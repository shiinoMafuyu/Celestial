package com.dn.helper;

import java.io.File;
import java.util.List;

import com.celestial.agniRadiance.EzUtil.Util_Collection;
import com.celestial.agniRadiance.EzUtil.Util_File;
import com.celestial.agniRadiance.entity.FileReader;


public class JsPackageImporter {

	static String srcFile = "src/test/resources/helper/02JSimport.txt";
	static List<String> lineList = null;
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param args 
	 */
	public static void main(String[] args) {
		
		lineList = new FileReader(srcFile,false,"utf-8").getLineList();
		allFileAddImport(Util_File.fileAll("src/main/webapp", ".*html"));
	}
	
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ������fileArr�е��ļ����<!-- auto import start--><!-- auto import end-->֮�����js������Ϣ��
	 * </ul>
	 * @param fArr
	 */
	private static void allFileAddImport(File[] fileArr) {
		File[] fArr = Util_File.fileAll("src/main/webapp", ".*html");
		for(File file:fArr){
			addImport(new FileReader(file.getAbsolutePath(),false,"utf-8"));
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected static void addImport(FileReader f) {
		int start = f.getRegexPosition(".*(<!-- auto import start-->){1}.*");
		int end = f.getRegexPosition(".*(<!-- auto import end-->){1}.*");
		
		if(start>=0 && end > start){
			List l_res = Util_Collection.replaceList(f.getLineList(), start, end, lineList);
			Util_File.printFile(l_res, f.getFilePath(),"utf-8");
			System.out.println("�������óɹ���" + f.getFileName());
		}else{
			System.out.println("δ�ҵ���ͷ�����־��������" + f.getFileName());
		}
		
	}

}
