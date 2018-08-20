/******************************************************************
 * CoreCreatorConfig.java
 * Copyright 2017 by WZG. All Rights Reserved.
 * CreateDate：2017年6月11日
 * Author：wangzg
 * Version：1.0.0
 ******************************************************************/

package com.celestial.butterflystorm.butterfly2017.ClassCreatorSuperStar;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <b>修改记录：</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2017年6月11日
 * </li>
 * </p>
 * 
 * <b>类说明：</b>
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
	 * 响应包中字段对应要导的包.
	 */
	@SuppressWarnings({ "serial", "rawtypes" })
	public static final Map importMapResponse = new HashMap<String, String[]>(){{
		put("List",new String[]{"import java.util.List;","import java.util.ArrayList;"});
		put("ToStringStyle",new String[]{"import org.apache.commons.lang3.builder.ToStringBuilder;","import org.apache.commons.lang3.builder.ToStringStyle;"});
		
		put("Double",new String[]{"import gnnt.util.number.NUMFormat;"/*,"import gnnt.MEBS.MobileServer.constant.Constant;"*/});//Double转字符串精度就不控制了.需要的自己类生成后添加.
		put("Date",new String[]{"import gnnt.util.date.DateFormat;","import java.util.Date;"});
	}};
	
	/**
	 * ResponseVO使用.
	 * 支持的类型和要引的包和处理方式放在这里.<br/>
	 * 为""表示支持,但不需要引入包或者进行特别操作.<br/>
	 * 其他的替换里面的X <br/>
	 * 要增加其他类型的支持在这里添加,X是用来被变量替换的<br/>
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
	 * RequestVO使用.
	 * 支持的类型和要引的包和处理方式放在这里.<br/>
	 * 为""表示支持,但不需要引入包或者进行特别操作.<br/>
	 * 其他的替换里面的X <br/>
	 * 要增加其他类型的支持在这里添加,X是用来被变量替换的<br/>
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
