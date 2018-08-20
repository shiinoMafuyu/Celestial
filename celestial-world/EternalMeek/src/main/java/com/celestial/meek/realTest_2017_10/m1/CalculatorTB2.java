/******************************************************************
 * CalculatorTB2.java
 * Copyright 2017 by WZG. All Rights Reserved.
 * CreateDate：2017年10月19日
 * Author：wangzg
 * Version：1.0.0
 ******************************************************************/

package com.celestial.meek.realTest_2017_10.m1;

/**
 * <b>修改记录：</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2017年10月19日
 * </li>
 * </p>
 * 
 * <b>类说明：</b>
 * <p> 
 * 
 * </p>
 */
public class CalculatorTB2 extends CalculatorTB {

	
	/**
	 * <b>构造方法</b>
	 * <br/>
	 * @param val
	 * @param symbol
	 */
	public CalculatorTB2(Integer val, boolean symbol) {
		super(val, symbol);
	}
	
	 public void show(){
		System.out.println("child");
	}

	public static void main(String[] args) {
		CalculatorTB.a++;
		CalculatorTB2.a++;
		System.out.println(CalculatorTB2.a);
		
		CalculatorTB tb = new CalculatorTB(1, true);
		tb.show();
		
		CalculatorTB2 tb2 = new CalculatorTB2(1, true);
		tb2.show();
		
		
	}
}
