/******************************************************************
 * Print.java
 * Copyright 2017 by WZG. All Rights Reserved.
 * CreateDate��2017��8��8��
 * Author��wangzg
 * Version��1.0.0
 ******************************************************************/

package com.celestial.thinking;

/**
 * <b>�޸ļ�¼��</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2017��8��8��
 * </li>
 * </p>
 * 
 * <b>��˵����</b>
 * <p> 
 * 
 * </p>
 */
public class Print {

	public static void print(Object obj){
		System.out.print(obj);
	}
	
	public static void println(Object obj){
		System.out.println(obj);
	}
	
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * 
	 * </ul> 
	 */
	public static void printSE() {
		printSE("");
	}
	
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * 
	 * </ul> 
	 */
	public static void printSE(Object obj) {
		System.out.println("\n\n\n\n>>>>>>>>>>>>>>>>>>>  " + obj + "  >>>>>>>>>>>>>>>>>>>>>>>");
	}
}
