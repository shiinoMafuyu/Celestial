/******************************************************************
 * ThenCreateClass.java
 * Copyright 2017 by WZG. All Rights Reserved.
 * CreateDate��2017��6��9��
 * Author��wangzg
 * Version��1.0.0
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
 * <b>�޸ļ�¼��</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2017��6��9��
 * </li>
 * </p>
 * 
 * <b>��˵����</b>
 * <p> 
 * 
 * </p>
 */
@SuppressWarnings("unused")
public class ThenCreateClass {
	
	public static String[][] sArr = new String[][]{
		new String[]{"1\\.\\s��Ϸ����ѯ","2\\.\\s��Ʒ�����ѯ"},
		new String[]{"2\\.\\s��Ʒ�����ѯ","3\\.\\s���˰��ѯ"},
		new String[]{"3\\.\\s���˰��ѯ","4\\.\\sӢ�۰��ѯ"},
		new String[]{"4\\.\\sӢ�۰��ѯ","5\\.\\s����ȡ��Ʒ��ѯ"},
		new String[]{"5\\.\\s����ȡ��Ʒ��ѯ","6\\.\\s����ȡ��Ʒ��ѯ"},
		
		new String[]{"6\\.\\s����ȡ��Ʒ��ѯ","7\\.\\s�ѹ��ڽ�Ʒ��ѯ"},
		new String[]{"7\\.\\s�ѹ��ڽ�Ʒ��ѯ","8\\.\\s��������Ϸ��ѯ"},
		new String[]{"8\\.\\s��������Ϸ��ѯ","9\\.\\s�ѽ�����Ϸ��ѯ"},
		new String[]{"9\\.\\s�ѽ�����Ϸ��ѯ","10\\.\\s��Ϸ�ؿ���Ϣ��ѯ"},
		new String[]{"10\\.\\s��Ϸ�ؿ���Ϣ��ѯ","11\\.\\s����"},
		
		new String[]{"11\\.\\s����","12\\.\\s��Ϸ֧��"},
		new String[]{"12\\.\\s��Ϸ֧��","13\\.\\s��ȡ��Ʒ"},
		new String[]{"13\\.\\s��ȡ��Ʒ","14\\.\\send"}
	};

	public static String resultPath = "D:/workspace_final/02MyEclipse2013/05�����ն����/forecast-frontend/src/gnnt/mobile/forecast/frontend/vo/";
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param args 
	 */
	public static void main(String[] args) {
		
		
		FileReader f1 = new FileReader("E:/t/t34 �����ն������Ϸ/00�ĵ�/02Э�� ����/����մ��Э�����.txt"); //new FileReader("E:/t/t34 �����ն������Ϸ/00�ĵ�/Э��.txt");
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
	 * <b>����˵����</b>
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
				System.out.println(sai[0]+" Response���ɹ���");
			} catch (Exception e) {
				System.out.println(sai[0]+" --------------->Responseδ���ɳɹ���");
				e.printStackTrace();
			}
		}
	}

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param f1
	 * @param string
	 * @param string2 
	 */
	private static void responseCreatorWarp(FileReader f1, String select1P1, String select1P2) {
		FileReader fx = f1.selectAllLineBetweenRegex2(select1P1, select1P2);
		List<List<String>> responseReader = fx.selectAllLineBetweenRegexList(".*���ذ�.*", ".*<.*/.*MEBS_MOBILE>.*");
		
		Tag responseTag = new Tag(UtilCollection.transListToLine(responseReader.get(0)));
		Tag res = responseTag.getTagByNamesReal("REP");
//		CreateSexResponseVO cr = new CreateSexResponseVO(res);
//		Util_File.printFile(cr.getVoClassStringList(), resultPath+cr.getClassName()+".java","gbk");
		
		CreateSimpleResponse csr = new CreateSimpleResponse(res);
		
		
	}
	

	/**
	 * <b>����˵����</b>
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
				System.out.println(sai[0]+" Request���ɳɹ���");
			} catch (Exception e) {
				System.out.println(sai[0]+" --------------->Requestδ���ɳɹ���");
				e.printStackTrace();
			}
		}
		
	}


	/**
	 * <b>����˵����</b>
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
		List<List<String>> requestReader = fx.selectAllLineBetweenRegexList(".*�ύ��.*", ".*���ذ�.*");
		Tag requestTag = new Tag(UtilCollection.transListToLine(requestReader.get(0)));
		Tag req = requestTag.getTagByNamesReal("REQ");
		
		CreateSexRequestVO cr = new CreateSexRequestVO(req);
		UtilFile.printFile(cr.getVoClassStringList(), resultPath+cr.getClassName()+".java","gbk");
		
	}

}
