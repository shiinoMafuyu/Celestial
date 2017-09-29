/******************************************************************
 * ISendRequest.java
 * Copyright 2017 by WZG. All Rights Reserved.
 * CreateDate：2017年6月17日
 * Author：wangzg
 * Version：1.0.0
 ******************************************************************/

package com.celestial.butterflystorm.butterfly2017.protocoltest.core;

import com.celestial.agniRadiance.entity.Tag;

/**
 * <b>修改记录：</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2017年6月17日
 * </li>
 * </p>
 * 
 * <b>类说明：</b>
 * <p> 
 * 
 * </p>
 */
public interface IConactSever {
	
	public Tag sendRequest(String url,String param,String charset);
	
}
