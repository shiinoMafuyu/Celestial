package com.celestial.meek.realTest_2016_09;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import com.celestial.agniRadiance.EzUtil.Util_Collection;
import com.celestial.butterflystorm.classcreator.silence.Conf;

public class te {

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param args 
	 */
	
	public static void main(String[] args) {
//		System.out.println(" = +".replaceAll("\\+", "\"+\""));
//		DBUtil.forCMD(new File("E:/anotherDeskTop/parese2/fall/te/E�ֻ�--�ֻ��ͻ����������ͨ��Э��.docx"), new File("E:/anotherDeskTop/parese2/fall/te/1"));
		//E:\HackingGate\03_2016-08-20_����һ��ʱ�Ĳ����ļ�\������\=0001�����̾���
//		DBUtil.findFile("jquery.validationEngine-zh_CN.js",new File("E:/HackingGate/03_2016-08-20_����һ��ʱ�Ĳ����ļ�/������/=0001�����̾���"));
//		DBUtil.findFile("jquery.validationEngine-zh_CN.js",new File("C:/Users/Administrator/Documents/����Ŀ����/02�༶��Ӷ/"));
		
		/*DBUtil3_parseTxt.matchAllSameRegx(" ref=\"MESSAGE\" type=\" String\"", "");
		String[] sArr = " ref=\"MESSAGE\" type=\" String\"".split("[^=]{1}\"{1}\\s+");
		System.out.println(sArr[0]);*/
		
		/*Map<String,String> map = DBUtil3_parseTxt.___getPropertyMap(" ref = \" MESS AGE \" type=\" String \" ");
		System.out.println(map.get("ref"));*/
		
		
		/*Tag t = new Tag("<FFF �ܻ� = \"���л���\" �ֻ�=\"���ձ��� ������������\">��������<QAQ>����֮ˮ,����<LIK>����������<F yi=\"���صú���\">����֮ˮ����,���Ե�����</F><HH></HH></LIK></QAQ></FFF>");
		System.out.println(t.getTagName());*/
		
//		teDeepCopyMap();
//		teDeepCopyMap2();
//		System.out.println(DBUtil3_parseTxt.matchAllSameRegx("fffdfffdfd1jd", "[^<>1234]*"));
		int i=0;
		System.out.println(i++ + i++);
	}

	
	private static void teDeepCopyMap2() {
		//�ǳ����,map�ķ��ͽ�ȥ��ʱ���ܶ���.��������ʱ���ֿ���...
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
		mx.put("ORP", "���ʲô��!");
		System.out.println(mx.get("ORP"));
		//key value �������´�����.
		System.out.println(Conf.responseInnerClassNameMap.get("ORP"));
	}

	
}
