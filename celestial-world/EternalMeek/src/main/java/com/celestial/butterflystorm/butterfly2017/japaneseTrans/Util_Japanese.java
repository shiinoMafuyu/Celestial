package com.celestial.butterflystorm.butterfly2017.japaneseTrans;

import java.util.LinkedHashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import com.celestial.agniRadiance.EzUtil.UtilJson;

public class Util_Japanese {
	
	private static Map<String, String> qingyinMap = new LinkedHashMap<String,String>();
	private static Map<String, String> aoyinMap = new LinkedHashMap<String,String>();

	static{
		qingyinMap = UtilJson.json2Map(new JSONObject("{勿:zu,勾:tsu,匹:de,化:te,切:chi,分:da,勻:xtu,刈:ji,友:ne,厄:nu,反:ha,及:no,升:do,午:to,卞:ni,卅:na,夭:pi,孔:fu,少:bu,尤:pu,壬:ba,天:pa,夫:hi,太:bi,廿:bo,弔:po,引:ma,心:mi,尺:he,屯:be,巴:pe,幻:ho,之:xe,丹:u,丰:xu,中:i,不:xi,丐:a,丑:xa,仁:ku,亢:gi,五:ki,互:ga,井:ka,云:o,予:xo,尹:e,介:za,仄:shi,仍:go,今:sa,仆:ge,仇:ko,什:gu,仃:ke,冗:zo,凶:ta,兮:ze,公:so,內:zu,六:se,元:ji,允:su,伊:re,伕:ro,伐:wa,亥:yo,仿:ra,伉:ri,伙:ru,乩:ya,交:yu,丞:mu,丟:me,乒:mo,仰:xka,仳:xke,件:n,仲:o,用:no,甩:ha,甘:nu,生:ne,瓜:na,瓦:ni,玄:to,玉:do,氾:te,犯:de,汁:tsu,汀:zu,氐:ji,母:da,民:chi,立:mi,穴:ma,禾:po,示:bo,石:ho,矢:pe,矛:be,目:he,皿:pu,皮:bu,白:fu,疋:pi,申:bi,甲:hi,由:pa,田:ba,巨:e,左:o,市:ka,布:ga,平:ki,幼:gi,弁:ku,失:a,奶:i,它:u,旦:su,斥:ji,本:se,朮:zu,末:so,未:ze,正:ta,札:zo,弗:ke,弘:gu,戊:ko,必:ge,扔:sa,打:go,扑:shi,扒:za,曰:ri,月:ru,方:yo,日:ra,止:xwa,歹:wa,木:re,欠:ro,手:mo,扎:xya,戈:mu,戶:me,斗:yu,斤:xyo,支:ya,文:xuy,氏:n,毛:o,奈:奈}"));
		aoyinMap = UtilJson.json2Map(new JSONObject("{申亦:byo,夭斤:pyo,夭文:pyu,申乓:bya,申亙:byu,立亦:myo,匹不:dhi,立亙:myu,立乓:mya,斥乓:ja,民乓:cha,亢斤:gyo,斥亦:jo,民亦:cho,斥亙:ju,民亙:chu,夭扎:pya,亢文:gyu,亢扎:gya,甲亦:hyo,甲亙:hyu,甲乓:hya,扑亦:sho,氐乓:ja,五文:kyu,氐亙:ju,五斤:kyo,伉亦:ryo,氐亦:jo,伉亙:ryu,扑乓:sha,伉乓:rya,扑亙:shu,瓦亙:nyu,瓦乓:nya,五扎:kya,瓦亦:nyo,平乓:kya,平亙:kyu,夫斤:hyo,平亦:kyo,夫文:hyu,仄扎:sha,夫扎:hya,仄文:shu,仄斤:sho,卞文:nyu,卞扎:nya,卞斤:nyo,刈扎:ja,勾之:tse,刈文:ju,勾予:tso,刈斤:jo,null:null,心文:myu,心扎:mya,勾不:tsi,幼亙:gyu,勾丑:tsa,幼乓:gya,內中:zui,疋亦:pyo,元扎:ja,太斤:byo,疋亙:pyu,幼亦:gyo,曰斤:ryo,曰文:ryu,元斤:jo,太扎:bya,曰扎:rya,心斤:myo,元文:ju,太文:byu,疋乓:pya,切扎:cha,切斤:cho,切文:chu}"));
	}
	public static void main(String[] args) {
		String s = UtilJson.map2Json(aoyinMap).toString();
		System.out.println(s);
		
	}
	
	public  static String wordTransToRoman(String word){
		StringBuffer sb = new StringBuffer();
		while(!"".equals(word)){
			
			String orinal = new String(word);
			
			word = findAoyin(sb,word);
			word = findQingyin(sb,word);
			
			if(orinal.equals(word)){
//				throw new RuntimeException("森揭衄祥湔婓腔楷秞:"+word);
				//楹祒祥堤懂腔 祥楹祒ㄐ
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
