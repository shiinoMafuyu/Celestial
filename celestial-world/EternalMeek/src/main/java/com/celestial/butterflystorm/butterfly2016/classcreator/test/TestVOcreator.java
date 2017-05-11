package com.celestial.butterflystorm.butterfly2016.classcreator.test;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.celestial.agniRadiance.EzUtil.Util_Collection;
import com.celestial.agniRadiance.EzUtil.Util_File;
import com.celestial.agniRadiance.entity.FileReader;
import com.celestial.agniRadiance.entity.Tag;
import com.celestial.butterflystorm.butterfly2016.classcreator.CreateRequestVO;
import com.celestial.butterflystorm.butterfly2016.classcreator.CreateResponseVO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestVOcreator {
	
	public static String resultPath = "src/main/java/com/celestial/butterflystorm/butterfly2016/classcreator/test/file/result/";
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	@Test
	public void _01_requestVO_create_warehouse() {
		
		FileReader f1 = new FileReader("src/main/java/com/celestial/butterflystorm/butterfly2016/classcreator/test/file/srcFile/投资类--手机客户端与仓单服务器通信协议.txt")
				.selectAllLineBetweenRegex2("4\\.申购委托查询", "5\\.申购成交查询");
		List<List<String>> requestReader = f1.selectAllLineBetweenRegexList(".*提交包.*", ".*返回包.*");
		
		Tag requestTag = new Tag(Util_Collection.transListToLine(requestReader.get(0)));
		Tag req = requestTag.getTagByNamesReal("REQ");
		
		CreateRequestVO cr = new CreateRequestVO(req);
//		Util_Collection.print(cr.getVoClassStringList());
		Util_File.printFile(cr.getVoClassStringList(), resultPath+cr.getClassName()+".java.txt");
	}
	
	@Test
	public void _02_requestVO_create_espot() {
		
		FileReader f1 = new FileReader("src/main/java/com/celestial/butterflystorm/butterfly2016/classcreator/test/file/srcFile/E现货--手机客户端与服务器通信协议(旧).txt")
				.selectAllLineBetweenRegex2("10\\. 商品委托查询", "11\\. 商品委托详情查询");
		List<List<String>> requestReader = f1.selectAllLineBetweenRegexList(".*请求包.*", ".*返回包.*");
		
		Tag requestTag = new Tag(Util_Collection.transListToLine(requestReader.get(0)));
		Tag req = requestTag.getTagByNamesReal("REQ");
		
		CreateRequestVO cr = new CreateRequestVO(req);
//		Util_Collection.print(cr.getVoClassStringList());
		Util_File.printFile(cr.getVoClassStringList(), resultPath+cr.getClassName()+".java.txt");
	}
	
	
	@Test
	public void _03_responseVO_create_warehouse() {
		
		FileReader f1 = new FileReader("src/main/java/com/celestial/butterflystorm/butterfly2016/classcreator/test/file/srcFile/投资类--手机客户端与仓单服务器通信协议.txt")
				.selectAllLineBetweenRegex2("4\\.申购委托查询", "5\\.申购成交查询");
		List<List<String>> responseReader = f1.selectAllLineBetweenRegexList(".*返回包.*", "5\\.申购成交查询");
		
		Tag responseTag = new Tag(Util_Collection.transListToLine(responseReader.get(0)));
		Tag res = responseTag.getTagByNamesReal("REP");
		CreateResponseVO cr = new CreateResponseVO(res);
//		Util_Collection.print(cr.getVoClassStringList());
		Util_File.printFile(cr.getVoClassStringList(), resultPath+cr.getClassName()+".java.txt");
	}
	
	@Test
	public void _04_responseVO_create_espot() {
		FileReader f1 = new FileReader("src/main/java/com/celestial/butterflystorm/butterfly2016/classcreator/test/file/srcFile/E现货--手机客户端与服务器通信协议(旧).txt")
				.selectAllLineBetweenRegex2("11\\. 商品委托详情查询", "12\\. 个人委托查询");
		List<List<String>> responseReader = f1.selectAllLineBetweenRegexList(".*返回包.*", "12\\. 个人委托查询");
		
		Tag responseTag = new Tag(Util_Collection.transListToLine(responseReader.get(0)));
		Tag res = responseTag.getTagByNamesReal("REP");
		CreateResponseVO cr = new CreateResponseVO(res);
//		Util_Collection.print(cr.getVoClassStringList());
		Util_File.printFile(cr.getVoClassStringList(), resultPath+cr.getClassName()+".java.txt","gbk");
	}
	
	
	
	
	
	
}
