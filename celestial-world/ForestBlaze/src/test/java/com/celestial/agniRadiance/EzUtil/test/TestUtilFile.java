package com.celestial.agniRadiance.EzUtil.test;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.celestial.agniRadiance.EzUtil.UtilDate;
import com.celestial.agniRadiance.EzUtil.UtilFile;
import com.celestial.agniRadiance.entity.FileReader;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestUtilFile{
	
	static String tp = "src/test/java/com/celestial/agniRadiance/EzUtil/test/file";
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	@Ignore
	@Test
	public void _01_FindFile() {
		String fileName = "AutoAuditFirmServlet.java";
		List<String> fileList = UtilFile.findFile(fileName, new File("E:/HackingGate/06_2016-10/（南方文交所老）Mgr"));
		String path = "E:\\HackingGate\\06_2016-10\\（南方文交所老）Mgr\\broker-src\\gnnt\\MEBS\\member\\broker\\action\\AutoAuditFirmServlet.java";
		Assert.assertEquals(path, fileList.get(0));
	}
	
	@Ignore
	@Test
	public void _02_FindFile2() {
		String fileName = ".*\\.java";
		List<String> fileList = UtilFile.findFile(fileName, new File("D:/workspace/shjy_mgr/entity-src/gnnt"));
		Assert.assertEquals(19, fileList.size());
	}
	
	@Test
	public void _03_FileDirectory(){
		String filePath = "src/test/java/com/celestial/agniRadiance/EzUtil/test/file";
		String regex = ".*file.*";
		File[] fArr = UtilFile.fileDirectory(filePath,regex);
		Assert.assertEquals(3, fArr.length);
	}
	
	@Test
	public void _0301_FileDirectory(){
		String filePath = "src/test/java/com/celestial/agniRadiance/EzUtil/test/file";
		String regex = ".*";
		File[] fArr = UtilFile.fileDirectory(filePath,regex);
		Assert.assertEquals(4, fArr.length);
	}
	
	@Ignore
	@Test
	public void _04_FileDocument() {
		String filePath = "E:/HackingGate/06_2016-10/（南方文交所老）Mgr";
		String regex = ".*c.*";
		File[] fArr = UtilFile.fileDocument(filePath,regex);
		Assert.assertEquals(3, fArr.length);
	}
	
	@Ignore
	@Test
	public void _05_FileIntegrated() {
		String filePath = "E:/HackingGate/06_2016-10/（南方文交所老）Mgr";
		String regex = ".*src";
		File[] fArr = UtilFile.fileAll(filePath,regex);
		Assert.assertEquals(15, fArr.length);
		
		File[] fArr2 = UtilFile.fileAll(filePath);
		Assert.assertEquals(21, fArr2.length);
	}
	
	@Ignore
	@Test
	public void _06_findAllFile() {
		//358
		String filePath = "E:/HackingGate/03_2016-08-20_开发一部时的补丁文件/补丁包/testPodCreate/project/issue_front_山东鼎峰/WebRoot";
		List<File> fileList = UtilFile.findAllFile(filePath);
		Assert.assertEquals(358, fileList.size());
		
	}
	
	@Ignore
	@Test
	public void _07_tSearchInnerClass(){
		File original = new File("E:/HackingGate/06_2016-10/test/1/BillLineDaoImpl.class");
		String name = original.getName();
		name = name.substring(0, name.lastIndexOf(".class"));
		String pa = original.getParent().replaceAll("\\\\", "/");
		File[] fArr = UtilFile.fileDocument(pa, name+"\\$.*\\.class");
		Assert.assertEquals(3, fArr.length);
	}
	
	@Ignore
	@Test
	public void _08_ReadPropertiess(){
		Map<String,String> m =UtilFile.readProperties("src/com/dragonNest/other/PropertyList.properties");
//		Util_Collection.printMap(m);
		assert(m.size()>=14);
	}
	
	@Ignore
	@Test
	public void _09_DeleteFile(){
		String path2 = "D:/workspace_final/02MyEclipse2013/liquidation/depository-extract-tradedata-m6-issue/src/gnnt/MEBS6/depository/extract/tradedata/issue";
		UtilFile.deleteFile(new File(path2));
		System.out.println("删除完成");
	}
	
	@Test
	public void _10_getCreateTime(){
		String f1Path = (tp+"/月神.txt");
		String abPath = new File(f1Path).getAbsolutePath();
		Date d = UtilFile.getCreateTime(abPath);
		Assert.assertNotNull(d);
	}
	
	@Test
	public void _10_getModifiedTime() throws Exception{
		String f1Path = (tp+"/月神.txt");
		Date d = UtilFile.getModifiedTime(new File(f1Path));
		Assert.assertNotNull(UtilDate.inTime(d, new Date[]{new Date()}));
	}
	
	@Test
	public void _1001_compareModifiedTime(){
		File f1 = new File(tp+"/file.txt");
		File f2 = new File(tp+"/file2.txt");
		boolean b = UtilFile.compareModifiedTime(f1,f2);
		Assert.assertTrue(b);
	}
	
	@Test
	public void _11_compareAndRenew(){
		
		File file = new File(tp+"/file.txt");//旧
		File file2 = new File(tp+"/file2.txt");//中
		File yue = new File(tp+"/月神.txt");//新
		
		
		File file2_t = new File(tp+"/file2_t.txt");//中
		
		
		UtilFile.compareAndRenew(file2, file2_t);
		boolean isTrue = UtilFile.compareFileContent(file2, file2_t);
		Assert.assertTrue(isTrue);
		
		UtilFile.compareAndRenew(yue,file2_t);
		isTrue = UtilFile.compareFileContent(yue, file2_t);
		Assert.assertTrue(isTrue);
		
		UtilFile.compareAndRenew(file,file2_t);
		boolean isFalse = UtilFile.compareFileContent(file, file2_t);
		file2_t.delete();
		Assert.assertFalse(isFalse);
		
		
		
	}
	
	@Test
	public void _12_copyByCmd(){
		File f1 = new File(tp+"/月神.txt");
		File f2 = new File(tp+"/月神2.txt");
		UtilFile.copyByCmd(f1, f2);
		boolean b = UtilFile.compareFileContent(f1, f2);
		f2.delete();
		Assert.assertTrue(b);
		
	}
	
	@Test
	public void _13_getUnRepeatName(){
		File f = new File(tp+"/01file/01f/ne.txt");
		FileReader fr = new FileReader(f);
		System.out.println(fr.readLine());
		File fe = UtilFile.getUnRepeatName(f);
		Assert.assertEquals("3-ne.txt",fe.getName());
		
	}
	
	@Test
	public void _14_getAbsolutePath(){
		File f = new File(tp+"/01file/01f/ne.txt");
		String fa = UtilFile.getAbsolutePath(f);
		
		String head = UtilFile.getAbsolutePath("");
		System.out.println(String.format("文件：%1$s , 文件路径：%2$s", fa,head));
		Assert.assertTrue(fa.startsWith(head));
	}
	@Test
	public void _15_01_listDocument(){
		String path = UtilFile.load("TestUtil_File");
		File[] fArr = UtilFile.listDocument(new File(path));
		Assert.assertTrue("abc.txt".equals(fArr[0].getName()));
		Assert.assertTrue("ef.txt".equals(fArr[1].getName()));
	}
	
}
