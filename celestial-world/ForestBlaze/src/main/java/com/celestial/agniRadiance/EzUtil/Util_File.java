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
import java.math.BigInteger;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import com.celestial.agniRadiance.abstracte.RecursiveDealFile;

public class Util_File {
	/**
	 * �����ļ� <br/>
	 * ͨ���ܵ� <br/>
	 * �� f1 ������ f2
	 * @param f1
	 * @param f2
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("resource")
	public static long copyByTransfer(File f1,File f2) throws Exception{
//		System.out.println(f1.getAbsolutePath() + "  -->  \n     " + f2.getAbsolutePath());
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
            if((inC.size()-inC.position())<20971520)
                length=(int)(inC.size()-inC.position());
            else
                length=20971520;
            inC.transferTo(inC.position(),length,outC);
            inC.position(inC.position()+length);
        }
    }

	/**
	 * ��ȡmd5ֵ
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
	        throw new RuntimeException("��ȡ�ļ�MD5ֵʧ��.");
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
	 * �Ƚ������ļ� �������ǲ���һ����
	 * @param file
	 * @param s1File
	 * @return
	 */
	public static boolean compareFile(File f1, File f2) {
		boolean b = false;
		try {
			if(f1.getName().equals(f2.getName())){
				if(Util_File.getMd5ByFile(f1).equals(Util_File.getMd5ByFile(f2)))
					b=true;
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	} 
	/**
	 * ��ȡ�ļ�����ʱ��
	 * @param filePath
	 */
	public static void getCreateTime(String filePath) {
		String fileName = filePath.substring(filePath.lastIndexOf("\\")+1);
	    try {
	      Process p = Runtime.getRuntime().exec("cmd /C dir "+filePath+" /tc");
	      InputStream is = p.getInputStream();
	      BufferedReader br = new BufferedReader(new InputStreamReader(is));
	      String result;
	      String getTime = null;
	      while ((result = br.readLine()) != null) {
	        String[] str = result.split(" ");
	        for (int i = str.length - 1; i >= 0; i--) {
	          if (str[i].equals(fileName)) {
	            getTime = str[0] + " " + str[2];
	          }
	        }
	      }
	      System.out.println(fileName+ " �ļ��Ĵ��������ǣ�" + getTime);
	    } catch (java.io.IOException exc) {
	      exc.printStackTrace();
	    }
	  }

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param string
	 * @return
	 */
	public static boolean checkNotNullnotKong(String s) {
		return s != null && !"".equals(s);
	}




//	private static final List<String> cmdStringChangeList = new ArrayList<String>(Arrays.asList(new String[]{" ",""}));
	/**
	 * Windows����̨��Ҫ�滻����"���������ַ�.ע���滻ʱ����ƥ��.�����滻��+��ʱ���������������Ҫת��\\+.<br/>
	 */
	@SuppressWarnings("serial")
	private static final Map<String,String> cmdStringChangeMap = new HashMap<String, String>(){{
		put("=","\"=\"");
		put(" ","\" \"");
		put("\\+","\"+\"");
		put(",","\",\"");
	}};
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ���ļ�f1������Ŀ¼f2����.<br/>
	 * ��������ı��ļ�����ʱ��.<br/>
	 * </ul>
	 * @param f1
	 * @param f2
	 */
	/*public static void forCMD(File f1, File f2) {
		copyByCmd(f1,f2);
	}*/

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ���ļ�f1����Ŀ¼f2�� 
	 * </ul>
	 * @param f1
	 * @param f2
	 */
	public static void copyByCmd(File f1, File f2) {
		try {
            Runtime rt = Runtime.getRuntime();
            String s1 = formate(f1.getAbsolutePath().replaceAll("\\\\", "\\\\\\\\"));
            String s2 = formate(f2.getAbsolutePath().replaceAll("\\\\", "\\\\\\\\"));
            Process pr = rt.exec("cmd /c copy "+s1+" "+s2);
            BufferedReader input = new BufferedReader(new InputStreamReader(pr.getInputStream(), "GBK"));
            String line = null;
            while ((line = input.readLine()) != null) {
                System.out.println(line);
            }
            int exitVal = pr.waitFor();
            if(exitVal!=0){
            	throw new RuntimeException("�����ļ��봦���쳣.�ļ�·���Ƿ���ȷ,������Ӧ�ü������ŵ��ַ���DBUtil.cmdStringChangeMap�����.");
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
        }
	}

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ��java����ַ�����ʽΪWindows����̨Ҳ��ʶ�����ʽ.<br/>
	 * ���Ǽ���"" �走<br/>
	 * </ul>
	 * @param s
	 * @return
	 */
	private static String formate(String s) {
		Iterator<Map.Entry<String, String>> it = cmdStringChangeMap.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, String> entry = it.next();
			String st = entry.getKey();
			//û��ֱ�ӱ����滻.�����жϰ���ʲô�Ļ���ȥ��һ���ȽϺ�.
			s = s.replaceAll(st, cmdStringChangeMap.get(st));
//			}
		}
		return s;
	}

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * �Ƚ��ļ�f1��f2��MD5ֵ�Ƿ�һ��.
	 * </ul>
	 * @param f1 �ļ�
	 * @param f2 �ļ�2
	 * @return
	 */
	public static boolean compareMD5(File f1, File f2) {
		boolean b = false;
		try {
			b = Util_File.getMd5ByFile(f1).equals(Util_File.getMd5ByFile(f2));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return b;
	}
	private static List<String> fileList = null;
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ��path������Ŀ¼��(�ݹ��������)Ѱ��ƥ������ʽfileName���ļ�.<br/>
	 * ֱ��д�ļ�ȫ��Ҳ�ǿ��Ե�Ŷ<br/>
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
	 * <b>����˵����</b>
	 * <ul>
	 * �ݹ�Ѱ���ļ�.<br/>
	 * �Եݹ�ķ�ʽȥ�������ļ���ƥ���,
	 * </ul>
	 * @param fileName ��������ƥ��.
	 * @param path
	 */
	private static void findFileRecursive(String fileName, File path) {
		if(path.isFile()){
			if(Util_String.matchAllSameRegx(path.getName(), fileName)){
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
			throw new RuntimeException(path.getAbsolutePath() + "�����ļ�Ҳ�����ļ���!");
		}
	}
	/**
	 * 
	 */

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ��f1�������ļ�(��������������Ŀ¼�е�)������f2��
	 * </ul>
	 * @param f1 �ļ�Ŀ¼.
	 * @param f2 ������Ŀ��Ŀ¼.
	 */
	public static void getFileTogetherByModifyTime(File f1, File f2) {
		if(f1.isFile()){
			//���ļ��Ļ���f2������û��,û��ֱ�ӿ��еĻ��Ƚ����޸�ʱ��.�Ƚ����ٿ�~
			File[] fArr = f2.listFiles();
			boolean b = true;
			for(File f: fArr){
				if(f1.getName().equals(f.getName())){
					//�����ǰ�ļ�����f2�д��ڵ�ͬ���ļ���~�Ͳ��ÿ���
					
					if(!(f1.lastModified() > f.lastModified())){
						b = false;
					}
					SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
					System.out.println("f1: "+sm.format(new Date(f1.lastModified())) +"\nf2: "+sm.format(new Date(f.lastModified())) + "  Ҫ�� :" + b);
				}
			}
			if(b)
				Util_File.copyByCmd(f1, f2);
			else
				System.out.println("f1: -->  "+f1.getAbsolutePath());
		}
		else if(f1.isDirectory()){
			//���ļ��м�������
			File[] fArr = f1.listFiles();
			for(File f : fArr){
				getFileTogetherByModifyTime(f,f2);
			}
		}
		else{
			throw new RuntimeException("�����ļ�Ҳ�����ļ����쳣!����!");
		}
	}



	
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ���ı����ݶ���lineList��
	 * </ul>
	 * @param filePath �ļ�·��
	 * @param charset ����
	 * @return
	 */
	public static List<String> readFileLineToList(String filePath,String charset,boolean isTrim) {
		File f = new File(filePath);
		if(!(f.exists() && f.isFile()))
			throw new RuntimeException("ָ���ļ������ڻ����ļ�!");
		
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
			throw new RuntimeException("��ȡ�ļ�����ʧ��~");
		}
		finally{
			Util_File.close(br);
		}
		return l;
	}
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ���ı����ݶ���lineList��
	 * </ul>
	 * @param filePath �ļ�·��
	 * @return
	 */
	public static List<String> readFileLineToList(String filePath) {
		return readFileLineToList(filePath,null,true);
	}

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ���ı����ݶ���lineList��
	 * </ul>
	 * @param filePath �ļ�·��
	 * @return
	 */
	public static List<String> readFileLineToList(String filePath,boolean isTrim) {
		return readFileLineToList(filePath,null,isTrim);
	}
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ��ls�е�����д��path��ָ����ļ���
	 * </ul>
	 * @param ls
	 * @param string
	 * @throws FileNotFoundException 
	 */
	public static void printFile(List<String> ls, String path){
		printFile(ls,path,"utf-8");
	}
	
	/**
	 * �����ַ���send��Ĭ�ϸ�ʽutf-8��·����û�оʹ������о͸��ǡ�
	 * @param send
	 * @param path
	 */
	public static void printFile(String send, String path) {
		printFile(send,path,"utf-8");
	}
	
	/**
	 * �����ַ���send��·����û�оʹ������о͸��ǡ�
	 * @param send
	 * @param path
	 */
	public static void printFile(String send, String path,String charset) {
		printFile(Arrays.asList( new String[]{send}),path,charset);
	}
	
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ��ls�е�����д��path��ָ����ļ���
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
			throw new RuntimeException(new StringBuffer("�����ļ�ʧ��:").append(path).toString(),e);
		}
		
		
	}
	
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ����ָ��·������һ���ļ�,·���������򴴽�,�ļ��������򴴽�.<br/>
	 * �ļ���"/"��Ϊ�ָ���<br/>
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
			throw new RuntimeException("�ļ�����ʧ��!");
		}
		return file;
	}
	
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * �ر��ļ���
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
	 * <b>����˵����</b>
	 * <ul>
	 * ���filePathָ����ļ����ڲ�(�����ļ�,�ļ���)<br/>
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
	 * <b>����˵����</b>
	 * <ul>
	 * ��ȡ��ǰ·���µ��ļ� <br/>
	 * </ul>
	 * @param filePath Ŀ¼λ��
	 * @return
	 */
	@Deprecated
	public static File[] fileArr(String filePath) {
		/**
		 * ��ʹ��Util_File.fileAll������
		 */
		File f = null;
		File[] fArr = null;
		try {
			f = new File(filePath);
			if(f.exists() && f.isDirectory()){
				fArr = f.listFiles();
			}else{
				throw new RuntimeException("ָ��λ�ò����ڻ��߲���Ŀ¼.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("��ȡ�ļ�ʧ��");
		}
		return fArr;
	}
	
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ��ȡfilePath·����,ƥ������ʽregex��ȫ��Ŀ¼.
	 * <br/>
	 * ���ݹ�
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
						//��֤��ǰ�ļ��������ļ��������Ƿ�һ��,ͬΪ�ļ�����ͬΪ�ļ���.���Ϊnull,���ļ����ļ��ж�����.
						if(isFile == null){
						}else if(file.isFile() == isFile){
						}else{
							b = false;
						}
						//�ļ������ļ����Ƿ���������ַ���.
						if(!Util_String.matchAllSameRegx(name, regex))
							b = false;
						return b;
					}
				});
			}else{
				throw new RuntimeException("ָ��λ�ò����ڻ��߲���Ŀ¼." + filePath);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("��ȡ�ļ�ʧ��");
		}
		return fArr;
	}

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ��ȡfilePath·����,ƥ������ʽregex��ȫ���ļ�.
	 * <br/>
	 * ���ݹ�
	 * </ul>
	 * @param filePath
	 * @param regex
	 * @return
	 */
	public static File[] fileDocument(String filePath, String regex) {
		return fileIntegrated(filePath,regex,true);
	}

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ��ȡfilePath·����,ƥ������ʽregex��ȫ��Ŀ¼���ļ�.
	 * </ul>
	 * @param filePath
	 * @param regex
	 * @return
	 */
	public static File[] fileAll(String filePath, String regex) {
		return fileIntegrated(filePath,regex,null);
	}

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ��ȡfilePath·���µ�ȫ��Ŀ¼���ļ�.
	 * </ul>
	 * @param filePath
	 * @return
	 */
	public static File[] fileAll(String filePath) {
		return fileIntegrated(filePath,".*",null);
	}

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * �ݹ��ҵ��µ������ļ�<br/>
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
			throw new RuntimeException("���ļ���Ŀ¼�쳣!�ݹ�����ļ�ʧ��!");
		}
	}

	private static List<File> findAllFile = null;
	
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * �ݹ����Ŀ¼pathFile�����file�ļ�.
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
			boolean isSameFile = Util_File.getMd5ByFile(originalFile).equals(Util_File.getMd5ByFile(path)) && originalFile.getName().equals(path.getName());
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
			throw new RuntimeException(path.getAbsolutePath() + "�����ļ�Ҳ�����ļ���!");
		}
	}

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ��ȡpath��ָ����properties�ļ�������м�ֵ��,��HashMap��ʽ����.<br/>
	 * </ul>
	 * @param path
	 * @return
	 */
	@SuppressWarnings({ "rawtypes" })
	public static Map readProperties(String path) {
		return readProperties(new File(path));
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Map readProperties(File propertiesFile) {
		Properties ps = new Properties();
		Map m = new LinkedHashMap<String, String>();
		try {
			ps.load(new FileInputStream(propertiesFile));
			for(Entry<Object, Object> ei :ps.entrySet()){
				m.put(ei.getKey(), ei.getValue());
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("��ȡproperties�ļ�ʧ��:" + propertiesFile.getAbsolutePath());
		}
		return m;
	}

	/**
	 * �ݹ�ɾ���ļ���
	 * @param file
	 */
	public static void deleteFile(File file) {
		if(file.exists()){
			RecursiveDealFile rd = new RecursiveDealFile(file) {
				@Override
				public void doWork(File file) {
					file.delete();
//					System.out.println("ɾ��"+file.getAbsolutePath());
				}
				public void doDirectoryWork(File directory){
					directory.delete();
//					System.out.println("ɾ��"+directory.getAbsolutePath());
				}
			};
		rd.start();
		}
			
			
	}

}
