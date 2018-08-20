/******************************************************************
 * Protocol.java
 * Copyright 2017 by WZG. All Rights Reserved.
 * CreateDate：2017年6月17日
 * Author：wangzg
 * Version：1.0.0
 ******************************************************************/

package com.celestial.butterflystorm.butterfly2017.protocoltest;

import java.util.HashMap;
import java.util.Map;

/**
 * <b>修改记录：</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2017年6月17日
 * </li>
 * </p>
 * 
 * <b>类说明：</b>
 * <p> 
 * 
 * </p>
 */
public class ProtocolConfig {
	
	public static Map<String,String> requestMap = new HashMap<String,String>();
	public static Map<String,String> responseMap = new HashMap<String,String>();
	
	public static String URL = "";
	
	public static String CHARSET = "gbk";
			
	static{
		
		initRequestMap();
		initResponseMap();
		
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 
	 * </ul> 
	 */
	private static void initRequestMap() {
		requestMap.put("game_type",
				"<?xml version=\"1.0\" encoding=\"GB2312\"?>" + 
				"<MEBS_MOBILE>" + 
				"	<REQ name=\"game_type\">" + 
				"		<U>pinscode</U>" + 
				"		<SID>sessionID</SID>" + 
				"	</REQ>" + 
				"</MEBS_MOBILE>" );
		
		/*requestMap.put("","");
		requestMap.put("","");
		requestMap.put("","");
		requestMap.put("","");
		
		requestMap.put("","");
		requestMap.put("","");
		requestMap.put("","");
		requestMap.put("","");
		requestMap.put("","");
		requestMap.put("","");
		
		requestMap.put("","");
		requestMap.put("","");
		requestMap.put("","");
		requestMap.put("","");*/
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 
	 * </ul> 
	 */
	private static void initResponseMap() {
		responseMap.put("game_type",
				"<?xml version=\"1.0\"encoding=\"GB2312\"?>" + 
						"<MEBS_MOBILE>" + 
						"	<REP name=\"game_type\">" + 
						"		<RESULT>" + 
						"			<RETCODE>返回码0成功, 其他为失败，错误描述在ARGS中</RETCODE>" + 
						"			<ARGS>提示信息参数，多个参数使用符号 | 分隔 ，没有参数时该标签不返回。" + 
						"			</ARGS>" + 
						"			<DID>默认类别编号</DID>" + 
						"			</RESULT>" + 
						"		<RESULTLIST>" + 
						"			<REC>" + 
						"				<ID>类别编号</ ID >" + 
						"				<N>类别名称</N>" + 
						"				<B>所需宗豆数</B>" + 
						"				<ICOURL>图标地址</ICOURL>" + 
						"				</REC>" + 
						"		</RESULTLIST>" + 
						"	</REP>" + 
						"</MEBS_MOBILE>" );
		
		/*responseMap.put("","");
		responseMap.put("","");
		responseMap.put("","");
		responseMap.put("","");
		
		responseMap.put("","");
		responseMap.put("","");
		responseMap.put("","");
		responseMap.put("","");
		responseMap.put("","");
		responseMap.put("","");
		
		responseMap.put("","");
		responseMap.put("","");
		responseMap.put("","");
		responseMap.put("","");
		*/
	}
}
