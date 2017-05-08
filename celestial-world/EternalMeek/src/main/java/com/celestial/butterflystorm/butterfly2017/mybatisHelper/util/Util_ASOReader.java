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
	
	/**��Ӣ����ע��*/
	private static Map<String,String> annotionMap = new HashMap<String, String>();
	

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ��ʼ��ע��map�����ô˹�����֮ǰ���������ⲽ��
	 * </ul>
	 */
	public static void init_annotionMapInfo(String mapPath) {
		//��ʼ��ע����Ϣmap��
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
		f = f.selectLineExcludeRegex(".*--.*");//ȥ��ע����Ϣ
		return f;
	}
	
	

	public static List<String[]> getClassPropertiesList(FileReader f) {
		List<String[]> classList = new ArrayList<String[]>();
		//���ֶ���Ϣ�����ֶ���Ϣ
		f.setIndex(3);//ǰ�沿������Ϣ ֮����Ǳ�����
		while(f.hasNext()){
			String s= f.readLine();
			if("".equals(s)){
			}
			else if(null!=s && s.contains("(") && s.contains(")")){
				String[] sArr = s.split(" ");
				String annotion = annotionMap.get(sArr[0]);
				if(null == annotion)
					System.out.println(sArr[0]+" ȱ��ע�ͣ�");
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
					//�����������ͳ�Ա���������ͺ�ע�͡�
					String refClassName = Util_String.__getStrAfterLast(refArr[1], ".");
					if(SQLcreator.ONE_TO_MANY.equals(refArr[0])){
						classList.add(new String[]{sArr[0],"List<" + refClassName +">",annotion });
					}else if(SQLcreator.ONE_TO_ONE.equals(refArr[0])){
						classList.add(new String[]{sArr[0],refClassName,annotion });
					}
				}
					
			}
		}
		System.out.println("���Ա��������"+classList.size());
		return classList;
	}


	public static List<String[]> getSQLPropertiesList(FileReader f) {
		List<String[]> sqlList = new ArrayList<String[]>();
		//���ֶ���Ϣ�����ֶ���Ϣ
		int kongge = 0;
		f.setIndex(3);//ǰ�沿������Ϣ ֮����Ǳ�����
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
		
		System.out.println("SQL�ֶ�����"+(sqlList.size()-kongge));
		return sqlList;
	}
	
	/**
	 * ��ȡaso�ж��������������Ϣ��һ�����÷�װ��һ���ַ�����������鷵��<br/>
	 * ��װ�����磺<br/>
	 * strengthenKind=strengthenKind,level=level,goodslevel=goodslevel|strengthen|strengthenList|com.dn.entity.Strengthen<br/>
	 * ��ʽ��|�ֿ���4���ֱַ�Ϊ�����Ӳ�ѯ����|�����ı�|��Ӧ����ֶ�|�ֶ�����Ӧ����(�Ǹ����Ӧ����)<br/>
	 * @param f ��ȡ��aso�ļ����ļ���ȡ��(����ע����Ϣ)��
	 * @return
	 */
	public static List<String[]> createRefInfo(FileReader f) {
		List<String[]> l = new ArrayList<String[]>();
		//���ֶ���Ϣ�����ֶ���Ϣ
		f.setIndex(3);//ǰ�沿������Ϣ ֮����Ǳ�����
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
		System.out.println("ref�ֶ�����"+l.size());
		
		return l;
	}


	public static Map<String, String> getInfoMap(FileReader f) {
		Map<String,String> createInfoMap = new HashMap<String, String>();
		//���� ���� dao������Ϣ
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
	 * <b>����˵����</b>
	 * <ul>
	 * ����aso�ļ�·����ȡһ��XMLdepender����(������ݹ�ṹ�Ĺ����������ֶε�����)<br/>
	 * </ul>
	 * @param path aso�ļ�·��
	 * @return
	 */
	public static XMLdepender createXMLdepernder(String path) {
		FileReader f = readASONoAnnotion(path);
		
		Map<String,String> m = getInfoMap(f);
		List<String[]> sqlPropertiesList = getSQLPropertiesList(f);
		XMLdepender xMLdepender = new XMLdepender(m.get("fullDaoName"),m.get("fullClassName"),m.get("tableName"),sqlPropertiesList);
		//���ã�
		List<String[]> joinOnArr = createRefInfo(f);
		if(joinOnArr.size() >0){
			xMLdepender.setJoinOnArr(joinOnArr);
			//�ݹ鿪ʼ
			String directory = Util_String.__getStrBeforeLast(path, "/");
			setXMLdependerMap(xMLdepender,directory);
		}
		
		return xMLdepender;
	}

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ��Ŀ¼directory��ݹ����xMLdepender�������ı��ļ�����ȡ������Ϣ��<br/>
	 * ��������������xMLdepender�����Ӳ�ѯ��������joinOnArr.<br/>
	 * ��������ŵ�<tableName,�������ʾ��XMLdepender> map��.<br/>
	 * �����ǵݹ����ԱȽ�ֱ�۵Ĵ�ֵ��ʽ����Ū��ʹ�����ô��ݵķ�ʽ���н����ֵ.
	 * </ul>
	 * @param xMLdepender ��Ҫ����������XMLdepender������joinOnArr�������úá�
	 * @param directory ����������ϵ��aso�ļ�Ŀ¼��
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

	/** xmlģ���ļ�λ�� */
	public static String XML_TEMPLATE_FILEPATH = "";



	
	
}
