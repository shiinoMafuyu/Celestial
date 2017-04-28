package com.celestial.hydrogenousProminence.fileReplace.test;

import java.util.HashMap;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.celestial.agniRadiance.entity.FileReader;
import com.celestial.hydrogenousProminence.fileReplace.RepDependency;
import com.celestial.hydrogenousProminence.fileReplace.Replace;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestReplace {
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	@SuppressWarnings("serial")
	@Test
	public void _01_replaceList(){
		String commonStart = ".*poem start.*",commonEnd = ".*poem end.*",
				commonPath = "src/main/java/com/celestial/hydrogenousProminence/fileReplace/test/" ;
		RepDependency dep = new RepDependency()
				.setSourceFilePath(commonPath + "ʫ.txt")
				.setRepMap(new HashMap<String,String[]>(){{
					put("rep1",new String[]{"poem1 start-+","poem1 end-+",commonStart,commonEnd,commonPath + "չʾ1.txt"});
					put("rep2",new String[]{"poem2 start-+","poem2 end-+",commonStart,commonEnd,commonPath + "չʾ2.txt"});
				}});
		Replace rep = new Replace(dep,"gbk");
		rep.executeReplace();
		String p1 = dep.getRepMap().get("rep1")[4] , f1 = commonPath + "չʾ1Ԥ��.txt";
		String p2 = dep.getRepMap().get("rep2")[4] , f2 = commonPath + "չʾ2Ԥ��.txt";
		boolean b1 = compareFile(p1,f1);
		boolean b2 = compareFile(p2,f2);
		Assert.assertTrue(b1);
		Assert.assertTrue(b2);
	}

	private boolean compareFile(String path, String forcast) {
		FileReader pf = new FileReader(path);
		FileReader ff = new FileReader(forcast);
		if(ff.getLineList().size() != pf.getLineList().size())
			return false;
		while(ff.hasNext()){
			if(!ff.readLine().equals(pf.readLine()))
				return false;
		}
		return true;
	}
	
}
