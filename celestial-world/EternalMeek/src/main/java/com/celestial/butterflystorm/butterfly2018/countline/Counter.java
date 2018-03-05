package com.celestial.butterflystorm.butterfly2018.countline;

import java.io.File;
import java.io.InputStream;
import java.util.List;

import com.celestial.agniRadiance.EzUtil.UtilFile;
import com.celestial.agniRadiance.entity.FileReader;

public class Counter {
	
	
	public static void main(String[] args) {
		List<String> files = UtilFile.findFile( ".*\\.java",new File("H:\\baiduyundownload\\五关六将"));
		FileReader fr = null;
		int lineNum =0;
		for(String fi:files) {
			fr = new FileReader(fi);
			lineNum += fr.getLineList().size();
		}
		System.out.println("文件数：" + files.size()+"  行数："+lineNum);
		
		InputStream is;
	}
}
