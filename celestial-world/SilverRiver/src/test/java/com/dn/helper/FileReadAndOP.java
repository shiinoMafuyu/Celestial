package com.dn.helper;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.celestial.agniRadiance.EzUtil.UtilString;
import com.celestial.agniRadiance.entity.FileReader;
import com.celestial.agniRadiance.entity.Tag;
import com.celestial.agniRadiance.map.JavaToRS;
import com.celestial.butterflystorm.butterfly2017.espotSysn.Util_sepotSysn;
import com.dn.dao.QueryCharactorDao;

@SuppressWarnings("unused")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FileReadAndOP {
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 
	 * </ul> 
	 */
	@Ignore
	@Test
	public void _02_readTagString() {
		System.out.println("==========================================\n\n\n");
		FileReader f = new FileReader("src/test/resources/helper/01tempUse.txt",false,"gbk");
		String si="";
		while(f.hasNext()){
			si = f.readLine();
			System.out.println("\""+si.replaceAll("\"", "\\\\\"")+"\" + ");
		}
		printDivide("_02_readTagString");
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 
	 * </ul> 
	 */
	@Test
	public void _03_createVariable() {
		FileReader f = new FileReader("src/test/resources/helper/01tempUse.txt",false,"gbk");
		String si="";
		String t1 = "ref=",t2 = "type=",m = "\"",m2 = ">",m3="<";
		while(f.hasNext()){
			si = f.readLine();
			String va = UtilString.getMatchIn(si, m, m, si.indexOf(t1));
			String ty = UtilString.getMatchIn(si, m, m, si.indexOf(t2));
			String ano = UtilString.getMatchIn(si, m2, m3, si.indexOf(m2));
			System.out.println(String.format("/** %s */\nprivate %s %s;\n",ano,ty,va));
		}
		printDivide("_03_createVariable");
	}

	@Test
	public void _04_createAppend() {
		FileReader f = new FileReader("src/test/resources/helper/01tempUse.txt",false,"gbk");
		System.out.println(Util_sepotSysn.createSQlAppend(f.getLineList()));
		
		printDivide("_04_createAppend");
	}
	
	@Test
	public void _04_02_createAppend() {
		FileReader f = new FileReader("src/test/resources/helper/01tempUse.txt",false,"gbk");
		String res = Util_sepotSysn.createSQlAppend(f.getLineList()).substring("String sql = ".length());
		
		System.out.println(res);
		
		printDivide("_04_02_createAppend");
	}

	//l.add("");
	@Ignore
	@Test
	public void _05_() {
		FileReader f = new FileReader("src/test/resources/helper/01tempUse.txt",true,"gbk");
		String si="";
		String[] sArr = new String[]{"",""};
		StringBuffer sb= new StringBuffer("new StringBuffer(\"\")\n");
		while(f.hasNext()){
			si = f.readLine();
			if(!"".equals(si)){
				if(si.contains("--")){
					sArr = si.split("--");
					sArr[1] = "//" + sArr[1];
				}
				else{
					sArr[0] = si;
					sArr[1] = "";
				}
				sb.append(".append(\""+sArr[0]+"\").append(\" \")+//"+sArr[1]+"\n");
			}
				
			else
				sb.append("\n");
		}
		sb.append(".toString();");
		System.out.println(sb.toString());
		
		printDivide("_05_");
	}
	

	
	//json串
	@Ignore
	@Test
	public void _06_() {
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
		
		printDivide("_06_");
	}

	@Test
	public void _07_readVariable() {
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
				
				
//				s = "tradeVO.set"+Util_String.transHeadToUpperCase(s)+"("+JavaToDB.MAP.get(type)+");";
				System.out.println(s+" --"+zs);
				if(n%4 == 0)
					System.out.println();
			}
			
		}
		System.out.println("共计：" +n);
		
		printDivide("_07_readVariable");
	}
	
	@Test
	public void _08_createSetVariable() {
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
				
				
				s = "orderVO.set"+UtilString.transHeadToUpperCase(s)+"("+JavaToRS.MAP.get(type).replaceAll("ARG", param)+");";
				System.out.println(s);
				if(n%4 == 0)
					System.out.println();
			}
			
		}
		System.out.println("共计：" +n);
		
		printDivide("_08_createSetVariable");
	}

	//json串
	@Test
	public void _09_addAnnotion() {
		FileReader f = new FileReader("src/test/resources/helper/01tempUse.txt",false,"gbk");
		
		while(f.hasNext()){
			String s = f.readLine();
			System.out.println("\""+s+"\",");
		}
		
		printDivide("_09_addAnnotion");
	}

	//去尾
	@Test
	public void _10_() {
		FileReader f = new FileReader("src/test/resources/helper/01tempUse.txt",false,"gbk");
		String s="";
		while(f.hasNext()){
			s = f.readLine();
			System.out.println("l.add(\""+s+"\");");
		}
		
		printDivide("_10_");
	}
	
	@Test
	public void _11_readVariableTas() {
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
				
				String zs = f.readBeforeLine1(2).replaceAll("\\*", "").replaceAll("/", "").replaceAll("\\s+", "");
				
				
//				s = "tradeVO.set"+Util_String.transHeadToUpperCase(s)+"("+JavaToDB.MAP.get(type)+");";
				System.out.println("t." + s + " " + s + ", --" + zs);
				if(n%4 == 0)
					System.out.println();
			}
			
		}
		System.out.println("共计：" +n);
		
		printDivide("_11_readVariableTas");
	}
	
	
	@Test
	public void _12_replaceAll(){
		StringBuffer sb = new StringBuffer();
		FileReader f = new FileReader("src/test/resources/helper/01tempUse.txt",true,"gbk");
		
		List<String> list = f.selectLineStartEndContain("", "", "mins");
		
		
		Double total = 0.0;
		for(String s: list){
			Double mins = Double.parseDouble(s.replaceAll("mins", "").replaceAll(" ", ""));
			total += mins;
		}
		System.out.println("Total :" + total/60.0);
		
	}
	
	@Test
	public void _12_replaceAll2(){
		StringBuffer sb = new StringBuffer();
		FileReader f = new FileReader("src/test/resources/helper/01tempUse.txt",true,"gbk");
		while(f.hasNext()){
			String s = f.readLine();
			if(UtilString.notNullEmpty(s))
				System.out.println(String.format("new String[]{\"%s\",\"%s\"},", UtilString.subStringLast(s, 1),s));
		}
		printDivide("_12_replaceAll2");
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 
	 * </ul> 
	 * @param methodName 
	 */
	private void printDivide(String methodName) {
		System.out.println("============>> " + methodName + " >>========================================\n\n\n\n");
		
	}

}
