package com.celestial.agniRadiance.EzUtil;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class UtilCollection {
	
	public enum SortWay{
		DESC,ASC
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 打印map
	 * </ul>
	 * @param map
	 */
	public static <K,V> void printMap(Map<K, V> map) {
		StringBuffer sb = null;
		for(Entry<K, V> ei : map.entrySet()){
			sb = new StringBuffer();
			sb.append(ei.getKey()).append(" = ").append(UtilString.toStr(ei.getValue()));
			System.out.println(sb.toString());
		}
		
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 用于显示List<Map<Integer,String>> 免得麻烦每次去写;<br/>
	 * </ul>
	 * @param l
	 */
	public static <K,V> void printListMap(List<Map<K, V>> l,boolean showKey) {
		Map<K, V> m;
		for(int i =0 ; i< l.size() ; i++){
			System.out.println("part" + i + "  ---------------------------->");
			m = l.get(i);
			for(Entry<K,V> ei : m.entrySet()){
				if(showKey)
					System.out.println(ei.getKey() + " --> " + UtilString.toStr(ei.getValue()));
				else
					System.out.println(UtilString.toStr(ei.getValue()));
			}
			System.out.println("part" + i + "  <----------------------------\n\n\n\n");
			
		}
		
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 把map里的value值toString()后存入List中,返回list;
	 * </ul>
	 * @param map
	 * @return
	 */
	public static <K,V> List<V> transMaptoList(Map<K,V> map) {
		List<V> l = new ArrayList<>();
		for(Entry<K,V> ei : map.entrySet()){
			l.add(ei.getValue());
		}
		return l;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
 	 * 进行包含匹配,获取匹配到包含start之后到end之间的所有list元素 <br/>
	 * 每完成一次start ~ end匹配 ,将结果存放到一个LinkedHashMap里<br/>
	 * 再把这个Map放到List里返回.<br/>
	 * </ul>
	 * @param stringList 需要进行解析的List<String>
	 * @param start 开始标识
	 * @param end 结束标识
	 * @return 
	 */
	public static List<Map<Integer,String>>selectLineBetween(List<String> stringList, String start,
			String end) {
		return selectLineBetween(stringList,start,end,false);
		
	}
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取stringList中,匹配正则表达式startRegex之后到endRegex之间的所有句子<br/>
	 * 每完成一次start ~ end匹配 ,将结果存放到一个LinkedHashMap里<br/>
	 * 再把这个Map放到List里返回.<br/>
	 * </ul>
	 * @param stringList 需要进行解析的List<String>
	 * @param startRegex 开始标识
	 * @param endRegex 结束标识
	 * @return 
	 */
	public static List<Map<Integer,String>> selectLineBetweenRegx(List<String> stringList, String startRegex,
			String endRegex) {
		return selectLineBetween(stringList,startRegex,endRegex,true);
		
	}
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * isRegx为true : 进行正则匹配,获取start上后到end之间的所有list元素.<br/>
	 * isRegx为false : 进行包含匹配,获取匹配到包含start之后到end之间的所有list元素 <br/>
	 * 每完成一次start ~ end匹配 ,将结果存放到一个LinkedHashMap里<br/>
	 * 再把这个Map放到List里返回.<br/>
	 * </ul>
	 * @param stringList 需要进行解析的List<String>
	 * @param start 开始标识
	 * @param end 结束标识
	 * @param isRegx 是否正则匹配
	 * @return
	 */
	private static List<Map<Integer,String>> selectLineBetween(
			List<String> stringList, String start, String end,
			boolean isRegx) {
		List<Map<Integer,String>> l = new ArrayList<Map<Integer,String>>();
		
		boolean isInner = false;
		Map<Integer,String> m = null;
		String si =null;
		if(!isRegx){
			start = ".*" + start +".*";
			end = ".*" + end +".*";
		}
		
		for(int i = 0; i < stringList.size() ; i ++){
			si = stringList.get(i);
			if(!isInner){
				if(UtilString.matchAllSameRegx(si, start)){
					isInner = true;
					m = new LinkedHashMap<Integer, String>();
					m.put(i, si);
				}
			}else{
				m.put(i, si);
				if(UtilString.matchAllSameRegx(si, end)){
					isInner = false;
					l.add(m);
				}
			}
			
		}
		
		return l;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 把list转为一个字符串(用toString的方法)
	 * </ul>
	 * @param stringList
	 * @return
	 */
	public static <T> String transListToLine(List<T> stringList) {
		StringBuffer sb = new StringBuffer();
		for(T si : stringList){
			sb.append(UtilString.toStr(si));
		}
		return sb.toString();
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 打印List中每一行<br/>
	 * </ul>
	 * @param lm
	 */
	public static <T> void print(List<T> lm) {
		for(Object oi : lm){
			System.out.println(oi);
		}
	}
	
	/**
	 * 判断前一个数组中是否含有后一个元素
	 * @param arr
	 * @param elem
	 * @return
	 */
	public static <T> boolean inArr(T[] arr, T elem) {
		boolean b = false;
		if(!UtilCollection.notNullEmpty(arr))
			return false;
		for(T i : arr){
			if(i != null && i.equals(elem)){
				b = true ;
				break;
			}
		}
		return b;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 判断arr非null非空<br/>
	 * </ul>
	 * @param arr
	 * @return true 如果非null非空
	 */
	private static <T> boolean notNullEmpty(T[] arr) {
		return arr != null && arr.length > 0;
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 判断list里是否包含str
	 * </ul>
	 * @param list
	 * @param str
	 */
	public static <T> boolean inList(List<T> list, T str) {
		return inArr(list.toArray(), str);
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 判断containWords里的字符串,si里是否都含有!
	 * </ul>
	 * @param containWords
	 * @param si
	 * @return
	 */
	public static boolean containAll(String[] containWords, String si) {
		boolean b = true;
		for(String i : containWords){
			if(!si.contains(i))
				b = false;
		}
		return b;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 深度拷贝List,返回一个新的list
	 * </ul>
	 * @param list
	 * @return
	 */
	public static <T> List<T> deepCopyList(List<T> list) {
		List<T> l = new ArrayList<>();
		for(T i : list){
			l.add(i);
		}
		return l;
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 把arr里存放的数组合并为一个<br/>
	 * </ul>
	 * @param 要合并为一个的数组的数组
	 * @return
	 */
	public static <T> T[] combineArray(T[][] arr) {
		if(!(arr!=null && arr.length >0))
			return null;
		int length = 0;
		for(int i = 0; i<arr.length ;i++){
			length += arr[i].length;
		}
		T[] re = Arrays.copyOf(arr[0], length);
		int nodePostion = arr[0].length;
		for(int i = 1 ;i<arr.length;i++){
			System.arraycopy(arr[i], 0, re, nodePostion, arr[i].length);
			nodePostion += arr[i].length;
		}
		return re;
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>s
	 * 把 List l里存放的数组合并为一个<br/>
	 * </ul>
	 * @param l 要合并为一个的数组的集合
	 * @return
	 */
	public static Object[] combineArray(List<Object[]> l) {
		Object[][] objArr = new Object[l.size()][];
		for(int i =0 ;i < l.size();i++){
			objArr[i] = l.get(i);
		}
		return combineArray(objArr);
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 深度拷贝一个Map.<br/>
	 * </ul>
	 * @param map
	 * @return
	 */
	public static <K,V> Map<K,V> deepCopyMap(Map<K, V> map) {
		Map<K,V> m = new HashMap<>();
		for(Map.Entry<K,V> e : map.entrySet()){
			m.put(e.getKey(), e.getValue());
		}
		return m;
	}


	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 用一个key从几个Map中获取一个value.<br/>
	 * </ul>
	 * @param key
	 * @param maps
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <K,V> V getValue(K key, Map<K,V>... maps) {
		V value = null;
		if(UtilCollection.notNullEmpty(maps))
			return value;
		for(Map<K,V> m : maps){
			value = m.get(key);
			if(value != null)
				break;
		}
		return value;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param listOrigin
	 * @param start
	 * @param end
	 * @param ListRep
	 * @return
	 */
	public static <T> List<T> replaceList(List<T> listOrigin,int start,int end,List<T> ListRep){
		List<T> l = new ArrayList<T>();
		l.addAll(listOrigin.subList(0, start+1));
		l.addAll(ListRep);
		l.addAll(listOrigin.subList(end, listOrigin.size()));
		return l;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 数组笛卡尔合并。
	 * </ul>
	 * @param sArr1
	 * @param sArr2
	 * @return
	 */
	public static String[] dikaer(String[] sArr1, String[] sArr2) {
		List<String> l = new ArrayList<String>();
		for(String si:sArr1){
			for(String sj:sArr2){
				l.add(si+sj);
			}
		}
		String[] sArr = new String[l.size()];
		for(int i=0;i<l.size();i++){
			sArr[i]=l.get(i);
		}
		return sArr;
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 将键值对value保存到 map<String,List>里 key对应的list里面。<br/>
	 * 没有list则新建一个。
	 * </ul>
	 * @param m
	 * @param representId
	 * @param ei
	 */
	public static <K,V> void put2MapList(Map<K,List<V>> map, K key, V value) {
		List<V> list = map.get(key);
		if(null == list){
			list = new ArrayList<>();
			map.put(key, list);
		}
		list.add(value);
		
	}

	/**
	 * 从sArr里获取位置是i大的元素，元素长度不够时返回默认值。
	 * @param sArr
	 * @param i
	 * @param defaultVal
	 * @return
	 */
	public static String getFromArr(String[] sArr, int i, String defaultVal) {
		if(i > sArr.length - 1)
			return defaultVal;
		else
			return sArr[i];
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 将List转为数组。
	 * </ul>
	 * @param list
	 * @return
	 */
	public static <T> T[]  transListToArr(List<T> list,T[] tArr) {
		tArr = list.toArray(tArr);
		return tArr;
	}

	/**
	 * 从list中移除positions中位置所指的元素。
	 * @param list
	 * @param positions
	 * @return
	 */
	public static <T> List<T> listRemoveElem(List<T> list, Integer... positions) {
		List<T> reList = new ArrayList<T>();
		for(int i =0 ;i < list.size();i++){
			if(!UtilCollection.isIn(positions,i))
				reList.add(list.get(i));
		}
		return reList;
	}

	/**
	 * 判断elem是否在arr中。
	 * @param arr
	 * @param elem
	 * @return
	 */
	public static boolean isIn(Object[] arr, Object elem) {
		boolean isIn = false;
		for(Object obj :arr){
			
			if(null == obj && null == elem){
				isIn = true;
				break;
			}
			if(null != obj && obj.equals(elem)){
				isIn = true;
				break;
			}
		}
		return isIn;
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param l
	 * @param str
	 * @return 
	 */
	public static List<String> addToList(List<String> l, String str) {
		if(!UtilCollection.inList(l, str))
			l.add(str);
		return l;
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 从map中取出键key对应的值，没有的话返回默认值<br/>
	 * </ul>
	 * @param map
	 * @param key
	 * @param defaultVal
	 * @return 
	 */
	public static <K,V> V getValue(Map<K, V> map, K key, V defaultVal) {
		V res = null;
		try {
			res = map.get(key);
			if(null == res)
				res = defaultVal;
		} catch (Exception e) {
			res = defaultVal;
		}
		return res;
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 验证list非null、非空
	 * </ul>
	 * @param list
	 * @return 
	 */
	public static <T> boolean notNullEmpty(List<T> list) {
		return list != null && list.size() > 0;
	}
	
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param list
	 * @param variableName
	 * @param sortWay
	 * @return 
	 */
	@SuppressWarnings("unchecked")
	public static <T> List<T> sort(List<T> list,
			String variableName, SortWay sortWay) {
		if(!notNullEmpty(list))
			return list;
		Field field = null;
		try {
			field = list.get(0).getClass().getDeclaredField(variableName);
			field.setAccessible(true);
		} catch (Exception e) {
			return list;
		}
		Object[] reArr = list.toArray();
		try {
			for(int i = 0 ; i <reArr.length - 1 ; i++){
				for(int j = reArr.length - 1 ; j > i ; j--){
					Double dj1 = new Double(UtilString.toStr(field.get(reArr[j-1])));
					Double dj = new Double(UtilString.toStr(field.get(reArr[j])));
					if(SortWay.ASC == sortWay){
						if(dj1 > dj){
							Object temp = reArr[j-1];
							reArr[j-1] =  reArr[j];
							reArr[j] = temp;
						}
					}else{
						if(dj1 < dj){
							Object temp = reArr[j-1];
							reArr[j-1] =  reArr[j];
							reArr[j] = temp;
						}
					}
					
				}
			}
			
		} catch (Exception e) {
			return list;
		}
		List<T> resList = new ArrayList<T>();
		for(Object oi : reArr){
			resList.add((T)oi);
		}
		return resList;
	}
	
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 根据时间类型排序，包括Date、Timestamp类型。
	 * </ul>
	 * @param list
	 * @param variableName
	 * @param sortWay
	 * @return 
	 */
	@SuppressWarnings("unchecked")
	public static <T> List<T> sortByTime(List<T> list,
			String variableName, SortWay sortWay) {

		if(!notNullEmpty(list))
			return list;
		Field field = null;
		try {
			field = list.get(0).getClass().getDeclaredField(variableName);
			field.setAccessible(true);
		} catch (Exception e) {
			return list;
		}
		Object[] reArr = list.toArray();
		try {
			for(int i = 0 ; i <reArr.length - 1 ; i++){
				for(int j = reArr.length - 1 ; j > i ; j--){
					Long dj1 = UtilDate.getLongTime((Date)field.get(reArr[j-1]));
					Long dj = UtilDate.getLongTime((Date)field.get(reArr[j]));
					
					if(SortWay.ASC == sortWay){
						if(dj1 > dj){
							Object temp = reArr[j-1];
							reArr[j-1] =  reArr[j];
							reArr[j] = temp;
						}
					}else{
						if(dj1 < dj){
							Object temp = reArr[j-1];
							reArr[j-1] =  reArr[j];
							reArr[j] = temp;
						}
					}
					
				}
			}
			
		} catch (Exception e) {
			return list;
		}
		List<T> resList = new ArrayList<T>();
		for(Object oi : reArr){
			resList.add((T)oi);
		}
		return resList;
	
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 如果第一个值为null,就选择后面的,下一个为null 就依次再选后面的<br/>
	 * </ul>
	 * @param val1
	 * @param vals
	 * @return 
	 */
	@SuppressWarnings("unchecked")
	public static <T> T nullChoose(T... vals) {
		T res = null;
		if(!UtilCollection.notNullEmpty(vals))
			return null;
		for(T ti: vals){
			if(ti != null){
				res = ti;
				break;
			}
		}
		return res;
	}
	
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 检查objs全部不为null
	 * </ul>
	 * @param objs
	 * @return 
	 */
	public static boolean notNull(Object... objs) {
		if(objs == null)
			return false;
		boolean isTrue = true;
		for(Object oi : objs){
			if(oi == null){
				isTrue = false;
				break;
			}
		}
		return isTrue;
	}
	
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 *  过滤出成员变量的值在某一范围的元素，返回其集合<br/>
	 *  范围类型可为日期或者数字<br/>
	 *  filterMap<key,value> = [变量名，变量范围数组(长度2、其一可为null)]<br/>
	 * 为null表示∞
	 * </ul>
	 * @param list
	 * @param filterMap
	 * @return 
	 */
	public static <T> List<T> filterListRange(List<T> list, Map<String, Object[]> filterMap) {
		List<T> resList = new ArrayList<T>();
		if(!UtilCollection.notNullEmpty(list))
			return resList;
		try {
			//获取成员变量,值map
			Map<Field,Object[]> fieldMap = new HashMap<Field,Object[]>();
			for(Entry<String,Object[]> ei : filterMap.entrySet()){
				Field field = list.get(0).getClass().getDeclaredField(ei.getKey());
				fieldMap.put(field,ei.getValue());
			}
			//遍历对象，进行过滤
			for(T ti : list){
				boolean isAllIn = true;
				for(Entry<Field,Object[]> ei : fieldMap.entrySet()){
					if(!UtilCollection.isInRange(ti,ei.getKey(),ei.getValue())){
						isAllIn = false;
						break;
					}
				}
				if(isAllIn)
					resList.add(ti);
			}
			
		} catch (Exception e) {
			System.out.println(String.format("以范围方式过滤list集合失败。过滤数据：\n%s\n过滤map：\n%s", list,filterMap));
		}
		return resList;
	}
	
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 判断对象obj的field成员变量的值是否在range中，如果的话返回true；<br/>
	 * 区间一边null则表示那边到∞<br/>
	 * 以左闭右开方式比较.
	 * </ul>
	 * @param obj 对象
	 * @param field 成员变量名
	 * @param range 范围
	 * @return
	 */
	public static boolean isInRange(Object obj,Field field,Object[] range){
		try {
			field.setAccessible(true);
			if(range[0] == null && range[1] == null)
				throw new RuntimeException(String.format("变量的范围有误，区间两边至多一方为null，对象：\n%s\n变量名:\n%s\n范围:\n%s",
						obj.getClass().getName(),field.getName(),range));
		} catch (Exception e) {
			return false;
		}
		
		//是数字类型
		boolean left = false;
		boolean right = false;
		try {
			boolean leftIsNum = UtilString.isNumber(range[0]),
					rightIsNum = UtilString.isNumber(range[1]);
			//如果两端都不是数字说明不是数字类型
			if(!(leftIsNum || rightIsNum))
				throw new RuntimeException(String.format("成员变量【%s】非数字类型", field.getName()));
			Double variableValue = null;
			if(range[0] == null)
				left = true;
			else if(range[1] == null)
				right = true;
			if(leftIsNum){
				Double range0 = UtilString.toDouble(range[0]);
				variableValue = UtilString.toDouble(field.get(obj));
				left = range0 <= variableValue;
			}
			
			if(rightIsNum){
				Double range1 = UtilString.toDouble(range[1]);
				variableValue = UtilString.toDouble(field.get(obj));
				right = range1 > variableValue;
			}
			return left && right;
		} catch (Exception e) {
		}
		
		//是日期类型
		try {
			boolean leftIsDate = UtilDate.isDate(range[0]),
					rightIsDate = UtilDate.isDate(range[1]);
			if(!(leftIsDate || rightIsDate))
				throw new RuntimeException(String.format("成员变量【%s】非日期类型", field.getName()));
			
			Date variableValue = null;
			
			if(range[0] == null)
				left = true;
			else if(range[1] == null)
				right = true;
			
			if(leftIsDate){
				Date range0 = (Date)range[0];
				variableValue = (Date)field.get(obj);
				left = range0.compareTo(variableValue) <= 0 ;
			}
			
			if(rightIsDate){
				Date range1 = (Date)range[1];
				variableValue = (Date)field.get(obj);
				right = range1.compareTo(variableValue) > 0 ;
			}
			
			return left && right;
		} catch (Exception e) {
		}
		
		return false;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 将list里的内容根据成员变量varialbe的值进行分组。<br/>
	 * </ul>
	 * @param list 需要分组的对象List
	 * @param varialbe 成员变量名
	 * @param clazz 成员变量类型
	 * @return 
	 */
	@SuppressWarnings("unchecked")
	public static <T,V> Map<T, List<V>> list2Map(List<V> list, String varialbe,Class<T> clazz) {
		Map<T, List<V>> map = new HashMap<T, List<V>>();
		if(!UtilCollection.notNullEmpty(list))
			return map;
		try {
			Field field = list.get(0).getClass().getDeclaredField(varialbe);
			field.setAccessible(true);
			for(V po : list){
				T key = (T)field.get(po);
				put2MapList(map,key,po);
			}
			
		} catch (Exception e) {
			System.out.println(String.format("拆分分组List失败：\n分组成员变量名：%s\n类型：%s", varialbe,clazz.getName()));
		}
		return map;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 查找出list中变量满足filterMap键值对要求的对象(只找一个)。<br/>
	 * </ul>
	 * @param list
	 * @param filterMap
	 * @return 
	 */
	public static <T> T filter(List<T> list,Map<String, Object> filterMap) {
		try {
			List<T> reslist = filterComprehensive(list,filterMap,true);
			if(reslist.size() == 0)
				return null;
			else
				return reslist.get(0);
		} catch (Exception e) {
			System.out.println(String.format("未过滤出正确数据，过滤对象类型:%s\n过滤条件filterMap：%s", UtilCollection.getClassByList(list) ,filterMap));
			return null;
		}
		
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 查找出list中满足filterMap键值对要求的对象(全部)。<br/>
	 * </ul>
	 * @param list
	 * @param filterMap
	 * @return 
	 */
	public static <T> List<T> filterList(List<T> list,Map<String, Object> filterMap) {
		return filterComprehensive(list,filterMap,false);
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param list
	 * @param filterMap
	 * @param isOne 是否只找一个
	 * @return
	 */
	private static <T> List<T> filterComprehensive(List<T> list,Map<String, Object> filterMap,boolean isOne){
		List<T> resList = new ArrayList<T>();
		if(!UtilCollection.notNullEmpty(list))
			return resList;
		//初始化map
		Map<Field,Object> fieldMap = new HashMap<Field, Object>();
		try {
			for(Entry<String, Object> ei : filterMap.entrySet()){
				Object obj = list.get(0);
				Field field = obj.getClass().getDeclaredField(ei.getKey());
				field.setAccessible(true);
				fieldMap.put(field, ei.getValue());
			}
			for( T ti : list){
				boolean isAllEqual = true;
				for(Entry<Field,Object> ei : fieldMap.entrySet()){
					Object val = ei.getKey().get(ti);
					if(!UtilString.equal(val,ei.getValue())){
						isAllEqual = false;
						break;
					}
				}
				if(isAllEqual){
					resList.add(ti);
					if(isOne)
						break;
				}
			}
		} catch (Exception e) {
			StringBuffer sb = new StringBuffer();
			for(Entry<String, Object> ei : filterMap.entrySet()){
				sb.append(ei.getKey()).append(" = ").append(ei.getValue());
			}
			System.out.println(String.format("过滤对象出现异常：\n%s", sb.toString()));
		}
			
		return resList;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取泛型list里值的类对象<br/>
	 * 前提是list有元素存在，如果没有则返回null
	 * </ul>
	 * @param list
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static <T> Class getClassByList(List<T> list){
		Class clazz = null;
		if(notNullEmpty(list))
			clazz = list.get(0).getClass();
		return clazz;
	}
}
