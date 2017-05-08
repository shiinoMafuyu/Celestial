package com.celestial.butterflystorm.butterfly2016.puddingII;

import java.io.File;

import com.celestial.agniRadiance.EzUtil.Util_File;
/**
 * <b>修改记录：</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2016-5-22
 * </li>
 * </p>
 * 
 * <b>类说明：</b>
 * <p> 
 * 
 * </p>
 */
public class PuddingMaker {
	/**--------------一旦生成不改变其值---------------*/
	/**
	 * 传入字符串s1对应的文件
	 */
	File s1File;
	/**
	 * 源文件home
	 * java在src下
	 * 一般文件在webRoot下
	 */
	String sourceHome; 
	/**
	 * 要拷贝的文件的home
	 * 一般文件webRoot下
	 * java文件拷其对应的.class文件 在webRoot/web-inf/classes下
	 */
	String srcFileHome;
	/**
	 * 目标路径home
	 * 一般文件项目名下
	 * java对应的class文件 项目名 + web-inf + classes
	 */
	String destinationHome ;
	/**
	 * 文件名
	 */
	String fileName;
	/**
	 * 项目名
	 */
	String projectName;
	/**
	 * 是否是java文件
	 */
	boolean isJava;
	
	/**--------------一旦生成不改变其值---------------*/
	File srcFile ;
	File desFile ;
	 
	String tail = null;
	/**
	 * 
	 * @param s1   一个文件
	 * @param s2   项目目录
	 */
	public PuddingMaker(String s1,String s2) {
		this.s1File = new File(s1);
		this.projectName = s2.substring(s2.lastIndexOf("/")+1, s2.length());
		this.fileName = s1.substring(s1.lastIndexOf("/")+1, s1.length());
		//生成含项目名的目标根路径
		this.destinationHome = s1.substring(0, s1.lastIndexOf("/"))+"/"+projectName;
		
		//生成查找路径
		this.isJava = fileName.endsWith(".java");
		if(isJava){
			this.sourceHome = s2+"/src";
			this.srcFileHome = s2+"/WebRoot/WEB-INF/classes";
			//若果是java文件 目标文件路径在根目录的/WEB-INF/classes下面
			this.destinationHome += "/WEB-INF/classes";
			
		}else{
			this.sourceHome = s2+"/WebRoot";
			this.srcFileHome = s2+"/WebRoot";
		}
	}
	/**
	 *  1 :拷贝成功
	 * -1 :文件未找到
	 * -2 :创建目标文件失败
	 * -3 :拷贝失败
	 * -4 :其他失败
	 * @return 结果
	 */
	public int makePudding(){
		//找到文件
		if(!findGelatin()){
			return -1;
		}
		//创建起源和目标路径
		if(!prepareFood()){
			return -2;
		}
		//拷贝
		if(!cookDinner()){
			return -3;
		}
		//检查
		if(isJava){
			foodIngredients();
		}
		System.out.println("文件生成补丁成功 : " + this.fileName );
		return 1;
	}
	/**
	 * 看有没有内部类 有的话拷贝
	 * 别去改变既有的值
	 * @return
	 */
	private boolean foodIngredients() {
		boolean b= true;
		try {
			String parentDes = desFile.getParent().replaceAll("\\\\", "/");
			String firstName=fileName.split("\\.")[0];
			File[] fArr=srcFile.getParentFile().listFiles();
			for(File i : fArr){
				String iName = i.getName();
				if(iName.contains(firstName+"$") && iName.endsWith(".class")){
					File iDesFile = new File(parentDes + "/"+iName);
					Util_File.copyByCmd(i, iDesFile);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			b = false;
		}
		return b;
	}
	/**
	 * 拷贝文件
	 * @return
	 */
	private boolean cookDinner() {
		boolean b = true;
		try {
			Util_File.copyByCmd(srcFile, desFile);
		} catch (Exception e) {
			e.printStackTrace();
			b = false;
		}
		return b;
	}
	/**
	 * 创造准备文件
	 * @return
	 */
	private boolean prepareFood() {
		boolean b= true;
		try {
			srcFile =new File ( srcFileHome + tail );
			
			if( srcFile != null && srcFile.exists() && srcFile.isFile()){
				desFile = new File(destinationHome + tail);
				desFile.getParentFile().mkdirs();
				desFile.createNewFile();
			}else{
				System.out.println("源文件不存在!无法拷贝生成补丁!");
			}
//			srcFile = 
		} catch (Exception e) {
			e.printStackTrace();
			b = true;
		}
		return b;
	}
	/**
	 * 去sourceHome中查找需要的文件,
	 * @return 找到返回true,否则false
	 */
	private boolean findGelatin() {
		boolean b =true;
		try {
			find(new File(this.sourceHome));
			if(tail ==null )
				b=false;
		} catch (Exception e) {
			e.printStackTrace();
			b=false;
		}
		return b;
	}
	/**
	 * 从属于findGelatin()的递归查找方法
	 * 用递归返回字符串也可以,但是不能查看全部文件了
	 * @param file
	 */
	private void find(File file) {
		if(file.isDirectory()){
			File[] fArr=file.listFiles();
			for(File i : fArr){
				find(i);
			}
		}
		else if(file.isFile()){
			if(Util_File.compareFile(file,this.s1File)){
				if(this.tail !=null ){
					System.out.println("警告 : 找到的 "+this.fileName+" 文件不止一个,请注意!");
				}
				String sFile = file.getAbsolutePath();
				this.tail = sFile.substring(this.sourceHome.length(),sFile.length());
				if(isJava){
					tail = tail.substring(0,tail.lastIndexOf("java"))+"class";
				}
			}
		}else{
			throw new RuntimeException("不是文件,不是目录异常");
		}
		
	}
	public String getDestinationHome() {
		return destinationHome;
	}
	public String getProjectName() {
		return projectName;
	}
	public String getSourceHome() {
		return sourceHome;
	}
	public String getSrcFileHome() {
		return srcFileHome;
	}
	public String getFileName() {
		return fileName;
	}
	public boolean isJava() {
		return isJava;
	}
	public File getS1File() {
		return s1File;
	}
	public File getSrcFile() {
		return srcFile;
	}
	public File getDesFile() {
		return desFile;
	}
	public String getTail() {
		return tail;
	}
	
	
	
}
