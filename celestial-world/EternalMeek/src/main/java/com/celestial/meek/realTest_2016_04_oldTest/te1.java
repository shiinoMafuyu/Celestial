package com.celestial.meek.realTest_2016_04_oldTest;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.celestial.agniRadiance.EzUtil.UtilCollection;
import com.celestial.agniRadiance.EzUtil.UtilString;
import com.celestial.agniRadiance.entity.FileReader;


@SuppressWarnings("unused")
public class te1 {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
//		t1();
//		t2();
//		te3();
		/*SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date()));*/
		/*System.out.println("xx".startsWith(""));
		System.out.println("xx".contains(""));*/
//		te4_LinkedHashMap();
//		teRegularExpression();
//		teSplit();
//		DBUtil3_parseTxt.checkContainTagHead("< REQ name=\"user_login\">");
//		teListRemove();
//		teAddArr();
//		teSplit();
		teTagHelp();
		
	}
	
	private static void teTagHelp() {
		FileReader f = new FileReader("C:/Users/Administrator/Desktop/parese2/e�ֻ�.txt");
		String head=".*<MEBS_MOBILE.*>.*",tail = ".*</MEBS_MOBILE>.*";
		List<Map<Integer,String>> lm = f.selectAllLineBetweenRegex(head,tail);
		List<String> li = UtilCollection.transMaptoList(lm.get(0));
		int title=1,r=0;
		
		System.out.println(123);
		/*TagHelper t = new TagHelper(li);
		System.out.println(t.getTag().getTagName());*/
		
	}

	private static void teAddArr() {
		String[] sArr1 = new String[]{"nn","mm"};
		String[] sArr2 = new String[]{"22","33"};
		
		String[] sArr3 = (String[])UtilCollection.combineArray(new String[][]{{"nn","mm"},{"22","33"}});
		List<Object[]> ls = new ArrayList<Object[]>();
		ls.add(sArr1);
		ls.add(sArr2);
		ls.add(sArr3);
		sArr3 = (String[])UtilCollection.combineArray(ls);
		
		System.out.println(1);
	}

	private static void teListRemove() {
		List<String> l = new ArrayList<String>(Arrays.asList(new String[]{"mashiro","yukino","shiino","mafuyu","yukino","hitagi"}));
		/*Util_Collection.print(l);
		Iterator<String> it = l.iterator();
		try {
			while(it.hasNext()){
				if(!it.next().equals("mafuyu"))
					it.remove();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		System.out.println("-----------------------------------------");
//		Util_Collection.print(l);
		List<String> lc = new CopyOnWriteArrayList<String>(l);
		UtilCollection.print(lc);
		
		int i = 0;
		for(String si : lc){
			if("yukino".endsWith(si)){
				if(i != 0)
					lc.remove(si);
				i++;
				
			}
		}
		

		
		System.out.println("-----------------------------------------");
		UtilCollection.print(lc);
		System.out.println("-----------------------------------------");
		
	}

	private static void teSplit() {
		//   ref = "queryAction" sub = "joker" type ="String"
		/*String s = "    HHH ";
		s = s.replaceAll("\\s+", " ");
		String[] sArr = s.split(" ");
		
		String ss="=";
		String[] ssArr = ss.split("=");
		System.out.println(ssArr.length);
		System.out.println(sArr[0]);*/
//		System.out.println(DBUtil3_parseTxt.matchAllRegx("54<oio?fasdfa?1>54", ".*<{1}.*\\?.*\\?.*>{1}.*"));
//		System.out.println(DBUtil3_parseTxt.matchAllRegx("<<ko?sbko>", ".*<{1}.*(?!(sb)).*>{1}.*"));
//		System.out.println(DBUtil3_parseTxt.matchAllSameRegx("sb", ".*sb.*"));
//		System.out.println(!DBUtil3_parseTxt.matchAllSameRegx("<x_?x>", ".*<{1}.*(\\?|<).*>{1}.*"));
		
		
//		String s = "ref = \"queryAction\" sub = \"joker\" type =\"String\"";//�����Ļ���ɶ��Ͳ��ܰ���" ",���ܾͲ���~
		String s =" futrue <   MUXI   ref = \"queryAction\" sub  =  \"joker\" type =\"String  ui\"  >yig<io ref = \"fvg\">yukino</io>< / MUXI > pop";
		int index1 = s.indexOf(">");
		int index2 = s.indexOf("<", index1);
		String tagName ="MUXI";
//		int index3 = s.indexOf("<{1}\\s*/\\s*"+tagName+"{1}\\s*>");
		String s2 = s.replaceAll("<{1}\\s*/{1}\\s*"+tagName+"{1}\\s*>", "</" + tagName +">");
		int index3 = s2.indexOf("</" + tagName +">");
		String innerTagString = s.substring(index2, s.indexOf("<{1}\\s*"+tagName+"{1}\\s*>", index2));
		s = s.replaceAll("\\s*(={1}\\s*)\"{1}", "=");
		String[] sArr = s.split("\"{1}\\s+");
		List<Object[]> l = new ArrayList<Object[]>();
		for(String si : sArr){
			String[] sR = si.split("=");
			if(sR.length == 2 && UtilString.notNullEmpty(sR[0]) && UtilString.notNullEmpty(sR[1])){
				l.add(sR);
			}else{
				throw new RuntimeException(new StringBuffer("�����ַ���").append(s).append("����������!").toString());
			}
		}
		System.out.println(s);
	}

	/**
	 * �ж��ַ����Ƿ�������
	 * @param str
	 * @return
	 */
	public static boolean isNumeric(String str)
	{
       Pattern pattern = Pattern.compile("[0-9]*");
       Matcher isNum = pattern.matcher(str);
       if( !isNum.matches() ) {
          return false;
       }
       return true;
	}
	
	private static void teRegularExpression() {
//		System.out.println(Pattern.compile("[a-z0-9A-Z]*").matcher("4324f52A").matches());
		System.out.println(Pattern.compile("\\s*").matcher("  ").matches());
	}


	private static void te4_LinkedHashMap() {
		Map<String,String> m = new LinkedHashMap<String, String>();
		m.put("�ռ�", "hello");
		m.put("ʱ��", "darkness");
		m.put("����", "my");
		m.put("����", "old");
		m.put("head", "friend");
		m.put("�޾�", "come");
		m.put("dio", "to");
		m.put("����", "talk");
		m.put("����", "with");
		m.put("�ټ�", "I");
		m.put("��", "again");		
		
		StringBuffer sb = new StringBuffer();
		Set<Entry<String, String>> it = m.entrySet();
		for(Entry<String, String> ei : it){
//			System.out.println(ei.getKey() + "  -->  " + ei.getValue());
			sb.append(ei.getValue()).append(' ');
		}
		System.out.println(sb.append('��').toString());
	}


	@SuppressWarnings("resource")
	public static void te3() throws Exception {
		BufferedReader br =new BufferedReader(new InputStreamReader(new FileInputStream("F:/����ͬ���ļ���/����ͬ���ļ���/00sentence/parse/33�ֵ���Ϣ.txt"),"utf-8"));
		StringBuffer sb = new StringBuffer();
		String s= null;
		while((s=br.readLine())!=null){
//			System.out.println("l.add(\""+s+"\");");
			sb.append(s);
		}
		System.out.println(sb.toString());
	}

	//ayase is here
	public static void t2() throws Exception {
		BufferedReader br =new BufferedReader(new InputStreamReader(new FileInputStream("F:/����ͬ���ļ���/����ͬ���ļ���/00sentence/parse/ע��.txt"),"gbk"));
		String s= null;
		while((s=br.readLine())!=null){
			System.out.println("l.add(\""+s+"\");");
//			System.out.println( s + " <br/>");
		}
		br.close();
	}

	public static void t1() {
		String[] sArr = new String[]{"2016-07-26  hao1 dhhhei 40.83  0.00  0.00  ","2016-07-26  000100000007 �Ǻ� 10,000.00  0.00  0.00  0.00  0.00  0.00  0.00  0.00  0.00  0.00  0.00  0.00  10,000.00  0.00  0.00  10,000.00  0.00  ",
				"2016-07-26  000100000013 ���� 999,855.97  0.00  0.00  0.00  0.00  0.00  0.00  0.00  0.00  0.00  0.00  0.00  999,855.97  0.00  0.00  1,000,119.97  264.00  ",
				"2016-07-26  000100000099 sad 9,979,966.70  0.00  0.00  0.00  0.00  0.00  0.00  0.00  0.00  0.00  0.00  0.00  9,979,966.70  0.00  0.00  9,979,966.70  0.00  ",
				"2016-07-26  000100000100 ces 9,983,119.20  0.00  0.00  0.00  0.00  0.00  0.00  0.00  0.00  0.00  0.00  0.00  9,983,119.20  0.00  0.00  9,983,185.20  66.00  ",
				"2016-07-26  000100000035 ����һ 10,000,000.00  0.00  0.00  0.00  0.00  0.00  0.00  0.00  0.00  0.00  0.00  0.00  10,000,000.00  0.00  0.00  10,000,000.00  0.00  ",
				"2016-07-26  000100000015 hanhan 10,007,317.30  0.00  0.00  0.00  0.00  0.00  0.00  0.00  0.00  0.00  0.00  0.00  10,007,317.30  0.00  0.00  10,007,317.30  0.00  ",
				"2016-07-26  000100000027 12456 100,000,000.00  0.00  0.00  0.00  0.00  0.00  0.00  0.00  0.00  0.00  0.00  0.00  100,000,000.00  0.00  0.00  100,000,000.00  0.00  ",
				"2016-07-26  000100009063 ���� 1,000,000,000.00  0.00  0.00  0.00  0.00  0.00  0.00  0.00  "};

		Double d = 0.0;
		for(int i = 0 ; i < sArr.length ; i++ ){
			String[] iArr = sArr[i].split(" ");
			System.out.println(iArr[3] + " --- " + iArr[4]);
			d+=Double.valueOf(iArr[4].replaceAll(",", ""));
		}
		d-=500;
		System.out.println(d);
		/*1,140,979,800.00
		  1,140,979,800.00*/
		System.out.println(d.toString());
		
	}

}
