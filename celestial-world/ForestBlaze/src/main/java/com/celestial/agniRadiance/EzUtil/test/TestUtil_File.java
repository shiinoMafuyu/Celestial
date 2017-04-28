package com.celestial.agniRadiance.EzUtil.test;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.celestial.agniRadiance.EzUtil.Util_File;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestUtil_File{
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	@Ignore
	@Test
	public void testFindFile() {
		String fileName = "AutoAuditFirmServlet.java";
		List<String> fileList = Util_File.findFile(fileName, new File("E:/HackingGate/06_2016-10/（南方文交所老）Mgr"));
		String path = "E:\\HackingGate\\06_2016-10\\（南方文交所老）Mgr\\broker-src\\gnnt\\MEBS\\member\\broker\\action\\AutoAuditFirmServlet.java";
		Assert.assertEquals(path, fileList.get(0));
	}
	
	@Ignore
	@Test
	public void testFindFile2() {
		String fileName = ".*\\.java";
		List<String> fileList = Util_File.findFile(fileName, new File("D:/workspace/shjy_mgr/entity-src/gnnt"));
		Assert.assertEquals(19, fileList.size());
	}
	
	@Ignore
	@Test
	public void testFileDirectory(){
		String filePath = "E:/HackingGate/06_2016-10/（南方文交所老）Mgr";
		String regex = ".*src";
		File[] fArr = Util_File.fileDirectory(filePath,regex);
		Assert.assertEquals(14, fArr.length);
	}
	
	@Ignore
	@Test
	public void testFileDocument() {
		String filePath = "E:/HackingGate/06_2016-10/（南方文交所老）Mgr";
		String regex = ".*c.*";
		File[] fArr = Util_File.fileDocument(filePath,regex);
		Assert.assertEquals(3, fArr.length);
	}
	
	@Ignore
	@Test
	public void testFileIntegrated() {
		String filePath = "E:/HackingGate/06_2016-10/（南方文交所老）Mgr";
		String regex = ".*src";
		File[] fArr = Util_File.fileAll(filePath,regex);
		Assert.assertEquals(15, fArr.length);
		
		File[] fArr2 = Util_File.fileAll(filePath);
		Assert.assertEquals(21, fArr2.length);
	}
	
	@Ignore
	@Test
	public void testfindAllFile() {
		//358
		String filePath = "E:/HackingGate/03_2016-08-20_开发一部时的补丁文件/补丁包/testPodCreate/project/issue_front_山东鼎峰/WebRoot";
		List<File> fileList = Util_File.findAllFile(filePath);
		Assert.assertEquals(358, fileList.size());
		
	}
	
	@Ignore
	@Test
	public void testSearchInnerClass(){
		File original = new File("E:/HackingGate/06_2016-10/test/1/BillLineDaoImpl.class");
		String name = original.getName();
		name = name.substring(0, name.lastIndexOf(".class"));
		String pa = original.getParent().replaceAll("\\\\", "/");
		File[] fArr = Util_File.fileDocument(pa, name+"\\$.*\\.class");
		Assert.assertEquals(3, fArr.length);
	}
	
	@Ignore
	@Test
	@SuppressWarnings("unchecked")
	public void testReadPropertiess(){
		Map<String,String> m =Util_File.readProperties("src/com/dragonNest/other/PropertyList.properties");
//		Util_Collection.printMap(m);
		assert(m.size()>=14);
	}
	
	@Test
	public void testDeleteFile(){
		String path2 = "D:/workspace_final/02MyEclipse2013/liquidation/depository-extract-tradedata-m6-issue/src/gnnt/MEBS6/depository/extract/tradedata/issue";
		Util_File.deleteFile(new File(path2));
		System.out.println("删除完成");
	}
	
	
	
	
	
}
