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
	 * RequestVO�м̳и���ĳ�Ա����.
	 */
	@SuppressWarnings("serial")
	public static final Map<String,String> requestPaVariableMap = new HashMap<String, String>(){{
		
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
	
	/**
	 * ����map<br/>
	 * RequestVO����Ҫ����İ�����.<br/>
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
	 * ����Ҫ����İ�.
	 */
	public static final List<String> mustImport_request = new ArrayList<String>(Arrays.asList(new String[]{
			"gnnt.framework.frontend.base.enums.ECheckLogonType",
			"gnnt.framework.frontend.base.requesthandler.IRequestHandler",
			"gnnt.framework.frontend.base.vo.ARequestVO"
	}));
	
	/**
	 * =======================================================�� RequestVO����=================�� ResponseVO����=======================================================
	 */
	
	public static final String RESPONSEVO = "ResponseVO";
	
	/**
	 * ResponseVO�м̳и���ĳ�Ա����.
	 */
	@SuppressWarnings("serial")
	public static final Map<String,String> responsePaVariableMap = new HashMap<String, String>(){{
		put("RETCODE","RETCODE");
		put("MESSAGE","MESSAGE");
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
		put("long","X + \"\";");
		put("Boolean","X.toString();");
		
		put("Double","NUMFormat.fmtDouble2(X);");
		put("Date","DateFormat.fmtTime(X);");
	}};
	
	/**
	 * ResponseVO���ж�Ҫ����İ�.
	 */
	public static final List<String> mustImport_response = new ArrayList<String>(Arrays.asList(new String[]{
			"gnnt.framework.frontend.base.vo.ResponseVO"
	}));
	
	/**
	 * ReponseVO��,ResultList������ӱ�ǩ��д��Ӧ������.<br/>
	 * XXX��Ϊ���滻�ı��.<br/>
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
