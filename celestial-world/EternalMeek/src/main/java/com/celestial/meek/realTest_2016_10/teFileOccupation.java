package com.celestial.meek.realTest_2016_10;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.celestial.agniRadiance.EzUtil.Util_File;

public class teFileOccupation {

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param args 
	 * @throws IOException 
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		File f= new File("D:/workspace/test/src/test/realTest_2016_10/te.java");
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
		String s = null;
		while((s = br.readLine() )!=null){
			System.out.println(s);
		}
		File f2 = new File("C:/Users/Administrator/Desktop/12/x.txt");
//		File[] f3 = f2.listFiles();
//		Util_File.findFile(new File("C:/Users/Administrator/Desktop/12/x.txt"), new File("C:/Users/Administrator/Desktop/12"));
		
		String md5 = Util_File.getMd5ByFile(f2);
		Scanner sc= new Scanner(System.in);
		String ok = sc.next();
		System.out.println(ok+"  " +md5);
	}

}
