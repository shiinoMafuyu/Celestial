package com.celestial.meek.realTest_2016_09;

import com.celestial.agniRadiance.entity.FileReader;

public class HtmlHelper {

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param args 
	 */
	public static void main(String[] args) {
		FileReader f = new FileReader("E:/anotherDeskTop/��ɧ.txt",false,"utf-8");
		while(f.hasNext()){
			System.out.println("<p>"+f.readLine()+"<br/></p>");
		}
	}

}
