package com.celestial.butterflystorm.zaza.japaneseTrans;

import java.util.LinkedHashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import com.celestial.agniRadiance.EzUtil.Util_Json;

public class Util_Japanese {
	
	private static Map<String, String> qingyinMap = new LinkedHashMap<String,String>();
	private static Map<String, String> aoyinMap = new LinkedHashMap<String,String>();

	static{
		qingyinMap = Util_Json.json2Map(new JSONObject("{づ:zu,つ:tsu,で:de,て:te,ち:chi,だ:da,っ:xtu,ぢ:ji,ね:ne,ぬ:nu,は:ha,の:no,ど:do,と:to,に:ni,な:na,ぴ:pi,ふ:fu,ぶ:bu,ぷ:pu,ば:ba,ぱ:pa,ひ:hi,び:bi,ぼ:bo,ぽ:po,ま:ma,み:mi,へ:he,べ:be,ぺ:pe,ほ:ho,ぇ:xe,う:u,ぅ:xu,い:i,ぃ:xi,あ:a,ぁ:xa,く:ku,ぎ:gi,き:ki,が:ga,か:ka,お:o,ぉ:xo,え:e,ざ:za,し:shi,ご:go,さ:sa,げ:ge,こ:ko,ぐ:gu,け:ke,ぞ:zo,た:ta,ぜ:ze,そ:so,ず:zu,せ:se,じ:ji,す:su,レ:re,ロ:ro,ワ:wa,ヨ:yo,ラ:ra,リ:ri,ル:ru,ヤ:ya,ユ:yu,ム:mu,メ:me,モ:mo,ヵ:xka,ヶ:xke,ン:n,ヲ:o,ノ:no,ハ:ha,ヌ:nu,ネ:ne,ナ:na,ニ:ni,ト:to,ド:do,テ:te,デ:de,ツ:tsu,ヅ:zu,ヂ:ji,ダ:da,チ:chi,ミ:mi,マ:ma,ポ:po,ボ:bo,ホ:ho,ペ:pe,ベ:be,ヘ:he,プ:pu,ブ:bu,フ:fu,ピ:pi,ビ:bi,ヒ:hi,パ:pa,バ:ba,エ:e,オ:o,カ:ka,ガ:ga,キ:ki,ギ:gi,ク:ku,ア:a,イ:i,ウ:u,ス:su,ジ:ji,セ:se,ズ:zu,ソ:so,ゼ:ze,タ:ta,ゾ:zo,ケ:ke,グ:gu,コ:ko,ゲ:ge,サ:sa,ゴ:go,シ:shi,ザ:za,り:ri,る:ru,よ:yo,ら:ra,ゎ:xwa,わ:wa,れ:re,ろ:ro,も:mo,ゃ:xya,む:mu,め:me,ゆ:yu,ょ:xyo,や:ya,ゅ:xuy,ん:n,を:o,ー:ー}"));
		aoyinMap = Util_Json.json2Map(new JSONObject("{ビョ:byo,ぴょ:pyo,ぴゅ:pyu,ビャ:bya,ビュ:byu,ミョ:myo,でぃ:dhi,ミュ:myu,ミャ:mya,ジャ:ja,チャ:cha,ぎょ:gyo,ジョ:jo,チョ:cho,ジュ:ju,チュ:chu,ぴゃ:pya,ぎゅ:gyu,ぎゃ:gya,ヒョ:hyo,ヒュ:hyu,ヒャ:hya,ショ:sho,ヂャ:ja,きゅ:kyu,ヂュ:ju,きょ:kyo,リョ:ryo,ヂョ:jo,リュ:ryu,シャ:sha,リャ:rya,シュ:shu,ニュ:nyu,ニャ:nya,きゃ:kya,ニョ:nyo,キャ:kya,キュ:kyu,ひょ:hyo,キョ:kyo,ひゅ:hyu,しゃ:sha,ひゃ:hya,しゅ:shu,しょ:sho,にゅ:nyu,にゃ:nya,にょ:nyo,ぢゃ:ja,つぇ:tse,ぢゅ:ju,つぉ:tso,ぢょ:jo,null:null,みゅ:myu,みゃ:mya,つぃ:tsi,ギュ:gyu,つぁ:tsa,ギャ:gya,ずい:zui,ピョ:pyo,じゃ:ja,びょ:byo,ピュ:pyu,ギョ:gyo,りょ:ryo,りゅ:ryu,じょ:jo,びゃ:bya,りゃ:rya,みょ:myo,じゅ:ju,びゅ:byu,ピャ:pya,ちゃ:cha,ちょ:cho,ちゅ:chu}"));
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
//				throw new RuntimeException("此处有不存在的发音:"+word);
				//翻译不出来的 不翻译！
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
