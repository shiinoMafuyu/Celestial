package com.celestial.misdirection.JunitPlay;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.celestial.misdirection.JunitPlay.entity.Equipment;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestVariable {
	
	static Equipment a = null;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("--------------------------------qaq");
	}
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	@Test
	public void test1m() {
		System.out.println("-- 1 --");
		a.setName("亿万斯年");
		System.out.println(a);
		Assert.assertNotNull(a);
		
	}
	@Test
	public void test2m() {
		System.out.println("-- 2 --");
		System.out.println(a);
		Assert.assertNotNull(a);
	}
	
	
}
