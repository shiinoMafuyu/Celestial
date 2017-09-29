/******************************************************************
 * ConactSever.java
 * Copyright 2017 by WZG. All Rights Reserved.
 * CreateDate：2017年6月17日
 * Author：wangzg
 * Version：1.0.0
 ******************************************************************/

package com.celestial.butterflystorm.butterfly2017.protocoltest.core.impl;

import com.celestial.agniRadiance.entity.Tag;
import com.celestial.agniRadiance.remote.UtilHttp;
import com.celestial.butterflystorm.butterfly2017.protocoltest.core.IConactSever;

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
public class ConactSever implements IConactSever {

	@Override
	public Tag sendRequest(String url, String param, String charset) {
		Tag t = null;
		try {
			t = new Tag(UtilHttp.doPost(url,param,charset));
		} catch (Exception e) {
			t = null;
		}
		return t;
	}

}
