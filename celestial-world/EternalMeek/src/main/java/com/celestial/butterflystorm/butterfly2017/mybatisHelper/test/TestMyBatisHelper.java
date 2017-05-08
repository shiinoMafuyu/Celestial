package com.celestial.butterflystorm.butterfly2017.mybatisHelper.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.celestial.butterflystorm.butterfly2017.mybatisHelper.DependerContainer;
import com.celestial.butterflystorm.butterfly2017.mybatisHelper.MyBatisHelper;
import com.celestial.butterflystorm.butterfly2017.mybatisHelper.util.Util_ASOReader;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestMyBatisHelper {
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	@Test
	public void _01_MyBatisHelper_normal(){
		Util_ASOReader.init_annotionMapInfo("src/main/java/com/celestial/butterflystorm/butterfly2017/mybatisHelper/test/srcFile/中英对照.txt");
		Util_ASOReader.XML_TEMPLATE_FILEPATH = "src/main/java/com/celestial/butterflystorm/butterfly2017/mybatisHelper/test/srcFile/MybatisXML_template.xml";
		
		String[] asoFilesPathes = new String[]{
				"src/main/java/com/celestial/butterflystorm/butterfly2017/mybatisHelper/test/srcFile/normal/equipment.aso",
				"src/main/java/com/celestial/butterflystorm/butterfly2017/mybatisHelper/test/srcFile/normal/strengthen.aso",
				"src/main/java/com/celestial/butterflystorm/butterfly2017/mybatisHelper/test/srcFile/normal/charactor.aso",
				"src/main/java/com/celestial/butterflystorm/butterfly2017/mybatisHelper/test/srcFile/normal/dragonJade.aso",
				
				"src/main/java/com/celestial/butterflystorm/butterfly2017/mybatisHelper/test/srcFile/normal/enchantment.aso",
				"src/main/java/com/celestial/butterflystorm/butterfly2017/mybatisHelper/test/srcFile/normal/mintMark.aso",
				"src/main/java/com/celestial/butterflystorm/butterfly2017/mybatisHelper/test/srcFile/normal/buff.aso"
		};
		
		MyBatisHelper m = new MyBatisHelper()
				.setDaoPath("src/main/java/com/celestial/butterflystorm/butterfly2017/mybatisHelper/test/result/normal/dao/")
				.setXmlPath("src/main/java/com/celestial/butterflystorm/butterfly2017/mybatisHelper/test/result/normal/xml/")
				.setEntityPath("src/main/java/com/celestial/butterflystorm/butterfly2017/mybatisHelper/test/result/normal/entity/")
				.setSqlPath("src/main/java/com/celestial/butterflystorm/butterfly2017/mybatisHelper/test/result/normal/sql/");
		
		for(String filePath: asoFilesPathes){
			DependerContainer de = new DependerContainer(filePath);
			m.createAll(de);
		}
		
	}
	
	@Test
	public void _02_MyBatisHelper_recursive(){
		Util_ASOReader.init_annotionMapInfo("src/main/java/com/celestial/butterflystorm/butterfly2017/mybatisHelper/test/srcFile/中英对照.txt");
		Util_ASOReader.XML_TEMPLATE_FILEPATH = "src/main/java/com/celestial/butterflystorm/butterfly2017/mybatisHelper/test/srcFile/MybatisXML_template.xml";
		
		String[] asoFilesPathes = new String[]{
				"src/main/java/com/celestial/butterflystorm/butterfly2017/mybatisHelper/test/srcFile/recursive/charactor.aso",
				"src/main/java/com/celestial/butterflystorm/butterfly2017/mybatisHelper/test/srcFile/recursive/equipment.aso",
				"src/main/java/com/celestial/butterflystorm/butterfly2017/mybatisHelper/test/srcFile/recursive/strengthen.aso"
		};
				
		MyBatisHelper m = new MyBatisHelper()
				.setDaoPath(	"src/main/java/com/celestial/butterflystorm/butterfly2017/mybatisHelper/test/result/recursive/dao/")
				.setXmlPath(	"src/main/java/com/celestial/butterflystorm/butterfly2017/mybatisHelper/test/result/recursive/xml/")
				.setEntityPath(	"src/main/java/com/celestial/butterflystorm/butterfly2017/mybatisHelper/test/result/recursive/entity/")
				.setSqlPath(	"src/main/java/com/celestial/butterflystorm/butterfly2017/mybatisHelper/test/result/recursive/sql/");
		
		for(String filePath: asoFilesPathes){
			DependerContainer de = new DependerContainer(filePath);
			m.createAll(de);
		}
		
	}
	
	
}
