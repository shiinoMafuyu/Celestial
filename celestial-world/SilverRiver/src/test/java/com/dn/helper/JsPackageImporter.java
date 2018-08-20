package com.dn.helper;

import java.io.File;
import java.util.List;

import com.celestial.agniRadiance.EzUtil.UtilCollection;
import com.celestial.agniRadiance.EzUtil.UtilFile;
import com.celestial.agniRadiance.entity.FileReader;


public class JsPackageImporter {

	static String srcFile = "src/test/resources/helper/02JSimport.txt";
	static List<String> lineList = null;
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param args 
	 */
	public static void main(String[] args) {
		
		lineList = new FileReader(srcFile,false,"utf-8").getLineList();
		allFileAddImport(UtilFile.fileAll("src/WebContent", ".*html"));
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 给所有fileArr中的文件里的<!-- auto import start--><!-- auto import end-->之间插入js导入信息。
	 * </ul>
	 * @param fArr
	 */
	private static void allFileAddImport(File[] fileArr) {
		for(File file:fileArr){
			addImport(new FileReader(file.getAbsolutePath(),false,"utf-8"));
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected static void addImport(FileReader f) {
		int start = f.getRegexPosition(".*(<!-- auto import start-->){1}.*");
		int end = f.getRegexPosition(".*(<!-- auto import end-->){1}.*");
		
		if(start>=0 && end > start){
			List l_res = UtilCollection.replaceList(f.getLineList(), start, end, lineList);
			UtilFile.printFile(l_res, f.getFilePath(),"utf-8");
			System.out.println("插入引用成功：" + f.getFileName());
		}else{
			System.out.println("未找到的头插入标志，跳过：" + f.getFileName());
		}
		
	}

}
