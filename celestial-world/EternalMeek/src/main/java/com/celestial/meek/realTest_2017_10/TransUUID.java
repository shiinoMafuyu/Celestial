/******************************************************************
 * TransUUID.java
 * Copyright 2017 by WZG. All Rights Reserved.
 * CreateDate：2017年10月16日
 * Author：wangzg
 * Version：1.0.0
 ******************************************************************/

package com.celestial.meek.realTest_2017_10;

import java.util.ArrayList;
import java.util.List;

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
public class TransUUID {
	
	public String arr2UUID(int[] arr){
		StringBuilder res = new StringBuilder("0x");
		
		for(int i = 0;i< arr.length;i++){
			res.append(int2str(arr[i]));
			if((i + 1)%4 ==0)
				res.append("-");
		}
		return res.toString();
	}
	
	public Integer[] UUID2arr(String str){
		
		String opstr = str.substring(2).replaceAll("-", "");
		List<Integer> list = new ArrayList<>();
		for(int i=0;i+1<str.length();i+=2){
			list.add(str2Int(opstr.substring(i, i+2)));
		}
		
		return list.toArray(new Integer[]{});
	}
	
	public int str2Int(String str){
		return Integer.parseInt(str,16);
	}
	public String int2str(int n){
		return Integer.toHexString(n);
	}
	
}
