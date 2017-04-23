package com.celestial.meek.realTest_2016_10;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;
/**
 * 文件树 <br/>
 * 不可修改可扩展的原则 <br/>
 * 少的向多的传递 (0 0和上面的居然搭上了!)
 * @author Administrator
 *
 */
public class FileTree {
	/**
	 * 一个树枝
	 */
	private File treeBoot;
	/**
	 * 树枝上的叶子
	 */
	private File[] treeLeaves;
	
	/**
	 * 树枝路径
	 */
	private String bootPath;
	/**
	 * 树叶路径s
	 */
	private String[] leavesPaths;
	
	/**
	 * 是否包含文件
	 * 是的话,目录 文件全包含
	 * 不包含文件就是全都是目录了
	 */
	private boolean isContainGreen = true;
	
	
	
	
	/**
	 * 
	 * @param bootPath 树的根路径
	 */
	public FileTree(String bootPath) {
		init(bootPath);
	}
	/**
	 * @param bootPath
	 * @param isContainGreen 是否包含文件
	 */
	public FileTree(String bootPath ,boolean isContainGreen) {
		init(bootPath,isContainGreen);
	}
	private void init(String bootPath) {
		init(bootPath,this.isContainGreen);
	}
	/**
	 * 只获取树的当前根和当前叶子;需要的时候再去遍历;
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
				//如果不要文件且当前file是文件时返回false
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
	 * 该对象是否属于t1的一部分
	 * @param t1
	 * @return
	 */
	public boolean isBelong(FileTree t1) {
		return t1.isContain(this);
	}
	/**
	 * 该对象是否包含t2<br/>
	 * 完全包含
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
		//找到全部同名文件夹 结果存放在list perhapsNodesList中
		getPerhapsNodes(bootPathPieceName,new File(bootPathMain));
		//从list中找完全一样
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
