package com.celestial.butterflystorm.butterfly2017.mybatisHelper.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.celestial.agniRadiance.EzUtil.Util_String;
import com.celestial.agniRadiance.entity.FileReader;
import com.celestial.butterflystorm.butterfly2017.mybatisHelper.creator.SQLcreator;
import com.celestial.butterflystorm.butterfly2017.mybatisHelper.depender.XMLdepender;

public class Util_ASOReader {
	
	/**中英对照注释*/
	private static Map<String,String> annotionMap = new HashMap<String, String>();
	

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 初始化注释map，掉用此工具类之前必须先走这步。
	 * </ul>
	 */
	public static void init_annotionMapInfo(String mapPath) {
		//初始化注释信息map。
		FileReader f_annotion = new FileReader(mapPath,true,"gbk");
		while(f_annotion.hasNext()){
			String s = f_annotion.readLine();
			if(!"".equals(s)){
				String[] sArr = s.split(":");
				annotionMap.put(sArr[0], sArr[1]);
			}
		}
	}

	public static FileReader readASONoAnnotion(String path) {
		FileReader f = new FileReader(path);
		f = f.selectLineExcludeRegex(".*--.*");//去掉注释信息
		return f;
	}
	
	

	public static List<String[]> getClassPropertiesList(FileReader f) {
		List<String[]> classList = new ArrayList<String[]>();
		//表字段信息、类字段信息
		f.setIndex(3);//前面部分是信息 之后才是变量。
		while(f.hasNext()){
			String s= f.readLine();
			if("".equals(s)){
			}
			else if(null!=s && s.contains("(") && s.contains(")")){
				String[] sArr = s.split(" ");
				String annotion = annotionMap.get(sArr[0]);
				if(null == annotion)
					System.out.println(sArr[0]+" 缺少注释！");
				if(sArr[1].contains("int")){
					classList.add(new String[]{sArr[0],"Integer",annotion});
				}
				else if(sArr[1].contains("double")){
					classList.add(new String[]{sArr[0],"Double",annotion});
				}
				else if(sArr[1].contains("char")){
					classList.add(new String[]{sArr[0],"String",annotion});
				}
				else if(sArr[1].startsWith("ref")){
					String[] refArr = Util_String.getLineParam(sArr[1], "ref").split(",");
					//设置引用类型成员变量的类型和注释。
					String refClassName = Util_String.__getStrAfterLast(refArr[1], ".");
					if(SQLcreator.ONE_TO_MANY.equals(refArr[0])){
						classList.add(new String[]{sArr[0],"List<" + refClassName +">",annotion });
					}else if(SQLcreator.ONE_TO_ONE.equals(refArr[0])){
						classList.add(new String[]{sArr[0],refClassName,annotion });
					}
				}
					
			}
		}
		System.out.println("类成员变量数："+classList.size());
		return classList;
	}


	public static List<String[]> getSQLPropertiesList(FileReader f) {
		List<String[]> sqlList = new ArrayList<String[]>();
		//表字段信息、类字段信息
		int kongge = 0;
		f.setIndex(3);//前面部分是信息 之后才是变量。
		while(f.hasNext()){
			
			String s= f.readLine();
			if("".equals(s)){
				kongge++;
				sqlList.add(new String[]{"","",""});
			}
			else if(null!=s && s.contains("(") && s.contains(")")){
				String[] sArr = s.split(" ");
				String condition = Util_String.getLineParam(s, "col_con");
				if(sArr[1].contains("int")){
					sqlList.add(new String[]{sArr[0],sArr[1],condition});
				}
				else if(sArr[1].contains("double")){
					sqlList.add(new String[]{sArr[0],sArr[1],condition});
				}
				else if(sArr[1].contains("char")){
					sqlList.add(new String[]{sArr[0],sArr[1],condition});
				}
			}
		}
		
		System.out.println("SQL字段数："+(sqlList.size()-kongge));
		return sqlList;
	}
	
	/**
	 * 读取aso中对其他表的引用信息，一个引用封装成一个字符串，组成数组返回<br/>
	 * 封装成形如：<br/>
	 * strengthenKind=strengthenKind,level=level,goodslevel=goodslevel|strengthen|strengthenList|com.dn.entity.Strengthen<br/>
	 * 形式。|分开的4部分分别为：连接查询条件|关联的表|对应表的字段|字段所对应的类(那个表对应的类)<br/>
	 * @param f 读取了aso文件的文件读取类(已无注释信息)。
	 * @return
	 */
	public static List<String[]> createRefInfo(FileReader f) {
		List<String[]> l = new ArrayList<String[]>();
		//表字段信息、类字段信息
		f.setIndex(3);//前面部分是信息 之后才是变量。
		while(f.hasNext()){
			String s= f.readLine();
			if("".equals(s)){
			}
			//strengthenList ref(many,com.dn.entity.Strengthen) table(strengthenKind=strengthenKind,level=level,goodslevel=goodslevel|strengthen)
			//"level=level,strengthenKind=strengthenKind|strengthen|strengthenList|com.dn.entity.Strengthen"
			else if(null!=s && s.contains("(") && s.contains(")") && s.contains("ref") && s.contains("table")){
				String refProperty = s.split(" ")[0];
				String[] refInfos = Util_String.getLineParam(s,"ref").split(",");
				String[] tableInfoArr = Util_String.getLineParam(s, "table").split("\\|");
				l.add(new String[]{tableInfoArr[0],tableInfoArr[1],refProperty,refInfos[1],refInfos[0]});
			}
		}
		System.out.println("ref字段数："+l.size());
		
		return l;
	}


	public static Map<String, String> getInfoMap(FileReader f) {
		Map<String,String> createInfoMap = new HashMap<String, String>();
		//类名 表名 dao名等信息
		String fullClassName = Util_String.getLineParam(f.readLine(0),"fullClassName");
		String fullDaoName = Util_String.getLineParam(f.readLine(1),"fullDaoName");
		
		String daoName = fullDaoName.substring(fullDaoName.lastIndexOf(".")+1);
		String className = fullClassName.substring(fullClassName.lastIndexOf(".")+1);
		
		String tableName = Util_String.__transHeadToLowerCase(className);
		
		createInfoMap.put("fullClassName", fullClassName);
		createInfoMap.put("fullDaoName", fullDaoName);
		createInfoMap.put("daoName", daoName);
		createInfoMap.put("className", className);
		createInfoMap.put("tableName", tableName);
		createInfoMap.put("tableCondition", Util_String.getLineParam(f.readLine(2), "tableCondition"));
		return createInfoMap;
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 根据aso文件路径获取一个XMLdepender对象(包含其递归结构的关联表、关联字段的设置)<br/>
	 * </ul>
	 * @param path aso文件路径
	 * @return
	 */
	public static XMLdepender createXMLdepernder(String path) {
		FileReader f = readASONoAnnotion(path);
		
		Map<String,String> m = getInfoMap(f);
		List<String[]> sqlPropertiesList = getSQLPropertiesList(f);
		XMLdepender xMLdepender = new XMLdepender(m.get("fullDaoName"),m.get("fullClassName"),m.get("tableName"),sqlPropertiesList);
		//引用！
		List<String[]> joinOnArr = createRefInfo(f);
		if(joinOnArr.size() >0){
			xMLdepender.setJoinOnArr(joinOnArr);
			//递归开始
			String directory = Util_String.__getStrBeforeLast(path, "/");
			setXMLdependerMap(xMLdepender,directory);
		}
		
		return xMLdepender;
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 从目录directory里递归查找xMLdepender所依赖的表文件，获取依赖信息。<br/>
	 * 依赖查找条件是xMLdepender的连接查询条件数组joinOnArr.<br/>
	 * 依赖结果放到<tableName,依赖表表示类XMLdepender> map中.<br/>
	 * 由于是递归所以比较直观的传值方式不好弄，使用引用传递的方式进行结果定值.
	 * </ul>
	 * @param xMLdepender 需要查找依赖的XMLdepender对象，其joinOnArr需已设置好。
	 * @param directory 查找依赖关系的aso文件目录。
	 */
	private static void setXMLdependerMap(XMLdepender xMLdepender,
			String directory) {
		List<String[]> joinOnArr = xMLdepender.getJoinOnList();
		Map<String,XMLdepender> xMLdependerMap = new HashMap<String,XMLdepender>();
		for(String[] si :joinOnArr){
			String tableName = si[1];
			FileReader fi = readASONoAnnotion(directory+"/"+tableName+".aso");
			Map<String, String> mi = getInfoMap(fi);
			XMLdepender xi = new XMLdepender(mi.get("fullClassName"), mi.get("tableName"), getSQLPropertiesList(fi));
			List<String[]> joinOnArri = createRefInfo(fi);
			if(joinOnArri.size() >0){
				xi.setJoinOnArr(joinOnArri);
				setXMLdependerMap(xi,directory);
			}
			xMLdependerMap.put(tableName, xi);
		}
		
		xMLdepender.setxMLdependerMap(xMLdependerMap);
		
	}

	/** xml模板文件位置 */
	public static String XML_TEMPLATE_FILEPATH = "";



	
	
}
