package com.celestial.meek.realTest_2016_09;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.celestial.agniRadiance.EzUtil.UtilFile;

public class FindClassProblem {

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param args 
	 */
	public static void main(String[] args) {
//		DBUtil.forCMD(new File("E:\\anotherDeskTop\\parese2\\fall\\E�ֻ�--�ֻ��ͻ����������ͨ��Э��(��).txt"),new File("E:\\anotherDeskTop\\parese2\\fall\\te"));
//		DBUtil.forCMD(new File("E:/HackingGate/03_2016-08-20_����һ��ʱ�Ĳ����ļ�/������/=0001�����̾���/0037-����������--Ӷ���ѯ--���״���Ӷ����շ�Ӷ��ѯ���޸�/db_script/����Ӷ����ͼ�޸�--�����һ����ѯ�ֶ�--type.sql"),new File("E:\\anotherDeskTop\\parese2\\fall\\te"));
		//E:\HackingGate\03_2016-08-20_����һ��ʱ�Ĳ����ļ�\������\=0001�����̾���\0037-����������--Ӷ���ѯ--���״���Ӷ����շ�Ӷ��ѯ���޸�\db_script\����Ӷ����ͼ�޸�--�����һ����ѯ�ֶ�--type.sql
		File f1 = new File("E:/HackingGate/03_2016-08-20_����һ��ʱ�Ĳ����ļ�/������/=0001�����̾���");
		File f2 = new File("E:/HackingGate/03_2016-08-20_����һ��ʱ�Ĳ����ļ�/������/���̾���(���Ƿ�����)");
//		System.out.println(f1.exists() +" "+f2.exists());
//		getFileTogetherByModifyTime(f1,f2);
//		compareMad5();
		UtilFile.getFileTogetherByModifyTime(f1,f2);
	}

	@SuppressWarnings("unused")
	private static void compareMad5() {
		File f1 = new File("E:/HackingGate/03_2016-08-20_����һ��ʱ�Ĳ����ļ�/������/���̾���(���Ƿ�����)/integrated_broker/timebargain_broker/jquery.validationEngine-zh_CN.js");
		File f2 = new File("E:/HackingGate/03_2016-08-20_����һ��ʱ�Ĳ����ļ�/������/x/");
		File[] fArr = f2.listFiles();
		for(File i : fArr){
			if(UtilFile.compareMD5(f1,i)){
				System.out.println(i.getName());
			}
		}
	}

	public static void getFileTogetherByModifyTime(File f1,File f2) {
		if(f1.isFile()){
			//���ļ��Ļ���f2������û��,û��ֱ�ӿ��еĻ��Ƚ����޸�ʱ��.�Ƚ����ٿ�~
			File[] fArr = f2.listFiles();
			boolean b = true;
			for(File f: fArr){
				if(f1.getName().equals(f.getName())){
					//�����ǰ�ļ�����f2�д��ڵ�ͬ���ļ���~�Ͳ��ÿ���
					
					if(!(f1.lastModified() > f.lastModified())){
						b = false;
					}
					SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
					System.out.println("f1: "+sm.format(new Date(f1.lastModified())) +"\nf2: "+sm.format(new Date(f.lastModified())) + "  Ҫ�� :" + b);
				}
			}
			if(b)
				UtilFile.copyByCmd(f1, f2);
			else
				System.out.println("f1: -->  "+f1.getAbsolutePath());
		}
		else if(f1.isDirectory()){
			//���ļ��м�������
			File[] fArr = f1.listFiles();
			for(File f : fArr){
				getFileTogetherByModifyTime(f,f2);
			}
		}
		else{
			throw new RuntimeException("�����ļ�Ҳ�����ļ����쳣!����!");
		}
	}

}
