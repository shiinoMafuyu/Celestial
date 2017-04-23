package com.dn.helper;

import java.util.Arrays;
import java.util.List;

import com.celestial.agniRadiance.EzUtil.Util_File;
import com.dn.helper.mybatisHelper.DependerContainer;
import com.dn.helper.mybatisHelper.creator.DAOcreator;
import com.dn.helper.mybatisHelper.creator.ENTITYcreator;
import com.dn.helper.mybatisHelper.creator.SQLcreator;
import com.dn.helper.mybatisHelper.creator.XMLcreator;
import com.dn.helper.mybatisHelper.depender.DAOdepender;
import com.dn.helper.mybatisHelper.depender.ENTITYdepender;
import com.dn.helper.mybatisHelper.depender.SQLdepender;
import com.dn.helper.mybatisHelper.depender.XMLdepender;

public class MyBatisHelper {

	
	public static final String ANNOTION_MAP_FILE = "src/test/resources/helper/中英对照.txt";
	
	private String daoPath = "src/main/java/com/dn/dao/";
	private String xmlPath = "src/main/java/com/dn/dao/xml/";
	private String entityPath = "src/main/java/com/dn/entity/";
	private String sqlPath = "src/test/resources/helper/sql/";
	
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param args 
	 */
	public static void main(String[] args) {
		String[] sqlFiles = new String[]{
				"src/test/resources/helper/tableAssociation/equipment.aso",
				"src/test/resources/helper/tableAssociation/strengthen.aso",
				"src/test/resources/helper/tableAssociation/charactor.aso",
				
				"src/test/resources/helper/tableAssociation/dragonJade.aso",
				"src/test/resources/helper/tableAssociation/enchantment.aso",
				"src/test/resources/helper/tableAssociation/mintMark.aso",
				"src/test/resources/helper/tableAssociation/buff.aso"
		};
		MyBatisHelper m = new MyBatisHelper();
		for(String s: sqlFiles){
			DependerContainer de = new DependerContainer(s);
			m.create_entity(de.getENTITYdepender());
			m.create_sql(de.getSQLdepender());
			m.create_dao(de.getDAOdepender());
			
			m.create_xml(de.getXMLdepender());
			
		}
		
	}

	private void create_entity(ENTITYdepender entityDepender) {
		
		ENTITYcreator cc = new ENTITYcreator(entityDepender);
		
		String savePath = entityPath + entityDepender.getClassName() + ".java";
		
		Util_File.printFile(cc.getThisClass(),savePath ,"gbk");
		System.out.println("实体类创建/更新完毕：" + savePath);
		
	}
	
	private void create_sql(SQLdepender sQLdepender) {
		SQLcreator sqlFile = new SQLcreator(sQLdepender);
		
		String savePath = sqlPath + sQLdepender.getTableName() + ".sql";
		Util_File.printFile(sqlFile.getSQL(), savePath);
		
		System.out.println("表创建sql创建/更新完毕：" + savePath);
	}

	private void create_dao(DAOdepender daOdepender) {
		DAOcreator d =new DAOcreator(daOdepender);
		String daoInterface = d.getThisClass();
		
		List<String> l = Arrays.asList(new String[]{daoInterface});
		String savePath = daoPath + daOdepender.getDaoName() +".java";
		
		Util_File.printFile(l, savePath , "gbk");
		System.out.println("MyBatis dao创建/更新完毕：" + savePath);
		
	}
	
	private void create_xml(XMLdepender xmLdepender) {
		
		
		XMLcreator xf = new XMLcreator(xmLdepender);
		String sxml = xf.getThisClass();
		List<String> l = Arrays.asList(new String[]{sxml});

		String savePath = xmlPath + xmLdepender.getClassName() +".xml";
		
		Util_File.printFile(l, savePath);
		System.out.println("MyBatis xml创建/更新完毕：" + savePath);
		
	}

}
