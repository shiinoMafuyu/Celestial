/******************************************************************
 * CoreCreator.java
 * Copyright 2017 by WZG. All Rights Reserved.
 * CreateDate��2017��6��11��
 * Author��wangzg
 * Version��1.0.0
 ******************************************************************/

package com.celestial.butterflystorm.butterfly2017.ClassCreatorSuperStar.core.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.celestial.agniRadiance.EzUtil.UtilNormal;
import com.celestial.agniRadiance.EzUtil.UtilReflect;
import com.celestial.agniRadiance.EzUtil.UtilString;
import com.celestial.butterflystorm.butterfly2017.ClassCreatorSuperStar.CoreCreatorConfig;
import com.celestial.butterflystorm.butterfly2017.ClassCreatorSuperStar.core.IAliceWonderLand;
import com.celestial.butterflystorm.butterfly2017.ClassCreatorSuperStar.core.IOrientalBrightNightCity;
import com.celestial.butterflystorm.butterfly2017.ClassCreatorSuperStar.vo.AClass;

/**
 * <b>�޸ļ�¼��</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2017��6��11��
 * </li>
 * </p>
 * 
 * <b>��˵����</b>
 * <p> 
 * 
 * </p>
 */
@SuppressWarnings("unused")
public class OrientalBrightNightCity implements IOrientalBrightNightCity{
	
	private static Map<String, String> rangeMap = CoreCreatorConfig.CfMap;
	
	private String qualifiedName;
	private String packageName;
	private String name;
	private String superName;
	
	private String classAnnotion = "�������磬������ʷ��Ϊֹ���ơ�";
	private String author = "wangzg";
	
	private String[] interfaces;
	private AClass[] innerClass;
	private String[][] variables;//String[] = [��Ա�����������ͣ�ע�͡�ȫ��]
	
	IAliceWonderLand alc = new AliceWonderLand();
	
	/**
	 * <b>���췽��</b>
	 * <br/>
	 */
	public OrientalBrightNightCity() {
	}
	
	@SuppressWarnings("unchecked")
	public List<String> getTheClass(AClass ac){
		init(ac);
		
		List<String> l = new ArrayList<String>();
		l.addAll(createPackageInfo());
		l.addAll(createImportInfo());
		l.addAll(createMainClassInfo());
		
		for(Entry<String, String> ei : rangeMap.entrySet()){
			try {
				List<String> lx = (List<String>)UtilReflect.excuteReflectObject(new Object[]{this,ei.getValue()});
				l.addAll(l.size() - 2,UtilNormal.table(lx));
			} catch (Exception e) {
				System.out.println(String.format("����:%s() δ���óɹ�.", ei.getValue()));
				e.printStackTrace();
			}
		}
		return l;
	}
	
	
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param ac 
	 */
	private void init(AClass ac) {
		qualifiedName = ac.getQualifiedName();
		packageName = UtilString.getStrBeforeLast(qualifiedName, ".");
		name = UtilString.getStrAfterLast(qualifiedName, ".");
		superName = ac.getSuperName();
		
		classAnnotion = ac.getClassAnnotion();
		author = ac.getAuthor();
		
		interfaces = ac.getInterfaces();
		innerClass = ac.getInnerClass();
		variables = ac.getVariables();
	}

	private List<String> createPackageInfo() {
		return alc.createPackageInfo(packageName);
	}
	
	private List<String> createImportInfo() {
		return alc.createImportInfo(variables,CoreCreatorConfig.mustImportMap,CoreCreatorConfig.mustImportMap);
	}
	
	private List<String> createMainClassInfo() {
		return alc.createMainClassInfo(name,superName,interfaces,author,classAnnotion);
	}
	
	private List<String> createVariables() {
		return alc.createVariables(variables);
	}
	
	private List<String> createSetters() {
		return alc.createSetters(variables);
	}
	
	private List<String> createGetters() {
		return alc.createGetters(variables);
	}
	
	private List<String> createInnerClass() {
		return alc.createInnerClass(innerClass);
	}
	
}
