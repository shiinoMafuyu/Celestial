package com.celestial.meek.realTest_2017_02;

import com.celestial.agniRadiance.EzUtil.UtilCollection;

public class passwordHeadache {

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param args 
	 */
	public static void main(String[] args) {
		String[] sArr1 = new String[]{"io","qw","fsdf","aaga","gaga","sga"};
		String[] sArr2 = new String[]{"(","!","====","$"};
		String[] sArr3 = new String[]{"mi",""};
		String[] sArr4 = new String[]{"143","23141","314"};
		String[] sarr = UtilCollection.dikaer(sArr1,sArr2);
		sarr = UtilCollection.dikaer(sarr,sArr3);
		sarr = UtilCollection.dikaer(sarr,sArr2);
		sarr = UtilCollection.dikaer(sarr,sArr4);
//		System.out.println(sarr);
		for(String si:sarr){
			System.out.println(si);
		}
	}

}
