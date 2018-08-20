/******************************************************************
 * ThenCreateClass.java
 * Copyright 2017 by WZG. All Rights Reserved.
 * CreateDate：2017年6月9日
 * Author：wangzg
 * Version：1.0.0
 ******************************************************************/

package com.celestial.meek.realTest_2017_06;

import java.util.List;

import com.celestial.agniRadiance.EzUtil.UtilCollection;
import com.celestial.agniRadiance.EzUtil.UtilFile;
import com.celestial.agniRadiance.entity.FileReader;
import com.celestial.agniRadiance.entity.Tag;
import com.celestial.butterflystorm.butterfly2016.classcreator.CreateResponseVO;
import com.celestial.butterflystorm.butterfly2017.classcreatorSex.CreateSexRequestVO;
import com.celestial.butterflystorm.butterfly2017.classcreatorSex.CreateSexResponseVO;
import com.celestial.butterflystorm.butterfly2017.classcreatorSex.CreateSimpleResponse;

/**
 * <b>修改记录：</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2017年6月9日
 * </li>
 * </p>
 * 
 * <b>类说明：</b>
 * <p> 
 * 
 * </p>
 */
@SuppressWarnings("unused")
public class ThenCreateClass {
	
	public static String[][] sArr = new String[][]{
		new String[]{"1\\.\\s游戏类别查询","2\\.\\s奖品详情查询"},
		new String[]{"2\\.\\s奖品详情查询","3\\.\\s幸运榜查询"},
		new String[]{"3\\.\\s幸运榜查询","4\\.\\s英雄榜查询"},
		new String[]{"4\\.\\s英雄榜查询","5\\.\\s可领取奖品查询"},
		new String[]{"5\\.\\s可领取奖品查询","6\\.\\s已领取奖品查询"},
		
		new String[]{"6\\.\\s已领取奖品查询","7\\.\\s已过期奖品查询"},
		new String[]{"7\\.\\s已过期奖品查询","8\\.\\s进行中游戏查询"},
		new String[]{"8\\.\\s进行中游戏查询","9\\.\\s已结束游戏查询"},
		new String[]{"9\\.\\s已结束游戏查询","10\\.\\s游戏关卡信息查询"},
		new String[]{"10\\.\\s游戏关卡信息查询","11\\.\\s竞猜"},
		
		new String[]{"11\\.\\s竞猜","12\\.\\s游戏支付"},
		new String[]{"12\\.\\s游戏支付","13\\.\\s领取奖品"},
		new String[]{"13\\.\\s领取奖品","14\\.\\send"}
	};

	public static String resultPath = "D:/workspace_final/02MyEclipse2013/05过五关斩六奖/forecast-frontend/src/gnnt/mobile/forecast/frontend/vo/";
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param args 
	 */
	public static void main(String[] args) {
		
		
		FileReader f1 = new FileReader("E:/t/t34 过五关斩六奖游戏/00文档/02协议 解析/过关沾酱协议解析.txt"); //new FileReader("E:/t/t34 过五关斩六奖游戏/00文档/协议.txt");
//		String[][] sArr = new String[][]{
//			
//		};
		
		
//		createAllRequest(f1,sArr);
		createAllResponse(f1,sArr);
//		responseCreatorWarp(f1,sArr[9][0],sArr[9][1]);
//		requestCreatorWarp(f1,sArr[9][0],sArr[9][1]);
		
//		requestCreatorWarp(f1,sArr[12][0],sArr[12][1]);
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param f1
	 * @param sArr 
	 */
	private static void createAllResponse(FileReader f1, String[][] sArr) {
		for(String[] sai : sArr){
			try {
				responseCreatorWarp(f1,sai[0],sai[1]);
				System.out.println(sai[0]+" Response生成功！");
			} catch (Exception e) {
				System.out.println(sai[0]+" --------------->Response未生成成功！");
				e.printStackTrace();
			}
		}
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param f1
	 * @param string
	 * @param string2 
	 */
	private static void responseCreatorWarp(FileReader f1, String select1P1, String select1P2) {
		FileReader fx = f1.selectAllLineBetweenRegex2(select1P1, select1P2);
		List<List<String>> responseReader = fx.selectAllLineBetweenRegexList(".*返回包.*", ".*<.*/.*MEBS_MOBILE>.*");
		
		Tag responseTag = new Tag(UtilCollection.transListToLine(responseReader.get(0)));
		Tag res = responseTag.getTagByNamesReal("REP");
//		CreateSexResponseVO cr = new CreateSexResponseVO(res);
//		Util_File.printFile(cr.getVoClassStringList(), resultPath+cr.getClassName()+".java","gbk");
		
		CreateSimpleResponse csr = new CreateSimpleResponse(res);
		
		
	}
	

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param f1
	 * @param sArr 
	 */
	private static void createAllRequest(FileReader f1, String[][] sArr) {
		for(String[] sai : sArr){
			try {
				requestCreatorWarp(f1,sai[0],sai[1]);
				System.out.println(sai[0]+" Request生成成功！");
			} catch (Exception e) {
				System.out.println(sai[0]+" --------------->Request未生成成功！");
				e.printStackTrace();
			}
		}
		
	}


	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * ReceivePrizeRequestVO
	 * </ul>
	 * @param f1
	 * @param select1P1
	 * @param select1P2
	 * @param select2P1
	 * @param select2P2 
	 */
	private static void requestCreatorWarp(FileReader f1, String select1P1, String select1P2) {
		FileReader fx = f1.selectAllLineBetweenRegex2(select1P1,select1P2);
		List<List<String>> requestReader = fx.selectAllLineBetweenRegexList(".*提交包.*", ".*返回包.*");
		Tag requestTag = new Tag(UtilCollection.transListToLine(requestReader.get(0)));
		Tag req = requestTag.getTagByNamesReal("REQ");
		
		CreateSexRequestVO cr = new CreateSexRequestVO(req);
		UtilFile.printFile(cr.getVoClassStringList(), resultPath+cr.getClassName()+".java","gbk");
		
	}

}
