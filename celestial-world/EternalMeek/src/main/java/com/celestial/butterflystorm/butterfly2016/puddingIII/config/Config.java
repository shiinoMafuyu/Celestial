package com.celestial.butterflystorm.butterfly2016.puddingIII.config;

public class Config {
	/**
	 补丁生成策略:
	 
	 1.java文件是去源码文件(一般是src)里寻找和准备文件完全一致的源码文件,再根据src下的路径去WebRoot/WEB-INF/classes里找对应的.class文件.
	   	注意你的项目是否已经编译生成了.class文件.;完全一致指名字一样,md5值一样.
	   	
	 2.jsp .xml .jsp .avi .js ...等等非java类型的文件全部从WebRoot下面查找与 准备文件一样的文件，
	 	然后就是一样的了,拷贝到Config.puddingPath下面建立的项目补丁目录内,完成补丁生成.
	 	
	 	注:java文件会搜索全部src目录,找出全部的完全一样文件;同样其他类型文件也会在WebRoot找出全部完全一致文件.制作补丁会以找到的第一个所在位置为准,
	 	其他给出提示"找到的完全一致文件不止一个".(话说这种脑残行为我只见过一次,我原本不相信有这种存在的.)
	*/
	
	/**生成好的补丁文件保存位置,默认桌面.*/
	public static String puddingPath = "E:/t/t26_myToolDevelopTestDataArea/puddingIII/res";
	
	/**打印提示信息与否,默认是*/
	public static  boolean isPrint = true;
	
	public static  COPY_METHOD CopyMethod = COPY_METHOD.COPY_BY_CMD;
	
	
	
	/**
	 * 生成补丁文件时用的拷贝方法。<br/>
	 */
	public enum COPY_METHOD{
		
		/**
		 * 调用Windows的CMD命令进行拷贝<br/>
		 * 不改变变文件创建、修改时间<br/>
		 * 默认<br/>
		 */
		COPY_BY_CMD("copyByCmd"),
		/**
		 * java的流操作文件复制。<br/>
		 * 文件修改创建时间变为为当前<br/>
		 * 备用<br/>
		 */
		COPY_BY_TRANSFER("copyByTransfer");
		
		private String method;
		private COPY_METHOD(String method){
			this.method = method;
		}
		@Override
		public String toString() {
			return method;
		}
		
	}
	/**
	 * 根据项目类型选择对应每局类型。
	 */
	public enum PUDDING_TYPE{
		
		/**
		 * web项目
		 */
		WEB("web"),
		/**
		 * java项目
		 */
		JAVA("java");
		
		
		private PUDDING_TYPE(String type){
			this.type = type;
		}
		private String type;
		public String toString(){
			return type;
		}
	}
	
}
