package com.celestial.meek.realTest_2016_09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TeCh extends TeFa {

	protected List<String> l = new ArrayList<String>(Arrays.asList(new String[]{"威风","堂堂"}));
	protected String s = "狂风堂堂";
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param args 
	 */
	public static void main(String[] args) {
		TeCh t= new TeCh();
		System.out.println(t.s);
		System.out.println(t.l);
		
		t.show();
	}
	private void show() {
		System.out.println(super.s);
		System.out.println(super.l);
	}

}
