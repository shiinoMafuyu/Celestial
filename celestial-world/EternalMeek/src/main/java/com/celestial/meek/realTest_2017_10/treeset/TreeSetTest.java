/******************************************************************
 * TreeSetTest.java
 * Copyright 2017 by WZG. All Rights Reserved.
 * CreateDate：2017年10月23日
 * Author：wangzg
 * Version：1.0.0
 ******************************************************************/

package com.celestial.meek.realTest_2017_10.treeset;

import java.util.Comparator;
import java.util.TreeSet;

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
public class TreeSetTest {
	
	@Test
	public void testTreeSet(){
		TreeSet<Person> ts = new TreeSet<>(new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				if (o1.getAge() > o2.getAge()){
					return 1;
				}else {
					return -1;
				}
			}
		});
		
		ts.add(new Person().setAge(5).setName("sino"));
		ts.add(new Person().setAge(3).setName("kimi"));
		ts.add(new Person().setAge(2).setName("miki"));
		ts.add(new Person().setAge(7).setName("yuki"));
		ts.add(new Person().setAge(5).setName("niki"));
		ts.add(new Person().setAge(4).setName("yuii"));
		
		ts.add(new Person().setAge(1).setName("moly"));
		ts.add(new Person().setAge(5).setName("nori"));
		
		System.out.println(ts);
		System.out.println(ts.size());
	}
}
