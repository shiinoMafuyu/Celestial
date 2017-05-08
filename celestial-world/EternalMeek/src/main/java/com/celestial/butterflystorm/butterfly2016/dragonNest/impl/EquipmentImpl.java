package com.celestial.butterflystorm.butterfly2016.dragonNest.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.celestial.butterflystorm.butterfly2016.dragonNest.Abstract.PropertyEntity;
import com.celestial.butterflystorm.butterfly2016.dragonNest.Interface.Equipment;
import com.celestial.butterflystorm.butterfly2016.dragonNest.entity.NumericDouble;
import com.celestial.butterflystorm.butterfly2016.dragonNest.entity.NumericInteger;
import com.celestial.butterflystorm.butterfly2016.dragonNest.other.PropertySpace;
import com.celestial.butterflystorm.butterfly2016.dragonNest.other.Util_Helper;

public class EquipmentImpl extends PropertyEntity implements Equipment {
	
	private List<String> propertyMsgList = new ArrayList<String>();
	
	@Override
	public Map<String, NumericInteger> MapProperty() {
		return this.propertyMap;
	}

	@Override
	public Map<String, NumericDouble> MapPropertyFixedPCT() {
		return this.propertyFixedPCTMap;
	}

	@Override
	public Map<String, NumericDouble> MapPropertyMul() {
		return this.propertyMulMap;
	}
	
	public EquipmentImpl(List<String> ls) {
		initPropertyMsgList(ls);
		initPropertyVariable();
	}

	private void initPropertyMsgList(List<String> ls) {
		for(String si : ls){
			if(si != null && !si.contains("#")){
				this.propertyMsgList.add(si);
			}
		}
		
	}

	private void initPropertyVariable() {
		for(String si : this.propertyMsgList){
			if(!si.contains("="))
				continue;
			int index = si.indexOf("=");
			String key = si.substring(0, index);
			String value = si.substring(index+1);
			if(PropertySpace.propertyFixedPCTMap.get(key) != null){
				//�ǹ̶�����ֵ�ⰵ��ˮ + ��
				//�ڹ̶�����ֵ����ֻ������%
				if(!Util_Helper.checkDouble(value))
					continue;
				NumericDouble.put(propertyFixedPCTMap,key,value);
			}else if(PropertySpace.propertyMap.get(key) != null){
				//��һ������ֵ
				if(Util_Helper.checkInteger(value))
				{
					//������ֵ��ʱ�� �﹥:50~60
					//��key,value��Ӧ�ļ�ֵ�����ֵ,���ӵ�map��ǰ��key,value��(û�����½�,�������)
					NumericInteger.put(propertyMap,key,value);
				}else if(Util_Helper.checkDouble(value)){
					//�����԰ٷֱȵ�ʱ�� �﹥:5.00%~5.00%
					//��key,value��Ӧ�ļ�ֵ�����ֵ,���ӵ�map��ǰ��key,value��(û�����½�,�������)
					NumericDouble.put(propertyMulMap,key,value);
				}
			}
		}
	}


	
}
