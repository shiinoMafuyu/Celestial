/******************************************************************
 * RulesReaderTest.java
 * Copyright 2017 by WZG. All Rights Reserved.
 * CreateDate：2017年10月23日
 * Author：wangzg
 * Version：1.0.0
 ******************************************************************/

package com.celestial.meek.realTest_2017_10;

import java.util.concurrent.ThreadLocalRandom;

import org.junit.Test;

/**
 * <b>修改记录：</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2017年10月23日
 * </li>
 * </p>
 * 
 * <b>类说明：</b>
 * <p> 
 * 
 * </p>
 */
public class RulesReaderTest {
	
	@Test
	public void testThreadCreate(){
//		ThreadPoolExecutor tpe = new ThreadPoolExecutor(10, 50, 1000, , new )
		System.out.println(ThreadLocalRandom.current().nextDouble());
		
	}
}
