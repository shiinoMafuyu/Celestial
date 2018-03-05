/******************************************************************
 * Test.java
 * Copyright 2017 by WZG. All Rights Reserved.
 * CreateDate：2017年10月12日
 * Author：wangzg
 * Version：1.0.0
 ******************************************************************/

package com.celestial.leetcode.russiadoll.m2;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * <b>修改记录：</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2017年10月12日
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
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	@Test
	public void _01_(){
		int ret = s.maxEnvelopes(new int[][]{});
		Assert.assertEquals(0, ret);
	}

	@Test
	public void _02_(){
		int ret = s.maxEnvelopes(new int[][]{new int[]{5,4},new int[]{6,4},new int[]{6,7},new int[]{2,3}});
		Assert.assertEquals(3, ret);
	}
	
	@Test
	public void _03_(){
		int ret = s.maxEnvelopes(new int[][]{
			new int[]{1,3},new int[]{3,5},new int[]{6,7},new int[]{6,8},new int[]{8,4},new int[]{9,5}
			});
		Assert.assertEquals(3, ret);
	}

}
