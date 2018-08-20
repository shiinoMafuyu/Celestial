/******************************************************************
 * ExquisiteMoon.java
 * Copyright 2017 by WZG. All Rights Reserved.
 * CreateDate：2017年6月16日
 * Author：wangzg
 * Version：1.0.0
 ******************************************************************/

package com.celestial.butterflystorm.butterfly2017.ClassCreatorSuperStar.core.MoonD.impl;

import java.util.List;

import com.celestial.agniRadiance.EzUtil.UtilString;
import com.celestial.agniRadiance.entity.Tag;
import com.celestial.butterflystorm.butterfly2017.ClassCreatorSuperStar.core.MoonD.IExquisiteMoon;

/**
 * <b>修改记录：</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2017年6月16日
 * </li>
 * </p>
 * 
 * <b>类说明：</b>
 * <p> 
 * 
 * </p>
 */
public class ExquisiteMoon implements IExquisiteMoon {

	@Override
	public String[][] parseSimpleTagList(List<Tag> tagList) {
		String[][] sArr = new String[tagList.size()][];
		Tag ti = null;
		for(int i =0;i < tagList.size();i++){
			ti = tagList.get(i);
			//String[] = [成员变量名，类型，注释、全名]
			String[] isArr = new String[]{
					ti.getTagName(),
					ti.getPropertyMap().get("type"),
					ti.getValue(),
					ti.getPropertyMap().get("ref")
			};
			if(!check(isArr)){
				throw new RuntimeException("标签属性不全，请检查" + ti);
			}
			sArr[i] = isArr;
		}
		
		return sArr;
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param isArr 
	 */
	private boolean check(String[] sArr) {
		for(String si :sArr){
			if(!UtilString.notNullEmpty(si))
				return false;
		}
		return true;
		
	}

}
