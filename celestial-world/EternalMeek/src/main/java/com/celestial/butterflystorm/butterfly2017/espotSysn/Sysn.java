package com.celestial.butterflystorm.butterfly2017.espotSysn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.celestial.hydrogenousProminence.fileReplace.RepDependency;
import com.celestial.hydrogenousProminence.fileReplace.Replace;

/**
 * espot用sql文件里的sql代码同步对应的java代码。<br/>
 * sql里坐标定位：
 * "--" + java文件名 + " sql start-"
 * "--" + java文件名 + " sql end-"
 * <br/>
 * java 里坐标定位：
 * "——————sql start——————"
 * "——————sql end——————"
 * <br/>
 * 
 * @author Administrator
 *
 */
public class Sysn extends Replace {

	public Sysn(RepDependency depend, String charset) {
		super(depend, charset);
	}

	@SuppressWarnings("serial")
	public static void main(String[] args) {
		String commonStart = ".*sql start.*",
			   commonEnd = ".*sql end.*",
			   aimPath = "D:/workspace_final/02MyEclipse2013/liquidation/depository-extract-tradedata-m6-espot/src/gnnt/MEBS6/depository/extract/tradedata/espot/dao/impl/" ,
			   srcPath = "D:/workspace_final/02MyEclipse2013/liquidation/depository-extract-tradedata-m6-espot/src/configfiles/e现货查询.sql";
		
		String[] nameArr = new String[]{
										"OrdersDAO","OrderFileDatasDAO",
										"WithdrawsDAO","WithdrawFileDatasDAO",
										"TradesDAO","TradeFileDatasDAO"};
		RepDependency dep = new RepDependency()
				.setSourceFilePath(srcPath)
				.setRepMap(new HashMap<String,String[]>(){{
					for(int i=0;i< nameArr.length;i++){
						put("rep" + i , new String[]{"--" + nameArr[i] + " sql start-+","--" + nameArr[i] + " sql end-+",commonStart,commonEnd,aimPath + nameArr[i] + ".java"});
					}
				}});
		Sysn sysn = new Sysn(dep, "gbk");
		sysn.executeReplace();
	}
	
	@Override
	public List<String> doTrans(List<String> sourceList) {
		String apendSql = Util_sepotSysn.createAppend(sourceList,2,"sql");
		return Arrays.asList(new String[]{apendSql});
	}
	
	
}
