package com.celestial.butterflystorm.butterfly2016.puddingIII;

import com.celestial.butterflystorm.butterfly2016.puddingIII.InterfaceHolder.InterfaceHolder;
import com.celestial.butterflystorm.butterfly2016.puddingIII.config.Config;
import com.celestial.butterflystorm.butterfly2016.puddingIII.config.Config.COPY_METHOD;
import com.celestial.butterflystorm.butterfly2016.puddingIII.config.Config.PUDDING_TYPE;

public class DoCreate {

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param args 
	 */
	public static void main(String[] args) {
		
		/**���ÿ����õķ���*/
		Config.CopyMethod = COPY_METHOD.COPY_BY_CMD;
		/**���ò������ɺ��ŵ�·��*/
		Config.puddingPath = "E:/t/t26_myToolDevelopTestDataArea/puddingIII/res";
		
		/**�����ļ�λ����Config������*/
		InterfaceHolder holder = new InterfaceHolder(
							"E:/t/t26_myToolDevelopTestDataArea/puddingIII/puddingSrc",
							"E:/t/t26_myToolDevelopTestDataArea/puddingIII/mobile_svr_issue",
							PUDDING_TYPE.WEB);
		holder.excute();
	}

}
