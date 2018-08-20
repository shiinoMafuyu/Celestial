/******************************************************************
 * MergeSort.java
 * Copyright 2017 by WZG. All Rights Reserved.
 * CreateDate：2017年10月13日
 * Author：wangzg
 * Version：1.0.0
 ******************************************************************/

package com.celestial.algorithm.mergesort;

import java.util.Arrays;

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
public class MergeSort {

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param arr
	 * @return 
	 */
	public int[] mergerSort(int[] arr) {
		if(arr==null)
			return arr;
		int half = 0,halfval = 0;
		
		while(halfval * 2 < arr.length){
			halfval = (int)Math.pow(2, half);
			half ++;
			
			
			int index1 = 0;
			do{
				int index2 = index1 + halfval - 1;
				int index3 = index1 + halfval;
				int index4 = index1 + 2 * halfval - 1;
				System.out.println(String.format("m1:%s,m2:%s,n1:%s,n2:%s,arr:%s", index1,index2,index3,index4,Arrays.toString(arr)));
				switchArr(arr,index1,index2,index3,index4);
				index1 = index4 + 1;
				
			}while(index1 < arr.length);
			
		}
		return arr;
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param arr
	 * @param m1
	 * @param m2
	 * @param n1
	 * @param n2 
	 */
	public void switchArr(int[] arr, int m1, int m2, int n1, int n2) {
		
		if(m2 >= arr.length - 1)
			return;
		if(n2 > arr.length - 1)
			n2 = arr.length - 1;
		int[] tempArr = new int[n2 - m1 + 1];
		
		int index = 0,i = m1 ,j = n1;
		for(; i <= m2 && j <= n2 ; ){
			int mi = arr[i];
			int nj = arr[j];
			if(mi < nj){
				tempArr[index] = mi;
				i++;
			}else{
				tempArr[index] = nj;
				j++;
			}
			index ++;
		}
		
		for(;i <= m2;i++){
			tempArr[index] = arr[i];
			index++;
		}
		
		for(;j <= n2;j++){
			tempArr[index] = arr[j];
			index++;
		}
		
		for(int k = 0;k < tempArr.length ; k++){
			arr[m1 + k] = tempArr[k];
		}
		
	}

	
	
	

}
