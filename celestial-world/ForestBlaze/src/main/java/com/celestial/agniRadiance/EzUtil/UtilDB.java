package com.celestial.agniRadiance.EzUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

/**
 * <b>修改记录：</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2016-10-??
 * </li>
 * </p>
 * 
 * <b>类说明：</b>
 * <p> 
 * String userName ="trade_3400drh",password="password",url="jdbc:oracle:thin:@172.18.3.1:1521/abc";<br/>
 * </p>
 */
public class UtilDB {

	public static Connection getConnectionMySQL(String userName, String password,String url) {
		return getConnection(userName, password, url, "com.mysql.jdbc.Driver");
	}
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 以常用密码、用户名获取MySQL连接<br/>
	 * 注意区分使用<br/>
	 * </ul>
	 * @return
	 */
	public static Connection getConnectionMySQL() {
		return getConnectionMySQL("root", "123","jdbc:mysql://localhost/typemoon");
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param userName
	 * @param password
	 * @param url
	 */
	public static Connection getConnectionOracle(String userName, String password,String url) {
		return getConnection(userName,password,url,"oracle.jdbc.driver.OracleDriver");
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取数据库连接.MySQL的或者Oracle的.<br/>
	 * </ul>
	 * @param userName
	 * @param password
	 * @param url
	 * @param driver
	 * @return
	 */
	public static Connection getConnection(String userName,String password, String url, String driver) {
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, userName, password);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("连接数据库失败~");
		}
		return conn;
	}
	public static void close(Connection conn) {
		if(conn != null){
			try {
				conn.close();
			} catch (Exception e) {
			}
		}
	}
	public static void close(Statement st) {
		if(st != null){
			try {
				st.close();
			} catch (Exception e) {
			}
		}
	}

	public static void close(java.sql.ResultSet rs) {
		if(rs != null){
			try {
				rs.close();
			} catch (Exception e) {
			}
		}
	}
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param userName
	 * @param password
	 * @param url
	 * @return 
	 */
	public static DataSource getDataSource(String userName, String password, String url) {
		BasicDataSource ds = new BasicDataSource();
		ds.setUsername(userName);
		ds.setPassword(password);
		ds.setUrl(url);
		return ds;
	}
}
