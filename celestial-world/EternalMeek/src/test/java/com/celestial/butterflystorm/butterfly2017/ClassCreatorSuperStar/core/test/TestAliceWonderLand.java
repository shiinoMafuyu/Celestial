/******************************************************************
 * TestAliceWonderLand.java
 * Copyright 2017 by WZG. All Rights Reserved.
 * CreateDate：2017年6月11日
 * Author：wangzg
 * Version：1.0.0
 ******************************************************************/

package com.celestial.butterflystorm.butterfly2017.ClassCreatorSuperStar.core.test;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.celestial.agniRadiance.EzUtil.UtilCollection;
import com.celestial.butterflystorm.butterfly2017.ClassCreatorSuperStar.core.IAliceWonderLand;
import com.celestial.butterflystorm.butterfly2017.ClassCreatorSuperStar.core.impl.AliceWonderLand;
import com.celestial.butterflystorm.butterfly2017.ClassCreatorSuperStar.vo.AClass;

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
public class TestAliceWonderLand {
	
	private static IAliceWonderLand alc;
	private static AClass[] innerClass;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		alc = new AliceWonderLand();
		innerClass = new AClass[]{
				new AClass().setInnerClass(null)
				.setInterfaces(new String[]{"Abc","StrangeInterface"})
				.setQualifiedName("gnnt.MEBS6.react.frontend.trade.vo.TradeQueryResponseVO")
				.setSuperName("ResponseVO")
				.setVariables(new String[][]{
					new String[]{"U","String","pinscode","Pinscode"},
					new String[]{"SID","long","sessionID","sessionID"},
					new String[]{"GID","String","游戏编号","gameId"},
					new String[]{"LNO","Integer","关卡序号","LunaNum"}
				})
		};
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	@Test
	public void _01_01_createInnerClass(){
		List<String>  l = alc.createInnerClass(innerClass);
		UtilCollection.print(l);
	}
	
	
	
	
	
}
