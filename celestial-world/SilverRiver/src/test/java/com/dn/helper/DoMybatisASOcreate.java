package com.dn.helper;

import com.celestial.butterflystorm.butterfly2017.mybatisHelper.DependerContainer;
import com.celestial.butterflystorm.butterfly2017.mybatisHelper.MyBatisHelper;
import com.celestial.butterflystorm.butterfly2017.mybatisHelper.util.Util_ASOReader;

public class DoMybatisASOcreate {
	
	
	public static void main(String[] args) {
		Util_ASOReader.init_annotionMapInfo("src/test/resources/helper/÷–”¢∂‘’’.txt");
		Util_ASOReader.XML_TEMPLATE_FILEPATH = "src/test/resources/helper/MybatisXML_template.xml";
		String[] asoFilesPathes = new String[]{
				"src/test/resources/helper/tableAssociation/equipment.aso",
				"src/test/resources/helper/tableAssociation/strengthen.aso",
				"src/test/resources/helper/tableAssociation/charactor.aso",
				"src/test/resources/helper/tableAssociation/dragonJade.aso",
				
				"src/test/resources/helper/tableAssociation/enchantment.aso",
				"src/test/resources/helper/tableAssociation/mintMark.aso",
				"src/test/resources/helper/tableAssociation/buff.aso"
		};
		
		MyBatisHelper m = new MyBatisHelper()
				.setDaoPath("src/main/java/com/dn/dao/")
				.setXmlPath("src/main/java/com/dn/dao/xml/")
				.setEntityPath("src/main/java/com/dn/entity/")
				.setSqlPath("src/test/resources/helper/sql/");
		
		for(String filePath: asoFilesPathes){
			DependerContainer de = new DependerContainer(filePath);
			m.createAll(de);
		}
		
	}
	
}
