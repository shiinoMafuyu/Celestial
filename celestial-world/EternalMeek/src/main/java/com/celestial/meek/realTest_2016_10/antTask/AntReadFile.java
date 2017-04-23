package com.celestial.meek.realTest_2016_10.antTask;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;

public class AntReadFile extends Task {
	
	private String filePath;
	
	public void execute() throws BuildException {
		System.out.println("start to execute self defineded task , now read file --> " + this.filePath);
		File f = new File(filePath);
		BufferedReader br = null;
		try {
			String s = null;
			br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
			while((s = br.readLine()) != null){
				System.out.println(s);
			}
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("读取文件异常.");
		}
		finally{
			if(br != null)
				try {
					br.close();
				} catch (IOException e) {}
		}
	}
	
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
}

