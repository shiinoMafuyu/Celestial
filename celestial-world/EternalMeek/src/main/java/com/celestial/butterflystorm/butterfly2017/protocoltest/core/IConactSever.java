/******************************************************************
 * ISendRequest.java
 * Copyright 2017 by WZG. All Rights Reserved.
 * CreateDate��2017��6��17��
 * Author��wangzg
 * Version��1.0.0
 ******************************************************************/

package com.celestial.butterflystorm.butterfly2017.protocoltest.core;

import com.celestial.agniRadiance.entity.Tag;

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
public interface IConactSever {
	
	public Tag sendRequest(String url,String param,String charset);
	
}
