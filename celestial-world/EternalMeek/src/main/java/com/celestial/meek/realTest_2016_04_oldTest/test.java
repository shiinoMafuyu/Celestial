package com.celestial.meek.realTest_2016_04_oldTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.channels.FileChannel;
import java.text.SimpleDateFormat;
import java.util.Date;

@SuppressWarnings("unused")
public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		//测试管道传输文件 看起来只能拷贝文件
		//teCopyByTransfer();
		//测试文件copy
		//teFileCreate();
		//测试文件listFile()方法
		//teFileList();
		//测试递归检验
		//teCheck();
		
		File podding=new File("E:/te/test/pod");
		File project=new File("E:/te/test/A");
		boolean  b1=checkFile(podding);
		boolean b2=checkFile(project);
		if(!(b1&&b2)){
			System.out.println("文件目录有问题 程序结束~");
			return;
		}
		
		String recordIndexPath=createRecordIndex(podding);
		recursiveTraverseMoveAndCopy(podding,project,recordIndexPath,project.getPath().lastIndexOf("\\"));
		
	}
	/**
	 * 创建备份目录
	 * 补丁同一级目录下建立补丁备份目录---日期-02---所有项目的备份 
	 * @param podding
	 * @return
	 */
	private static String createRecordIndex(File podding) {
		String p=podding.getPath();
		String parentPath= p.substring(0, p.lastIndexOf(podding.getName()))+"/history/";
		
		String sd=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		File f=new File(parentPath);
		f.mkdirs();
		File[] fArr=f.listFiles();
		int index=1;
		for(int i=0;i<fArr.length;i++){
			if(fArr[i].getName().contains(sd)){
				index++;
			}
		}
		File recordIndexFile=new File(parentPath+sd+"-history--"+index);
		recordIndexFile.mkdirs();
		return recordIndexFile.getPath();
	}
	//文件递归copy
	//遍历补丁 根据补丁中的文件 文件夹去项目中移走文件或者直接创建
	/**
	 * 
	 * @param podding 补丁文件
	 * @param project 项目文件
	 * @param recordIndexPath 备份保存的根路径
	 * @param index project的名字的位置,用来创建保存路径的位置时候需要用
	 * @throws Exception 
	 */
	private static void recursiveTraverseMoveAndCopy(File podding, File project,String recordIndexPath, int index) throws Exception {
		File[] fArr=podding.listFiles();
		String sProject=project.getPath();
		File ex=null;
		boolean isExist=true;
		for(File i:fArr){
			ex=new File(sProject+"/"+i.getName());//文件全名~只操作文件
			isExist=ex.exists();
			if(i.isFile()){//是文件
				if(isExist){//存在的话 移走
					File ft=new File(recordIndexPath+"/"+ex.getPath().substring(index));
					ft.getParentFile().mkdirs();
					ft.createNewFile();
					copyByTransfer(ex,ft);
				}else{//不存在的话创建
					ex.createNewFile();
				}
				copyByTransfer(i,ex);
			}else{//是目录
				if(!isExist){//项目中不存在的对应目录话创建目录 继续递归
					ex.mkdirs();
				}
				recursiveTraverseMoveAndCopy(i,ex,recordIndexPath,index);
			}
		}
		
		
	}
	
	//递归验证文件是否存在
	//以补丁为准 同时递归 补丁和项目必须同一级别,之前的是坑爹~~
	private static boolean recursiveTraverseCheck(File podding, File project) {
		
		File[] fArr=podding.listFiles();
		String sProject=project.getPath();
		File ex=null;
		boolean isExist=true;
		boolean isSameStructure=true;
		//遍历
		//如果是文件则不获取list 直接看另一边有没有 否则的话也要看那边有没有 并且有的话还要比较下级目录
		for(File i:fArr){
			ex=new File(sProject+"/"+i.getName());
			isExist=ex.exists();
			if(isExist==false)//这句话的意思是 遍历过程中只要有一个补丁中存在而项目中不存在的文件/文件夹 则结构是不一样的 变成false~
				isSameStructure=false;
			if(i.isFile()){
				System.out.println("文件 : "+ex.getPath() +"存在 : "+isExist );
			}else{
				System.out.println("目录 : "+ex.getPath() +"存在 : "+isExist );
				if(isExist){
					boolean b=recursiveTraverseCheck(i,ex);
					if(b==false)
						isSameStructure=false;
				}
			}
		}
		return isSameStructure;
		
	}
	//测试文件List
	private static void teFileList() {
		File f=new File("E:/te");
		File[] fArr=f.listFiles();
		String[] s= f.list();
		for(File i:fArr){
			System.out.print(i.getPath());
			if(i.isFile()){
				System.out.println("  文件");
			}else{
				System.out.println("  文件夹");
			}
		}
		
	}
	/**
	 * 测试递归检验文件那个方法
	 */
	private static void teCheck() {
		File podding=new File("E:/te/test/pod");
		File project=new File("E:/te/test/A");
		
		System.out.println(podding!=null);
		System.out.println(podding.exists());
		System.out.println(!podding.isFile());
		
		/*System.out.println(podding.getPath());
		File n=new File(podding.getPath()+"/x");
		System.out.println(n.getPath()+"  ex? "+n.exists());*/
		boolean b=recursiveTraverseCheck(podding,project);
		System.out.println(b);
	}
	//文件创建或者文件夹创建测试
	//结论:要创建不存在的目录下的目录用file.mkdirs()方法	要创建不存在的目录下的文件先按之前的创建目录再用file.createNewFile()创建文件
	//如果文件,文件夹存在那么file.mkdirs() file.createNewFile()不执行
	private static void teFileCreate() throws Exception {
		File f=new File("E:/te/h/h2");
		File f2=new File("E:/te/h/h2/lp.txt");
		/*System.out.println("文件夹存在: "+f.exists());
		System.out.println("文件存在: "+f2.exists());*/
		
		File f3=new File("w2.txt");
		/*File f4=new File("D:/workspace/test/lib");
		System.out.println("f3 ex?:"+f3.exists());
		System.out.println("f3 is file?:"+f3.isFile());
		
		System.out.println("f4 ex?:"+f4.exists());
		System.out.println("f4 is file?:"+f4.isFile());*/
		f.mkdirs();
		f2.createNewFile();
		
		System.out.println(f2.exists());
		//System.out.println(copyByTransfer(f3,f2));
		
	}
	//测试管道传输
	private static void teCopyByTransfer() throws Exception {
		File in=new File("C:/Users/Administrator/Desktop/te2");
		File out=new File("E:/te2");
		System.out.println(copyByTransfer(in,out));
	}
	/**
	 * 通过管道传输文件
	 * @param f1 输入文件
	 * @param f2 输出文件
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("resource")
	private static long copyByTransfer(File f1, File f2) throws Exception{
		long time=new Date().getTime();
        int length=1,size=20971520;
        FileChannel inC=new FileInputStream(f1).getChannel();
		FileChannel outC=new FileOutputStream(f2).getChannel();
        while(true){
        	//如果源文件的指针位置和大小一样了,说明读完了,结束
            if(inC.position()==inC.size()){
                inC.close();
                outC.close();
                return new Date().getTime()-time;
            }
            //下面两句大概明白了 就是说两边通过管道传输东西大概传输量不可控,如果没有20m的量就按实际尺寸写入;如果超出20m的量就先写入20m 剩下的下次再说~
            if((inC.size()-inC.position())<size)//如果大小减去位置小于 20m 长度length=尺寸差
                length=(int)(inC.size()-inC.position());
            else
                length=size;//否则长度=20m
            inC.transferTo(inC.position(),length,outC);
            inC.position(inC.position()+length);
        }
	}

	/**
     * 检查File是否为空或者不存在或者不是目录
     * @param f
     * @return
     */
	private static boolean checkFile(File f) {
		if(!(f!=null&&f.exists()&&!f.isFile())){
			System.out.println("补丁文件夹为null,或者不存在,或者不是文件夹");
			return false;
		}else{
			return true;
		}
	}

	@SuppressWarnings("resource")
	private static void te1 () throws Exception{
		File f=new File("w.txt");
		File f2=new File("C:/Users/Administrator/Desktop");
		PrintWriter pw=new PrintWriter(new OutputStreamWriter(new FileOutputStream(f,false),"utf-8"),true);
		BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(f2)));
		String s=null;
		while((s=br.readLine())!=null){
			pw.println("");
		}
		pw.close();
		f.renameTo(new File("w2.txt"));
	}

}
