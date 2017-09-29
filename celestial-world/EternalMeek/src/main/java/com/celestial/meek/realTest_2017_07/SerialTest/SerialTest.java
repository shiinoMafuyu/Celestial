/******************************************************************
 * SerialTest.java
 * Copyright 2017 by WZG. All Rights Reserved.
 * CreateDate��2017��7��23��
 * Author��wangzg
 * Version��1.0.0
 ******************************************************************/

package com.celestial.meek.realTest_2017_07.SerialTest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * <b>�޸ļ�¼��</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2017��7��23��
 * </li>
 * </p>
 * 
 * <b>��˵����</b>
 * <p> 
 * 
 * </p>
 */
public class SerialTest {


    public static void main(String[] args) {
    	String path = "src/main/java/com/celestial/meek/realTest_2017_07/SerialTest/testfile/Object.txt";
    	write(path);
    	Person p = (Person)deSerialize(path);
    	System.out.println(p);
    }


	/**
	 * <b>����˵����</b>
	 * <ul>
	 * 
	 * </ul> 
	 */
	private static void write(String path) {
		ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(path));
            Person robin = new Person("robin", 29);
            oos.writeObject(robin);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != oos) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
	}
	
	public static Object deSerialize(String path)
			 {
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream(path));
			return ois.readObject();
		}catch(Exception e){
			e.printStackTrace();
		}
		finally {
			if (null != ois)
				try {
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		return null;
	}
}
