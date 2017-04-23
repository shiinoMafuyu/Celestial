package com.shortterm.japanese;

import java.util.ArrayList;
import java.util.List;

import com.celestial.agniRadiance.EzUtil.Util_File;
import com.celestial.agniRadiance.EzUtil.Util_String;
import com.celestial.agniRadiance.entity.FileReader;

public class JapaneseFileCreator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JapaneseFileCreator.createStudyFile("H:/我的坚果云/09temp/03JP/01我自选的常用句子.txt");
	}

	private static void createStudyFile(String path) {
		FileReader f = new FileReader(path,false,"utf-8");
		
		List<String> l_no_annotion = new ArrayList<String>();
		List<String> l_no_fanyi = new ArrayList<String>();
		int i =0;
		String s ="";
		while(f.hasNext()){
			s = f.readLine();
			i =i%4 + 1;
			if(i==1){
				l_no_annotion.add(s+"\n");
				l_no_fanyi.add(s);
			}
			if(i == 2){
				l_no_fanyi.add(s+"\n");
			}
			
			
		}
		String saveDirectory = Util_String.__getStrBeforeLast(path, "/");
		Util_File.printFile(l_no_annotion, saveDirectory+"/StudyFile/01日语无注释.txt");
		Util_File.printFile(l_no_fanyi, saveDirectory+"/StudyFile/02日语无翻译.txt");
		Util_File.printFile(f.getLineList(), saveDirectory+"/StudyFile/03日语全有.txt");
		
	}
	
	

}
