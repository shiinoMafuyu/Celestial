package com.celestial.agniRadiance.EzUtil;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;


@SuppressWarnings("rawtypes")
public class Container {
	
	private static Map<String, Class> REALIZATION_CLASS_MAP = new HashMap<String, Class>();
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 初始化
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
	 * <b>方法说明：</b>
	 * <ul>
	 * 根据参数调用类的构造方法,获取其实例.<br/>
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
			throw new RuntimeException("获取实例失败,请检查接口名和参数是否正确.");
		}
		
	}

	private static void check() {
		if(null == REALIZATION_CLASS_MAP)
			throw new RuntimeException("请先调用初始化方法");
	}
}
