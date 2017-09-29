package com.celestial.meek.realTest_2016_08;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Properties;

import com.celestial.agniRadiance.EzUtil.UtilFile;
import com.celestial.agniRadiance.EzUtil.UtilString;

@SuppressWarnings("unused")
public class te {

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param args 
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
//		teEquals();		
//		toKnowSystemInfo();
//		deleteFileUnZipMistake();
		compareTwoFile();
	}

	private static void compareTwoFile() throws FileNotFoundException {
		System.out.println("��ͬ : " + UtilFile.getMd5ByFile(new File("C:/Users/Administrator/Documents/����Ŀ����/08�ֻ�/2�����ERͼ/zhaozy/΢���׺ͱ���/����ϵͳERͼ(1).dm1")).equals(UtilFile.getMd5ByFile(new File("C:/Users/Administrator/Documents/����Ŀ����/08�ֻ�/2�����ERͼ/zhaozy/΢���׺ͱ���/����ϵͳERͼ.dm1"))));
	}

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ɾ����ѹ������ļ�
	 * </ul>
	 * @throws FileNotFoundException 
	 */
	private static void deleteFileUnZipMistake() throws FileNotFoundException {
		String s1="C:/Users/Administrator/Documents/����Ŀ����/08�ֻ�/2�����ERͼ/zhaozy/΢���׺ͱ���/����ϵͳ";	
		String s2="C:/Users/Administrator/Documents/����Ŀ����/08�ֻ�/2�����ERͼ/zhaozy/΢���׺ͱ���";		
		
		File f1 = new File(s1);
		File[] fArr1 = f1.listFiles();
		for(File fi : fArr1){
			String name = fi.getName();
			System.out.println(name);
			File ft = new File(s2+"/"+name);
			if(ft.exists()){
				System.out.println("ɾ���ļ�: " + ft.delete());
			}else{
				throw new RuntimeException("������~");
			}
		}

	}

	@SuppressWarnings("rawtypes")
	private static void toKnowSystemInfo() {
		Properties p = System.getProperties();
		Iterator it = p.entrySet().iterator();
		while(it.hasNext()){
			Entry m = (Entry)it.next();
			System.out.println(m.getKey()+"   -->  "+m.getValue());
		}
	}

	private static void teEquals() throws FileNotFoundException {
		String espot = UtilFile.getMd5ByFile(new File("C:/Users/Administrator/Desktop/umb/e�ֻ�/ActiveUser.jar"));
		String vendor = UtilFile.getMd5ByFile(new File("C:/Users/Administrator/Desktop/umb/����/ActiveUser.jar"));
		System.out.println(espot.equals(vendor));
		
		
	}

	private static void teRegexExpression() {
		String s = "<? xml version= \"1.0\" encoding = \"GBK\"   ?    >";
		System.out.println(s);
		System.out.println(s.replaceAll(" ", "\\\\\\\\s*"));
		System.out.println(s.replaceAll(" ", "\\\\\\\\s*").replaceAll("\"", "\\\\\""));
		
		String ss = "<\\s*\\?\\s*xml\\s*version\\s*=\\s*\"1\\.0\"\\s*encoding\\s*=\\s*\"GBK\"\\s*\\?\\s*>";
		System.out.println(UtilString.matchAllSameRegx(s, ss));
		
	}

}
