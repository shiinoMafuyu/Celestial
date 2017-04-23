package com.celestial.butterflystorm.dragonNest.test.Interface;

import junit.framework.TestCase;

import com.celestial.agniRadiance.EzUtil.Container;
import com.celestial.butterflystorm.dragonNest.Interface.Charactor;
import com.celestial.butterflystorm.dragonNest.config.Config;
import com.celestial.butterflystorm.dragonNest.entity.NumericDouble;

public class TestCharacter extends TestCase {
	static{
		Container.init(Config.IMPL_MAP);
	}
	
	private Charactor ct = null;
	@Override
	protected void setUp() throws Exception {
		super.setUp();
//		ct = (Charactor)Container.getREALIZATION("Charactor");
		
		/*try {
			Class c  = Class.forName("com.dragonNest.impl.EquipmentsCombineImpl");
			Object o =c.newInstance();
			EquipmentsCombine cc = (EquipmentsCombine)o;
			EquipmentsCombine ect = (EquipmentsCombine)Container.getRealizationObject("EquipmentsCombine");
			System.out.println(cc);
			
		} catch (Exception e) {
			e.printStackTrace();
		}*/
	}
	
	
	public void testGetTypeAttack() {
		ct = (Charactor)Container.getRealizationObject("Charactor");
		NumericDouble typeLight = ct.getTypeAttack().get("typeLight");
		assertEquals(43.92, typeLight.getValue());
		
	}
	
	
}
