package com.celestial.butterflystorm.zaza.japaneseTrans;

import java.util.LinkedHashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import com.celestial.agniRadiance.EzUtil.Util_Json;

public class Util_Japanese {
	
	private static Map<String, String> qingyinMap = new LinkedHashMap<String,String>();
	private static Map<String, String> aoyinMap = new LinkedHashMap<String,String>();

	static{
		qingyinMap = Util_Json.json2Map(new JSONObject("{��:zu,��:tsu,��:de,��:te,��:chi,��:da,��:xtu,��:ji,��:ne,��:nu,��:ha,��:no,��:do,��:to,��:ni,��:na,��:pi,��:fu,��:bu,��:pu,��:ba,��:pa,��:hi,��:bi,��:bo,��:po,��:ma,��:mi,��:he,��:be,��:pe,��:ho,��:xe,��:u,��:xu,��:i,��:xi,��:a,��:xa,��:ku,��:gi,��:ki,��:ga,��:ka,��:o,��:xo,��:e,��:za,��:shi,��:go,��:sa,��:ge,��:ko,��:gu,��:ke,��:zo,��:ta,��:ze,��:so,��:zu,��:se,��:ji,��:su,��:re,��:ro,��:wa,��:yo,��:ra,��:ri,��:ru,��:ya,��:yu,��:mu,��:me,��:mo,��:xka,��:xke,��:n,��:o,��:no,��:ha,��:nu,��:ne,��:na,��:ni,��:to,��:do,��:te,��:de,��:tsu,��:zu,��:ji,��:da,��:chi,��:mi,��:ma,��:po,��:bo,��:ho,��:pe,��:be,��:he,��:pu,��:bu,��:fu,��:pi,��:bi,��:hi,��:pa,��:ba,��:e,��:o,��:ka,��:ga,��:ki,��:gi,��:ku,��:a,��:i,��:u,��:su,��:ji,��:se,��:zu,��:so,��:ze,��:ta,��:zo,��:ke,��:gu,��:ko,��:ge,��:sa,��:go,��:shi,��:za,��:ri,��:ru,��:yo,��:ra,��:xwa,��:wa,��:re,��:ro,��:mo,��:xya,��:mu,��:me,��:yu,��:xyo,��:ya,��:xuy,��:n,��:o,�`:�`}"));
		aoyinMap = Util_Json.json2Map(new JSONObject("{�ӥ�:byo,�Ԥ�:pyo,�Ԥ�:pyu,�ӥ�:bya,�ӥ�:byu,�ߥ�:myo,�Ǥ�:dhi,�ߥ�:myu,�ߥ�:mya,����:ja,����:cha,����:gyo,����:jo,����:cho,����:ju,����:chu,�Ԥ�:pya,����:gyu,����:gya,�ҥ�:hyo,�ҥ�:hyu,�ҥ�:hya,����:sho,�¥�:ja,����:kyu,�¥�:ju,����:kyo,���:ryo,�¥�:jo,���:ryu,����:sha,���:rya,����:shu,�˥�:nyu,�˥�:nya,����:kya,�˥�:nyo,����:kya,����:kyu,�Ҥ�:hyo,����:kyo,�Ҥ�:hyu,����:sha,�Ҥ�:hya,����:shu,����:sho,�ˤ�:nyu,�ˤ�:nya,�ˤ�:nyo,�¤�:ja,�Ĥ�:tse,�¤�:ju,�Ĥ�:tso,�¤�:jo,null:null,�ߤ�:myu,�ߤ�:mya,�Ĥ�:tsi,����:gyu,�Ĥ�:tsa,����:gya,����:zui,�ԥ�:pyo,����:ja,�Ӥ�:byo,�ԥ�:pyu,����:gyo,���:ryo,���:ryu,����:jo,�Ӥ�:bya,���:rya,�ߤ�:myo,����:ju,�Ӥ�:byu,�ԥ�:pya,����:cha,����:cho,����:chu}"));
	}
	public static void main(String[] args) {
		String s = Util_Json.map2Json(aoyinMap).toString();
		System.out.println(s);
		
	}
	
	public  static String wordTransToRoman(String word){
		StringBuffer sb = new StringBuffer();
		while(!"".equals(word)){
			
			String orinal = new String(word);
			
			word = findAoyin(sb,word);
			word = findQingyin(sb,word);
			
			if(orinal.equals(word)){
//				throw new RuntimeException("�˴��в����ڵķ���:"+word);
				//���벻������ �����룡
				sb.append(word.substring(0,1)).append(" ");
				word = word.substring(1);
				
			}
				
		}
		
		
		return sb.toString();
	}
	
	private static String findQingyin(StringBuffer sb, String word) {
		
		if(word.length()>=1){
			String st = word.substring(0,1);
			String yin = qingyinMap.get(st);
			if(null == yin)
				return word;
			else{
				word = word.substring(1,word.length());
				sb.append(yin).append(" ");
				return word;
			}
		}else{
			return word;
		}
		
	}

	private static String findAoyin(StringBuffer sb, String word) {
		if(word.length()>=2){
			String st = word.substring(0,2);
			String yin = aoyinMap.get(st);
			if(null == yin)
				return word;
			else{
				word = word.substring(2,word.length());
				sb.append(yin).append(" ");
				return findAoyin(sb,word);
			}
			
		}else{
			return word;
		}
		
	}

}
