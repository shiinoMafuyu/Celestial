/******************************************************************
 * EvilInTheMirror.java
 * Copyright 2017 by WZG. All Rights Reserved.
 * CreateDate：2017年6月11日
 * Author：wangzg
 * Version：1.0.0
 ******************************************************************/

package com.celestial.butterflystorm.butterfly2017.ClassCreatorSuperStar;

import com.celestial.agniRadiance.entity.Tag;
import com.celestial.butterflystorm.butterfly2017.ClassCreatorSuperStar.core.IEternalScarlletNewMoon;
import com.celestial.butterflystorm.butterfly2017.ClassCreatorSuperStar.core.impl.EternalScarlletNewMoon;
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
public class EvilInTheMirror {
	public static void main(String[] args) {
		Tag t = null;
		IEternalScarlletNewMoon esn = new  EternalScarlletNewMoon();
		AClass ac = esn.recursiveParse(t);
	}
}
