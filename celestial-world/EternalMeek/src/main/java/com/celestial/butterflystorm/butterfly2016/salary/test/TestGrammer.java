package com.celestial.butterflystorm.butterfly2016.salary.test;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.celestial.agniRadiance.EzUtil.UtilDB;
import com.celestial.agniRadiance.EzUtil.UtilString;
import com.celestial.agniRadiance.entity.Print;
import com.celestial.agniRadiance.entity.Tag;
import com.celestial.butterflystorm.butterfly2016.salary.Interface.entity.Employee;
import com.celestial.butterflystorm.butterfly2016.salary.implement.dao.ManagerEmployeeDaoImpl;

import junit.framework.TestCase;

public class TestGrammer extends TestCase {
	
	private Print p = new Print(true);
	@Override
	protected void setUp() throws Exception {
	}
	
	@Override
	protected void tearDown() throws Exception {
	}
	public void testTagSameChild(){
		p.println("testTagSameChild---------------------------------------------->");
		Tag t = new Tag("<Employee><name>微沙</name><age>998</age><gender>女</gender><salary>24000</salary><union>皇家党,扣费党,民进党</union></Employee>");
		for(String s : t.getMapColor()){
//			System.out.println(t.getTagByNames(s.split(" ")));
			assertNotNull(t.getTagByNames(s.split(" ")));
		}
	}
	
	public void testDBLink(){
		p.println("testDBLink---------------------------------------------->");
		Connection conn = UtilDB.getConnectionMySQL();
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery("select * from employee");
			while(rs.next()){
				p.println(rs.getString(1) + " , " + rs.getString(2) + " , " + rs.getString(3)+ " , " + rs.getString(4)+ " , " + rs.getString(5)+ " , " + rs.getString(6));
				assertTrue(UtilString.isInteger(rs.getString(1)));
				
				/*assertTrue(rs.getString(2) != null);
				assertTrue(UtilString.isInteger(rs.getString(3)));
				assertTrue(UtilString.isInteger(rs.getString(4)));
				
				assertTrue(UtilString.isDouble(rs.getString(5)));
				assertTrue(rs.getString(6) != null);*/
			}
//			st.execute("insert into Employee values(null,'shiino',14,0,27000.51,'gameResearch,肝脏破碎')");插入没问题
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			try {
				rs.close();
				st.close();
			} catch (Exception e2) {
			}
			UtilDB.close(conn);
		}
	}
	
	public void testReflectGetMethod() {
		p.println("testReflectGetMethod---------------------------------------------->");
		ManagerEmployeeDaoImpl med = new ManagerEmployeeDaoImpl();
		try {
			Method m = med.getClass().getDeclaredMethod("addEmployee1", Employee.class);
//			Method m = med.getClass().getDeclaredMethod("addEmployee1", EmployeeFixed.class);//发生异常,EmployeeFixed虽然继承自Employee,但是这获取不了那个方法.
			p.println(m.getName());
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
	}
	

	
}
