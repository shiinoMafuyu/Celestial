package com.celestial.butterflystorm.butterfly2016.dragonNest;

import com.celestial.agniRadiance.EzUtil.Container;
import com.celestial.butterflystorm.butterfly2016.dragonNest.Interface.Charactor;
import com.celestial.butterflystorm.butterfly2016.dragonNest.config.Config;

public class InterfaceHolder {

	
	/**
	 * <b>方法说明：</b>
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
