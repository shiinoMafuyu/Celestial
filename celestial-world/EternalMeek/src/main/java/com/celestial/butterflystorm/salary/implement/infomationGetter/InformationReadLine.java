package com.celestial.butterflystorm.salary.implement.infomationGetter;

import com.celestial.butterflystorm.salary.Interface.infomationGetter.InformationGetter;

public class InformationReadLine implements InformationGetter {

	@Override
	public String getInformation() {
		//�Ȼ���������ж�ȡ
//		String s="<name></name><age></age><gender></gender><salary></salary><union><u1>�ʼҵ�</u1></union>";
//		String s="<name>΢ɳ</name><age>998</age><gender>Ů</gender><salary>24000</salary><union><u1>�ʼҵ�</u1><u1>�۷ѵ�</u1></union>";
		String s = "<Employee><name>΢ɳ</name><age>998</age><gender>0</gender><salary>24000</salary><union>�ʼҵ�,�۷ѵ�,�����</union></Employee>";
		return s;
	}

}
