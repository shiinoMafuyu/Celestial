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
	 * <b>���췽��</b>
	 * ͨ����ǩ������.<br/>
	 * <br/>
	 * @param protocolTag req��ǩ
	 */
	public CreateSexRequestVO(Tag reqTag) {
		super.initAndCreate(reqTag);
	}

	/**
	 * 
	 * <b>����˵����</b>
	 * <ul>
	 * ������
	 * </ul>
	 */
	protected int createClass() {
		super._createClass_p1();
		//3.������б�������ע��
		this.voClassStringList.addAll(UtilNormal.table(_createAllVariables()));
		//3.25 ���������Ķ����get set����(���м������)
		for(Tag t : this.layerTagList){
			this.voClassStringList.addAll(UtilNormal.table(__createOneInnerClassDefine(t)));
		}
		//3.5����������� 4.��ӹ��췽������ע��
		this.voClassStringList.addAll(UtilNormal.table(_createProperty_pa_constructor_response()));
		//5.�������get��������ע��
		this.voClassStringList.addAll(UtilNormal.table(_createAllGet(this.directTagList)));
		//6.����ڲ���
		this.voClassStringList.addAll(UtilNormal.table(_createInnerClass()));
		//���� ���toString����
		this.voClassStringList.add("}");
		this.voClassStringList.add("");
		return 0;
	}

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * �����ڲ���
	 * </ul>
	 * @return
	 */
	private Collection<? extends String> _createInnerClass() {
		List<String> l = new ArrayList<String>();
		//1.���������Ķ����get set����(�ŵ�����ȥ ������б���ĩβ~)
		
		//2.����ڲ���<PROS>��һ��. ÿ����һ���ı�ǩ��Ӧһ��������.<PROS>��Ӧ����PropertyList,Ŀǰֻ���������Ҫ�Լ�ȥConf.requestInnerClassNameMap����.
			/*<PROS>
				<PRO>��Ʒ����
					<BP>��������</BP>
					<CP>��Ʒ����ֵ</CP>
				</PRO>
			</PROS>*/
		for(Tag t : this.layerTagList){
			l.addAll(__createInnerGatherClass(t));
		}
		return l;
	}

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ����������Ը��������Ա�������������.
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
		l.add(" * <b>����˵����</b>");
		l.add(" * <ul>");
		l.add(" * ��ȡ"+t.getValue()+"�б�");
		l.add(" * </ul>");
		l.add(" * @return");
		l.add(" */");
		l.add("public "+className+" get"+className+"() {");
		l.add("	return "+tagName+";");
		l.add("}");
		return l;
	}

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ����һ���ڲ���()
	 * </ul>
	 * @param t
	 * @return
	 */
	private Collection<? extends String> __createInnerGatherClass(Tag t) {
		List<String> l = new ArrayList<String>();
		l.add("/**");
		l.add(" * ������");
		l.add(" */");
		l.add("public class " + SexGameConf.requestInnerClassNameMap.get(t.getTagName()) + " {");
		//1.�����������ڲ�����Ϣ��������� ��ʼ�� get set���� private List<PropertyObj> PRO = new ArrayList<PropertyObj>(); 
		for(Tag ti : t.getChildTagList()){
			l.addAll(UtilNormal.table(___createInnerProperty(ti)));
		}
		//2.�����������ڲ�����Ϣ��<PRO>��һ��
			/*<PRO>��Ʒ����
				<BP>��������</BP>
				<CP>��Ʒ����ֵ</CP>
			</PRO>*/
		for(Tag ti : t.getChildTagList()){
			l.addAll(UtilNormal.table(___createInnerPropertyClass(ti)));
		}
		l.add("}");
		l.add("");
		return l;
	}

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ���������������������.
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
		l.add(" * ������");
		l.add(" */");
		l.add("public class "+className+" {");
		l.addAll(UtilNormal.table(__createNormalVariable( t.getChildTagList())));
		l.add("	/**");
		l.add("	* <b>���췽��</b>");
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
	 * <b>����˵����</b>
	 * <ul>
	 * ������������ڲ�����.������Ա�������� ע�� get set����֮��.
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
			throw new RuntimeException("Conf.requestInnerClassNameMap��δ�ҵ� " + propertyName +"��Ӧ����.");
		l.add("/**");
		l.add(" * " + annotation);
		l.add(" */");
		l.add("private List<" + className + "> " + propertyName + " = new ArrayList<" + className + ">();");
		l.add("");
		l.add("/**");
		l.add("* <b>����˵����</b>");
		l.add("* <ul>");
		l.add("* ����" + annotation);
		l.add("* </ul>");
		l.add("* @param list");
		l.add("*/");
		l.add("public void setList(ArrayList<"+className+"> list) {");
		l.add("	"+propertyName+" = list;");
		l.add("}");
		l.add("");
		l.add("/**");
		l.add("* <b>����˵����</b>");
		l.add("* <ul>");
		l.add("* ��ȡ" + annotation);
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
	 * <b>����˵����</b>
	 * <ul>
	 * ������ͨ��Ա������get��������ע��.
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
	 * <b>����˵����</b>
	 * <ul>
	 * ����get��������ע��.
	 * </ul>
	 * @param t
	 * @return
	 */
	private Collection<? extends String> __creaeteGetMethod(Tag t) {
		List<String> l = new ArrayList<String>();
		l.add("/**");
		l.add(" * <b>����˵����</b>");
		l.add(" * <ul>");
		l.add(" * ��ȡ" + t.getValue() + "");
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
	 * <b>����˵����</b>
	 * <ul>
	 * �����м䲿��
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
	 * <b>����˵����</b>
	 * <ul>
	 * �������췽��.<br/>
	 * û��userID sessionIDʱ��Ҫ���ι��캯��<br/>
	 * </ul>
	 * @return
	 */
	private Collection<? extends String> __createConstructor() {
		List<String> l = new ArrayList<String>();
		String head = className.substring(0, className.indexOf("RequestVO"));
		//TemplateQueryRequestVO
		l.add("/**");
		l.add(" * <b>���췽��</b>");
		l.add(" * <br/>");
		l.add(" */");
		l.add("public "+head+"RequestVO() {");
		l.add("	super();");
		l.add("}");
		l.add("");
		if(this.directTagListPa.size() > 0){
			l.add("/**");
			l.add(" * <b>���췽��</b>");
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
	 * <b>����˵����</b>
	 * <ul>
	 * �����ڲ����������
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
	 * <b>����˵����</b>
	 * <ul>
	 * �������������б�������ע��.
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
	 * <b>����˵����</b>
	 * <ul>
	 * ���������������ע��
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
	 * <b>����˵����</b>
	 * <ul>
	 * �����еı���
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
	 * <b>����˵����</b>
	 * <ul>
	 * ���ݻ����ǩ��������<br/>
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
		//У���ڲ����ǩ���� ���Ұ�������ӵ�typeList����
		if(this.layerTagList.size() > 0){
			this.typeList.add("ToStringStyle");
			this.typeList.add("List");
			for(Tag t : this.layerTagList){
				checkLayerTag(t);
			}
		}
		//����������������û.
		checkType();
	}



	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ����ڲ����ǩ��Ķ���<br/>
	 * </ul>
	 * @param t
	 */
	private void checkLayerTag(Tag t) {
		//����ֻ�������������,�Ͱ�3����д,����Ҫ�ٸ�.
		for(Tag t1 : t.getChildTagList()){
			checkTagList(t1.getChildTagList());
		}
		
	}
	
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ��ʼ����Ա����  <br/>
	 * </ul>
	 * @param reqTag
	 */
	protected void init(Tag reqTag) {
		super.__init_0(reqTag);
		for(Tag t : reqTag.getChildTagList()){
			if(t.getMapColor() != null && t.getMapColor().size() >0){
				this.layerTagList.add(t);
			}else{
				//�����Conf��requestPaVariableMap�ﶨ�����ȥ��.
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
