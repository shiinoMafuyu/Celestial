package com.celestial.agniRadiance.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.celestial.agniRadiance.EzUtil.Util_Collection;

/**
 * <b>修改记录：</b> 
 * <p>
 * <li>
 * 
 *                        ---- Administrator 2016-8-15
 *  标签需满足的规范:
 *  1. <MEBS_MOBILE></MEBS_MOBILE> 这样成对出现<MEBS_MOBILE/>这样也行;<br/>
 *  2.中间可行属性值<MEBS_MOBILE ref ="jojo" sub="josiki"></MEBS_MOBILE><br/>
 *  3.<MEBS_MOBILE>这里为标签的value值</MEBS_MOBILE>,不管带不带子标签取value值取标签头的">"到下一个"<"之间的值.<br/>
 *  4.除了用作标签标识,其他地方不要写"<"或">";<br/>
 *  5.所有地方允许空格,写出你喜欢的格式吧<br/>
 * </li>
 * </p>
 * 
 * <b>类说明：</b>
 * <p> 
 * 
 * </p>
 */
public class TagHelper {
	/**-------------------老规矩 订了就不再改变的值------------------------ */
	/**
	 * 用于剖解的主体<br/>
	 */
	private List<String> lineList = new ArrayList<String>();

	
	/**-------------------老规矩 订了就不再改变的值------------------------ */
	private Tag tag = null;
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param args 
	 */
	@SuppressWarnings({ "unused"})
	public static void main(String[] args) {
		/*List<String> l  = new ArrayList<String>(Arrays.asList(new String[]{"mashiro","yukino","hitagi","kurise","ayase"}));
		l.add("o_o");
		List<String> l2  = DBUtil.copyListDeep(l);
		
		Iterator<String> iter = l.iterator();  
		while(iter.hasNext()){
			System.out.println("remove :" + iter.next());
			iter.remove();
		}
		
		System.out.println("打印l");
		Util_Collection.print(l);
		System.out.println("打印l2");
		Util_Collection.print(l2);*/
		
//		List<String> lineList = new ArrayList<String>(Arrays.asList(new String[]{"mashiro","yukino","hitagi","kurise","ayase"}));
		
		FileReader f = new FileReader("C:/Users/Administrator/Desktop/parese2/e现货.txt");
		String head=".*<MEBS_MOBILE>.*",tail = ".*</MEBS_MOBILE>.*";
		List<Map<Integer,String>> lm = f.selectAllLineBetweenRegex(head,tail);
		List<String> li = Util_Collection.transMaptoList(lm.get(0));
		Util_Collection.print(li);
		
		
		TagHelper t = new TagHelper(li);
		Util_Collection.printListMap(lm, false);
	}
	
	
	
	
	public TagHelper(List<String> lineList) {
		super();
		this.lineList = lineList;
		this.tag = new Tag(Util_Collection.transListToLine(lineList));
	}
	
	
	
	public List<String> getLineList() {
		return lineList;
	}
	
	
	
	public Tag getTag() {
		return tag;
	}




	
	
	
}
