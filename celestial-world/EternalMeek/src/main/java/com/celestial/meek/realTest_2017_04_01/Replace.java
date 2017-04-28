package com.celestial.meek.realTest_2017_04_01;

import java.util.Arrays;

import com.celestial.agniRadiance.EzUtil.Util_File;
import com.celestial.agniRadiance.entity.FileReader;

public class Replace {

	public static void main(String[] args) {
		FileReader f = new FileReader("D:/workspace4/db/c_right.sql", false, "gbk");//("D:/workspace4/db/c_right.sql")
		String save = "E:/t/t25_OTC现货/t18修改member、exchange/08更新备份2017-04-07/c_right.sql";
		StringBuffer sb = new StringBuffer("");
		while(f.hasNext()){
			sb.append(f.readLine()).append("\n");
		}
		String send = sb.toString();
		send = send.substring(0, send.length()-1)
						.replaceAll("占用保证金","占用交易履约保证金")
						.replaceAll("释放保证金","释放交易履约保证金")
						.replaceAll("交收保证金","交收履约保证金")
						.replaceAll("可用保证金","可用交易履约保证金")
						.replaceAll("冻结保证金","冻结交易履约保证金");
		Util_File.printFile(Arrays.asList(new String[]{send}), save,"gbk");
		System.out.println("完成！");
		System.out.println(send);
	}

}
