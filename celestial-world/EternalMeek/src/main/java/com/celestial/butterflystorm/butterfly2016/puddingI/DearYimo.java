package com.celestial.butterflystorm.butterfly2016.puddingI;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.util.Date;

public class DearYimo {

	/**
	 * 
	 * java文件都在src下面 吗固定下不..
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		
		String source=new String("C:/Users/Administrator/Desktop/temp/te1");
		String project=new String("D:/workspace/SelfOpenAccount");
		
		createDinner(source,project);
	}
	/**
	 * 创建补丁
	 * @param source 存放了生成补丁文件的目录
	 * @param project 项目目录
	 * @throws FileNotFoundException 
	 */
	private static void createDinner(String source0, String project0) throws Exception {
		//1.先搞定java文件
		File source=new File(source0);
		File project=new File(project0);
		
		//遍历source下的所有文件文件夹
		if(checkFile(source) && checkFile(project)){
			String f1Head=source0+project0.substring(project0.lastIndexOf("/"));
			hook(source,project,f1Head);//f1Head 当前source路径加上项目名
		}

	}



	/**
	 * 遍历要做补丁的文件
	 * 把f2中的 拷到f1中...
	 * @param f1 要打补丁文件所在目录
	 * @param f2 项目所在目录
	 * @param f1Head 
	 * @throws FileNotFoundException
	 */
	private static void hook(File f1, File f2, String f1Head) throws Exception {
		if(f1.isDirectory()){
			File[] fArr=f1.listFiles();
			for(File i: fArr){
				hook(i,f2, f1Head);
			}
		}
		else if(f1.isFile()){
			//是文件的话就强暴f2
			//获取路劲尾数
			String f1Name=f1.getName();
			//是java文件吗
			if(f1Name.endsWith(".java")){
				String head=(f2.getAbsolutePath()+"\\src").replaceAll("\\\\", "/");
				String f2Head=f2.getAbsolutePath()+"/WebRoot/WEB-INF/classes";//项目的路径头
				compare(f1,new File(head),head);
				
				String sad=f1Head+"/WEB-INF/classes"+tail;
				new File(sad.substring(0, sad.lastIndexOf("/"))).mkdirs();
				File file=new File(sad);
				file.createNewFile();
				forTransfer(new File(f2Head+"/"+tail),file);
				copyAnonymous(f2Head+"/"+tail,sad);
				tail=null;
				return;
			}else{
				String head2=(f2.getAbsolutePath()+"/WebRoot").replaceAll("\\\\", "/");
				compare2(f1,new File(head2),f1Head,head2);
			}
			
		}
		else{
			throw new RuntimeException("不是文件或者文件夹的 什么鬼?");
		}
		
	}

	/**
	 * 拷贝匿名内部类
	 * @param fs1 要拷的文件(含目录)
	 * @param fs2 拷贝到的文件(含目录)
	 * @throws Exception 
	 */
	private static void copyAnonymous(String fs1, String fs2) throws Exception {
		String fileName = fs1.substring(fs1.lastIndexOf("/")+1, fs1.length());
		String nameHeaad = fileName.split("\\.")[0]+"$";
		String nameTail = fileName.split("\\.")[1];
		File f1 = new File(fs1.substring(0, fs1.lastIndexOf("/")));
		String fs21 = fs2.substring(0, fs2.lastIndexOf("/"));
		File[] fileArr=f1.listFiles();
		for(File i:fileArr){
			String iName=i.getName();
			if(iName.contains(nameHeaad) && iName.endsWith(nameTail)){
				if(i.exists()){
					forTransfer(i,new File(fs21+"/"+iName));
				}
			}
		}
		
		
	}
	/**
	 * 不是java文件 直接拷
	 * 去f2中找和f1同名同md5值的文件 拷到f1所在目录对应位置
	 * f2-->f1
	 * @param f1
	 * @param f2
	 * @param head2
	 * @param head2 
	 * @throws Exception 
	 */
	private static void compare2(File f1, File f2, String f1Head, String head2) throws Exception {
		if(!checkFile(f2)){
			return;
		}
		File[] fArr=f2.listFiles();
		for(File i: fArr){
			if(i.isDirectory()){
				compare2(f1,i,f1Head,head2);
			}
			if(i.isFile()){
				if(f1.getName().equals(i.getName())){
					if(getMd5ByFile(f1).equals(getMd5ByFile(i))){
						String tail2=i.getAbsolutePath().replaceAll("\\\\", "/").split(head2)[1];
						File file=new File(f1Head+tail2);
						File path= file.getParentFile();
						System.out.println(path.mkdirs());
						file.createNewFile();
						
						forTransfer(i,file);
					}
				}
				
			}
		}
		
	}

	static String tail=null;
	/**
	 * 从文件夹f2中找出 与f1 相同的文件的路径后缀
	 * @param f1
	 * @param f2
	 * @param head
	 * @return
	 * @throws FileNotFoundException
	 */
	private static void compare(File f1, File f2, String head) throws FileNotFoundException {
		if(null != tail)
			return;
		if(f2.isDirectory()){
			File[] fArr=f2.listFiles();
			for(File i: fArr){
				compare(f1,i,head);
			}
		}
		else if(f2.isFile()){
			//是文件的话就和f1对比
			//获取路劲尾数   
			//文件md5值一样 是同一个文件
			String name2=f2.getName();
			System.out.println(name2);
			if(f1.getName().equals(f2.getName())){
				System.out.println(f1.getAbsolutePath());
				System.out.println(f2.getAbsolutePath());
				if(getMd5ByFile(f1).equals(getMd5ByFile(f2))){
					String f2Name=f2.getAbsolutePath().replaceAll("\\\\", "/").split(head)[1];
					tail=f2Name.substring(0, f2Name.lastIndexOf("."))+".class";
					return;
				}
			}
		}
		
	}
	
	
	
	
	/**
	 * 获取md5值
	 * @param file
	 * @return
	 * @throws FileNotFoundException
	 */
	public static String getMd5ByFile(File file) throws FileNotFoundException {  
        String value = null;  
        FileInputStream in = new FileInputStream(file);  
    try {  
        MappedByteBuffer byteBuffer = in.getChannel().map(FileChannel.MapMode.READ_ONLY, 0, file.length());  
        MessageDigest md5 = MessageDigest.getInstance("MD5");  
        md5.update(byteBuffer);  
        BigInteger bi = new BigInteger(1, md5.digest());  
        value = bi.toString(16);  
    } catch (Exception e) {  
        e.printStackTrace();  
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
	 * 文件是不是为空 或者存在不 或者不是目录
	 * @param source
	 * @return
	 */
	private static boolean checkFile(File f) {
		return f!=null && f.exists() && f.isDirectory();
	}
	
	
	/**
	 * 拷贝文件 
	 * 通过管道
	 * @param f1
	 * @param f2
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("resource")
	public static long forTransfer(File f1,File f2) throws Exception{
        long time=new Date().getTime();
        int length=2097152;
		FileInputStream in=new FileInputStream(f1);
        FileOutputStream out=new FileOutputStream(f2);
        FileChannel inC=in.getChannel();
        FileChannel outC=out.getChannel();
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

}
