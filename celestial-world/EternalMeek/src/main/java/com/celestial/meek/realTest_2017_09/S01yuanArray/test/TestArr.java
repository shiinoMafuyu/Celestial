/******************************************************************
 * TestArr.java
 * Copyright 2017 by WZG. All Rights Reserved.
 * CreateDate：2017年9月13日
 * Author：wangzg
 * Version：1.0.0
 ******************************************************************/

package com.celestial.meek.realTest_2017_09.S01yuanArray.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import com.celestial.meek.realTest_2017_09.S01yuanArray.arr.Duplicated;
import com.celestial.meek.realTest_2017_09.S01yuanArray.vo.Country;
import com.celestial.meek.realTest_2017_09.S01yuanArray.vo.Person;



/**
 * <b>修改记录：</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2017年9月13日
 * </li>
 * </p>
 * 
 * <b>类说明：</b>
 * <p> 
 * 
 * </p>
 */
public class TestArr {
	
//	@Test
//	public void _01_Duplicated(){
//		String personName = "shiino",countryName = "日本",capital = "东京都";
//		Duplicated<Person, Country> d = getMsg(personName,countryName);
//		Assert.assertEquals(personName, d.a.getName());
//		Assert.assertEquals(countryName, d.b.getName());
//		d.b.setCapital(capital);
//		Assert.assertEquals(capital, d.b.getCapital());
//		
//		
//	}
//	@Test
//	public void _02_FiveTuple(){
//		String personName = "shiino",countryName = "日本",capital = "东京都";
//		FourTuple<Person,Integer,Country,String> five = new FourTuple<>(new Person().setName(personName), 15, new Country().setName(countryName), capital);
//		
//		Assert.assertEquals(five.c.setCapital(capital).getCapital(), capital);
//		
//		Tuple02<Person, Country> two = new Tuple02<>(new Person().setName(personName), new Country().setName(countryName));
//		Assert.assertEquals(two.t1.setAge(15).getAge(), new Integer(15));
//		
//	}
//
//	private Duplicated<Person, Country> getMsg(String personName,String countryName) {
//		Duplicated<Person, Country> d = new Duplicated<>(new Person().setName(personName), new Country().setName(countryName));
//		return d;
//	}
	
	@Test
	public void _03_strangeMap(){
		Map<String,Integer> m = getStrangeMap("mashiro",5);
		Assert.assertEquals(m.get("mashiro"), new Integer(5));
		
	}
	
	private <STRANGE,REDMOON> Map<STRANGE, REDMOON> getStrangeMap(STRANGE k1, REDMOON k2) {
		Map<STRANGE,REDMOON> m = new HashMap<>();
		m.put(k1, k2);
		return m;
	}
	
}
