package com.celestial.meek.realTest_2016_10;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.celestial.agniRadiance.EzUtil.UtilFile;
import com.celestial.agniRadiance.EzUtil.UtilString;
import com.celestial.agniRadiance.entity.FileReader;

public class Dbutil_play {

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param args 
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
//		测试文件读取
//		teFileReader();
		
		/**---------task01 辅助写RequestVO ResponseVO类 ;解析文本,并且把他们按所需格式打印出来;------------*/
		//解析e现货
		/*DBUtil3_parseTxt.paresSimpleAndShow("C:/Users/Administrator/Desktop/parese2/e现货.txt","",
				"9. ","^[0-9]+\\.\\s{1}.*");*/
		//解析竞价
		/*DBUtil3_parseTxt.paresSimpleAndShow("C:/Users/Administrator/Desktop/parese2/copyHere.txt","",
				"17 ","^[0-9]+\\s{1}.*");*/
		/**---------task02 辅助写RowMapper类 根据:PO类 ------------*/
		//生成RowMapper的set方法
		readFilePrintWhat("propertyPO","C:/Users/Administrator/Desktop/kimo`/f/" + "MyCmdQueryPO" 
				+ ".java");
		
		/**---------task03 生成PO类 根据:ResponseVO类------------*/
		//生成 PO类系列 把Response类放到C:/Users/Administrator/Desktop/kimo`/PO/下 ;全名填入下面就行;
		/*String filePath = "C:/Users/Administrator/Desktop/kimo`/vendo_response/MyCmdQueryResponseVO.java";
		String className = filePath.substring(filePath.lastIndexOf("/")+1, filePath.lastIndexOf("."));
		createPoClass(filePath,"gnnt.MEBS.MobileServer.vo.micro.trade." + className,"xxxx");*/
		
		


		

	}
	
	

	@SuppressWarnings("unused")
	private static void teFileReader() {
//		FileReader n = new FileReader("C:/Users/Administrator/Desktop/kimo`/vendo_response/MyCmdQueryResponseVO.java");
		FileReader n = new FileReader("C:/Users/Administrator/Desktop/parese2/copyHere.txt");
		
		//..<..>..<../..>.. ".*<{1}.*>{1}.*<{1}.*/{1}.*>{1}.*"
		Map<Integer,String> map = n.selectLineStartEndContainMap("", "", ".*<{1}.*>{1}.*<{1}.*>{1}.*");
		Map<Integer,String> map2 = n.selectLineStartEndContainMap("", "", ".*<{1}.*>{1}.*<{1}.*/{1}.*>{1}.*");
		/*for(Entry ei : map2.entrySet()){
			map.remove(ei.getKey());
		}
		
		for(Entry ei : map.entrySet()){
			System.out.println( ei.getKey() + "  ------>  " + ei.getValue());
		}*/
		
	}



	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 调用方法生成VO类  <br/>
	 * 正确的打开方式: <br/>
	 * 1)把对应的Response类放到 C:/Users/Administrator/Desktop/kimo`/vendo_response/ 下面 <br/>
	 * 2)把类的全名传入  <br/>
	 * 另 : 如果内部类的名字不是规范的形式,请手动填入那个类的名字,即参数InnerClassName <br/>
	 * 平时的话随便填无影响 <br/>
	 * </ul>
	 * @param qualifiedName 类的全名(依据文件的类的全名)
	 * @param InnerClassName 内部类的备用名
	 * @throws FileNotFoundException 
	 */
	@SuppressWarnings("unused")
	private static void createPoClass(String filePath,String qualifiedName, String InnerClassName) throws FileNotFoundException {

		String fileName = qualifiedName.substring(qualifiedName.lastIndexOf(".")+1);
		//解析文件获取变量数组
		List<String[]> l = voCreateHelper(filePath,InnerClassName);/**  --  2  --     */
		//根据变量数据生成PO类
		
	}



	@SuppressWarnings("unused")
	private static void checkMess(String filePath,String objName) {
		BufferedReader br = null;
		String start[] =new String[]{ "public" ,"void" ,"set"};
		int n = 0;
		int bl = 0;
		List<String> bs = new ArrayList<String>();
		List<String> ma = new ArrayList<String>();
 		Map<String,String> map = new LinkedHashMap<String, String>();
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
			String s = null;
			String s0 = null;
			String methodKeyWords = null;
			while((s = br.readLine()) != null){
				s = s.trim();
				
				if(s.startsWith("private ") && s.contains(";") && s.split(" ").length == 3){
					bl++;
					bs.add(s.split(" ")[2].replace(";", ""));
				}
				
				String[] temp = s.split(" ");
				if(start[0].equals(temp[0]) && start[1].equals(temp[1]) && temp[2].startsWith(start[2])){
					s0 = s.substring(s.indexOf("set") , s.indexOf("("));
					methodKeyWords = s.substring(s.indexOf("set") + 3, s.indexOf("("));
					String[] sArr = s.substring(s.indexOf("(")+1, s.indexOf(")")).split(" ");
					String sx = objName + "." + s0 + "(rs.get" + sArr[0] + "(\"" + UtilString.transHeadToLowerCase(methodKeyWords) + "\"));";
					n++;
					
					s = br.readLine();
					
					for(String si : bs){
						if(s.contains(si)){
//							ma.add(si + "  -->  " + s);
							if(map.get(si)!=null){
								System.out.println("-----------------> "+si +"  --  " + map.get(si) + s);
							}else{
								map.put(si, s);
							}
						}
					}
					
					System.out.println(sx);
					
				}
			}
			System.out.println("set方法: " + n);
			System.out.println("变量: " + bl);
			
			for(String si : bs){
				if(map.get(si) != null){
//					System.out.println("缺失     -------->  " + si);
					System.out.println(si + "----------->" + map.get(si));
				}
			}
			
		} catch (Exception e) {
			 e.printStackTrace();
			 throw new RuntimeException("today i get up early but nothing happen~");
		}
		finally{
			UtilFile.close(br);
		}
		
	}

	//生成 PO类系列
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 把对文件的解析结果放到List<String>中 <br/>
	 * </ul>
	 * @param filePath 文件路径
	 * @param bf 备用类名
	 * @return
	 */
	public static List<String[]> voCreateHelper(String filePath,String bf) {
		List<String[]> l = new ArrayList<String[]>();
		String className = filePath.substring(filePath.lastIndexOf("/")+1, filePath.indexOf(".java"));
		String classObj = className.substring(0, className.indexOf("ResponseVO"))+"Obj";
		String zhuShi = "";
		boolean nextLineIsZhuShi = false;
		Boolean flag = false;
		BufferedReader br = null;
		String start[] =new String[]{ "public" ,"void" ,"set"};
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
			String s = null;
			String s0 = null;
			while((s = br.readLine()) != null){
				s = s.trim();
				if(s.startsWith("* <ul>")){
					nextLineIsZhuShi = true;
					continue;
				}
					
				if(nextLineIsZhuShi){
					zhuShi = s.substring(s.indexOf("*")+1).trim();
					if(zhuShi.contains("设置")){
						zhuShi = zhuShi.substring(zhuShi.indexOf("设置")+2);
					}
					nextLineIsZhuShi = false;
				}
				
				if(!flag && hasFindClass(s,classObj,bf)){
					flag =  true;
				}
				if(!flag)
					continue;
				//{"TotalRecords","Integer","总记录数"}
				String[] temp = s.split(" ");
				if(temp.length <3)
					continue;
				if(start[0].equals(temp[0]) && start[1].equals(temp[1]) && temp[2].startsWith(start[2])){
					s0 = s.substring(s.indexOf("set") , s.indexOf("("));//方法名
					String[] sArr = s.substring(s.indexOf("(")+1, s.indexOf(")")).split(" ");//类型 + 变量名(括号中内容)
					l.add(new String[]{s0.substring(s0.indexOf("set")+3),sArr[0],zhuShi});
					
				}
			}
		} catch (Exception e) {
			 e.printStackTrace();
			 throw new RuntimeException("today i get up early but nothing happen~");
		}
		finally{
			UtilFile.close(br);
		}
		return l;
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 看下找到类了吗
	 * </ul>
	 * @param s 要验证的字符串
	 * @param classObj 类名
	 * @param bf 类名备份
	 * @return
	 */
	private static boolean hasFindClass(String s, String classObj, String bf) {
		boolean b = false;
		String[] findArr = s.split(" ");
		if(findArr.length >= 3){
			if("public".equals(findArr[0]) && "class".equals(findArr[1]) ){
				try {
					String tail0 = findArr[2];
					String tail = null;
					if(tail0.contains("{")){
						tail = tail0.substring(0, tail0.lastIndexOf("{")).trim();
					}else{
						tail = tail0.split(" ")[0].trim();
					}
					if(tail.equals(classObj) || tail.equals(bf)){
						b = true;
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return b;
	}



	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 创建RowMapper类时,里面需要些大量setXXX(request.getParamter("XXX"))
	 * 这个方法用来获取那些语句<br/>
	 * </ul>
	 * @param objName 实例名字
	 * @param filePath RequestVO路径
	 */
	public static void readFilePrintWhat(String objName, String filePath) {
		BufferedReader br = null;
		String start[] =new String[]{ "public" ,"void" ,"set"};
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
			String s = null;
			String s0 = null;
			String methodKeyWords = null;
			while((s = br.readLine()) != null){
				s = s.trim();
				String[] temp = s.split(" ");
				if(start[0].equals(temp[0]) && start[1].equals(temp[1]) && temp[2].startsWith(start[2])){
					s0 = s.substring(s.indexOf("set") , s.indexOf("("));
					methodKeyWords = s.substring(s.indexOf("set") + 3, s.indexOf("("));
					String[] sArr = s.substring(s.indexOf("(")+1, s.indexOf(")")).split(" ");
					String sx = objName + "." + s0 + "(rs.get" + sArr[0] + "(\"" + UtilString.transHeadToLowerCase(methodKeyWords) + "\"));";
					System.out.println(sx);
					
				}
			}
		} catch (Exception e) {
			 e.printStackTrace();
			 throw new RuntimeException("today i get up early but nothing happen~");
		}
		finally{
			UtilFile.close(br);
		}
	}
	
	
	@SuppressWarnings("unused")
	private static void calculateSalary(double x, double total) {
		/*double x =0;
		double total = 21.75;*/
		System.out.println((3600/total)*x+(4500/total)*(total-x));
	}
	
}
