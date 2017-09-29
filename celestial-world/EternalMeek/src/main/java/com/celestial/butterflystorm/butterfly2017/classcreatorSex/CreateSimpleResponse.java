/******************************************************************
 * CreateSimpleResponse.java
 * Copyright 2017 by WZG. All Rights Reserved.
 * CreateDate��2017��6��16��
 * Author��wangzg
 * Version��1.0.0
 ******************************************************************/

package com.celestial.butterflystorm.butterfly2017.classcreatorSex;

import java.util.List;

import com.celestial.agniRadiance.EzUtil.UtilCollection;
import com.celestial.agniRadiance.EzUtil.UtilString;
import com.celestial.agniRadiance.entity.Tag;
import com.celestial.butterflystorm.butterfly2017.ClassCreatorSuperStar.core.IAliceWonderLand;
import com.celestial.butterflystorm.butterfly2017.ClassCreatorSuperStar.core.MoonD.IExquisiteMoon;
import com.celestial.butterflystorm.butterfly2017.ClassCreatorSuperStar.core.MoonD.impl.ExquisiteMoon;
import com.celestial.butterflystorm.butterfly2017.ClassCreatorSuperStar.core.impl.AliceWonderLand;

/**
 * <b>�޸ļ�¼��</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2017��6��16��
 * </li>
 * </p>
 * 
 * <b>��˵����</b>
 * <p> 
 * 
 * </p>
 */
public class CreateSimpleResponse {
	
	
	
	IExquisiteMoon moon = new ExquisiteMoon();
	
	IAliceWonderLand land = new AliceWonderLand();
	
	
	/**
	 * <b>���췽��</b>
	 * <br/>
	 */
	public CreateSimpleResponse(Tag t) {
		Tag res = t.getDirectChildTag("RESULT");
		Tag resList = t.getDirectChildTag("RESULTLIST");
		
		
		System.out.println("----------------------------"+formateName(t.getPropertyMap().get("name"))+"-----------------------------------");
		createVariableAndSetter(res);
		System.out.println("-----------------------------------------\n\n");
		if(null != resList)
			createVariableAndSetter(resList.getDirectChildTag("REC"));
		System.out.println("---------------------------------------------------------------\n\n\n\n");
		
	}

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param str
	 * @return 
	 */
	private String formateName(String str) {
		String[] sArr = str.split("_");
		StringBuffer sb = new StringBuffer();
		for(String si : sArr){
			sb.append(UtilString.transHeadToUpperCase(si));
		}
		sb.append("ResponseVO");
		return sb.toString();
	}

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param ta 
	 */
	private void createVariableAndSetter(Tag ta) {
		if(null == ta)
			return;
		List<Tag> ct = ta.getChildTagList();
		if(null == ct)
			return;
		
		String[][] sArr = moon.parseSimpleTagList(ct);
		UtilCollection.print(land.createVariables(land.transToSetterVariableArr(sArr)));
		System.out.println("\n\n");
		UtilCollection.print(land.createSetters(sArr));
	}
}
