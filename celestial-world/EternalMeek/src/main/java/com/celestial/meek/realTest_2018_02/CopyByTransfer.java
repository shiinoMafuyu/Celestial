package com.celestial.meek.realTest_2018_02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.channels.FileChannel;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class CopyByTransfer {

	public static void main(String[] args) throws IOException {
		
//		System.out.println("拷贝电影用时："+
//		copyByTransfer(new File("H:\\baiduyundownload\\04低幼动画\\末日时你在做什么忙吗可以拯救一下吗\\01.mp4")
//				, new File("H:\\baiduyundownload\\04低幼动画\\末日时你在做什么忙吗可以拯救一下吗\\002.mp4")));
		
		Map<String,Integer> map = readFile(new File("H:\\t\\08 简历\\要背的题\\name.txt"));
		List<Person> list = sortName(map);
		System.out.println(list);
	}
	
	private static List<Person> sortName(Map<String, Integer> map) {
		CopyByTransfer ct = new CopyByTransfer();
		List<Person> list = new ArrayList<>();
		for(Entry<String, Integer> en : map.entrySet()) {
			Person ps = ct.new Person(en.getKey(), en.getValue());
			list.add(ps);
		}
		
		list.sort(new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				if(o1.count < o2.count)
					return 1;
				else
					return -1;
			}
		});
		
		return list;
	}

	@SuppressWarnings("resource")
	public static void copy(File f1,File f2) throws IOException {
		FileChannel inC = new FileInputStream(f1).getChannel();
		FileChannel outC = new FileOutputStream(f2).getChannel();
		int length=0,copysize = 200000;
		while(true) {
			if(inC.position() == inC.size()) {
				inC.close();
				outC.close();
				return;
			}
			if(inC.size()-inC.position() < copysize) {
				length = (int)(inC.size()-inC.position());
			}else {
				length = copysize;
			}
			inC.transferTo(inC.position(), length, outC);
			inC.position(inC.position()+length);
		}
	}
	
	@SuppressWarnings("resource")
	public static long copyByTransfer(File f1,File f2) throws IOException {
		Timestamp start = new Timestamp(System.currentTimeMillis());
		FileChannel inC = new FileInputStream(f1).getChannel();
		FileChannel outC = new FileOutputStream(f2).getChannel();
		int len=0,copySize = 4 * 1024;
		while(true) {
			
			if(inC.position() == inC.size()) {
				inC.close();
				outC.close();
				return System.currentTimeMillis() - start.getTime();
			}
			if(inC.size() - inC.position() > copySize) {
				len = copySize;
			}else {
				len = (int)(inC.size() - inC.position()); 
			}
			
			inC.transferTo(inC.position(), len, outC);
			inC.position(inC.position()+len);
			
		}
		
	}
	
	public static Map<String,Integer> readFile(File file){
		Map<String,Integer> map = new HashMap<>();
		BufferedReader br =null;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
			String s = null;
			while((s = br.readLine()) != null) {
//				System.out.println(s);
				String[] msgArr = s.split(",");
				if(msgArr!=null && msgArr.length ==3 ) {
					String key = msgArr[1];
					Integer val = map.get(key);
					if(val == null)
						val =0;
					map.put(key, val+1);
				}
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			if(br!=null)
				try {
					br.close();
				}catch(Exception e) {}
		}
		return map;
	}
	
	class Person{
		String name;
		int count;
		public Person(String name,int count) {
			this.name = name;
			this.count =count;
		}
		
		public String toString() {
			return String.format("name:%s , count:%s", name,count);
		}
	}

}
