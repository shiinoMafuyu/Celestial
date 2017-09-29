/******************************************************************
 * Protocol.java
 * Copyright 2017 by WZG. All Rights Reserved.
 * CreateDate��2017��6��17��
 * Author��wangzg
 * Version��1.0.0
 ******************************************************************/

package com.celestial.butterflystorm.butterfly2017.protocoltest;

import java.util.HashMap;
import java.util.Map;

/**
 * <b>�޸ļ�¼��</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2017��6��17��
 * </li>
 * </p>
 * 
 * <b>��˵����</b>
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
	 * <b>����˵����</b>
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
	 * <b>����˵����</b>
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
						"			<RETCODE>������0�ɹ�, ����Ϊʧ�ܣ�����������ARGS��</RETCODE>" + 
						"			<ARGS>��ʾ��Ϣ�������������ʹ�÷��� | �ָ� ��û�в���ʱ�ñ�ǩ�����ء�" + 
						"			</ARGS>" + 
						"			<DID>Ĭ�������</DID>" + 
						"			</RESULT>" + 
						"		<RESULTLIST>" + 
						"			<REC>" + 
						"				<ID>�����</ ID >" + 
						"				<N>�������</N>" + 
						"				<B>�����ڶ���</B>" + 
						"				<ICOURL>ͼ���ַ</ICOURL>" + 
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
