package com.dn.helper;

import com.celestial.agniRadiance.EzUtil.Util_String;
import com.celestial.agniRadiance.entity.FileReader;
import com.celestial.agniRadiance.map.JavaToRS;
import com.celestial.butterflystorm.butterfly2017.espotSysn.Util_sepotSysn;

@SuppressWarnings("unused")
public class FileReadAndOP {

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param args 
	 */
	public static void main(String[] args) {
//		_01_();
//		_02_();
		readVariable();
//		createSetVariable();
//		createAppend();
//		_04_();
//		_05_();
		
	}

	private static void createAppend() {
		FileReader f = new FileReader("src/test/resources/helper/01tempUse.txt",false,"gbk");
		System.out.println(Util_sepotSysn.createAppend(f.getLineList()));
	}

	//l.add("");
	private static void _05_() {
		FileReader f = new FileReader("src/test/resources/helper/01tempUse.txt",true,"gbk");
		String s="";
		StringBuffer sb= new StringBuffer("new StringBuffer(\"\")\n");
		while(f.hasNext()){
			s = f.readLine();
			if(!"".equals(s))
				sb.append(".append(\""+s+"\").append(\" \")\n");
			else
				sb.append("\n");
		}
		sb.append(".toString();");
		System.out.println(sb.toString());
	}
	

	//json串
	private static void _04_() {
		FileReader f = new FileReader("src/test/resources/helper/中英对照.txt",false,"gbk");
		String s="";
		while(f.hasNext()){
			s = f.readLine();
			String[] sArr = s.split(":");
			if(sArr.length>1){
				System.out.println("\""+sArr[0]+"\":\""+sArr[1]+"\",");
			}else{
				System.out.println("");
			}
		}
	}

	//
	private static void readVariable() {
		FileReader f = new FileReader("src/test/resources/helper/01tempUse.txt",true,"gbk");
		String s="";
		int n = 0;
		while(f.hasNext()){
			s = f.readLine();
			if(s.startsWith("private ") && !s.contains("static")){
				n++;
				String[] arr = s.replaceAll(";", "").replaceAll("\\s+", " ").split(" ");
				String type = arr[1];
				s = " " + arr[2]+",";
				
				String zs = f.readBeforeLine1(2).replaceAll("\\*", "").replaceAll("/", "").replaceAll("\\s+", "");
				
				
//				s = "tradeVO.set"+Util_String.__transHeadToUpperCase(s)+"("+JavaToDB.MAP.get(type)+");";
				System.out.println(s+" --"+zs);
				if(n%4 == 0)
					System.out.println();
			}
			
		}
		System.out.println("共计：" +n);
	}
	
	private static void createSetVariable() {
		FileReader f = new FileReader("src/test/resources/helper/01tempUse.txt",true,"gbk");
		String s="";
		int n = 0;
		while(f.hasNext()){
			s = f.readLine();
			if(s.startsWith("private ") && !s.contains("static")){
				n++;
				String[] arr = s.replaceAll(";", "").replaceAll("\\s+", " ").split(" ");
				String type = arr[1];
				s = arr[2];
				String param = s;
				
				String zs = f.readBeforeLine1(2).replaceAll("\\*", "").replaceAll("/", "").replaceAll("\\s+", "");
				
				
				s = "orderVO.set"+Util_String.__transHeadToUpperCase(s)+"("+JavaToRS.MAP.get(type).replaceAll("ARG", param)+");";
				System.out.println(s);
				if(n%4 == 0)
					System.out.println();
			}
			
		}
		System.out.println("共计：" +n);
	}

	//json串
	protected static void _02_() {
		FileReader f = new FileReader("src/test/resources/helper/01tempUse.txt",false,"gbk");
		
		StringBuffer sb = new StringBuffer("{");
		while(f.hasNext()){
			String s = f.readLine();
			if("".equals(s))
				sb.append("\n");
			else{
				String key = s.split(" ")[0];
				sb.append("\"").append(key).append("\"").append(":0,");
			}
		}
		sb.append("}");
		System.out.println(sb.toString());
	}

	//去尾
	protected static void _01_() {
		FileReader f = new FileReader("src/test/resources/helper/01tempUse.txt",true,"gbk");
		String s="";
		while(f.hasNext()){
			s = f.readLine();
			if(s.indexOf("(") < 0){
				System.out.println("");
				continue;
			}
			
			System.out.println(Util_String.subStringLastChar(s, ","));
		}
	}

}
