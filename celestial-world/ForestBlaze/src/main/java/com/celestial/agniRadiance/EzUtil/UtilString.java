package com.celestial.agniRadiance.EzUtil;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;

/**
 * <b>�޸ļ�¼��</b> 
 * <p>
 * <li>
 * 
 *                        ---- Administrator 2016-9-14
 * </li>
 * </p>
 * 
 * <b>��˵����</b>
 * <p> 
 * �ַ�����ش���<br/>
 * ��3��__������ʾ��ϸ<br/>
 * _��ʾ�м�ϸ<br/>
 * û��_��ʾ�������.
 * </p>
 */
public class UtilString {
	
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ��i����д��ĸ��ɴ�д
	 * </ul>
	 * @param str
	 * @return
	 */
	public static String transHeadToUpperCase(String str) {
		if("".equals(str))
			return "";
		return new StringBuffer(str.substring(0, 1).toUpperCase()).append(str.substring(1)).toString();
	}

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * s�Ƿ�ΪDouble
	 * </ul>
	 * @param s
	 * @return
	 */
	public static boolean isDouble(String s) {
		boolean b = true;
		try {
			Double.valueOf(s);
		} catch (Exception e) {
			b = false;
		}
		return b;
	}

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * s�Ƿ�ΪInteger
	 * </ul>
	 * @param s
	 * @return
	 */
	public static boolean isInteger(String s) {
		boolean b = true;
		try {
			Integer.valueOf(s);
		} catch (Exception e) {
			b = false;
		}
		return b;
	}
	
	/**
	 * 
	 * <b>����˵����</b>
	 * <ul>
	 * ����д��ĸ��д��Сд
	 * </ul>
	 * @param str
	 * @return
	 */
	public static String transHeadToLowerCase(String str) {
		if("".equals(str))
			return "";
		return new StringBuffer(str.substring(0, 1).toLowerCase()).append(str.substring(1)).toString();
	}
	
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ��ȡ����.
	 * </ul>
	 * @param substring
	 * @return
	 */
	public static Map<String, String> getPropertyMap(String s) {
		String sb = s.trim();
		Map<String,String> map = new LinkedHashMap<String, String>();
		try {
			s = s.trim();
			if(s != null && "".equals(s))
				return map;
			String[] sArr = s.split("\"");
			String key = "";
			for(int i = 0 ;i< sArr.length;i ++){
				if(i%2 == 0){
					key = sArr[i].substring(0, sArr[i].indexOf("=")).trim();
				}else{
					map.put(key, sArr[i]);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(new StringBuffer("�����ַ���").append(sb).append("����������!").toString());
		}
		
		return map;
	}
	
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param string
	 * @return
	 */
	public static boolean notNullEmpty(String s) {
		return s != null && !"".equals(s);
	}
	
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ��ȡs�е�һ���ַ��� ; ��"  ko ff xx" ����ko;
	 * </ul>
	 * @param s
	 * @return
	 */
	public static String getTheFirstWord(String s) {
		String st = s.trim();
		int index = st.length();
		if(st.contains(" "))
			index = st.indexOf(" ");
		return st.substring(0, index);
	}
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ���һ���ַ������Ƿ���һ�������ļ򵥱�ǩ.<br/>
	 * �����ǩ����������<br/>
	 * </ul>
	 * @param s
	 * @return
	 */
	public static int containCompleteSimpleTag(String s) {
		int n = -1;
		if(!UtilString.matchAllSameRegx(s, ".*<.*>.*<.*>.*"))
			return n;
		try {
			String headContent = s.substring(s.indexOf("<") + 1 , s.indexOf(">"));
			String tagName = UtilString.getTheFirstWord(headContent);
			String regx = ".*<\\s*"+tagName+"\\s*>[^>]*<\\s*/\\s*"+tagName+"\\s*>.*";
			if(UtilString.matchAllSameRegx(s, regx)){
				n = s.indexOf(tagName) + tagName.length();
			}
		} catch (Exception e) {
		}
		return n;
	}
	
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ������ʽƥ�俪ͷ����;
	 * </ul>
	 * @param s
	 * @param regex
	 * @return
	 */
	public static boolean matchHeadRegx(String s, String regex) {
		return matchAllSameRegx(s,regex + ".*");
	}
	
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ������ʽƥ���β��β����;
	 * </ul>
	 * @param s
	 * @param regex
	 * @return
	 */
	public static boolean matchTailRegx(String s, String regex) {
		return matchAllSameRegx(s,".*" + regex);
	}
	
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ������ʽ����λ�ð���;
	 * </ul>
	 * @param s
	 * @param regex
	 * @return
	 */
	public static boolean matchAllRegx(String s, String regex) {
		return matchAllSameRegx(s,".*" + regex + ".*");
	}
	
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * �ַ��������������ʽ��ȫһ��;
	 * <br/>
	 * <br/>
	 * <br/>
	 * ������ʽʹ��С˵��:<br/>
	 * 1			����1 <br/>
	 * . 			����һ���ַ� <br/>
	 * (��"\"��ע��ת��) <br/>
	 * \d			���� <br/>
	 * \D			������ <br/>
	 * \w			�����ַ�([a-zA-Z_0-9]) <br/>
	 * \W			�ǵ����ַ� <br/>
	 * [a-z] a ~ z 	��һ�� <br/>
	 * [^a-z]		�� a ~ z �� <br/>
	 * [0-9A-Za-z] 	0 ~ 9 , A ~ Z , a ~ z ��һ�� <br/>
	 * [a-z]{3} 	a ~ z ��3�� <br/>
	 * [a-z]* 		a ~ z ��0������ <br/>
	 * [a-z]+ 		a ~ z ��1������ <br/>
	 * [a-z]{3,5}	a ~ z ����3~5�� <br/>
	 * [a-z]{3,}	a ~ z ����3������ <br/>
	 * ^a			��a��ͷ <br/>
	 * b$			��b��β <br/>
	 * FU?			F���ֻ���FU����() <br/>
	 * a|b			a����b������һ�� <br/>
	 * (J|X){2}		J����X������һ������2��,��JJ JX XJ XX <br/>
	 * ()			��Ϊһ������ <br/>
	 * </ul>
	 * @param s
	 * @param regex
	 * @return
	 */
	public static boolean matchAllSameRegx(String s, String regex) {
		return Pattern.compile(regex).matcher(s).matches();
	}
	
	/**
	 * ȥ�����n���ַ���
	 * @param s
	 * @param n
	 * @return
	 */
	public static String subStringLast(String s,int n){
		return s.substring(0,s.length()-n);
	}

	/**
	 * ȥ����ĩβ��removeStr�ַ������û���򲻹ܡ�
	 * @param s
	 * @param removeStr
	 * @return
	 */
	public static String subStringLastChar(String s, String removeStr) {
		int lastIndex = s.lastIndexOf(removeStr);
		if(lastIndex + removeStr.length() == s.length()){
			s = s.substring(0,lastIndex);
		}
		return s;
	}

	/**
	 * ��ȡstr��className���������������
	 * @param str "className(com.dn.entity.Equipment)"
	 * @param paramName "className"
	 * @return
	 */
	public static String getLineParam(String str, String paramName) {
		String param ="";
		int index1 =  str.indexOf(paramName);
		if(index1<0)
			return param;
		int indexStart = str.indexOf("(", index1)+1;
		int indexEnd = str.indexOf(")", index1);
		try {
			param = str.substring(indexStart, indexEnd);
		} catch (Exception e) {
		}
		return param;
	}
	
	private static List<String> COLLECTION_TYPE_LIST= Arrays.asList(new String[]{"List","Map"});

	/**
	 * �жϱ�������variableType�Ƿ񼯺����� ��List ��Map<br/>
	 * (�����뵽��˵����)�ǵĻ��������͡����ǵĻ����ؿ��ַ�����
	 * @param variableType
	 * @return
	 */
	public static String isCollectionType(String variableType) {
		String type = "";
		for(String si:COLLECTION_TYPE_LIST){
			if(si.equals(variableType) || UtilString.matchAllRegx(variableType, si+"<.*>")){
				type = si;
				break;
			}
		}
		return type;
	}

	/**
	 * ȥ��list����һ������removeStr ��","<br/>
	 * ������һ���ǲ���","�ģ�����ǰ��ֱ��ȥ��һ��","�󷵻�<br/>
	 * ɾ����β��removeStr�ģ�������к����򲻹�<br/>
	 * ����ĩβ��removeStr֮���listԪ��
	 * @param list
	 * @param removeStr
	 * @return
	 */
	public static List<String> subStringLastChar(List<String> list,
			String removeStr) {
		if(!UtilCollection.notNullEmpty(list))
			return list;
		String si="";
		int colNum = 0;
		for(int i = list.size() - 1 ; i >= 0 ; i--){
			si = list.get(i);
			int lastIndex = si.lastIndexOf(removeStr);
			if(lastIndex >=0 && lastIndex + removeStr.length() == si.length()){
				si = si.substring(0,lastIndex);
				list.set(i, si);
				colNum = i;
				break;
			}
		}
		
		return list.subList(0, colNum + 1);
	}

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ��s��ȡ������sign֮��Ĳ��֡�<br/>
	 * �磺ez.EzUtil.Util_Stringȡ������.֮��ģ���ΪUtil_String��
	 * </ul>
	 * @param s
	 * @param sign 
	 * @return
	 */
	public static String getStrAfterLast(String s, String sign) {
		return s.substring(s.lastIndexOf(sign) + sign.length());
	}

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ��s�л�ȡ���һ��sign֮ǰ���ַ�����
	 * </ul>
	 * @param s
	 * @param sign
	 * @return
	 */
	public static String getStrBeforeLast(String s, String sign) {
		return s.substring(0, s.lastIndexOf(sign));
	}

	/**
	 * ���س���Ϊn���Ʊ����<br/>
	 * @param n
	 * @return
	 */
	public static String createTabs(int n) {
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<n;i++){
			sb.append("	");
		}
		return sb.toString();
	}

	/**
	 * �ж�c�Ƿ���Ӣ����ĸ
	 * @param c
	 * @return
	 */
	public static boolean isEnglishChar(char c) {
		if((c>=65 && c<=90) || (c>=97 && c<=1222)){
			return true;
		}
		return false;
	}

	/**
	 * ��ʽ��·���ַ�����
	 * @param path
	 * @return
	 */
	public static String fmtPathStr(String path) {
		return path.replaceAll("\\\\", "/");
	}

	/**
	 * ����n���ظ���str���ϲ�Ϊһ���ַ�����
	 * @param str
	 * @param n
	 * @return
	 */
	public static String nstr(String str, int n) {
		StringBuffer sb = new StringBuffer();
		for(int i = 0 ; i< n ; i++){
			sb.append(str);
		}
		return sb.toString();
	}

	/**
	 * ��������ַ���str����n֮����match1��match2֮����ַ���<br/>
	 * ���磺
	 * getMatchIn("name = 'kurise',name = 'miki'; yesterday once more.","'",";",20)
	 * --> miki'
	 * @param str
	 * @param match1
	 * @param match2
	 * @param n
	 * @return
	 */
	public static String getMatchIn(String str,String match1,String match2,int n) {
		str = str.substring(n);
		int index1 = str.indexOf(match1);
		int index2 = str.indexOf(match2,index1+1);
		return str.substring(index1+1, index2);
	}

	/**
	 * �ж���Ԫ���Ƿ����<br/>
	 * @param obj1
	 * @param obj2
	 * @return
	 */
	public static boolean equal(Object obj1, Object obj2) {
		if(obj1 == null)
			if(obj2 == null)
				return true;
			else
				return false;
		return obj1.equals(obj2);
	}

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ��ȡ��n��ʼ��match1����֮��Ե�match2֮����ַ���<br/>
	 * ������match1,match2<br/>
	 * eg��
	 * getMatchIn2("0123+(5 * 6 - ( 4* 2 - 3/ (3+1)) + 3 /( 3 * 1))" , "(" , ")" , 6) -- >  " 4* 2 - 3/ (3+1)"
	 * </ul>
	 * @param str
	 * @param match1
	 * @param match2
	 * @param n
	 * @return 
	 */
	public static String getMatchIn2(String str, String match1, String match2, int n) {
		str = str.substring(n);
		int index1 = str.indexOf(match1);
		int index2 = -1;
		
		int deepth = 0;
		Integer index = index1;
		
		while(index < str.length()){
			String minMatch = getMinMatch(str,index,match1,match2);
			index = str.indexOf(minMatch,index);
			if(match1.equals(minMatch)){//�����match1ƥ����� -1,�����match2ƥ����� +1.���Ϊ0ʱ���ҵ��͵�һ��match1��Ե�match2�ˡ�
				deepth--;
			}else{
				deepth++;
			}
			if(deepth == 0){
				index2 = index;
				break;
			}else{
				index += minMatch.length();
			}
		}
		
		String res = null;
		if(index2 >= 0){
			res = subString(str, index1 + 1, index2);
		}else{
			res = subString(str, index1 + 1, str.length());
		}
		
		return res;
	}
	
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ��ȡ��index��ʼ,ƥ��ƥ��ֵ�����ǰ��,match<br/>
	 * eg:
	 * getMinMatch("yuki:{age:17,height:165,home:{jp:'���δ�',us:'losAnges'}}","{","}",":") --> ":"
	 * </ul>
	 * @param str
	 * @param match1
	 * @param match2
	 * @return 
	 */
	public static String getMinMatch(String str,Integer index,String... matchs) {
		str = str.substring(index);
		Map<String,Integer> m = new HashMap<>();
		for(String si : matchs){
			m.put(si, str.indexOf(si));
		}
		String nearMatch = null;
		Integer min = -1;
		for(Entry<String, Integer> ei: m.entrySet()){
			Integer val = ei.getValue();
			if(val == -1)
				continue;
			if(min == -1){
				min = val;
				nearMatch = ei.getKey();
			}
			else if(min >= 0 && min > val){
				min = val;
				nearMatch = ei.getKey();
			}
			
		}
		if(min == -1)
			return null;
		return nearMatch;
	}

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ��ȡ�ַ�����û��ȡ������null���׳��쳣<br/>
	 * </ul>
	 * @param index1
	 * @param index2
	 * @return
	 */
	public static String subString(String str,int index1,int index2){
		try {
			return str.substring(index1, index2);
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ��objתΪString.����Ϊnull�����
	 * ������Long��Integer��������
	 * </ul>
	 * @param obj
	 * @return
	 */
	public static String toStr(Object obj){
		if(obj == null)
			return "";
		else
			return obj.toString();
	}
	
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * �ַ���תΪLong����<br/>
	 * �����StringUtil��ķ������Է���null
	 * </ul>
	 * @param str
	 * @param defVal 
	 * @return
	 */
	public static Long strToLong(String str, Long defVal){
		try {
			return Long.parseLong(str);
		} catch (Exception e) {
			return defVal;
		}
	}
	
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ������תΪstring������Ϊnull�����
	 * </ul>
	 * @param date
	 * @return 
	 */
	public static String dateToStr(Date date) {
		if(date == null)
			return "";
		else
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
	}
	
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ��strתΪInteger���ɷ���null
	 * </ul>
	 * @param str
	 * @param defval
	 * @return 
	 */
	public static Integer strToInteger(String str, Integer defval) {
		try {
			return Integer.parseInt(str);
		} catch (Exception e) {
			return defval;
		}
	}
	
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ��str��ʽ��Ϊ����length���ַ���������Ĳ�����ͷ����n �� append�ַ����䣬�����˵Ľ�ȡĩβlength��<br/>
	 * eg��fmtStr("123","0",5) --> "00123"
	 * </ul>
	 * @param str
	 * @param append
	 * @param length
	 * @return 
	 */
	public static String fmtStr(String str, String append, int length) {
		if(str == null)
			return createNstr(append,length);
		else if(str.length() < length){
			return createNstr(append,length - str.length()) + str;
		}else{
			return str.substring(str.length() - length);
		}
	}
	
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ����һ������Ϊlength ��append���ظ��ַ�<br/>
	 * eg: createNstr("a",5) -->"aaaaa"
	 * </ul>
	 * @param append
	 * @param length
	 * @return 
	 */
	private static String createNstr(String append, int length) {
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<length;i++){
			sb.append(append);
		}
		return sb.toString();
	}
	
	/**
	 * 
	 * <b>����˵����</b>
	 * <ul>
	 * �ж�obj�Ƿ�Ϊ���֣�nullҲ����<br/>
	 * ��������Long,Integer,Double,����String����
	 * </ul>
	 * @param obj
	 * @return
	 */
	public static boolean isNumber(Object obj){
		if(obj == null)
			return false;
		try {
			return obj instanceof Integer || obj instanceof Long || obj instanceof Double;
			
		} catch (Exception e) {
			return false;
		}
		
	}
	
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ��objתΪDouble��obj������String��Double��Integer��Long
	 * </ul>
	 * @param obj
	 * @return 
	 */
	public static Double toDouble(Object obj) {
		Double d = null;
		try {
			d = Double.valueOf(UtilString.toStr(obj));
		} catch (Exception e) {
		}
		return d;
	}
}
