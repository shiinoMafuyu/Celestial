/******************************************************************
 * User.java
 * Copyright 2017 by WZG. All Rights Reserved.
 * CreateDate：2017年8月6日
 * Author：wangzg
 * Version：1.0.0
 ******************************************************************/

package com.celestial.meek.realTest_2017_08;

import java.util.Timer;
import java.util.TimerTask;

/**
 * <b>修改记录：</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2017年8月6日
 * </li>
 * </p>
 * 
 * <b>类说明：</b>
 * <p> 
 * 
 * </p>
 */
public class User {
	
	private static String kind = "humanBeing";
	
	private String id = "experiment001";
	
	private String name = "实验体001";

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
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取
	 * </ul>
	 * @return the kind
	 */
	public static String getKind() {
		return kind;
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 设置
	 * </ul>
	 * kind
	 */
	public static void setKind(String kind) {
		User.kind = kind;
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
	 * 设置
	 * </ul>
	 * name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取
	 * </ul>
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 设置
	 * </ul>
	 * id
	 */
	public void setId(String id) {
		this.id = id;
	}
}
