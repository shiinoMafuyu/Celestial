package com.celestial.agniRadiance.entity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.celestial.agniRadiance.EzUtil.UtilNormal;
import com.celestial.agniRadiance.EzUtil.UtilString;



/**
 * 
 * <b>修改记录：</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2016-8-10
 * </li>
 * </p>
 * 
 * <b>类说明：创建一般的类,成员变量名 (带注释) + get set 方法(带注释)</b>
 * 这个地方主要用作创建PO类<br/>
 * <p> 
 * 
 * </p>
 */
public class NormalClass {

	/**
	 * 根据是否含有相应的类型添加导入包
	 * 
	 */
	@SuppressWarnings("serial")
	Map<String,String> packageMap  = new HashMap<String, String>(){{
		put("Date","import java.util.Date;");
		put("Timestamp","import java.sql.Timestamp;");
	}};
	/**
	 * 特定环境需要添加的�r(�s��t)�q
	 */
	@SuppressWarnings("serial")
	Map<String,String> packageMap2  = new HashMap<String, String>(){{
		/*put("Clone","import gnnt.MEBS.MobileServer.po.Clone;");*/
	}};
	
	List<String[]> lsArr = new ArrayList<String[]>();
	String qualifiedName ;
	
	
	
	List<String> memberVariables = new ArrayList<String>();
	List<String> getMethods = new ArrayList<String>();
	List<String> setMethods = new ArrayList<String>();
	List<String> mixSetAndGetMethods = new ArrayList<String>();
	List<String> packageInfo = new ArrayList<String>();
	List<String> annotationInfo = new ArrayList<String>();
	
	List<String> thisClass = new ArrayList<String>();
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param args 
	 */
	public static void main(String[] args) {
		NormalClass n = new NormalClass(Arrays.asList(new String[][]{
				{"MESSAGE","String","返回信息"},
				{"UserID","String","用户id"},
				{"TotalRecords","Integer","总记录数"},
				{"Price","Double","资金总额"}
		}),"gnnt.MEBS.MobileServer.po.micro.funds.FuckResponseVO");
		
		//成员变量
		/*List<String> lp = n.createMemberVariables();
		for(String si : lp){
			System.out.println(si);
		}*/
		
		//全部get方法
		/*List<String> lget = n.createGetMethods();
		for(String si : lget){
			System.out.println(si);
		}*/
		
		//全部set方法
		/*List<String> lset = n.createSetMethods();
		for(String si : lset){
			System.out.println(si);
		}*/
		/*for(String si : n.getMixSetAndGetMethod()){
			System.out.println(si);
		}*/
		/*for(String si : n.getAnnotationInfo()){
			System.out.println(si);
		}*/
		
		for(String si : n.getThisClass()){
			System.out.println(si);
		}
	}
	/**
	 * <b>构造方法</b>
	 * 构造一个那啥类
	 * <br/>
	 * @param lsArr 变量数组
	 * @param qualifiedName 类的全称
	 */
	public NormalClass(List<String[]> lsArr ,String qualifiedName) {
		super();
		this.lsArr = lsArr;
		this.qualifiedName = qualifiedName ;
		
		memberVariables = createMemberVariables();
		getMethods = createGetMethods();
		setMethods = createSetMethods();
		mixSetAndGetMethods = createMixSetAndGetMethods();
		packageInfo = createPackageInfo();
		annotationInfo = createAnnotationInfo();
		
		thisClass = createThisClass();
	}
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 整个类的所有行
	 * </ul>
	 * @return
	 */
	private List<String> createThisClass() {
		List<String> l = new ArrayList<String>();
		String className = qualifiedName.substring(qualifiedName.lastIndexOf(".")+1);
		className = className.substring(0, className.indexOf("ResponseVO")) +"PO";
		String packageName = qualifiedName.substring(0, qualifiedName.lastIndexOf("."));
		l.add("package " + packageName + ";");
		l.add("");
		l.add("");
		l.addAll(this.packageInfo);
		l.addAll(this.annotationInfo);
		l.add("public class " + className + "{");//----------------------------------------------->>
		
		l.addAll(UtilNormal.table(createExtra1()));
		
		l.addAll(UtilNormal.table(this.memberVariables));
		l.addAll(UtilNormal.table(this.mixSetAndGetMethods));
		
		l.add("}");
		return l;
	}
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 一些不重要的额外信息
	 * </ul>
	 * @return
	 */
	private List<String> createExtra1() {
		List<String> l =new ArrayList<String>();
		l.add("");
		l.add("/** 序列号 */");
		l.add("private static final long serialVersionUID = 1L;");
		return l;
	}
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 创建注解信息~
	 * </ul>
	 * @return
	 */
	private List<String> createAnnotationInfo() {
		List<String> l = new ArrayList<String>();
		l.add("/**");
		l.add(" * ");
		l.add(" * <b>修改记录：</b> ");
		l.add(" * <p>");
		l.add(" * <li>");
		l.add(" * ");
		l.add(" *                        ---- wangzg " + new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		l.add(" * </li>");
		l.add(" * </p>");
		l.add(" * ");
		l.add(" * <b>类说明：</b>");
		l.add(" * <p> ");
		l.add(" * ");
		l.add(" * </p>");
		l.add(" */");

		return l;
	}
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 创建全部set方法
	 * </ul>
	 * @return
	 */
	private List<String> createSetMethods() {
		List<String> l = new ArrayList<String>();
		for(String[] sArr : lsArr){
			l.addAll(createAsetMethod(sArr));
		}
		return l;
	}
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 创建一个set方法
	 * </ul>
	 * @param sArr
	 * @return
	 */
	private Collection<? extends String> createAsetMethod(String[] sArr) {
		List<String> l = new ArrayList<String>();
		String paramCase = UtilString.transHeadToLowerCase(sArr[0]);
		l.add("/**");
		l.add(" * <b>方法说明：</b>");
		l.add(" * <ul>");
		l.add(" * 设置" + sArr[2]);
		l.add(" * </ul>");
		l.add(" * @param " + UtilString.transHeadToLowerCase(sArr[0]));
		l.add(" */");
		l.add("public void set" + sArr[0] + "(" + sArr[1] + " " + paramCase + ") {");
		l.add("	this." + paramCase + " = " + paramCase + ";");
		l.add("}");
		l.add("");
		return l;
	}
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 创建get方法
	 * </ul>
	 * @return
	 */
	private List<String> createGetMethods() {
		List<String> l = new ArrayList<String>();
		for(String[] sArr : lsArr){
			l.addAll(createAgetMethod(sArr));
		}
		return l;
	}
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 创建一个get方法
	 * </ul>
	 * @param sArr
	 * @return
	 */
	private Collection<? extends String> createAgetMethod(String[] sArr) {
		List<String> l = new ArrayList<String>();
		l.add("/**");
		l.add(" * <b>方法说明：</b>");
		l.add(" * <ul>");
		l.add(" * 获取" + sArr[2]  );
		l.add(" * </ul>");
		l.add(" * @return");
		l.add(" */");
		l.add("public " + sArr[1] + " get"+sArr[0]+"() {");
		l.add("	return " + UtilString.transHeadToLowerCase(sArr[0]) + " ;");
		l.add("}");
		l.add("");
		return l;
	}
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 创建成员变量
	 * </ul>
	 * @return
	 */
	private List<String> createMemberVariables() {
		List<String> l = new ArrayList<String>();
		for(String[] sArr : lsArr){
			l.add("/**");
			l.add(" * " + sArr[2] + " ");
			l.add(" */");
			l.add("private "+ sArr[1] +" "+ UtilString.transHeadToLowerCase(sArr[0]) +" ;");
		}
		l.add("");
		return l;
	}
	

	

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 根据包含的类的信息导入包
	 * </ul>
	 * @return
	 */
	private List<String> createPackageInfo() {
		List<String> l = new ArrayList<String>();
		for(Entry<String, String> ei :this.packageMap2.entrySet()){
			l.add(ei.getValue());
		}
		for(String[] sArr : lsArr){
			String aPackageImport = this.packageMap.get(sArr[1]);
			if(aPackageImport != null){
				l.add(aPackageImport);
				this.packageMap.remove(sArr[1]);
			}
		}
		return l;
	}
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 创建get和set方法交叉的方法
	 * </ul>
	 * @return
	 */
	private List<String> createMixSetAndGetMethods() {
		List<String> l = new ArrayList<String>();
		for(String[] sArr : lsArr){
			l.addAll(createAgetMethod(sArr));
			l.addAll(createAsetMethod(sArr));
		}
		return l;
	}


	public List<String[]> getLsArr() {
		return lsArr;
	}
	public List<String> getMemberVariables() {
		return memberVariables;
	}
	public List<String> getGetMethods() {
		return getMethods;
	}
	public List<String> getSetMethods() {
		return setMethods;
	}
	public List<String> getMixSetAndGetMethod() {
		return mixSetAndGetMethods;
	}
	public Map<String, String> getPackageMap() {
		return packageMap;
	}
	public Map<String, String> getPackageMap2() {
		return packageMap2;
	}
	public List<String> getMixSetAndGetMethods() {
		return mixSetAndGetMethods;
	}
	public List<String> getPackageInfo() {
		return packageInfo;
	}
	public List<String> getAnnotationInfo() {
		return annotationInfo;
	}
	public String getQualifiedName() {
		return qualifiedName;
	}
	public List<String> getThisClass() {
		return thisClass;
	}
	
	
	
	
	
}
