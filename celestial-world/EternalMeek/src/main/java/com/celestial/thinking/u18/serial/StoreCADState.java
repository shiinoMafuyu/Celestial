/******************************************************************
 * StoreCADState.java
 * Copyright 2017 by WZG. All Rights Reserved.
 * CreateDate：2017年8月16日
 * Author：wangzg
 * Version：1.0.0
 ******************************************************************/

package com.celestial.thinking.u18.serial;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * <b>修改记录：</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2017年8月16日
 * </li>
 * </p>
 * 
 * <b>类说明：</b>
 * <p> 
 * 
 * </p>
 */
public class StoreCADState {
	public static void main(String[] args) throws Exception {
		List<Class<? extends Shape>> shapeTypes = new ArrayList<Class<? extends Shape>>();
		// Add references to the class objects:
		shapeTypes.add(Circle.class);
		shapeTypes.add(Square.class);
		shapeTypes.add(Line.class);
		List<Shape> shapes = new ArrayList<Shape>();
		// Make some shapes:
		for (int i = 0; i < 10; i++)
			shapes.add(Shape.randomFactory());
		// Set all the static colors to GREEN:
		for (int i = 0; i < 10; i++)
			((Shape) shapes.get(i)).setColor(Shape.GREEN);
		// Save the state vector:
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("CADState.out"));
		
		out.writeObject(shapeTypes);
		Line.serializeStaticState(out);
		out.writeObject(shapes);
		
		// Display the shapes:
		System.out.println(shapes);
		System.out.println("===============\n\n\n");
		
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("CADState.out"));
		List<Class<? extends Shape>> inshapeTypes = (List)in.readObject();
		Line.deserializeStaticState(in);
		List<Shape> inShapes = (List<Shape>)in.readObject();
		System.out.println(inshapeTypes);
		System.out.println(inShapes);
		
		
	}
}
