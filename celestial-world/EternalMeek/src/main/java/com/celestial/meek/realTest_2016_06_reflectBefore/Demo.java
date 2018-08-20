package com.celestial.meek.realTest_2016_06_reflectBefore;
import java.lang.reflect.Method;
  
public class Demo {  
    public static void main(String[] args) throws Exception {  
        Method p = System.out.getClass().getMethod("println", String.class);  
        for (int i = 0; i < 16; i++) {  
            p.invoke(System.out, "demo");  
        }  
        System.in.read(); // block the program  
        
    }  
}  
