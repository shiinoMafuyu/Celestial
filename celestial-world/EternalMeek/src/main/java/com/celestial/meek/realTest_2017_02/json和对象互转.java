package com.celestial.meek.realTest_2017_02;

public class json和对象互转 {

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param args 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		
//		_01_();
		/*Equip e = new Equip();e.setName("月下");e.setGoodslevel("009300010001");e.setSuitId("qaq").setAf(12.33);
		String jsonstr = Util_Json.toJsonString(e);
		System.out.println(jsonstr);
	}

	private static void _01_() {
		Equipment e = new Equipment();e.setName("月下");e.setGoodslevel("009300010001");e.setSuitId("qaq");
//		Util_Json
//		JSONObject js = 
//		JSONArray.
		JSONObject js = JSONObject.fromBean(e);
		js.toString(1);
		System.out.println(js.toString());
		for(Iterator<String>  it = js.keys() ;it.hasNext();){
			String key = it.next();
			String value = js.getString(key);
			if(!"".equals(value) && !"null".equals(value) && null !=value)
				System.out.print("\""+key+"\":\""+js.getString(key)+"\",");
		}
		
		
//		js.toJSONArray(arg0)E:\m2\repository\net\sf\json-lib\json-lib\0.8\json-lib-0.8.jar
		
		String jsonArrStr = "[{\"gf\":null,\"ti\":null,\"zmsh\":null,\"level\":null,\"zmDK\":null,\"yzDK_\":null,\"ti_\":null,\"zz_\":null,\"wg\":\"\",\"hp_\":null,\"zhi\":null,\"hf\":null,\"hg\":null,\"zz\":null,\"sf\":null,\"sg\":null,\"li\":null,\"mg_\":\"\",\"gg\":null,\"xyDK_\":null,\"wg_\":\"\",\"yz_\":null,\"wf\":null,\"mphf\":null,\"hp\":null,\"representId\":\"\",\"min_\":null,\"zm_\":null,\"yzDK\":null,\"wf_\":null,\"ydsd\":null,\"yz\":null,\"id\":null,\"suitId\":\"\",\"name\":\"月下\",\"xy_\":null,\"mg\":\"\",\"mphf_\":null,\"mf\":null,\"zm\":null,\"zmsh_\":null,\"min\":null,\"ydsd_\":null,\"mf_\":null,\"goodslevel\":\"\",\"xy\":null,\"strengthenKind\":\"\",\"xyDK\":null,\"li_\":null,\"zhi_\":null,\"ag\":12.3,\"zmDK_\":null,\"af\":2.33}]";
		
		String jsonStr = "{\"gf\":null,\"ti\":null,\"zmsh\":null,\"level\":null,\"zmDK\":null,\"yzDK_\":null,\"ti_\":null,\"zz_\":null,\"wg\":\"\",\"hp_\":null,\"zhi\":null,\"hf\":null,\"hg\":null,\"zz\":null,\"sf\":null,\"sg\":null,\"li\":null,\"mg_\":\"\",\"gg\":null,\"xyDK_\":null,\"wg_\":\"\",\"yz_\":null,\"wf\":null,\"mphf\":null,\"hp\":null,\"representId\":\"\",\"min_\":null,\"zm_\":null,\"yzDK\":null,\"wf_\":null,\"ydsd\":null,\"yz\":null,\"id\":null,\"suitId\":\"qaq\",\"name\":\"月下\",\"xy_\":null,\"mg\":\"\",\"mphf_\":null,\"mf\":null,\"zm\":null,\"zmsh_\":null,\"min\":null,\"ydsd_\":null,\"mf_\":null,\"goodslevel\":\"009300010001\",\"xy\":null,\"strengthenKind\":\"\",\"xyDK\":null,\"li_\":null,\"zhi_\":null,\"ag\":null,\"zmDK_\":null,\"af\":null}";
		String jsonStr2 = "{\"suitId\":\"qaq\",\"name\":\"月下\",\"goodslevel\":\"009300010001\"}";
		JSONArray jRrr = JSONArray.fromString(jsonArrStr);
		System.out.println(jRrr.length());
		
		JSONObject jo = new JSONObject(jsonStr);
//		Equipment e2 = (Equipment)JSONObject.toBean(jo,Equipment.class);
		Equipment e2 = (Equipment)JSONObject.toBean(jo,Equipment.class);
		System.out.println(1);*/
	}

}
