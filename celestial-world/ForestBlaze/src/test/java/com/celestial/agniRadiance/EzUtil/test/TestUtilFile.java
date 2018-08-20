package com.celestial.agniRadiance.EzUtil.test;

import java.io.File;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.celestial.agniRadiance.EzUtil.UtilDate;
import com.celestial.agniRadiance.EzUtil.UtilFile;
import com.celestial.agniRadiance.EzUtil.UtilString;
import com.celestial.agniRadiance.abstracte.RecursiveDealFile;
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
		List<String> fileList = UtilFile.findFile(fileName, new File("E:/HackingGate/06_2016-10/���Ϸ��Ľ����ϣ�Mgr"));
		String path = "E:\\HackingGate\\06_2016-10\\���Ϸ��Ľ����ϣ�Mgr\\broker-src\\gnnt\\MEBS\\member\\broker\\action\\AutoAuditFirmServlet.java";
		Assert.assertEquals(path, fileList.get(0));
	}
	
	@Ignore
	@Test
	public void _02_FindFile2() {
		String fileName = ".*\\.java";
		List<String> fileList = UtilFile.findFile(fileName, new File("D:/workspace/shjy_mgr/entity-src/gnnt"));
		Assert.assertEquals(19, fileList.size());
	}
	@Ignore
	@Test
	public void _03_FileDirectory(){
		String filePath = "src/test/java/com/celestial/agniRadiance/EzUtil/test/file";
		String regex = ".*file.*";
		File[] fArr = UtilFile.fileDirectory(filePath,regex);
		Assert.assertEquals(3, fArr.length);
	}
	@Ignore
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
		String filePath = "E:/HackingGate/06_2016-10/���Ϸ��Ľ����ϣ�Mgr";
		String regex = ".*c.*";
		File[] fArr = UtilFile.fileDocument(filePath,regex);
		Assert.assertEquals(3, fArr.length);
	}
	
	@Ignore
	@Test
	public void _05_FileIntegrated() {
		String filePath = "E:/HackingGate/06_2016-10/���Ϸ��Ľ����ϣ�Mgr";
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
		String filePath = "E:/HackingGate/03_2016-08-20_����һ��ʱ�Ĳ����ļ�/������/testPodCreate/project/issue_front_ɽ������/WebRoot";
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
		System.out.println("ɾ�����");
	}
	
	@Ignore
	@Test
	public void _10_getCreateTime(){
		String f1Path = (tp+"/����.txt");
		String abPath = new File(f1Path).getAbsolutePath();
		Date d = UtilFile.getCreateTime(abPath);
		Assert.assertNotNull(d);
	}
	
	@Ignore
	@Test
	public void _10_getModifiedTime() throws Exception{
		String f1Path = (tp+"/����.txt");
		Date d = UtilFile.getModifiedTime(new File(f1Path));
		Assert.assertNotNull(UtilDate.inTime(d, new Date[]{new Date()}));
	}
	
	@Ignore
	@Test
	public void _1001_compareModifiedTime(){
		File f1 = new File(tp+"/file.txt");
		File f2 = new File(tp+"/file2.txt");
		boolean b = UtilFile.compareModifiedTime(f1,f2);
		Assert.assertTrue(b);
	}
	
	@Ignore
	@Test
	public void _11_compareAndRenew(){
		
		File file = new File(tp+"/file.txt");//��
		File file2 = new File(tp+"/file2.txt");//��
		File yue = new File(tp+"/����.txt");//��
		
		
		File file2_t = new File(tp+"/file2_t.txt");//��
		
		
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
	@Ignore
	@Test
	public void _12_copyByCmd(){
		File f1 = new File(tp+"/����.txt");
		File f2 = new File(tp+"/����2.txt");
		UtilFile.copyByCmd(f1, f2);
		boolean b = UtilFile.compareFileContent(f1, f2);
		f2.delete();
		Assert.assertTrue(b);
		
	}
	@Ignore
	@Test
	public void _13_getUnRepeatName(){
		File f = new File(tp+"/01file/01f/ne.txt");
		FileReader fr = new FileReader(f);
		System.out.println(fr.readLine());
		File fe = UtilFile.getUnRepeatName(f);
		Assert.assertEquals("3-ne.txt",fe.getName());
		
	}
	@Ignore
	@Test
	public void _14_getAbsolutePath(){
		File f = new File(tp+"/01file/01f/ne.txt");
		String fa = UtilFile.getAbsolutePath(f);
		
		String head = UtilFile.getAbsolutePath("");
		System.out.println(String.format("�ļ���%1$s , �ļ�·����%2$s", fa,head));
		Assert.assertTrue(fa.startsWith(head));
	}
	@Ignore
	@Test
	public void _15_01_listDocument(){
		String path = UtilFile.load("TestUtil_File");
		File[] fArr = UtilFile.listDocument(new File(path));
		Assert.assertTrue("abc.txt".equals(fArr[0].getName()));
		Assert.assertTrue("ef.txt".equals(fArr[1].getName()));
	}
	
	@Test
	public void _16_01_transEncode(){
//		String path = "C:/Users/Administrator/Desktop/3/Container.java";
//		String savePath = "C:/Users/Administrator/Desktop/3/Container2.java";
//		List<String> ls = UtilFile.readFileLineToList(path, "gbk", false);
//		UtilFile.printFile(ls, savePath, "utf-8");
		
		String[] paths = new String[] {
				"H:\\workspace_final\\01neon\\01GitHub\\Celestial2",
				/*"C:\\Users\\Administrator\\Desktop\\3"*/
		};
		
		for(String si : paths) {
			recresiveShowEncoding(new File(si));
		}
		
		for(String si : encodingType) {
			System.out.println(si);
		}
		//EncodingDetect
		
	}
	
	static Set<String> encodingType = new HashSet<>();

	private void recresiveShowEncoding(File file) {
		
		@SuppressWarnings("serial")
		Set<String> typeSet = new HashSet<String>() {{
			/*add("java");*/
			add("html");
			add("css");
			add("js");
		}};
		
		if(file.exists()){
			RecursiveDealFile rd = new RecursiveDealFile(file) {
				@Override
				public void doWork(File file) {
					try {
						String fileName = file.getName();
						String end = fileName.substring(fileName.lastIndexOf(".")+1);
						if(typeSet.contains(end)) {
							String encoding = EncodingDetect.getJavaEncode(file);
							encodingType.add(encoding);
							changeEncoding(file.getAbsolutePath(),encoding,"utf-8");
						}
						
					} catch (Exception e) {
					}
				}
				
				public void doDirectoryWork(File directory){
				}
			};
			rd.start();
		}
	}
	
	private void changeEncoding(String absolutePath, String encoding, String targetEncoding) {
		absolutePath = UtilString.fmtPathStr(absolutePath);
		List<String> ls = UtilFile.readFileLineToList(absolutePath, encoding, false);
		UtilFile.printFile(ls, absolutePath, targetEncoding);
		
	}
	
}
