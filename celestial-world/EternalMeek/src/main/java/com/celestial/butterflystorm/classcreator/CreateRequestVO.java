package com.celestial.butterflystorm.classcreator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.celestial.agniRadiance.EzUtil.Util_Collection;
import com.celestial.agniRadiance.EzUtil.Util_Normal;
import com.celestial.agniRadiance.EzUtil.Util_String;
import com.celestial.agniRadiance.entity.FileReader;
import com.celestial.agniRadiance.entity.Tag;
import com.celestial.butterflystorm.classcreator.silence.Conf;

public class CreateRequestVO extends VOcreator{
	

	
	/**agniRadiance
	 * 
	 * <b>���췽��</b>
	 * ͨ����ǩ������.<br/>
	 * <br/>
	 * @param protocolTag req��ǩ
	 */
	public CreateRequestVO(Tag reqTag) {
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
		this.voClassStringList.addAll(Util_Normal.table(_createAllVariables()));
		//3.25 ���������Ķ����get set����(���м������)
		for(Tag t : this.layerTagList){
			this.voClassStringList.addAll(Util_Normal.table(__createOneInnerClassDefine(t)));
		}
		//3.5����������� 4.��ӹ��췽������ע��
		this.voClassStringList.addAll(Util_Normal.table(_createProperty_pa_constructor_response()));
		//5.�������get��������ע��
		this.voClassStringList.addAll(Util_Normal.table(_createAllGet(this.directTagList)));
		//6.����ڲ���
		this.voClassStringList.addAll(Util_Normal.table(_createInnerClass()));
		//���� ���toString����
		this.voClassStringList.addAll(Util_Normal.table(__createToString()));
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
		String className = Conf.requestInnerClassNameMap.get(tagName);
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
		l.add("public class " + Conf.requestInnerClassNameMap.get(t.getTagName()) + " {");
		//1.�����������ڲ�����Ϣ��������� ��ʼ�� get set���� private List<PropertyObj> PRO = new ArrayList<PropertyObj>(); 
		for(Tag ti : t.getChildTagList()){
			l.addAll(Util_Normal.table(___createInnerProperty(ti)));
		}
		//2.�����������ڲ�����Ϣ��<PRO>��һ��
			/*<PRO>��Ʒ����
				<BP>��������</BP>
				<CP>��Ʒ����ֵ</CP>
			</PRO>*/
		for(Tag ti : t.getChildTagList()){
			l.addAll(Util_Normal.table(___createInnerPropertyClass(ti)));
		}
		l.addAll(Util_Normal.table(__createToString()));
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
		String className = Conf.requestInnerClassNameMap.get(propertyName);
		
		l.add("/**");
		l.add(" * ������");
		l.add(" */");
		l.add("public class "+className+" {");
		l.addAll(Util_Normal.table(__createNormalVariable( t.getChildTagList())));
		l.add("	/**");
		l.add("	* <b>���췽��</b>");
		l.add("	* <br/>");
		l.add("	*/");
		l.add("	public "+className+"() {");
		l.add("		super();");
		l.add("	}");
		l.add("	");
		l.addAll(Util_Normal.table(_createAllGet(t.getChildTagList())));
		l.addAll(Util_Normal.table(__createToString()));
		l.add("}");
		l.add("");
		return l;
	}


	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ���toString()����.
	 * </ul>
	 * @return
	 */
	private Collection<? extends String> __createToString() {
		List<String> l = new ArrayList<String>();
		l.add("@Override");
		l.add("public String toString() {");
		l.add("	return ToStringBuilder.reflectionToString(this, ToStringStyle.SIMPLE_STYLE);");
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
		String className = Conf.requestInnerClassNameMap.get(propertyName);
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
		l.add("public "+ type + " get"+Util_String.__transHeadToUpperCase(t.getPropertyMap().get("ref")) + "(){");
		l.add("	return " + Conf.supportMap.get(type).replace("X", t.getTagName()));
		l.add("}");
		l.add("");
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
		l.addAll(__create_paGetter());
		l.addAll(__create_getReponse());
		return l;
	}

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ���ɷ���response�Ĵ���.
	 * </ul>
	 * @return
	 */
	private Collection<? extends String> __create_getReponse() {
		List<String> l = new ArrayList<String>();
		//����public ResponseVO getResponseVO()���� ����ע��
		String head = className.substring(0, className.indexOf("RequestVO"));
		l.add("@Override");
		l.add("public ResponseVO getResponseVO() {");
		l.add("	return new "+head+"ResponseVO();");
		l.add("}");
		l.add("");
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

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ������������get set����.<br/>
	 * ��userID sessionID��û�в�ͬŶ~
	 * </ul>
	 * @return
	 */
	private Collection<? extends String> __create_paGetter() {
		//���ھ�������,��Ҫ�ټ�.����˵����������(������)������.
		List<String> l = new ArrayList<String>();
		
		if(this.directTagListPa.size() > 0){
			for(Tag t : this.directTagListPa){
				if("U".equals(t.getTagName())){
					l.add("@Override");
					l.add("public String getUserID() {");
					l.add("	return U;");
					l.add("}");
					l.add("");
				}
				else if("SI".equals(t.getTagName())){
					l.add("@Override");
					l.add("public long getSessionID() {");
					l.add("	return StringUtil.strToLong(SI,0);");
					l.add("}");
					l.add("");
				}
				else{
					throw new RuntimeException("��֧�ֵļ̳�Ԫ��.�����֧�ֻ�����д֧�ַ���.");
				}
			}
		}else{
			l.add("@Override");
			l.add("public String getUserID() {");
			l.add("	return null;");
			l.add("}");
			l.add("");
			l.add("@Override");
			l.add("public long getSessionID() {");
			l.add("	return StringUtil.strToLong(null,0);");
			l.add("}");
			l.add("");
		}
		
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
			String innerClassName = Conf.requestInnerClassNameMap.get(tagName);
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
				super.__init_1_separateVariable(t,Conf.requestPaVariableMap);
			}
		}
		
	}
	
	public static void main(String[] args) {
		FileReader f = new FileReader("E:/anotherDeskTop/parese2/fall/E�ֻ�--�ֻ��ͻ����������ͨ��Э��(��).txt");
		FileReader f1 = f.selectAllLineBetweenRegex2("10\\. ��Ʒί�в�ѯ", "11\\. ��Ʒί�������ѯ");
		List<List<String>> requestReader = f1.selectAllLineBetweenRegexList(".*�����.*", ".*���ذ�.*");
		
		/*FileReader f = new FileReader("E:/anotherDeskTop/parese2/fall_����/Ͷ����--�ֻ��ͻ�����ֵ�������ͨ��Э��.txt");
		FileReader f1 = f.selectAllLineBetweenRegex2("4\\.�깺ί�в�ѯ", "5\\.�깺�ɽ���ѯ");
		List<List<String>> requestReader = f1.selectAllLineBetweenRegexList(".*�ύ��.*", ".*���ذ�.*");*/
		
		Tag requestTag = new Tag(Util_Collection.transListToLine(requestReader.get(0)));
		Tag req = requestTag.getTagByNamesReal("REQ");
		
		CreateRequestVO cr = new CreateRequestVO(req);
		Util_Collection.print(cr.getVoClassStringList());
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void __initVar() {
		this.mustImport = Util_Collection.deepCopyList(Conf.mustImport_request);
		this.importMap = Util_Collection.deepCopyMap(Conf.importMap);
		
		this.extendClass = "RequestVO";
		this.voType = Conf.REQUESTVO;
	}
	
	
}
