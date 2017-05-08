package com.celestial.butterflystorm.butterfly2016.salary.Interface.dao;

import java.util.List;

import com.celestial.butterflystorm.butterfly2016.salary.Interface.entity.Employee;

public interface ManagerEmployeeDao {
	public void addEmployee(Employee employee);
	public void deleteEmployee(Employee employee);
	public void deleteEmployee(Integer id);
	
	public Employee findEmployee(Integer id);
	public Employee findEmployee(Employee employee);
	public List<Employee> findAllEmployees(String name);
	public Employee findLastEmployee();
}
