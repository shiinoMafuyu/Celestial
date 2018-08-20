package com.celestial.meek.realTest_2016_05_ant;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;

public class MyVeryOwnTask extends Task {
	
	private String podding;
	private String project;
	
	//目录下有的就直接覆盖 改名 先做这个
	//没有目录 没有文件的弹出个提示~~最好 应该
    // The method executing the task
    @SuppressWarnings("resource")
	public void execute() throws BuildException {
        System.out.println("补丁位置: "+podding);
        System.out.println("项目位置: "+project);
        //找到补丁名	找到补丁下面所有文件的字符串 		拼项目下面的文件,去看下面有没有补丁对应文件	没有的话直接复制 有的话直接复制(..)
        //不获取目录怎么样 (niceIdea~) 如果补丁里存在项目里不含有的目录或文件,打印出来,问是否打补丁.是的话,创建目录和文件,否的话完全不执行操作--->遍历补丁去吧~
        //返回的是数组 不过没什么关系,并不需要获取不知道长度和层次的list 直接全部校验一次 再全部创建即可
        File fPodding=new File(podding);
        File fProject=new File(project);
        
        //检查目录是不是不存在
        boolean b1=checkFile(fPodding);
        boolean b2=checkFile(fProject);
        if(!b1){
        	System.out.println("补丁目录为空或者不存在或者不是目录,请检查~");
        	return;
        }
        if(!b2){
        	System.out.println("项目目录为空或者不存在或者不是目录,请检查~");
        	return;
        }
        
        
        //对照文件
        boolean b= recursiveTraverseCheck(fPodding,fProject);
        if(b){
        	System.out.println("完成检测,补丁目录与项目目录结构一致.是否开始? Y/N");
        }else{
        	System.out.println("完成检测,补丁目录与项目目录结构不一致.若继续则会在项目中增加对应目录和文件");
        	System.out.println("是否开始? Y/N");
        }
        
        //对照完毕 执行copy或者放弃
        Scanner scan=new Scanner(System.in);
        String op=scan.next();
        if(!op.toLowerCase().equals("y")){
        	System.out.println("打补丁操作已放弃,程序结束~");
        	return;
        }
        //copy
        //copy step1:获取备份存放路径
        String recordIndexPath=createRecordIndex(fPodding);
        //copy step2:project里面的文件移动备份,补丁中的文件放过来 目录创建
		try {
			recursiveTraverseMoveAndCopy(fPodding,fProject,recordIndexPath,fProject.getPath().lastIndexOf("\\"));
		} catch (Exception e) {
			e.printStackTrace();
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

	/**
	 * 通过管道传输文件
	 * @param f1 输入文件
	 * @param f2 输出文件
	 * @return
	 * @throws Exception
	 */
	private static long copyByTransfer(File f1, File f2) throws Exception{
		long time=new Date().getTime();
        int length=1,size=20971520;
        @SuppressWarnings("resource")
		FileChannel inC=new FileInputStream(f1).getChannel();
        @SuppressWarnings("resource")
		FileChannel outC=new FileOutputStream(f2).getChannel();
        while(true){
            if(inC.position()==inC.size()){
                inC.close();
                outC.close();
                return new Date().getTime()-time;
            }
            if((inC.size()-inC.position())<size)
                length=(int)(inC.size()-inC.position());
            else
                length=size;
            inC.transferTo(inC.position(),length,outC);
            inC.position(inC.position()+length);
        }
	}
	
	/**
	 * 根据补丁所在位置创建备份目录
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
	/**
	 * 递归验证文件是否存在
	 * 以补丁为准 同时递归 补丁和项目必须同一级别,之前方式的是坑爹~~
	 * @param podding
	 * @param project
	 * @return
	 */
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
    
    public void setPodding(String podding) {
		this.podding = podding;
	}
	public void setProject(String project) {
		this.project = project;
	}
	
    
    
}
