/******************************************************************
 * AliceWonderLand.java
 * Copyright 2017 by WZG. All Rights Reserved.
 * CreateDate：2017年6月11日
 * Author：wangzg
 * Version：1.0.0
 ******************************************************************/

package com.celestial.butterflystorm.butterfly2017.ClassCreatorSuperStar.core.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.celestial.agniRadiance.EzUtil.UtilCollection;
import com.celestial.agniRadiance.EzUtil.UtilNormal;
import com.celestial.agniRadiance.EzUtil.UtilString;
import com.celestial.butterflystorm.butterfly2017.ClassCreatorSuperStar.CoreCreatorConfig;
import com.celestial.butterflystorm.butterfly2017.ClassCreatorSuperStar.core.IAliceWonderLand;
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
public class AliceWonderLand implements IAliceWonderLand {

	@Override
	public List<String> createPackageInfo(String packageName) {
		List<String> l = new ArrayList<String>();
		l.add("package" + packageName + ";");
		l.add("");
		return l;
	}

	@Override
	public List<String> createImportInfo(String[][] variables, Map<String, String> variableImportMap, Map<String, String> mustImportMap) {
		List<String> l = new ArrayList<String>();
		for(Entry<String, String> ei : mustImportMap.entrySet()){
			l = UtilCollection.addToList(l,ei.getValue());
		}
		//String[] = [成员变量名，类型，注释、全名]
		for(String sai[] : variables){
			String importSe = UtilCollection.getValue(variableImportMap,sai[1],"");
			l = UtilCollection.addToList(l,importSe);
		}
		return l;
	}

	@Override
	public List<String> createMainClassInfo(String name, String superName, String[] interfaces, String author, String classAnnotion) {
		String extendsInfo = "";
		if(!"".equals(superName))
			extendsInfo = String.format(" extends %s", superName);
		String implementsInfo = "";
		if(interfaces.length > 0){
			implementsInfo = "implements ";
			for(String si : interfaces){
				implementsInfo = implementsInfo + si + " ,";
			}
			implementsInfo = UtilString.subStringLastChar(implementsInfo, ",");
		}
		
		List<String> l = new ArrayList<String>();
		l.add("/**");
		l.add(" * ");
		l.add(" * <b>修改记录：</b> ");
		l.add(" * <p>");
		l.add(" * <li>");
		l.add(" * ");
		l.add(" *                        ---- " + author + "  " + new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		l.add(" * </li>");
		l.add(" * </p>");
		l.add(" * ");
		l.add(" * <b>" + classAnnotion + "</b>");
		l.add(" * <p> ");
		l.add(" * ");
		l.add(" * </p>");
		l.add(" */");
		l.add("public class " + name + " " + extendsInfo + implementsInfo + "{");
		l.add("	");
		l.add("}");
		return l;
	}

	@Override
	public List<String> createVariables(String[][] variables) {
		List<String> l = new ArrayList<String>();
		//String[] = [成员变量名，类型，注释，全名]
		for(String[] sai : variables){
			l.add("/** "+sai[2]+" */");
			l.add("private "+sai[1]+" "+sai[0]+";");
			l.add("");
		}
		return l;
	}

	@Override
	public List<String> createSetters(String[][] variables) {
		List<String> l = new ArrayList<String>();
		//String[] = [成员变量名，类型，注释，全名]
		for(String[] sai : variables){
			String ref = sai[3];
			String var = UtilString.transHeadToLowerCase(ref);
			String type = sai[1];
			String op = CoreCreatorConfig.supportMapResponse.get(type).replace("X", var);
			l.add("/**");
			l.add(" * <b>方法说明：</b>");
			l.add(" * <ul>");
			l.add(" * 设置" + sai[2]);
			l.add(" * </ul>");
			l.add(" * @param " + var +" " + sai[2]);
			l.add(" */");
			l.add("public void set" + UtilString.transHeadToUpperCase(ref) + "(" + type + " " + var + ") {");
			l.add("	" + sai[0]+" = " + op);
			l.add("}");
			l.add("");
		}
		return l;
	}

	@Override
	public List<String> createGetters(String[][] variables) {
		
		List<String> l = new ArrayList<String>();
		//String[] = [成员变量名，类型，注释，全名]
		for(String[] sai : variables){
			l.add("/**");
			l.add(" * <b>方法说明：</b>");
			l.add(" * <ul>");
			l.add(" * 获取" + sai[2] + "");
			l.add(" * </ul>");
			l.add(" * @return " + sai[2]);
			l.add(" */");
			String type = sai[1];
			l.add("public "+ type + " get"+UtilString.transHeadToUpperCase(sai[3]) + "(){");
			l.add("	return " + CoreCreatorConfig.supportMap.get(type).replace("X", sai[0]));
			l.add("}");
			l.add("");
		}
		
		return l;
	}

	@Override
	public List<String> createInnerClass(AClass[] innerClass) {
		List<String> l = new ArrayList<String>();
		for(AClass ac : innerClass){
			l.addAll(createOneInnerClass(ac));
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
	private List<String>  createOneInnerClass(AClass ac) {
		List<String> l = new ArrayList<String>();
//		String packageName = Util_String.getStrBeforeLast(qualifiedName, ".");
		String name = ac.getQualifiedName();
		String superName = ac.getSuperName();
		
		String classAnnotion = ac.getClassAnnotion();
		String author = ac.getAuthor();
		
		String[] interfaces = ac.getInterfaces();
		String[][] variables = ac.getVariables();
		l.addAll(createMainClassInfo(name,superName,interfaces,author,classAnnotion));
		l.addAll(l.size()-2,UtilNormal.table(createVariables(variables)));
		l.addAll(l.size()-2,UtilNormal.table(createSetters(variables)));
		l.addAll(l.size()-2,UtilNormal.table(createGetters(variables)));
		return l;
	}

	@Override
	public String[][] transToSetterVariableArr(String[][] sArr) {
		String[][] reArr = new String[sArr.length][];
		
		for(int i = 0 ; i < sArr.length ;i++){
			String[] siArr = sArr[i];
			String[] tempArr = new String[siArr.length];
			for(int j =0 ;j < siArr.length; j++){
				if(1 == j)
					tempArr[j] = "String";
				else
					tempArr[j] = siArr[j];
			}
			reArr[i] = tempArr;
		}
		return reArr;
	}
	
}
