/******************************************************************
 * TestSolution.java
 * Copyright 2017 by WZG. All Rights Reserved.
 * CreateDate：2017年10月12日
 * Author：wangzg
 * Version：1.0.0
 ******************************************************************/

package com.celestial.leetcode.WordLadderII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;


/**
 * <b>修改记录：</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2017年10月12日
 * </li>
 * </p>
 * 
 * <b>类说明：</b>
 * <p> 
 * 
 * </p>
 */
public class TestSolution {
	
	Solution s = new Solution();
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	@Test
	public void _01_(){
		
		List<List<String>> list = s.findLadders("hit", "cog", Arrays.asList(new String[]{"hot","dot","dog","lot","log"}));
		Assert.assertEquals(new ArrayList<List<String>>(), list);
	}
	
	@Test
	public void _02_(){
		
		List<List<String>> list = s.findLadders("hit", "cog", Arrays.asList(new String[]{"hot","dot","dog","lot","log","cog"}));
		List<List<String>> expectedList = new ArrayList<>();
		
		expectedList.add(Arrays.asList(new String[]{"hit","hot","dot","dog","cog"}));
		expectedList.add(Arrays.asList(new String[]{"hit","hot","lot","log","cog"}));
		
		Assert.assertEquals(expectedList, list);
		
		
	}
	
	@Test
	public void _03_(){
		List<String> list = new ArrayList<>();
		list.add("hit");
		list.add("hot");
		list.add("dot");
		list.add("dog");
		list.add("cog");
		list.add("hit");
		Iterator<String> itor = list.iterator();
		while(itor.hasNext()){
			String next = itor.next();
			System.out.println(next);
			if(next.contains("o"))
				itor.remove();
		}
		System.out.println(list);
	}
	
	
}
