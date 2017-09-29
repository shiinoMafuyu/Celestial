/******************************************************************
 * Country.java
 * Copyright 2017 by WZG. All Rights Reserved.
 * CreateDate��2017��9��13��
 * Author��wangzg
 * Version��1.0.0
 ******************************************************************/

package com.celestial.meek.realTest_2017_09.S01yuanArray.vo;

/**
 * <b>�޸ļ�¼��</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2017��9��13��
 * </li>
 * </p>
 * 
 * <b>��˵����</b>
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
	 * <b>����˵����</b>
	 * <ul>
	 * ��ȡ
	 * </ul>
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ��ȡ
	 * </ul>
	 * @return the capital
	 */
	public String getCapital() {
		return capital;
	}

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ����
	 * </ul>
	 * name
	 */
	public Country setName(String name) {
		this.name = name;
		return this;
	}

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ����
	 * </ul>
	 * capital
	 */
	public Country setCapital(String capital) {
		this.capital = capital;
		return this;
	}
	
	
}
