package com.celestial.meek.realTest_2016_04_oldTest;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.celestial.agniRadiance.EzUtil.Util_DB;



public class te2 {

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param args 
	 */
	public static void main(String[] args) {
//		teContainNum();
		String userName ="trade_3400drh",password="password",path="jdbc:oracle:thin:@172.18.3.1:1521/gnnt";
		
		Connection conn = Util_DB.getConnectionOracle(userName,password,path);
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select t.code, t.commodityid ,t.beginprice from v_vvvvvvvvvvv t");
			while(rs.next()){
				System.out.println(rs.getString("code") );
			}
			
			rs.close();
			st.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			Util_DB.close(conn);
		}
	}

	@SuppressWarnings("unused")
	private static void teContainNum() {
		String s = "24 25 34 35 36 ��û�޸Ĺ� 20 21 22 23 26 27 28 30 32 ��д��,���ܻ�����Щ���� 15 16 17 18 19 31 33";
		for(int i=0 ; i< 36;i++){
			if(!s.contains(i+"")){
				System.out.println(i);
			}else{
				
			}
		}
		
	}

}
