/******************************************************************
 * EnumClass.java
 * Copyright 2017 by WZG. All Rights Reserved.
 * CreateDate��2017��8��8��
 * Author��wangzg
 * Version��1.0.0
 ******************************************************************/

package com.celestial.thinking.u19;

import static com.celestial.thinking.Print.printSE;
import static com.celestial.thinking.Print.println;
import static com.celestial.thinking.u19.EnumClass.Name.SHHINO;

import java.util.Date;

import org.junit.Test;

/**
 * <b>�޸ļ�¼��</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2017��8��8��
 * </li>
 * </p>
 * 
 * <b>��˵����</b>
 * <p> 
 * 
 * </p>
 */
public class EnumClass {
	
	private Date createTime;

	enum Name{SHHINO,YUKINO,AYASE;
		@Override
		public String toString() {
			String id = name();
			return id.charAt(0)+id.substring(1).toLowerCase();
		}
	};
	
	@Test
	public void printEnumClass(){
		printSE("printEnumClass");
		
		for(Name ni : Name.values()){
			println(ni + " ordinal : " + ni.ordinal());
			
			println(ni.getDeclaringClass());
			
			println(ni + " == " + Name.SHHINO + " : " + (ni == Name.SHHINO));
			
			
			
		}
		
		println("valueOf(AYASE):" + Name.valueOf("AYASE"));
		
		println(SHHINO);
	}
	
	enum Color{RED,YELLOW,GREEN}
	
	@Test
	public void enumSwitch(){
		printSE("enumSwitch");
//		Color[] colors = Color.values();//values()�����Ǳ������ӵ� �㰴F3������
		Color[] vals = Color.class.getEnumConstants();
		for(Color en: vals){
			println(en);
		}
		
	}

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ��ȡ
	 * </ul>
	 * @return the createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ����
	 * </ul>
	 * createTime
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	

	
	

}
