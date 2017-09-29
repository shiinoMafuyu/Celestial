package com.celestial.butterflystorm.butterfly2016.classcreator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.celestial.agniRadiance.EzUtil.UtilCollection;
import com.celestial.agniRadiance.EzUtil.UtilNormal;
import com.celestial.agniRadiance.EzUtil.UtilString;
import com.celestial.agniRadiance.entity.Tag;
import com.celestial.butterflystorm.butterfly2016.classcreator.silence.Conf;

public class CreateResponseVO extends VOcreator{
	/**
	 * 层级为1的<RESULTLIST>标签
	 */
	private List<Tag> layerTagList1 = new ArrayList<Tag>();
	
	/**
	 * 层级为2的<RESULTLIST>标签
	 */
	private List<Tag> layerTagList2 = new ArrayList<Tag>();
	

	
	/**
	 * RESULTLIST成员变量的类型.(主要集合类的名字)
	 */
	private String resultClassName = "";
	
	/**
	 * 主要信息类的名字.
	 */
	private String objClassName = "";
	
	/**
	 * 此类是否含有ResultList
	 */
	private boolean hasResultList = false;
	
	/**
	 * 结果信息类类名
	 */
	private String resultVOName = "";
	
	
	/**
	 * ReponseVO中,ResultList里面的子标签缩写对应的类名.<br/>
	 * XXX作为被替换的标记.<br/>
	 */
	@SuppressWarnings("serial")
	private Map<String,String> responseInnerClassNameMap = new HashMap<String, String>(){{
		put("PRS","PropertyList");
		put("ORP","OrderPictureList");
		put("PCS","PictureObj");
		put("PRO","PropertyObj");
		put("REC","XXX");
	}};
	
	/**
	 * 根据返回标签生成返回类.
	 * <b>构造方法</b>
	 * <br/>
	 * @param resTag
	 */
	public CreateResponseVO(Tag resTag) {
		super.initAndCreate(resTag);
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
		//3.5添加请求属性 4.添加构造方法及其注释
		this.voClassStringList.addAll(UtilNormal.table(_createProperty_pa_constructor_response()));
		
		//4.创建主要集合类.
		this.voClassStringList.addAll(UtilNormal.table(_createMainList()));
		//5.创建主要ResultVO实现类.
		this.voClassStringList.addAll(UtilNormal.table(_createResultVO_impl()));
		//6.创建剩下的集合类和信息类.简单的工作了O(∩_∩)O哈哈~
		this.voClassStringList.addAll(UtilNormal.table(_createInnerCollection_Info()));
		this.voClassStringList.add("}");
		this.voClassStringList.add("");
		return 0;
	}
	

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 
	 * </ul>
	 * @return
	 */
	private Collection<? extends String> _createResultVO_impl() {
		List<String> l = new ArrayList<String>();
		l.add("/**");
		l.add(" * 返回结果信息类");
		l.add(" */");
		l.add("public class "+this.resultVOName+" extends ResultVO{");
		this.directTagList.get(0);
		l.addAll(UtilNormal.table(__create_normalVarAndSetter(this.directTagList)));
		l.add("}");
		l.add("");
		return l;
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 创建一般变量的定义和Setter方法<br/>
	 * </ul>
	 * @param tagList
	 * @return
	 */
	private Collection<? extends String> __create_normalVarAndSetter(
			List<Tag> tagList) {
		List<String> l = new ArrayList<String>();
		l.addAll(__create_normalVar(tagList));
		l.addAll(__create_normalSetter(tagList));
		return l;
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 生成一般变量的Setter方法.<br/>
	 * </ul>
	 * @param tagList
	 * @return
	 */
	private Collection<? extends String> __create_normalSetter(
			List<Tag> tagList) {
		List<String> l = new ArrayList<String>();
		for(Tag t : tagList){
			String ref = t.getPropertyMap().get("ref");
			String var = UtilString.transHeadToLowerCase(ref);
			String type = t.getPropertyMap().get("type");
			String op = Conf.supportMapResponse.get(type).replace("X", var);
			l.add("/**");
			l.add(" * <b>方法说明：</b>");
			l.add(" * <ul>");
			l.add(" * 设置"+t.getValue());
			l.add(" * </ul>");
			l.add(" * @param");
			l.add(" */");
			l.add("public void set"+ref+"("+type+" "+var+") {");
			l.add("	"+t.getTagName()+" = "+op);
			l.add("}");
			l.add("");
		}
		return l;
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 生成一般变量.<br/>
	 * </ul>
	 * @param tagList
	 * @return
	 */
	private Collection<? extends String> __create_normalVar(List<Tag> tagList) {
		List<String> l = new ArrayList<String>();
		for(Tag t : tagList){
			l.add("/**");
			l.add(" * "+t.getValue());
			l.add(" */");
			l.add("private String "+t.getTagName()+" ;");
		}
		l.add("");
		return l;
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 创建layerTagList1 layerTagList2 里面对应的集合类和信息类.<br/>
	 * 就大功告成了.<br/>
	 * </ul>
	 * @return
	 */
	private Collection<? extends String> _createInnerCollection_Info() {
		List<String> l = new ArrayList<String>();
		//创建集合类
		for(Tag t : this.layerTagList2){
			l.addAll(__create_collectionClass(t));
		}
		//下面创建信息类
		for(Tag t : this.layerTagList1){
			l.addAll(__create_infoClass(t));
		}
		for(Tag t : this.layerTagList2){
			for(Tag ti : t.getChildTagList()){
				l.addAll(__create_infoClass(ti));
			}
		}
		return l;
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 生成信息类.<br/>
	 * </ul>
	 * @param tag
	 * @return
	 */
	private Collection<? extends String> __create_infoClass(Tag tag) {
		List<String> l = new ArrayList<String>();
		l.add("/**");
		l.add(" * "+tag.getValue());
		l.add(" */");
		l.add("public class "+this.responseInnerClassNameMap.get(tag.getTagName())+"{");
		l.addAll(UtilNormal.table(__create_normalVarAndSetter(tag.getChildTagList())));
		l.add("}");
		l.add("");
		return l;
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 有两层标签的创建集合类.<br/>
	 * </ul>
	 * @param t
	 * @return
	 */
	private Collection<? extends String> __create_collectionClass(Tag t) {
		List<String> l = new ArrayList<String>();
		String tagName = t.getTagName();
		String ano = t.getValue();
		String collectionClassName = this.responseInnerClassNameMap.get(tagName);
		l.add("/**");
		l.add(" * "+ano);
		l.add(" */");
		l.add("public class "+collectionClassName+"{");
		l.add("	/** 信息集合 */");
		l.add("	private List<"+collectionClassName+"> "+tagName+";");
		l.add("");
		l.add("	/**");
		l.add("	 * ");
		l.add("	 * 获取信息集合");
		l.add("	 * <br/><br/>");
		l.add("	 * @return");
		l.add("	 */");
		l.add("	public List<"+collectionClassName+"> getList(){");
		l.add("		return "+tagName+";");
		l.add("	}");
		l.add("");
		l.add("	/**");
		l.add("	 * ");
		l.add("	 * 设置信息集合");
		l.add("	 * <br/><br/>");
		l.add("	 * @param list");
		l.add("	 */");
		l.add("	public void setList(List<"+collectionClassName+"> list){");
		l.add("		"+tagName+" = list;");
		l.add("	}");
		l.add("}");
		l.add("");
		return l;
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 创建主要的结果集合类.
	 * </ul>
	 * @return
	 */
	private List<String> _createMainList() {
		List<String> l = new ArrayList<String>();
		if(!this.hasResultList)
			return l;
		l.add("/**");
		l.add(" * 核心集合类");
		l.add(" */");
		l.add("public class "+this.resultClassName+"{");
		
		l.addAll(UtilNormal.table(__create_1_p1()));//PRS ORP之类 private PropertyList PRS; 这一层
		
		for(Tag t : this.layerTagList1){
			l.addAll(UtilNormal.table(__create_2_p1(t)));//private List<SubOrderQueryObj> REC; 这一层
		}
		l.add("");
		l.addAll(UtilNormal.table(__create_1_p2()));
		for(Tag t : this.layerTagList1){
			l.addAll(UtilNormal.table(__create_2_p2(t)));
		}
		l.add("}");
		l.add("");
		return l;
	}


	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 创建一层p2部分:天个体成员变量的get set方法.
	 * </ul>
	 * @param t
	 * @return
	 */
	private Collection<? extends String> __create_2_p2(Tag t) {
		List<String> l = new ArrayList<String>();
		String innerClassName = this.responseInnerClassNameMap.get(t.getTagName());
		l.add("/**");
		l.add(" * 获取信息集合");
		l.add(" * <br/><br/>");
		l.add(" * @return");
		l.add(" */");
		l.add("public List<"+innerClassName+"> getList(){");
		l.add("	return "+t.getTagName()+";");
		l.add("}");
		l.add("");
		l.add("/**");
		l.add(" * 设置信息集合");
		l.add(" * <br/><br/>");
		l.add(" * @param list");
		l.add(" */");
		l.add("public void setList(List<"+innerClassName+"> list){");
		l.add("	"+t.getTagName()+" = list;");
		l.add("}");
		l.add("");

		return l;
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 创建第二层级的p2部分:添加成员变量的get set方法.<br/>
	 * </ul>
	 * @return
	 */
	private List<String> __create_1_p2() {
		List<String> l = new ArrayList<String>();
		for(Tag t : this.layerTagList2){
			String innerClassName = this.responseInnerClassNameMap.get(t.getTagName());
			l.add("/**");
			l.add(" * 获取"+t.getValue());
			l.add(" * <br/><br/>");
			l.add(" * @return");
			l.add(" */");
			l.add("public "+innerClassName+" get"+innerClassName+"(){");
			l.add("	return "+t.getTagName()+";");
			l.add("}");
			l.add("");
			l.add("/**");
			l.add(" * 设置"+t.getValue());
			l.add(" * <br/><br/>");
			l.add(" * @param resultList");
			l.add(" */");
			l.add("public void set"+innerClassName+"("+innerClassName+" resultList){");
			l.add("	"+t.getTagName()+" = resultList;");
			l.add("}");
			l.add("");
		}
		return l;
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 创建第二层级p1部分:添加成员变量<br/>
	 * </ul>
	 * @param t
	 * @return
	 */
	private List<String> __create_2_p1(Tag t) {
		List<String> l = new ArrayList<String>();
		l.add("/** 信息类集合 */");
		l.add("private List<"+this.responseInnerClassNameMap.get(t.getTagName())+"> "+t.getTagName()+";");
		return l;
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 两层的注册第一层级 p1部分:添加成员变量.(一层的没有这个)<br/>
	 * </ul>
	 * @return
	 */
	private List<String> __create_1_p1() {
		List<String> l = new ArrayList<String>();
		if(this.layerTagList2.size() == 0)
			return l;
		for(Tag t : this.layerTagList2){
			l.add("/** "+t.getValue()+" */");
			l.add("private "+this.responseInnerClassNameMap.get(t.getTagName())+" "+t.getTagName()+";");
		}
		l.add("");
		return l;
	}

	protected void checkParamArr() {
		super.__checkParamArr_0();
		//1.检验RESULTLIST子标签中内容完整性.
		//1)1层的
		for(Tag t : this.layerTagList1){
			super.checkTagList(t.getChildTagList());
		}
		//2)2层的
		for(Tag t : this.layerTagList2){
			for(Tag i : t.getChildTagList()){
				super.checkTagList(i.getChildTagList());
			}
		}
		
		//检查参数类型有问题没.
		checkType();
		
	}

	protected void init(Tag resTag) {
		super.__init_0(resTag);
		//ResultList class 的名字
		String shortName = this.className.substring(0, this.className.lastIndexOf(this.voType)) ;
		this.resultClassName = shortName + "List";
		this.objClassName = shortName + "Obj";
		this.resultVOName = shortName + "ResultVO";
		//Result标签.暂时没看到里面的子标签还有子标签的~有添加处理吧~~
		for(Tag t : resTag.getTagByNamesReal("RESULT").getChildTagList()){
			super.__init_1_separateVariable(t, Conf.responsePaVariableMap);
		}
		
		//<RESULTLIST>的子级标签.根据层级分类,如:<REC>只有子标签,而<PRS> <ORP>含有子子标签.
		Tag resultList = resTag.getTagByNamesReal("RESULTLIST");
		if(null != resultList  && null != resultList.getChildTagList())
		for(Tag t : resultList.getChildTagList()){
			//一般来说只有1层或者2层
			int repeat = t.getMapColor().get(0).split(" ").length;
			if(repeat == 1){
				this.layerTagList1.add(t);
			}
			else if(repeat == 2){
				this.layerTagList2.add(t);
			}else{
				throw new RuntimeException("尚不支持的RESULTLIST层级嵌套,请在此处添加.");
			}
		}
		//如果标签<RESULTLIST>里面有子标签则
		if(this.layerTagList1.size() > 0 || this.layerTagList2.size() > 0){
			this.hasResultList = true;
			this.typeList.add("List");
		}
		//设置内部类缩写对应的全名和注释.
		_init_innerClass();
	}
	

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 设置内部类缩写对应的全名.
	 * </ul>
	 */
	private void _init_innerClass() {
		//1层的
		_init_innerClass_op(this.layerTagList1);
		//2层的
		_init_innerClass_op(this.layerTagList2);
		for(Tag t : this.layerTagList2){
			_init_innerClass_op(t.getChildTagList());
		}
		/**------注释不需要默认!自己不填没有就算了!------*/
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 把responseInnerClassNameMap里包含XXX的value中的XXX替换为this.objClassName.<br/>
	 * 主要是因为REC的类名是动态生成的,为了能和其他标签一样同样方法,这里做了REC对应类名的修饰.<br/>
	 * 方法主要是__create_infoClass(Tag tag)这个<br/>
	 * </ul>
	 * @param tagList
	 */
	private void _init_innerClass_op(List<Tag> tagList) {
		for(Tag t : tagList){
			String key = t.getTagName();
			//主要是对付REC那种类名是动态的.有需要的话去responseInnerClassNameMap里添加,XXX是被替换内容.
			String value = this.responseInnerClassNameMap.get(key).replace("XXX", this.objClassName);
			this.responseInnerClassNameMap.put(key, value);
		}
	}


	@SuppressWarnings("unchecked")
	@Override
	protected void __initVar() {
		this.mustImport = UtilCollection.deepCopyList(Conf.mustImport_response);
		this.importMap = UtilCollection.deepCopyMap(Conf.importMapResponse);
		
		this.extendClass = "ResponseVO";
		this.voType = Conf.RESPONSEVO;
	}

	/**
	 * 创建主类中resultList的get set方法.
	 */
	protected Collection<? extends String> _createProperty_pa_constructor_response() {
		List<String> l = new ArrayList<String>();
		if(this.hasResultList){
			l.add("");
			l.add("/** 集合类 */");
			l.add("private "+this.resultClassName+" RESULTLIST;");
			l.add("");
			l.add("/**");
			l.add(" * 获取集合类");
			l.add(" * <br/><br/>");
			l.add(" * @return");
			l.add(" */");
			l.add("public "+this.resultClassName+" getResultList(){");
			l.add("	return RESULTLIST;");
			l.add("}");
			l.add("");
			l.add("/**");
			l.add(" * 设置集合类");
			l.add(" * <br/><br/>");
			l.add(" * @param resultList");
			l.add(" */");
			l.add("public void setResultList("+this.resultClassName+" resultList){");
			l.add("	RESULTLIST = resultList;");
			l.add("}");
			l.add("");
		}
		return l;
	}
	
	
}
