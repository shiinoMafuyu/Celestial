package com.celestial.butterflystorm.dragonNest;

import com.celestial.agniRadiance.EzUtil.Container;
import com.celestial.butterflystorm.dragonNest.Interface.Charactor;
import com.celestial.butterflystorm.dragonNest.config.Config;

public class InterfaceHolder {

	
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param args 
	 */
	public static void main(String[] args) {
		Container.init(Config.IMPL_MAP);
		
		InterfaceHolder holder = new InterfaceHolder();
		Charactor ct = (Charactor)Container.getRealizationObject("Charactor");
		
	}

}
