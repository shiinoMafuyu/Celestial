package com.celestial.agniRadiance.EzUtil;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;


@SuppressWarnings("rawtypes")
public class Container {
	
	private static Map<String, Class> REALIZATION_CLASS_MAP = new HashMap<String, Class>();
	
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ��ʼ��
	 * </ul>
	 * @param realizationMap
	 */
	public static void init(Map<String,String> realizationMap){
		for(int i = 0; i < 2 ; i++)
			for(Map.Entry<String, String> ei : realizationMap.entrySet()){
				try {
//					REALIZATION_CLASS_MAP.put(ei.getKey(), Util_Normal.getReflectObject(ei.getValue()));
					REALIZATION_CLASS_MAP.put(ei.getKey(),UtilReflect.ClassFor(ei.getKey()));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	}
	
	public static Object getRealizationClass(String interfaceName) {
		check();
		return REALIZATION_CLASS_MAP.get(interfaceName);
	}
	
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ���ݲ���������Ĺ��췽��,��ȡ��ʵ��.<br/>
	 * </ul>
	 * @param interfaceName
	 * @param params
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Object getRealizationObject(String interfaceName,Object...params) {
		check();
		try {
			Class c = REALIZATION_CLASS_MAP.get(interfaceName);
			Class[] cArr = new Class[params.length];
			for(int i = 0; i < cArr.length ; i++){
				cArr[i] = params[i].getClass();
			}
			Constructor ct = c.getConstructor(cArr);
			return ct.newInstance(params);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("��ȡʵ��ʧ��,����ӿ����Ͳ����Ƿ���ȷ.");
		}
		
	}

	private static void check() {
		if(null == REALIZATION_CLASS_MAP)
			throw new RuntimeException("���ȵ��ó�ʼ������");
	}
}
