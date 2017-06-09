package com.celestial.butterflystorm.butterfly2017.codeSynchronous;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import com.celestial.agniRadiance.EzUtil.Util_File;
import com.celestial.agniRadiance.EzUtil.Util_String;
import com.celestial.agniRadiance.abstracte.RecursiveDealFile;
import com.celestial.agniRadiance.entity.FileReader;

public class Synchronous_reverse {
	
	private static List<String[]> configList = Arrays.asList(new String[][]{
		new String[]{"D:/workspace_final/02MyEclipse2013/liquidation/depository-extract-tradedata-m6-issue/src/gnnt/MEBS6/depository/extract/tradedata/issue"
				,"D:/workspace_final/02MyEclipse2013/liquidation/depository-extract-tradedata-m6-sale/src/gnnt/MEBS6/depository/extract/tradedata/sale"},
		new String[]{"D:/workspace_final/02MyEclipse2013/liquidation/depository-extract-tradedata-m6-issue/src/configfiles/GUO_SHANG.xml"
				,"D:/workspace_final/02MyEclipse2013/liquidation/depository-extract-tradedata-m6-sale/src/configfiles/GUO_SHANG.xml"}
	});

	public static void main(String[] args) {
		
		
		doAllSysn(configList);
		
		
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param configList2 
	 */
	private static void doAllSysn(List<String[]> aconfigList) {
		
		for(String[] si : aconfigList){
			Synchronous_reverse syn = new Synchronous_reverse();
			syn.doSynchronous(si[0],si[1]);
		}
		
	}

	public void doSynchronous(String path1,String path2) {
		Util_File.deleteFile(new File(path2));
		RecursiveDealFile rd = new RecursiveDealFile(new File(path1)) {
			@Override
			public void doWork(File file) {
				String charset = getCharsetByType(file.getName());
				FileReader f = new FileReader(file,charset,false);
				StringBuffer sb = new StringBuffer();
				while(f.hasNext()){
					sb.append(f.readLine()).append("\n");
				}
				String send = Util_String.subStringLastChar(sb.toString(), "\n");
				send =  send.replaceAll("gnnt.MEBS6.depository.extract.tradedata.issue","gnnt.MEBS6.depository.extract.tradedata.sale")
							.replaceAll("su_", "sa_")
							.replaceAll("sA_", "sa_")
							.replaceAll("SU_", "sa_")
							.replaceAll("Su_", "sa_");
				Util_File.printFile(send, path2 + Util_String.fmtPathStr(file.getAbsolutePath()).substring(path1.length()),charset);
				System.out.println("修改保存完成：" + file.getName());
			}

			
			
		};
		
		rd.start();
		
	}
	
	private String getCharsetByType(String name) {
		if(Util_String.matchAllSameRegx(name, ".*\\.java"))
			return "gbk";
		else
			return "utf-8";
	}

}
