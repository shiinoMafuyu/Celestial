/******************************************************************
 * Solution.java
 * Copyright 2017 by WZG. All Rights Reserved.
 * CreateDate��2017��10��16��
 * Author��wangzg
 * Version��1.0.0
 ******************************************************************/

package com.celestial.leetcode._0004mediansortedarrays;

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
public class Solution {
	
	public double findMedianSortedArrays(int[] A, int[] B) {
        if(A.length > B.length){
            int[] temp = A;A = B;B = temp;
        }
        
        int half = (A.length + B.length + 1)/2;
        int iMin =0,iMax = A.length;
        
        while(iMin <= iMax){
        	int i =(iMin + iMax)/2;
        	int j = half -i;
        	if(i < iMax && B[j-1] > A[i]){
        		iMin ++;
        	} else if(i > iMin && A[i-1] > B[j]){
        		iMax --;
        	}else{
        		int maxLeft = 0;
        		if(i ==0 ){
        			maxLeft = B[j-1];
        		}else if( j== 0){
        			maxLeft = A[i-1];
        		}else{
        			maxLeft = Math.max(A[i-1],B[j-1]);
        		}
        		if((A.length + B.length)%2 == 1)
        			return maxLeft;
        		
        		int minRight = 0;
        		if(i == A.length){
        			minRight = B[j];
        		}else if(j == B.length){
        			minRight = A[i];
        		}else{
        			minRight = Math.min(A[i], B[j]);
        		}
        		
        		return (maxLeft + minRight)/2.0;
        	}
        	
           
        }
        
        return 0.0;
        
    }
}
