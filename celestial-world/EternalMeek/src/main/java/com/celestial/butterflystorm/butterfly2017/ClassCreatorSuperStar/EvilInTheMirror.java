/******************************************************************
 * EvilInTheMirror.java
 * Copyright 2017 by WZG. All Rights Reserved.
 * CreateDate��2017��6��11��
 * Author��wangzg
 * Version��1.0.0
 ******************************************************************/

package com.celestial.butterflystorm.butterfly2017.ClassCreatorSuperStar;

import com.celestial.agniRadiance.entity.Tag;
import com.celestial.butterflystorm.butterfly2017.ClassCreatorSuperStar.core.IEternalScarlletNewMoon;
import com.celestial.butterflystorm.butterfly2017.ClassCreatorSuperStar.core.impl.EternalScarlletNewMoon;
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
public class EvilInTheMirror {
	public static void main(String[] args) {
		Tag t = null;
		IEternalScarlletNewMoon esn = new  EternalScarlletNewMoon();
		AClass ac = esn.recursiveParse(t);
	}
}
