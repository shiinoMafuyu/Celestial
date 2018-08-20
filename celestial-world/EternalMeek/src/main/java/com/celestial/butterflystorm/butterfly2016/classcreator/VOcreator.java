package com.celestial.butterflystorm.butterfly2016.classcreator;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.celestial.agniRadiance.EzUtil.UtilCollection;
import com.celestial.agniRadiance.EzUtil.UtilFile;
import com.celestial.agniRadiance.EzUtil.UtilString;
import com.celestial.agniRadiance.entity.Tag;
import com.celestial.butterflystorm.butterfly2016.classcreator.silence.Conf;


public abstract class VOcreator {
	
	/**
	 * 已生成的VO类代码
	 */
	protected List<String> voClassStringList = new ArrayList<String>(); 
	
	/**
	 * 类的名字
	 */
	protected String className;
	
	/**
	 * 包的名字,协议里有的话从协议里获取.不然为默认
	 */
	protected String packageName = "gnnt";
	
	/**
	 * 类的注释
	 */
	protected String annotation;
	
	/**
	 * 类下面非继承的直接标签
	 */
	protected List<Tag> directTagList = new ArrayList<Tag>();
	
	/**
	 * 含有子标签的直接标签,用来生成内部类相关内容的
	 * 包括:内部类的get set 方法,和其定义(含内部类成员变量和成员变量的那啥内部类get set方法)
	 */
	protected List<Tag> layerTagList = new ArrayList<Tag>();
	
	/**
	 * 继承父类的直接子标签
	 */
	protected List<Tag> directTagListPa = new ArrayList<Tag>();
	
	/**
	 * 含有的类型集合
	 */
	protected List<String> typeList = new ArrayList<String>();

	/**
	 * 每个类都要引入的包.
	 */
	protected  List<String> mustImport = new ArrayList<String>();
	
	/**
	 * 对应特殊类型的成员变量对应需要导入的包.在子类中初始化~
	 */
	protected Map<String,String[]> importMap = new HashMap<String, String[]>();
	
	/**
	 * RequestVo ResponseVO继承的父类是哪只?子类中初始化~
	 */
	protected String extendClass = "";
	
	/**
	 * 这个类是RequestVo还是ResponseVO ? 子类中初始化~
	 */
	protected String voType = "";
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * RequestVO和ResponseVO公用的初始化方法.<br/>
	 * 初始化className packageName 和 annotation<br/>
	 * </ul>
	 * @param initTag
	 */
	protected void __init_0(Tag initTag) {
		__initVar();//虽然说放这里有点奇怪..不过要放在一个父类中有实体的方法里这是暂时比较合理..等重构完成之后再换位置吧
		this.className = transName(initTag.getPropertyMap().get("name"));
		String pkg = initTag.getPropertyMap().get("pkg");
		if(pkg != null && !"".equals(pkg))
			this.packageName = pkg;
		String ano = initTag.getPropertyMap().get("ie");
		if(ano != null && !"".equals(ano))
			this.annotation = ano;
		
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 把cmd_order_query转为CmdOrderQueryRequestVO这样的<br/>
	 * </ul>
	 * @param str
	 * @return
	 */
	protected String transName(String str) {
		String[] sArr = str.split("_");
		StringBuffer sb = new StringBuffer();
		for(String i: sArr){
			sb.append(UtilString.transHeadToUpperCase(i));
		}
		return sb.append(this.voType).toString();
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 将属于父类的成员变量和普通的成员变量分开.<br/>
	 * </ul>
	 * @param t
	 * @param paVariablemap
	 */
	protected void __init_1_separateVariable(Tag t,
			Map<String, String> paVariablemap) {
		if(paVariablemap.get(t.getTagName()) == null){
			this.directTagList.add(t);
		}else{
			this.directTagListPa.add(t);
		}
		
	}
	
	/**
	 * 
	 * <b>方法说明：</b>
	 * <ul>
	 * 成员变量,描述,类型,注释 缺一抛异常<br/>
	 * 不校验方法名重复和变量名重复<br/>
	 * </ul>
	 * @param directTagList2
	 */
	protected void checkTagList(List<Tag> tagList) {
		for(Tag t : tagList){
			String type = t.getPropertyMap().get("type");
			addType(type);
			boolean b1 = UtilString.notNullEmpty(t.getTagName());
			boolean b2 = UtilString.notNullEmpty(t.getPropertyMap().get("ref"));
			boolean b3 = UtilString.notNullEmpty(type);
			
			boolean b4 = UtilString.notNullEmpty(t.getValue());
			if(!(b1 && b2 && b3 && b4))
				throw new RuntimeException("标签 : <" + t.getTagName() + "> 不完整,请检查其ref,type属性和其值是否完整.");
		}
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 将类型添加到typeList里面.
	 * </ul>
	 * @param type
	 */
	protected void addType(String type) {
		if(!UtilCollection.inList(this.typeList, type)){
			this.typeList.add(type);
		}
	}
	
	protected abstract int createClass();
	protected abstract void init(Tag t);
	
	protected abstract Collection<? extends String> _createProperty_pa_constructor_response();
	
	/**
	 * 
	 * <b>方法说明：</b>
	 * <ul>
	 * 校验数据完整性<br/>
	 * 检查类型有问题没有<br/>
	 * </ul>
	 */
	protected abstract void checkParamArr();
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 导包信息
	 * </ul>
	 * @return
	 */
	protected Collection<? extends String> _createPackageInfo() {
		List<String> l = new ArrayList<String>();
		//--↓--包
		l.add("package "+this.packageName+";");
		l.add("");
		//--↑--
		//--↓--这之间为必须要导的包.如果之后复杂了可以写成配置形式.
		
		for(String si : this.mustImport){
			l.add("import " + si + ";");
		}
		l.add("");
		//--↑--
		for(String i: this.typeList){
			String[] importString = this.importMap.get(i);
			if(importString == null)
				continue;
			for(String si : importString){
				if(!UtilCollection.inList(l,si)){
					l.add(si);
				}
			}
		}
		l.add("");
		l.add("");
		l.add("");
		return l;
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 在子类中实现<br/>
	 * 完成mustImport 和  importMap的子类实现.我也是醉了<br/>
	 * </ul>
	 */
	protected abstract void __initVar();

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 公用的检验标签完整性.
	 * </ul>
	 */
	protected void __checkParamArr_0() {
		//校验直接子标签完整 并且把类型添加到typeList里面
		checkTagList(this.directTagList);
		//检查父类直接子标签
		checkTagList(this.directTagListPa);
		
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 添加类的注释
	 * </ul>
	 * @return
	 */
	protected Collection<? extends String> _createClassAnnotation() {
		List<String> l = new ArrayList<String>();
		l.add("/**");
		l.add(" * ");
		l.add(" * <b>修改记录：</b> ");
		l.add(" * <p>");
		l.add(" * <li>");
		l.add(" * ");
		l.add(" *                        ---- " + Conf.AUTHOR + "  " + new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		l.add(" * </li>");
		l.add(" * </p>");
		l.add(" * ");
		l.add(" * <b>类说明：" + this.annotation + "</b>");
		l.add(" * <p> ");
		l.add(" * ");
		l.add(" * </p>");
		l.add(" */");
		if(this.className != null && this.className.endsWith(Conf.RESPONSEVO)){
			l.add("@SuppressWarnings(\"unused\")");
		}
		return l;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 如果参数类型不含在配置里,抛出异常.需要支持的话自己添加.<br/>
	 * 涉及对类型的操作方式transTypeWaysMap <br/>
	 * 和需要引入的包importMap <br/>
	 * </ul>
	 */
	protected void checkType() {
		for(String i : this.typeList){
			if(Conf.supportMap.get(i) == null)
				throw new RuntimeException("类型 " + i + "不支持!请检查或添加 ");
		}
		
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取生成好了的RequestVO类字符串集合.
	 * </ul>
	 * @return
	 */
	public List<String> getVoClassStringList() {
		return voClassStringList;
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 创建类的操作的第一部分.<br/>
	 * 可共用提取<br/>
	 * </ul>
	 */
	protected void _createClass_p1() {
		//0.校验变量完整性
		checkParamArr();
		//1.添加头部信息 (包名 导包啥的)
		this.voClassStringList.addAll(_createPackageInfo());
		//2.添加类的注释
		this.voClassStringList.addAll(_createClassAnnotation());
		this.voClassStringList.add("public class " + this.className + " extends "+this.extendClass+"{");
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 初始化,并完成类的创建.<br/>
	 * </ul>
	 * @param tag 
	 */
	protected void initAndCreate(Tag tag) {
		init(tag);
		createClass();
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	
	
}
