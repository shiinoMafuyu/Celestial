package com.celestial.meek.reaLTest_2017_01;

import java.io.File;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.celestial.agniRadiance.EzUtil.UtilFile;
import com.celestial.agniRadiance.EzUtil.UtilString;
import com.celestial.agniRadiance.entity.FileReader;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class mavenMD5 {
	
	@BeforeClass
	public static void setupBeforeClass() {
		
	}
	
	@AfterClass
	public static void teardownAfterClass() {
		
	}
	
	@Test
	public void _01showFileMd5(){
		boolean b = "b69a7d94a045430a1d8216950cb27199".equals(UtilFile.getMd5ByFile(new File("E:/Download/wechat_web_devtools_0.7.0_x64.exe")));
		System.out.println("_01showFileMd5:"+b);
	}
	
	@Ignore
	@Test
	public void _02showJsonCreator(){
		/**帮助生成一条json对象数据*/
		FileReader f = new FileReader("C:/Users/Administrator/Desktop/2.txt");
		while(f.hasNext()){
			String s = f.readLine();
			if(UtilString.matchHeadRegx(s, ".*<{1}.*>{1}.*")){
				s = s.substring(s.indexOf("<")+1,s.indexOf(">"));
				if(!s.contains("/"))
					System.out.println("\""+s+"\":\"\",");
			}
		}
	}
	
	@Ignore
	@Test
	public void _03classVariableHelper(){
//		li double(11,2) default 0,
//		wg double(11,2),
		/**根据sql自动生成类的*/
		FileReader f = new FileReader("C:/Users/Administrator/Desktop/1.sql");
		while(f.hasNext()){
			String s = f.readLine();
			if(null!=s && !"".equals(s)){
				String sArr[] = s.split(" ");
//				System.out.println(sArr[0]+" int(11),");
				if(sArr[1].contains("int"))
					System.out.println("private Integer "+sArr[0]+";");
				else if(sArr[1].contains("double"))
					System.out.println("private Double "+sArr[0]+";");
				else if(sArr[1].contains("char"))
					System.out.println("private String "+sArr[0]+";");
			}
		}
	}
	
	@Ignore
	@Test
	public void _03classVariableCompare(){
		String s1 ="representId,suitId,name,level,li,min,zhi,ti,wg,yz,xy,xyDK,zm,zmDK,mg,mf,hp,wf,yzDK,gg,hg,sg,ag,zz,ydsd,li_,min_,zhi_,ti_,wg_,yz_,xy_,xyDK_,zm_,zmDK_,mg_,mf_,hp_,wf_,yzDK_,ydsd_";
		String s2 ="?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?";
		System.out.println(s1.split(",").length);
		System.out.println(s2.split(",").length);
		System.out.println("---------------------------------");
		
		String s3 ="representId,suitId,name,level,li,min,zhi,ti,wg,yz,xy,xyDK,zm,zmDK,mg,mf,hp,wf,yzDK,gg,hg,sg,ag,zz,ydsd,li_,min_,zhi_,ti_,wg_,yz_,xy_,xyDK_,zm_,zmDK_,mg_,mf_,hp_,wf_,yzDK_,ydsd_";
		String s4 ="#{suitId},#{name},#{level},#{li},#{min},#{zhi},#{ti},#{wg},#{yz},#{xy},#{xyDK},#{zm},#{zmDK},#{mg},#{mf},#{hp},#{wf},#{yzDK},#{gg},#{hg},#{sg},#{ag},#{zz},#{ydsd},#{li_},#{min_},#{zhi_},#{ti_},#{wg_},#{yz_},#{xy_},#{xyDK_},#{zm_},#{zmDK_},#{mg_},#{mf_},#{hp_},#{wf_},#{yzDK_},#{ydsd_}";
		System.out.println(s3.split(",").length);
		System.out.println(s4.split(",").length);
		
		String s5="#{representId},#{suitId},#{name},#{level},#{li},#{min},#{zhi},#{ti},#{wg},#{yz},#{xy},#{xyDK},#{zm},#{zmDK},#{mg},#{mf},#{hp},#{wf},#{yzDK},#{gg},#{hg},#{sg},#{ag},#{zz},#{ydsd},#{li_},#{min_},#{zhi_},#{ti_},#{wg_},#{yz_},#{xy_},#{xyDK_},#{zm_},#{zmDK_},#{mg_},#{mf_},#{hp_},#{wf_},#{yzDK_},#{ydsd_}";
		System.out.println(s5.split(",").length);
	}
	
	@Ignore
	@Test
	public void _03classMethodUse(){
		List<String> fArr =UtilFile.findFile(".*html",new File("\"D:/GitHub/DN/DN/src/main/webapp\""));
		for(String f:fArr){
			System.out.println(new File(f).getAbsolutePath());
		}
		
		//E:/t/t19Util持续开发/t01FileReader元素替换/1.txt
		//E:/t/t19Util持续开发/t01FileReader元素替换/1.txt
	}
	
	@Test
	public void _04fileReaderReplace(){
		FileReader f = new FileReader("E:/t/t19Util持续开发/t01FileReader元素替换/1.txt");
		while(f.hasNext()){
			System.out.println(f.readLine());
		}
		
		
		int a = f.getRegexPosition("<!-- auto import start-->");
		int b = f.getRegexPosition("<!-- auto import end-->");
		System.out.println(a+" "+b);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
