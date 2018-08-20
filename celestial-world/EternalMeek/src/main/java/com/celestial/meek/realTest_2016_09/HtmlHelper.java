package com.celestial.meek.realTest_2016_09;

import com.celestial.agniRadiance.entity.FileReader;

public class HtmlHelper {

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param args 
	 */
	public static void main(String[] args) {
		FileReader f = new FileReader("E:/anotherDeskTop/离骚.txt",false,"utf-8");
		while(f.hasNext()){
			System.out.println("<p>"+f.readLine()+"<br/></p>");
		}
	}

}
