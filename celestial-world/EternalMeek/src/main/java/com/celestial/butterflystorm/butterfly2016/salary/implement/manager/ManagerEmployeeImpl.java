package com.celestial.butterflystorm.butterfly2016.salary.implement.manager;

import java.util.List;

import com.celestial.agniRadiance.EzUtil.Container;
import com.celestial.butterflystorm.butterfly2016.salary.Interface.dao.ManagerEmployeeDao;
import com.celestial.butterflystorm.butterfly2016.salary.Interface.entity.Employee;
import com.celestial.butterflystorm.butterfly2016.salary.Interface.manager.ManageEmployee;

public class ManagerEmployeeImpl implements ManageEmployee{
	
	protected  ManagerEmployeeDao managerEmployeeDao = (ManagerEmployeeDao)Container.getRealizationObject("ManagerEmployeeDao");
	
	@Override
	public void addEmployee(Employee employee) {
		managerEmployeeDao.addEmployee(employee);
	}

	@Override
	public void deleteEmployee(Employee employee) {
		
	}

	@Override
	public Employee findEmployee(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee findEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> findAllEmployees(String name) {
		// TODO Auto-generated method stub
		return null;
	}


}
