package com.celestial.meek.realTest_2017_04_01;

import java.util.Arrays;

import com.celestial.agniRadiance.EzUtil.Util_File;
import com.celestial.agniRadiance.entity.FileReader;

public class Replace {

	public static void main(String[] args) {
		FileReader f = new FileReader("D:/workspace4/db/c_right.sql", false, "gbk");//("D:/workspace4/db/c_right.sql")
		String save = "E:/t/t25_OTC�ֻ�/t18�޸�member��exchange/08���±���2017-04-07/c_right.sql";
		StringBuffer sb = new StringBuffer("");
		while(f.hasNext()){
			sb.append(f.readLine()).append("\n");
		}
		String send = sb.toString();
		send = send.substring(0, send.length()-1)
						.replaceAll("ռ�ñ�֤��","ռ�ý�����Լ��֤��")
						.replaceAll("�ͷű�֤��","�ͷŽ�����Լ��֤��")
						.replaceAll("���ձ�֤��","������Լ��֤��")
						.replaceAll("���ñ�֤��","���ý�����Լ��֤��")
						.replaceAll("���ᱣ֤��","���ύ����Լ��֤��");
		Util_File.printFile(Arrays.asList(new String[]{send}), save,"gbk");
		System.out.println("��ɣ�");
		System.out.println(send);
	}

}
