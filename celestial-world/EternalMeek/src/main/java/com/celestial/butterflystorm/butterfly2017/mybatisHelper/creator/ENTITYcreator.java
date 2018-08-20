package com.celestial.butterflystorm.butterfly2017.mybatisHelper.creator;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.celestial.agniRadiance.EzUtil.UtilNormal;
import com.celestial.agniRadiance.EzUtil.UtilString;
import com.celestial.butterflystorm.butterfly2017.mybatisHelper.depender.ENTITYdepender;



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
 * <p> 
 * 有两种set方法可选：
 * 1。普通的set；(private Collection<? extends String> createAsetMethod)
 * 2.返回对象自身的set方法。(就可以这么用了，new object().setXX("").setXY("").setXZ("");) (private Collection<? extends String> createAsetMethod2)
 * </p>
 */
public class ENTITYcreator {

	private boolean isSpecialsetter = true;
	/**
	 * 根据是否含有相应的类型添加导入包
	 * 
	 */
	@SuppressWarnings("serial")
	Map<String,String> packageMap  = new HashMap<String, String>(){{
		put("Date","import java.util.Date;");
		put("Timestamp","import java.sql.Timestamp;");
		put("Map","import java.util.Map;");
		put("List","import java.util.List;");
	}};
	/**
	 * 特定环境需要添加的�r(�s��t)�q
	 */
	@SuppressWarnings("serial")
	Map<String,String> packageMap2  = new LinkedHashMap<String, String>(){{
		put("JsonInclude","import com.fasterxml.jackson.annotation.JsonInclude;");
	}};
	
	List<String[]> lsArr = new ArrayList<String[]>();
	String qualifiedName ;
	String className ;
	
	
	
	List<String> memberVariables = new ArrayList<String>();
	List<String> equalMethods = new ArrayList<String>();
	List<String> constructors = new ArrayList<String>();
	List<String> toString = new ArrayList<String>();
	
	
	List<String> getMethods = new ArrayList<String>();
	List<String> setMethods = new ArrayList<String>();
	List<String> mixSetAndGetMethods = new ArrayList<String>();
	List<String> packageInfo = new ArrayList<String>();
	List<String> annotationInfo = new ArrayList<String>();
	
	/**最终结果存放*/
	List<String> thisClass = new ArrayList<String>();
	
	/**
	 * <b>构造方法</b>
	 * 构造一个那啥类
	 * <br/>
	 * @param lsArr 变量数组
	 * @param qualifiedName 类的全称
	 */
	public ENTITYcreator(ENTITYdepender entityDepender) {
		super();
		this.lsArr = entityDepender.getClassList();
		this.qualifiedName = entityDepender.getQualifiedName() ;
		className = qualifiedName.substring(qualifiedName.lastIndexOf(".")+1);
		
		memberVariables = createMemberVariables();
		equalMethods = equalMethods();
		constructors = createConstructorsMethod();
		toString = createToStringMethod();
		
//		用的Get Set混合排列 这个没用
//		getMethods = createGetMethods();
//		setMethods = createSetMethods();
		
		mixSetAndGetMethods = createMixSetAndGetMethods();
		packageInfo = createPackageInfo();
		annotationInfo = createAnnotationInfo();
		
		thisClass = createThisClass();
	}
	
	private List<String> createToStringMethod() {
		List<String> l = new ArrayList<String>();
		l.add("@Override");
		l.add("public String toString() {");
		l.add("	return \""+className+" [\"\n");
		String[] sArr = null;
		for(int i=0;i< lsArr.size()-1;i++){
			sArr = lsArr.get(i);
			//"id=" + id + ", "
			l.add("			+\" "+sArr[0]+"=\" + "+sArr[0]+" + \", \"");
		}
		sArr = lsArr.get(lsArr.size()-1);
		l.add("			+\" "+sArr[0]+"=\" + "+sArr[0]+" + \" \"");
		l.add("		+ \"]\";");
		l.add("}");
		l.add("");
		return l;
	}
	private List<String> createConstructorsMethod() {
		List<String> l = new ArrayList<String>();
		l.add("public "+className+"() {");
		l.add("	super();");
		l.add("}");
		l.add("");
		l.add("public "+className+"(Integer id) {");
		l.add("	super();");
		l.add("	this.id = id;");
		l.add("}");
		l.add("");
		return l;
	}
	private List<String> equalMethods() {
		List<String> l = new ArrayList<String>();
		l.addAll(createEqualsMethod());
		l.addAll(createHashMethod());
		return l;
	}
	private Collection<? extends String> createHashMethod() {
		List<String> l = new ArrayList<String>();
		l.add("@Override");
		l.add("public int hashCode() {");
		l.add("	final int prime = 31;");
		l.add("	int result = 1;");
		for(String[] sArr : lsArr){
			l.add("	result = prime * result + (("+sArr[0]+" == null) ? 0 : "+sArr[0]+".hashCode());");
		}
		l.add("	return result;");
		l.add("}");
		l.add("");
		return l;
	}
	private Collection<? extends String> createEqualsMethod() {
		List<String> l = new ArrayList<String>();
		l.add("@Override");
		l.add("public boolean equals(Object obj) {");
		l.add("	if (this == obj)");
		l.add("		return true;");
		l.add("	if (obj == null)");
		l.add("		return false;");
		l.add("	if (getClass() != obj.getClass())");
		l.add("		return false;");
		l.add("	"+className+" other = ("+className+") obj;");
		
		for(String[] sArr : lsArr){
			l.add("	if ("+sArr[0]+" == null) {");
			l.add("		if (other."+sArr[0]+" != null)");
			l.add("			return false;");
			l.add("	} else if (!"+sArr[0]+".equals(other."+sArr[0]+"))");
			l.add("		return false;");
		}
		l.add("return true;");
		l.add("}");
		l.add("");
		return l;
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
		String packageName = qualifiedName.substring(0, qualifiedName.lastIndexOf("."));
		l.add("package " + packageName + ";");
		l.add("");
		l.add("");
		l.addAll(this.packageInfo);
		l.addAll(this.annotationInfo);
		l.add("@JsonInclude(value=JsonInclude.Include.NON_EMPTY)");
		l.add("public class " + className + "{");//----------------------------------------------->>
		
		l.addAll(UtilNormal.table(createExtra1()));
		l.addAll(UtilNormal.table(this.memberVariables));
		
		l.addAll(UtilNormal.table(this.constructors));
		l.addAll(UtilNormal.table(this.equalMethods));
		l.addAll(UtilNormal.table(this.toString));
		
		l.addAll(UtilNormal.table(this.mixSetAndGetMethods));
		
		l.add("}");
		l.add("");
		return l;
	}
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 一些不重要的额外信息
	 * </ul>
	 * @return
	 */
	private Collection<? extends String> createExtra1() {
		List<String> l =new ArrayList<String>();
		l.add("");
//		l.add("/** 序列号 */");
//		l.add("private static final long serialVersionUID = 1L;");
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
	@SuppressWarnings("unused")
	private List<String> createSetMethods() {
		List<String> l = new ArrayList<String>();
		for(String[] sArr : lsArr){
			if(isSpecialsetter)
				l.addAll(createAsetMethod2(sArr));
			else
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
		String methodCase = UtilString.transHeadToUpperCase(sArr[0]);
		l.add("/**");
		l.add(" * <b>方法说明：</b>");
		l.add(" * <ul>");
		l.add(" * 设置" + sArr[2]);
		l.add(" * </ul>");
		l.add(" * @param " + UtilString.transHeadToLowerCase(sArr[0]));
		l.add(" */");
		l.add("public void set" + methodCase + "(" + sArr[1] + " " + paramCase + ") {");
		l.add("	this." + paramCase + " = " + paramCase + ";");
		l.add("}");
		l.add("");
		return l;
	}
	
	private Collection<? extends String> createAsetMethod2(String[] sArr){
		List<String> l = new ArrayList<String>();
		String paramCase = UtilString.transHeadToLowerCase(sArr[0]);
		String methodCase = UtilString.transHeadToUpperCase(sArr[0]);
		l.add("/**");
		l.add(" * <b>方法说明：</b>");
		l.add(" * <ul>");
		l.add(" * 设置" + sArr[2]);
		l.add(" * </ul>");
		l.add(" * @param " + UtilString.transHeadToLowerCase(sArr[0]));
		l.add(" */");
		l.add("public "+className+" set" + methodCase + "(" + sArr[1] + " " + paramCase + ") {");
		l.add("	this." + paramCase + " = " + paramCase + ";");
		l.add("	return this;");
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
	@SuppressWarnings("unused")
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
		l.add("public " + sArr[1] + " get"+UtilString.transHeadToUpperCase(sArr[0])+"() {");
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
		String[] sx=null;
		try {
			List<String> l = new ArrayList<String>();
			for(String[] sArr : lsArr){
				sx = sArr;
				l.add("/**");
				l.add(" * " + sArr[2] + " ");
				l.add(" */");
				l.add("private "+ sArr[1] +" "+ UtilString.transHeadToLowerCase(sArr[0]) +" ;");
			}
			l.add("");
			return l;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("生成成员变量出错，关联数据："+sx[0]);
		}
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
			String aPackageImport = getImportMsgByVariableType(sArr[1]);
			if(aPackageImport != null){
				l.add(aPackageImport);
				this.packageMap.remove(sArr[1]);
			}
		}
		return l;
	}
	/**
	 * 根据一个变量类型获取其导包信息
	 * @param string
	 * @return
	 */
	private String getImportMsgByVariableType(String variableType) {
		String impotKey = UtilString.isCollectionType(variableType);
		if("".equals(impotKey))
			impotKey = variableType;
		return this.packageMap.get(impotKey);
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
			if(isSpecialsetter)
				l.addAll(createAsetMethod2(sArr));
			else
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
