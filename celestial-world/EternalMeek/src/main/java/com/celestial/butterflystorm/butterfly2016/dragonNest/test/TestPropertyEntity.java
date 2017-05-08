package com.celestial.butterflystorm.butterfly2016.dragonNest.test;

import com.celestial.butterflystorm.butterfly2016.dragonNest.Abstract.PropertyEntity;

import junit.framework.TestCase;

public class TestPropertyEntity extends TestCase {
	PropertyEntity pe = null;
	public void testConstructor() {
		pe = new PropertyEntity() {
		};
		System.out.println(pe.getPropertyFixedPCTMap().size());
		assertEquals(pe.getPropertyFixedPCTMap().size()>0,true);
		assert(pe.getPropertyMap().size()>0);
		assert(pe.getPropertyMulMap().size()>0);
	}
}
