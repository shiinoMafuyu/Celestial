package com.celestial.meek.realTest_2016_09;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import com.celestial.agniRadiance.EzUtil.Util_Collection;
import com.celestial.butterflystorm.classcreator.silence.Conf;

public class te {

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param args 
	 */
	
	public static void main(String[] args) {
//		System.out.println(" = +".replaceAll("\\+", "\"+\""));
//		DBUtil.forCMD(new File("E:/anotherDeskTop/parese2/fall/te/E现货--手机客户端与服务器通信协议.docx"), new File("E:/anotherDeskTop/parese2/fall/te/1"));
		//E:\HackingGate\03_2016-08-20_开发一部时的补丁文件\补丁包\=0001宁夏绿巨人
//		DBUtil.findFile("jquery.validationEngine-zh_CN.js",new File("E:/HackingGate/03_2016-08-20_开发一部时的补丁文件/补丁包/=0001宁夏绿巨人"));
//		DBUtil.findFile("jquery.validationEngine-zh_CN.js",new File("C:/Users/Administrator/Documents/新项目开发/02多级返佣/"));
		
		/*DBUtil3_parseTxt.matchAllSameRegx(" ref=\"MESSAGE\" type=\" String\"", "");
		String[] sArr = " ref=\"MESSAGE\" type=\" String\"".split("[^=]{1}\"{1}\\s+");
		System.out.println(sArr[0]);*/
		
		/*Map<String,String> map = DBUtil3_parseTxt.___getPropertyMap(" ref = \" MESS AGE \" type=\" String \" ");
		System.out.println(map.get("ref"));*/
		
		
		/*Tag t = new Tag("<FFF 总会 = \"大中华区\" 分会=\"大日本区 大亚美利坚区\">汽油与火把<QAQ>沧浪之水,清兮<LIK>可以振吾衣<F yi=\"隐藏得很深\">沧浪之水浊兮,可以涤吾足</F><HH></HH></LIK></QAQ></FFF>");
		System.out.println(t.getTagName());*/
		
//		teDeepCopyMap();
//		teDeepCopyMap2();
//		System.out.println(DBUtil3_parseTxt.matchAllSameRegx("fffdfffdfd1jd", "[^<>1234]*"));
		int i=0;
		System.out.println(i++ + i++);
	}

	
	private static void teDeepCopyMap2() {
		//非常奇怪,map的泛型进去的时候不能定型.而出来的时候又可以...
		Map m1 = new HashMap();
		m1.put("f1", new File("xxx"));
		Map m2 = Util_Collection.deepCopyMap(m1);
		System.out.println(((File)m2.get("f1")).getAbsolutePath());
		System.out.println(1);
	}

	@SuppressWarnings({ "unused", "unchecked", "rawtypes" })
	private static void teDeepCopyMap() {
		Map m = Conf.responseInnerClassNameMap ,mx;
		System.out.println(Conf.responseInnerClassNameMap.get("frozen"));
		mx = Util_Collection.deepCopyMap(m);
		//ORP=OrderPictureList
		
		mx.put("frozen", "Summer");
		mx.put("ORP", "你好什么鬼!");
		System.out.println(mx.get("ORP"));
		//key value 对象被重新创建了.
		System.out.println(Conf.responseInnerClassNameMap.get("ORP"));
	}

	
}
