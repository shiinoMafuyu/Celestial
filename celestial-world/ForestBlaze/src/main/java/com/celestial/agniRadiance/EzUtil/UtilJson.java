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
public class UtilJson {

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
		return new StringBuffer(UtilString.subStringLast(sb.toString(), 1)).append("}").toString();
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
		StringBuffer sb2 = new StringBuffer(UtilString.subStringLast(sb.toString(), 1)).append("]");
		return sb2.toString();
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 根据json字符串生成java类。<br/>
	 * 使用set方法赋值<br/>
	 * 成员变量限基础类型。
	 * </ul>
	 * @param jsonStr json字符串
	 * @param clazz 类
	 * @return
	 */
	public static <T> T stringToObject(String jsonStr, Class<T> clazz) {
		try {
			JSONObject js = new JSONObject(jsonStr);
			Constructor<T> cons = clazz.getConstructor();
			T obj = cons.newInstance();
			Method[] methodArr = clazz.getMethods();
			
			String key=null,value=null,methodName=null;
			
			//遍历jsonStr里的key，找到clazz里对应的set方法，分别调用，给各属性赋上key对应的值。
			for(Iterator<String>  it = js.keys() ;it.hasNext();){
				try {
					StringBuffer sb = new StringBuffer().append("set");
					key = it.next();
					value = js.getString(key);
					if(null != value){
						methodName = sb.append(UtilString.transHeadToUpperCase(key)).toString();
						Method m = stringToObject_getMethod(methodArr,methodName);
						if(m == null)
							continue;
						Class<?> paramClass = m.getParameterTypes()[0];
						m.invoke(obj, paramClass.getConstructor(String.class).newInstance(value));
					}
				} catch (Exception e) {
					continue;
				}
			}
			
			return obj;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
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
		return null;
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
		StringBuffer sb2 = new StringBuffer(UtilString.subStringLast(sb.toString(), 1)).append("}");
		
		return sb2.toString();
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * json转Map
	 * </ul>
	 * @param json
	 * @return
	 */
	public static Map<String, String> json2Map(JSONObject json) {
		Map<String,String> m = new HashMap<String, String>();
		Iterator<String> it = json.keys();
		while(it.hasNext()){
			String key =(String)it.next();
			m.put(key, json.getString(key));
		}
		return m;
	}


	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * map转json
	 * </ul>
	 * @param m
	 * @return
	 */
	public static JSONObject map2Json(Map<String, String> m) {
		return new JSONObject(m);
	}
	



	
	
	
	
}
