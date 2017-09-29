/******************************************************************
 * IExcutedQuery.java
 * Copyright 2017 by WZG. All Rights Reserved.
 * CreateDate：2017年6月27日
 * Author：wangzg
 * Version：1.0.0
 ******************************************************************/

package com.celestial.meek.realTest_2017_06.testSelectSpeed.callback;

import java.util.List;

import com.celestial.meek.realTest_2017_06.testSelectSpeed.Entity;

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
public interface IExcutedQuery {
	
	public void addToList(List<Entity> allList,List<Entity> partList);
}
