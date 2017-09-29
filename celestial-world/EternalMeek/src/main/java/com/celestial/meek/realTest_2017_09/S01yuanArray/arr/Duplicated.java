/******************************************************************
 * Duplicated.java
 * Copyright 2017 by WZG. All Rights Reserved.
 * CreateDate：2017年9月13日
 * Author：wangzg
 * Version：1.0.0
 ******************************************************************/

package com.celestial.meek.realTest_2017_09.S01yuanArray.arr;

/**
 * <b>修改记录：</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2017年9月13日
 * </li>
 * </p>
 * 
 * <b>类说明：</b>
 * <p> 
 * 
 * </p>
 */
public class Duplicated<A,B> {
	
	public final A a;
	
	public final B b;
	
	public Duplicated(A a,B b){
		this.a = a;
		this.b = b;
	}

	@Override
	public String toString() {
		return "Duplicated [a=" + a + ", b=" + b + "]";
	}
	
}
