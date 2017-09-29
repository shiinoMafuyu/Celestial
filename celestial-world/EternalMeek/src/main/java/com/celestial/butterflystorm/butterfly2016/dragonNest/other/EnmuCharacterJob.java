package com.celestial.butterflystorm.butterfly2016.dragonNest.other;

import java.util.HashMap;
import java.util.Map;

import com.celestial.agniRadiance.EzUtil.UtilCollection;

public enum EnmuCharacterJob {
	Swordmaster/*��ʥ*/,
	Mercenary/*ս��*/,
	Bowmaster/*����*/,
	Acrobat/*����*/,
	ElementLord/*Ԫ��ʦ*/,
	ForceUser/*ħ��ʦ*/,
	Paladin/*����*/,
	Priest/*��˾*/,
	theDefault/*������_��,�˼Ҳ�����*/;
	
	@SuppressWarnings({ "serial", "rawtypes" })
	private final static Map addtionMap = new HashMap<String, Map<String,Double>>(){{
		put("strength",new HashMap<String, Double>(){{put("physicalAttack",3.0);put("hardStraight",5.0);put("vertigo",5.0);}});
		put("agile",new HashMap<String, Double>(){{put("physicalAttack",3.0);put("fatalAttack",5.0);put("fatalDefence",5.0);}});
		put("wisdom",new HashMap<String, Double>(){{put("magicAttack",3.0);put("magicDefence",3.0);put("mp",100.0);}});
		put("health",new HashMap<String, Double>(){{put("hp",200.0);put("physicalDefence",3.0);put("hardStraightDef",5.0);put("vertigoDef",5.0);}});
	}};
	
	@SuppressWarnings("unchecked")
	public static Map<String,Map<String,Double>> getAddtionMap(){
		Map<String, Map<String,Double>> m = UtilCollection.deepCopyMap(addtionMap);
		return m;
	}
}
