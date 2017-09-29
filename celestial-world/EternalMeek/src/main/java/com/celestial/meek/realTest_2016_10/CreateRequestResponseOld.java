package com.celestial.meek.realTest_2016_10;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.celestial.agniRadiance.EzUtil.UtilNormal;
import com.celestial.agniRadiance.EzUtil.UtilString;


public class CreateRequestResponseOld {

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param args 
	 */
	public static void main(String[] args) {
//		tePart1_requestOver();
//		tePart2_responseOver();

	}
	
	

	@SuppressWarnings("unused")
	public static void tePart2_responseOver() {
		List<String> lx =new ArrayList<String>();
		String[] sArr = new String[]{"CHF","CheckHistoryFlag","Double","��ǰ��ʷ��ѯ��־   0����ǰ��¼; 1: ��ʷ��¼"};
		List<String[]> ls2 = new ArrayList<String[]>();
		/*ls2.add(new String[]{"RETCODE","RETCODE","String","���ش���"});
		ls2.add(new String[]{"MESSAGE","MESSAGE","String","������Ϣ"});*/
		ls2.add(new String[]{"U","UserID","String","�û�id"});
		ls2.add(new String[]{"SI","SessionID","Long","�û��Ựid"});
		ls2.add(new String[]{"TTLREC","TotalRecords","Integer","�ܼ�¼��"});
		ls2.add(new String[]{"PRI","Price","Double","�ʽ��ܶ�"});
		String className ="SubOrderQueryResponseVO";
		
		List<String> linfo = new ArrayList<String>();
		linfo.add("update by wangzg 2016��8��3��00:02:56");

		String qualifiedName = "gnnt.MEBS.MobileServer.vo.micro.trade.TradeQueryResponseVO";
		
		List<String[]> lz = new ArrayList<String[]>();
		lz.add(new String[]{"CT","CreateTime","Date","����ʱ��"});
		lz.add(new String[]{"PRI","Price","Double","�۸�"});
		lz.add(new String[]{"FN","FirmName","String","����������"});
		
		//���Դ�����Ϣ�� (�Դ�ע��)
//		lx = DBUtil2_class.create2InfoClass(ls2,className);
		//���Դ���������
//		lx = DBUtil2_class.create2ListClass(className);
		//���Դ��� Response�е� resultList����get set����
//		lx = DBUtil2_class.create2ResultList(className);
		//���Դ���Response�еĽ����Ϣ��(�Դ�ע��)
//		lx = DBUtil2_class.create2ResultInfoClass(ls2,className);
		//���Դ���Response����Ϣ
//		lx = DBUtil2_class.createPackageInfo2(qualifiedName, ls2, null);
		//���Դ�����ע�͵�Response�� ������Response�����û������ ������!
//		lx = DBUtil2_class.createreResponseClass(qualifiedName,ls2,lz,linfo);
		//�ٲ�����request��
		String qualifiedNameRequest = "gnnt.MEBS.MobileServer.vo.micro.trade.TemplateQueryRequestVO";
		lx = CreateRequestResponseOld.createRequestClass(qualifiedNameRequest,ls2,linfo);
		for(String si : lx){
			System.out.println(si);
		}
	}


	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ����Response��(��ע��)
	 * </ul>
	 * @param qualifiedName ��ȫ��
	 * @param ls ������Ϣ���ֶ�����list
	 * @param lz ������Ϣ�ڲ����ֶ�����list
	 * @param linfo ע����Ϣ
	 * @return
	 */
	public static List<String> createreResponseClass(String qualifiedName,
			List<String[]> ls, List<String[]> lz, List<String> linfo) {
		List<String> l =new ArrayList<String>();
		checkParamArr(ls);
		checkParamArr(lz);
		String className = qualifiedName.substring(qualifiedName.lastIndexOf(".")+1);
		//1.���Response����Ϣ
		l.addAll(CreateRequestResponseOld.createPackageInfo2(qualifiedName, ls, lz));
		//2.���Response��ע��
		l.addAll(CreateRequestResponseOld.createClassAnnotation(linfo,qualifiedName));
		l.add("public class "+className+" extends ResponseVO{");
		
		//3.���resultList 
		if(lz != null && lz.size() > 0){
			l.addAll(UtilNormal.table(CreateRequestResponseOld.create2ResultList(className)));
		}
		//4.��ӽ����Ϣ��
		l.addAll(UtilNormal.table(CreateRequestResponseOld.create2ResultInfoClass(ls, className)));
		if(lz != null && lz.size() > 0){
			//5.��Ӳ�ѯ���������
			l.addAll(UtilNormal.table(CreateRequestResponseOld.create2ListClass(className)));
			//6.��Ӳ�ѯ�����Ϣ�ڲ���
			l.addAll(UtilNormal.table(CreateRequestResponseOld.create2InfoClass(lz, className)));
		}
		l.add("");
		l.add("");
		l.add("}");
		l.add("");
		
		return l;
	}


	/**
	 * <b>����˵����</b>
	 * <ul>
	 * �����Դ�ע�͵Ľ����Ϣ��<br/>
	 * ��Ҫ��Ϣ�����õ�<br/>
	 * </ul>
	 * @param ls
	 * @param className
	 * @return
	 */
	public static List<String> create2ResultInfoClass(List<String[]> ls,
			String className) {
		List<String> l =new ArrayList<String>();
		String head = className.substring(0, className.indexOf("ResponseVO"));
		l.add("/**");
		l.add(" * ���ؽ����Ϣ��");
		l.add(" */");
		l.add("public class "+head+"ResultVO extends ResultVO{");

		l.addAll(UtilNormal.table(CreateRequestResponseOld.createAllVariables(ls)));
		l.addAll(UtilNormal.table(CreateRequestResponseOld.createAllSet(ls)));
		
		l.add("}");
		l.add("");
		return l;
	}


	/**
	 * <b>����˵����</b>
	 * <ul>
	 * Response����������Ϣ������(�Դ�ע��) <br/>
	 * get set RESULTLIST <br/>
	 * </ul>
	 * @param className
	 * @return
	 */
	public static List<String> create2ResultList(String className) {
		List<String> l =new ArrayList<String>();
		String head = getResponseVOHead(className);
		l.add("/** ������ */");
		l.add("private "+head+"List RESULTLIST;");
		l.add("");
		l.add("/**");
		l.add(" * ");
		l.add(" * ��ȡ������");
		l.add(" * <br/><br/>");
		l.add(" * @return");
		l.add(" */");
		l.add("public "+head+"List getResultList(){");
		l.add("	return RESULTLIST;");
		l.add("}");
		l.add("");
		l.add("/**");
		l.add(" * ");
		l.add(" * ���ü�����");
		l.add(" * <br/><br/>");
		l.add(" * @param resultList");
		l.add(" */");
		l.add("public void setResultList("+head+"List resultList){");
		l.add("	RESULTLIST = resultList;");
		l.add("}");

		return l;
	}


	private static String getResponseVOHead(String className) {
		String head = null;
		try {
			head = className.substring(0, className.indexOf("ResponseVO"));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("��������: " + className);
		}
		return head;
	}



	/**
	 * <b>����˵����</b>
	 * <ul>
	 * Response����������Ϣ��(�Դ�ע��)<br/>
	 * </ul>
	 * @param linfo
	 * @return
	 */
	public static List<String> create2ListClass(String className) {
		List<String> l =new ArrayList<String>();
		String head = className.substring(0, className.indexOf("ResponseVO"));
		l.add("/**");
		l.add(" * ������");
		l.add(" */");
		l.add("public class "+head+"List{");
		l.add("	/** ��Ϣ���� */");
		l.add("	private List<"+head+"Obj> REC;");
		l.add("");
		l.add("	/**");
		l.add("	 * ");
		l.add("	 * ��ȡ��Ϣ����");
		l.add("	 * <br/><br/>");
		l.add("	 * @return");
		l.add("	 */");
		l.add("	public List<"+head+"Obj> getList(){");
		l.add("		return REC;");
		l.add("	}");
		l.add("");
		l.add("	/**");
		l.add("	 * ");
		l.add("	 * ������Ϣ����");
		l.add("	 * <br/><br/>");
		l.add("	 * @param list");
		l.add("	 */");
		l.add("	public void setList(List<"+head+"Obj> list){");
		l.add("		REC = list;");
		l.add("	}");
		l.add("}");
		l.add("");
		
		return l;
	}


	/**
	 * <b>����˵����</b>
	 * <ul>
	 * Response����������Ϣ��(�Դ�ע��)
	 * </ul>
	 * @param ls �ֶ�����
	 * @param className ����
	 * @return
	 */
	public static List<String> create2InfoClass(List<String[]> ls,String className) {
		List<String> l =new ArrayList<String>();
		String head = className.substring(0, className.indexOf("ResponseVO"));
		l.add("/**");
		l.add(" * ��Ϣ��");
		l.add(" */");
		l.add("public class "+head+"Obj{");
		l.addAll(UtilNormal.table(CreateRequestResponseOld.createAllVariables(ls)));
		l.addAll(UtilNormal.table(CreateRequestResponseOld.createAllSet(ls)));
		l.add("}");
		l.add("");
		
		return l;
	}


	/**
	 * ���Բ���1 Request���������
	 */
	protected static void tePart1_requestOver() {
//		List<String> lx =new ArrayList<String>();
//		String[] sArr = new String[]{"CHF","CheckHistoryFlag","Double","��ǰ��ʷ��ѯ��־   0����ǰ��¼; 1: ��ʷ��¼"};
		//��������get����
		/*List<String> lget = DBUtil2_class.createGetMethod(sArr);
		for(String i : lget){
			System.out.println(i);
		}*/
		
		//��������set����
//		List<String> lset = CreateRequestResponseOld.createSetMethod(sArr);
		/*for(String i : lset){
			System.out.println(i);
		}*/
		
		//��������getע��
//		List<String> lannotateSet = CreateRequestResponseOld.createGetAnnotate(sArr);
		/*for(String i : lannotateSet){
			System.out.println(i);
		}*/
		//��������setע��
//		List<String> lannotateGet = CreateRequestResponseOld.createSetAnnotate(sArr);
		/*for(String i : lannotateGet){
			System.out.println(i);
		}*/
		//����setע���set��������Ч��
		/*lx.addAll(lannotateSet);
		lx.addAll(lset);
		for(String i : lx){
			System.out.println(i);
		}*/
		
		//����ֱ������һ��set�ķ�����ע�⼯
		/*lx.addAll(DBUtil2_class.createSet(sArr));
		for(String i : lx){
			System.out.println(i);
		}*/
		
		//�����������е�set������
		/*List<String[]> ls = new ArrayList<String[]>();
		ls.add(sArr);
		ls.add(new String[]{"RETCODE","CheckHistoryFlag","Double","��ǰ��ʷ��ѯ��־   0����ǰ��¼; 1: ��ʷ��¼"});
		ls.add(new String[]{"MESSAGE","CheckHistoryFlag","Double","��ǰ��ʷ��ѯ��־   0����ǰ��¼; 1: ��ʷ��¼"});
		ls.add(new String[]{"TTLREC","TotalRecords","Integer","�ܼ�¼��"});
		ls.add(new String[]{"PRI","Price","Double","�ʽ��ܶ�"});
		ls.add(new String[]{"FI","FirmID","String","������ID"});*/
		//������������set������
		/*lx = DBUtil2_class.createAllSet(ls);
		
		for(String s : lx){
			System.out.println(s);
		}*/
		
		//��������set������
		/*lx = DBUtil2_class.createGet(sArr);
		for(String s : lx){
			System.out.println(s);
		}*/
		
		//������������get������
		/*List<String[]> ls2 = new ArrayList<String[]>();
		ls2.add(new String[]{"U","UserID","String","�û�id"});
		ls2.add(new String[]{"SI","SessionID","Long","�û��Ựid"});
		ls2.add(new String[]{"TTLREC","TotalRecords","Integer","�ܼ�¼��"});
		ls2.add(new String[]{"PRI","Price","Double","�ʽ��ܶ�"});
		ls2.add(new String[]{"FI","FirmID","String","������ID"});
		lx = DBUtil2_class.createAllGet(ls2,"TemplateQueryRequestVO");
		
		for(String i : lx){
			System.out.println(i);
		}*/
		
		//���������ֶμ���ע��
		/*List<String> lz = new ArrayList<String>();
//		lz.addAll(DBUtil2_class.createVariableAnnotate(sArr));
//		lz.addAll(DBUtil2_class.createVariable(sArr));
		lz.addAll(DBUtil2_class.createVariableAndAnnotate(sArr));
		for(String i : lz ){
			System.out.println(i);
		}*/
		//���������ֶμ���ע��
		List<String> lz = new ArrayList<String>();
		List<String[]> ls2 = new ArrayList<String[]>();
		ls2.add(new String[]{"RETCODE","RETCODE","String","���ش���"});
		ls2.add(new String[]{"MESSAGE","MESSAGE","String","������Ϣ"});
		ls2.add(new String[]{"U","UserID","String","�û�id"});
		ls2.add(new String[]{"SI","SessionID","Long","�û��Ựid"});
		ls2.add(new String[]{"TTLREC","TotalRecords","Integer","�ܼ�¼��"});
		ls2.add(new String[]{"PRI","Price","Double","�ʽ��ܶ�"});
//		ls2.add(new String[]{"FI","FirmID","String","������ID"});
//		lz.addAll(DBUtil2_class.createAllVariables(ls2));
		for(String i : lz ){
			System.out.println(i);
		}
		
		//���Դ���request�Ĺ��췽��
		/*List<String> lg = new ArrayList<String>();
		lg = DBUtil2_class.createConstructor("TemplateQueryRequestVO");
		for(String i : lg){
			System.out.println(i);
		}*/
		
		//����Ҫ����İ��������İ�
		/*String qualifiedName = "gnnt.MEBS.MobileServer.vo.micro.trade.TemplateQueryRequestVO";
		List<String> lb = DBUtil2_class.createPackageInfo(qualifiedName,ls2);
		for(String i : lb){
			System.out.println(i);
		}*/
		/**======================================Request��ok!================================================*/
		//����request��
		/*String qualifiedName = "gnnt.MEBS.MobileServer.vo.micro.trade.TemplateQueryRequestVO";
		List<String> lb = DBUtil2_class.createRequestClass(qualifiedName,ls2);
		for(String i : lb){
			System.out.println(i);
		}*/
		//�������ע��
		/*String qualifiedName = "gnnt.MEBS.MobileServer.vo.micro.trade.TemplateQueryRequestVO";
		List<String> linfo = new ArrayList<String>();
		linfo.add("update by wangzg 2016��8��3��00:02:56");
		List<String> lb = DBUtil2_class.createClassAnnotation(linfo);
		for(String i : lb){
			System.out.println(i);
		}*/
		//������ע���request��
		String qualifiedName = "gnnt.MEBS.MobileServer.vo.micro.trade.TemplateQueryRequestVO";
		List<String> linfo = new ArrayList<String>();
		linfo.add("update by wangzg 2016��8��3��00:02:56");
		
		
		List<String> lb = CreateRequestResponseOld.createRequestClass(qualifiedName,ls2,linfo);
		for(String i : lb){
			System.out.println(i);
		}
		/**======================================Request��ok!================================================*/
		
	}


	/**
	 * <b>����˵����</b>
	 * <ul>
	 * �������ע��
	 * </ul>
	 * @param linfo
	 * @param qualifiedName 
	 * @return
	 */
	public static List<String> createClassAnnotation(List<String> linfo, String qualifiedName) {
		List<String> l = new ArrayList<String>();
		l.add("/**");
		l.add(" * ");
		l.add(" * <b>�޸ļ�¼��</b> ");
		l.add(" * <p>");
		l.add(" * <li>");
		l.add(" * ");
//		l.add(" *                        ---- zhaoziy 2016-06-07");
		for(String si : linfo){
			l.add(" *                        ---- "+si+" ");
		}
		l.add(" * </li>");
		l.add(" * </p>");
		l.add(" * ");
		l.add(" * <b>��˵����</b>");
		l.add(" * <p> ");
		l.add(" * ");
		l.add(" * </p>");
		l.add(" */");
		if(qualifiedName != null && qualifiedName.endsWith("ResponseVO")){
			l.add("@SuppressWarnings(\"unused\")");
		}
		return l;
	}

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ����Request��(��ע��)
	 * </ul>
	 * @param qualifiedName ���ȫ��
	 * @param varsList ��������
	 * @param linfo ע����Ϣ
	 * @return
	 */
	public static List<String> createRequestClass(String qualifiedName,
			List<String[]> varsList ,List<String> linfo) {
		//���������������������
		CreateRequestResponseOld.checkParamArr(varsList);
		List<String> l = new ArrayList<String>();
		String className = qualifiedName.substring(qualifiedName.lastIndexOf(".")+1);
		//1.��Ӱ���ͷ����Ϣ
		l.addAll(CreateRequestResponseOld.createPackageInfo(qualifiedName, varsList));
		//2.������ע��
		l.addAll(CreateRequestResponseOld.createClassAnnotation(linfo,qualifiedName));
		l.add("public class "+className+" extends RequestVO{");
		//3.������б�������ע��
		l.addAll(UtilNormal.table(CreateRequestResponseOld.createAllVariables(varsList),1));
		//4.��ӹ��췽������ע��
		l.addAll(UtilNormal.table(CreateRequestResponseOld.createConstructor(className)));
		//5.�������get��������ע��
		l.addAll(UtilNormal.table(CreateRequestResponseOld.createAllGet(varsList, className)));
		l.add("}");
		l.add("");
		return l;
	}

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ��������������������� <br/>
	 * �����ϲ���������������������֤~<br/>
	 * </ul>
	 * @param varsList
	 */
	protected static void checkParamArr(List<String[]> varsList) {
		int n = 1;
		for(String[] sArr : varsList){
			n++;
			for(int i = 0 ;i < 4 ; i++){
				if(null == sArr[i] || "".equals(sArr[i])){
					StringBuffer sb =new StringBuffer("���� �� " + n + "�� ����������У��ʧ�� ,����ΪnullΪ��! --> ");
					for(String si : sArr){
						if(si != null)
							sb.append(si + "   ");
					}
					throw new RuntimeException(sb.toString());
				}
			}
		}
		
	}




	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ����������Ϣ(Request)
	 * </ul>
	 * @param qualifiedName
	 * @param varsList
	 * @return
	 */
	public static List<String> createPackageInfo(String qualifiedName, List<String[]> varsList) {
		List<String> l = new ArrayList<String>();
		String packageName = qualifiedName.substring(0, qualifiedName.lastIndexOf("."));
//		String className = qualifiedName.substring(qualifiedName.lastIndexOf(".")+1);
		l.add("package "+packageName+";");
		l.add("");
		
		l.add("import gnnt.MEBS.MobileServer.vo.RequestVO;");
		l.add("import gnnt.MEBS.MobileServer.vo.ResponseVO;");
		
		String[] typeArr = new String[]{"Date","Boolean","Double","Long","Integer"};
		
		if(checkContainType(varsList, "Date")){
			l.add("import java.util.Date;");
		}
		if(checkContainType(varsList, typeArr)){
//			l.add("import gnnt.MEBS.MobileServer.statictools.Tools;");//
			l.add("import gnnt.util.string.StringUtil;");
		}
		
		l.add("");
		return l;
	}
	
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ����������Ϣ(Response)
	 * </ul>
	 * @param qualifiedName ��ȫ��
	 * @param varsList Response�����Ϣ�����б�
	 * @param varsListInner Response�����Ϣ�ڲ�������б�
	 * @return
	 */
	public static List<String> createPackageInfo2(String qualifiedName, List<String[]> varsList ,List<String[]> varsListInner) {
		List<String> l = new ArrayList<String>();
		String packageName = qualifiedName.substring(0, qualifiedName.lastIndexOf("."));
		l.add("package "+packageName+";");
		l.add("");
		
		l.add("import gnnt.MEBS.MobileServer.vo.ResponseVO;");
		//�����Ƿ��в�ѯ�����resultList�ж��Ƿ�import java.util.List;
		if(varsListInner != null && varsListInner.size() > 0){
			l.add("import java.util.List;");
		}else{
			varsListInner = new ArrayList<String[]>();
		}
		//���� Date
		if(checkContainType(varsList,"Date") || checkContainType(varsListInner,"Date")){
			l.add("import java.util.Date;");
			l.add("import gnnt.util.date.DateFormat;");
		}
		//Double
		if(checkContainType(varsList, "Double") || checkContainType(varsListInner, "Double") ){
			l.add("import gnnt.util.number.NUMFormat;");
		}
		l.add("");
		return l;
	}
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * �ж�varsList�Ƿ����������������һ����
	 * </ul>
	 * @param varsList
	 * @param typeArr
	 * @return
	 */
	public static boolean checkContainType(List<String[]> varsList,
			String[] typeArr) {
		boolean toolsArrContainFlag = false ;
		for(String[] sArr : varsList){
			for(String i :typeArr){
				if(i.equals(sArr[2])){
					toolsArrContainFlag = true;
					break;
				}
			}
			if(toolsArrContainFlag)
				break;
		}
		return toolsArrContainFlag;
	}


	/**
	 * <b>����˵����</b>
	 * <ul>
	 * �ж��ֶ����鼯�����Ƿ����ĳһ����
	 * </ul>
	 * @param varsList �ֶ����鼯��
	 * @param type Date,Double,Integer  and so on
	 * @return
	 */
	public static boolean checkContainType(List<String[]> varsList,
			String type) {
		boolean b = false ;
		for(String[] sArr : varsList){
			if(type.equals(sArr[2])){
				b = true;
				break;
			}
		}
		return b;
	}


	/**
	 * <b>����˵����</b>
	 * <ul>
	 * �������췽��
	 * </ul>
	 * @param string
	 * @return
	 */
	public static List<String> createConstructor(String className) {
		List<String> l = new ArrayList<String>();
		String head = className.substring(0, className.indexOf("RequestVO"));
		//TemplateQueryRequestVO
		l.add("/**");
		l.add(" * <b>���췽��</b>");
		l.add(" * <br/>");
		l.add(" */");
		l.add("public "+head+"RequestVO() {");
		l.add("	super();");
		l.add("}");
		l.add("");
		l.add("/**");
		l.add(" * <b>���췽��</b>");
		l.add(" * <br/>");
		l.add(" * @param userID");
		l.add(" * @param sessionID");
		l.add(" */");
		l.add("public "+head+"RequestVO(String userID, String sessionID) {");
		l.add("	super();");
		l.add("	U = userID;");
		l.add("	SI = sessionID;");
		l.add("}");
		l.add("");
		return l;
	}

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ���������ֶεĶ����ע��
	 * </ul>
	 * @param ls2
	 * @return
	 */
	public static Collection<? extends String> createAllVariables(
			List<String[]> ls) {
		List<String> l = new ArrayList<String>();
		for(String[] sArr : ls){
			l.addAll(CreateRequestResponseOld.createVariableAndAnnotate(sArr));
		}
		return l;
	}

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ������������ע��
	 * </ul>
	 * @param sArr
	 * @return
	 */
	public static Collection<? extends String> createVariableAndAnnotate(
			String[] sArr) {
		List<String> l = new ArrayList<String>();
		if("RETCODE".equals(sArr[0]) || "MESSAGE".equals(sArr[0])){
		}else{
			l.addAll(CreateRequestResponseOld.createVariableAnnotate(sArr));
			l.addAll(CreateRequestResponseOld.createVariable(sArr));
		}
		return l;
	}

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * �����ֶε�ע��
	 * </ul>
	 * @param sArr
	 * @return
	 */
	public static Collection<? extends String> createVariableAnnotate(
			String[] sArr) {
		List<String> l = new ArrayList<String>();
		l.add("/**");
		l.add(" * "+sArr[3]+" ");
		l.add(" */");
		return l;
	}

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ������Ա����
	 * </ul>
	 * @param sArr
	 * @return
	 */
	public static List<String> createVariable(String[] sArr) {
		List<String> l = new ArrayList<String>();
//		l.add("private "+sArr[2]+" "+sArr[0]+" ;");
		l.add("private String "+sArr[0]+" ;");
		return l;
	}

	/**
	 * 
	 * <b>����˵����</b>
	 * <ul>
	 * ����ȫ��get����
	 * </ul>
	 * @param ls
	 * @return
	 */
	public static List<String> createAllGet(List<String[]> ls,String className) {
		List<String> l = new ArrayList<String>();
		//����public ResponseVO getResponseVO()���� ����ע��
		String head = className.substring(0, className.indexOf("RequestVO"));
		l.add("@Override");
		l.add("public ResponseVO getResponseVO() {");
		l.add("	return new "+head+"ResponseVO();");
		l.add("}");
		l.add("");
		//����Request�����������������get��������ע��
		for(String[] sArr : ls){
			l.addAll(CreateRequestResponseOld.createGet(sArr));
		}
		return l;
	}

	/**
	 * 
	 * <b>����˵����</b>
	 * <ul>
	 * ����Get������ ����ע��
	 * </ul>
	 * @param sArr
	 * @return
	 */
	public static List<String> createGet(String[] sArr) {
		List<String> l = new ArrayList<String>();
		//�����@Override��over������ O(��_��)O����~
		if("SessionID".equals(sArr[1])){
			l.add("@Override");
			l.add("public long getSessionID() {");
			l.add("	return StringUtil.strToLong(SI,0);");
			l.add("}");
			l.add("");
		}else if("UserID".equals(sArr[1])){
			l.add("@Override");
			l.add("public String getUserID() {");
			l.add("	return U;");
			l.add("}");
			l.add("");
		}else{
			l.addAll(CreateRequestResponseOld.createGetAnnotate(sArr));
			l.addAll(CreateRequestResponseOld.createGetMethod(sArr));
		}
		return l;
	}

	/**
	 * 
	 * <b>����˵����</b>
	 * <ul>
	 * ��������set����,����RESULT��ķ���ֵ��
	 * </ul>
	 * @param ls
	 * @return
	 */
	public static List<String> createAllSet(List<String[]> ls) {
		List<String> l = new ArrayList<String>();
		for(String[] i : ls){
			l.addAll(CreateRequestResponseOld.createSet(i));
		}
		return l;
	}

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ֱ�Ӵ���һ������set������ע���set��<br/>
	 * ûʲô�ô�,���get��Ӧ��
	 * </ul>
	 * @param sArr
	 * @return
	 */
	public static Collection<? extends String> createSet(String[] sArr) {
		//�����RETCODE �� MESSAGE�Ļ��Ͳ��÷��ط�����
		List<String> l = new ArrayList<String>();
		if("RETCODE".equals(sArr[0]) || "MESSAGE".equals(sArr[0])){
		}else{
			l.addAll(CreateRequestResponseOld.createSetAnnotate(sArr));
			l.addAll(CreateRequestResponseOld.createSetMethod(sArr));
		}
		return l;
	}

	/**
	 * 
	 * <b>����˵����</b>
	 * <ul>
	 * ����set����ע��
	 * </ul>
	 * @param sArr
	 * @return
	 */
	public static List<String> createSetAnnotate(String[] sArr) {
		List<String> l = new ArrayList<String>();
		l.add("/**");
		l.add(" * <b>����˵����</b>");
		l.add(" * <ul>");
		l.add(" * ����"+sArr[3]+"");
		
		l.add(" * </ul>");
		l.add(" * @param");
		l.add(" */");
		return l;
	}

	/**
	 * 
	 * <b>����˵����</b>
	 * <ul>
	 * ����getע��
	 * </ul>
	 * @param sArr
	 * @return
	 */
	public static List<String> createGetAnnotate(String[] sArr) {
		List<String> l = new ArrayList<String>();
		l.add("/**");
		l.add(" * <b>����˵����</b>");
		l.add(" * <ul>");
		l.add(" * ��ȡ"+sArr[3]+"");
		
		l.add(" * </ul>");
		l.add(" * @return");
		l.add(" */");
		return l;
	}


	/**
	 * 
	 * <b>����˵����</b>
	 * <ul>
	 * ����set����
	 * </ul>
	 * @param sArr
	 * @return
	 */
	public static List<String> createSetMethod(String[] sArr) {
		List<String> l = new ArrayList<String>();
		String param = UtilString.transHeadToLowerCase(sArr[1]);
		l.add("public void set"+sArr[1]+"("+sArr[2]+" "+param+") {");
		String ret = "";
		if("String".equals(sArr[2])){
			ret = "	"+sArr[0]+" = "+param+" ;";
		}else if("Boolean".equals(sArr[2])){
			ret = "	"+sArr[0]+" = "+param+".toString() ;";
		}else if("Date".equals(sArr[2])){
			ret = "	"+sArr[0]+" = DateFormat.fmtTime("+param+") ;";
		}else if("Double".equals(sArr[2])){
			ret = "	"+sArr[0]+" = NUMFormat.fmtDouble2("+param+") ;";
		}else if("Long".equals(sArr[2])){
			ret = "	"+sArr[0]+" = "+param+".toString() ;";
		}else if("Integer".equals(sArr[2])){
			ret = "	"+sArr[0]+" = "+param+".toString() ;";
		}else{
//			ret = "	"+sArr[0]+" = "+param+" ;";
//			�������漸������׳�����ʱ�쳣 ; Ҫ����Ӷ�Ӧ����;Ҫô�����������ʹ���;
			throw new RuntimeException("Set Param is not Excepted!");
		}
		l.add(ret);
		l.add("}");
		l.add("");
		return l;
	}



	/**
	 * 
	 * <b>����˵����</b>
	 * <ul>
	 * ����get����
	 * </ul>
	 * @param sArr
	 * @return
	 */
	public static List<String> createGetMethod(String[] sArr) {
		List<String> l = new ArrayList<String>();
		l.add("public "+sArr[2]+" get"+sArr[1]+"(){");
		String ret ="";
		if("String".equals(sArr[2])){
			ret = "	return "+sArr[0]+";";
		}else if("Boolean".equals(sArr[2])){
			ret = "	return StringUtil.strToBoolean("+sArr[0]+");";
		}else if("Date".equals(sArr[2])){
			ret = "	return StringUtil.strToDate("+sArr[0]+");";
		}else if("Double".equals(sArr[2])){
			ret = "	return StringUtil.strToDouble("+sArr[0]+",0.0);";
		}else if("Long".equals(sArr[2])){
			ret = "	return StringUtil.strToLong("+sArr[0]+",0L);";
		}else if("Integer".equals(sArr[2])){
			ret = "	return StringUtil.strToInt("+sArr[0]+",0);";
		}else{
//			ret = "	return "+sArr[0]+";";
//			�������漸������׳�����ʱ�쳣 ; Ҫ����Ӷ�Ӧ����;Ҫô�����������ʹ���;
			throw new RuntimeException("Set Param is not Excepted!Find Here And add Type or Check your varaible type!");
		}
		l.add(ret);
		l.add("}");
		l.add("");
		return l;
	}
	
	
}
