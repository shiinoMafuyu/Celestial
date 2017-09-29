package com.celestial.meek.realTest_2016_06_reflectBefore;

import java.io.File;
import java.util.Date;

import com.celestial.agniRadiance.EzUtil.UtilFile;
import com.celestial.agniRadiance.entity.FileReader;


@SuppressWarnings("unused")
public class te1 {

	public static void main(String[] args) {
		//ruleMyPuddingFile();
		//teLastCreateTime();
//		teGetCreateTime();
		
		/*te1 t = new te1();
		Object o = t.new HH();*/
		teQuanJiaoBanJiao();
		System.out.println("<CU>閿燂拷/CU>".equals("<CU>閿燂拷/CU>"));
	}
	
	private static void teQuanJiaoBanJiao() {
		FileReader f = new FileReader("C:/Users/Administrator/Desktop/parese2/缁佺偟绮￠敓锟絫xt",false,"gbk");
		String s = null;
		while(f.hasNext()){
			s = f.readLine();
			boolean b = s.contains("x") || s.contains("x") || s.contains("x");
//			boolean b = s.contains("閿燂拷) || s.contains("閿燂拷) || s.contains("閿燂拷);
//			boolean b =true;
			if(b)
				System.out.println(s);
		}
	}

	private static void teGetCreateTime() {
//		DBUtil.getCreateTime("C:/Users/Administrator/Desktop/x/gt.txt");
		UtilFile.getCreateTime("C:\\Users\\Administrator\\Desktop\\x\\gt.txt");
		UtilFile.getCreateTime("C:\\Users\\Administrator\\Desktop\\x\\gt2.txt");
		UtilFile.getCreateTime("C:\\Users\\Administrator\\Desktop\\x\\gt3.txt");
		UtilFile.getCreateTime("C:\\Users\\Administrator\\Desktop\\x\\gt4.txt");
	}

	private static void teLastCreateTime() {
		File f1 = new File("C:/Users/Administrator/Desktop/x/gt.txt");
		File f2 = new File("C:/Users/Administrator/Desktop/x/gt2.txt");
		Date d1 = new Date( f1.lastModified());
		Date d2 = new Date( f2.lastModified());
		System.out.println(d1.toString());
		System.out.println(d2.toString());
		System.out.println(d1.before(d2));
	}

	private static void ruleMyPuddingFile() {
		File f = new File( "C:/Users/Administrator/Desktop/鐞涖儰绔甸敓锟藉ù瀣槸閺傚洣娆㈤弫鏉戞値");
		File[] files = f.listFiles();
		System.out.println("閺傚洣娆㈡稉顏呮殶 : "+files.length);
		int filesCount = 0;
		for(File i : files){
			File[] fi = i.listFiles();
			for(File j : fi){
				String name = j.getName();
				if("files".equals(name)){
					filesCount++;
				}
			}
		}
		System.out.println("閸忚精顓搁崥鐜les:" +filesCount +"   濞屸剝婀侀梻顕�顣�: "+(filesCount == files.length));
	}
	
	private HH h;
	public class HH{
		
	}
}
