package com.celestial.agniRadiance.EzUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Util_Collection {
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ��ӡmap
	 * </ul>
	 * @param map
	 */
	public static void printMap(Map<String, String> map) {
		StringBuffer sb = null;
		for(Entry<String, String> ei : map.entrySet()){
			sb = new StringBuffer();
			sb.append(ei.getKey()).append(" = ").append(ei.getValue());
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
	@SuppressWarnings("rawtypes")
	public static void printListMap(List<Map<Integer, String>> l,boolean showKey) {
		Map<Integer, String> m;
		for(int i =0 ; i< l.size() ; i++){
			System.out.println("part" + i + "  ---------------------------->");
			m = l.get(i);
			for(Entry ei : m.entrySet()){
				if(showKey)
					System.out.println(ei.getKey() + " --> " + ei.getValue());
				else
					System.out.println(ei.getValue());
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static List<String> transMaptoList(Map map) {
		List<String> l = new ArrayList<String>();
		for(Entry ei : ((Map<String,String>)map).entrySet()){
			l.add((String)ei.getValue());
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
				if(Util_String.matchAllSameRegx(si, start)){
					isInner = true;
					m = new LinkedHashMap<Integer, String>();
					m.put(i, si);
				}
			}else{
				m.put(i, si);
				if(Util_String.matchAllSameRegx(si, end)){
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
	public static String transListToLine(List<String> stringList) {
		StringBuffer sb = new StringBuffer();
		for(String si : stringList){
			sb.append(si);
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
	@SuppressWarnings("rawtypes")
	public static void print(List lm) {
		for(Object oi : lm){
			System.out.println(oi);
		}
	}
	
	/**
	 * �ж�ǰһ���������Ƿ��к�һ��Ԫ��
	 * @param objects
	 * @param object
	 * @return
	 */
	public static boolean contain(Object[] objects, Object object) {
		boolean b = false;
		try{
			for(Object i : objects){
				if(i != null && i.equals(object)){
					b = true ;
					break;
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return b;
	}
	
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * �ж�list���Ƿ����str
	 * </ul>
	 * @param list
	 * @param str
	 */
	public static boolean contain(List<String> list, String str) {
		return contain(list.toArray(), str);
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static List deepCopyList(List list) {
		List l = new ArrayList();
		for(Object i : list){
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
	public static Object[] combineArray(Object[][] arr) {
		if(!(arr!=null && arr.length >0))
			return null;
		int length = 0;
		for(int i = 0; i<arr.length ;i++){
			length += arr[i].length;
		}
		Object[] re = Arrays.copyOf(arr[0], length);
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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Map deepCopyMap(
			Map<Object, Object> map) {
		//û����Object��������,û������,��֪����ô��ȡ����������HashMap����LinkedHashMap.ͨ���Խ�����String,String��Ҳ������
		//HashMap������û���� ����Ҫ���Լ�����������LinkedHashMap��֧��.
		//Ȼ�������Ǹ���������,ֻҪ����Mapʱ���������;���,�����HashMap<>�������д,��󷵻�ֵҲ���Զ�ת�͹�ȥ= =.
		//����֮����������ȥ.
		Map m = new HashMap();
		for(Map.Entry e : map.entrySet()){
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
	@SuppressWarnings("rawtypes")
	public static String getValue(String key, Map... maps) {
		String value = null;
		for(Map m :maps){
			value = (String)m.get(key);
			if(value !=null)
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void put(Map map, String key, Object value) {
		Object oList = map.get(key);
		if(null == oList){
			oList = new ArrayList();
			map.put(key, oList);
		}
		List l = (List)oList;
		l.add(value);
		
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
	 * @param l
	 * @return
	 */
	public static String[] transListToArr(List<String> l) {
		String[] sArr = new String[l.size()];
		for(int i=0;i<l.size();i++){
			sArr[i] = l.get(i);
		}
		return sArr;
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
			if(!Util_Collection.isIn(positions,i))
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

	
	
	
}
