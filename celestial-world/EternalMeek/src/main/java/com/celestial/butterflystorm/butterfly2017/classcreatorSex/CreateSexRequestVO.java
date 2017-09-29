package com.celestial.butterflystorm.butterfly2017.classcreatorSex;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.celestial.agniRadiance.EzUtil.UtilCollection;
import com.celestial.agniRadiance.EzUtil.UtilNormal;
import com.celestial.agniRadiance.EzUtil.UtilString;
import com.celestial.agniRadiance.entity.Tag;
import com.celestial.butterflystorm.butterfly2017.classcreatorSex.silence.SexGameConf;

public class CreateSexRequestVO extends SexVOcreator{
	

	
	/**agniRadiance
	 * 
	 * <b>构造方法</b>
	 * 通过标签生成类.<br/>
	 * <br/>
	 * @param protocolTag req标签
	 */
	public CreateSexRequestVO(Tag reqTag) {
		super.initAndCreate(reqTag);
	}

	/**
	 * 
	 * <b>方法说明：</b>
	 * <ul>
	 * 创建类
	 * </ul>
	 */
	protected int createClass() {
		super._createClass_p1();
		//3.添加所有变量及其注释
		this.voClassStringList.addAll(UtilNormal.table(_createAllVariables()));
		//3.25 添加主类里的定义和get set方法(所有集合类的)
		for(Tag t : this.layerTagList){
			this.voClassStringList.addAll(UtilNormal.table(__createOneInnerClassDefine(t)));
		}
		//3.5添加请求属性 4.添加构造方法及其注释
		this.voClassStringList.addAll(UtilNormal.table(_createProperty_pa_constructor_response()));
		//5.添加所有get方法及其注释
		this.voClassStringList.addAll(UtilNormal.table(_createAllGet(this.directTagList)));
		//6.添加内部类
		this.voClassStringList.addAll(UtilNormal.table(_createInnerClass()));
		//附带 添加toString方法
		this.voClassStringList.add("}");
		this.voClassStringList.add("");
		return 0;
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 创建内部类
	 * </ul>
	 * @return
	 */
	private Collection<? extends String> _createInnerClass() {
		List<String> l = new ArrayList<String>();
		//1.添加主类里的定义和get set方法(放到上面去 添加所有变量末尾~)
		
		//2.添加内部类<PROS>这一级. 每个这一级的标签对应一个集合类.<PROS>对应的是PropertyList,目前只有这个有需要自己去Conf.requestInnerClassNameMap里配.
			/*<PROS>
				<PRO>商品属性
					<BP>属性名称</BP>
					<CP>商品属性值</CP>
				</PRO>
			</PROS>*/
		for(Tag t : this.layerTagList){
			l.addAll(__createInnerGatherClass(t));
		}
		return l;
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 创建主类里对个集合类成员变量对象的声明.
	 * </ul>
	 * @param t
	 * @return
	 */
	protected Collection<? extends String> __createOneInnerClassDefine(Tag t) {
		//Conf.requestInnerClassNameMap.get(t.getTagName())
		String tagName = t.getTagName();
		String className = SexGameConf.requestInnerClassNameMap.get(tagName);
		List<String> l = new ArrayList<String>();
		l.add("/**");
		l.add(" * <b>方法说明：</b>");
		l.add(" * <ul>");
		l.add(" * 获取"+t.getValue()+"列表");
		l.add(" * </ul>");
		l.add(" * @return");
		l.add(" */");
		l.add("public "+className+" get"+className+"() {");
		l.add("	return "+tagName+";");
		l.add("}");
		return l;
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 创建一个内部类()
	 * </ul>
	 * @param t
	 * @return
	 */
	private Collection<? extends String> __createInnerGatherClass(Tag t) {
		List<String> l = new ArrayList<String>();
		l.add("/**");
		l.add(" * 集合类");
		l.add(" */");
		l.add("public class " + SexGameConf.requestInnerClassNameMap.get(t.getTagName()) + " {");
		//1.创建集合类内部的信息类变量定义 初始化 get set方法 private List<PropertyObj> PRO = new ArrayList<PropertyObj>(); 
		for(Tag ti : t.getChildTagList()){
			l.addAll(UtilNormal.table(___createInnerProperty(ti)));
		}
		//2.创建集合类内部的信息类<PRO>这一级
			/*<PRO>商品属性
				<BP>属性名称</BP>
				<CP>商品属性值</CP>
			</PRO>*/
		for(Tag ti : t.getChildTagList()){
			l.addAll(UtilNormal.table(___createInnerPropertyClass(ti)));
		}
		l.add("}");
		l.add("");
		return l;
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 创建集合类的子类属性类.
	 * </ul>
	 * @param ti
	 * @return
	 */
	private Collection<? extends String> ___createInnerPropertyClass(Tag t) {
		List<String> l = new ArrayList<String>();
		String annotation = t.getValue();
		if(annotation ==null)
			annotation = "";
		String propertyName = t.getTagName();
		String className = SexGameConf.requestInnerClassNameMap.get(propertyName);
		
		l.add("/**");
		l.add(" * 属性类");
		l.add(" */");
		l.add("public class "+className+" {");
		l.addAll(UtilNormal.table(__createNormalVariable( t.getChildTagList())));
		l.add("	/**");
		l.add("	* <b>构造方法</b>");
		l.add("	* <br/>");
		l.add("	*/");
		l.add("	public "+className+"() {");
		l.add("		super();");
		l.add("	}");
		l.add("	");
		l.addAll(UtilNormal.table(_createAllGet(t.getChildTagList())));
		l.add("}");
		l.add("");
		return l;
	}


	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 创建集合类的内部属性.包括成员变量定义 注释 get set方法之类.
	 * </ul>
	 * @param t
	 * @return
	 */
	private Collection<? extends String> ___createInnerProperty(Tag t) {
		List<String> l = new ArrayList<String>();
		String annotation = t.getValue();
		if(annotation ==null)
			annotation = "";
		String propertyName = t.getTagName();
		String className = SexGameConf.requestInnerClassNameMap.get(propertyName);
		if(null == className)
			throw new RuntimeException("Conf.requestInnerClassNameMap中未找到 " + propertyName +"对应类名.");
		l.add("/**");
		l.add(" * " + annotation);
		l.add(" */");
		l.add("private List<" + className + "> " + propertyName + " = new ArrayList<" + className + ">();");
		l.add("");
		l.add("/**");
		l.add("* <b>方法说明：</b>");
		l.add("* <ul>");
		l.add("* 设置" + annotation);
		l.add("* </ul>");
		l.add("* @param list");
		l.add("*/");
		l.add("public void setList(ArrayList<"+className+"> list) {");
		l.add("	"+propertyName+" = list;");
		l.add("}");
		l.add("");
		l.add("/**");
		l.add("* <b>方法说明：</b>");
		l.add("* <ul>");
		l.add("* 获取" + annotation);
		l.add("* </ul>");
		l.add("* @return");
		l.add("*/");
		l.add("public List<"+className+"> getList() {");
		l.add("	return "+propertyName+";");
		l.add("}");
		l.add("");
		return l;
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 创建普通成员变量的get方法及其注释.
	 * </ul>
	 * @param tagList 
	 * @return
	 */
	private Collection<? extends String> _createAllGet(List<Tag> tagList) {
		List<String> l = new ArrayList<String>();
		for(Tag t : tagList){
			l.addAll(__creaeteGetMethod(t));
		}
		return l;
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 创建get方法及其注释.
	 * </ul>
	 * @param t
	 * @return
	 */
	private Collection<? extends String> __creaeteGetMethod(Tag t) {
		List<String> l = new ArrayList<String>();
		l.add("/**");
		l.add(" * <b>方法说明：</b>");
		l.add(" * <ul>");
		l.add(" * 获取" + t.getValue() + "");
		l.add(" * </ul>");
		l.add(" * @return");
		l.add(" */");
		String type = t.getPropertyMap().get("type");
		l.add("public "+ type + " get"+UtilString.transHeadToUpperCase(t.getPropertyMap().get("ref")) + "(){");
		l.add("	return " + SexGameConf.supportMap.get(type).replace("X", t.getTagName()));
		l.add("}");
		l.add("");
		String ss = String.format("new String[]{\"%s\",\"%s\",\"%s\",\"%s\"},", t.getTagName(),type,t.getValue(),t.getPropertyMap().get("ref"));
		System.out.println(ss);
		return l;
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 创建中间部分
	 * </ul>
	 * @return
	 */
	protected Collection<? extends String> _createProperty_pa_constructor_response() {
		List<String> l = new ArrayList<String>();
		l.addAll(__create_propertyVariable());
		l.addAll(__createConstructor());
		l.addAll(__createExtendMethod());
		return l;
	}


	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 创建构造方法.<br/>
	 * 没有userID sessionID时不要带参构造函数<br/>
	 * </ul>
	 * @return
	 */
	private Collection<? extends String> __createConstructor() {
		List<String> l = new ArrayList<String>();
		String head = className.substring(0, className.indexOf("RequestVO"));
		//TemplateQueryRequestVO
		l.add("/**");
		l.add(" * <b>构造方法</b>");
		l.add(" * <br/>");
		l.add(" */");
		l.add("public "+head+"RequestVO() {");
		l.add("	super();");
		l.add("}");
		l.add("");
		if(this.directTagListPa.size() > 0){
			l.add("/**");
			l.add(" * <b>构造方法</b>");
			l.add(" * <br/>");
			l.add(" * @param userID");
			l.add(" * @param sessionID");
			l.add(" */");
			l.add("public "+head+"RequestVO(String userID, String sessionID) {");
			l.add("	super();");
			l.add("	U = userID;");
			l.add("	SI = sessionID;");
			l.add("}");
			l.add("");
		}
		return l;
	}
	
	private Collection<? extends String> __createExtendMethod() {
		String head = className.substring(0, className.indexOf("RequestVO"));
		List<String> l = new ArrayList<String>();
		l.add("@Override");
		l.add("public ECheckLogonType getCheckLogonType() {");
		l.add("	return ECheckLogonType.SOMETIMES;");
		l.add("}");
		l.add("");
		l.add("@Override");
		l.add("public IRequestHandler getRequestHandler() {");
		l.add("	return new "+head+"RequestHandler();");
		l.add("}");
		l.add("");
		return l;
	}


	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 创建内部类变量定义
	 * </ul>
	 * @return
	 */
	private Collection<? extends String> __create_propertyVariable() {
		List<String> l = new ArrayList<String>();
		for(Tag t : this.layerTagList){
			String tagName = t.getTagName() ;
			String innerClassName = SexGameConf.requestInnerClassNameMap.get(tagName);
			l.add("/**");
			l.add(" * " + t.getValue());
			l.add(" */ ");
			l.add("private " + innerClassName + " " + tagName + " = new " + innerClassName + "();");
			l.add("");
		}
		return l;
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 生成主类里所有变量及其注释.
	 * </ul>
	 * @return
	 */
	private Collection<? extends String> _createAllVariables() {
		List<String> l = new ArrayList<String>();
		l.addAll(__createParentVariable());
		l.addAll(__createNormalVariable(this.directTagList));
		return l;
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 创建常规变量和其注释
	 * </ul>
	 * @param tagList 
	 * @return
	 */
	private Collection<? extends String> __createNormalVariable(List<Tag> tagList) {
		List<String> l = new ArrayList<String>();
		for(Tag ti : tagList){
			l.addAll(__createVariable(ti));
		}
		l.add("");
		return l;
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 父类中的变量
	 * </ul>
	 * @return
	 */
	private Collection<? extends String> __createParentVariable() {
		List<String> l = new ArrayList<String>();
		if(this.directTagListPa.size() != 0){
			for(Tag ti : this.directTagListPa){
				l.addAll(__createVariable(ti));
			}
		}
		return l;
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 根据基层标签创建变量<br/>
	 * </ul>
	 * @param tag
	 * @return
	 */
	private Collection<? extends String> __createVariable(Tag tag) {
		List<String> l = new ArrayList<String>();
		l.add("/**");
		l.add(" * " + tag.getValue());
		l.add(" */");
		l.add("private String " + tag.getTagName() + " ;");
		return l;
	}


	
	
	protected void checkParamArr() {
		super.__checkParamArr_0();
		//校验内部类标签完整 并且把类型添加到typeList里面
		if(this.layerTagList.size() > 0){
			this.typeList.add("ToStringStyle");
			this.typeList.add("List");
			for(Tag t : this.layerTagList){
				checkLayerTag(t);
			}
		}
		//检查参数类型有问题没.
		checkType();
	}



	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 检查内部类标签里的东东<br/>
	 * </ul>
	 * @param t
	 */
	private void checkLayerTag(Tag t) {
		//现在只见到有三层的了,就按3层来写,有需要再改.
		for(Tag t1 : t.getChildTagList()){
			checkTagList(t1.getChildTagList());
		}
		
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 初始化成员变量  <br/>
	 * </ul>
	 * @param reqTag
	 */
	protected void init(Tag reqTag) {
		super.__init_0(reqTag);
		for(Tag t : reqTag.getChildTagList()){
			if(t.getMapColor() != null && t.getMapColor().size() >0){
				this.layerTagList.add(t);
			}else{
				//如果是Conf的requestPaVariableMap里定义的则去掉.
				super.__init_1_separateVariable(t,SexGameConf.requestPaVariableMap);
			}
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void __initVar() {
		this.mustImport = UtilCollection.deepCopyList(SexGameConf.mustImport_request);
		this.importMap = UtilCollection.deepCopyMap(SexGameConf.importMap);
		
		this.extendClass = "ARequestVO";
		this.voType = SexGameConf.REQUESTVO;
	}
	
	
}
