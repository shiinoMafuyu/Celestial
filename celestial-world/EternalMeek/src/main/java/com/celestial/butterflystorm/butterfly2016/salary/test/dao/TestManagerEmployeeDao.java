package com.celestial.butterflystorm.butterfly2016.salary.test.dao;

import java.util.List;

import com.celestial.agniRadiance.entity.Print;
import com.celestial.agniRadiance.entity.Tag;
import com.celestial.butterflystorm.butterfly2016.salary.Interface.dao.ManagerEmployeeDao;
import com.celestial.butterflystorm.butterfly2016.salary.Interface.entity.Employee;
import com.celestial.butterflystorm.butterfly2016.salary.implement.dao.ManagerEmployeeDaoImpl;
import com.celestial.butterflystorm.butterfly2016.salary.implement.entity.EmployeeFixed;

import junit.framework.TestCase;

public class TestManagerEmployeeDao extends TestCase{
	private ManagerEmployeeDao managerEmployeeDao = null;
	private Employee emp;
	
	private Print p = new Print(true);
	@Override
	protected void setUp() throws Exception {
		managerEmployeeDao = new ManagerEmployeeDaoImpl();
	}
	
	@Override
	protected void tearDown() throws Exception {
	}
	
	public void tes1tAddEmployee() {
		String information = "<Employee><name>LongTerm</name><age>998</age><gender>0</gender><salary>24000</salary><union>皇家党,扣费党,民进党</union></Employee>";
		Tag t = new Tag(information);
		Employee employee =  new EmployeeFixed(t);
		managerEmployeeDao.addEmployee(employee);
	}
	
	public void testFindEmployee() {
		emp = managerEmployeeDao.findLastEmployee();
		p.println(emp.toString());
	}
	
	public void testFineEmployeeById() {
		emp = managerEmployeeDao.findEmployee(12);
		assertEquals(12, 12);
	}
	
	public void testFindAllEmployee(){
		List<Employee> l = managerEmployeeDao.findAllEmployees("微");
		System.out.println(l.size());
	}
	
	
	
}
