package com.celestial.misdirection.JunitPlay;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.celestial.meek.realTest_2017_06.interFace.Beautiful;
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
		
		Beautiful b = () -> {System.out.println("你为什么要吃药？！都不萌萌哒了！");return "该吃药了，给你留了大瓶的";};
		System.out.println(b.show());
//		new Thread(() -> System.out.println("In Java8, Lambda expression rocks !!") ).start();
	}
	
}
