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
				.append("               decode(gl.receiveindate,null,-1,(sysdate - to_date(to_char(t.UpdateTime, 'YYYY-MM-DD HH24:MI:SS')) - gl.receiveIndate)) overTime ") //��ǰϵͳʱ�� - ����ʱ�� - ��Ч�� �����;û����Ч������Զ�������
				.append("          from ft_game_records t, ft_game_level gl ")
				.append("         where 1 = 1 ")
				.append("           and gl.typeID = t.typeID ")
				.append("           and gl.no = t.currentLevelNO - 1) ")//��ǰ�ؿ���ͨ��֮��Ż�õ�ǰ�ؿ��Ľ�Ʒ����Ϸ��¼����ĵ�ǰ�ؿ��ǽ������Ĵ��عؿ������Խ�Ʒֻ����ȡ��ǰ�ؿ�-1�ġ�
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
