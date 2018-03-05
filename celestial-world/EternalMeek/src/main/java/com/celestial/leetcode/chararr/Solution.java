/******************************************************************
 * Solution.java
 * Copyright 2017 by WZG. All Rights Reserved.
 * CreateDate£º2017Äê10ÔÂ12ÈÕ
 * Author£ºwangzg
 * Version£º1.0.0
 ******************************************************************/

package com.celestial.leetcode.chararr;

//Please implement the serializer and deserializer for char array below.
//For char arrays, we follow the JSON standard according to http://www.json.org/
//Therefore, a single character A is represented as "A" (wrapped in double quotes instead of single quotes).
//A char array containing 3 elements "A", "B", "C" is represented in string as ["A","B","C"].
//For the purpose of this problem, you must not use JSON parser library or eval method. 
//Standard library provided by the language (not including JSON library) is allowed.
public class Solution {

    public static String charArrayToString(char[] param) throws Exception {
//        throw new Exception("Function Not implemented yet.");
    	String str = String.valueOf(param);
    	return str;
    }

    // Bonus point if your deserializer is able to deal with whitespaces between elements.
    // For example: param = "[  \"a\",  \"b\", \"c\"  ]"
    public static char[] stringToCharArray(String param) throws Exception {
//        throw new Exception("Function Not implemented yet.");
    	char[] arr = param.toCharArray();
    	return arr;
    }

    // Note: These tests are basic and passing them does not mean your code is correct.
    // Feel free to write additional tests and test serializer and deserializer individually.
    public static void main(String[] args) {
        String[] testcases = {
            "[]",
            "[\"a\",\"b\",\"c\"]",
            "[\"T\",\"e\",\"!\",\"'\"]",
            "[\"'\",\"\\\"\",\"c\"]",
            "[\"\\n\",\"\\t\",\"'\",\"\\\"\",\"\\\\\"]"
        };

        for(String testcase : testcases) {
            try {
                if (!charArrayToString(stringToCharArray(testcase)).equals(testcase)) {
                    System.out.println("TESTCASE FAILED : {}" + testcase);
                } else {
                    System.out.println("TESTCASE PASSED");
                }
            } catch(Exception e) {
                System.out.println("Exception occured in testcase : " + testcase);
                break;
            }
        }
    }
}
