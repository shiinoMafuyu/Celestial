package com.celestial.butterflystorm.butterfly2016.dragonNest.test;

import java.util.Map;

import com.celestial.butterflystorm.butterfly2016.dragonNest.other.EnmuCharacterJob;

import junit.framework.TestCase;

public class TestGrammer extends TestCase{
	
	
	public void testGetMap(){
		Map<String,Map<String,Double>> m = EnmuCharacterJob.getAddtionMap();
		System.out.println(m.get("strength").get("physicalAttack"));
	}
	
	
	
	
	
	
	
	
	
}
