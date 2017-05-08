package com.celestial.butterflystorm.butterfly2016.classcreator;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.celestial.agniRadiance.EzUtil.Util_Collection;
import com.celestial.agniRadiance.EzUtil.Util_File;
import com.celestial.agniRadiance.EzUtil.Util_String;
import com.celestial.agniRadiance.entity.Tag;
import com.celestial.butterflystorm.butterfly2016.classcreator.silence.Conf;


public abstract class VOcreator {
	
	/**
	 * �����ɵ�VO�����
	 */
	protected List<String> voClassStringList = new ArrayList<String>(); 
	
	/**
	 * �������
	 */
	protected String className;
	
	/**
	 * ��������,Э�����еĻ���Э�����ȡ.��ȻΪĬ��
	 */
	protected String packageName = "gnnt";
	
	/**
	 * ���ע��
	 */
	protected String annotation;
	
	/**
	 * ������Ǽ̳е�ֱ�ӱ�ǩ
	 */
	protected List<Tag> directTagList = new ArrayList<Tag>();
	
	/**
	 * �����ӱ�ǩ��ֱ�ӱ�ǩ,���������ڲ���������ݵ�
	 * ����:�ڲ����get set ����,���䶨��(���ڲ����Ա�����ͳ�Ա��������ɶ�ڲ���get set����)
	 */
	protected List<Tag> layerTagList = new ArrayList<Tag>();
	
	/**
	 * �̳и����ֱ���ӱ�ǩ
	 */
	protected List<Tag> directTagListPa = new ArrayList<Tag>();
	
	/**
	 * ���е����ͼ���
	 */
	protected List<String> typeList = new ArrayList<String>();

	/**
	 * ÿ���඼Ҫ����İ�.
	 */
	protected  List<String> mustImport = new ArrayList<String>();
	
	/**
	 * ��Ӧ�������͵ĳ�Ա������Ӧ��Ҫ����İ�.�������г�ʼ��~
	 */
	protected Map<String,String[]> importMap = new HashMap<String, String[]>();
	
	/**
	 * RequestVo ResponseVO�̳еĸ�������ֻ?�����г�ʼ��~
	 */
	protected String extendClass = "";
	
	/**
	 * �������RequestVo����ResponseVO ? �����г�ʼ��~
	 */
	protected String voType = "";
	
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * RequestVO��ResponseVO���õĳ�ʼ������.<br/>
	 * ��ʼ��className packageName �� annotation<br/>
	 * </ul>
	 * @param initTag
	 */
	protected void __init_0(Tag initTag) {
		__initVar();//��Ȼ˵�������е����..����Ҫ����һ����������ʵ��ķ�����������ʱ�ȽϺ���..���ع����֮���ٻ�λ�ð�
		this.className = transName(initTag.getPropertyMap().get("name"));
		String pkg = initTag.getPropertyMap().get("pkg");
		if(pkg != null && !"".equals(pkg))
			this.packageName = pkg;
		String ano = initTag.getPropertyMap().get("ie");
		if(ano != null && !"".equals(ano))
			this.annotation = ano;
		
	}
	
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ��cmd_order_queryתΪCmdOrderQueryRequestVO������<br/>
	 * </ul>
	 * @param str
	 * @return
	 */
	protected String transName(String str) {
		String[] sArr = str.split("_");
		StringBuffer sb = new StringBuffer();
		for(String i: sArr){
			sb.append(Util_String.__transHeadToUpperCase(i));
		}
		return sb.append(this.voType).toString();
	}

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * �����ڸ���ĳ�Ա��������ͨ�ĳ�Ա�����ֿ�.<br/>
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
	 * <b>����˵����</b>
	 * <ul>
	 * ��Ա����,����,����,ע�� ȱһ���쳣<br/>
	 * ��У�鷽�����ظ��ͱ������ظ�<br/>
	 * </ul>
	 * @param directTagList2
	 */
	protected void checkTagList(List<Tag> tagList) {
		for(Tag t : tagList){
			String type = t.getPropertyMap().get("type");
			addType(type);
			boolean b1 = Util_File.checkNotNullnotKong(t.getTagName());
			boolean b2 = Util_File.checkNotNullnotKong(t.getPropertyMap().get("ref"));
			boolean b3 = Util_File.checkNotNullnotKong(type);
			
			boolean b4 = Util_File.checkNotNullnotKong(t.getValue());
			if(!(b1 && b2 && b3 && b4))
				throw new RuntimeException("��ǩ : <" + t.getTagName() + "> ������,������ref,type���Ժ���ֵ�Ƿ�����.");
		}
	}
	
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ��������ӵ�typeList����.
	 * </ul>
	 * @param type
	 */
	protected void addType(String type) {
		if(!Util_Collection.contain(this.typeList, type)){
			this.typeList.add(type);
		}
	}
	
	protected abstract int createClass();
	protected abstract void init(Tag t);
	
	protected abstract Collection<? extends String> _createProperty_pa_constructor_response();
	
	/**
	 * 
	 * <b>����˵����</b>
	 * <ul>
	 * У������������<br/>
	 * �������������û��<br/>
	 * </ul>
	 */
	protected abstract void checkParamArr();
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ������Ϣ
	 * </ul>
	 * @return
	 */
	protected Collection<? extends String> _createPackageInfo() {
		List<String> l = new ArrayList<String>();
		//--��--��
		l.add("package "+this.packageName+";");
		l.add("");
		//--��--
		//--��--��֮��Ϊ����Ҫ���İ�.���֮�����˿���д��������ʽ.
		
		for(String si : this.mustImport){
			l.add("import " + si + ";");
		}
		l.add("");
		//--��--
		for(String i: this.typeList){
			String[] importString = this.importMap.get(i);
			if(importString == null)
				continue;
			for(String si : importString){
				if(!Util_Collection.contain(l,si)){
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
	 * <b>����˵����</b>
	 * <ul>
	 * ��������ʵ��<br/>
	 * ���mustImport ��  importMap������ʵ��.��Ҳ������<br/>
	 * </ul>
	 */
	protected abstract void __initVar();

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ���õļ����ǩ������.
	 * </ul>
	 */
	protected void __checkParamArr_0() {
		//У��ֱ���ӱ�ǩ���� ���Ұ�������ӵ�typeList����
		checkTagList(this.directTagList);
		//��鸸��ֱ���ӱ�ǩ
		checkTagList(this.directTagListPa);
		
	}
	
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ������ע��
	 * </ul>
	 * @return
	 */
	protected Collection<? extends String> _createClassAnnotation() {
		List<String> l = new ArrayList<String>();
		l.add("/**");
		l.add(" * ");
		l.add(" * <b>�޸ļ�¼��</b> ");
		l.add(" * <p>");
		l.add(" * <li>");
		l.add(" * ");
		l.add(" *                        ---- " + Conf.AUTHOR + "  " + new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		l.add(" * </li>");
		l.add(" * </p>");
		l.add(" * ");
		l.add(" * <b>��˵����" + this.annotation + "</b>");
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
	 * <b>����˵����</b>
	 * <ul>
	 * ����������Ͳ�����������,�׳��쳣.��Ҫ֧�ֵĻ��Լ����.<br/>
	 * �漰�����͵Ĳ�����ʽtransTypeWaysMap <br/>
	 * ����Ҫ����İ�importMap <br/>
	 * </ul>
	 */
	protected void checkType() {
		for(String i : this.typeList){
			if(Conf.supportMap.get(i) == null)
				throw new RuntimeException("���� " + i + "��֧��!�������� ");
		}
		
	}
	
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ��ȡ���ɺ��˵�RequestVO���ַ�������.
	 * </ul>
	 * @return
	 */
	public List<String> getVoClassStringList() {
		return voClassStringList;
	}

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ������Ĳ����ĵ�һ����.<br/>
	 * �ɹ�����ȡ<br/>
	 * </ul>
	 */
	protected void _createClass_p1() {
		//0.У�����������
		checkParamArr();
		//1.���ͷ����Ϣ (���� ����ɶ��)
		this.voClassStringList.addAll(_createPackageInfo());
		//2.������ע��
		this.voClassStringList.addAll(_createClassAnnotation());
		this.voClassStringList.add("public class " + this.className + " extends "+this.extendClass+"{");
	}

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ��ʼ��,�������Ĵ���.<br/>
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