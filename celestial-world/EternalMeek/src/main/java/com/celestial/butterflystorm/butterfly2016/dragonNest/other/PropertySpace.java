package com.celestial.butterflystorm.butterfly2016.dragonNest.other;

import java.util.Map;

import com.celestial.agniRadiance.EzUtil.UtilCollection;
import com.celestial.agniRadiance.EzUtil.UtilFile;
@SuppressWarnings({ "unchecked", "rawtypes" })
public class PropertySpace {
	/**请勿修改此map*/
	public static Map propertyMap = null;
	/**请勿修改此map*/
	public static Map propertyFixedPCTMap = null;
	/**请勿修改此map*/
	public static Map propertyListLV1Map = null;
	/**请勿修改此map*/
	public static Map propertyListLV2Map = null;
	
	static{
		init();
	}
	public PropertySpace() {
		//居然还省下了我转型的事
	}

	private static void init() {
		Map m1 = UtilFile.readProperties(Config.PROPERTY_LV1_MAP_PATH);
		Map m2 = UtilFile.readProperties(Config.PROPERTY_LV2_MAP_PATH);
		propertyListLV1Map = UtilCollection.deepCopyMap(m1);
		propertyListLV2Map = UtilCollection.deepCopyMap(m2);
		m1.putAll(m2);
		propertyFixedPCTMap = UtilFile.readProperties(Config.PROPERTY_FIXEDPCTMAP_PATH);
		propertyMap = m1;
	}
}
