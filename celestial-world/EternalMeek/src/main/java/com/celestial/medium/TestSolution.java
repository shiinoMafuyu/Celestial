/******************************************************************
 * TestSolution.java
 * Copyright 2017 by WZG. All Rights Reserved.
 * CreateDate：2017年10月13日
 * Author：wangzg
 * Version：1.0.0
 ******************************************************************/

package com.celestial.medium;

import org.junit.Assert;
import org.junit.Test;


/**
 * <b>修改记录：</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2017年10月13日
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
		double ret = s.findMedianSortedArrays(new int[]{1, 2,7,8},new int[]{3,9,10,20});
		Assert.assertTrue(7.5d == ret);
		//1 2 3 7   8 9 10 20
	}
	
}
