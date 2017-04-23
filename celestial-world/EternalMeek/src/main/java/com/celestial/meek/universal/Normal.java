package com.celestial.meek.universal;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.celestial.agniRadiance.EzUtil.Util_File;
import com.celestial.agniRadiance.entity.FileReader;

/**
 * <b>修改记录：</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2016-10-18
 * </li>
 * </p>
 * 
 * <b>类说明：</b>
 * <p> 
 * 1.包含一些我常用的方法.
 * 文件对比,正则匹配啥的.
 * </p>
 */
public class Normal {

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param args 
	 */
	public static void main(String[] args) {
		/*boolean b = compareFile(new File("E:/BaiduYunDownload/01软件/VMware12.0安装包和注册码/VMware-workstation-full-12.0.0-2985596.exe"),new File("E:/BaiduYunDownload/01软件/VMware12.0安装包和注册码/VMware-workstation-full-12.0.0-2985596_1.exe"));
		System.out.println(b);*/
		System.out.println( new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
//		readFileAndprint();
//		transBigCase();
//		System.out.println(Double.MAX_VALUE);
	}

	private static void transBigCase() {
		String s = "firmid";
		System.out.println(s.toUpperCase());
		System.out.println(s.toLowerCase());
	}

	public static void readFileAndprint() {
		FileReader f = new FileReader("E:/t/t13数据库查询优化/x.txt",false,"utf-8");
		while(f.hasNext()){
			System.out.println("\" "+f.readLine()+" \" +");//变成java字符串	
//			System.out.println("/**");
//			System.out.println(" * ");
//			System.out.println(" */");
//			System.out.println("private String "+f.readLine()+";");
			
		}
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 比较两个文件
	 * </ul>
	 * @param file
	 * @param file2
	 * @return
	 */
	private static boolean compareFile(File file, File file2) {
		return Util_File.getMd5ByFile(file).equals(Util_File.getMd5ByFile(file2));
	}

}
