package com.celestial.agniRadiance.EzUtil;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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
public class Util_String {

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ��i����д��ĸ��ɴ�д
	 * </ul>
	 * @param str
	 * @return
	 */
	public static String __transHeadToUpperCase(String str) {
		return new StringBuffer(str.substring(0, 1).toUpperCase()).append(str.substring(1)).toString();
	}

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ���s1Ϊ��Ϊnull�򷵻�s2,���򷵻�s1.
	 * </ul>
	 * @param s1
	 * @param s2
	 * @return
	 */
	public static String __nullEmptyChoose(String s1,
			String s2) {
		if(null == s1 || "".equals(s1))
			return s2;
		else
			return s1;
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
	 * @param string
	 * @return
	 */
	public static String __transHeadToLowerCase(String string) {
		if("".equals(string))
			return "";
		return string.substring(0, 1).toLowerCase()+string.substring(1);
	}
	
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ��ȡ����.
	 * </ul>
	 * @param substring
	 * @return
	 */
	public static Map<String, String> ___getPropertyMap(String s) {
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
	 * ��ȡs�е�һ���ַ��� ; ��"  ko ff xx" ����ko;
	 * </ul>
	 * @param s
	 * @return
	 */
	public static String ___getTheFirstWord(String s) {
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
	public static int __containCompleteSimpleTag(String s) {
		int n = -1;
		if(!Util_String.matchAllSameRegx(s, ".*<.*>.*<.*>.*"))
			return n;
		try {
			String headContent = s.substring(s.indexOf("<") + 1 , s.indexOf(">"));
			String tagName = Util_String.___getTheFirstWord(headContent);
			String regx = ".*<\\s*"+tagName+"\\s*>[^>]*<\\s*/\\s*"+tagName+"\\s*>.*";
			if(Util_String.matchAllSameRegx(s, regx)){
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
	public static String __isCollectionType(String variableType) {
		String type = "";
		for(String si:COLLECTION_TYPE_LIST){
			if(si.equals(variableType) || Util_String.matchAllRegx(variableType, si+"<.*>")){
				type = si;
				break;
			}
		}
		return type;
	}

	/**
	 * ȥ��list����һ������removeStr ��","<br/>
	 * ������һ���ǲ���","�ģ�����ǰ��ֱ��ȥ��һ��","�󷵻�<br/>
	 * @param list
	 * @param removeStr
	 * @return
	 */
	public static List<String> subStringLastChar(List<String> list,
			String removeStr) {
		String si="";
		for(int i=list.size()-1;i>=0;i--){
			si = list.get(i);
			int lastIndex = si.lastIndexOf(removeStr);
			if(lastIndex >=0 && lastIndex + removeStr.length() == si.length()){
				si = si.substring(0,lastIndex);
				list.set(i, si);
				break;
			}
		}
		return list;
	}

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ��s��ȡ������sign֮��Ĳ��֡�<br/>
	 * �磺ez.EzUtil.Util_Stringȡ�����ġ�֮��ģ���ΪUtil_String��
	 * </ul>
	 * @param s
	 * @param sign 
	 * @return
	 */
	public static String __getStrAfterLast(String s, String sign) {
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
	public static String __getStrBeforeLast(String s, String sign) {
		return s.substring(0, s.lastIndexOf("/"));
	}

	/**
	 * ���س���Ϊn���Ʊ����<br/>
	 * @param n
	 * @return
	 */
	public static String __createTabs(int n) {
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<n;i++){
			sb.append("	");
		}
		return sb.toString();
	}

	/**
	 * �����������Ͳ�ͬ���зָ�(Ŀǰ�Ƿָ�Ӣ����ĸ������)�ҷָ�һ��
	 * @param str
	 * @return
	 */
	public static String[] __separateByType(String str) {
		String[] sarr = new String[2];
		for(int i=0;i<str.length()-1;i++){
			if(__isEnglishChar(str.charAt(i)) != __isEnglishChar(str.charAt(i+1))){
				sarr[0] = str.substring(0, i+1);
				sarr[1] = str.substring(i+1);
				break;
			}
		}
		return sarr;
	}

	/**
	 * �ж�c�Ƿ���Ӣ����ĸ
	 * @param c
	 * @return
	 */
	public static boolean __isEnglishChar(char c) {
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
	
}
