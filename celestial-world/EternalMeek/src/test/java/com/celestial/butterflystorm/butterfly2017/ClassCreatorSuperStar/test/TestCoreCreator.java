/******************************************************************
 * TestCoreCreator.java
 * Copyright 2017 by WZG. All Rights Reserved.
 * CreateDate��2017��6��11��
 * Author��wangzg
 * Version��1.0.0
 ******************************************************************/

package com.celestial.butterflystorm.butterfly2017.ClassCreatorSuperStar.test;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.celestial.agniRadiance.EzUtil.UtilCollection;
import com.celestial.butterflystorm.butterfly2017.ClassCreatorSuperStar.core.impl.OrientalBrightNightCity;
import com.celestial.butterflystorm.butterfly2017.ClassCreatorSuperStar.vo.AClass;

/**
 * <b>�޸ļ�¼��</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2017��6��11��
 * </li>
 * </p>
 * 
 * <b>��˵����</b>
 * <p> 
 * 
 * </p>
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestCoreCreator {
	
	private static AClass ac ;
	private static OrientalBrightNightCity cc;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ac = new AClass().setInnerClass(null)
				.setInterfaces(new String[]{"Abc","StrangeInterface"})
				.setQualifiedName("gnnt.MEBS6.react.frontend.trade.vo.TradeQueryResponseVO")
				.setSuperName("ResponseVO")
				.setVariables(new String[][]{
					new String[]{"U","String","pinscode","Pinscode"},
					new String[]{"SID","long","sessionID","sessionID"},
					new String[]{"GID","String","��Ϸ���","gameId"},
					new String[]{"LNO","Integer","�ؿ����","LunaNum"}
				});
		
		cc = new OrientalBrightNightCity();
	}
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	@Test
	public void _01_01_getTheClass(){
		List<String> l = cc.getTheClass(ac);
		UtilCollection.print(l);
	}
	
}
