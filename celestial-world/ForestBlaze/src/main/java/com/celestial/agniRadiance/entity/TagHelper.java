package com.celestial.agniRadiance.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.celestial.agniRadiance.EzUtil.Util_Collection;

/**
 * <b>�޸ļ�¼��</b> 
 * <p>
 * <li>
 * 
 *                        ---- Administrator 2016-8-15
 *  ��ǩ������Ĺ淶:
 *  1. <MEBS_MOBILE></MEBS_MOBILE> �����ɶԳ���<MEBS_MOBILE/>����Ҳ��;<br/>
 *  2.�м��������ֵ<MEBS_MOBILE ref ="jojo" sub="josiki"></MEBS_MOBILE><br/>
 *  3.<MEBS_MOBILE>����Ϊ��ǩ��valueֵ</MEBS_MOBILE>,���ܴ������ӱ�ǩȡvalueֵȡ��ǩͷ��">"����һ��"<"֮���ֵ.<br/>
 *  4.����������ǩ��ʶ,�����ط���Ҫд"<"��">";<br/>
 *  5.���еط�����ո�,д����ϲ���ĸ�ʽ��<br/>
 * </li>
 * </p>
 * 
 * <b>��˵����</b>
 * <p> 
 * 
 * </p>
 */
public class TagHelper {
	/**-------------------�Ϲ�� ���˾Ͳ��ٸı��ֵ------------------------ */
	/**
	 * �����ʽ������<br/>
	 */
	private List<String> lineList = new ArrayList<String>();

	
	/**-------------------�Ϲ�� ���˾Ͳ��ٸı��ֵ------------------------ */
	private Tag tag = null;
	
	/**
	 * <b>����˵����</b>
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
		
		System.out.println("��ӡl");
		Util_Collection.print(l);
		System.out.println("��ӡl2");
		Util_Collection.print(l2);*/
		
//		List<String> lineList = new ArrayList<String>(Arrays.asList(new String[]{"mashiro","yukino","hitagi","kurise","ayase"}));
		
		FileReader f = new FileReader("C:/Users/Administrator/Desktop/parese2/e�ֻ�.txt");
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
