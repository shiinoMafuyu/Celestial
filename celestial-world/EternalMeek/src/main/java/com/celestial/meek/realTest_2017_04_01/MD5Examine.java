package com.celestial.meek.realTest_2017_04_01;

import java.io.File;

import com.celestial.agniRadiance.EzUtil.Util_File;

public class MD5Examine {

	public static void main(String[] args) {
		System.out.println(Util_File.getMd5ByFile(new File("E:/Download/apache-tomcat-6.0.53-windows-x64.zip")).equals("70d59a61ddf76ab0fd8eafafaf33b6e7"));
		
	}

}
