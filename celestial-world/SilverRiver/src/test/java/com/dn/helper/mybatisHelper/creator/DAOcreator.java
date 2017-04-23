package com.dn.helper.mybatisHelper.creator;

import com.celestial.agniRadiance.EzUtil.Util_String;
import com.dn.helper.mybatisHelper.depender.DAOdepender;

public class DAOcreator {

	private String className = "";
	private String daoName ="";
	
	
	private String thisClass ="";
	
	String interfaceDao = 	"package com.dn.dao;\n" +
			"\n" +
			"import java.util.List;\n" +
			"\n" +
			"import com.dn.annotation.MyBatisRepository;\n" +
			"import com.dn.entity.--arg_className--;\n" +
			"\n" +
			"@MyBatisRepository\n" +
			"public interface --arg_daoName-- {\n\n" +
			"--arg_methodStr--\n" +
			"}\n" ;
	
	StringBuffer sb = new StringBuffer("	int insert(className paramName);\n")
	   .append("	List<className> selectByCondition(className paramName);\n")
	   .append("	List<className> selectByVague(className paramName);\n")
	   .append("	int update(className paramName);\n")
	   .append("	int deleteById(int id);\n");
	
	public DAOcreator(DAOdepender dAOdepender) {
		this.className = dAOdepender.getClassName();
		this.daoName = dAOdepender.getDaoName();

		createDao();
	}


	private void createDao() {
		String methodStr = sb.toString().replaceAll("className", className)
										.replaceAll("paramName", Util_String.__transHeadToLowerCase(className));
		
		thisClass = interfaceDao.replaceAll("--arg_className--", className)
									   .replaceAll("--arg_daoName--", daoName)
									   .replaceAll("--arg_methodStr--", methodStr);
		
	}

	public String getClassName() {
		return className;
	}


	public void setClassName(String className) {
		this.className = className;
	}


	public String getThisClass() {
		return thisClass;
	}


	public void setThisClass(String thisClass) {
		this.thisClass = thisClass;
	}
	
	

}
