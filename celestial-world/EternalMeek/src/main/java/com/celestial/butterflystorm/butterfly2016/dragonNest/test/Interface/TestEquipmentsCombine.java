package com.celestial.butterflystorm.butterfly2016.dragonNest.test.Interface;

import com.celestial.butterflystorm.butterfly2016.dragonNest.impl.EquipmentsCombineImpl;

import junit.framework.TestCase;

public class TestEquipmentsCombine extends TestCase {
	EquipmentsCombineImpl eps = null;
	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}
	public void testInit(){
		eps = new EquipmentsCombineImpl("src/com/dragonNest/other/equipment/一套装备/一套装备00.txt");
		Double d = eps.getPropertyFixedPCTMap().get("typeLight").getValue();
		assertEquals(43.92, d);//光攻43.92
		assertEquals(13.96, eps.getPropertyFixedPCTMap().get("typeDarkness").getValue());
		assertEquals(29.96, eps.getPropertyFixedPCTMap().get("typeFire").getValue());
		assertEquals(29.96, eps.getPropertyFixedPCTMap().get("typeWater").getValue());
		
		assertEquals(8.62, eps.getPropertyMulMap().get("physicalAttack").getValue());
		assertEquals(8.62, eps.getPropertyMulMap().get("magicAttack").getValue());
		
		assertEquals(4.5, eps.getPropertyMulMap().get("strength").getValue());
		assertEquals(4.5, eps.getPropertyMulMap().get("agile").getValue());
		assertEquals(7.0, eps.getPropertyMulMap().get("wisdom").getValue());
		
		assertEquals(130,(int)eps.getPropertyLV2Map().get("physicalAttack").getValue());
		assertEquals(1288,(int)eps.getPropertyLV2Map().get("magicAttack").getValue());
		assertEquals(23590,(int)eps.getPropertyLV2Map().get("hp").getValue());
		System.out.println(1);
	}
}
