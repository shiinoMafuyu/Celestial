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
	 * �㼶Ϊ1��<RESULTLIST>��ǩ
	 */
	private List<Tag> layerTagList1 = new ArrayList<Tag>();
	
	/**
	 * �㼶Ϊ2��<RESULTLIST>��ǩ
	 */
	private List<Tag> layerTagList2 = new ArrayList<Tag>();
	

	
	/**
	 * RESULTLIST��Ա����������.(��Ҫ�����������)
	 */
	private String resultClassName = "";
	
	/**
	 * ��Ҫ��Ϣ�������.
	 */
	private String objClassName = "";
	
	/**
	 * �����Ƿ���ResultList
	 */
	private boolean hasResultList = false;
	
	/**
	 * �����Ϣ������
	 */
	private String resultVOName = "";
	
	
	/**
	 * ReponseVO��,ResultList������ӱ�ǩ��д��Ӧ������.<br/>
	 * XXX��Ϊ���滻�ı��.<br/>
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
	 * ���ݷ��ر�ǩ���ɷ�����.
	 * <b>���췽��</b>
	 * <br/>
	 * @param resTag
	 */
	public CreateResponseVO(Tag resTag) {
		super.initAndCreate(resTag);
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
		//3.5����������� 4.��ӹ��췽������ע��
		this.voClassStringList.addAll(UtilNormal.table(_createProperty_pa_constructor_response()));
		
		//4.������Ҫ������.
		this.voClassStringList.addAll(UtilNormal.table(_createMainList()));
		//5.������ҪResultVOʵ����.
		this.voClassStringList.addAll(UtilNormal.table(_createResultVO_impl()));
		//6.����ʣ�µļ��������Ϣ��.�򵥵Ĺ�����O(��_��)O����~
		this.voClassStringList.addAll(UtilNormal.table(_createInnerCollection_Info()));
		this.voClassStringList.add("}");
		this.voClassStringList.add("");
		return 0;
	}
	

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * 
	 * </ul>
	 * @return
	 */
	private Collection<? extends String> _createResultVO_impl() {
		List<String> l = new ArrayList<String>();
		l.add("/**");
		l.add(" * ���ؽ����Ϣ��");
		l.add(" */");
		l.add("public class "+this.resultVOName+" extends ResultVO{");
		this.directTagList.get(0);
		l.addAll(UtilNormal.table(__create_normalVarAndSetter(this.directTagList)));
		l.add("}");
		l.add("");
		return l;
	}

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ����һ������Ķ����Setter����<br/>
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
	 * <b>����˵����</b>
	 * <ul>
	 * ����һ�������Setter����.<br/>
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
			l.add(" * <b>����˵����</b>");
			l.add(" * <ul>");
			l.add(" * ����"+t.getValue());
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
	 * <b>����˵����</b>
	 * <ul>
	 * ����һ�����.<br/>
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
	 * <b>����˵����</b>
	 * <ul>
	 * ����layerTagList1 layerTagList2 �����Ӧ�ļ��������Ϣ��.<br/>
	 * �ʹ󹦸����.<br/>
	 * </ul>
	 * @return
	 */
	private Collection<? extends String> _createInnerCollection_Info() {
		List<String> l = new ArrayList<String>();
		//����������
		for(Tag t : this.layerTagList2){
			l.addAll(__create_collectionClass(t));
		}
		//���洴����Ϣ��
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
	 * <b>����˵����</b>
	 * <ul>
	 * ������Ϣ��.<br/>
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
	 * <b>����˵����</b>
	 * <ul>
	 * �������ǩ�Ĵ���������.<br/>
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
		l.add("	/** ��Ϣ���� */");
		l.add("	private List<"+collectionClassName+"> "+tagName+";");
		l.add("");
		l.add("	/**");
		l.add("	 * ");
		l.add("	 * ��ȡ��Ϣ����");
		l.add("	 * <br/><br/>");
		l.add("	 * @return");
		l.add("	 */");
		l.add("	public List<"+collectionClassName+"> getList(){");
		l.add("		return "+tagName+";");
		l.add("	}");
		l.add("");
		l.add("	/**");
		l.add("	 * ");
		l.add("	 * ������Ϣ����");
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
	 * <b>����˵����</b>
	 * <ul>
	 * ������Ҫ�Ľ��������.
	 * </ul>
	 * @return
	 */
	private List<String> _createMainList() {
		List<String> l = new ArrayList<String>();
		if(!this.hasResultList)
			return l;
		l.add("/**");
		l.add(" * ���ļ�����");
		l.add(" */");
		l.add("public class "+this.resultClassName+"{");
		
		l.addAll(UtilNormal.table(__create_1_p1()));//PRS ORP֮�� private PropertyList PRS; ��һ��
		
		for(Tag t : this.layerTagList1){
			l.addAll(UtilNormal.table(__create_2_p1(t)));//private List<SubOrderQueryObj> REC; ��һ��
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
	 * <b>����˵����</b>
	 * <ul>
	 * ����һ��p2����:������Ա������get set����.
	 * </ul>
	 * @param t
	 * @return
	 */
	private Collection<? extends String> __create_2_p2(Tag t) {
		List<String> l = new ArrayList<String>();
		String innerClassName = this.responseInnerClassNameMap.get(t.getTagName());
		l.add("/**");
		l.add(" * ��ȡ��Ϣ����");
		l.add(" * <br/><br/>");
		l.add(" * @return");
		l.add(" */");
		l.add("public List<"+innerClassName+"> getList(){");
		l.add("	return "+t.getTagName()+";");
		l.add("}");
		l.add("");
		l.add("/**");
		l.add(" * ������Ϣ����");
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
	 * <b>����˵����</b>
	 * <ul>
	 * �����ڶ��㼶��p2����:��ӳ�Ա������get set����.<br/>
	 * </ul>
	 * @return
	 */
	private List<String> __create_1_p2() {
		List<String> l = new ArrayList<String>();
		for(Tag t : this.layerTagList2){
			String innerClassName = this.responseInnerClassNameMap.get(t.getTagName());
			l.add("/**");
			l.add(" * ��ȡ"+t.getValue());
			l.add(" * <br/><br/>");
			l.add(" * @return");
			l.add(" */");
			l.add("public "+innerClassName+" get"+innerClassName+"(){");
			l.add("	return "+t.getTagName()+";");
			l.add("}");
			l.add("");
			l.add("/**");
			l.add(" * ����"+t.getValue());
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
	 * <b>����˵����</b>
	 * <ul>
	 * �����ڶ��㼶p1����:��ӳ�Ա����<br/>
	 * </ul>
	 * @param t
	 * @return
	 */
	private List<String> __create_2_p1(Tag t) {
		List<String> l = new ArrayList<String>();
		l.add("/** ��Ϣ�༯�� */");
		l.add("private List<"+this.responseInnerClassNameMap.get(t.getTagName())+"> "+t.getTagName()+";");
		return l;
	}

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * �����ע���һ�㼶 p1����:��ӳ�Ա����.(һ���û�����)<br/>
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
		//1.����RESULTLIST�ӱ�ǩ������������.
		//1)1���
		for(Tag t : this.layerTagList1){
			super.checkTagList(t.getChildTagList());
		}
		//2)2���
		for(Tag t : this.layerTagList2){
			for(Tag i : t.getChildTagList()){
				super.checkTagList(i.getChildTagList());
			}
		}
		
		//����������������û.
		checkType();
		
	}

	protected void init(Tag resTag) {
		super.__init_0(resTag);
		//ResultList class ������
		String shortName = this.className.substring(0, this.className.lastIndexOf(this.voType)) ;
		this.resultClassName = shortName + "List";
		this.objClassName = shortName + "Obj";
		this.resultVOName = shortName + "ResultVO";
		//Result��ǩ.��ʱû����������ӱ�ǩ�����ӱ�ǩ��~����Ӵ����~~
		for(Tag t : resTag.getTagByNamesReal("RESULT").getChildTagList()){
			super.__init_1_separateVariable(t, Conf.responsePaVariableMap);
		}
		
		//<RESULTLIST>���Ӽ���ǩ.���ݲ㼶����,��:<REC>ֻ���ӱ�ǩ,��<PRS> <ORP>�������ӱ�ǩ.
		Tag resultList = resTag.getTagByNamesReal("RESULTLIST");
		if(null != resultList  && null != resultList.getChildTagList())
		for(Tag t : resultList.getChildTagList()){
			//һ����˵ֻ��1�����2��
			int repeat = t.getMapColor().get(0).split(" ").length;
			if(repeat == 1){
				this.layerTagList1.add(t);
			}
			else if(repeat == 2){
				this.layerTagList2.add(t);
			}else{
				throw new RuntimeException("�в�֧�ֵ�RESULTLIST�㼶Ƕ��,���ڴ˴����.");
			}
		}
		//�����ǩ<RESULTLIST>�������ӱ�ǩ��
		if(this.layerTagList1.size() > 0 || this.layerTagList2.size() > 0){
			this.hasResultList = true;
			this.typeList.add("List");
		}
		//�����ڲ�����д��Ӧ��ȫ����ע��.
		_init_innerClass();
	}
	

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * �����ڲ�����д��Ӧ��ȫ��.
	 * </ul>
	 */
	private void _init_innerClass() {
		//1���
		_init_innerClass_op(this.layerTagList1);
		//2���
		_init_innerClass_op(this.layerTagList2);
		for(Tag t : this.layerTagList2){
			_init_innerClass_op(t.getChildTagList());
		}
		/**------ע�Ͳ���ҪĬ��!�Լ�����û�о�����!------*/
	}

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ��responseInnerClassNameMap�����XXX��value�е�XXX�滻Ϊthis.objClassName.<br/>
	 * ��Ҫ����ΪREC�������Ƕ�̬���ɵ�,Ϊ���ܺ�������ǩһ��ͬ������,��������REC��Ӧ����������.<br/>
	 * ������Ҫ��__create_infoClass(Tag tag)���<br/>
	 * </ul>
	 * @param tagList
	 */
	private void _init_innerClass_op(List<Tag> tagList) {
		for(Tag t : tagList){
			String key = t.getTagName();
			//��Ҫ�ǶԸ�REC���������Ƕ�̬��.����Ҫ�Ļ�ȥresponseInnerClassNameMap�����,XXX�Ǳ��滻����.
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
	 * ����������resultList��get set����.
	 */
	protected Collection<? extends String> _createProperty_pa_constructor_response() {
		List<String> l = new ArrayList<String>();
		if(this.hasResultList){
			l.add("");
			l.add("/** ������ */");
			l.add("private "+this.resultClassName+" RESULTLIST;");
			l.add("");
			l.add("/**");
			l.add(" * ��ȡ������");
			l.add(" * <br/><br/>");
			l.add(" * @return");
			l.add(" */");
			l.add("public "+this.resultClassName+" getResultList(){");
			l.add("	return RESULTLIST;");
			l.add("}");
			l.add("");
			l.add("/**");
			l.add(" * ���ü�����");
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
