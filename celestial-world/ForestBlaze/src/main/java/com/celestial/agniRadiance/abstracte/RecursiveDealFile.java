package com.celestial.agniRadiance.abstracte;

import java.io.File;

public abstract class RecursiveDealFile {
	
	private File recursiveFile = null;
	
	public RecursiveDealFile(File recursiveFile){
		this.recursiveFile = recursiveFile;
		
	}
	
	/**
	 * 进行递归遍历。<br/>
	 * @param file
	 */
	private  void recursiveFile(File file,Object...obs){
		if(file.isDirectory()){
			File[] fArr = file.listFiles();
			for(File fi : fArr){
				recursiveFile(fi);
			}
		}else{
			doWork(file);
		}
		
	}
	
	/**
	 * 开始处理
	 */
	public  void start(){
		recursiveFile(recursiveFile);
	}

	/**
	 * 文件处理方式。
	 * @param file
	 */
	public abstract void doWork(File file);
	
	
}
