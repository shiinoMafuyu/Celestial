package com.celestial.hydrogenousProminence.fileReplace.test;

import java.util.HashMap;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.celestial.agniRadiance.EzUtil.UtilFile;
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
		final String commonStart = ".*poem start.*" ;
		final String commonEnd = ".*poem end.*";
		final String commonPath = "src/test/java/com/celestial/hydrogenousProminence/fileReplace/test/";
		RepDependency dep = new RepDependency()
				.setSourceFilePath(commonPath + "诗.txt")
				.setRepMap(new HashMap<String,String[]>(){{
					put("rep1",new String[]{"poem1 start-+","poem1 end-+",commonStart,commonEnd,commonPath + "展示1.txt"});
					put("rep2",new String[]{"poem2 start-+","poem2 end-+",commonStart,commonEnd,commonPath + "展示2.txt"});
				}});
		Replace rep = new Replace(dep,"gbk");
		rep.executeReplace();
		String p1 = dep.getRepMap().get("rep1")[4] , f1 = commonPath + "展示1预期.txt";
		String p2 = dep.getRepMap().get("rep2")[4] , f2 = commonPath + "展示2预期.txt";
		boolean b1 = UtilFile.compareFileContent(p1,f1);
		boolean b2 = UtilFile.compareFileContent(p2,f2);
		Assert.assertTrue(b1);
		Assert.assertTrue(b2);
	}

	
}
