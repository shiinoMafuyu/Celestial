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
	 * <b>����˵����</b>
	 * <ul>
	 * ��ӡmap
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
	 * <b>����˵����</b>
	 * <ul>
	 * ������ʾList<Map<Integer,String>> ����鷳ÿ��ȥд;<br/>
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
	 * <b>����˵����</b>
	 * <ul>
	 * ��map���valueֵtoString()�����List��,����list;
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
	 * <b>����˵����</b>
	 * <ul>
 	 * ���а���ƥ��,��ȡƥ�䵽����start֮��end֮�������listԪ�� <br/>
	 * ÿ���һ��start ~ endƥ�� ,�������ŵ�һ��LinkedHashMap��<br/>
	 * �ٰ����Map�ŵ�List�ﷵ��.<br/>
	 * </ul>
	 * @param stringList ��Ҫ���н�����List<String>
	 * @param start ��ʼ��ʶ
	 * @param end ������ʶ
	 * @return 
	 */
	public static List<Map<Integer,String>>selectLineBetween(List<String> stringList, String start,
			String end) {
		return selectLineBetween(stringList,start,end,false);
		
	}
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ��ȡstringList��,ƥ��������ʽstartRegex֮��endRegex֮������о���<br/>
	 * ÿ���һ��start ~ endƥ�� ,�������ŵ�һ��LinkedHashMap��<br/>
	 * �ٰ����Map�ŵ�List�ﷵ��.<br/>
	 * </ul>
	 * @param stringList ��Ҫ���н�����List<String>
	 * @param startRegex ��ʼ��ʶ
	 * @param endRegex ������ʶ
	 * @return 
	 */
	public static List<Map<Integer,String>> selectLineBetweenRegx(List<String> stringList, String startRegex,
			String endRegex) {
		return selectLineBetween(stringList,startRegex,endRegex,true);
		
	}
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * isRegxΪtrue : ��������ƥ��,��ȡstart�Ϻ�end֮�������listԪ��.<br/>
	 * isRegxΪfalse : ���а���ƥ��,��ȡƥ�䵽����start֮��end֮�������listԪ�� <br/>
	 * ÿ���һ��start ~ endƥ�� ,�������ŵ�һ��LinkedHashMap��<br/>
	 * �ٰ����Map�ŵ�List�ﷵ��.<br/>
	 * </ul>
	 * @param stringList ��Ҫ���н�����List<String>
	 * @param start ��ʼ��ʶ
	 * @param end ������ʶ
	 * @param isRegx �Ƿ�����ƥ��
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
	 * <b>����˵����</b>
	 * <ul>
	 * ��listתΪһ���ַ���(��toString�ķ���)
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
	 * <b>����˵����</b>
	 * <ul>
	 * ��ӡList��ÿһ��<br/>
	 * </ul>
	 * @param lm
	 */
	public static <T> void print(List<T> lm) {
		for(Object oi : lm){
			System.out.println(oi);
		}
	}
	
	/**
	 * �ж�ǰһ���������Ƿ��к�һ��Ԫ��
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
	 * <b>����˵����</b>
	 * <ul>
	 * �ж�arr��null�ǿ�<br/>
	 * </ul>
	 * @param arr
	 * @return true �����null�ǿ�
	 */
	private static <T> boolean notNullEmpty(T[] arr) {
		return arr != null && arr.length > 0;
	}

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * �ж�list���Ƿ����str
	 * </ul>
	 * @param list
	 * @param str
	 */
	public static <T> boolean inList(List<T> list, T str) {
		return inArr(list.toArray(), str);
	}
	
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * �ж�containWords����ַ���,si���Ƿ񶼺���!
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
	 * <b>����˵����</b>
	 * <ul>
	 * ��ȿ���List,����һ���µ�list
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
	 * <b>����˵����</b>
	 * <ul>
	 * ��arr���ŵ�����ϲ�Ϊһ��<br/>
	 * </ul>
	 * @param Ҫ�ϲ�Ϊһ�������������
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
	 * <b>����˵����</b>
	 * <ul>s
	 * �� List l���ŵ�����ϲ�Ϊһ��<br/>
	 * </ul>
	 * @param l Ҫ�ϲ�Ϊһ��������ļ���
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
	 * <b>����˵����</b>
	 * <ul>
	 * ��ȿ���һ��Map.<br/>
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
	 * <b>����˵����</b>
	 * <ul>
	 * ��һ��key�Ӽ���Map�л�ȡһ��value.<br/>
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
	 * <b>����˵����</b>
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
	 * <b>����˵����</b>
	 * <ul>
	 * ����ѿ����ϲ���
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
	 * <b>����˵����</b>
	 * <ul>
	 * ����ֵ��value���浽 map<String,List>�� key��Ӧ��list���档<br/>
	 * û��list���½�һ����
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
	 * ��sArr���ȡλ����i���Ԫ�أ�Ԫ�س��Ȳ���ʱ����Ĭ��ֵ��
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
	 * <b>����˵����</b>
	 * <ul>
	 * ��ListתΪ���顣
	 * </ul>
	 * @param list
	 * @return
	 */
	public static <T> T[]  transListToArr(List<T> list,T[] tArr) {
		tArr = list.toArray(tArr);
		return tArr;
	}

	/**
	 * ��list���Ƴ�positions��λ����ָ��Ԫ�ء�
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
	 * �ж�elem�Ƿ���arr�С�
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
	 * <b>����˵����</b>
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
	 * <b>����˵����</b>
	 * <ul>
	 * ��map��ȡ����key��Ӧ��ֵ��û�еĻ�����Ĭ��ֵ<br/>
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
	 * <b>����˵����</b>
	 * <ul>
	 * ��֤list��null���ǿ�
	 * </ul>
	 * @param list
	 * @return 
	 */
	public static <T> boolean notNullEmpty(List<T> list) {
		return list != null && list.size() > 0;
	}
	
	
	/**
	 * <b>����˵����</b>
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
	 * <b>����˵����</b>
	 * <ul>
	 * ����ʱ���������򣬰���Date��Timestamp���͡�
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
	 * <b>����˵����</b>
	 * <ul>
	 * �����һ��ֵΪnull,��ѡ������,��һ��Ϊnull ��������ѡ�����<br/>
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
	 * <b>����˵����</b>
	 * <ul>
	 * ���objsȫ����Ϊnull
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
	 * <b>����˵����</b>
	 * <ul>
	 *  ���˳���Ա������ֵ��ĳһ��Χ��Ԫ�أ������伯��<br/>
	 *  ��Χ���Ϳ�Ϊ���ڻ�������<br/>
	 *  filterMap<key,value> = [��������������Χ����(����2����һ��Ϊnull)]<br/>
	 * Ϊnull��ʾ��
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
			//��ȡ��Ա����,ֵmap
			Map<Field,Object[]> fieldMap = new HashMap<Field,Object[]>();
			for(Entry<String,Object[]> ei : filterMap.entrySet()){
				Field field = list.get(0).getClass().getDeclaredField(ei.getKey());
				fieldMap.put(field,ei.getValue());
			}
			//�������󣬽��й���
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
			System.out.println(String.format("�Է�Χ��ʽ����list����ʧ�ܡ��������ݣ�\n%s\n����map��\n%s", list,filterMap));
		}
		return resList;
	}
	
	
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * �ж϶���obj��field��Ա������ֵ�Ƿ���range�У�����Ļ�����true��<br/>
	 * ����һ��null���ʾ�Ǳߵ���<br/>
	 * ������ҿ���ʽ�Ƚ�.
	 * </ul>
	 * @param obj ����
	 * @param field ��Ա������
	 * @param range ��Χ
	 * @return
	 */
	public static boolean isInRange(Object obj,Field field,Object[] range){
		try {
			field.setAccessible(true);
			if(range[0] == null && range[1] == null)
				throw new RuntimeException(String.format("�����ķ�Χ����������������һ��Ϊnull������\n%s\n������:\n%s\n��Χ:\n%s",
						obj.getClass().getName(),field.getName(),range));
		} catch (Exception e) {
			return false;
		}
		
		//����������
		boolean left = false;
		boolean right = false;
		try {
			boolean leftIsNum = UtilString.isNumber(range[0]),
					rightIsNum = UtilString.isNumber(range[1]);
			//������˶���������˵��������������
			if(!(leftIsNum || rightIsNum))
				throw new RuntimeException(String.format("��Ա������%s������������", field.getName()));
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
		
		//����������
		try {
			boolean leftIsDate = UtilDate.isDate(range[0]),
					rightIsDate = UtilDate.isDate(range[1]);
			if(!(leftIsDate || rightIsDate))
				throw new RuntimeException(String.format("��Ա������%s������������", field.getName()));
			
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
	 * <b>����˵����</b>
	 * <ul>
	 * ��list������ݸ��ݳ�Ա����varialbe��ֵ���з��顣<br/>
	 * </ul>
	 * @param list ��Ҫ����Ķ���List
	 * @param varialbe ��Ա������
	 * @param clazz ��Ա��������
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
			System.out.println(String.format("��ַ���Listʧ�ܣ�\n�����Ա��������%s\n���ͣ�%s", varialbe,clazz.getName()));
		}
		return map;
	}
	
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ���ҳ�list�б�������filterMap��ֵ��Ҫ��Ķ���(ֻ��һ��)��<br/>
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
			System.out.println(String.format("δ���˳���ȷ���ݣ����˶�������:%s\n��������filterMap��%s", UtilCollection.getClassByList(list) ,filterMap));
			return null;
		}
		
	}
	
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ���ҳ�list������filterMap��ֵ��Ҫ��Ķ���(ȫ��)��<br/>
	 * </ul>
	 * @param list
	 * @param filterMap
	 * @return 
	 */
	public static <T> List<T> filterList(List<T> list,Map<String, Object> filterMap) {
		return filterComprehensive(list,filterMap,false);
	}
	
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param list
	 * @param filterMap
	 * @param isOne �Ƿ�ֻ��һ��
	 * @return
	 */
	private static <T> List<T> filterComprehensive(List<T> list,Map<String, Object> filterMap,boolean isOne){
		List<T> resList = new ArrayList<T>();
		if(!UtilCollection.notNullEmpty(list))
			return resList;
		//��ʼ��map
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
			System.out.println(String.format("���˶�������쳣��\n%s", sb.toString()));
		}
			
		return resList;
	}
	
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ��ȡ����list��ֵ�������<br/>
	 * ǰ����list��Ԫ�ش��ڣ����û���򷵻�null
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
