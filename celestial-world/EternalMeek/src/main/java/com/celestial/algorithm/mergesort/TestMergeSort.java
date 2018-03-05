/******************************************************************
 * TestMergeSort.java
 * Copyright 2017 by WZG. All Rights Reserved.
 * CreateDate：2017年10月13日
 * Author：wangzg
 * Version：1.0.0
 ******************************************************************/

package com.celestial.algorithm.mergesort;

import java.util.Arrays;

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
public class TestMergeSort {
	
	MergeSort m = new MergeSort();
	
	@Test
	public void _01_(){
		int[] arr = new int[]{9,1,5,3,4,
			  //5 6 7 8
				2,6,8,7};
		int[] expectedArr = new int[]{1,2,3,4,5,6,7,8,9};
		
		arr = m.mergerSort(arr);
		
		System.out.println(Arrays.toString(arr));
		
		Assert.assertTrue(arrEqual(expectedArr, arr));
	}
	
	@Test
	public void _02_(){
		int[] arr = new int[]{3,2};
		m.switchArr(arr, 0, 0, 1, 1);
		Assert.assertTrue(arrEqual(new int[]{2,3}, arr));
		
	}
	
	@Test
	public void _03_(){
		int[] arr = new int[]{1,9,3,5};
		m.switchArr(arr, 0, 1, 2, 3);
		Assert.assertTrue(arrEqual(new int[]{1,3,5,9}, arr));
		
	}
	
	@Test
	public void _04_(){
		int[] arr = new int[]{1,9,3};
		m.switchArr(arr, 0, 1, 2, 3);
		Assert.assertTrue(arrEqual(new int[]{1,3,9}, arr));
		
	}
	
	@Test
	public void _05_(){
		int[] arr = new int[]{1, 9, 3, 5, 2, 4, 6, 8, 7};
		m.switchArr(arr,8,9,9,9);
		Assert.assertTrue(arrEqual(new int[]{1, 9, 3, 5, 2, 4, 6, 8, 7}, arr));
		
	}
	
	@Test
	public void _06_(){
		int[] arr = new int[]{9};
		int[] expectedArr = new int[]{9};
		arr = m.mergerSort(arr);
		Assert.assertTrue(arrEqual(expectedArr, arr));
	}
	
	@Test
	public void _07_(){
		int[] arr = new int[]{9,3};
		int[] expectedArr = new int[]{3,9};
		arr = m.mergerSort(arr);
		Assert.assertTrue(arrEqual(expectedArr, arr));
	}
	

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param arr1
	 * @param arr2
	 * @return 
	 */
	private boolean arrEqual(int[] arr1, int[] arr2) {
		for(int i=0;i< arr1.length;i++){
			if(arr1[i] != arr2[i])
				return false;
		}
		return true;
	}
}
