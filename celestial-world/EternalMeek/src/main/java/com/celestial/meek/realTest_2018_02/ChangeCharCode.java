package com.celestial.meek.realTest_2018_02;

import java.io.UnsupportedEncodingException;

public class ChangeCharCode {

	public static void main(String[] args) throws UnsupportedEncodingException {
		
		System.out.println(ChangeCharEncode("EA!","ISO-8859-1","UTF-8"));
		System.out.println(ChangeCharEncode("EA!我","UTF-8","ISO-8859-1"));
		System.out.println(ChangeCharEncode(ChangeCharEncode("EA!我","UTF-8","ISO-8859-1"),"ISO-8859-1","UTF-8"));
	}

	private static String ChangeCharEncode(String str,String encode1,String encode2) throws UnsupportedEncodingException {
		return new String(str.getBytes(encode1),encode2);
	}

}
