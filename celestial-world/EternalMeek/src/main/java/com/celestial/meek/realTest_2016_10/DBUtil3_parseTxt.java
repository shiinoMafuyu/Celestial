package com.celestial.meek.realTest_2016_10;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.celestial.agniRadiance.EzUtil.UtilFile;
import com.celestial.agniRadiance.EzUtil.UtilString;

public class DBUtil3_parseTxt {

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param args 
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		
		
	}

	
	
	
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 简单(真)解析文本<br/>
	 * and展示信息~这样拷过去就行啦
	 * </ul>
	 * @param filePath 文件位置
	 * @param startFlag 开始部分
	 * @param showPart 要展示的部分
	 */
	public static void paresSimpleAndShow(String filePath, String startFlag,
			String showPart,String titleRegex) {
		DBUtil3_parseTxt.print(DBUtil3_parseTxt.gentleParse(DBUtil3_parseTxt.getTxtList(filePath,startFlag,titleRegex)),showPart);
	}

	/**
	 * 
	 * <b>方法说明：</b>
	 * <ul>
	 * 展示解析处理好了的信息~<br/>
	 * 主要是打印出来,复制粘贴用的<br/>
	 * 用于copy~ 
	 * </ul>
	 * @param lm
	 * @param part
	 */
	public static void print(List<List<Object>> lm, String part) {
		//{"SI","SessionID","Long","用户会话id"},
		String[] sArr = null;
		String st = null;
		for(List<Object> i : lm){
			String partMsg = (String)i.get(0);
			if(!partMsg.startsWith(part))
				continue;
			System.out.println(partMsg);
			for(int j = 1 ; j < i.size() ; j++){
				sArr = (String[])i.get(j);
				st = "{\""+sArr[0]+"\",\""+sArr[1]+"\",\""+sArr[2]+"\",\""+sArr[3]+"\"},";
				System.out.println(st);
			}
		}
		
	}





	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 遍历lp中的每一个List<String><br/>
	 * 如果该List<String>中的一个String一行含有完整的标签开头和结尾,则将之转为长度为4的字符串数组存入一个List<Object>中,否则舍弃<br/>
	 * 返回结果实为List<List<String[]>>形式<br/>
	 * </ul>
	 * @param 还有完整xml标签的需要解析出来的List<String>的集合
	 * @return
	 */
	public static List<List<Object>> gentleParse(
			List<List<String>> lp) {
		List< List<Object>>  l = new ArrayList<List<Object>>();
		List<Object> lo = null;
		for(List<String> list : lp){
			lo = new ArrayList<Object>();
			lo.add(list.get(0));
			for(String si : list){
				String  tag = DBUtil3_parseTxt.rowTagRecognize(si);
				if(tag != null){
					String[] sArr = DBUtil3_parseTxt.getArr(si,tag);
					lo.add(sArr);
				}
			}
			l.add(lo);
		}
		return l;
	}



	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 传入一行含有完整标签的字符串<UI>用户名</UI>UserID,把它封装成一个数组返回<br/>
	 * 形式{"UI","UserID","","用户名"}<br/>
	 * </ul>
	 * @param line
	 * @return
	 */
	private static String[] getArr(String line , String tag) {
		//{"SI","SessionID","Long","用户会话id"},
		String[] sArr = new String[4];
		sArr[0] = tag ;
		String tagStart = "<" + tag + ">";
		String tagEnd = "</" + tag + ">";
		sArr[1] = line.substring(line.indexOf(tagEnd) + tagEnd.length()).trim();
		sArr[2] = "";
		sArr[3] = line.substring(line.indexOf(tagStart)+tagStart.length(), line.indexOf(tagEnd)).trim();
		return sArr;
	}


	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 传入一行字符串,如果该行含有<UI></UI>这样成对的标签返回标签名UI;<br/>
	 * </ul>
	 * @param si
	 * @return
	 */
	public static String rowTagRecognize(String str) {
		String tag = null;
		if(str.contains("<") && str.contains(">")){
			tag = str.substring(str.indexOf("<")+1, str.indexOf(">"));
		}
		if(!str.contains("</"+tag+">"))
			tag = null;
		return tag;
	}

	static Map<String,List<String>> mps = new HashMap<String, List<String>>();
	static List<List<String>> lps = new ArrayList<List<String>>();
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 解析filePath指向的文件,把从第零行开始的内容,以titleRegex指示的标题分开<br/>
	 * 放入List<String>中,再把这些List<String>放入一个父List中返回<br/>
	 * 
	 * </ul>
	 * @param filePath 文件路径
	 * @param titleRegex 标题形式正则式
	 * @return
	 */
	public static List<List<String>> getTxtList(String filePath, String titleRegex) {
		return DBUtil3_parseTxt.getTxtList(filePath,"",titleRegex);
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 解析filePath指向的文件,把从flagString开始后的内容,以titleRegex指示的标题分开<br/>
	 * 放入List<String>中,再把这些List<String>放入一个父List中返回<br/>
	 * 
	 * </ul>
	 * @param filePath 文件路径
	 * @param flagString 开始位置
	 * @param titleRegex 标题形式正则式
	 * @return
	 */
	@SuppressWarnings("resource")
	public static List<List<String>> getTxtList(String filePath, String flagString,String titleRegex) {
		List<List<String>> l = new ArrayList<List<String>>();
		List<String> lt = new ArrayList<String>();
		boolean startFlag = false ;
		
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
			String s = null;
			while((s = br.readLine()) != null ){
				if(s != null && s.contains(flagString))
					startFlag = true ;
				s = s.trim();
				if(!startFlag)
					continue;
				if(UtilString.matchHeadRegx(s,titleRegex)){
					lt = new ArrayList<String>();
					l.add(lt);
				}
				lt.add(s);
			}
		} catch (Exception e) {
			UtilFile.close(br);
			throw new RuntimeException("文件读取流错误~");
		}
		
		return l;
	}
	



	
	/**===================================================================================================
	 * <b>方法说明：</b>
	 * <ul>
	 * 检查标签完整性<br/>
	 * 一个标签的开始<TName>或结束</TName>只能在一行<br/>
	 * 支持<TName />形式<br/>
	 * </ul>
	 * @param txtString
	 * @param tag 
	 * @return
	 */
/*	public static boolean checkTagCompleted(String txtString, String tag) {
		String tagStart = "<"+tag;
		String tagEnd = "</"+tag+">";
		String s = matchAndReduce(txtString,tagStart,tagEnd);
		return false;
	}*/

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 递归检查
	 * </ul>
	 * @param txtString
	 * @param tagStart
	 * @param tagEnd
	 * @return
	 */
/*	private static String matchAndReduce(String txtString, String tagStart,
			String tagEnd) {
		if(txtString.contains(tagStart)){
			//<FBACALL><ff/>POLICE<MEBS_MOBILE ref="找不到引用" sub="电话号码" ><REQ ref="qqq" sub=-"ppp"><I sub="Information" type="String">信息</I><FI sub="FirmID" type="String" >交易商ID</FI><PRI sub="Price" type="Double">价格</PRI></REQ></MEBS_MOBILE>ooooooooooooooo
			String s = "";
			int index1 = txtString.lastIndexOf(tagStart);
//			int index2 = txtString.
		}
		return null;
	}*/

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 当时是用来解析文本获取每个以n.x开头的标题的和<MEBS_MOBILE></MEBS_MOBILE>之间的内容的<br/>
	 * 可以说现在没有任何卵用<br/>
	 * 这个功能不是可通用性的元素拼接起来的,用一次就丢了的垃圾<br/>
	 * </ul>
	 * @throws Exception
	 */
/*	@SuppressWarnings("unused")
	protected static void pares1() throws Exception {
		String[] filterString =new String[]{"?xml","version"};
		
		List<String[]> ls2 = new ArrayList<String[]>();
		ls2.add(new String[]{"U","UserID","String","用户id"});
		//自由取得 属性  不断传入字符串
		
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(new File("F:/云盘同步文件夹/云盘同步文件夹/00sentence/parse/r1.txt"))));
		
		BufferedReader br =new BufferedReader(new InputStreamReader(new FileInputStream("F:/云盘同步文件夹/云盘同步文件夹/00sentence/parse/parse3.txt"),"gbk"));
		String s = null;
		String title = null;
		int MEBS_MOBILE_num = 2 ;
		int i = 1;
		
		boolean inMEBS_MOBILE =false;
		
		while((s=br.readLine())!=null){
			
			if(s.contains(i+". ")){
				System.out.println(s);
				pw.println(s);
				i++;
				title = s ;
			}
			if(title != null){//title !=null 表示正在取两个MEBS_MOBILE ;
				if(s.contains("<MEBS_MOBILE>")){
					inMEBS_MOBILE = true;
					s = "<MEBS_MOBILE title=\""+title+"\">";
				}
				else if(s.contains("</MEBS_MOBILE>")){
					inMEBS_MOBILE = false;
					MEBS_MOBILE_num --;
				}
				if(MEBS_MOBILE_num ==0){
					MEBS_MOBILE_num = 2;
					title = null;
				}
				if(inMEBS_MOBILE || s.contains("<MEBS_MOBILE>") || s.contains("</MEBS_MOBILE>")){
					System.out.println(s.trim());
					pw.println(s.trim());
				}
			}
		}
		br.close();
		pw.flush();
		pw.close();
	}*/


	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * stringList中检查标签是否完整<br/>
	 * </ul>
	 * @param stringList
	 * @return
	 */
/*	public static boolean checkTagCompleted(List<String> stringList) {
		boolean b = true;
		List<String> l = new CopyOnWriteArrayList<String>(stringList);
		for(String si : l){
			boolean bb = DBUtil3_parseTxt.checkTagCompletedSimpleWay(si);
			String sx = DBUtil3_parseTxt.checkContainTagHead(si);
			
		}
		
		
		return b;
	}*/

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 检查标签是不是以<FUCk />这种形式行内完整<br/>
	 * 这种算<  FUCK sub="fuckyou"  /  ><br/>
	 * 这种不算<  FU CK sub = "fuckyou" / ><br/>
	 * 里面只能含有一个不与"="匹配的字符串,且只能是"<"之后第一个<br/>
	 * </ul>
	 * @param si
	 * @return
	 */
//	public static boolean checkTagCompletedSimpleWay(String si) {
//		//depress
//		boolean b = false ;
//		if(Util_String.matchAllSameRegx(si, ".*<{1}.*/{1}\\s+>{1}")){
////			String s = 
//		}
//		return b;
//	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 判断一个String中是否包含一个标签头<FUCK > <br/>
	 * 判断依据顺序包含"<"和">",中间不包含1"?"和"<"(取的时候以第一个">"为准所以不用判断里面是否含有多余的">"了)<br/>
	 * 一行内不要含有多个标签<br/>
	 * 注:<FUCK />这种形式将会在
	 * </ul>
	 * @param readLine
	 * @return 
	 */
/*	public static String checkContainTagHead(String str) {
		String sb = null;
		if(Util_String.matchAllSameRegx(str, ".*<{1}.*>{1}.*") && !Util_String.matchAllSameRegx(str, ".*<{1}.*(\\?|<).*>{1}.*") ){
			String s = str.substring(str.indexOf('<')+1, str.indexOf('>'));
			//等号问题
			
//			sb = ___checkAndGetTheFirstWord(s);
			
		}
		
		return sb;
	}*/

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * ref = "queryAction" sub = "joker" type ="String"<br/>
	 * 以空格和等号打断去掉为空的字符串.
	 * </ul>
	 * @param st
	 * @return
	 */
/*	public static Map<String, String> __getPropertyMap(String st) {
		String[] sArr = DBUtil3_parseTxt.split(st, new String[]{"="," "});
		if(sArr.length%2!=0){
			throw new RuntimeException("标签属性错误~");
		}
		Map<String,String> map = new LinkedHashMap<String, String>();
		for(int i = 0 ; i + 2 < sArr.length ; i+=2){
			map.put(sArr[i], sArr[i+1]);
		}
		return map;
	}*/

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 染一个字符串被多种符号打断
	 * </ul>
	 * @param s
	 * @param regexArr
	 * @return
	 */
/*	private static String[] split(String s, String[] regexArr) {
		String[] sArr = s.split("\\s+");
		List<Object[]> ls = new ArrayList<Object[]>();
		for(String si : sArr){
			ls.add(si.split("="));
		}
		sArr = (String[])Util_File.arrayCombine(ls);
		return sArr;
	}*/
	
}
