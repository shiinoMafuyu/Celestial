/******************************************************************
 * QueryThread.java
 * Copyright 2017 by WZG. All Rights Reserved.
 * CreateDate��2017��6��27��
 * Author��wangzg
 * Version��1.0.0
 ******************************************************************/

package com.celestial.meek.realTest_2017_06.testSelectSpeed;

import java.util.List;

/**
 * <b>�޸ļ�¼��</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2017��6��27��
 * </li>
 * </p>
 * 
 * <b>��˵����</b>
 * <p> 
 * 
 * </p>
 */
public class QueryThread extends Thread{
	
	QueryDAO queryDAO;
	Long[] range ;
	List<Entity> list ;
	
	/**
	 * <b>���췽��</b>
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
	 * <b>����˵����</b>
	 * <ul>
	 * ��ȡ
	 * </ul>
	 * @return the list
	 */
	public List<Entity> getList() {
		return list;
	}


	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ����
	 * </ul>
	 * list
	 */
	public void setList(List<Entity> list) {
		this.list = list;
	}


	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ��ȡ
	 * </ul>
	 * @return the queryDAO
	 */
	public QueryDAO getQueryDAO() {
		return queryDAO;
	}
	
	
}


