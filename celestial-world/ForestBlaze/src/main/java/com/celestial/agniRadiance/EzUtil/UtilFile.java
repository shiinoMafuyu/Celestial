package com.celestial.agniRadiance.EzUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLDecoder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import javax.swing.filechooser.FileSystemView;

import com.celestial.agniRadiance.abstracte.RecursiveDealFile;
import com.celestial.agniRadiance.entity.FileReader;

public class UtilFile {
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 通过管道拷贝文件f1到f2<br/>
	 * 目录存在则创建<br/>
	 * </ul>
	 * @param f1
	 * @param f2
	 * @throws Exception
	 */
	public static void copyByTransferDRS(File f1,File f2) throws Exception{
		createFile(f2.getParentFile());
		copyByTransfer(f1,f2);
	}
	
	/**
	 * 拷贝文件 <br/>
	 * 通过管道 <br/>
	 * 把 f1 拷贝到 f2
	 * @param f1
	 * @param f2
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("resource")
	public static long copyByTransfer(File f1,File f2) throws Exception{
		long time=new Date().getTime();
		int length=2097152;
		FileChannel inC=new FileInputStream(f1).getChannel();
		FileChannel outC=new FileOutputStream(f2).getChannel();
		while(true){
			if(inC.position()==inC.size()){
			    inC.close();
			    outC.close();
			    return new Date().getTime()-time;
			}
			if((inC.size()-inC.position())<2097152)
			    length=(int)(inC.size()-inC.position());
			else
			    length=2097152;
			inC.transferTo(inC.position(),length,outC);
			inC.position(inC.position()+length);
		}
    }

	/**
	 * 获取md5值
	 * @param file
	 * @return
	 * @throws FileNotFoundException
	 */
	public static String getMd5ByFile(File file){
		String value = null;
		FileInputStream in = null;
		try {
	    	in = new FileInputStream(file);
			MappedByteBuffer byteBuffer = in.getChannel().map(FileChannel.MapMode.READ_ONLY, 0, file.length());
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.update(byteBuffer);
			BigInteger bi = new BigInteger(1, md5.digest());
			value = bi.toString(16);
	    } catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("获取文件MD5值失败.");
	    } finally {
			if(null != in) {
				try {
				in.close();
				} catch (IOException e) {
				    e.printStackTrace();
				}
			}
	    }
	    return value;
    }
	/**
	 * 比较两个文件 看他们是不是一样的
	 * @param file
	 * @param s1File
	 * @return
	 */
	public static boolean compareFile(File f1, File f2) {
		boolean b = false;
		try {
			if(f1.getName().equals(f2.getName())){
				if(UtilFile.getMd5ByFile(f1).equals(UtilFile.getMd5ByFile(f2)))
					b=true;
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	} 
	

//	private static final List<String> cmdStringChangeList = new ArrayList<String>(Arrays.asList(new String[]{" ",""}));
	/**
	 * Windows控制台需要替换加上"括起来的字符.注意替换时正则匹配.比如替换掉+号时由于是正则符所以要转意\\+.<br/>
	 */
	@SuppressWarnings("serial")
	private static final Map<String,String> cmdStringChangeMap = new HashMap<String, String>(){{
		put("=","\"=\"");
		put(" ","\" \"");
		put("\\+","\"+\"");
		put(",","\",\"");
	}};
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 把文件f1拷贝到目录f2下面.<br/>
	 * 这样不会改变文件生成时间.<br/>
	 * </ul>
	 * @param f1
	 * @param f2
	 */
	/*public static void forCMD(File f1, File f2) {
		copyByCmd(f1,f2);
	}*/

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 把文件f1拷到目录f2下 <br/>
	 * 使用控制台方式<br/>
	 * </ul>
	 * @param f1
	 * @param f2
	 */
	public static void copyByCmd(File f1, File f2) {
		try {
			String s1 = formateCmdPath(f1.getAbsolutePath());
			String s2 = formateCmdPath(f2.getAbsolutePath());
			
			Runtime rt = Runtime.getRuntime();
			String cmd = "cmd /c copy " + s1 + " " + s2;
			Process pr = rt.exec(cmd);
			BufferedReader input = new BufferedReader(new InputStreamReader(pr.getInputStream(), "GBK"));
			String line = null;
			while ((line = input.readLine()) != null) {
			    System.out.println(line);
			}
			int exitVal = pr.waitFor();
			if(exitVal!=0){
				throw new RuntimeException("拷贝文件请处理异常.文件路径是否正确,或者是应该加上引号的字符在DBUtil.cmdStringChangeMap中添加.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 把文件f1拷到目录f2下 ,如果f2所在目录不存在则创建。<br/>
	 * 使用控制台方式<br/>
	 * </ul>
	 * @param f1
	 * @param f2
	 */
	public static void copyByCmdDRS(File f1, File f2) {
		createFile(f2.getParentFile());
		copyByCmd(f1,f2);
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 如果不存在则创建文件<br/>
	 * </ul>
	 * @param parentFile 
	 */
	public static void createFile(File file) {
		if(!file.exists())
			file.mkdirs();
	}

	/**
	 * 获取文件创建时间(精确到分钟)。<br/>
	 * 通过控制台方式。<br/>
	 * @param filePath
	 */
	public static Date getCreateTime(String filePath){
		filePath = formateCmdPath(filePath);
		try {
			String cmd = String.format("cmd /C dir %s /tc", filePath);
			Process p = Runtime.getRuntime().exec(cmd);
			InputStream is = p.getInputStream(); 
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String line;
			while((line = br.readLine()) != null){
				if(UtilString.matchAllSameRegx(line, "\\d{4}/\\d{2}/\\d{2}\\s{2}\\d{2}:\\d{2}.*")){
					break;
				}
			 }
			return new SimpleDateFormat("yyyy/MM/dd  hh:mm").parse(line);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 将java里的字符串格式为Windows控制台也能识别的形式.<br/>
	 * 就是加上"" 妈蛋<br/>
	 * </ul>
	 * @param s
	 * @return
	 */
	private static String formateCmdPath(String s) {
		Iterator<Map.Entry<String, String>> it = cmdStringChangeMap.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, String> entry = it.next();
			String st = entry.getKey();
			//没错直接遍历替换.正则判断包含什么的还是去死一死比较好.
			s = s.replaceAll(st, cmdStringChangeMap.get(st));
//			}
		}
		return s;
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 比较文件f1和f2的MD5值是否一样.
	 * </ul>
	 * @param f1 文件
	 * @param f2 文件2
	 * @return
	 */
	public static boolean compareMD5(File f1, File f2) {
		boolean b = false;
		try {
			b = UtilFile.getMd5ByFile(f1).equals(UtilFile.getMd5ByFile(f2));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return b;
	}
	private static List<String> fileList = null;
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 从path下所有目录中(递归查找所有)寻找匹配正则式fileName的文件.<br/>
	 * 直接写文件全名也是可以的哦<br/>
	 * </ul>
	 * @param fileName(regex)
	 * @param path
	 * @return
	 */
	public static List<String> findFile(String fileName,File path){
		fileList= new ArrayList<String>();
		findFileRecursive(fileName,path);
		return fileList;
	}
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 递归寻找文件.<br/>
	 * 以递归的方式去找所有文件名匹配的,
	 * </ul>
	 * @param fileName 可用正则匹配.
	 * @param path
	 */
	private static void findFileRecursive(String fileName, File path) {
		if(path.isFile()){
			if(UtilString.matchAllSameRegx(path.getName(), fileName)){
				fileList.add(path.getAbsolutePath());
			}
		}
		else if(path.isDirectory()){
			File[] fArr = path.listFiles();
			for(File f : fArr){
				findFileRecursive(fileName,f);
			}
		}
		else{
			throw new RuntimeException(path.getAbsolutePath() + "不是文件也不是文件夹!");
		}
	}
	/**
	 * 
	 */

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 把f1中所有文件(包括下面所有子目录中的)拷贝到f2中
	 * </ul>
	 * @param f1 文件目录.
	 * @param f2 拷到的目标目录.
	 */
	public static void getFileTogetherByModifyTime(File f1, File f2) {
		if(f1.isFile()){
			//是文件的话看f2里面有没有,没有直接拷有的话比较其修改时间.比较新再拷~
			File[] fArr = f2.listFiles();
			boolean b = true;
			for(File f: fArr){
				if(f1.getName().equals(f.getName())){
					//如果当前文件不比f2中存在的同名文件晚~就不用拷了
					
					if(!(f1.lastModified() > f.lastModified())){
						b = false;
					}
					SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
					System.out.println("f1: "+sm.format(new Date(f1.lastModified())) +"\nf2: "+sm.format(new Date(f.lastModified())) + "  要拷 :" + b);
				}
			}
			if(b)
				UtilFile.copyByCmd(f1, f2);
			else
				System.out.println("f1: -->  "+f1.getAbsolutePath());
		}
		else if(f1.isDirectory()){
			//是文件夹继续遍历
			File[] fArr = f1.listFiles();
			for(File f : fArr){
				getFileTogetherByModifyTime(f,f2);
			}
		}
		else{
			throw new RuntimeException("不是文件也不是文件夹异常!请检查!");
		}
	}



	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 将文本内容读入lineList中
	 * </ul>
	 * @param filePath 文件路径
	 * @param charset 编码
	 * @return
	 */
	public static List<String> readFileLineToList(String filePath,String charset,boolean isTrim) {
		File f = new File(filePath);
		if(!(f.exists() && f.isFile()))
			throw new RuntimeException("指定文件不存在或不是文件!");
		
		List<String> l = new ArrayList<String>();
		
		BufferedReader br = null;
		try {
			if(charset !=null){
				br = new BufferedReader(new InputStreamReader(new FileInputStream(f),charset));
			}else{
				br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
			}
			String s = null;
			while((s=br.readLine()) != null ){
				if(isTrim){
					l.add(s.trim());
				}else{
					l.add(s);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("读取文件内容失败~");
		}
		finally{
			UtilFile.close(br);
		}
		return l;
	}
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 将文本内容读入lineList中
	 * </ul>
	 * @param filePath 文件路径
	 * @return
	 */
	public static List<String> readFileLineToList(String filePath) {
		return readFileLineToList(filePath,null,true);
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 将文本内容读入lineList中
	 * </ul>
	 * @param filePath 文件路径
	 * @return
	 */
	public static List<String> readFileLineToList(String filePath,boolean isTrim) {
		return readFileLineToList(filePath,null,isTrim);
	}
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 把ls中的内容写到path所指向的文件中
	 * </ul>
	 * @param ls
	 * @param string
	 * @throws FileNotFoundException 
	 */
	public static void printFile(List<String> ls, String path){
		printFile(ls,path,"utf-8");
	}
	
	/**
	 * 保存字符串send，默认格式utf-8，路径上没有就创建。有就覆盖。
	 * @param send
	 * @param path
	 */
	public static void printFile(String send, String path) {
		printFile(send,path,"utf-8");
	}
	
	/**
	 * 保存字符串send，路径上没有就创建。有就覆盖。
	 * @param send
	 * @param path
	 */
	public static void printFile(String send, String path,String charset) {
		printFile(Arrays.asList( new String[]{send}),path,charset);
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 把ls中的内容写到path所指向的文件中
	 * </ul>
	 * @param ls
	 * @param string
	 * @param charset
	 * @throws FileNotFoundException 
	 */
	public static void printFile(List<String> ls, String path,String charset){
		try{
			File f = createAFile(path);
			PrintWriter pw = null;
			pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(f),charset));
			for(String i:ls){
				pw.println(i);
			}
			pw.flush();
			pw.close();
		}catch(Exception e){
			throw new RuntimeException(new StringBuffer("保存文件失败:").append(path).toString(),e);
		}
		
		
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 根据指定路径创建一个文件,路径不存在则创建,文件不存在则创建.<br/>
	 * 文件以"/"做为分隔符<br/>
	 * </ul>
	 * @param path
	 * @return
	 */
	public static File createAFile(String path) {
		File file = null;
		try {
			File fp = new File(path.substring(0, path.lastIndexOf("/")));
			if(!fp.exists()){
				fp.mkdirs();
			}
			file = new File(path);
			if(!file.exists()){
				file.createNewFile();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("文件创建失败!");
		}
		return file;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 关闭文件流
	 * </ul>
	 * @param br
	 */
	public static void close(BufferedReader br) {
		try {
			if(br != null)
				br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 检查filePath指向的文件存在不(包括文件,文件夹)<br/>
	 * </ul>
	 * @param filePath
	 * @return
	 */
	public static boolean checkFileExist(String filePath) {
		boolean b = false;
		try {
			File f = new File(filePath);
			b = f.exists();
		} catch (Exception e) {
		}
		return b;
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取filePath路径下,匹配正则式regex的全部目录.
	 * <br/>
	 * 不递归
	 * </ul>
	 * @param filePath
	 * @param regex
	 * @return
	 */
	public static File[] fileDirectory(String filePath, String regex) {
		return fileIntegrated(filePath,regex,false);
	}

	private static File[] fileIntegrated(String filePath,final String regex,
			final Boolean isFile) {
		File[] fArr = null;
		File f = new File(filePath);
		try {
			f = new File(filePath);
			if(f.exists() && f.isDirectory()){
				fArr = f.listFiles(new FilenameFilter() {
					public boolean accept(File dir, String name) {
						File file = new File(dir.getAbsolutePath()+"/"+name);
						boolean b = true;
						//验证当前文件和所需文件的类型是否一样,同为文件或者同为文件夹.如果为null,则文件或文件夹都可以.
						if(isFile == null){
						}else if(file.isFile() == isFile){
						}else{
							b = false;
						}
						//文件或者文件夹是否包含给定字符串.
						if(!UtilString.matchAllSameRegx(name, regex))
							b = false;
						return b;
					}
				});
			}else{
				throw new RuntimeException("指定位置不存在或者不是目录." + filePath);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("获取文件失败");
		}
		return fArr;
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取filePath路径下,匹配正则式regex的全部文件.
	 * <br/>
	 * 不递归
	 * </ul>
	 * @param filePath
	 * @param regex
	 * @return
	 */
	public static File[] fileDocument(String filePath, String regex) {
		return fileIntegrated(filePath,regex,true);
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取filePath路径下,匹配正则式regex的全部目录和文件.
	 * </ul>
	 * @param filePath
	 * @param regex
	 * @return
	 */
	public static File[] fileAll(String filePath, String regex) {
		return fileIntegrated(filePath,regex,null);
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取filePath路径下的全部目录和文件.
	 * </ul>
	 * @param filePath
	 * @return
	 */
	public static File[] fileAll(String filePath) {
		return fileIntegrated(filePath,".*",null);
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 递归找到下的所有文件<br/>
	 * </ul>
	 * @param filePath
	 * @return
	 */
	public static List<File> findAllFile(String filePath) {
		findAllFile = new ArrayList<File>();
		findAllFileRecursive(new File(filePath));
		return findAllFile;
	}
	private static void findAllFileRecursive(File file) {
		if(file.isFile()){
			findAllFile.add(file);
		}else if(file.isDirectory()){
			File[] fArr = file.listFiles();
			for(File i : fArr){
				findAllFileRecursive(i);
			}
		}else{
			throw new RuntimeException("非文件非目录异常!递归查找文件失败!");
		}
	}

	private static List<File> findAllFile = null;
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 递归查找目录pathFile下面的file文件.
	 * </ul>
	 * @param file
	 * @param pathFile
	 * @return
	 */
	public static List<String> findFile(File file, File pathFile) {
		fileList = new ArrayList<String>();
		findFileRecursive(file,pathFile);
		return fileList;
	}

	private static void findFileRecursive(File originalFile, File path) {
		if(path.isFile()){
			boolean isSameFile = UtilFile.getMd5ByFile(originalFile).equals(UtilFile.getMd5ByFile(path)) && originalFile.getName().equals(path.getName());
			if(isSameFile){
				fileList.add(path.getAbsolutePath().replaceAll("\\\\", "/"));
			}
		}
		else if(path.isDirectory()){
			File[] fArr = path.listFiles();
			for(File f : fArr){
				findFileRecursive(originalFile,f);
			}
		}
		else{
			throw new RuntimeException(path.getAbsolutePath() + "不是文件也不是文件夹!");
		}
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取path所指定的properties文件里的所有键值对,以HashMap形式返回.<br/>
	 * </ul>
	 * @param path
	 * @return
	 */
	public static Map<String,String> readProperties(String path) {
		return readProperties(path,null);
	}
	
	/**
	 * 将path路径指定文件，以指定格式charset读取
	 * @param path 文件路径
	 * @param charset 编码
	 * @return
	 */
	public static Map<String,String> readProperties(String path,String charset){
		return readProperties(new File(path),charset); 
	}
	
	/**
	 * 读取Properties文件到map里
	 * @param file
	 * @return
	 */
	public static Map<String,String> readProperties(File file) {
		return readProperties(file,null);
	}
	
	/**
	 * 将file以指定格式charset读取
	 * @param file
	 * @param charset
	 * @return
	 */
	public static Map<String,String> readProperties(File file,String charset){
		Properties ps = new Properties();
		Map<String,String> m = new LinkedHashMap<String, String>();
		try {
			if(charset == null)
				ps.load(new FileInputStream(file));
			else
				ps.load(new InputStreamReader(new FileInputStream(file),charset));
			for(Entry<Object, Object> ei :ps.entrySet()){
				m.put((String)ei.getKey(), (String)ei.getValue());
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("读取properties文件失败:" + file.getAbsolutePath());
		}
		return m;
	}
	
	
	/**
	 * 递归删除文件。
	 * @param file
	 */
	public static void deleteFile(File file) {
		if(file.exists()){
			RecursiveDealFile rd = new RecursiveDealFile(file) {
				@Override
				public void doWork(File file) {
					file.delete();
//					System.out.println("删除"+file.getAbsolutePath());
				}
				public void doDirectoryWork(File directory){
					directory.delete();
//					System.out.println("删除"+directory.getAbsolutePath());
				}
			};
		rd.start();
		}
			
			
	}
	
	/**
	 * 更新文件。<br/>
	 * 如果srcFile比targetFile，或者targetFile不存在则复制srcFile到targetFile.<br/>
	 * @param srcFile
	 * @param targetFile
	 */
	public static void compareAndRenew(File srcFile, File targetFile) {
		if(!targetFile.exists() || !compareModifiedTime(srcFile,targetFile)){
			UtilFile.copyByCmdDRS(srcFile, targetFile);
		}
	}
	
	/** 
	 * 读取文件修改时间的方法1
	 * @param file
	 */ 
	public static Date getModifiedTime(File file){
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(file.lastModified());
		return cal.getTime();
	}

	/**
	 * 比较f1Path和f2Path是否一致。
	 * @param f1Path 
	 * @param f2Path 
	 * @return
	 */
	public static boolean compareFileContent(String f1Path, String f2Path) {
		return compareFileContent(new File(f1Path),new File(f1Path));
	}
	
	/**
	 * 比较f1和f2是否一致。
	 * @param f1 
	 * @param f2 
	 * @return
	 */
	public static boolean compareFileContent(File f1, File f2) {
		FileReader pf = new FileReader(f1);
		FileReader ff = new FileReader(f2);
		if(ff.getLineList().size() != pf.getLineList().size())
			return false;
		while(ff.hasNext()){
			if(!ff.readLine().equals(pf.readLine()))
				return false;
		}
		return true;
	}

	/**
	 * 比较创建时间f2是否比f1新。
	 * @param f1
	 * @param f2
	 * @return
	 */
	public static boolean compareModifiedTime(File f1, File f2) {
		return UtilFile.getModifiedTime(f2).after(UtilFile.getModifiedTime(f1));
	}

	/**
	 * 获取文件file的不重名新名<br/>
	 * @param file
	 */
	public static File getUnRepeatName(File file) {
		String name = file.getName();
		Integer n = 1;
		if(file.exists()){
			if(UtilString.matchAllRegx(name, "\\d+-.*")){
				n = Integer.valueOf(name.split("-")[0]);
				n++;
				name = n + name.substring(name.indexOf("-"));
			}else{
				name = n + "-" + name;
			}
			return getUnRepeatName(new File(file.getParentFile().getAbsolutePath()+"/"+name));
		}else{
			return file;
		}
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取绝对路径。
	 * </ul>
	 * @param path
	 * @return 
	 */
	public static String getAbsolutePath(String path) {
		return getAbsolutePath(new File(path));
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取绝对路径。
	 * </ul>
	 * @param file
	 * @return 
	 */
	public static String getAbsolutePath(File file) {
		return UtilString.fmtPathStr(file.getAbsolutePath());
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 判断path是不是存在的目录.<br/>
	 * </ul>
	 * @param path
	 * @return 
	 */
	public static boolean isPath(String path) {
		try{
			File f = new File(path);
			if(f.exists() && f.isDirectory())
				return true;
		}catch (Exception e) {
		}
		return false;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取桌面路径<br/>
	 * </ul>
	 * @return
	 */
	public static String getDesktopPath(){
		FileSystemView fsv = FileSystemView.getFileSystemView();
		File home = fsv.getHomeDirectory(); 
		return UtilString.fmtPathStr(home.getAbsolutePath());
	}

	/**
	 * 根据文件名获得sourcepath下文件路劲
	 * @param fileName
	 * @return
	 */
	public static String load(String fileName) {
		try {
			
			return URLDecoder.decode(UtilFile.class.getResource("/"+fileName).getPath(),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 根据文件名获得sourcepath下文件路径
	 * @param fileName 
	 * @param obj 配置文件同源类对象
	 * @return
	 */
	public static String load(String fileName,Object obj) {
		return obj.getClass().getResource("/"+fileName).getPath();
	}
	
	

	/**
	 * 如果为null则返回数组长度为0的。
	 * @param file
	 * @return
	 */
	public static File[] listFile(File file) {
		File[] fArr = file.listFiles();
		if(null == fArr)
			fArr = new File[]{};
		return fArr;
	}

	/**
	 * 获取当前目录下的所有文件
	 * @param directory
	 * @return
	 */
	public static File[] listDocument(File directory) {
		List<File> list = new ArrayList<>();
		File[] fArr = directory.listFiles();
		for(File fi: fArr){
			if(fi.isFile())
				list.add(fi);
		}
		return list.toArray(new File[]{});
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 判断文件是否是对应中的一种
	 * </ul>
	 * @param file
	 * @param types
	 * @return 
	 */
	public static boolean isIntype(File file, String[] types) {
		String name = file.getName();
		if(name == null || "".equals(name))
			return false;
		for(String type : types){
			if(name.endsWith("."+type))
				return true;
		}
		return false;
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 加载configfiles资源。<br/>
	 * </ul>
	 * @param fileName
	 * @return
	 */
	public static File loadConfigSource(String fileName) {
		return new File(UtilFile.class.getResource("/"+fileName).getFile());
	}
	
	

}
