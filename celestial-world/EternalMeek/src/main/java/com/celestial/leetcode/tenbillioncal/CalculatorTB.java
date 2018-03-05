/******************************************************************
 * CalculatorTB.java
 * Copyright 2017 by WZG. All Rights Reserved.
 * CreateDate：2017年10月19日
 * Author：wangzg
 * Version：1.0.0
 ******************************************************************/

package com.celestial.leetcode.tenbillioncal;

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
public class CalculatorTB {
	
	private Integer val;
	private boolean symbol;
	
	/**
	 * <b>构造方法</b>
	 * <br/>
	 * @param val
	 * @param symbol
	 */
	public CalculatorTB(Integer val, boolean symbol) {
		super();
		this.val = val;
		this.symbol = symbol;
	}
	
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取
	 * </ul>
	 * @return the val
	 */
	public Integer getVal() {
		return val;
	}



	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取
	 * </ul>
	 * @return the symbol
	 */
	public boolean isSymbol() {
		return symbol;
	}



	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 设置
	 * </ul>
	 * val
	 */
	public void setVal(Integer val) {
		this.val = val;
	}



	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 设置
	 * </ul>
	 * symbol
	 */
	public void setSymbol(boolean symbol) {
		this.symbol = symbol;
	}



	public static void main(String[] args) {
		CalculatorTB cal = new CalculatorTB(1, true);
		CalculatorTB cal2 = new CalculatorTB(1, true);
		System.out.println(cal.equals(cal2));
	}
}
