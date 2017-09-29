package com.celestial.butterflystorm.butterfly2016.puddingII;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.celestial.agniRadiance.EzUtil.UtilFile;

/**
 * ���ɲ���
 * @author Administrator
 *
 */
public class puddingController {

	/**
	 * �Զ����ɲ���С����.
	 * ��������˵��:
	 * 1)��ȡs1���ڵ�Ŀ¼�������ļ�,����֮.��Ϊs1.fileI.
	 * 2)ȥs2��ݹ����ļ�,ֻ������һ����md5ժҪ�㷨��һ�µĲ���ͬһ���ļ�(������֤���Բ�����):
	 * 		�����s1.fileI��.java�ļ�ȥ,src������.�ҵ�֮�����src�µ�·��ȥWEB-INF����.java�ļ���Ӧ��.class�ļ�.
	 * 		���s1.fileI�Ƿ�.java�ļ� (��.jsp .xml ��)��ֱ��ȥWEB-INF����ͬ��ͬMD5ֵ�ļ�.
	 * 3)�ҵ���Ӧ���ļ������s1�ﴴ����ӦĿ¼,������ȥ.�����java�ļ��������ڲ����ļ�û��,�еĻ�Ҳȫ����ȥ.
	 * 2016��8��23��16:40:38
	 * 
	 */
	public static void main(String[] args) {
		/**1.Ҫ���������ļ�����һ����ʱĿ¼��,��s1������λ��*/
		String s1 = "E:/HackingGate/03_2016-08-20_����һ��ʱ�Ĳ����ļ�/������/testPodCreate/pudding";
		/**2.���϶�����web��Ŀ·��,���м���.*/
		String s2 = "E:/HackingGate/03_2016-08-20_����һ��ʱ�Ĳ����ļ�/������/testPodCreate/project/issue_front_ɽ������";
		makeingPudding(s1,s2);
	}

	private static boolean makeingPudding(String s1, String s2) {
		if(!(UtilFile.checkFileExist(s1) && UtilFile.checkFileExist(s2)))
			throw new RuntimeException("����ļ��Ƿ񶼴���" + s1 +"\n" + s2);
		boolean b = true;
		List<String> failedList =new ArrayList<String>();
		try{
			File[] fArr = new File(s1).listFiles();
			PuddingMaker p ;
			for(File i : fArr){
				String i0 = i.getAbsolutePath().replaceAll("\\\\", "/");
				p =new PuddingMaker(i0, s2);
				int x = p.makePudding();
				if(x != 1){
					failedList.add(p.getFileName());
				}
			}
			//���չʾ
			System.out.println("���� " + fArr.length);
			System.out.println("�ɹ�: " +(fArr.length - failedList.size()));
			System.out.println("ʧ��: " + failedList.size());
			for(String i : failedList){
				System.out.println(i);
			}
		}catch(Exception e){
			e.printStackTrace();
			b=false;
		}
		return b;
	}

}

