package com.celestial.meek.realTest_2017_05;

import java.io.File;

import com.celestial.agniRadiance.EzUtil.UtilFile;
import com.celestial.agniRadiance.EzUtil.UtilString;

public class a2 {
	public static void main(String[] args) {
		boolean b = UtilString.matchAllSameRegx("<classpathentry kind=\"src\" path=\"src/account-src\"/>",
				"<classpathentry\\s+kind=\"src\"\\s+path=\"src/.*\"\\s*/>");
		System.out.println(b+"222222");
		String tail = "com/celestial/butterflystorm/butterfly2016/zaza/busFee/BusFee.class";
		UtilFile.copyByCmdDRS(new File("D:/GitHub/Celestial/celestial-world/EternalMeek/target/classes/"+tail),
				new File("E:/t/t29 工具开发/02补丁合并工具/04 公交费/"+tail));
		System.out.println("https://172.18.3.3/svn/PI/%E8%B5%84%E6%BA%90%E5%85%B1%E4%BA%AB/%E5%BC%80%E5%8F%91%E4%B8%89%E9%83%A8/%E6%BA%90%E4%BB%A3%E7%A0%81%E5%BA%93");
//		System.out.println(String.format("md5值一样：%s", "a16cddc192534b263cceea57850b5288".equals(Util_File.getMd5ByFile(new File("E:/BaiduYunDownload/site-1.10.13-1.9.x.zip")))));
//		System.out.println(String.format("md5值一样：%s", "a16cddc192534b263cceea57850b5288".equals(Util_File.getMd5ByFile(new File("E:/Download/site-1.10.13-1.9.x.zip")))));
	}
}
