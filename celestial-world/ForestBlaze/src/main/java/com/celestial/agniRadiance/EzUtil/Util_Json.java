package com.celestial.agniRadiance.EzUtil;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import net.sf.json.JSONObject;


@SuppressWarnings("unchecked")
public class Util_Json {

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 将java对象转为json字符串，<br/>
	 * 成员变量限基础类型。
	 * </ul>
	 * @param obj
	 * @return
	 */
	public static String toJsonString(Object obj) {
		
		JSONObject js = JSONObject.fromBean(obj);
		String key=null,value=null;
		StringBuffer sb = new StringBuffer("{");
		for(Iterator<String>  it = js.keys() ;it.hasNext();){
			key = it.next();
			value = js.getString(key);
			if(!"".equals(value) && !"null".equals(value) && null !=value){
				sb.append("\"").append(key).append("\":\"").append(value).append("\",");
			}
		}
		return new StringBuffer(Util_String.subStringLast(sb.toString(), 1)).append("}").toString();
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 强一个List<Object> 转为json数组.
	 * </ul>
	 * @param list
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static String toJsonStringArr(List list) {
		StringBuffer sb = new StringBuffer("[");
		for(Object obj : list){
			sb.append(toJsonString(obj)).append(",");
		}
		StringBuffer sb2 = new StringBuffer(Util_String.subStringLast(sb.toString(), 1)).append("]");
		return sb2.toString();
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 根据json字符串生成java类。<br/>
	 * 成员变量限基础类型。
	 * </ul>
	 * @param jsonStr json字符串
	 * @param clazz 类
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static Object stringToObject(String jsonStr, Class<?> clazz) {
		try {
			JSONObject js = new JSONObject(jsonStr);
			Constructor<?> cons = clazz.getConstructor();
			Object obj = cons.newInstance();
			Method[] methodArr = clazz.getMethods();
			Method m = null;
			
			String key=null,value=null,methodName=null;
			
			//遍历jsonStr里的key，找到clazz里对应的set方法，分别调用，给各属性赋上key对应的值。
			for(Iterator<String>  it = js.keys() ;it.hasNext();){
				StringBuffer sb = new StringBuffer("set");
				key = it.next();
				value = js.getString(key);
				if(null != value){
					methodName = sb.append(Util_String.__transHeadToUpperCase(key)).toString();
					m = stringToObject_getMethod(methodArr,methodName);
					Class paramClass = m.getParameterTypes()[0];
					m.invoke(obj, paramClass.getConstructor(String.class).newInstance(value));
				}
			}
			
			return obj;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("json字符串转java对象失败！");
		}
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 根据名字找方法。
	 * </ul>
	 * @param methodArr
	 * @param methodName
	 * @return
	 */
	private static Method stringToObject_getMethod(Method[] methodArr,
			String methodName) {
		for(int i=0;i<methodArr.length;i++){
			if(methodName.equals(methodArr[i].getName()))
					return methodArr[i];
		}
		throw new RuntimeException("没有找到方法："+methodName);
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 将map<String,List<Object>> 类型转为json数据。
	 * </ul>
	 * @param map
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static String toJsonStringMap(Map map) {
		StringBuffer sb = new StringBuffer("{");
		
		for(Entry ei: (Set<Entry>)map.entrySet()){
			sb.append("\"").append(ei.getKey()).append("\":").append(toJsonStringArr((List)ei.getValue())).append(",");
		}
		StringBuffer sb2 = new StringBuffer(Util_String.subStringLast(sb.toString(), 1)).append("}");
		
		return sb2.toString();
	}

	public static Map<String, String> json2Map(JSONObject json) {
		Map<String,String> m = new HashMap<String, String>();
		Iterator<String> it = json.keys();
		while(it.hasNext()){
			String key =(String)it.next();
			m.put(key, json.getString(key));
		}
		return m;
	}


	public static JSONObject map2Json(Map<String, String> m) {
		return new JSONObject(m);
	}
	



	
	
	
	
}
