/******************************************************************
 * CoreCreator.java
 * Copyright 2017 by WZG. All Rights Reserved.
 * CreateDate：2017年6月11日
 * Author：wangzg
 * Version：1.0.0
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
 * <b>修改记录：</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2017年6月11日
 * </li>
 * </p>
 * 
 * <b>类说明：</b>
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
	
	private String classAnnotion = "西方世界，近代历史，为止的云。";
	private String author = "wangzg";
	
	private String[] interfaces;
	private AClass[] innerClass;
	private String[][] variables;//String[] = [成员变量名，类型，注释、全名]
	
	IAliceWonderLand alc = new AliceWonderLand();
	
	/**
	 * <b>构造方法</b>
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
				System.out.println(String.format("方法:%s() 未调用成功.", ei.getValue()));
				e.printStackTrace();
			}
		}
		return l;
	}
	
	
	/**
	 * <b>方法说明：</b>
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
