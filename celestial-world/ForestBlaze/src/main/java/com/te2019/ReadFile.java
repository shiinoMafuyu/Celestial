package com.te2019;


import com.celestial.agniRadiance.entity.FileReader;

import java.io.File;

public class ReadFile {
    public static String path = "src/main/resources/";

    public static void main(String[] args) {

        FileReader f = new FileReader("ForestBlaze/a.html",false);
        changeToJavascriptArr(f);
    }

    private static void changeToJavascriptArr(FileReader f) {
        while (f.hasNext()) {
            System.out.println(String.format("'%s',", f.readLine()));
        }
    }
}
