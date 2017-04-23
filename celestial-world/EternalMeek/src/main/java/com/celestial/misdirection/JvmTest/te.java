package com.celestial.misdirection.JvmTest;

import java.util.List;
import java.util.Map;

import com.celestial.agniRadiance.EzUtil.Util_Collection;
import com.celestial.agniRadiance.entity.FileReader;
import com.celestial.agniRadiance.entity.Tag;
/**
 * 
 * <b>修改记录：</b> 
 * <p>
 * <li>
 * 
 *                        ---- Administrator 2016-9-9
 * </li>
 * </p>
 * 
 * <b>类说明：没有卵用类 555</b>
 * <p> 
 * 
 * </p>
 */
@SuppressWarnings("unused")
public class te {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		teTextReaderNewFunction();
//		System.out.println("".equals(null));
		teTagHelper2();
		teTagHelper3();
		
		/*String s = "MEBS_MT REP RESULT RETCODE";
		String regex = ".*RESULT .* RETCODE.*";
		System.out.println(DBUtil3_parseTxt.matchAllSameRegx(s, regex));*/
	}
	
	private static void teTagHelper3() {
		FileReader f = new FileReader("C:/Users/Administrator/Desktop/c.xml");
		String headRegex = ".*<USERCASE.*";
		String tailRegex = ".*</USERCASE>.*";
		//  编写测试 Tag t = test_And_Verify(input,out); input out为xml标签   (不需要用时 不用) 
		// 获取子标签方式不用正则表达式
	}

	private static void teTagHelper2() {
		FileReader f = new FileReader("C:/Users/Administrator/Desktop/c.xml");
		String headRegex = ".*<USERCASE.*";
		String tailRegex = ".*</USERCASE>.*";
		FileReader f2 = f.selectAllLineBetweenRegex2(headRegex, tailRegex);
		List<List<String>> ll = f2.selectAllLineBetweenRegexList(".*<MEBS_MT>.*", ".*</MEBS_MT>.*");
		
	}

	private static void teTextReaderNewFunction() {
		FileReader f = new FileReader("C:/Users/Administrator/Desktop/c.xml",false);
		String headRegex = ".*<USERCASE.*";
		String tailRegex = ".*</USERCASE>.*";
		FileReader f2 = f.selectAllLineBetweenRegex2(headRegex, tailRegex);
		List<List<String>> ll = f2.selectAllLineBetweenRegexList(".*<INPUT>.*", ".*</INPUT>.*");
		
		Util_Collection.print(ll.get(0));
		List<Map<Integer,String>> lx = f.selectAllLineBetweenRegex(headRegex, tailRegex);
	}

	public String removeVersionTitile(String tagString) {
//		tagString = tagString.replaceAll("<{1}\\s*?", "<?").replaceAll("?\\s*>", "?>");
		tagString = tagString.replaceAll("<{1}\\s*\\?.*\\?\\s*>{1}", "");
		return tagString;
	}
}
