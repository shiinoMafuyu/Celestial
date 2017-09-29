/******************************************************************
 * SeriesArea.java
 * Copyright 2017 by WZG. All Rights Reserved.
 * CreateDate��2017��7��3��
 * Author��wangzg
 * Version��1.0.0
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
 * <b>�޸ļ�¼��</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2017��7��3��
 * </li>
 * </p>
 * 
 * <b>��˵����</b>
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
	 * <b>����˵����</b>
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
			//String[] = [��Ա�����������ͣ�ע�ͣ�ȫ��]
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
