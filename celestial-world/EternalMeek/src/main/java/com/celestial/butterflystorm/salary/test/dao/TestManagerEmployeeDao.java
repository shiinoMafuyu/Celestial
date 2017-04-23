package com.celestial.butterflystorm.salary.test.dao;

import java.util.List;

import junit.framework.TestCase;

import com.celestial.agniRadiance.entity.Print;
import com.celestial.agniRadiance.entity.Tag;
import com.celestial.butterflystorm.salary.Interface.dao.ManagerEmployeeDao;
import com.celestial.butterflystorm.salary.Interface.entity.Employee;
import com.celestial.butterflystorm.salary.implement.dao.ManagerEmployeeDaoImpl;
import com.celestial.butterflystorm.salary.implement.entity.EmployeeFixed;

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
		String information = "<Employee><name>LongTerm</name><age>998</age><gender>0</gender><salary>24000</salary><union>�ʼҵ�,�۷ѵ�,�����</union></Employee>";
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
		List<Employee> l = managerEmployeeDao.findAllEmployees("΢");
		System.out.println(l.size());
	}
	
	
	
}
