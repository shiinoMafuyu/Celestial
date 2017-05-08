package com.celestial.butterflystorm.butterfly2016.dragonNest.impl;

import java.util.Map;

import com.celestial.agniRadiance.EzUtil.Container;
import com.celestial.butterflystorm.butterfly2016.dragonNest.Abstract.PropertyEntity2;
import com.celestial.butterflystorm.butterfly2016.dragonNest.Interface.Addtioner;
import com.celestial.butterflystorm.butterfly2016.dragonNest.Interface.Charactor;
import com.celestial.butterflystorm.butterfly2016.dragonNest.Interface.EquipmentsCombine;
import com.celestial.butterflystorm.butterfly2016.dragonNest.entity.NumericDouble;
import com.celestial.butterflystorm.butterfly2016.dragonNest.entity.NumericInteger;

public class CharactorImpl extends PropertyEntity2 implements Charactor {

	private EquipmentsCombine es = (EquipmentsCombine)Container.getRealizationObject("EquipmentsCombine");
	private Addtioner ad = (Addtioner)Container.getRealizationObject("Addtioner");
	
	public CharactorImpl() {
		super();
	}
	
	public CharactorImpl(EquipmentsCombine equipmentsCombine) {
		this.es = equipmentsCombine;
	}
	
	public void init(EquipmentsCombine equipmentsCombine){
		this.es = equipmentsCombine;
	}
	@Override
	public Map<String, NumericDouble> getTypeAttack() {
		return null;
	}
	
	@Override
	public Map<String, NumericInteger> getMsgOther() {
		return null;
	}
	
	@Override
	public Map<String, NumericInteger> getProperty() {
		return null;
	}
	
	@Override
	public Map<String, NumericInteger> getNormal() {
		return null;
	}

	

	
}
