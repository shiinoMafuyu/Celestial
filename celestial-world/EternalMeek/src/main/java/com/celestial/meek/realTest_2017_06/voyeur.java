/******************************************************************
 * afd.java
 * Copyright 2017 by WZG. All Rights Reserved.
 * CreateDate：2017-6-14
 * Author：wanzg
 * Version：1.0.0
 ******************************************************************/

package com.celestial.meek.realTest_2017_06;

import java.util.Observable;
import java.util.Observer;

/**
 * <b>修改记录：</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2017-6-14
 * </li>
 * </p>
 * 
 * <b>类说明：</b>
 * <p> 
 * 
 * </p>
 */
public class voyeur implements Observer{
	

	@Override
	public void update(Observable observable, Object obj) {
		System.out.println(String.format("name has change to --> %s", "dd"));
	}
	
	public static void main(String[] args) {
		voyeur vo = new voyeur();
		kitty ki = new kitty();
		ki.addObserver(vo);
		ki.addObserver(new Observer() {
			
			@Override
			public void update(Observable observable, Object obj) {
				System.out.println("-------------->");
				
			}
		});
		ki.setName("kurise");
		ki.setName("maya");
	}
}

class kitty extends Observable {
	
	private String name = "shinno";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;

		setChanged();
		notifyObservers(name);
	}
	
	
}