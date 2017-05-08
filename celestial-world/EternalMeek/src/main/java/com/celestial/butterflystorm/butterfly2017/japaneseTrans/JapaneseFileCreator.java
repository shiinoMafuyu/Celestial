package com.celestial.butterflystorm.butterfly2017.japaneseTrans;

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
		JapaneseFileCreator.createStudyFile("H:/�ҵļ����/09temp/03JP/01����ѡ�ĳ��þ���.txt");
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
		Util_File.printFile(l_no_annotion, saveDirectory+"/StudyFile/01������ע��.txt");
		Util_File.printFile(l_no_fanyi, saveDirectory+"/StudyFile/02�����޷���.txt");
		Util_File.printFile(f.getLineList(), saveDirectory+"/StudyFile/03����ȫ��.txt");
		
	}
	
	

}
