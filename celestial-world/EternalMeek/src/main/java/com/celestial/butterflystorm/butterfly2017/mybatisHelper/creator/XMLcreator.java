package com.celestial.butterflystorm.butterfly2017.mybatisHelper.creator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.celestial.agniRadiance.EzUtil.UtilString;
import com.celestial.agniRadiance.entity.FileReader;
import com.celestial.butterflystorm.butterfly2017.mybatisHelper.depender.XMLdepender;
import com.celestial.butterflystorm.butterfly2017.mybatisHelper.util.Util_ASOReader;

public class XMLcreator {
	
	private List<String[]> columnList = new ArrayList<String[]>();
	
	private String thisClass ="";
	
	private String fullDaoName ="";
	private String fullClassName ="";
	private String tableName ="";
	
	
	private  Map<String,String> m = new LinkedHashMap<String, String>();
	
	public XMLcreator(XMLdepender xmLdepender) {
		this.columnList = xmLdepender.getColumnList();
		this.fullDaoName = xmLdepender.getFullDaoName();
		this.fullClassName = xmLdepender.getFullClassName();
		this.tableName = xmLdepender.getTableName();
		m.put("--resultMapName--", tableName+"ResultMap");
		//����ݹ� ���ɣ���
		this.thisClass = createXmlFile(xmLdepender);
	}

	private String createXmlFile(XMLdepender xmLdepender){
		
		
		createResultMap(xmLdepender);
		createSelectSQL(xmLdepender);
		
		
		insert();
		
		selectByCondition();
		selectByVague();
		update();
		delete();
		
		return replaceAll();
		
	}
	
	private void createSelectSQL(XMLdepender xmLdepender) {
		initGradationTree();
		StringBuffer sb_select = new StringBuffer("		select ");
		StringBuffer sb_from = new StringBuffer(" from ");
		StringBuffer sb_where = new StringBuffer(" where 1=1");
		selectSQL(xmLdepender,0,0,sb_select,sb_from,sb_where);
		String sql = new StringBuffer(UtilString.subStringLastChar(sb_select.toString(), ","))
					.append(" ").append(UtilString.subStringLastChar(sb_from.toString(), ","))
					.append(sb_where).append("\n").toString();
		m.put("--select_sql_sentence--", sql);
	}

	//���С����
	Map<Integer,Integer> gradationTree = new HashMap<Integer,Integer>();
	
	private void putInGradationTree(Integer i, Integer size) {
		Integer itg = gradationTree.get(i);
		if(null == itg)
			itg = 0;
		itg += size;
		gradationTree.put(i, itg);
	}

	private int getputInGradationTree(int i) {
		Integer itg = gradationTree.get(i);
		if(null == itg)
			itg = 0;
		return itg;
	}
	
	private void initGradationTree(){
		gradationTree = new HashMap<Integer, Integer>();
	}

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ��XMLdepender���ݽṹΪ�������ݹ����select sql��䴴����<br/>
	 * ��ı���t11�� "t"+�㼶 +�ڼ�����ʾ<br/>
	 * ��resultMap��Ӧ<br/>
	 * �ó����������뷨��<br/>
	 * </ul>
	 * @param sb_where 
	 * @param sb_from 
	 */
	private void selectSQL(XMLdepender xmLdepender,int talbelLevel,int index,StringBuffer sb_select, StringBuffer sb_from, StringBuffer sb_where ) {
		//Ҫ����ȡ�������С�
		//����Ҫע�⣬����ı���˳���map��˳��Ӧ����һ���ģ���Ȼ���
		List<String[]> colList = xmLdepender.getColumnList();
		for(String[] si:colList){
			if(!"".equals(si[0]))
				//t00.id id00,
				sb_select.append("t").append(talbelLevel).append(index).append(".").append(si[0]).append(" ").append(si[0]).append(talbelLevel).append(index).append(",");
		}
		//equipment t00,
		sb_from.append(xmLdepender.getTableName()).append(" ").append("t").append(talbelLevel).append(index).append(",");
		int nextLevelIndex = getputInGradationTree(talbelLevel+1);
		//һ�����й����������������
		for(String[] sj:xmLdepender.getJoinOnList()){
			//sj = [level=level,strengthenKind=strengthenKind|strengthen|strengthenList|com.dn.entity.Strengthen] ����(��|������Ϊһ��Ԫ��)
			//and t00.level=t01.level and t00.strengthenKind=t01.strengthenKind
			String[] conditionArr = sj[0].split(",");
			for(String sci : conditionArr){
				String[] equalRL = sci.split("=");//["level","level"]
				//and t00.level=t10.level
				sb_where.append(" and t").append(talbelLevel).append(nextLevelIndex).append(".").append(equalRL[0]).append(" = t").append(talbelLevel+1).append(nextLevelIndex).append(".").append(equalRL[1]);
			}
			selectSQL(xmLdepender.getxMLdependerMap().get(sj[1]),talbelLevel+1,nextLevelIndex,sb_select,sb_from,sb_where);
			
			nextLevelIndex++;
		}
		putInGradationTree(talbelLevel+1,xmLdepender.getJoinOnList().size());
		
	}
	

	private void createResultMap(XMLdepender xmLdepender) {
		initGradationTree();
		StringBuffer sb = new StringBuffer();
		resultMap(xmLdepender,0,0,sb);
		m.put("--resultMap--", sb.toString());
	}

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ��XMLdepender���ݽṹΪ�������ݹ����resultMap������<br/>
	 * </ul>
	 * @param xmLdepender
	 * @param sb
	 */
	private void resultMap(XMLdepender xmLdepender,int talbelLevel,int index, StringBuffer sb) {
		List<String[]> colList = xmLdepender.getColumnList();
		String tabs = UtilString.createTabs(talbelLevel);
		for(String[] si:colList){
			//<result column="id" property="id"/>
			if(!"".equals(si[0]))
				sb.append(tabs).append("		<result column=\"").append(si[0]).append(talbelLevel).append(index).append("\" property=\"").append(si[0]).append("\"/>\n");
			else
				sb.append(tabs).append("		\n");
		}
		int nextLevelIndex = getputInGradationTree(talbelLevel+1);
		for(String[] si : xmLdepender.getJoinOnList()){
			//"level=level,strengthenKind=strengthenKind|strengthen|strengthenList|com.dn.entity.Strengthen|many"
			String refType = "many".equals(si[4])? "collection" :"association";//һ�Զ໹��һ��һ
			sb.append(tabs).append("		<").append(refType).append(" property=\""+si[2]+"\" ofType=\""+si[3]+"\">\n");
			resultMap(xmLdepender.getxMLdependerMap().get(si[1]),talbelLevel+1,nextLevelIndex,sb);
			sb.append(tabs).append("		</").append(refType).append(">\n");
			
			nextLevelIndex++;
		}
		putInGradationTree(talbelLevel+1,xmLdepender.getJoinOnList().size());
		
	}

	private String replaceAll() {
		FileReader f_file = new FileReader(Util_ASOReader.XML_TEMPLATE_FILEPATH,false,"utf-8");
		StringBuffer sb = new StringBuffer();
		while(f_file.hasNext()){
			sb.append(f_file.readLine()).append("\n");
		}
		String s = sb.toString()
				.replaceAll("--full_dao_name--", fullDaoName)
				.replaceAll("--full_class_name--", fullClassName)
				
				.replaceAll("--insert_sql--", m.get("--insert_sql--"))
				.replaceAll("--select_sql--", m.get("--select_sql--"))
				.replaceAll("--update_sql--", m.get("--update_sql--"))
				.replaceAll("--delete_sql--", m.get("--delete_sql--"))
				.replaceAll("--select_sql_vague--", m.get("--select_sql_vague--"))
				.replaceAll("--resultMap--", m.get("--resultMap--"))
				.replaceAll("--resultMapName--", m.get("--resultMapName--"));
		
		return s;
	}

	private void insert() {
		
		StringBuffer sb_key = new StringBuffer("(");
		StringBuffer sb_value = new StringBuffer("(");
		for(String[] si:columnList){
			if(!"".equals(si[0]) && !"id".equals(si[0])){
				sb_key.append(si[0]).append(",");
				sb_value.append("#{").append(si[0]).append("},");
			}
				
		}
		String s_key = sb_key.substring(0, sb_key.length()-1)+")";
		String s_value = sb_value.substring(0, sb_value.length()-1)+")";
		
		String sql = "insert into " + tableName + s_key + " values " + s_value;
		m.put("--insert_sql--", sql);
	}
	
	private void selectByCondition() {
		/*<trim prefix="" suffixOverrides="">
			<if test="representId != null"> and representId=#{representId} </if>
			<if test="suitId != null"> and suitId=#{suitId} </if>
		</trim>*/
		StringBuffer sb = new StringBuffer("		<trim prefix=\"\" suffixOverrides=\"\">\n");
		for(String[] s: columnList){
			if("".equals(s[0])){
				sb.append("\n");
			}
			else if(null!=s[0]){
				//<if test="representId != null"> and representId=#{representId} </if>
				sb.append("			<if test=\""+s[0]+" != null\"> and t00."+s[0]+"=#{"+s[0]+"}</if>\n");
			}
		}
		sb.append("		</trim>\n");
//		String sql ="select * from "+tableName+" where 1=1 \n" + sb.toString();
		String sql = new StringBuffer(m.get("--select_sql_sentence--")).append(" ").append(sb).toString();
		m.put("--select_sql--", sql);
	}
	
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ģ����ѯ
	 * </ul>
	 */
	private void selectByVague() {
		StringBuffer sb = new StringBuffer("		<trim prefix=\"\" suffixOverrides=\"\">\n");
		for(String[] s: columnList){
			if("".equals(s[0])){
				sb.append("\n");
			}
			else if(null!=s[0]){
				//<if test="representId != null"> and representId like CONCAT('%',#{representId},'%') </if>
				sb.append("			<if test=\""+s[0]+" != null\"> and t00."+s[0]+" like CONCAT('%',#{"+s[0]+"},'%') </if>\n");
			}
		}
		sb.append("		</trim>\n");
//		String sql = "select * from "+tableName+" where 1=1 \n" + sb.toString();
		String sql = new StringBuffer(m.get("--select_sql_sentence--")).append(" ").append(sb).toString();
		m.put("--select_sql_vague--", sql);
	}
	
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ����update���set<br/>
	 * ����Ĳ��ã����ܶ�̬��������  ��������İ汾��
	 *  <trim prefix="set" suffixOverrides=",">
		  <if test="srcId!=null">SRC_ID=#{srcId},</if>
		  <if test="srcType!=null">SRC_TYPE=#{srcType},</if>
		 </trim>
	 * </ul>
	 */
	private  void update() {
		
		StringBuffer sb = new StringBuffer("		<trim prefix=\"set\" suffixOverrides=\",\">\n");
		for(String[] s:columnList){
			if("".equals(s[0])){
				sb.append("\n");
			}
			else if(null!=s[0] && !"id".equals(s[0])){
				//<if test="memberAccount != null">memberAccount=#{memberAccount},</if>
				sb.append("			<if test=\""+s[0]+" != null\">"+s[0]+"=#{"+s[0]+"},</if>\n");
			}
		}
		sb.append("		</trim>\n");
		String sql = "update "+tableName+" \n" + sb.toString() + " \n		where id=#{id}";
		m.put("--update_sql--", sql);
	}
	
	private void delete() {
		m.put("--delete_sql--", "delete from "+tableName + " where id=#{id}");
	}

	public String getThisClass() {
		return thisClass;
	}

	public void setThisClass(String thisClass) {
		this.thisClass = thisClass;
	}
	
}
