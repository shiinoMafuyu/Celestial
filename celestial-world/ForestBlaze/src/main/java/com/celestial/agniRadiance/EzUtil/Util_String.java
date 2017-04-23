package com.celestial.agniRadiance.EzUtil;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * <b>修改记录：</b> 
 * <p>
 * <li>
 * 
 *                        ---- Administrator 2016-9-14
 * </li>
 * </p>
 * 
 * <b>类说明：</b>
 * <p> 
 * 字符串相关处理<br/>
 * 分3级__两个表示很细<br/>
 * _表示中间细<br/>
 * 没有_表示粒度最粗.
 * </p>
 */
public class Util_String {

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 把i的手写字母变成大写
	 * </ul>
	 * @param str
	 * @return
	 */
	public static String __transHeadToUpperCase(String str) {
		return new StringBuffer(str.substring(0, 1).toUpperCase()).append(str.substring(1)).toString();
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 如果s1为空为null则返回s2,否则返回s1.
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
	 * <b>方法说明：</b>
	 * <ul>
	 * s是否为Double
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
	 * <b>方法说明：</b>
	 * <ul>
	 * s是否为Integer
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
	 * <b>方法说明：</b>
	 * <ul>
	 * 把首写字母大写变小写
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
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取属性.
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
			throw new RuntimeException(new StringBuffer("属性字符串").append(sb).append("属性有问题!").toString());
		}
		
		return map;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取s中第一个字符串 ; 如"  ko ff xx" 返回ko;
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
	 * <b>方法说明：</b>
	 * <ul>
	 * 检查一行字符串里是否含有一个完整的简单标签.<br/>
	 * 这个标签不包含属性<br/>
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
	 * <b>方法说明：</b>
	 * <ul>
	 * 正则表达式匹配开头包含;
	 * </ul>
	 * @param s
	 * @param regex
	 * @return
	 */
	public static boolean matchHeadRegx(String s, String regex) {
		return matchAllSameRegx(s,regex + ".*");
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 正则表达式匹配结尾结尾包含;
	 * </ul>
	 * @param s
	 * @param regex
	 * @return
	 */
	public static boolean matchTailRegx(String s, String regex) {
		return matchAllSameRegx(s,".*" + regex);
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 正则表达式任意位置包含;
	 * </ul>
	 * @param s
	 * @param regex
	 * @return
	 */
	public static boolean matchAllRegx(String s, String regex) {
		return matchAllSameRegx(s,".*" + regex + ".*");
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 字符串必须和正则表达式完全一致;
	 * <br/>
	 * <br/>
	 * <br/>
	 * 正则表达式使用小说明:<br/>
	 * 1			数字1 <br/>
	 * . 			任意一个字符 <br/>
	 * (带"\"的注意转意) <br/>
	 * \d			数字 <br/>
	 * \D			非数字 <br/>
	 * \w			单独字符([a-zA-Z_0-9]) <br/>
	 * \W			非单独字符 <br/>
	 * [a-z] a ~ z 	中一个 <br/>
	 * [^a-z]		非 a ~ z 中 <br/>
	 * [0-9A-Za-z] 	0 ~ 9 , A ~ Z , a ~ z 中一个 <br/>
	 * [a-z]{3} 	a ~ z 中3个 <br/>
	 * [a-z]* 		a ~ z 中0个以上 <br/>
	 * [a-z]+ 		a ~ z 中1个以上 <br/>
	 * [a-z]{3,5}	a ~ z 出现3~5个 <br/>
	 * [a-z]{3,}	a ~ z 出现3个以上 <br/>
	 * ^a			以a开头 <br/>
	 * b$			以b结尾 <br/>
	 * FU?			F粗现或者FU粗现() <br/>
	 * a|b			a或者b中任意一个 <br/>
	 * (J|X){2}		J或者X中任意一个存在2个,如JJ JX XJ XX <br/>
	 * ()			视为一个整体 <br/>
	 * </ul>
	 * @param s
	 * @param regex
	 * @return
	 */
	public static boolean matchAllSameRegx(String s, String regex) {
		return Pattern.compile(regex).matcher(s).matches();
	}
	
	/**
	 * 去掉最后n个字符。
	 * @param s
	 * @param n
	 * @return
	 */
	public static String subStringLast(String s,int n){
		return s.substring(0,s.length()-n);
	}

	/**
	 * 去掉最末尾的removeStr字符，如果没有则不管。
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
	 * 读取str中className后面括号里的内容
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
	 * 判断变量类型variableType是否集合类型 如List 和Map<br/>
	 * (其他想到再说。。)是的话返回类型。不是的话返回空字符串。
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
	 * 去掉list最后的一个符号removeStr 如","<br/>
	 * 如果最后一行是不含","的，则往前找直到去掉一个","后返回<br/>
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
	 * <b>方法说明：</b>
	 * <ul>
	 * 在s中取得最后的sign之后的部分。<br/>
	 * 如：ez.EzUtil.Util_String取得最后的。之后的，即为Util_String。
	 * </ul>
	 * @param s
	 * @param sign 
	 * @return
	 */
	public static String __getStrAfterLast(String s, String sign) {
		return s.substring(s.lastIndexOf(sign) + sign.length());
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 从s中获取最后一个sign之前的字符串。
	 * </ul>
	 * @param s
	 * @param sign
	 * @return
	 */
	public static String __getStrBeforeLast(String s, String sign) {
		return s.substring(0, s.lastIndexOf("/"));
	}

	/**
	 * 返回长度为n的制表符。<br/>
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
	 * 根据字形类型不同进行分割(目前是分割英文字母和其他)且分割一次
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
	 * 判断c是否是英文字母
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
	 * 格式化路径字符串。
	 * @param path
	 * @return
	 */
	public static String fmtPathStr(String path) {
		return path.replaceAll("\\\\", "/");
	}
	
}
