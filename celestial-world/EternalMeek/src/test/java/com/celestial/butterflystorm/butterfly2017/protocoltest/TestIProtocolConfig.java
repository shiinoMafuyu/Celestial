/******************************************************************
 * TestCoreCreator.java
 * Copyright 2017 by WZG. All Rights Reserved.
 * CreateDate：2017年6月11日
 * Author：wangzg
 * Version：1.0.0
 ******************************************************************/

package com.celestial.butterflystorm.butterfly2017.protocoltest;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.celestial.agniRadiance.entity.Tag;
import com.celestial.butterflystorm.butterfly2017.protocoltest.core.IConactSever;
import com.celestial.butterflystorm.butterfly2017.protocoltest.core.impl.ConactSever;

/**
 * <b>修改记录：</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2017年6月11日
 * </li>
 * </p>
 * 
 * <b>类说明：</b>
 * <p> 
 * 
 * </p>
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestIProtocolConfig {
	
	private static IConactSever conactSever = new ConactSever();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	@Test
	public void _01_01_sendRequest(){
		Tag t = conactSever.sendRequest(ProtocolConfig.URL, 
				ProtocolConfig.requestMap.get("game_type"),
				ProtocolConfig.CHARSET);
		Assert.assertNotNull(t);
	}
	
}
