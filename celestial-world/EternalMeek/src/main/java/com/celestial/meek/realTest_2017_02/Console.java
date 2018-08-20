package com.celestial.meek.realTest_2017_02;


public class Console {

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param args 
	 */
	public static void main(String[] args)  {
		
		String s = "strengthenKind=strengthenKind,level=level,goodslevel=goodslevel|strengthen";
		String[] sArr = s.split("\\|");
		System.out.println(sArr);
	}

}
