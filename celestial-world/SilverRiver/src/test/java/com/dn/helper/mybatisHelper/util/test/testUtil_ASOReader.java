package com.dn.helper.mybatisHelper.util.test;


import java.util.Arrays;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.celestial.agniRadiance.EzUtil.Util_File;
import com.celestial.agniRadiance.entity.FileReader;
import com.dn.helper.mybatisHelper.creator.XMLcreator;
import com.dn.helper.mybatisHelper.depender.XMLdepender;
import com.dn.helper.mybatisHelper.util.Util_ASOReader;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class testUtil_ASOReader {
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	
	@Test
	public void _01_createRefInfo(){
		FileReader f = Util_ASOReader.readASONoAnnotion("src/test/resources/helper/tableAssociation/equipment.aso");
		List<String[]> joinOnArr = Util_ASOReader.createRefInfo(f);
		Assert.assertEquals(1,joinOnArr.size());
		
	}
	
	@Ignore
	@Test
	public void _02_createXMLdepernder_testFile(){
		XMLdepender xmlDepender = Util_ASOReader.createXMLdepernder("src/test/resources/helper/tableAssociation/aso_test/equipment.aso");
		XMLcreator xmlCreattor = new XMLcreator(xmlDepender);
		System.out.println(xmlCreattor.getThisClass());
		Assert.assertEquals(xmlDepender.getxMLdependerMap().size(),1);
	}
	
	@Test
	public void _03_createXMLdepernder(){
		String asoOutPut ="src/test/resources/helper/tableAssociation/aso_test/aso_test_output/";
		
		XMLdepender xmlDepender = Util_ASOReader.createXMLdepernder("src/test/resources/helper/tableAssociation/equipment.aso");
		XMLcreator xmlCreattor = new XMLcreator(xmlDepender);
		System.out.println(xmlCreattor.getThisClass());
		Util_File.printFile(Arrays.asList(new String[]{xmlCreattor.getThisClass()}), asoOutPut+"/equipment.xml");
		Assert.assertEquals(xmlDepender.getxMLdependerMap().size(),1);
	}
	
	
}
