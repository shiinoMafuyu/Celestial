/******************************************************************
 * User.java
 * Copyright 2017 by WZG. All Rights Reserved.
 * CreateDate��2017��8��6��
 * Author��wangzg
 * Version��1.0.0
 ******************************************************************/

package com.celestial.meek.realTest_2017_08;

import java.util.Timer;
import java.util.TimerTask;

/**
 * <b>�޸ļ�¼��</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2017��8��6��
 * </li>
 * </p>
 * 
 * <b>��˵����</b>
 * <p> 
 * 
 * </p>
 */
public class User {
	
	private static String kind = "humanBeing";
	
	private String id = "experiment001";
	
	private String name = "ʵ����001";

	public static void main(String[] args) {
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
		        public void run() {
		            System.out.println("11232");
		        }
		}, 0 , 1000);
		System.out.println("------->next");
	}
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ��ȡ
	 * </ul>
	 * @return the kind
	 */
	public static String getKind() {
		return kind;
	}

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ����
	 * </ul>
	 * kind
	 */
	public static void setKind(String kind) {
		User.kind = kind;
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
	 * ����
	 * </ul>
	 * name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ��ȡ
	 * </ul>
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ����
	 * </ul>
	 * id
	 */
	public void setId(String id) {
		this.id = id;
	}
}
