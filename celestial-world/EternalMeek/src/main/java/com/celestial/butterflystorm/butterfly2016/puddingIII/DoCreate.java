package com.celestial.butterflystorm.butterfly2016.puddingIII;

import com.celestial.butterflystorm.butterfly2016.puddingIII.InterfaceHolder.InterfaceHolder;
import com.celestial.butterflystorm.butterfly2016.puddingIII.config.Config;
import com.celestial.butterflystorm.butterfly2016.puddingIII.config.Config.COPY_METHOD;
import com.celestial.butterflystorm.butterfly2016.puddingIII.config.Config.PUDDING_TYPE;

public class DoCreate {

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param args 
	 */
	public static void main(String[] args) {
		
		/**设置拷贝用的方法*/
		Config.CopyMethod = COPY_METHOD.COPY_BY_CMD;
		/**设置补丁生成后存放的路径*/
		Config.puddingPath = "E:/t/t26_myToolDevelopTestDataArea/puddingIII/res";
		
		/**生成文件位置在Config里配置*/
		InterfaceHolder holder = new InterfaceHolder(
							"E:/t/t26_myToolDevelopTestDataArea/puddingIII/puddingSrc",
							"E:/t/t26_myToolDevelopTestDataArea/puddingIII/mobile_svr_issue",
							PUDDING_TYPE.WEB);
		holder.excute();
	}

}
