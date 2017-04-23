package com.celestial.butterflystorm.salary.manager;


import com.celestial.agniRadiance.EzUtil.Container;
import com.celestial.agniRadiance.entity.Tag;
import com.celestial.butterflystorm.salary.Config.Config;
import com.celestial.butterflystorm.salary.Interface.entity.Employee;
import com.celestial.butterflystorm.salary.Interface.infomationGetter.InformationGetter;
import com.celestial.butterflystorm.salary.Interface.manager.ManageEmployee;
import com.celestial.butterflystorm.salary.implement.entity.EmployeeFixed;

public class CoreManager {
	
	public static CoreManager coreManager = null;
	protected InformationGetter informationGetter = (InformationGetter)Container.getRealizationObject("InformationGetter");
	protected ManageEmployee managerEmployee = (ManageEmployee)Container.getRealizationObject("ManageEmployee");
	
	public  static CoreManager Instance() {
		if(null == coreManager){
			coreManager = new CoreManager();
		}
		return coreManager;
	}
	private CoreManager() {
	}
	
	public static void main(String[] args) {
		Container.init(Config.IMPL_MAP);
		CoreManager.Instance().operate();
	
	}
	public void operate() {
		String information = informationGetter.getInformation();
		Tag t = new Tag(information);
		Employee employee =  new EmployeeFixed(t);
		
		managerEmployee.addEmployee(employee);
		
	}
	

	
}
