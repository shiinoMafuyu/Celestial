/******************************************************************
 * CoreCreatorConfig.java
 * Copyright 2017 by WZG. All Rights Reserved.
 * CreateDate��2017��6��11��
 * Author��wangzg
 * Version��1.0.0
 ******************************************************************/

package com.celestial.butterflystorm.butterfly2017.ClassCreatorSuperStar;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <b>�޸ļ�¼��</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2017��6��11��
 * </li>
 * </p>
 * 
 * <b>��˵����</b>
 * <p> 
 * 
 * </p>
 */
public class CoreCreatorConfig {
	
	public static final Map<String,String> CfMap = new LinkedHashMap<String,String>();
	
	static{
//		CfMap.put("0", "createPackageInfo");
//		CfMap.put("1", "createImportInfo");
//		CfMap.put("2", "createMainClassInfo");
		CfMap.put("3", "createVariables");
		CfMap.put("4", "createSetters");
		CfMap.put("5", "createGetters");
		
	}
	
	
	@SuppressWarnings("serial")
	public static final Map<String,String> mustImportMap = new LinkedHashMap<String,String>(){{
		put("1","import gnnt.framework.frontend.base.enums.ECheckLogonType;");
		put("2","import gnnt.framework.frontend.base.requesthandler.IRequestHandler;");
		put("3","import gnnt.framework.frontend.base.vo.ARequestVO;");
	}};
	
	/**
	 * ��Ӧ�����ֶζ�ӦҪ���İ�.
	 */
	@SuppressWarnings({ "serial", "rawtypes" })
	public static final Map importMapResponse = new HashMap<String, String[]>(){{
		put("List",new String[]{"import java.util.List;","import java.util.ArrayList;"});
		put("ToStringStyle",new String[]{"import org.apache.commons.lang3.builder.ToStringBuilder;","import org.apache.commons.lang3.builder.ToStringStyle;"});
		
		put("Double",new String[]{"import gnnt.util.number.NUMFormat;"/*,"import gnnt.MEBS.MobileServer.constant.Constant;"*/});//Doubleת�ַ������ȾͲ�������.��Ҫ���Լ������ɺ����.
		put("Date",new String[]{"import gnnt.util.date.DateFormat;","import java.util.Date;"});
	}};
	
	/**
	 * ResponseVOʹ��.
	 * ֧�ֵ����ͺ�Ҫ���İ��ʹ���ʽ��������.<br/>
	 * Ϊ""��ʾ֧��,������Ҫ��������߽����ر����.<br/>
	 * �������滻�����X <br/>
	 * Ҫ�����������͵�֧�����������,X�������������滻��<br/>
	 */
	@SuppressWarnings("serial")
	public static final Map<String,String> supportMapResponse = new HashMap<String, String>(){{
		put("List","");
		put("ToStringStyle","");
		put("String","X;");
		
		put("Integer","X.toString();");
		put("Long","X.toString();");
		put("long","StringUtil.strToLong(X,0);");
		put("Boolean","X.toString();");
		
		put("Double","NUMFormat.fmtDouble2(X);");
		put("Date","DateFormat.fmtTime(X);");
	}};
	
	/**
	 * RequestVOʹ��.
	 * ֧�ֵ����ͺ�Ҫ���İ��ʹ���ʽ��������.<br/>
	 * Ϊ""��ʾ֧��,������Ҫ��������߽����ر����.<br/>
	 * �������滻�����X <br/>
	 * Ҫ�����������͵�֧�����������,X�������������滻��<br/>
	 */
	@SuppressWarnings("serial")
	public static final Map<String,String> supportMap = new HashMap<String, String>(){{
		put("List","");
		put("ToStringStyle","");
		put("String","X;");
		
		put("Integer","StringUtil.strToInt(X, 0);");
		put("Long","StringUtil.strToLong(X,0);");
		put("long","StringUtil.strToLong(X,0);");
		put("Boolean","StringUtil.strToBoolean(X);");
		
		put("Double","StringUtil.strToDouble(X,0.0);");
		put("Date","StringUtil.strToDate(X);");
		put("Float","StringUtil.strToFloat(X, 0);");
	}};
	
}
