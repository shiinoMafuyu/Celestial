/******************************************************************
 * CalculatorTB.java
 * Copyright 2017 by WZG. All Rights Reserved.
 * CreateDate��2017��10��19��
 * Author��wangzg
 * Version��1.0.0
 ******************************************************************/

package com.celestial.meek.realTest_2017_10.m1;

/**
 * <b>�޸ļ�¼��</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2017��10��19��
 * </li>
 * </p>
 * 
 * <b>��˵����</b>
 * <p> 
 * 
 * </p>
 */
public class CalculatorTB {
	
	public static int a=0;
	private Integer val;
	private boolean symbol;
	
	
	public void show2(String... str){
		System.out.println("arr");
	}
	
	public void show2(String str,String str2){
		System.out.println("two params");
	}
	
	@Override
	protected CalculatorTB clone() {
		CalculatorTB tb = new CalculatorTB(val, symbol);
		return tb;
	}
	
	public CalculatorTB() {
	}
	public CalculatorTB(Integer val, boolean symbol) {
		super();
		this.val = val;
		this.symbol = symbol;
	}
	
	
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ��ȡ
	 * </ul>
	 * @return the val
	 */
	public Integer getVal() {
		return val;
	}
	
	public void show(){
		System.out.println("super");
	}



	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ��ȡ
	 * </ul>
	 * @return the symbol
	 */
	public boolean isSymbol() {
		return symbol;
	}



	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ����
	 * </ul>
	 * val
	 */
	public void setVal(Integer val) {
		this.val = val;
	}



	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ����
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
