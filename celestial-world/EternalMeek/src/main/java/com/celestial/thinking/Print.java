/******************************************************************
 * Print.java
 * Copyright 2017 by WZG. All Rights Reserved.
 * CreateDate：2017年8月8日
 * Author：wangzg
 * Version：1.0.0
 ******************************************************************/

package com.celestial.thinking;

/**
 * <b>修改记录：</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2017年8月8日
 * </li>
 * </p>
 * 
 * <b>类说明：</b>
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
	 * <b>方法说明：</b>
	 * <ul>
	 * 
	 * </ul> 
	 */
	public static void printSE() {
		printSE("");
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 
	 * </ul> 
	 */
	public static void printSE(Object obj) {
		System.out.println("\n\n\n\n>>>>>>>>>>>>>>>>>>>  " + obj + "  >>>>>>>>>>>>>>>>>>>>>>>");
	}
}
