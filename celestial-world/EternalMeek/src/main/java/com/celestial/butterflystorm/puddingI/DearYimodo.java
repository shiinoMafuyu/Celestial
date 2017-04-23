package com.celestial.butterflystorm.puddingI;

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

public class DearYimodo {

	/**
	 * 
	 * java�ļ�����src���� ��̶��²�..
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		
		String source=new String("C:/Users/Administrator/Desktop/temp/te1");
		String project=new String("D:/workspace/SelfOpenAccount");
		
		createDinner(source,project);
	}
	/**
	 * ��������
	 * @param source ��������ɲ����ļ���Ŀ¼
	 * @param project ��ĿĿ¼
	 * @throws FileNotFoundException 
	 */
	private static void createDinner(String source0, String project0) throws Exception {
		//1.�ȸ㶨java�ļ�
		File source=new File(source0);
		File project=new File(project0);
		
		//����source�µ������ļ��ļ���
		if(checkFile(source) && checkFile(project)){
			String f1Head=source0+project0.substring(project0.lastIndexOf("/"));
			hook(source,project,f1Head);//f1Head ��ǰsource·��������Ŀ��
		}

	}



	/**
	 * ����Ҫ���������ļ�
	 * ��f2�е� ����f1��...
	 * @param f1 Ҫ�򲹶��ļ�����Ŀ¼
	 * @param f2 ��Ŀ����Ŀ¼
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
			//���ļ��Ļ���ǿ��f2
			//��ȡ·��β��
			String f1Name=f1.getName();
			//��java�ļ���
			if(f1Name.endsWith(".java")){
				String head=(f2.getAbsolutePath()+"\\src").replaceAll("\\\\", "/");
				String f2Head=f2.getAbsolutePath()+"/WebRoot/WEB-INF/classes";//��Ŀ��·��ͷ
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
			throw new RuntimeException("�����ļ������ļ��е� ʲô��?");
		}
		
	}

	/**
	 * ���������ڲ���
	 * @param fs1 Ҫ�����ļ�(��Ŀ¼)
	 * @param fs2 ���������ļ�(��Ŀ¼)
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
	 * ����java�ļ� ֱ�ӿ�
	 * ȥf2���Һ�f1ͬ��ͬmd5ֵ���ļ� ����f1����Ŀ¼��Ӧλ��
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
	 * ���ļ���f2���ҳ� ��f1 ��ͬ���ļ���·����׺
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
			//���ļ��Ļ��ͺ�f1�Ա�
			//��ȡ·��β��   
			//�ļ�md5ֵһ�� ��ͬһ���ļ�
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
	 * ��ȡmd5ֵ
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
	 * �ļ��ǲ���Ϊ�� ���ߴ��ڲ� ���߲���Ŀ¼
	 * @param source
	 * @return
	 */
	private static boolean checkFile(File f) {
		return f!=null && f.exists() && f.isDirectory();
	}
	
	
	/**
	 * �����ļ� 
	 * ͨ���ܵ�
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
