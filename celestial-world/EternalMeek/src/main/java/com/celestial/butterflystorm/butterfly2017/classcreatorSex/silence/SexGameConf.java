package com.celestial.butterflystorm.butterfly2017.classcreatorSex.silence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SexGameConf {
	public static final String AUTHOR = "wangzg";
	
	public static final String REQUESTVO = "RequestVO";
	
	@SuppressWarnings("serial")
	public static final Map<String,String> requestInnerClassNameMap = new HashMap<String, String>(){{
		put("PROS","PropertyList");
		put("PICS","PictureList");
		put("PR","PropertyObj");
		put("PRO","PropertyObj");
		put("PIC","PictureObj");
	}};
	
	/**
	 * RequestVO中继承父类的成员变量.
	 */
	@SuppressWarnings("serial")
	public static final Map<String,String> requestPaVariableMap = new HashMap<String, String>(){{
		
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
	
	/**
	 * 导包map<br/>
	 * RequestVO中需要导入的包索引.<br/>
	 */
	@SuppressWarnings({ "serial", "rawtypes" })
	public static final Map importMap = new HashMap<String, String[]>(){{
		put("List",new String[]{"import java.util.List;","import java.util.ArrayList;"});
		put("ToStringStyle",new String[]{"import org.apache.commons.lang3.builder.ToStringBuilder;","import org.apache.commons.lang3.builder.ToStringStyle;"});
		
		put("Integer",new String[]{"import gnnt.util.string.StringUtil;"});
		put("Long",new String[]{"import gnnt.util.string.StringUtil;"});
		put("Boolean",new String[]{"import gnnt.util.string.StringUtil;"});
		
		put("Double",new String[]{"import gnnt.util.string.StringUtil;"});
		put("Date",new String[]{"import gnnt.util.string.StringUtil;","import java.util.Date;"});
		put("Float",new String[]{"import gnnt.util.string.StringUtil;"});
		
	}};
	
	/**
	 * 必须要引入的包.
	 */
	public static final List<String> mustImport_request = new ArrayList<String>(Arrays.asList(new String[]{
			"gnnt.framework.frontend.base.enums.ECheckLogonType",
			"gnnt.framework.frontend.base.requesthandler.IRequestHandler",
			"gnnt.framework.frontend.base.vo.ARequestVO"
	}));
	
	/**
	 * =======================================================↑ RequestVO配置=================↓ ResponseVO配置=======================================================
	 */
	
	public static final String RESPONSEVO = "ResponseVO";
	
	/**
	 * ResponseVO中继承父类的成员变量.
	 */
	@SuppressWarnings("serial")
	public static final Map<String,String> responsePaVariableMap = new HashMap<String, String>(){{
		put("RETCODE","RETCODE");
		put("MESSAGE","MESSAGE");
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
		put("long","X + \"\";");
		put("Boolean","X.toString();");
		
		put("Double","NUMFormat.fmtDouble2(X);");
		put("Date","DateFormat.fmtTime(X);");
	}};
	
	/**
	 * ResponseVO类中都要引入的包.
	 */
	public static final List<String> mustImport_response = new ArrayList<String>(Arrays.asList(new String[]{
			"gnnt.framework.frontend.base.vo.ResponseVO"
	}));
	
	/**
	 * ReponseVO中,ResultList里面的子标签缩写对应的类名.<br/>
	 * XXX作为被替换的标记.<br/>
	 */
	@SuppressWarnings("serial")
	public static final Map<String,String> responseInnerClassNameMap = new HashMap<String, String>(){{
		put("PRS","PropertyList");
		put("ORP","OrderPictureList");
		put("PCS","PictureObj");
		put("PRO","PropertyObj");
		put("REC","XXX");
	}};
}
