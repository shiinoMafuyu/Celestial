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
	 * <b>����˵����</b>
	 * <ul>
	 * ��java����תΪjson�ַ�����<br/>
	 * ��Ա�����޻������͡�
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
	 * <b>����˵����</b>
	 * <ul>
	 * ǿһ��List<Object> תΪjson����.
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
	 * <b>����˵����</b>
	 * <ul>
	 * ����json�ַ�������java�ࡣ<br/>
	 * ��Ա�����޻������͡�
	 * </ul>
	 * @param jsonStr json�ַ���
	 * @param clazz ��
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
			
			//����jsonStr���key���ҵ�clazz���Ӧ��set�������ֱ���ã��������Ը���key��Ӧ��ֵ��
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
			throw new RuntimeException("json�ַ���תjava����ʧ�ܣ�");
		}
	}

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ���������ҷ�����
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
		throw new RuntimeException("û���ҵ�������"+methodName);
	}

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ��map<String,List<Object>> ����תΪjson���ݡ�
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
