/******************************************************************
 * SeriesArea.java
 * Copyright 2017 by WZG. All Rights Reserved.
 * CreateDate：2017年7月3日
 * Author：wangzg
 * Version：1.0.0
 ******************************************************************/

package com.celestial.butterflystorm.butterfly2017.ClassCreatorSuperStar;

import java.util.ArrayList;
import java.util.List;

import com.celestial.agniRadiance.EzUtil.UtilCollection;
import com.celestial.agniRadiance.EzUtil.UtilFile;
import com.celestial.agniRadiance.entity.FileReader;
import com.celestial.butterflystorm.butterfly2017.ClassCreatorSuperStar.core.IAliceWonderLand;
import com.celestial.butterflystorm.butterfly2017.ClassCreatorSuperStar.core.impl.AliceWonderLandNormal;

/**
 * <b>修改记录：</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2017年7月3日
 * </li>
 * </p>
 * 
 * <b>类说明：</b>
 * <p> 
 * 
 * </p>
 */
public class SeriesArea {
	
	static IAliceWonderLand aliceWonderLand = new AliceWonderLandNormal();
	public static void main(String[] args) {
		
		createGettersAndSetters();
		
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 
	 * </ul> 
	 */
	private static void createGettersAndSetters() {
		String[][] sArr = parese();
		List<String> list = new ArrayList<>();
		list.addAll(aliceWonderLand.createSetters(sArr));
		list.addAll(aliceWonderLand.createGetters(sArr));
		UtilCollection.print(list);
	}

	public static String[][] parese(){
		List<String[]> list = new ArrayList<>();
		FileReader f = new FileReader(UtilFile.load("02tempUse.txt"),true,"gbk");
		
		while(f.hasNext()){
			//String[] = [成员变量名，类型，注释，全名]
			String si = f.readLine();
			if(si == null || "".equals(si) || (si != null && si.indexOf(";") < 0))
				continue;
			String ano = f.readBeforeLine1(2).replaceAll("/", "").replaceAll("\\*", "").replaceAll(" ", "");
			String[] ssAr = si.replace(";", "").split(" ");
			String[] stArr = new String[]{ssAr[2],ssAr[1],ano,ssAr[2]};
			list.add(stArr);
		}
		
		return list.toArray(new String[][]{});
		
	}
}
