package com.celestial.butterflystorm.butterfly2019;

import java.io.File;

import com.celestial.agniRadiance.entity.FileReader;

public class ReadToOperate {

	public static String path = "src/main/resources/";
	public static void main(String[] args) {
		
		FileReader f = new FileReader(path+"a.html",false);
		
		
		changeToJavascriptArr(f);
	}
	private static void changeToJavascriptArr(FileReader f) {
		while(f.hasNext()) {
			System.out.println(String.format("'%s',", f.readLine()));
		}
	}

}
