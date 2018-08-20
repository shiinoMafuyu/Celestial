/******************************************************************
 * TestSolution.java
 * Copyright 2017 by WZG. All Rights Reserved.
 * CreateDate：2017年10月16日
 * Author：wangzg
 * Version：1.0.0
 ******************************************************************/

package com.celestial.leetcode._0004mediansortedarrays;

import org.junit.Test;

/**
 * <b>修改记录：</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2017年10月16日
 * </li>
 * </p>
 * 
 * <b>类说明：</b>
 * <p> 
 * 
 * </p>
 */
public class TestSolution {
	static Solution s = new Solution();
	@Test
	public void _01_(){
		double v=s.findMedianSortedArrays(new int[]{1,3}, new int[]{2});
		System.out.println(v);
	}
	
	@Test
	public void _02_(){
		double v=s.findMedianSortedArrays(new int[]{1,2}, new int[]{3,4});
		System.out.println(v);
	}
}
