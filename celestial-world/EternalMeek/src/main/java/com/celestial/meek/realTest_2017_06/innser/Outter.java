/******************************************************************
 * Inner.java
 * Copyright 2017 by WZG. All Rights Reserved.
 * CreateDate��2017��6��20��
 * Author��wangzg
 * Version��1.0.0
 ******************************************************************/

package com.celestial.meek.realTest_2017_06.innser;

import java.util.ArrayList;
import java.util.List;

/**
 * <b>�޸ļ�¼��</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2017��6��20��
 * </li>
 * </p>
 * 
 * <b>��˵����</b>
 * <p> 
 * 
 * </p>
 */
public class Outter {
	
	/**
	 * ���ۣ�
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
