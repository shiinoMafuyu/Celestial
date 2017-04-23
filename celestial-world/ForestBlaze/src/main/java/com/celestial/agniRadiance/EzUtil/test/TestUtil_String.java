package com.celestial.agniRadiance.EzUtil.test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.celestial.agniRadiance.EzUtil.Util_String;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestUtil_String {
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	@Test
	public void _01_subStringLast(){
		String s = "heitagi,";
		Assert.assertEquals(Util_String.subStringLast(s, 1), "heitagi");
	}
	
	@Test
	public void _02_subStringLastChar(){
		String s = "heitagi,,";
		Assert.assertEquals(Util_String.subStringLastChar(s, ",,"), "heitagi");
		
		String s2 = "heita,gi";
		Assert.assertEquals(Util_String.subStringLastChar(s2, ","), "heita,gi");
	}
	
	@Test
	public void _03_readLineParam(){
		String s = "className(com.dn.entity.Equipment)";
		Assert.assertEquals(Util_String.getLineParam(s, "className"), "com.dn.entity.Equipment");
		
	}
	
	@Test
	public void _04___isCollectionType(){
		Assert.assertEquals(Util_String.__isCollectionType("List"), "List");
		Assert.assertEquals(Util_String.__isCollectionType("List<String>"), "List");
		Assert.assertEquals(Util_String.__isCollectionType("List<String_Joker>"), "List");
		Assert.assertEquals(Util_String.__isCollectionType("String"), "");
		Assert.assertEquals(Util_String.__isCollectionType("Map<String,Object>"), "Map");
		
		
	}
	
	
	@Test
	public void _05_subStringLastChar(){
		List<String> l = new ArrayList<String>();
		l.add("1,");
		l.add("2,");
		l.add("3,");
		l.add("4,");
		l.add("	 ");
		
		List<String> l2 = new ArrayList<String>();
		l2.add("1,");
		l2.add("2,");
		l2.add("3,");
		l2.add("4");
		l2.add("	 ");
		
		List<String> l_1 = Util_String.subStringLastChar(l,",");
		Assert.assertEquals(l2, l_1);
		
	}
	
	
	
	@Test
	public void _05__getStrAfterLast(){
		String s = "ez.EzUtil.test.TestUtil_String";
		String res = Util_String.__getStrAfterLast(s, ".");
		Assert.assertEquals("TestUtil_String",res);
		
	}
	
	@Test
	public void _06__getStrAfterLast(){
		String s = "src/test/resources/helper/tableAssociation/strengthen.aso";
		String res = Util_String.__getStrBeforeLast(s, "/");
		Assert.assertEquals("src/test/resources/helper/tableAssociation",res);
		
	}
	
	@Test
	public void _07__fmtPathStr(){
		String s = new File("src\\test").getAbsolutePath();
		s = Util_String.fmtPathStr(s);
		Assert.assertFalse(s.contains("\\"));
		
	}
}
