package com.celestial.butterflystorm.dragonNest.test;

import junit.framework.TestCase;

import com.celestial.butterflystorm.dragonNest.Abstract.PropertyEntity;

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
