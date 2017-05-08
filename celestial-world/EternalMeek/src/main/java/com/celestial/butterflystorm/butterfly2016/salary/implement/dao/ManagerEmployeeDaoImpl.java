package com.celestial.butterflystorm.butterfly2016.salary.implement.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.celestial.butterflystorm.butterfly2016.salary.Interface.dao.ManagerEmployeeDao;
import com.celestial.butterflystorm.butterfly2016.salary.Interface.entity.Employee;
import com.celestial.butterflystorm.butterfly2016.salary.implement.entity.EmployeeFixed;
import com.celestial.butterflystorm.butterfly2016.salary.tempAbstract.dao.ManagerEmployeeDaoTemp;

@SuppressWarnings("unused")
public class ManagerEmployeeDaoImpl extends  ManagerEmployeeDaoTemp implements ManagerEmployeeDao{
	private Employee NullEmployee = new EmployeeFixed();
	@Override
	public void addEmployee(Employee employee) {
		todo(new Object[]{this,"addEmployee1",new Class[]{Employee.class},new Object[]{employee}});
	}
	public void addEmployee1(Employee e) throws SQLException   {
		ps = conn.prepareStatement("insert into Employee values(null,?,?,?,?,?)");
		
		ps.setString(1, e.getName());
		ps.setInt(2, e.getAge());
		ps.setInt(3, e.getGender());
		
		ps.setDouble(4, e.getSalary());
		ps.setString(5, e.getUnions());
		ps.execute();
		
	}
	
	@Override
	public void deleteEmployee(Employee employee) {
		deleteEmployee(employee.getId());
	}
	
	@Override
	public void deleteEmployee(Integer id) {
		todo(new Object[]{this,"deleteEmployee1",new Class[]{Integer.class},new Object[]{id}});
	}
	public void deleteEmployee1(Integer id) throws SQLException {
		ps = conn.prepareStatement("delete from  Employee where id=?");
		ps.setInt(1, id);
		ps.execute();
	}
	@Override
	public Employee findEmployee(Integer id) {
		return (Employee)todo(new Object[]{this,"findEmployee1",new Class[]{Integer.class},new Object[]{id}});
	}
	public Employee findEmployee1(Integer id) throws SQLException {
		ps = conn.prepareStatement("select * from  Employee where id=?");
		ps.setInt(1, id);
		rs = ps.executeQuery();
		Employee emp = null;
		while(rs.next()){
			emp = new EmployeeFixed(rs);
		}
		return emp;
	}

	@Override
	public Employee findEmployee(Employee employee) {
		return findEmployee(employee.getId());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> findAllEmployees(String name) {
		return (List<Employee>)todo(new Object[]{this,"findAllEmployees1",new Class[]{String.class},new Object[]{name}});
	}
	public List<Employee> findAllEmployees1(String name) throws SQLException {
		ps = conn.prepareStatement("select * from  Employee where name like ?");
		ps.setString(1, "%"+name+"%");
		rs = ps.executeQuery();
		List<Employee> l = new ArrayList<Employee>();
		Employee emp = null;
		while(rs.next()){
			emp = new EmployeeFixed(rs);
			l.add(emp);
		}
		return l;
	}
	@Override
	public Employee findLastEmployee() {
		return (Employee)todo(new Object[]{this,"findLastEmployee1",new Class[]{},new Object[]{}});
	}
	
	public Employee findLastEmployee1() throws SQLException {
		ps = conn.prepareStatement(" select * from employee where id = (select max(id) from employee);");
		rs = ps.executeQuery();
		Employee emp = null;
		while(rs.next()){
			emp = new EmployeeFixed(rs);
		}
		return emp;
	}

}
