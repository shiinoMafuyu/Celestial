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
	 * <b>����˵����</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param args 
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
//		�����ļ���ȡ
//		teFileReader();
		
		/**---------task01 ����дRequestVO ResponseVO�� ;�����ı�,���Ұ����ǰ������ʽ��ӡ����;------------*/
		//����e�ֻ�
		/*DBUtil3_parseTxt.paresSimpleAndShow("C:/Users/Administrator/Desktop/parese2/e�ֻ�.txt","",
				"9. ","^[0-9]+\\.\\s{1}.*");*/
		//��������
		/*DBUtil3_parseTxt.paresSimpleAndShow("C:/Users/Administrator/Desktop/parese2/copyHere.txt","",
				"17 ","^[0-9]+\\s{1}.*");*/
		/**---------task02 ����дRowMapper�� ����:PO�� ------------*/
		//����RowMapper��set����
		readFilePrintWhat("propertyPO","C:/Users/Administrator/Desktop/kimo`/f/" + "MyCmdQueryPO" 
				+ ".java");
		
		/**---------task03 ����PO�� ����:ResponseVO��------------*/
		//���� PO��ϵ�� ��Response��ŵ�C:/Users/Administrator/Desktop/kimo`/PO/�� ;ȫ�������������;
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
	 * <b>����˵����</b>
	 * <ul>
	 * ���÷�������VO��  <br/>
	 * ��ȷ�Ĵ򿪷�ʽ: <br/>
	 * 1)�Ѷ�Ӧ��Response��ŵ� C:/Users/Administrator/Desktop/kimo`/vendo_response/ ���� <br/>
	 * 2)�����ȫ������  <br/>
	 * �� : ����ڲ�������ֲ��ǹ淶����ʽ,���ֶ������Ǹ��������,������InnerClassName <br/>
	 * ƽʱ�Ļ��������Ӱ�� <br/>
	 * </ul>
	 * @param qualifiedName ���ȫ��(�����ļ������ȫ��)
	 * @param InnerClassName �ڲ���ı�����
	 * @throws FileNotFoundException 
	 */
	@SuppressWarnings("unused")
	private static void createPoClass(String filePath,String qualifiedName, String InnerClassName) throws FileNotFoundException {

		String fileName = qualifiedName.substring(qualifiedName.lastIndexOf(".")+1);
		//�����ļ���ȡ��������
		List<String[]> l = voCreateHelper(filePath,InnerClassName);/**  --  2  --     */
		//���ݱ�����������PO��
		
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
			System.out.println("set����: " + n);
			System.out.println("����: " + bl);
			
			for(String si : bs){
				if(map.get(si) != null){
//					System.out.println("ȱʧ     -------->  " + si);
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

	//���� PO��ϵ��
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * �Ѷ��ļ��Ľ�������ŵ�List<String>�� <br/>
	 * </ul>
	 * @param filePath �ļ�·��
	 * @param bf ��������
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
					if(zhuShi.contains("����")){
						zhuShi = zhuShi.substring(zhuShi.indexOf("����")+2);
					}
					nextLineIsZhuShi = false;
				}
				
				if(!flag && hasFindClass(s,classObj,bf)){
					flag =  true;
				}
				if(!flag)
					continue;
				//{"TotalRecords","Integer","�ܼ�¼��"}
				String[] temp = s.split(" ");
				if(temp.length <3)
					continue;
				if(start[0].equals(temp[0]) && start[1].equals(temp[1]) && temp[2].startsWith(start[2])){
					s0 = s.substring(s.indexOf("set") , s.indexOf("("));//������
					String[] sArr = s.substring(s.indexOf("(")+1, s.indexOf(")")).split(" ");//���� + ������(����������)
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
	 * <b>����˵����</b>
	 * <ul>
	 * �����ҵ�������
	 * </ul>
	 * @param s Ҫ��֤���ַ���
	 * @param classObj ����
	 * @param bf ��������
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
	 * <b>����˵����</b>
	 * <ul>
	 * ����RowMapper��ʱ,������ҪЩ����setXXX(request.getParamter("XXX"))
	 * �������������ȡ��Щ���<br/>
	 * </ul>
	 * @param objName ʵ������
	 * @param filePath RequestVO·��
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
