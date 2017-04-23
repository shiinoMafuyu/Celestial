package com.celestial.butterflystorm.dragonNest.test;

import java.util.Map;

import junit.framework.TestCase;

import com.celestial.butterflystorm.dragonNest.other.EnmuCharacterJob;

public class TestGrammer extends TestCase{
	
	
	public void testGetMap(){
		Map<String,Map<String,Double>> m = EnmuCharacterJob.getAddtionMap();
		System.out.println(m.get("strength").get("physicalAttack"));
	}
	
	
	
	
	
	
	
	
	
}
