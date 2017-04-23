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

import com.celestial.agniRadiance.EzUtil.Util_Normal;
import com.celestial.agniRadiance.EzUtil.Util_String;



/**
 * 
 * <b>�޸ļ�¼��</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2016-8-10
 * </li>
 * </p>
 * 
 * <b>��˵��������һ�����,��Ա������ (��ע��) + get set ����(��ע��)</b>
 * ����ط���Ҫ��������PO��<br/>
 * <p> 
 * 
 * </p>
 */
public class NormalClass {

	/**
	 * �����Ƿ�����Ӧ��������ӵ����
	 * 
	 */
	@SuppressWarnings("serial")
	Map<String,String> packageMap  = new HashMap<String, String>(){{
		put("Date","import java.util.Date;");
		put("Timestamp","import java.sql.Timestamp;");
	}};
	/**
	 * �ض�������Ҫ��ӵĨr(�s���t)�q
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
	 * <b>����˵����</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param args 
	 */
	public static void main(String[] args) {
		NormalClass n = new NormalClass(Arrays.asList(new String[][]{
				{"MESSAGE","String","������Ϣ"},
				{"UserID","String","�û�id"},
				{"TotalRecords","Integer","�ܼ�¼��"},
				{"Price","Double","�ʽ��ܶ�"}
		}),"gnnt.MEBS.MobileServer.po.micro.funds.FuckResponseVO");
		
		//��Ա����
		/*List<String> lp = n.createMemberVariables();
		for(String si : lp){
			System.out.println(si);
		}*/
		
		//ȫ��get����
		/*List<String> lget = n.createGetMethods();
		for(String si : lget){
			System.out.println(si);
		}*/
		
		//ȫ��set����
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
	 * <b>���췽��</b>
	 * ����һ����ɶ��
	 * <br/>
	 * @param lsArr ��������
	 * @param qualifiedName ���ȫ��
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
	 * <b>����˵����</b>
	 * <ul>
	 * �������������
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
		
		l.addAll(Util_Normal.table(createExtra1()));
		
		l.addAll(Util_Normal.table(this.memberVariables));
		l.addAll(Util_Normal.table(this.mixSetAndGetMethods));
		
		l.add("}");
		return l;
	}
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * һЩ����Ҫ�Ķ�����Ϣ
	 * </ul>
	 * @return
	 */
	private Collection<? extends String> createExtra1() {
		List<String> l =new ArrayList<String>();
		l.add("");
		l.add("/** ���к� */");
		l.add("private static final long serialVersionUID = 1L;");
		return l;
	}
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ����ע����Ϣ~
	 * </ul>
	 * @return
	 */
	private List<String> createAnnotationInfo() {
		List<String> l = new ArrayList<String>();
		l.add("/**");
		l.add(" * ");
		l.add(" * <b>�޸ļ�¼��</b> ");
		l.add(" * <p>");
		l.add(" * <li>");
		l.add(" * ");
		l.add(" *                        ---- wangzg " + new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		l.add(" * </li>");
		l.add(" * </p>");
		l.add(" * ");
		l.add(" * <b>��˵����</b>");
		l.add(" * <p> ");
		l.add(" * ");
		l.add(" * </p>");
		l.add(" */");

		return l;
	}
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ����ȫ��set����
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
	 * <b>����˵����</b>
	 * <ul>
	 * ����һ��set����
	 * </ul>
	 * @param sArr
	 * @return
	 */
	private Collection<? extends String> createAsetMethod(String[] sArr) {
		List<String> l = new ArrayList<String>();
		String paramCase = Util_String.__transHeadToLowerCase(sArr[0]);
		l.add("/**");
		l.add(" * <b>����˵����</b>");
		l.add(" * <ul>");
		l.add(" * ����" + sArr[2]);
		l.add(" * </ul>");
		l.add(" * @param " + Util_String.__transHeadToLowerCase(sArr[0]));
		l.add(" */");
		l.add("public void set" + sArr[0] + "(" + sArr[1] + " " + paramCase + ") {");
		l.add("	this." + paramCase + " = " + paramCase + ";");
		l.add("}");
		l.add("");
		return l;
	}
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ����get����
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
	 * <b>����˵����</b>
	 * <ul>
	 * ����һ��get����
	 * </ul>
	 * @param sArr
	 * @return
	 */
	private Collection<? extends String> createAgetMethod(String[] sArr) {
		List<String> l = new ArrayList<String>();
		l.add("/**");
		l.add(" * <b>����˵����</b>");
		l.add(" * <ul>");
		l.add(" * ��ȡ" + sArr[2]  );
		l.add(" * </ul>");
		l.add(" * @return");
		l.add(" */");
		l.add("public " + sArr[1] + " get"+sArr[0]+"() {");
		l.add("	return " + Util_String.__transHeadToLowerCase(sArr[0]) + " ;");
		l.add("}");
		l.add("");
		return l;
	}
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ������Ա����
	 * </ul>
	 * @return
	 */
	private List<String> createMemberVariables() {
		List<String> l = new ArrayList<String>();
		for(String[] sArr : lsArr){
			l.add("/**");
			l.add(" * " + sArr[2] + " ");
			l.add(" */");
			l.add("private "+ sArr[1] +" "+ Util_String.__transHeadToLowerCase(sArr[0]) +" ;");
		}
		l.add("");
		return l;
	}
	

	

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ���ݰ����������Ϣ�����
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
	 * <b>����˵����</b>
	 * <ul>
	 * ����get��set��������ķ���
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
