/******************************************************************
 * ConsoleJunit2.java
 * Copyright 2017 by WZG. All Rights Reserved.
 * CreateDate：2017年8月10日
 * Author：wangzg
 * Version：1.0.0
 ******************************************************************/

package com.celestial.meek.realTest_2017_08.junit2;

import java.math.RoundingMode;
import java.util.Date;

import com.google.common.math.LongMath;

/**
 * <b>修改记录：</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2017年8月10日
 * </li>
 * </p>
 * 
 * <b>类说明：</b>
 * <p> 
 * 
 * </p>
 */
public class ConsoleJunit2 {
	
	
	public static void main(String[] args) {
		System.out.println(LongMath.log2(1000000000000000L, RoundingMode.HALF_EVEN));;
		
		Date d = new Date();
		System.out.println(d.before(null));;
	}
}
