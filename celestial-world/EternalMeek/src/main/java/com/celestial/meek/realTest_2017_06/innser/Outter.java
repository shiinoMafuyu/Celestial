/******************************************************************
 * Inner.java
 * Copyright 2017 by WZG. All Rights Reserved.
 * CreateDate：2017年6月20日
 * Author：wangzg
 * Version：1.0.0
 ******************************************************************/

package com.celestial.meek.realTest_2017_06.innser;

import java.util.ArrayList;
import java.util.List;

/**
 * <b>修改记录：</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2017年6月20日
 * </li>
 * </p>
 * 
 * <b>类说明：</b>
 * <p> 
 * 
 * </p>
 */
public class Outter {
	
	/**
	 * 结论：
	 * 
	 */
	public static void main(String[] args) {
		List<Inner> innerList = new ArrayList<Inner>();
		
		for(int i=0;i<5;i++){
			innerList.add(new Outter().new Inner().setI(i));
		}
		for(Inner ir : innerList){
			System.out.println(ir.getI());
		}
	}
	
	class Inner{
		int i = 0;
		
		public int getI() {
			return i;
		}
		public Inner setI(int i) {
			this.i = i;
			return this;
		}
	}
}
