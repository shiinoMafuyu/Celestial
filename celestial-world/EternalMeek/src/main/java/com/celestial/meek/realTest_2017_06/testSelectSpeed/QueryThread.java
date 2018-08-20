/******************************************************************
 * QueryThread.java
 * Copyright 2017 by WZG. All Rights Reserved.
 * CreateDate：2017年6月27日
 * Author：wangzg
 * Version：1.0.0
 ******************************************************************/

package com.celestial.meek.realTest_2017_06.testSelectSpeed;

import java.util.List;

/**
 * <b>修改记录：</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2017年6月27日
 * </li>
 * </p>
 * 
 * <b>类说明：</b>
 * <p> 
 * 
 * </p>
 */
public class QueryThread extends Thread{
	
	QueryDAO queryDAO;
	Long[] range ;
	List<Entity> list ;
	
	/**
	 * <b>构造方法</b>
	 * <br/>
	 * @param queryDAO
	 * @param range
	 */
	public QueryThread(QueryDAO queryDAO, Long[] range) {
		super();
		this.queryDAO = queryDAO;
		this.range = range;
	}
	
	
	@Override
	public void run() {
		super.run();
		list = queryDAO.getQuotation(range);
	}


	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取
	 * </ul>
	 * @return the list
	 */
	public List<Entity> getList() {
		return list;
	}


	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 设置
	 * </ul>
	 * list
	 */
	public void setList(List<Entity> list) {
		this.list = list;
	}


	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取
	 * </ul>
	 * @return the queryDAO
	 */
	public QueryDAO getQueryDAO() {
		return queryDAO;
	}
	
	
}


