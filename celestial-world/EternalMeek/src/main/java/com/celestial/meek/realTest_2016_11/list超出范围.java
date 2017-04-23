package com.celestial.meek.realTest_2016_11;

import java.util.ArrayList;
import java.util.List;

public class list超出范围 {

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param args 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> l = new ArrayList<String>();
		List<String> l2 = new ArrayList<String>();
		l.add("111");
		l.add("112");
		l.add("113");
		l.add("114");
		System.out.println(l.get(0));
		
		
		try {
			l2.add(l.get(0));
			l2.add(l.get(1));
			l2.add(l.get(5));
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(l2);
	}

}
