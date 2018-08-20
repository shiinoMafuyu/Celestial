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

import com.celestial.agniRadiance.EzUtil.UtilString;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestUtilString {
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	@Test
	public void _01_subStringLast(){
		String s = "heitagi,";
		Assert.assertEquals(UtilString.subStringLast(s, 1), "heitagi");
	}
	
	@Test
	public void _02_subStringLastChar(){
		String s = "heitagi,,";
		Assert.assertEquals(UtilString.subStringLastChar(s, ",,"), "heitagi");
		
		String s2 = "heita,gi";
		Assert.assertEquals(UtilString.subStringLastChar(s2, ","), "heita,gi");
	}
	
	@Test
	public void _03_readLineParam(){
		String s = "className(com.dn.entity.Equipment)";
		Assert.assertEquals(UtilString.getLineParam(s, "className"), "com.dn.entity.Equipment");
		
	}
	
	@Test
	public void _04_isCollectionType(){
		Assert.assertEquals(UtilString.isCollectionType("List"), "List");
		Assert.assertEquals(UtilString.isCollectionType("List<String>"), "List");
		Assert.assertEquals(UtilString.isCollectionType("List<String_Joker>"), "List");
		Assert.assertEquals(UtilString.isCollectionType("String"), "");
		Assert.assertEquals(UtilString.isCollectionType("Map<String,Object>"), "Map");
		
		
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
		
		List<String> l_1 = UtilString.subStringLastChar(l,",");
		Assert.assertEquals(l2, l_1);
		
	}
	
	
	
	@Test
	public void _05getStrAfterLast(){
		String s = "ez.EzUtil.test.TestUtil_String";
		String res = UtilString.getStrAfterLast(s, ".");
		Assert.assertEquals("TestUtil_String",res);
		
	}
	
	@Test
	public void _06getStrAfterLast(){
		String s = "src/test/resources/helper/tableAssociation/strengthen.aso";
		String res = UtilString.getStrBeforeLast(s, "/");
		Assert.assertEquals("src/test/resources/helper/tableAssociation",res);
		
		String s2 = "gnnt.MEBS6.react.frontend.trade.vo.TradeQueryResponseVO";
		System.out.println(s2.lastIndexOf("."));
		String res2 = UtilString.getStrBeforeLast(s2, ".");
		Assert.assertEquals("gnnt.MEBS6.react.frontend.trade.vo",res2);
	}
	
	@Test
	public void _07__fmtPathStr(){
		String s = new File("src\\test").getAbsolutePath();
		s = UtilString.fmtPathStr(s);
		Assert.assertFalse(s.contains("\\"));
		
	}
	
	@Test
	public void _08_getMatchIn(){
		String s = UtilString.getMatchIn("name = 'kurise',name = 'miki'; yesterday once more.","'",";",20);
		String ex = "miki'";
		Assert.assertEquals(ex, s);
		
		s = "<classpathentry kind=\"src\" path=\"src/account-src\"/>";
		s = UtilString.getMatchIn(s,"\"","\"",s.indexOf("path="));
		ex = "src/account-src";
		Assert.assertEquals(ex, s);
		
	}
	
	@Test
	public void _08__transHead(){
		
		Assert.assertEquals("Mafuyu", UtilString.transHeadToUpperCase("mafuyu"));
		Assert.assertEquals("A", UtilString.transHeadToUpperCase("a"));
		Assert.assertEquals("", UtilString.transHeadToUpperCase(""));
		
	}
	
	@Test
	public void _09__transHead(){
		Assert.assertEquals(":",UtilString.getMinMatch("yuki:{age:17,height:165,home:{jp:'神奈川',us:'losAnges'}}",0,"{","}",":"));
		Assert.assertEquals("{",UtilString.getMinMatch("yuki:{age:17,height:165,home:{jp:'神奈川',us:'losAnges'}}",0,"{","}","ho"));
		Assert.assertEquals("los",UtilString.getMinMatch("yuki:{age:17,height:165,home:{jp:'神奈川',us:'losAnges'}}",0,"{{","}}","los"));
		Assert.assertEquals("}}",UtilString.getMinMatch("yuki:{age:17,height:165,home:{jp:'神奈川',us:'losAnges'}}",0,"{{","}}","losa"));
		
	}
	
	@Test
	public void _10_getMatchIn2(){
		Assert.assertEquals(" 4* 2 - 3/ (3+1)",UtilString.getMatchIn2("0123+(5 * 6 - ( 4* 2 - 3/ (3+1)) + 3 /( 3 * 1))","(",")",6));
		Assert.assertEquals("5 * 6 - ( 4* 2 - 3/ (3+1)) + 3 /( 3 * 1)",UtilString.getMatchIn2("0123+(5 * 6 - ( 4* 2 - 3/ (3+1)) + 3 /( 3 * 1))","(",")",0));
		Assert.assertEquals(" 3 * 1",UtilString.getMatchIn2("0123+(5 * 6 - ( 4* 2 - 3/ (3+1)) + 3 /( 3 * 1))","(",")",33));
		
	}
	
	@Test
	public void _11___equal(){
		Assert.assertTrue(UtilString.equal(null, null));
		Assert.assertFalse(UtilString.equal(null, "a"));
		Assert.assertFalse(UtilString.equal("a", null));
	}
	
	
}
