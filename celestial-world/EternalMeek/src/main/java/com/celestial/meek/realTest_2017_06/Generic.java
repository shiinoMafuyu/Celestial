/******************************************************************
 * Generic.java
 * Copyright 2017 by WZG. All Rights Reserved.
 * CreateDate：2017年6月23日
 * Author：wangzg
 * Version：1.0.0
 ******************************************************************/

package com.celestial.meek.realTest_2017_06;

import java.util.HashMap;
import java.util.Map;

/**
 * <b>修改记录：</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2017年6月23日
 * </li>
 * </p>
 * 
 * <b>类说明：</b>
 * <p> 
 * 
 * </p>
 */
public class Generic {

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param args 
	 */
	public static void main(String[] args) {
		
		String s = "555";
		getMap(s,String.class);
		
	}
	
	@SuppressWarnings("unchecked")
	public static <T,V> Map<T,V> getMap(T a,Class<V> b){
		Map<T,V> m = new HashMap<T,V>();
		System.out.println((V)a);
//		m.put(, value)
		System.out.println(b.getName());
		return m;
	}

}
