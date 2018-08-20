package com.celestial.butterflystorm.butterfly2017.mybatisHelper;

import java.util.Arrays;
import java.util.List;

import com.celestial.agniRadiance.EzUtil.UtilFile;
import com.celestial.butterflystorm.butterfly2017.mybatisHelper.creator.DAOcreator;
import com.celestial.butterflystorm.butterfly2017.mybatisHelper.creator.ENTITYcreator;
import com.celestial.butterflystorm.butterfly2017.mybatisHelper.creator.SQLcreator;
import com.celestial.butterflystorm.butterfly2017.mybatisHelper.creator.XMLcreator;
import com.celestial.butterflystorm.butterfly2017.mybatisHelper.depender.DAOdepender;
import com.celestial.butterflystorm.butterfly2017.mybatisHelper.depender.ENTITYdepender;
import com.celestial.butterflystorm.butterfly2017.mybatisHelper.depender.SQLdepender;
import com.celestial.butterflystorm.butterfly2017.mybatisHelper.depender.XMLdepender;

public class MyBatisHelper {

	private String daoPath = "";
	private String xmlPath = "";
	private String entityPath = "";
	private String sqlPath = "";
	
	

	/**
	 * 创造所有。
	 * @param de
	 */
	public void createAll(DependerContainer de) {
		create_entity(de.getENTITYdepender());
		create_sql(de.getSQLdepender());
		
		create_dao(de.getDAOdepender());
		create_xml(de.getXMLdepender());
	}

	private void create_entity(ENTITYdepender entityDepender) {
		
		ENTITYcreator cc = new ENTITYcreator(entityDepender);
		
		String savePath = entityPath + entityDepender.getClassName() + ".java";
		
		UtilFile.printFile(cc.getThisClass(),savePath ,"gbk");
		System.out.println("实体类创建/更新完毕：" + savePath);
		
	}
	
	private void create_sql(SQLdepender sQLdepender) {
		SQLcreator sqlFile = new SQLcreator(sQLdepender);
		
		String savePath = sqlPath + sQLdepender.getTableName() + ".sql";
		UtilFile.printFile(sqlFile.getSQL(), savePath);
		
		System.out.println("表创建sql创建/更新完毕：" + savePath);
	}

	private void create_dao(DAOdepender daOdepender) {
		DAOcreator d =new DAOcreator(daOdepender);
		String daoInterface = d.getThisClass();
		
		List<String> l = Arrays.asList(new String[]{daoInterface});
		String savePath = daoPath + daOdepender.getDaoName() +".java";
		
		UtilFile.printFile(l, savePath , "gbk");
		System.out.println("MyBatis dao创建/更新完毕：" + savePath);
		
	}
	
	private void create_xml(XMLdepender xmLdepender) {
		
		
		XMLcreator xf = new XMLcreator(xmLdepender);
		String sxml = xf.getThisClass();
		List<String> l = Arrays.asList(new String[]{sxml});

		String savePath = xmlPath + xmLdepender.getClassName() +".xml";
		
		UtilFile.printFile(l, savePath);
		System.out.println("MyBatis xml创建/更新完毕：" + savePath);
		
	}

	public MyBatisHelper setDaoPath(String daoPath) {
		this.daoPath = daoPath;
		return this;
	}

	public MyBatisHelper setXmlPath(String xmlPath) {
		this.xmlPath = xmlPath;
		return this;
	}

	public MyBatisHelper setEntityPath(String entityPath) {
		this.entityPath = entityPath;
		return this;
	}

	public MyBatisHelper setSqlPath(String sqlPath) {
		this.sqlPath = sqlPath;
		return this;
	}
	
	

}
