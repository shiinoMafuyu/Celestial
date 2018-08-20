package com.celestial.meek.realTest_2016_09;

import com.celestial.agniRadiance.entity.FileReader;

public class teRmi {

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param args 
	 */
	public static void main(String[] args) {
		
		/*System.out.println("\u914d\u7f6e\u6ce8\u518c\u670d\u52a1ip\u5730\u5740");
		System.out.println("\u914d\u7f6e\u6ce8\u518c\u670d\u52a1\u76d1\u542c\u7aef\u53e3");*/
		
		/*System.out.println("---->");
		b:for(int i =0 ;i <100;i++){
			if(i %2 !=0)
				continue b;
			System.out.println(i);
		}*/
		/*teRmi t = new teRmi();
		t.smile((Object) "xx");
		List<String> l = new ArrayList<String>();
		l.add("xxx");
		t.smile(l);*/
		
		FileReader f = new FileReader("E:/anotherDeskTop/parese2/fall/c.txt",false,"utf-8");
		while(f.hasNext()){
			System.out.println("l.add(\"" + f.readLine() +"\");");
		}
		
	}


}
