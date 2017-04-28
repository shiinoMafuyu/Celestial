package com.celestial.agniRadiance.entity;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import com.celestial.agniRadiance.EzUtil.Util_Collection;
import com.celestial.agniRadiance.EzUtil.Util_File;
import com.celestial.agniRadiance.EzUtil.Util_String;


public class FileReader {
	
	/**---------------��ʼ����ֵ���ٸı�---------------------*/
	private String filePath = "";
	private String fileName = "";
	private List<String> lineList = new ArrayList<String>();
	/**---------------��ʼ����ֵ���ٸı�---------------------*/
	
	/**---------------���� ����---------------------------*/
	/**
	 * indexָ����һ��<br/>
	 * ����㹻�����Ļ�������ʶ�����º���:<br/>
	 * 1. currentLine ����index��ָ�������<br/>
	 * 2. index����ʼ���Ļ���С�ܵ� 0,Ҳ��������һ�ζ�ȡ����Ϊ0.��ǰcurrentLine Ϊnull; <br/>
	 * 3.currentLine Ϊ���ǽṹ������  + ����ʹ��  ,currentLine����Ϊ������һ������read������,��ȡ������.
	 */
	private int index = 0;
	private String currentLine = null;
	
	/**---------------���� ����---------------------------*/
	
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param args 
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		FileReader f = new FileReader("C:/Users/Administrator/Desktop/kimo`/vendo_response/MyCmdQueryResponseVO.java");
		//�����ַ���
//		List<String> st = f.selectLineStartWith("public");
//		List<String> st2 = f.selectLineEndWith("public");
		List<String> st3 = f.selectLineStartEndContain("","","*","����");
		for(String s : st3){
			System.out.println(s);
		}
		
		//�ҵ�ĳһ��,ĳ���� ; ����LineList
		f.setIndex(4);
		String s = f.readLine();
		String s2 =f.readCurrentLine();
		
		String s3 = f.readBeforeLine(1);
		String s31 = f.readBeforeLine1();
		
		String s4 = f.readNextLine();
		String s5 = f.readNextLine(3);
		
		String s6 = f.readNextLine1();
	}
	
	/**
	 * ����һ��FileReader�� <br/>
	 * �ļ�·������"/"�ָ�.<br/>
	 * Ĭ����trim()��ʽ��ȡ <br/>
	 * <b>���췽��</b>
	 * <br/>
	 * @param filePath �ļ�·��
	 */
	public FileReader(String filePath) {
		super();
		init(filePath,null,true);
	}
	
	/**
	 * ����һ��FileReader��<br/>
	 * �ļ�·������"/"�ָ�.<br/>
	 * <b>���췽��</b>
	 * <br/>
	 * @param filePath �ļ�·��
	 * @param isTrim �Ƿ���Ҫtrim ;Ĭ��true;
	 */
	public FileReader(String filePath,boolean isTrim) {
		super();
		init(filePath,null,isTrim);
	}
	
	/**
	 * ����һ��FileReader��<br/>
	 * �ļ�·������"/"�ָ�.<br/>
	 * <b>���췽��</b>
	 * <br/>
	 * @param filePath �ļ�·��
	 * @param isTrim �Ƿ���Ҫtrim ;Ĭ��true;
	 * @param charset ��ȡʱ���ַ���
	 */
	public FileReader(String filePath,boolean isTrim , String charset) {
		super();
		init(filePath,charset,isTrim);
	}
	
	private void init(String filePath ,String charset,boolean isTrim){
		if(filePath.contains("\\"))
			filePath = filePath.replaceAll("\\\\", "/");
		this.filePath = filePath;
		File f = new File(filePath);
		if(!(f.exists() && f.isFile()))
			throw new RuntimeException("ָ���ļ������ڻ����ļ�!" + filePath);
		lineList = Util_File.readFileLineToList(filePath,charset,isTrim);
		this.fileName = filePath.substring(filePath.lastIndexOf("/")+1);
		
	}

	public FileReader(List<String> lineList) {
		super();
		this.lineList = lineList;
	}
	
	public FileReader(File file) {
		String path = file.getAbsolutePath().replaceAll("\\\\", "/");
		init(path, null, true);
	}

	/**
	 * <b>���췽��</b>
	 * <br/>
	 * @param file
	 * @param charset
	 * @param isTrim
	 */
	public FileReader(File file,String charset,boolean isTrim) {
		String path = file.getAbsolutePath().replaceAll("\\\\", "/");
		init(path, charset, isTrim);
	}
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ��ȡ��һ������,λ�ò�����ת<br/>
	 * </ul>
	 * @return
	 */
	public String readNextLine1() {
		return readNextLine1(1);
	}

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ��ȡ����n������,λ�ò�����ת
	 * </ul>
	 * @param n
	 * @return
	 */
	public String readNextLine1(int n) {
		return readBeforeLine1(-n);
	}

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ��ȡǰһ�е�ֵ,�кŲ�����;
	 * </ul>
	 * @return
	 */
	public String readBeforeLine1() {
		return readBeforeLine1(1);
	}


	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ��ȡǰn�е�ֵ,�кŲ�����
	 * </ul>
	 * @param n
	 * @return
	 */
	public String readBeforeLine1(int n) {
		int i = checkIndex(index - n);
		currentLine = lineList.get(i);
		return currentLine;
	}
	
	
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ��ȡ�����n�е����������������ж�ȡ���������;<br/>
	 * �����readNextLine1(),�˷���������������ȡ��.<br/>
	 * </ul>
	 * @param n
	 * @return
	 */
	public String readNextLine(int n) {
		return readBeforeLine(-n);
	}

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ��ȡ��һ��<br/>
	 * �����readNextLine1(),�˷���������ع�����ȡ��.<br/>
	 * </ul>
	 * @return
	 */
	public String readNextLine() {
		return readBeforeLine(-1);
	}

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ��ȡ��һ������ <br/>
	 * �����readBeforeLine1(),�˷���������������ȡ��.<br/>
	 * </ul>
	 * @return
	 */
	public String readBeforeLine() {
		return readBeforeLine(1);
	}

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ��ȡǰn������<br/>
	 * �����readBeforeLine1(),�˷���������������ȡ��.<br/>
	 * </ul>
	 * @param n ��ȡ֮ǰn�е�����;
	 * @return
	 */
	public String readBeforeLine(int n) {
		index = checkIndex(index - n);
		currentLine = lineList.get(index);
		return currentLine;
	}

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ��ȡ��ǰ��
	 * </ul>
	 * @return
	 */
	public String readCurrentLine() {
		return currentLine;
	}
	
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ��ȡ��һ������
	 * </ul>
	 * @return
	 */
	public String readLine() {
		return readLine(index);
	}
	
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ��ȡ��n�е����� <br/>
	 * �α�����ô�<br/>
	 * </ul>
	 * @param i
	 * @return
	 */
	public String readLine(int n) {
		index = checkIndex(n);
		currentLine = lineList.get(index);
		index ++;
		return currentLine;
	}
	
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * �����ļ�����headWords��ͷ; ��taiWords��β ;���Ұ���containWords�ľ���; <br/>
	 * ���������� ����ĳһ��ֱ�Ӵ���null����""���� <br/>
	 * �����Ļ����������Ĭ��Ϊtrue <br/>
	 * </ul>
	 * @param headWords ��ͷ��
	 * @param taiWords ��β��
	 * @param containWords ������
	 * @return
	 */
	public List<String> selectLineStartEndContain(String headWords,
			String taiWords, String ...containWords) {
		if(headWords == null)
			headWords = "";
		if(taiWords == null)
			taiWords = "";
		if(containWords == null)
			containWords = new String[]{""};
		
		List<String> l = new ArrayList<String>();
		for(String si : lineList){
			if(si.startsWith(headWords) && si.endsWith(taiWords) && Util_Collection.containAll(containWords, si)){
				l.add(si);
			}
				
		}
		return l;
	}
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * Map��ʽ<�к�,��Ӧ���ַ���>
	 * �����ļ�����headWords��ͷ; ��taiWords��β ;���Ұ���containWords�ľ���; <br/>
	 * ���������� ����ĳһ��ֱ�Ӵ���null����""���� <br/>
	 * �����Ļ����������Ĭ��Ϊtrue <br/>
	 * </ul>
	 * @param headWords ��ͷ��
	 * @param taiWords ��β��
	 * @param containWords ��Ҫ�������ַ�������
	 * @return
	 */
	public Map<Integer, String> selectLineStartEndContainMap(String headWords,
			String taiWords, String[] containWords) {
		return selectLineStartEndContainMap(headWords,taiWords,"",containWords);
		
	}
	
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * LinkedHashMap��ʽ������headWords��ͷ,��taiWords��β��ƥ��������ʽ���� <br/>
	 * �������ʹ����""��ʾ����<br/>
	 * <br/>
	 * </ul>
	 * @param headWords ��ͷ��
	 * @param taiWords ��β��
	 * @param regx ������ʽ
	 * @return
	 */
	public Map<Integer, String> selectLineStartEndContainMap(
			String headWords, String taiWords, String regex) {
		return selectLineStartEndContainMap(headWords,taiWords,regex,null);
	}
	
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * Map��ʽ<�к�,��Ӧ���ַ���>
	 * �����ļ�����headWords��ͷ; ��tailWords��β ;���Ұ���containWords�ľ���; <br/>
	 * ���������� ����ĳһ��ֱ�Ӵ���null����""���� <br/>
	 * �����Ļ����������Ĭ��Ϊtrue <br/>
	 * </ul>
	 * @param headWords ��ͷ��
	 * @param tailWords ��β��
	 * @param regex ������ʽ
	 * @param containWords Ҫ�������ַ�������
	 * @return
	 */
	public Map<Integer, String> selectLineStartEndContainMap(String headWords,
			String tailWords,String regex, String[] containWords) {
		if(headWords == null)
			headWords = "";
		if(tailWords == null)
			tailWords = "";
		if(regex == null || "".equals(regex))
			regex = ".*";
		if(containWords == null)
			containWords = new String[]{""};
		String si = null;
		Map<Integer,String> m = new LinkedHashMap<Integer, String>();
		for(int i = 0 ; i < lineList.size() ; i++ ){
			si = lineList.get(i);
			if(si.startsWith(headWords) && si.endsWith(tailWords) && Util_Collection.containAll(containWords, si) && Pattern.compile(regex).matcher(si).matches()){
				m.put(i, si);
			}
		}
		return m;
	}
	
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ����ĳһ����ʽ������List�е�����λ�á�<br/>
	 * </ul>
	 * @param regex
	 * @return
	 */
	public int getRegexPosition(String regex){
		String si = null;
		for(int i = 0 ; i < lineList.size() ; i++ ){
			si = lineList.get(i);
			if(Pattern.compile(regex).matcher(si).matches()){
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ѡ����ĳ���ַ�����β��������;
	 * </ul>
	 * @param taiWords
	 * @return
	 */
	public List<String> selectLineEndWith(String taiWords) {
		List<String> l = new ArrayList<String>();
		for(String si : lineList){
			if(si.endsWith(taiWords))
				l.add(si);
		}
		return l;
	}

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ������ĳ���ַ�����ʼ�������� ;
	 * </ul>
	 * @param headWords
	 * @return
	 */
	public List<String> selectLineStartWith(String headWords) {
		List<String> l = new ArrayList<String>();
		for(String si : lineList){
			if(si.startsWith(headWords))
				l.add(si);
		}
		return l;
	}
	
	
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ���index�Ƿ����
	 * </ul>
	 */
	private int checkIndex(int n){
		if(n >= lineList.size())
			return lineList.size() - 1 ;
		else if(n < 0)
			return  0;
		else
			return n;
	}

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ��ȡ�ļ���
	 * </ul>
	 * @return
	 */
	public String getFileName() {
		return fileName;
	}
	public String getFilePath() {
		return filePath;
	}

	public List<String> getLineList() {
		return lineList;
	}
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ��ȡ�б�
	 * </ul>
	 * @return
	 */
	public int getIndex() {
		return index;
	}
	
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * �����б� <br/>
	 * ����С��0,���ܳ�������б� <br/>
	 * ������Ϊ0�����<br/>
	 * </ul>
	 * @param index
	 */
	public void setIndex(int index) {
		this.index = checkIndex(index);
	}
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ��ȡlineList����,ƥ��������ʽheadRegex��tailRegex֮���������<br/>
	 * </ul>
	 * @param headRegex
	 * @param tailRegex
	 * @return
	 */
	public List<Map<Integer, String>> selectAllLineBetweenRegex(String headRegex, String tailRegex) {
		return  Util_Collection.selectLineBetweenRegx(lineList, headRegex, tailRegex);
	}

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * �ж�lineList�Ƿ��пɶ�Ԫ��<br/>
	 * </ul>
	 * @return
	 */
	public boolean hasNext() {
		return index < lineList.size();
	}
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ��ѡ��������һ���µ�FileReader����
	 * </ul>
	 * @param headRegex ��ʼ��ƥ��
	 * @param tailRegex �ս���ƥ��
	 * @return
	 */
	public FileReader selectAllLineBetweenRegex2(String headRegex,
			String tailRegex) {
		List<List<String>> l = selectAllLineBetweenRegexList(headRegex,tailRegex);
		if(l !=null && l.size() > 0)
			return new FileReader(l.get(0));
		else
			return null;
	}
	
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ��ѡ��������һ���µ�FileReader����.<br/>
	 * ��������β��
	 * </ul>
	 * @param headRegex ��ʼ��ƥ��
	 * @param tailRegex �ս���ƥ��
	 * @return
	 */
	public FileReader selectAllLineBetweenRegex2_removeHeadTail(String headRegex,
			String tailRegex) {
		List<List<String>> l = selectAllLineBetweenRegexList(headRegex,tailRegex);
		
		if(l !=null && l.size() > 0){
			List<String> backList = l.get(0);
			if(backList.size() >= 2){
				return new FileReader(Util_Collection.listRemoveElem(backList,0,backList.size()-1));
			}
		}
		
		return new FileReader(new ArrayList<String>());
	}

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ѡ����,��List<List<String>>��ʽ����,�Ա� selectAllLineBetweenRegex(String headRegex,String tailRegex)
	 * </ul>
	 * @param headRegex
	 * @param tailRegex
	 * @return
	 */
	public List<List<String>> selectAllLineBetweenRegexList(String headRegex,
			String tailRegex) {
		List<List<String>> l = new ArrayList<List<String>>();
		for(Map<Integer,String> mi : selectAllLineBetweenRegex(headRegex, tailRegex)){
			l.add(Util_Collection.transMaptoList(mi));
		}
		return l;
	}
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ----------��ʱ������-------<br/>
	 * ѡ��headRegex��ʼ��ֱ��tailRegex����һ��<br/>
	 * ��������ͷ��β<br/>
	 * </ul>
	 * @param headRegex
	 * @param tailRegex
	 * @param containHeadAndTail
	 * @return
	 */
	public List<Map<Integer, String>> selectAllLineBetweenRegex(
			String headRegex, String tailRegex, boolean containHeadAndTail) {
		List<Map<Integer, String>> l = selectAllLineBetweenRegex(headRegex, tailRegex);
		return l;
	}

	/**
	 * ����һ��FileReader �ų���ԭFileReader��ƥ����ʽregx�ľ��ӡ�
	 * @param regx
	 * @return FileReader
	 */
	public FileReader selectLineExcludeRegex(String regx) {
		List<String> l =new ArrayList<String>();
		for(String si : lineList){
			if(Util_String.matchAllSameRegx(si, regx))
				continue;
			l.add(si);
		}
		return new FileReader(l);
	}

	/**
	 * ��ʵ���е�lineList��start��end֮��Ĳ����滻ΪlineListRep�е����ݣ�����һ���½�FileReader<br/>
	 * ע����Ӱ�쵱ǰʵ��<br/>
	 * @param start
	 * @param end
	 * @param lineListRep
	 * @return
	 */
	public FileReader replaceList(int start, int end, List<String> lineListRep) {
		return new FileReader(Util_Collection.replaceList(this.lineList, start, end, lineListRep));
	}

	/**
	 * ��ӡ��ǰʵ����lineList���ݡ�<br/>
	 * ��ӡ���ָ�������ʼ����
	 */
	public void printAll() {
		while(this.hasNext()){
			System.out.println(this.readLine());
		}
		this.setIndex(0);
	}
	
}
