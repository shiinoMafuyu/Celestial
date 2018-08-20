/******************************************************************
 * ABC.java
 * Copyright 2017 by WZG. All Rights Reserved.
 * CreateDate：2017年10月19日
 * Author：wangzg
 * Version：1.0.0
 ******************************************************************/

package com.celestial.meek.realTest_2017_10.m1;

import java.util.Objects;
import java.util.TreeSet;

/**
 * <b>修改记录：</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2017年10月19日
 * </li>
 * </p>
 * 
 * <b>类说明：</b>
 * <p> 
 * 告一段落
 * </p>
 */
public class ABC {
	
	
	public static void main(String[] args) {
		
		Object o = null;String s = null;
		System.out.println("-->"+Objects.equals(o, s));
		
		CalculatorTB tb = new CalculatorTB(1, false);
		tb.show();
		
		CalculatorTB tb2 = tb.clone();
		tb2.show();
		
		
		
		CalculatorTB tb3 = new CalculatorTB();
		tb3.show2("a","b");
		
		System.out.println(Objects.equals("A", new String("A")));
		System.out.println(Objects.equals("A", "B"));
		System.out.println(Objects.equals(null, "B"));
		
		
//		Map<String,String> m= new ConcurrentHashMap<>();
//		m.put("a", null);
//		System.out.println(m);
		
		TreeSet<Double> ts = new TreeSet<>();
		ts.add(5.2);
		ts.add(5.3);
		ts.add(5.2);
		ts.add(1.2);
		ts.add(2.23);
		ts.add(1.5);
		ts.add(2.10);
		System.out.println(ts);
		
		
	}
}
