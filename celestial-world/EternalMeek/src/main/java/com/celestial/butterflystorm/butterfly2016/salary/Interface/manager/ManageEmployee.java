package com.celestial.butterflystorm.butterfly2016.salary.Interface.manager;

import java.util.List;

import com.celestial.butterflystorm.butterfly2016.salary.Interface.entity.Employee;
/**
 * <b>修改记录：</b> 
 * <p>
 * <li>
 * 
 *                        ---- Administrator 2016-10-17
 * </li>
 * </p>
 * 
 * <b>类说明：</b>
 * <p> 
 * 这个接口的实现里可以添加事物控制之类的.相当于service,而ManagerEmployeeDao则作为dao吧.<br/>
 * </p>
 */
public interface ManageEmployee {
	
	public void addEmployee(Employee employee);
	public void deleteEmployee(Employee employee);
	
	public Employee findEmployee(String id);
	public Employee findEmployee(Employee employee);
	public List<Employee> findAllEmployees(String name);
	
}
