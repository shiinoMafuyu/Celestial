package com.celestial.meek.realTest_2016_09;

import com.celestial.agniRadiance.EzUtil.UtilString;
import com.celestial.agniRadiance.entity.FileReader;

public class _09_22_appendRefAndType {

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param args 
	 */
	public static void main(String[] args) {
		smipleTagDealWith();
	}

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * �򵥴����±�ǩ.
	 * </ul>
	 */
	private static void smipleTagDealWith() {
		//�������ø���ǩ��Ӧ��map����.
		FileReader f = new FileReader("E:/anotherDeskTop/parese2/fall/E�ֻ�--�ֻ��ͻ����������ͨ��Э��(��) - ����Ʒ.txt");
		while(f.hasNext()){
			String s = f.readLine();
			int index = UtilString.containCompleteSimpleTag(s);
			if(index != -1){
				StringBuffer sb = new StringBuffer(s.substring(0,index)).append(" ref=\"\" type=\"\"").append(s.substring(index));
				System.out.println(sb.toString());
			}
		}
		
	}

}
