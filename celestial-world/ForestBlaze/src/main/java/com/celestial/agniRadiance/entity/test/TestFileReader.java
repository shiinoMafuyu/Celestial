package com.celestial.agniRadiance.entity.test;

import java.util.ArrayList;
import java.util.Arrays;
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
		
		l.add(1,"qaq--蒸的！！");
		l.add(4,"--蒸的！！");
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
	
	@Test
	public void _02_printAll(){
		FileReader f2 = new FileReader(f.getLineList());
		f2.printAll();
		Assert.assertEquals(f2.getIndex(), 0);
	}
	
	@Test
	public void _03_replaceList(){
		FileReader f2 = new FileReader(f.getLineList());
		FileReader fend = f2.replaceList(0, 1, Arrays.asList(new String[]{"如花美眷","似水流年","空渡年华","暮影消沉"}));
		Assert.assertEquals(fend.readLine(1), "如花美眷");
		Assert.assertEquals(fend.readLine(2), "似水流年");
		Assert.assertEquals(fend.readLine(3), "空渡年华");
		Assert.assertEquals(fend.readLine(4), "暮影消沉");
	}
	
	
	
}
