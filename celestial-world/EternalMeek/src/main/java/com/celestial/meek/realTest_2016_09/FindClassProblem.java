package com.celestial.meek.realTest_2016_09;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.celestial.agniRadiance.EzUtil.UtilFile;

public class FindClassProblem {

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param args 
	 */
	public static void main(String[] args) {
//		DBUtil.forCMD(new File("E:\\anotherDeskTop\\parese2\\fall\\E现货--手机客户端与服务器通信协议(旧).txt"),new File("E:\\anotherDeskTop\\parese2\\fall\\te"));
//		DBUtil.forCMD(new File("E:/HackingGate/03_2016-08-20_开发一部时的补丁文件/补丁包/=0001宁夏绿巨人/0037-加盟商设置--佣金查询--交易待付佣金和日返佣查询的修改/db_script/待付佣金视图修改--添加了一个查询字段--type.sql"),new File("E:\\anotherDeskTop\\parese2\\fall\\te"));
		//E:\HackingGate\03_2016-08-20_开发一部时的补丁文件\补丁包\=0001宁夏绿巨人\0037-加盟商设置--佣金查询--交易待付佣金和日返佣查询的修改\db_script\待付佣金视图修改--添加了一个查询字段--type.sql
		File f1 = new File("E:/HackingGate/03_2016-08-20_开发一部时的补丁文件/补丁包/=0001宁夏绿巨人");
		File f2 = new File("E:/HackingGate/03_2016-08-20_开发一部时的补丁文件/补丁包/真绿巨人(核是否最新)");
//		System.out.println(f1.exists() +" "+f2.exists());
//		getFileTogetherByModifyTime(f1,f2);
//		compareMad5();
		UtilFile.getFileTogetherByModifyTime(f1,f2);
	}

	@SuppressWarnings("unused")
	private static void compareMad5() {
		File f1 = new File("E:/HackingGate/03_2016-08-20_开发一部时的补丁文件/补丁包/真绿巨人(核是否最新)/integrated_broker/timebargain_broker/jquery.validationEngine-zh_CN.js");
		File f2 = new File("E:/HackingGate/03_2016-08-20_开发一部时的补丁文件/补丁包/x/");
		File[] fArr = f2.listFiles();
		for(File i : fArr){
			if(UtilFile.compareMD5(f1,i)){
				System.out.println(i.getName());
			}
		}
	}

	public static void getFileTogetherByModifyTime(File f1,File f2) {
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

}
