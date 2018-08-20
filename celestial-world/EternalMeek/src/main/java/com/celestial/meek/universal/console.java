package com.celestial.meek.universal;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

public class console {

public static Map<Long,Long> payErrorMap = new HashMap<Long, Long>();
	
	public static void main(String[] args) throws ParseException {
		
		
		String sql = new StringBuffer("")
				.append("select *")
				.append("  from (select t.*, ")
				.append("               decode(gl.receiveindate,null,-1,(sysdate - to_date(to_char(t.UpdateTime, 'YYYY-MM-DD HH24:MI:SS')) - gl.receiveIndate)) overTime ") //当前系统时间 - 更新时间 - 有效期 则过期;没设有效期则永远不会过期
				.append("          from ft_game_records t, ft_game_level gl ")
				.append("         where 1 = 1 ")
				.append("           and gl.typeID = t.typeID ")
				.append("           and gl.no = t.currentLevelNO - 1) ")//当前关卡的通关之后才获得当前关卡的奖品，游戏记录表里的当前关卡是接下来的闯关关卡。所以奖品只能领取当前关卡-1的。
				.append(" where overTime > 0 ")
				.toString();
		
		System.out.println(sql);
		
		
		System.out.println(Integer.MAX_VALUE);
		
		
		
		
		
		
		
	}
	
	
	@SuppressWarnings("unused")
	private static Map<String, String> pareseXml(String xml) {
		StringBuilder labelStr = new StringBuilder();
        StringBuilder valueStr = new StringBuilder();
        char lastLable = '\0';
        Map<String,String> map = new HashMap<>();
        for(int i = 0; i < xml.length(); i++)
        {
            char c = xml.charAt(i);
            if(c != '<' && c != '>' && lastLable != '>' && valueStr.length() == 0)
                labelStr.append(c);
            if(lastLable == '>' && valueStr.length() == 0 && c != '<' || valueStr.length() > 0 && c != '<')
                valueStr.append(c);
            if(labelStr.length() > 0 && valueStr.length() > 0 && c == '<')
                map.put(labelStr.toString(), valueStr.toString());
            if(lastLable == '>' && c == '<')
                labelStr.delete(0, labelStr.length());
            if(valueStr.length() > 0 && c == '<')
                valueStr.delete(0, valueStr.length());
            lastLable = c;
        }
        return map;
	}

}
