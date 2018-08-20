/******************************************************************
 * Country.java
 * Copyright 2017 by WZG. All Rights Reserved.
 * CreateDate：2017年9月13日
 * Author：wangzg
 * Version：1.0.0
 ******************************************************************/

package com.celestial.meek.realTest_2017_09.S01yuanArray.vo;

/**
 * <b>修改记录：</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2017年9月13日
 * </li>
 * </p>
 * 
 * <b>类说明：</b>
 * <p> 
 * 
 * </p>
 */
public class Country {
	
	private String name;
	
	private String capital;
	
	

	@Override
	public String toString() {
		return "Country [name=" + name + ", capital=" + capital + "]";
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取
	 * </ul>
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取
	 * </ul>
	 * @return the capital
	 */
	public String getCapital() {
		return capital;
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 设置
	 * </ul>
	 * name
	 */
	public Country setName(String name) {
		this.name = name;
		return this;
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 设置
	 * </ul>
	 * capital
	 */
	public Country setCapital(String capital) {
		this.capital = capital;
		return this;
	}
	
	
}
