package com.celestial.meek.realTest_2018_08;

import java.util.List;

import com.celestial.agniRadiance.EzUtil.UtilFile;
import com.celestial.agniRadiance.entity.FileReader;

public class ReadFile {

	public static void main(String[] args) {
		
		FileReader f = new FileReader(UtilFile.load("a.txt"),false);
		
		htmlCodeToArr(f.getLineList());
	}

	private static void htmlCodeToArr(List<String> line) {
		for(String si : line) {
			System.out.println(String.format("'%s',", si));
		}
		
	}

}
