/******************************************************************
 * ExquisiteMoon.java
 * Copyright 2017 by WZG. All Rights Reserved.
 * CreateDate��2017��6��16��
 * Author��wangzg
 * Version��1.0.0
 ******************************************************************/

package com.celestial.butterflystorm.butterfly2017.ClassCreatorSuperStar.core.MoonD.impl;

import java.util.List;

import com.celestial.agniRadiance.EzUtil.UtilString;
import com.celestial.agniRadiance.entity.Tag;
import com.celestial.butterflystorm.butterfly2017.ClassCreatorSuperStar.core.MoonD.IExquisiteMoon;

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
public class ExquisiteMoon implements IExquisiteMoon {

	@Override
	public String[][] parseSimpleTagList(List<Tag> tagList) {
		String[][] sArr = new String[tagList.size()][];
		Tag ti = null;
		for(int i =0;i < tagList.size();i++){
			ti = tagList.get(i);
			//String[] = [��Ա�����������ͣ�ע�͡�ȫ��]
			String[] isArr = new String[]{
					ti.getTagName(),
					ti.getPropertyMap().get("type"),
					ti.getValue(),
					ti.getPropertyMap().get("ref")
			};
			if(!check(isArr)){
				throw new RuntimeException("��ǩ���Բ�ȫ������" + ti);
			}
			sArr[i] = isArr;
		}
		
		return sArr;
	}

	/**
	 * <b>����˵����</b>
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
