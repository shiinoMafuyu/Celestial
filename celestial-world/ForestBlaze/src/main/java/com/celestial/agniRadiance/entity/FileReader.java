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
	
	/**---------------初始化后值不再改变---------------------*/
	private String filePath = "";
	private String fileName = "";
	private List<String> lineList = new ArrayList<String>();
	/**---------------初始化后值不再改变---------------------*/
	
	/**---------------遍历 变量---------------------------*/
	/**
	 * index指向下一行<br/>
	 * 如果你够聪明的话就能意识到以下含义:<br/>
	 * 1. currentLine 不是index所指向的行数<br/>
	 * 2. index被初始化的话最小能到 0,也就是其下一次读取内容为0.当前currentLine 为null; <br/>
	 * 3.currentLine 为了是结构不复杂  + 便于使用  ,currentLine设置为进行了一次其他read操作后,读取的内容.
	 */
	private int index = 0;
	private String currentLine = null;
	
	/**---------------遍历 变量---------------------------*/
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param args 
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		FileReader f = new FileReader("C:/Users/Administrator/Desktop/kimo`/vendo_response/MyCmdQueryResponseVO.java");
		//过滤字符串
//		List<String> st = f.selectLineStartWith("public");
//		List<String> st2 = f.selectLineEndWith("public");
		List<String> st3 = f.selectLineStartEndContain("","","*","设置");
		for(String s : st3){
			System.out.println(s);
		}
		
		//找到某一行,某几行 ; 遍历LineList
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
	 * 生成一个FileReader类 <br/>
	 * 文件路径请以"/"分隔.<br/>
	 * 默认以trim()方式读取 <br/>
	 * <b>构造方法</b>
	 * <br/>
	 * @param filePath 文件路径
	 */
	public FileReader(String filePath) {
		super();
		init(filePath,null,true);
	}
	
	/**
	 * 生成一个FileReader类<br/>
	 * 文件路径请以"/"分隔.<br/>
	 * <b>构造方法</b>
	 * <br/>
	 * @param filePath 文件路径
	 * @param isTrim 是否需要trim ;默认true;
	 */
	public FileReader(String filePath,boolean isTrim) {
		super();
		init(filePath,null,isTrim);
	}
	
	/**
	 * 生成一个FileReader类<br/>
	 * 文件路径请以"/"分隔.<br/>
	 * <b>构造方法</b>
	 * <br/>
	 * @param filePath 文件路径
	 * @param isTrim 是否需要trim ;默认true;
	 * @param charset 读取时的字符产
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
			throw new RuntimeException("指定文件不存在或不是文件!" + filePath);
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
	 * <b>构造方法</b>
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
	 * <b>方法说明：</b>
	 * <ul>
	 * 读取下一行数据,位置不会跳转<br/>
	 * </ul>
	 * @return
	 */
	public String readNextLine1() {
		return readNextLine1(1);
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 读取后面n行数据,位置不回跳转
	 * </ul>
	 * @param n
	 * @return
	 */
	public String readNextLine1(int n) {
		return readBeforeLine1(-n);
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 读取前一行的值,行号不回跳;
	 * </ul>
	 * @return
	 */
	public String readBeforeLine1() {
		return readBeforeLine1(1);
	}


	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 读取前n行的值,行号不回跳
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
	 * <b>方法说明：</b>
	 * <ul>
	 * 读取后面第n行的数据如果超过最后行读取最后行内容;<br/>
	 * 相对于readNextLine1(),此方法行数会混滚至读取行.<br/>
	 * </ul>
	 * @param n
	 * @return
	 */
	public String readNextLine(int n) {
		return readBeforeLine(-n);
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 读取下一行<br/>
	 * 相对于readNextLine1(),此方法行数会回滚至读取行.<br/>
	 * </ul>
	 * @return
	 */
	public String readNextLine() {
		return readBeforeLine(-1);
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 读取上一行数据 <br/>
	 * 相对于readBeforeLine1(),此方法行数会混滚至读取行.<br/>
	 * </ul>
	 * @return
	 */
	public String readBeforeLine() {
		return readBeforeLine(1);
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 读取前n行数据<br/>
	 * 相对于readBeforeLine1(),此方法行数会混滚至读取行.<br/>
	 * </ul>
	 * @param n 读取之前n行的数据;
	 * @return
	 */
	public String readBeforeLine(int n) {
		index = checkIndex(index - n);
		currentLine = lineList.get(index);
		return currentLine;
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取当前行
	 * </ul>
	 * @return
	 */
	public String readCurrentLine() {
		return currentLine;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 读取下一行内容
	 * </ul>
	 * @return
	 */
	public String readLine() {
		return readLine(index);
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 读取第n行的数据 <br/>
	 * 游标调到该处<br/>
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
	 * <b>方法说明：</b>
	 * <ul>
	 * 返回文件里以headWords开头; 以taiWords结尾 ;并且包含containWords的句子; <br/>
	 * 若果不想用 其中某一个直接传入null或者""即可 <br/>
	 * 这样的话该条件结果默认为true <br/>
	 * </ul>
	 * @param headWords 开头词
	 * @param taiWords 结尾词
	 * @param containWords 不定参
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
	 * <b>方法说明：</b>
	 * <ul>
	 * Map形式<行号,对应行字符串>
	 * 返回文件里以headWords开头; 以taiWords结尾 ;并且包含containWords的句子; <br/>
	 * 若果不想用 其中某一个直接传入null或者""即可 <br/>
	 * 这样的话该条件结果默认为true <br/>
	 * </ul>
	 * @param headWords 开头词
	 * @param taiWords 结尾词
	 * @param containWords 所要包含的字符串数组
	 * @return
	 */
	public Map<Integer, String> selectLineStartEndContainMap(String headWords,
			String taiWords, String[] containWords) {
		return selectLineStartEndContainMap(headWords,taiWords,"",containWords);
		
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * LinkedHashMap形式返回以headWords开头,以taiWords结尾且匹配正则表达式的行 <br/>
	 * 如果不想使用以""表示即可<br/>
	 * <br/>
	 * </ul>
	 * @param headWords 开头词
	 * @param taiWords 结尾词
	 * @param regx 正则表达式
	 * @return
	 */
	public Map<Integer, String> selectLineStartEndContainMap(
			String headWords, String taiWords, String regex) {
		return selectLineStartEndContainMap(headWords,taiWords,regex,null);
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * Map形式<行号,对应行字符串>
	 * 返回文件里以headWords开头; 以tailWords结尾 ;并且包含containWords的句子; <br/>
	 * 若果不想用 其中某一个直接传入null或者""即可 <br/>
	 * 这样的话该条件结果默认为true <br/>
	 * </ul>
	 * @param headWords 开头词
	 * @param tailWords 结尾词
	 * @param regex 正则表达式
	 * @param containWords 要包含的字符串数组
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
	 * <b>方法说明：</b>
	 * <ul>
	 * 返回某一正则式在整个List中的所处位置。<br/>
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
	 * <b>方法说明：</b>
	 * <ul>
	 * 选择以某个字符串结尾的所有行;
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
	 * <b>方法说明：</b>
	 * <ul>
	 * 返回以某个字符串开始的所有行 ;
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
	 * <b>方法说明：</b>
	 * <ul>
	 * 检查index是否过界
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
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取文件名
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
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取行标
	 * </ul>
	 * @return
	 */
	public int getIndex() {
		return index;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 设置行标 <br/>
	 * 不能小于0,不能超过最大行标 <br/>
	 * 否则被置为0或最大<br/>
	 * </ul>
	 * @param index
	 */
	public void setIndex(int index) {
		this.index = checkIndex(index);
	}
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取lineList当中,匹配正则表达式headRegex和tailRegex之间的所有行<br/>
	 * </ul>
	 * @param headRegex
	 * @param tailRegex
	 * @return
	 */
	public List<Map<Integer, String>> selectAllLineBetweenRegex(String headRegex, String tailRegex) {
		return  Util_Collection.selectLineBetweenRegx(lineList, headRegex, tailRegex);
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 判断lineList是否还有可读元素<br/>
	 * </ul>
	 * @return
	 */
	public boolean hasNext() {
		return index < lineList.size();
	}
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 以选中行生成一个新的FileReader对象
	 * </ul>
	 * @param headRegex 起始行匹配
	 * @param tailRegex 终结行匹配
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
	 * <b>方法说明：</b>
	 * <ul>
	 * 以选中行生成一个新的FileReader对象.<br/>
	 * 不包含首尾。
	 * </ul>
	 * @param headRegex 起始行匹配
	 * @param tailRegex 终结行匹配
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
	 * <b>方法说明：</b>
	 * <ul>
	 * 选择行,以List<List<String>>形式返回,对比 selectAllLineBetweenRegex(String headRegex,String tailRegex)
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
	 * <b>方法说明：</b>
	 * <ul>
	 * ----------暂时不补完-------<br/>
	 * 选择headRegex开始后直到tailRegex的那一行<br/>
	 * 不包含开头结尾<br/>
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
	 * 返回一个FileReader 排除了原FileReader中匹配正式regx的句子。
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
	 * 将实例中的lineList中start和end之间的部分替换为lineListRep中的内容，返回一个新建FileReader<br/>
	 * 注：不影响当前实例<br/>
	 * @param start
	 * @param end
	 * @param lineListRep
	 * @return
	 */
	public FileReader replaceList(int start, int end, List<String> lineListRep) {
		return new FileReader(Util_Collection.replaceList(this.lineList, start, end, lineListRep));
	}

	/**
	 * 打印当前实例的lineList内容。<br/>
	 * 打印完后指针调回起始处。
	 */
	public void printAll() {
		while(this.hasNext()){
			System.out.println(this.readLine());
		}
		this.setIndex(0);
	}
	
}
