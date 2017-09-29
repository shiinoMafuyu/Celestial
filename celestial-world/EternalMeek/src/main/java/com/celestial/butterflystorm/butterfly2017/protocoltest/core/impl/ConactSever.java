/******************************************************************
 * ConactSever.java
 * Copyright 2017 by WZG. All Rights Reserved.
 * CreateDate��2017��6��17��
 * Author��wangzg
 * Version��1.0.0
 ******************************************************************/

package com.celestial.butterflystorm.butterfly2017.protocoltest.core.impl;

import com.celestial.agniRadiance.entity.Tag;
import com.celestial.agniRadiance.remote.UtilHttp;
import com.celestial.butterflystorm.butterfly2017.protocoltest.core.IConactSever;

/**
 * <b>�޸ļ�¼��</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2017��6��17��
 * </li>
 * </p>
 * 
 * <b>��˵����</b>
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
