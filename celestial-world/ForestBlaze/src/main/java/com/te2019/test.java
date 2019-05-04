package com.te2019;

import java.util.HashMap;
import java.util.Map;

public class test {

    public static void main(String[] args) {
        Map<String,String> methodMap = new HashMap<String,String>(){{
            put("a","长青岁月");
            put("b","黄赤交角");
        }};
        System.out.println(methodMap);
    }

}
