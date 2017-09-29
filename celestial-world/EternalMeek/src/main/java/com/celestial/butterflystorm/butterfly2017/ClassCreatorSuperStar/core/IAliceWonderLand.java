/******************************************************************
 * IAliceWonderLand.java
 * Copyright 2017 by WZG. All Rights Reserved.
 * CreateDate��2017��6��11��
 * Author��wangzg
 * Version��1.0.0
 ******************************************************************/

package com.celestial.butterflystorm.butterfly2017.ClassCreatorSuperStar.core;

import java.util.List;
import java.util.Map;

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
public interface IAliceWonderLand {

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param packageName
	 * @return 
	 */
	List<String> createPackageInfo(String packageName);

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param variables
	 * @param variableImportMap
	 * @param mustImportMap
	 * @return 
	 */
	List<String> createImportInfo(String[][] variables, Map<String, String> variableImportMap, Map<String, String> mustImportMap);

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param name
	 * @param superName
	 * @param interfaces
	 * @param author
	 * @param classAnnotion
	 * @return 
	 */
	List<String> createMainClassInfo(String name, String superName, String[] interfaces, String author, String classAnnotion);

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param variables
	 * @return 
	 */
	List<String> createVariables(String[][] variables);

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param variables
	 * @return 
	 */
	List<String> createSetters(String[][] variables);

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param variables
	 * @return 
	 */
	List<String> createGetters(String[][] variables);

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param innerClass
	 * @return 
	 */
	List<String> createInnerClass(AClass[] innerClass);

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param sArr
	 * @return 
	 */
	String[][] transToSetterVariableArr(String[][] sArr);
	
}
