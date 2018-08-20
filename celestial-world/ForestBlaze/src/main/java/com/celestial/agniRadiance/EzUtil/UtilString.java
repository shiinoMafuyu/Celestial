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
public class UtilString {
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 把i的手写字母变成大写
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
	 * @param str
	 * @return
	 */
	public static String transHeadToLowerCase(String str) {
		if("".equals(str))
			return "";
		return new StringBuffer(str.substring(0, 1).toLowerCase()).append(str.substring(1)).toString();
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取属性.
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
			throw new RuntimeException(new StringBuffer("属性字符串").append(sb).append("属性有问题!").toString());
		}
		
		return map;
	}
	
	/**
	 * <b>方法说明：</b>
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
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取s中第一个字符串 ; 如"  ko ff xx" 返回ko;
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
	 * <b>方法说明：</b>
	 * <ul>
	 * 检查一行字符串里是否含有一个完整的简单标签.<br/>
	 * 这个标签不包含属性<br/>
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
	 * 去掉list最后的一个符号removeStr 如","<br/>
	 * 如果最后一行是不含","的，则往前找直到去掉一个","后返回<br/>
	 * 删除结尾是removeStr的，如果句中含有则不管<br/>
	 * 舍弃末尾是removeStr之后的list元素
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
	 * <b>方法说明：</b>
	 * <ul>
	 * 在s中取得最后的sign之后的部分。<br/>
	 * 如：ez.EzUtil.Util_String取得最后的.之后的，即为Util_String。
	 * </ul>
	 * @param s
	 * @param sign 
	 * @return
	 */
	public static String getStrAfterLast(String s, String sign) {
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
	public static String getStrBeforeLast(String s, String sign) {
		return s.substring(0, s.lastIndexOf(sign));
	}

	/**
	 * 返回长度为n的制表符。<br/>
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
	 * 判断c是否是英文字母
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
	 * 格式化路径字符串。
	 * @param path
	 * @return
	 */
	public static String fmtPathStr(String path) {
		return path.replaceAll("\\\\", "/");
	}

	/**
	 * 创建n个重复的str，合并为一个字符串。
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
	 * 返回配对字符串str长度n之后在match1和match2之间的字符。<br/>
	 * 例如：
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
	 * 判断俩元素是否相等<br/>
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
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取从n开始，match1和与之配对的match2之间的字符串<br/>
	 * 不包括match1,match2<br/>
	 * eg：
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
			if(match1.equals(minMatch)){//如果和match1匹配深度 -1,如果和match2匹配深度 +1.深度为0时就找到和第一个match1配对的match2了。
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
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取从index开始,匹配匹配值当中最靠前的,match<br/>
	 * eg:
	 * getMinMatch("yuki:{age:17,height:165,home:{jp:'神奈川',us:'losAnges'}}","{","}",":") --> ":"
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
	 * <b>方法说明：</b>
	 * <ul>
	 * 截取字符串，没截取到返回null不抛出异常<br/>
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
	 * <b>方法说明：</b>
	 * <ul>
	 * 将obj转为String.处理为null的情况
	 * 包括、Long、Integer、等类型
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
	 * <b>方法说明：</b>
	 * <ul>
	 * 字符串转为Long返回<br/>
	 * 相对于StringUtil里的方法可以返回null
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
	 * <b>方法说明：</b>
	 * <ul>
	 * 将日期转为string。处理为null的情况
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
	 * <b>方法说明：</b>
	 * <ul>
	 * 将str转为Integer，可返回null
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
	 * <b>方法说明：</b>
	 * <ul>
	 * 将str格式化为长度length的字符串，不足的部分在头部用n 个 append字符补充，超出了的截取末尾length个<br/>
	 * eg：fmtStr("123","0",5) --> "00123"
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
	 * <b>方法说明：</b>
	 * <ul>
	 * 创建一个长度为length 的append的重复字符<br/>
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
	 * <b>方法说明：</b>
	 * <ul>
	 * 判断obj是否为数字，null也不算<br/>
	 * 包含类型Long,Integer,Double,不含String类型
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
	 * <b>方法说明：</b>
	 * <ul>
	 * 将obj转为Double，obj可能是String、Double、Integer、Long
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
