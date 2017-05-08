package com.celestial.butterflystorm.butterfly2016.dragonNest.other;

import java.util.Map;

import com.celestial.agniRadiance.EzUtil.Util_Collection;
import com.celestial.agniRadiance.EzUtil.Util_File;
@SuppressWarnings({ "unchecked", "rawtypes" })
public class PropertySpace {
	/**�����޸Ĵ�map*/
	public static Map propertyMap = null;
	/**�����޸Ĵ�map*/
	public static Map propertyFixedPCTMap = null;
	/**�����޸Ĵ�map*/
	public static Map propertyListLV1Map = null;
	/**�����޸Ĵ�map*/
	public static Map propertyListLV2Map = null;
	
	static{
		init();
	}
	public PropertySpace() {
		//��Ȼ��ʡ������ת�͵���
	}

	private static void init() {
		Map m1 = Util_File.readProperties(Config.PROPERTY_LV1_MAP_PATH);
		Map m2 = Util_File.readProperties(Config.PROPERTY_LV2_MAP_PATH);
		propertyListLV1Map = Util_Collection.deepCopyMap(m1);
		propertyListLV2Map = Util_Collection.deepCopyMap(m2);
		m1.putAll(m2);
		propertyFixedPCTMap = Util_File.readProperties(Config.PROPERTY_FIXEDPCTMAP_PATH);
		propertyMap = m1;
	}
}
