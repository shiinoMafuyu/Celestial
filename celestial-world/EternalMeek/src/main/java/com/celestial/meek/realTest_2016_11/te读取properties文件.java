package com.celestial.meek.realTest_2016_11;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class te读取properties文件 {

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param args 
	 */
	public static void main(String[] args) {
		Properties ps = new Properties();
		te读取properties文件 t = new te读取properties文件();
		URL url = t.getClass().getResource("/common1.properties");
		try {
			System.out.println(url);
			System.out.println(url.getPath().substring(1));
			File f =  new File(url.getPath().substring(1));
			FileInputStream fis = new FileInputStream(f);
			ps.load(fis);
			fis.close();
			String key = "2016-11-12";
			String s = (String)ps.get(key);
			System.out.println(s);
			ps.remove(key);
			ps.put("2016-11-28", "233");
			ps.put("world2", "so empty111111");
			FileOutputStream fos = new FileOutputStream(f);
			ps.store(fos, "qaq is that?");
			fos.flush();
			fos.close();
			
			System.out.println("well done!");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(url);
		
	}

}
