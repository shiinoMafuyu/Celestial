package com.celestial.meek.realTest_2016_10;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.celestial.agniRadiance.EzUtil.UtilNormal;
import com.celestial.agniRadiance.EzUtil.UtilString;


public class CreateRequestResponseOld {

	/**
	 * <b>方法说明：</b>
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
		String[] sArr = new String[]{"CHF","CheckHistoryFlag","Double","当前历史查询标志   0：当前记录; 1: 历史记录"};
		List<String[]> ls2 = new ArrayList<String[]>();
		/*ls2.add(new String[]{"RETCODE","RETCODE","String","返回代码"});
		ls2.add(new String[]{"MESSAGE","MESSAGE","String","返回信息"});*/
		ls2.add(new String[]{"U","UserID","String","用户id"});
		ls2.add(new String[]{"SI","SessionID","Long","用户会话id"});
		ls2.add(new String[]{"TTLREC","TotalRecords","Integer","总记录数"});
		ls2.add(new String[]{"PRI","Price","Double","资金总额"});
		String className ="SubOrderQueryResponseVO";
		
		List<String> linfo = new ArrayList<String>();
		linfo.add("update by wangzg 2016年8月3日00:02:56");

		String qualifiedName = "gnnt.MEBS.MobileServer.vo.micro.trade.TradeQueryResponseVO";
		
		List<String[]> lz = new ArrayList<String[]>();
		lz.add(new String[]{"CT","CreateTime","Date","创建时间"});
		lz.add(new String[]{"PRI","Price","Double","价格"});
		lz.add(new String[]{"FN","FirmName","String","交易商名称"});
		
		//测试创建信息类 (自带注释)
//		lx = DBUtil2_class.create2InfoClass(ls2,className);
		//测试创建集合类
//		lx = DBUtil2_class.create2ListClass(className);
		//测试创建 Response中的 resultList和其get set方法
//		lx = DBUtil2_class.create2ResultList(className);
		//测试创建Response中的结果信息类(自带注释)
//		lx = DBUtil2_class.create2ResultInfoClass(ls2,className);
		//测试创建Response包信息
//		lx = DBUtil2_class.createPackageInfo2(qualifiedName, ls2, null);
		//测试创建带注释的Response类 创建的Response类基本没问题了 不报错!
//		lx = DBUtil2_class.createreResponseClass(qualifiedName,ls2,lz,linfo);
		//再测试下request类
		String qualifiedNameRequest = "gnnt.MEBS.MobileServer.vo.micro.trade.TemplateQueryRequestVO";
		lx = CreateRequestResponseOld.createRequestClass(qualifiedNameRequest,ls2,linfo);
		for(String si : lx){
			System.out.println(si);
		}
	}


	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 创建Response类(带注释)
	 * </ul>
	 * @param qualifiedName 类全名
	 * @param ls 返回信息类字段数组list
	 * @param lz 返回信息内部类字段数组list
	 * @param linfo 注释信息
	 * @return
	 */
	public static List<String> createreResponseClass(String qualifiedName,
			List<String[]> ls, List<String[]> lz, List<String> linfo) {
		List<String> l =new ArrayList<String>();
		checkParamArr(ls);
		checkParamArr(lz);
		String className = qualifiedName.substring(qualifiedName.lastIndexOf(".")+1);
		//1.添加Response包信息
		l.addAll(CreateRequestResponseOld.createPackageInfo2(qualifiedName, ls, lz));
		//2.添加Response类注释
		l.addAll(CreateRequestResponseOld.createClassAnnotation(linfo,qualifiedName));
		l.add("public class "+className+" extends ResponseVO{");
		
		//3.添加resultList 
		if(lz != null && lz.size() > 0){
			l.addAll(UtilNormal.table(CreateRequestResponseOld.create2ResultList(className)));
		}
		//4.添加结果信息类
		l.addAll(UtilNormal.table(CreateRequestResponseOld.create2ResultInfoClass(ls, className)));
		if(lz != null && lz.size() > 0){
			//5.添加查询结果集合类
			l.addAll(UtilNormal.table(CreateRequestResponseOld.create2ListClass(className)));
			//6.添加查询结果信息内部类
			l.addAll(UtilNormal.table(CreateRequestResponseOld.create2InfoClass(lz, className)));
		}
		l.add("");
		l.add("");
		l.add("}");
		l.add("");
		
		return l;
	}


	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 创建自带注释的结果信息类<br/>
	 * 主要信息返回用的<br/>
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
		l.add(" * 返回结果信息类");
		l.add(" */");
		l.add("public class "+head+"ResultVO extends ResultVO{");

		l.addAll(UtilNormal.table(CreateRequestResponseOld.createAllVariables(ls)));
		l.addAll(UtilNormal.table(CreateRequestResponseOld.createAllSet(ls)));
		
		l.add("}");
		l.add("");
		return l;
	}


	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * Response方法创建信息集合类(自带注释) <br/>
	 * get set RESULTLIST <br/>
	 * </ul>
	 * @param className
	 * @return
	 */
	public static List<String> create2ResultList(String className) {
		List<String> l =new ArrayList<String>();
		String head = getResponseVOHead(className);
		l.add("/** 集合类 */");
		l.add("private "+head+"List RESULTLIST;");
		l.add("");
		l.add("/**");
		l.add(" * ");
		l.add(" * 获取集合类");
		l.add(" * <br/><br/>");
		l.add(" * @return");
		l.add(" */");
		l.add("public "+head+"List getResultList(){");
		l.add("	return RESULTLIST;");
		l.add("}");
		l.add("");
		l.add("/**");
		l.add(" * ");
		l.add(" * 设置集合类");
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
			throw new RuntimeException("类名错误: " + className);
		}
		return head;
	}



	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * Response方法创建信息类(自带注释)<br/>
	 * </ul>
	 * @param linfo
	 * @return
	 */
	public static List<String> create2ListClass(String className) {
		List<String> l =new ArrayList<String>();
		String head = className.substring(0, className.indexOf("ResponseVO"));
		l.add("/**");
		l.add(" * 集合类");
		l.add(" */");
		l.add("public class "+head+"List{");
		l.add("	/** 信息集合 */");
		l.add("	private List<"+head+"Obj> REC;");
		l.add("");
		l.add("	/**");
		l.add("	 * ");
		l.add("	 * 获取信息集合");
		l.add("	 * <br/><br/>");
		l.add("	 * @return");
		l.add("	 */");
		l.add("	public List<"+head+"Obj> getList(){");
		l.add("		return REC;");
		l.add("	}");
		l.add("");
		l.add("	/**");
		l.add("	 * ");
		l.add("	 * 设置信息集合");
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
	 * <b>方法说明：</b>
	 * <ul>
	 * Response方法创建信息类(自带注释)
	 * </ul>
	 * @param ls 字段数组
	 * @param className 类名
	 * @return
	 */
	public static List<String> create2InfoClass(List<String[]> ls,String className) {
		List<String> l =new ArrayList<String>();
		String head = className.substring(0, className.indexOf("ResponseVO"));
		l.add("/**");
		l.add(" * 信息类");
		l.add(" */");
		l.add("public class "+head+"Obj{");
		l.addAll(UtilNormal.table(CreateRequestResponseOld.createAllVariables(ls)));
		l.addAll(UtilNormal.table(CreateRequestResponseOld.createAllSet(ls)));
		l.add("}");
		l.add("");
		
		return l;
	}


	/**
	 * 测试部分1 Request类生成完毕
	 */
	protected static void tePart1_requestOver() {
//		List<String> lx =new ArrayList<String>();
//		String[] sArr = new String[]{"CHF","CheckHistoryFlag","Double","当前历史查询标志   0：当前记录; 1: 历史记录"};
		//测试生成get方法
		/*List<String> lget = DBUtil2_class.createGetMethod(sArr);
		for(String i : lget){
			System.out.println(i);
		}*/
		
		//测试生成set方法
//		List<String> lset = CreateRequestResponseOld.createSetMethod(sArr);
		/*for(String i : lset){
			System.out.println(i);
		}*/
		
		//测试生成get注释
//		List<String> lannotateSet = CreateRequestResponseOld.createGetAnnotate(sArr);
		/*for(String i : lannotateSet){
			System.out.println(i);
		}*/
		//测试生成set注释
//		List<String> lannotateGet = CreateRequestResponseOld.createSetAnnotate(sArr);
		/*for(String i : lannotateGet){
			System.out.println(i);
		}*/
		//测试set注解和set方法创建效果
		/*lx.addAll(lannotateSet);
		lx.addAll(lset);
		for(String i : lx){
			System.out.println(i);
		}*/
		
		//测试直接生成一个set的方法和注解集
		/*lx.addAll(DBUtil2_class.createSet(sArr));
		for(String i : lx){
			System.out.println(i);
		}*/
		
		//测试生成所有的set方法集
		/*List<String[]> ls = new ArrayList<String[]>();
		ls.add(sArr);
		ls.add(new String[]{"RETCODE","CheckHistoryFlag","Double","当前历史查询标志   0：当前记录; 1: 历史记录"});
		ls.add(new String[]{"MESSAGE","CheckHistoryFlag","Double","当前历史查询标志   0：当前记录; 1: 历史记录"});
		ls.add(new String[]{"TTLREC","TotalRecords","Integer","总记录数"});
		ls.add(new String[]{"PRI","Price","Double","资金总额"});
		ls.add(new String[]{"FI","FirmID","String","交易商ID"});*/
		//测试生成所有set方法集
		/*lx = DBUtil2_class.createAllSet(ls);
		
		for(String s : lx){
			System.out.println(s);
		}*/
		
		//测试生成set方法集
		/*lx = DBUtil2_class.createGet(sArr);
		for(String s : lx){
			System.out.println(s);
		}*/
		
		//测试生成所有get方法集
		/*List<String[]> ls2 = new ArrayList<String[]>();
		ls2.add(new String[]{"U","UserID","String","用户id"});
		ls2.add(new String[]{"SI","SessionID","Long","用户会话id"});
		ls2.add(new String[]{"TTLREC","TotalRecords","Integer","总记录数"});
		ls2.add(new String[]{"PRI","Price","Double","资金总额"});
		ls2.add(new String[]{"FI","FirmID","String","交易商ID"});
		lx = DBUtil2_class.createAllGet(ls2,"TemplateQueryRequestVO");
		
		for(String i : lx){
			System.out.println(i);
		}*/
		
		//测试生成字段及其注解
		/*List<String> lz = new ArrayList<String>();
//		lz.addAll(DBUtil2_class.createVariableAnnotate(sArr));
//		lz.addAll(DBUtil2_class.createVariable(sArr));
		lz.addAll(DBUtil2_class.createVariableAndAnnotate(sArr));
		for(String i : lz ){
			System.out.println(i);
		}*/
		//创建所有字段及其注解
		List<String> lz = new ArrayList<String>();
		List<String[]> ls2 = new ArrayList<String[]>();
		ls2.add(new String[]{"RETCODE","RETCODE","String","返回代码"});
		ls2.add(new String[]{"MESSAGE","MESSAGE","String","返回信息"});
		ls2.add(new String[]{"U","UserID","String","用户id"});
		ls2.add(new String[]{"SI","SessionID","Long","用户会话id"});
		ls2.add(new String[]{"TTLREC","TotalRecords","Integer","总记录数"});
		ls2.add(new String[]{"PRI","Price","Double","资金总额"});
//		ls2.add(new String[]{"FI","FirmID","String","交易商ID"});
//		lz.addAll(DBUtil2_class.createAllVariables(ls2));
		for(String i : lz ){
			System.out.println(i);
		}
		
		//测试创建request的构造方法
		/*List<String> lg = new ArrayList<String>();
		lg = DBUtil2_class.createConstructor("TemplateQueryRequestVO");
		for(String i : lg){
			System.out.println(i);
		}*/
		
		//测试要导入的包和所属的包
		/*String qualifiedName = "gnnt.MEBS.MobileServer.vo.micro.trade.TemplateQueryRequestVO";
		List<String> lb = DBUtil2_class.createPackageInfo(qualifiedName,ls2);
		for(String i : lb){
			System.out.println(i);
		}*/
		/**======================================Request类ok!================================================*/
		//创建request类
		/*String qualifiedName = "gnnt.MEBS.MobileServer.vo.micro.trade.TemplateQueryRequestVO";
		List<String> lb = DBUtil2_class.createRequestClass(qualifiedName,ls2);
		for(String i : lb){
			System.out.println(i);
		}*/
		//创建类的注释
		/*String qualifiedName = "gnnt.MEBS.MobileServer.vo.micro.trade.TemplateQueryRequestVO";
		List<String> linfo = new ArrayList<String>();
		linfo.add("update by wangzg 2016年8月3日00:02:56");
		List<String> lb = DBUtil2_class.createClassAnnotation(linfo);
		for(String i : lb){
			System.out.println(i);
		}*/
		//创建带注解的request类
		String qualifiedName = "gnnt.MEBS.MobileServer.vo.micro.trade.TemplateQueryRequestVO";
		List<String> linfo = new ArrayList<String>();
		linfo.add("update by wangzg 2016年8月3日00:02:56");
		
		
		List<String> lb = CreateRequestResponseOld.createRequestClass(qualifiedName,ls2,linfo);
		for(String i : lb){
			System.out.println(i);
		}
		/**======================================Request类ok!================================================*/
		
	}


	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 创建类的注释
	 * </ul>
	 * @param linfo
	 * @param qualifiedName 
	 * @return
	 */
	public static List<String> createClassAnnotation(List<String> linfo, String qualifiedName) {
		List<String> l = new ArrayList<String>();
		l.add("/**");
		l.add(" * ");
		l.add(" * <b>修改记录：</b> ");
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
		l.add(" * <b>类说明：</b>");
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
	 * <b>方法说明：</b>
	 * <ul>
	 * 创建Request类(带注释)
	 * </ul>
	 * @param qualifiedName 类的全名
	 * @param varsList 变量数组
	 * @param linfo 注释信息
	 * @return
	 */
	public static List<String> createRequestClass(String qualifiedName,
			List<String[]> varsList ,List<String> linfo) {
		//检验参数数组数据完整性
		CreateRequestResponseOld.checkParamArr(varsList);
		List<String> l = new ArrayList<String>();
		String className = qualifiedName.substring(qualifiedName.lastIndexOf(".")+1);
		//1.添加包名头部信息
		l.addAll(CreateRequestResponseOld.createPackageInfo(qualifiedName, varsList));
		//2.添加类的注释
		l.addAll(CreateRequestResponseOld.createClassAnnotation(linfo,qualifiedName));
		l.add("public class "+className+" extends RequestVO{");
		//3.添加所有变量及其注释
		l.addAll(UtilNormal.table(CreateRequestResponseOld.createAllVariables(varsList),1));
		//4.添加构造方法及其注释
		l.addAll(UtilNormal.table(CreateRequestResponseOld.createConstructor(className)));
		//5.添加所有get方法及其注释
		l.addAll(UtilNormal.table(CreateRequestResponseOld.createAllGet(varsList, className)));
		l.add("}");
		l.add("");
		return l;
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 检验参数数组数据完整性 <br/>
	 * 如果你喜欢可以在这里添加其他验证~<br/>
	 * </ul>
	 * @param varsList
	 */
	protected static void checkParamArr(List<String[]> varsList) {
		int n = 1;
		for(String[] sArr : varsList){
			n++;
			for(int i = 0 ;i < 4 ; i++){
				if(null == sArr[i] || "".equals(sArr[i])){
					StringBuffer sb =new StringBuffer("参数 第 " + n + "行 数据完整性校验失败 ,请勿为null为空! --> ");
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
	 * <b>方法说明：</b>
	 * <ul>
	 * 创建包的信息(Request)
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
	 * <b>方法说明：</b>
	 * <ul>
	 * 创建包的信息(Response)
	 * </ul>
	 * @param qualifiedName 类全名
	 * @param varsList Response结果信息参数列表
	 * @param varsListInner Response结果信息内部类参数列表
	 * @return
	 */
	public static List<String> createPackageInfo2(String qualifiedName, List<String[]> varsList ,List<String[]> varsListInner) {
		List<String> l = new ArrayList<String>();
		String packageName = qualifiedName.substring(0, qualifiedName.lastIndexOf("."));
		l.add("package "+packageName+";");
		l.add("");
		
		l.add("import gnnt.MEBS.MobileServer.vo.ResponseVO;");
		//根据是否有查询结果集resultList判断是否import java.util.List;
		if(varsListInner != null && varsListInner.size() > 0){
			l.add("import java.util.List;");
		}else{
			varsListInner = new ArrayList<String[]>();
		}
		//日期 Date
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
	 * <b>方法说明：</b>
	 * <ul>
	 * 判断varsList是否包含数组中所含任一类型
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
	 * <b>方法说明：</b>
	 * <ul>
	 * 判断字段数组集合里是否包含某一变量
	 * </ul>
	 * @param varsList 字段数组集合
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
	 * <b>方法说明：</b>
	 * <ul>
	 * 创建构造方法
	 * </ul>
	 * @param string
	 * @return
	 */
	public static List<String> createConstructor(String className) {
		List<String> l = new ArrayList<String>();
		String head = className.substring(0, className.indexOf("RequestVO"));
		//TemplateQueryRequestVO
		l.add("/**");
		l.add(" * <b>构造方法</b>");
		l.add(" * <br/>");
		l.add(" */");
		l.add("public "+head+"RequestVO() {");
		l.add("	super();");
		l.add("}");
		l.add("");
		l.add("/**");
		l.add(" * <b>构造方法</b>");
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
	 * <b>方法说明：</b>
	 * <ul>
	 * 创建所有字段的定义和注解
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
	 * <b>方法说明：</b>
	 * <ul>
	 * 创建变量和其注解
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
	 * <b>方法说明：</b>
	 * <ul>
	 * 创建字段的注解
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
	 * <b>方法说明：</b>
	 * <ul>
	 * 创建成员变量
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
	 * <b>方法说明：</b>
	 * <ul>
	 * 生成全部get方法
	 * </ul>
	 * @param ls
	 * @return
	 */
	public static List<String> createAllGet(List<String[]> ls,String className) {
		List<String> l = new ArrayList<String>();
		//生成public ResponseVO getResponseVO()方法 及其注解
		String head = className.substring(0, className.indexOf("RequestVO"));
		l.add("@Override");
		l.add("public ResponseVO getResponseVO() {");
		l.add("	return new "+head+"ResponseVO();");
		l.add("}");
		l.add("");
		//根据Request里面的内容生成其他get方法和其注解
		for(String[] sArr : ls){
			l.addAll(CreateRequestResponseOld.createGet(sArr));
		}
		return l;
	}

	/**
	 * 
	 * <b>方法说明：</b>
	 * <ul>
	 * 创建Get方法体 及其注释
	 * </ul>
	 * @param sArr
	 * @return
	 */
	public static List<String> createGet(String[] sArr) {
		List<String> l = new ArrayList<String>();
		//如果是@Override的over就是了 O(∩_∩)O哈哈~
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
	 * <b>方法说明：</b>
	 * <ul>
	 * 创建所有set方法,根据RESULT里的返回值来
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
	 * <b>方法说明：</b>
	 * <ul>
	 * 直接创建一个含有set方法和注解的set集<br/>
	 * 没什么用处,算和get对应吧
	 * </ul>
	 * @param sArr
	 * @return
	 */
	public static Collection<? extends String> createSet(String[] sArr) {
		//如果是RETCODE 和 MESSAGE的话就不用返回方法了
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
	 * <b>方法说明：</b>
	 * <ul>
	 * 创建set方法注释
	 * </ul>
	 * @param sArr
	 * @return
	 */
	public static List<String> createSetAnnotate(String[] sArr) {
		List<String> l = new ArrayList<String>();
		l.add("/**");
		l.add(" * <b>方法说明：</b>");
		l.add(" * <ul>");
		l.add(" * 设置"+sArr[3]+"");
		
		l.add(" * </ul>");
		l.add(" * @param");
		l.add(" */");
		return l;
	}

	/**
	 * 
	 * <b>方法说明：</b>
	 * <ul>
	 * 创建get注释
	 * </ul>
	 * @param sArr
	 * @return
	 */
	public static List<String> createGetAnnotate(String[] sArr) {
		List<String> l = new ArrayList<String>();
		l.add("/**");
		l.add(" * <b>方法说明：</b>");
		l.add(" * <ul>");
		l.add(" * 获取"+sArr[3]+"");
		
		l.add(" * </ul>");
		l.add(" * @return");
		l.add(" */");
		return l;
	}


	/**
	 * 
	 * <b>方法说明：</b>
	 * <ul>
	 * 生成set方法
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
//			不是上面几种情况抛出运行时异常 ; 要嘛添加对应类型;要么就是数据类型错误;
			throw new RuntimeException("Set Param is not Excepted!");
		}
		l.add(ret);
		l.add("}");
		l.add("");
		return l;
	}



	/**
	 * 
	 * <b>方法说明：</b>
	 * <ul>
	 * 生成get方法
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
//			不是上面几种情况抛出运行时异常 ; 要嘛添加对应类型;要么就是数据类型错误;
			throw new RuntimeException("Set Param is not Excepted!Find Here And add Type or Check your varaible type!");
		}
		l.add(ret);
		l.add("}");
		l.add("");
		return l;
	}
	
	
}
