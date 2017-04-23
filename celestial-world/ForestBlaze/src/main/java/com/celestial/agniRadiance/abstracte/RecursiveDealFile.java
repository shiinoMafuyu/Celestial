package com.celestial.agniRadiance.abstracte;

import java.io.File;

public abstract class RecursiveDealFile {
	
	private File recursiveFile = null;
	
	public RecursiveDealFile(File recursiveFile){
		this.recursiveFile = recursiveFile;
		
	}
	
	/**
	 * ���еݹ������<br/>
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
	 * ��ʼ����
	 */
	public  void start(){
		recursiveFile(recursiveFile);
	}

	/**
	 * �ļ�����ʽ��
	 * @param file
	 */
	public abstract void doWork(File file);
	
	
}
