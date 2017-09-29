/******************************************************************
 * ChangeRetcode.java
 * Copyright 2017 by WZG. All Rights Reserved.
 * CreateDate：2017年8月24日
 * Author：wangzg
 * Version：1.0.0
 ******************************************************************/

package com.celestial.butterflystorm.butterfly2017.codeSynchronous.use;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.celestial.agniRadiance.EzUtil.UtilFile;
import com.celestial.agniRadiance.EzUtil.UtilString;
import com.celestial.agniRadiance.abstracte.RecursiveDealFile;
import com.celestial.agniRadiance.entity.FileReader;

/**
 * <b>修改记录：</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2017年8月24日
 * </li>
 * </p>
 * 
 * <b>类说明：</b>
 * <p> 
 * 
 * </p>
 */
public class ChangeRetcode {

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param args 
	 */
	public static void main(String[] args) {
		List<String[]> repList = Arrays.asList(new String[][]{
			new String[]{"-311300110001","-3113001100010"},
			new String[]{"-311300115001","-3113001150010"},
			new String[]{"-311300119001","-3113001190010"},
			new String[]{"-311300119002","-3113001190020"},
			new String[]{"-311300119003","-3113001190030"},
			new String[]{"-311300119004","-3113001190040"},
			new String[]{"-311300119005","-3113001190050"},
			new String[]{"-311300119006","-3113001190060"},
			new String[]{"-311300119007","-3113001190070"},
			new String[]{"-311300119008","-3113001190080"},
			new String[]{"-311300119009","-3113001190090"},
			new String[]{"-311300125001","-3113001250010"},
			new String[]{"-311300129001","-3113001290010"},
			new String[]{"-311300129002","-3113001290020"},
			new String[]{"-311300129003","-3113001290030"},
			new String[]{"-311300129004","-3113001290040"},
			new String[]{"-311300129005","-3113001290050"},
			new String[]{"-311300129006","-3113001290060"},
			new String[]{"-311300129007","-3113001290070"},
			new String[]{"-311300129008","-3113001290080"},
			new String[]{"-311300129009","-3113001290090"},
			new String[]{"-311300129010","-3113001290100"},
			new String[]{"-311300129011","-3113001290110"},
			new String[]{"-311300129012","-3113001290120"},
			new String[]{"-311300129013","-3113001290130"},
			new String[]{"-311300129014","-3113001290140"},
			new String[]{"-311300120001","-3113001200010"},
			new String[]{"-311300135001","-3113001350010"},
			new String[]{"-311300139001","-3113001390010"},
			new String[]{"-311300139002","-3113001390020"},
			new String[]{"-311300139003","-3113001390030"},
			new String[]{"-311300139004","-3113001390040"},
			new String[]{"-311300139005","-3113001390050"},
			new String[]{"-311300139006","-3113001390060"},
			new String[]{"-311300139007","-3113001390070"},
		});
		String[] types = new String[]{"java","xml"};
		
		List<String> direcotorys = Arrays.asList(new String[]{
				"D:/workspace_final/02MyEclipse2013/05过五关斩六奖/forecast-core-service",
				"D:/workspace_final/02MyEclipse2013/05过五关斩六奖/forecast-frontend"
		});
		
		for(String dir : direcotorys){
			doSynchronous(dir,
					dir,
					repList,
					types);
		}
		
		
		
		
	}
	
	public static void doSynchronous(String path1,String path2,List<String[]> repList,String[] types) {
		
		RecursiveDealFile rd = new RecursiveDealFile(new File(path1)) {
			@Override
			public void doWork(File file) {
				FileReader f = new FileReader(file,"gbk",false);
				if(!UtilFile.isIntype(file,types))
					return;
				StringBuffer sb = new StringBuffer();
				while(f.hasNext()){
					sb.append(f.readLine()).append("\n");
				}
				String send = UtilString.subStringLastChar(sb.toString(), "\n");
				for(String[] pair : repList){
					send =  send.replaceAll(pair[0], pair[1]);
				}
				
				UtilFile.printFile(send, path2 + UtilString.fmtPathStr(file.getAbsolutePath()).substring(path1.length()),"gbk");
				System.out.println("修改保存完成：" + file.getName());
			}
		};
		
		rd.start();
		
	}

}
