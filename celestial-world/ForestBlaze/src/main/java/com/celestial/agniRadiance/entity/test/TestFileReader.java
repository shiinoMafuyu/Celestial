package com.celestial.agniRadiance.entity.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.celestial.agniRadiance.EzUtil.Util_Collection;
import com.celestial.agniRadiance.entity.FileReader;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SuppressWarnings("unchecked")
public class TestFileReader {
	
	public static List<String> l0 = new ArrayList<String>();
	public static List<String> l = new ArrayList<String>();
	public static FileReader f = null;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		l0.add("1");
		l0.add("2");
		l0.add("3");
		l0.add("4");
		l0.add("5");
		
		l = Util_Collection.deepCopyList(l0);
		
		l.add(1,"qaq--ÕôµÄ£¡£¡");
		l.add(4,"--ÕôµÄ£¡£¡");
		f = new FileReader(l);
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	
	
	@Test
	public void _01_selectLineExcludeRegex(){
		FileReader f2 = f.selectLineExcludeRegex(".*--.*");
		List<String> lf2 = f2.getLineList();
		for(int i=0;i<l0.size();i++){
			Assert.assertEquals(lf2.get(i), l0.get(i));
		}
	}
	
}
