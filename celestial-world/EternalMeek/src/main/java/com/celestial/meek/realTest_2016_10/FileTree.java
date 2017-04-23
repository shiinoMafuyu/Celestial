package com.celestial.meek.realTest_2016_10;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;
/**
 * �ļ��� <br/>
 * �����޸Ŀ���չ��ԭ�� <br/>
 * �ٵ����Ĵ��� (0 0������ľ�Ȼ������!)
 * @author Administrator
 *
 */
public class FileTree {
	/**
	 * һ����֦
	 */
	private File treeBoot;
	/**
	 * ��֦�ϵ�Ҷ��
	 */
	private File[] treeLeaves;
	
	/**
	 * ��֦·��
	 */
	private String bootPath;
	/**
	 * ��Ҷ·��s
	 */
	private String[] leavesPaths;
	
	/**
	 * �Ƿ�����ļ�
	 * �ǵĻ�,Ŀ¼ �ļ�ȫ����
	 * �������ļ�����ȫ����Ŀ¼��
	 */
	private boolean isContainGreen = true;
	
	
	
	
	/**
	 * 
	 * @param bootPath ���ĸ�·��
	 */
	public FileTree(String bootPath) {
		init(bootPath);
	}
	/**
	 * @param bootPath
	 * @param isContainGreen �Ƿ�����ļ�
	 */
	public FileTree(String bootPath ,boolean isContainGreen) {
		init(bootPath,isContainGreen);
	}
	private void init(String bootPath) {
		init(bootPath,this.isContainGreen);
	}
	/**
	 * ֻ��ȡ���ĵ�ǰ���͵�ǰҶ��;��Ҫ��ʱ����ȥ����;
	 * @param bootPath
	 * @param isContainGreen
	 */
	private void init(String bootPath, boolean isContainGreen) {
		this.bootPath = bootPath ;
		this.isContainGreen = isContainGreen;
		
		this.treeBoot = new File(this.bootPath);
		
		final boolean needFile = this.isContainGreen;
		this.treeLeaves = this.treeBoot.listFiles(new FileFilter() {
			@Override
			public boolean accept(File pathname) {
				//�����Ҫ�ļ��ҵ�ǰfile���ļ�ʱ����false
				return needFile || pathname.isDirectory();
			}
		});
		
		this.leavesPaths = new String[this.treeLeaves.length] ;
		for(int i =0 ; i < this.treeLeaves.length ; i++){
			this.leavesPaths[i] = this.treeLeaves[i].getAbsolutePath().replaceAll("\\\\", "/");
		}
	}
	
	public File getTreeBoot() {
		return treeBoot;
	}
	public File[] getTreeLeaves() {
		return treeLeaves;
	}
	public String getBootPath() {
		return bootPath;
	}
	public String[] getLeavesPaths() {
		return leavesPaths;
	}
	public boolean isContainGreen() {
		return isContainGreen;
	}
	/**
	 * �ö����Ƿ�����t1��һ����
	 * @param t1
	 * @return
	 */
	public boolean isBelong(FileTree t1) {
		return t1.isContain(this);
	}
	/**
	 * �ö����Ƿ����t2<br/>
	 * ��ȫ����
	 * @param t2
	 * @return
	 */
	public boolean isContain(FileTree t2) {
		boolean contain = checkContain(t2.getBootPath(),this.bootPath);
		return false;
	}
	
	List<String> perhapsNodesList = new ArrayList<String>();
	private boolean checkContain(String bootPathPiece, String bootPathMain) {
		String bootPathPieceName = bootPathPiece.substring(bootPathPiece.lastIndexOf("/")+1);
		//�ҵ�ȫ��ͬ���ļ��� ��������list perhapsNodesList��
		getPerhapsNodes(bootPathPieceName,new File(bootPathMain));
		//��list������ȫһ��
		System.out.println("xxx");
		return false;
	}
	private void getPerhapsNodes(String bootPathPieceName, File fileMain) {
		if(bootPathPieceName.equals(fileMain.getName())){
			perhapsNodesList.add(fileMain.getAbsolutePath().replace("\\\\", "/"));
		}
		if(fileMain.isFile())
			return;
		File[] files = fileMain.listFiles();
		for(File i : files){
			getPerhapsNodes(bootPathPieceName,i);
		}
		
		
	}
	
	
	
	
}
