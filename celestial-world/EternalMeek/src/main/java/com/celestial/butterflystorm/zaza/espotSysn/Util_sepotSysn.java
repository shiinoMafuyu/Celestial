package com.celestial.butterflystorm.zaza.espotSysn;

import java.util.List;

import com.celestial.agniRadiance.EzUtil.Util_String;

/**
 * ��һ��List��Ϊappend���ַ�����
 * @author Administrator
 *
 */
public class Util_sepotSysn {
	
	/**
	 * ����java���append�ַ�����
	 * @param list
	 * @param tabN
	 * @return
	 */
	public static String createAppend(List<String> list) {
		return createAppend(list,0);
	}
	
	/**
	 * ����java���append�ַ�����
	 * @param list
	 * @param tabN
	 * @return
	 */
	public static String createAppend(List<String> list,int tabN) {
		return createAppend(list,0,"");
	}

	/**
	 * ����java���append�ַ�����
	 * @param list
	 * @param tabN
	 * @return
	 */
	public static String createAppend(List<String> list, int tabN, String name) {
		if(null!=name && "".equals(name))
			name = "sql";
		String tab = Util_String.__nstr("\t", tabN);
		StringBuffer sb = new StringBuffer(tab).append("String ").append(name).append(" = new StringBuffer(\"\")\n");
		for(String si : list){
			if(!"".equals(si) && !Util_String.matchAllSameRegx(si, "(\\s|\\t)+"))
				sb.append(tab).append(".append(\""+si+"\")\n");
			else
				sb.append(tab).append("\n");
		}
		sb.append(tab).append(".toString();");
		return sb.toString();
	}
}
