/******************************************************************
 * IExcutedQuery.java
 * Copyright 2017 by WZG. All Rights Reserved.
 * CreateDate��2017��6��27��
 * Author��wangzg
 * Version��1.0.0
 ******************************************************************/

package com.celestial.meek.realTest_2017_06.testSelectSpeed.callback;

import java.util.List;

import com.celestial.meek.realTest_2017_06.testSelectSpeed.Entity;

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
public interface IExcutedQuery {
	
	public void addToList(List<Entity> allList,List<Entity> partList);
}
