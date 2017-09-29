package com.celestial.meek.realTest_2016_10;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.celestial.agniRadiance.EzUtil.UtilFile;
import com.celestial.agniRadiance.EzUtil.UtilString;

public class DBUtil3_parseTxt {

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param args 
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		
		
	}

	
	
	
	
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ��(��)�����ı�<br/>
	 * andչʾ��Ϣ~��������ȥ������
	 * </ul>
	 * @param filePath �ļ�λ��
	 * @param startFlag ��ʼ����
	 * @param showPart Ҫչʾ�Ĳ���
	 */
	public static void paresSimpleAndShow(String filePath, String startFlag,
			String showPart,String titleRegex) {
		DBUtil3_parseTxt.print(DBUtil3_parseTxt.gentleParse(DBUtil3_parseTxt.getTxtList(filePath,startFlag,titleRegex)),showPart);
	}

	/**
	 * 
	 * <b>����˵����</b>
	 * <ul>
	 * չʾ����������˵���Ϣ~<br/>
	 * ��Ҫ�Ǵ�ӡ����,����ճ���õ�<br/>
	 * ����copy~ 
	 * </ul>
	 * @param lm
	 * @param part
	 */
	public static void print(List<List<Object>> lm, String part) {
		//{"SI","SessionID","Long","�û��Ựid"},
		String[] sArr = null;
		String st = null;
		for(List<Object> i : lm){
			String partMsg = (String)i.get(0);
			if(!partMsg.startsWith(part))
				continue;
			System.out.println(partMsg);
			for(int j = 1 ; j < i.size() ; j++){
				sArr = (String[])i.get(j);
				st = "{\""+sArr[0]+"\",\""+sArr[1]+"\",\""+sArr[2]+"\",\""+sArr[3]+"\"},";
				System.out.println(st);
			}
		}
		
	}





	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ����lp�е�ÿһ��List<String><br/>
	 * �����List<String>�е�һ��Stringһ�к��������ı�ǩ��ͷ�ͽ�β,��֮תΪ����Ϊ4���ַ����������һ��List<Object>��,��������<br/>
	 * ���ؽ��ʵΪList<List<String[]>>��ʽ<br/>
	 * </ul>
	 * @param ��������xml��ǩ����Ҫ����������List<String>�ļ���
	 * @return
	 */
	public static List<List<Object>> gentleParse(
			List<List<String>> lp) {
		List< List<Object>>  l = new ArrayList<List<Object>>();
		List<Object> lo = null;
		for(List<String> list : lp){
			lo = new ArrayList<Object>();
			lo.add(list.get(0));
			for(String si : list){
				String  tag = DBUtil3_parseTxt.rowTagRecognize(si);
				if(tag != null){
					String[] sArr = DBUtil3_parseTxt.getArr(si,tag);
					lo.add(sArr);
				}
			}
			l.add(lo);
		}
		return l;
	}



	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ����һ�к���������ǩ���ַ���<UI>�û���</UI>UserID,������װ��һ�����鷵��<br/>
	 * ��ʽ{"UI","UserID","","�û���"}<br/>
	 * </ul>
	 * @param line
	 * @return
	 */
	private static String[] getArr(String line , String tag) {
		//{"SI","SessionID","Long","�û��Ựid"},
		String[] sArr = new String[4];
		sArr[0] = tag ;
		String tagStart = "<" + tag + ">";
		String tagEnd = "</" + tag + ">";
		sArr[1] = line.substring(line.indexOf(tagEnd) + tagEnd.length()).trim();
		sArr[2] = "";
		sArr[3] = line.substring(line.indexOf(tagStart)+tagStart.length(), line.indexOf(tagEnd)).trim();
		return sArr;
	}


	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ����һ���ַ���,������к���<UI></UI>�����ɶԵı�ǩ���ر�ǩ��UI;<br/>
	 * </ul>
	 * @param si
	 * @return
	 */
	public static String rowTagRecognize(String str) {
		String tag = null;
		if(str.contains("<") && str.contains(">")){
			tag = str.substring(str.indexOf("<")+1, str.indexOf(">"));
		}
		if(!str.contains("</"+tag+">"))
			tag = null;
		return tag;
	}

	static Map<String,List<String>> mps = new HashMap<String, List<String>>();
	static List<List<String>> lps = new ArrayList<List<String>>();
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ����filePathָ����ļ�,�Ѵӵ����п�ʼ������,��titleRegexָʾ�ı���ֿ�<br/>
	 * ����List<String>��,�ٰ���ЩList<String>����һ����List�з���<br/>
	 * 
	 * </ul>
	 * @param filePath �ļ�·��
	 * @param titleRegex ������ʽ����ʽ
	 * @return
	 */
	public static List<List<String>> getTxtList(String filePath, String titleRegex) {
		return DBUtil3_parseTxt.getTxtList(filePath,"",titleRegex);
	}
	
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ����filePathָ����ļ�,�Ѵ�flagString��ʼ�������,��titleRegexָʾ�ı���ֿ�<br/>
	 * ����List<String>��,�ٰ���ЩList<String>����һ����List�з���<br/>
	 * 
	 * </ul>
	 * @param filePath �ļ�·��
	 * @param flagString ��ʼλ��
	 * @param titleRegex ������ʽ����ʽ
	 * @return
	 */
	@SuppressWarnings("resource")
	public static List<List<String>> getTxtList(String filePath, String flagString,String titleRegex) {
		List<List<String>> l = new ArrayList<List<String>>();
		List<String> lt = new ArrayList<String>();
		boolean startFlag = false ;
		
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
			String s = null;
			while((s = br.readLine()) != null ){
				if(s != null && s.contains(flagString))
					startFlag = true ;
				s = s.trim();
				if(!startFlag)
					continue;
				if(UtilString.matchHeadRegx(s,titleRegex)){
					lt = new ArrayList<String>();
					l.add(lt);
				}
				lt.add(s);
			}
		} catch (Exception e) {
			UtilFile.close(br);
			throw new RuntimeException("�ļ���ȡ������~");
		}
		
		return l;
	}
	



	
	/**===================================================================================================
	 * <b>����˵����</b>
	 * <ul>
	 * ����ǩ������<br/>
	 * һ����ǩ�Ŀ�ʼ<TName>�����</TName>ֻ����һ��<br/>
	 * ֧��<TName />��ʽ<br/>
	 * </ul>
	 * @param txtString
	 * @param tag 
	 * @return
	 */
/*	public static boolean checkTagCompleted(String txtString, String tag) {
		String tagStart = "<"+tag;
		String tagEnd = "</"+tag+">";
		String s = matchAndReduce(txtString,tagStart,tagEnd);
		return false;
	}*/

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * �ݹ���
	 * </ul>
	 * @param txtString
	 * @param tagStart
	 * @param tagEnd
	 * @return
	 */
/*	private static String matchAndReduce(String txtString, String tagStart,
			String tagEnd) {
		if(txtString.contains(tagStart)){
			//<FBACALL><ff/>POLICE<MEBS_MOBILE ref="�Ҳ�������" sub="�绰����" ><REQ ref="qqq" sub=-"ppp"><I sub="Information" type="String">��Ϣ</I><FI sub="FirmID" type="String" >������ID</FI><PRI sub="Price" type="Double">�۸�</PRI></REQ></MEBS_MOBILE>ooooooooooooooo
			String s = "";
			int index1 = txtString.lastIndexOf(tagStart);
//			int index2 = txtString.
		}
		return null;
	}*/

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ��ʱ�����������ı���ȡÿ����n.x��ͷ�ı���ĺ�<MEBS_MOBILE></MEBS_MOBILE>֮������ݵ�<br/>
	 * ����˵����û���κ�����<br/>
	 * ������ܲ��ǿ�ͨ���Ե�Ԫ��ƴ��������,��һ�ξͶ��˵�����<br/>
	 * </ul>
	 * @throws Exception
	 */
/*	@SuppressWarnings("unused")
	protected static void pares1() throws Exception {
		String[] filterString =new String[]{"?xml","version"};
		
		List<String[]> ls2 = new ArrayList<String[]>();
		ls2.add(new String[]{"U","UserID","String","�û�id"});
		//����ȡ�� ����  ���ϴ����ַ���
		
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(new File("F:/����ͬ���ļ���/����ͬ���ļ���/00sentence/parse/r1.txt"))));
		
		BufferedReader br =new BufferedReader(new InputStreamReader(new FileInputStream("F:/����ͬ���ļ���/����ͬ���ļ���/00sentence/parse/parse3.txt"),"gbk"));
		String s = null;
		String title = null;
		int MEBS_MOBILE_num = 2 ;
		int i = 1;
		
		boolean inMEBS_MOBILE =false;
		
		while((s=br.readLine())!=null){
			
			if(s.contains(i+". ")){
				System.out.println(s);
				pw.println(s);
				i++;
				title = s ;
			}
			if(title != null){//title !=null ��ʾ����ȡ����MEBS_MOBILE ;
				if(s.contains("<MEBS_MOBILE>")){
					inMEBS_MOBILE = true;
					s = "<MEBS_MOBILE title=\""+title+"\">";
				}
				else if(s.contains("</MEBS_MOBILE>")){
					inMEBS_MOBILE = false;
					MEBS_MOBILE_num --;
				}
				if(MEBS_MOBILE_num ==0){
					MEBS_MOBILE_num = 2;
					title = null;
				}
				if(inMEBS_MOBILE || s.contains("<MEBS_MOBILE>") || s.contains("</MEBS_MOBILE>")){
					System.out.println(s.trim());
					pw.println(s.trim());
				}
			}
		}
		br.close();
		pw.flush();
		pw.close();
	}*/


	/**
	 * <b>����˵����</b>
	 * <ul>
	 * stringList�м���ǩ�Ƿ�����<br/>
	 * </ul>
	 * @param stringList
	 * @return
	 */
/*	public static boolean checkTagCompleted(List<String> stringList) {
		boolean b = true;
		List<String> l = new CopyOnWriteArrayList<String>(stringList);
		for(String si : l){
			boolean bb = DBUtil3_parseTxt.checkTagCompletedSimpleWay(si);
			String sx = DBUtil3_parseTxt.checkContainTagHead(si);
			
		}
		
		
		return b;
	}*/

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ����ǩ�ǲ�����<FUCk />������ʽ��������<br/>
	 * ������<  FUCK sub="fuckyou"  /  ><br/>
	 * ���ֲ���<  FU CK sub = "fuckyou" / ><br/>
	 * ����ֻ�ܺ���һ������"="ƥ����ַ���,��ֻ����"<"֮���һ��<br/>
	 * </ul>
	 * @param si
	 * @return
	 */
//	public static boolean checkTagCompletedSimpleWay(String si) {
//		//depress
//		boolean b = false ;
//		if(Util_String.matchAllSameRegx(si, ".*<{1}.*/{1}\\s+>{1}")){
////			String s = 
//		}
//		return b;
//	}

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * �ж�һ��String���Ƿ����һ����ǩͷ<FUCK > <br/>
	 * �ж�����˳�����"<"��">",�м䲻����1"?"��"<"(ȡ��ʱ���Ե�һ��">"Ϊ׼���Բ����ж������Ƿ��ж����">"��)<br/>
	 * һ���ڲ�Ҫ���ж����ǩ<br/>
	 * ע:<FUCK />������ʽ������
	 * </ul>
	 * @param readLine
	 * @return 
	 */
/*	public static String checkContainTagHead(String str) {
		String sb = null;
		if(Util_String.matchAllSameRegx(str, ".*<{1}.*>{1}.*") && !Util_String.matchAllSameRegx(str, ".*<{1}.*(\\?|<).*>{1}.*") ){
			String s = str.substring(str.indexOf('<')+1, str.indexOf('>'));
			//�Ⱥ�����
			
//			sb = ___checkAndGetTheFirstWord(s);
			
		}
		
		return sb;
	}*/

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ref = "queryAction" sub = "joker" type ="String"<br/>
	 * �Կո�͵ȺŴ��ȥ��Ϊ�յ��ַ���.
	 * </ul>
	 * @param st
	 * @return
	 */
/*	public static Map<String, String> __getPropertyMap(String st) {
		String[] sArr = DBUtil3_parseTxt.split(st, new String[]{"="," "});
		if(sArr.length%2!=0){
			throw new RuntimeException("��ǩ���Դ���~");
		}
		Map<String,String> map = new LinkedHashMap<String, String>();
		for(int i = 0 ; i + 2 < sArr.length ; i+=2){
			map.put(sArr[i], sArr[i+1]);
		}
		return map;
	}*/

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * Ⱦһ���ַ��������ַ��Ŵ��
	 * </ul>
	 * @param s
	 * @param regexArr
	 * @return
	 */
/*	private static String[] split(String s, String[] regexArr) {
		String[] sArr = s.split("\\s+");
		List<Object[]> ls = new ArrayList<Object[]>();
		for(String si : sArr){
			ls.add(si.split("="));
		}
		sArr = (String[])Util_File.arrayCombine(ls);
		return sArr;
	}*/
	
}
