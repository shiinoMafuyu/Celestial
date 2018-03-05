/******************************************************************
 * ABC.java
 * Copyright 2017 by WZG. All Rights Reserved.
 * CreateDate：2017年10月16日
 * Author：wangzg
 * Version：1.0.0
 ******************************************************************/

package com.celestial.meek.realTest_2017_10;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;

/**
 * <b>修改记录：</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2017年10月16日
 * </li>
 * </p>
 * 
 * <b>类说明：</b>
 * <p> 
 * 
 * </p>
 */
public class ABC {

    

    
    public static void main1(String[] args){
    	
    	System.out.println("\\\\s23");
        Scanner sc = new Scanner(System.in);
        int arrNum = sc.nextInt();
        
        List<int[]> arrList = new ArrayList<>();
        for(int i=0;i<arrNum;i++){
            arrList.add(getIntArr(sc));
        }
        
        for(int[] arr : arrList){
            printRe(arr);
        }
        
        
        
    }
    
    public static int[] getIntArr(Scanner sc){
        int num = sc.nextInt();
        int[] arr = new int[num];
        for(int i=0;i<num;i++){
            arr[i] = sc.nextInt();
        }
        return arr;
        
    }
    
    public static void printRe(int[] arr){
        int nOdd = 0,n2 = 0, n4 =0;
        for(int i=0;i<arr.length;i++){
            int va = arr[i];
            if(va %4==0){
                n4++;
            }else if(va %2 ==0){
                n2++;
            }else{
                nOdd ++;
            }
        }
        
        nOdd += (n2%2);
        if(n4 >= nOdd+1)
            System.out.print("true");
        else
            System.out.print("false");
    }
    
    @Test
    public void _06_(){
    	System.out.println((int)Integer.MAX_VALUE);
    	System.out.println((int)Character.MAX_VALUE);
    	char c ='の';
    	System.out.println("--->"+Integer.parseInt("10", 16));
    	System.out.println(c);
    	
    	char d ='ɰ';
    	System.out.println(d);
    	System.out.println("--->"+(char)Integer.parseInt("0270", 16));
    	System.out.println("--->"+(char)Integer.parseInt("0BF5", 16));
    	
    	System.out.println((int)'我');
    	
    	System.out.println("--->"+Integer.toHexString((int)'我'));
    	
    }

}
