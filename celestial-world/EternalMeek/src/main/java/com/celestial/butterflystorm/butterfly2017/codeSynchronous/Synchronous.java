package com.celestial.butterflystorm.butterfly2017.codeSynchronous;

import java.io.File;

import com.celestial.agniRadiance.EzUtil.UtilFile;
import com.celestial.agniRadiance.EzUtil.UtilString;
import com.celestial.agniRadiance.abstracte.RecursiveDealFile;
import com.celestial.agniRadiance.entity.FileReader;

public class Synchronous {

	public static void main(String[] args) {
		String path1 = "D:/workspace_final/02MyEclipse2013/liquidation/depository-extract-tradedata-m6-sale/src/gnnt/MEBS6/depository/extract/tradedata/sale";
		String path2 = "D:/workspace_final/02MyEclipse2013/liquidation/depository-extract-tradedata-m6-issue/src/gnnt/MEBS6/depository/extract/tradedata/issue";
//		String path2 = "C:/Users/Administrator/Desktop/a";
		Synchronous syn = new Synchronous();
		syn.doSynchronous(path1,path2);
		
	}

	public void doSynchronous(String path1,String path2) {
		UtilFile.deleteFile(new File(path2));
		RecursiveDealFile rd = new RecursiveDealFile(new File(path1)) {
			@Override
			public void doWork(File file) {
				FileReader f = new FileReader(file,"gbk",false);
				StringBuffer sb = new StringBuffer();
				while(f.hasNext()){
					sb.append(f.readLine()).append("\n");
				}
				String send = UtilString.subStringLastChar(sb.toString(), "\n");
				send =  send.replaceAll("gnnt.MEBS6.depository.extract.tradedata.sale", "gnnt.MEBS6.depository.extract.tradedata.issue")
							.replaceAll("sa_", "su_")
							.replaceAll("sA_", "su_")
							.replaceAll("Sa_", "su_")
							.replaceAll("SA_", "su_");
				UtilFile.printFile(send, path2 + UtilString.fmtPathStr(file.getAbsolutePath()).substring(path1.length()),"gbk");
				System.out.println("修改保存完成：" + file.getName());
			}
		};
		
		rd.start();
		
	}
	
	

}
