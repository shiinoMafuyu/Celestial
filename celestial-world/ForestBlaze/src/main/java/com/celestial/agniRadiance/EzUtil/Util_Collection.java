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
	 * <b>方法说明：</b>
	 * <ul>
	 * 打印map
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
	 * <b>方法说明：</b>
	 * <ul>
	 * 用于显示List<Map<Integer,String>> 免得麻烦每次去写;<br/>
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
	 * <b>方法说明：</b>
	 * <ul>
	 * 把map里的value值toString()后存入List中,返回list;
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
	 * <b>方法说明：</b>
	 * <ul>
	 * 把list转为一个字符串(用toString的方法)
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
	 * <b>方法说明：</b>
	 * <ul>
	 * 打印List中每一行<br/>
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
	 * 判断前一个数组中是否含有后一个元素
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
	 * <b>方法说明：</b>
	 * <ul>
	 * 判断list里是否包含str
	 * </ul>
	 * @param list
	 * @param str
	 */
	public static boolean contain(List<String> list, String str) {
		return contain(list.toArray(), str);
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static List deepCopyList(List list) {
		List l = new ArrayList();
		for(Object i : list){
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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Map deepCopyMap(
			Map<Object, Object> map) {
		//没法用Object向上造型,没法泛型,不知道怎么获取传进来的是HashMap还是LinkedHashMap.通用性仅限于String,String我也是醉了
		//HashMap这点好像没法了 有需要可以加上其他比如LinkedHashMap的支持.
		//然后造型那个真是醉了,只要定义Map时不加上类型就行,后面的HashMap<>类型随便写,最后返回值也能自动转型过去= =.
		//泛型之泛进来泛出去.
		Map m = new HashMap();
		for(Map.Entry e : map.entrySet()){
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
	 * 从list中移除positions中位置所指的元素。
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

	
	
	
}
