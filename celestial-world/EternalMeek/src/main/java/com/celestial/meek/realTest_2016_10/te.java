package com.celestial.meek.realTest_2016_10;

import com.celestial.agniRadiance.entity.FileReader;

public class te {

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param args 
	 */
	public static void main(String[] args) {
//		readFileAndPrint();
		/*Rectangle s = new Square();
		s.setLength(10);
		System.out.println(s.getWidth());*/
//		System.out.println(Config.IMPL_MAP.get("InformationGetter"));
		
		/*Util_Helper.checkDouble("4.31%~4.31%");
		Util_Helper.checkDouble("4.31%");
		
		Util_Helper.checkInteger("50~51");*/
		
//		System.out.println(254/19 + " "+ 254%19+"/"+19);
		/*System.out.println(365.25*19/235);
		System.out.println(365.25*19-235*29.5);readFileAndPrint();*/
		
		String mooncake = "badTast1";
		
	}

	public static void readFileAndPrint() {
		FileReader forker = new FileReader("E:/HackingGate/01_StandardTest/01_101610/1.java",false,"utf-8");
		while(forker.hasNext()){
			System.out.println("'" + forker.readLine() + "' +");
		}
	}

}
