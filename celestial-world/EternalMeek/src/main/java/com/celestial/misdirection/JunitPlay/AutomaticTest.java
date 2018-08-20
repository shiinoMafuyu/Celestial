package com.celestial.misdirection.JunitPlay;

import com.celestial.agniRadiance.entity.Tag;

public class AutomaticTest {

	
	

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param args 
	 */
	public static void main(String[] args) {
		
		String connectURL = "http://172.18.3.10:16503/mobile_svr_espt/communicateServlet";
		String params = "<?xml version=\"1.0\" encoding = \"GBK\"?><MEBS_MT><REQ name=\"user_login\"><U>wzgjys01</U><PASSWORD>wzgjys01</PASSWORD><RANDOM_KEY></RANDOM_KEY></REQ></MEBS_MT>";
		String res = HttpUtils.doPost(connectURL, params, HttpUtils.GBK);
		System.out.println(res);
		
		Tag tag = new Tag(res);
		System.out.println(tag.getTagByNames("REP","NAME").getValue() + " : " + tag.getTagByNames("RETCODE").getValue());
		
		AutomaticTest auto =  new AutomaticTest("");
	}
	
	/**
	 * 
	 * <b>构造方法</b>
	 * <br/>
	 * @param string
	 */
	public AutomaticTest(String string) {
		
	}
}
