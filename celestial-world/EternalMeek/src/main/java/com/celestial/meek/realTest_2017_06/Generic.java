/******************************************************************
 * Generic.java
 * Copyright 2017 by WZG. All Rights Reserved.
 * CreateDate��2017��6��23��
 * Author��wangzg
 * Version��1.0.0
 ******************************************************************/

package com.celestial.meek.realTest_2017_06;

import java.util.HashMap;
import java.util.Map;

/**
 * <b>�޸ļ�¼��</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2017��6��23��
 * </li>
 * </p>
 * 
 * <b>��˵����</b>
 * <p> 
 * 
 * </p>
 */
public class Generic {

	/**
	 * <b>����˵����</b>
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
