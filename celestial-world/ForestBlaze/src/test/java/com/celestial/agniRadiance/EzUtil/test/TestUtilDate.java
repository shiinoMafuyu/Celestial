/******************************************************************
 * Testjava
 * Copyright ${year} by WZG. All Rights Reserved.
 * CreateDate：2017-8-8
 * Author：wanzg
 * Version：F1.0.0.0
 ******************************************************************/

package com.celestial.agniRadiance.EzUtil.test;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.celestial.agniRadiance.EzUtil.UtilDate;
import com.celestial.agniRadiance.EzUtil.test.entity.OverGamePO;


/**
 * <b>修改记录：</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2017-8-8
 * </li>
 * </p>
 * 
 * <b>类说明：</b>
 * <p> 
 * 
 * </p>
 */
public class TestUtilDate {
	
	
	@Test
	public void testgetMaxDate(){
		Long time = System.currentTimeMillis();
		Long max = time + 200L;
		
		List<OverGamePO> list = Arrays.asList(new OverGamePO[]{
				new OverGamePO().setUpdateTime2(null),
				new OverGamePO().setUpdateTime2(new Timestamp(time + 0)),
				new OverGamePO().setUpdateTime2(new Timestamp(time + 200)),
				new OverGamePO().setUpdateTime2(new Timestamp(time + 50)),
				
		});
		
		Date maxDate = UtilDate.getMaxDate(list, "updateTime");
		System.out.println(max +" - " + maxDate.getTime() + " = "+(max - maxDate.getTime()));
		Assert.assertTrue(max.equals(new Long(maxDate.getTime())));
		
		list = Arrays.asList(new OverGamePO[]{
				new OverGamePO().setUpdateTime2(null),
				new OverGamePO().setUpdateTime2(new Timestamp(time + 0)),
				new OverGamePO().setUpdateTime2(new Timestamp(time + 100)),
				new OverGamePO().setUpdateTime2(new Timestamp(time + 200)),
				new OverGamePO().setUpdateTime2(new Timestamp(time + 50)),
				
		});
		maxDate = UtilDate.getMaxDate(list, "updateTime");
		System.out.println(max +" - " + maxDate.getTime() + " = "+(max - maxDate.getTime()));
		Assert.assertTrue(max.equals(new Long(maxDate.getTime())));
		
		
		list = Arrays.asList(new OverGamePO[]{
				new OverGamePO().setUpdateTime2(null),
		});
		maxDate = UtilDate.getMaxDate(list, "updateTime");
		Assert.assertTrue(maxDate == null);
		
		list = Arrays.asList(new OverGamePO[]{
				new OverGamePO().setUpdateTime2(null),
				new OverGamePO().setUpdateTime2(new Timestamp(time + 0)),
				new OverGamePO().setUpdateTime2(new Timestamp(time + 100)),
				new OverGamePO().setUpdateTime2(new Timestamp(time + 200))
		
		});
		maxDate = UtilDate.getMaxDate(list, "updateTime");
		Assert.assertTrue(max.equals(new Date(time + 200).getTime()));
		
		
		list = Arrays.asList(new OverGamePO[]{
				new OverGamePO().setUpdateTime2(new Timestamp(time + 200)),
				new OverGamePO().setUpdateTime2(null),
				new OverGamePO().setUpdateTime2(new Timestamp(time + 0)),
				new OverGamePO().setUpdateTime2(new Timestamp(time + 100))
				
				
		});
		maxDate = UtilDate.getMaxDate(list, "updateTime");
		Assert.assertTrue(max.equals(new Date(time + 200).getTime()));
		
		
		
	}
	
	
	
}


