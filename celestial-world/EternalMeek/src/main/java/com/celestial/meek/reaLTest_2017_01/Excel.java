package com.celestial.meek.reaLTest_2017_01;

import com.celestial.agniRadiance.entity.FileReader;

public class Excel {

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param args 
	 */
	public static void main(String[] args) {
		FileReader f = new FileReader("E:/t/t19Util持续开发/xb.xlsx");
		while(f.hasNext()){
			System.out.println(f.readLine());
		}
	}

}
