/******************************************************************
 * TestSolution.java
 * Copyright 2017 by WZG. All Rights Reserved.
 * CreateDate��2017��10��16��
 * Author��wangzg
 * Version��1.0.0
 ******************************************************************/

package com.celestial.leetcode._0004mediansortedarrays;

import org.junit.Test;

/**
 * <b>�޸ļ�¼��</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2017��10��16��
 * </li>
 * </p>
 * 
 * <b>��˵����</b>
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
