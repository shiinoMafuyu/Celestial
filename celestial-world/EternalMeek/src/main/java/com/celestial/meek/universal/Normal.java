package com.celestial.meek.universal;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.celestial.agniRadiance.EzUtil.Util_File;
import com.celestial.agniRadiance.entity.FileReader;

/**
 * <b>�޸ļ�¼��</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2016-10-18
 * </li>
 * </p>
 * 
 * <b>��˵����</b>
 * <p> 
 * 1.����һЩ�ҳ��õķ���.
 * �ļ��Ա�,����ƥ��ɶ��.
 * </p>
 */
public class Normal {

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param args 
	 */
	public static void main(String[] args) {
		/*boolean b = compareFile(new File("E:/BaiduYunDownload/01���/VMware12.0��װ����ע����/VMware-workstation-full-12.0.0-2985596.exe"),new File("E:/BaiduYunDownload/01���/VMware12.0��װ����ע����/VMware-workstation-full-12.0.0-2985596_1.exe"));
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
		FileReader f = new FileReader("E:/t/t13���ݿ��ѯ�Ż�/x.txt",false,"utf-8");
		while(f.hasNext()){
			System.out.println("\" "+f.readLine()+" \" +");//���java�ַ���	
//			System.out.println("/**");
//			System.out.println(" * ");
//			System.out.println(" */");
//			System.out.println("private String "+f.readLine()+";");
			
		}
	}

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * �Ƚ������ļ�
	 * </ul>
	 * @param file
	 * @param file2
	 * @return
	 */
	private static boolean compareFile(File file, File file2) {
		return Util_File.getMd5ByFile(file).equals(Util_File.getMd5ByFile(file2));
	}

}
