package com.celestial.butterflystorm.salary.implement.infomationGetter;

import com.celestial.butterflystorm.salary.Interface.infomationGetter.InformationGetter;

public class InformationReadLine implements InformationGetter {

	@Override
	public String getInformation() {
		//等会儿从命令行读取
//		String s="<name></name><age></age><gender></gender><salary></salary><union><u1>皇家党</u1></union>";
//		String s="<name>微沙</name><age>998</age><gender>女</gender><salary>24000</salary><union><u1>皇家党</u1><u1>扣费党</u1></union>";
		String s = "<Employee><name>微沙</name><age>998</age><gender>0</gender><salary>24000</salary><union>皇家党,扣费党,民进党</union></Employee>";
		return s;
	}

}
