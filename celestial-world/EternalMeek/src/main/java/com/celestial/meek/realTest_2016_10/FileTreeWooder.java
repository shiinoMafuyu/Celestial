package com.celestial.meek.realTest_2016_10;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.celestial.agniRadiance.EzUtil.Util_File;
import com.celestial.agniRadiance.EzUtil.Util_Normal;


public class FileTreeWooder {
	static{
		
	}
	
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		FileTreeWooder f =new FileTreeWooder();
		String filePath = "C:/Users/Administrator/Desktop/补丁包/00002上海自贸需要出整理的补丁";
		String destHead = "C:/Users/Administrator/Desktop/补丁包/0000-上海自贸姬梦娜测试部分(不含在线开户)";
		boolean isRuled = f.checkAllContainFiles(filePath);
		if(isRuled){
			f.zhengHe(filePath,destHead);
		}
		else
			System.out.println("请规范补丁包,将项目文件放在补丁包中的files目录下.");
		
	}
	/**=======================================================中央反射中枢 不可修改 wangzg 2016年7月20日17:23:32====================================================*/
																             //反射中枢 和反射神经写一起算了 ╮(╯▽╰)╭
	
	/**=========================================================中央反射中枢不可修改 wangzg 2016年7月20日17:23:37===================================================*/
	/**
	 * 
	 * @param filePath	包含补丁包的目录
	 * @param destHead	整合到哪个塔塔 (不要是上面目录的子目录)
	 * @param projects	项目过滤
	 * @param dates		日期过滤
	 */
	public void zhengHe(String filePath, String destHead, String[] projects,
			String[] dates) {
		
		
	}
	
	
	/**=======================================================实例调用方法 不可修改 wangzg 2016年7月20日11:23:56====================================================*/
	/**
	 * 整合文件
	 * @param filePath	包含补丁包的目录
	 * @param destHead	整合到哪个塔塔 (不要是上面目录的子目录)
	 * @param projects	日期过滤
	 */
	public void zhengHe(String filePath, String destHead, String[] projects) {
		//为单数时
		//预处理两边的路径 就能伪侵略的过滤文件了
		File file = new File(filePath);
		File[] files = file.listFiles();
		copyAllByTimeMethodList = new ArrayList<Object>();
//		copyAllByTimeMethodList
		
		
	}
	private boolean zhengHe_filterProject(Object dynamicParam){
		
		return false;
	}
	/**
	 * 检查是否每个补丁文件夹都含有files目录
	 * @param filePath
	 * @return true 是 ; false 无
	 */
	public boolean checkAllContainFiles(String filePath) {
		File f = new File(filePath);
		File[] files = f.listFiles();
		System.out.println("文件个数 : "+files.length);
		int filesCount = 0;
		for(File i : files){
			File[] fi = i.listFiles();
			for(File j : fi){
				String name = j.getName();
				if("files".equals(name)){
					filesCount++;
				}
			}
		}
		System.out.println("共计含files:" +filesCount +"   没有问题: "+(filesCount == files.length));
		return filesCount == files.length;
		
	}

	/**其实我突然想到 如果在进行操作之前传入一个是否进行操作的值 true or false ,那不是就能通过这个值延伸出filter功能了吗*/
	/**然而已经写了 现在又莫得问题就坚决不能改原码!*/
	/**
	 * 整合文件
	 * @param filePath	包含补丁包的目录
	 * @param destHead	整合到哪个塔塔 (不要是filePath的子目录)
	 */
	public  void zhengHe(String filePath ,String destHead) {
		File file = new File(filePath);
		File[] files = file.listFiles();
		
		try {
			for(File i : files){
				String  head = i.getAbsolutePath().replaceAll("\\\\", "/");
				totalNum = 0;
				needNum = 0;
				susscessNum = 0;
				copyAllByTime(i,head,destHead);
				System.out.println(i.getName() +"  -->  共计 :" + totalNum + "  需拷贝: "+needNum + "  成功 : " + susscessNum +"\n 失败:-------------------------------------");
				for(String j : failList){
					System.out.println(j);
				}
				System.out.println("-------------------------------------");
			}
		} catch (Exception e) {
			System.out.println("发生异常,操作终止!");
		}
		
	}
	
	/**=======================================================实例调用方法 不可修改 wangzg 2016年7月20日11:23:56====================================================*/
	
	
	/**
	 * 原来原来你是我的猪大哥~
	 * 打得就是你~
	 * 爽得我好神不守舍~
	 */
	
	
	
	/**=======================================================内部方法 禁止调戏 2016年7月20日11:21:05 wangzg======================================================*/
	/**=======================================================变量只允许使用 不允许修改===========================================================================*/
	/**总共文件个数*/
	int totalNum = 0;
	/**需要拷贝文件个数*/
	int needNum = 0;
	/**拷贝成功个数*/
	int susscessNum = 0;
	/**失败文件*/
	List<String> failList = new ArrayList<String>();
	/**已经拷贝的文件*/
	Map<String,Long> copyedMap = new HashMap<String, Long>();
	/**=======================================================变量只允许使用 不允许修改===========================================================================
	 * @throws Exception */
	
	private  void copyAllByTime(File file, String head, String destHead,List<Object> methodList) throws Exception{
		boolean b = true ;
		try {
			System.out.println("开始执行反射方法..");
			b = Util_Normal.excuteReflectObjectAll(methodList);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		if(b){
			System.out.println("反射方法全部执行成功.");
			copyAllByTime(file, head, destHead);
		}
			
	}
	List<Object> copyAllByTimeMethodList = null;
	/**
	 * 递归遍历项目拷贝<br/>
	 * 简单说来 就是简单的把一个文件夹下的所有内容拷到另一个地方,如果有重复就依最后修改时间保留.<br/>
	 * @param file	要拷贝的文件/目录 <br/>
	 * @param head	最初的文件头 <br/>
	 * @param destHead	拷贝到哪里
	 * @throws Exception 
	 */
	@SuppressWarnings("deprecation")
	private  void copyAllByTime(File file, String head, String destHead) throws Exception {
		//head 方法扩展
		boolean b = true ;
		try {
			b = Util_Normal.excuteReflectObjectAll(copyAllByTimeMethodList);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		if(!b){
			return;
		}
		//body 方法主体
		if(file.isFile()){
			totalNum ++;
			try {
				String tail =  file.getAbsolutePath().replaceAll("\\\\", "/").substring(head.length());
				/*if(tail.contains("/files/SelfOpenAccount/")){//过滤掉selfOpenAccount
					return;
				}*/
				File destFile = new File(destHead + tail);
				File path = new File(destFile.getParent());
				
				//若以前目标位置本来就有文件  看现在这个是不是比较新  新的话才拷
				boolean b1;
				if(path.exists()){
					b1=true;
				}else{
					b1 = path.mkdirs();
				}
				boolean b2;
				boolean shouldCopy;
				if(destFile.exists()){
					b2 = true;
					//文件存在比较时间
					Date dateAlready =	new Date(copyedMap.get(tail));
					Date dateNow = new Date(file.lastModified());
					System.out.println("文件已存在 进行比较   ---- 现在文件 :" + dateNow.toLocaleString() +" --- 以前文件: "+dateAlready.toLocaleString() +" --- 为true 则拷: " + dateNow.after(dateAlready));
					if(dateNow.after(dateAlready)){
						shouldCopy = true;
					}else{
						shouldCopy = false;
					}
				}else{
					b2 = destFile.createNewFile();
					shouldCopy = true;
				}
				
				//文件存在的话才能拷贝
				if(!(b1 && b2)){
					throw new RuntimeException("没创建文件 拷贝成功");
				}
				if(shouldCopy){
					needNum++;
					Util_File.copyByTransfer(file, destFile);
					copyedMap.put(tail, file.lastModified());
					susscessNum++;
				}
			} catch (Exception e) {
				failList.add(file.getAbsolutePath().replaceAll("\\\\", "/"));
			}
		}
		else if(file.isDirectory()){
			File[] files = file.listFiles();
			for(File i : files){
				copyAllByTime(i,head,destHead);
			}
		}
		else{
			throw new RuntimeException("不是文件也不是文件夹,什么鬼!");
		}
		
	}
	/**=======================================================内部方法 禁止调戏 2016年7月20日11:21:05 wangzg======================================================*/
}
