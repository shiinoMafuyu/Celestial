package com.celestial.butterflystorm.butterfly2016.puddingII;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.celestial.agniRadiance.EzUtil.UtilFile;

/**
 * 生成补丁
 * @author Administrator
 *
 */
public class puddingController {

	/**
	 * 自动生成补丁小工具.
	 * 工作流程说明:
	 * 1)获取s1所在的目录的所有文件,遍历之.设为s1.fileI.
	 * 2)去s2里递归找文件,只有名字一样且md5摘要算法均一致的才算同一个文件(这样保证绝对不出错):
	 * 		如果是s1.fileI是.java文件去,src下面找.找到之后根据src下的路径去WEB-INF下找.java文件对应的.class文件.
	 * 		如果s1.fileI是非.java文件 (如.jsp .xml 等)则直接去WEB-INF下找同名同MD5值文件.
	 * 3)找到对应的文件后就在s1里创建对应目录,拷贝过去.如果是java文件看下有内部类文件没有,有的话也全拷过去.
	 * 2016年8月23日16:40:38
	 * 
	 */
	public static void main(String[] args) {
		/**1.要做补丁的文件拖入一个临时目录中,在s1处填上位置*/
		String s1 = "E:/HackingGate/03_2016-08-20_开发一部时的补丁文件/补丁包/testPodCreate/pudding";
		/**2.填上对饮的web项目路径,运行即可.*/
		String s2 = "E:/HackingGate/03_2016-08-20_开发一部时的补丁文件/补丁包/testPodCreate/project/issue_front_山东鼎峰";
		makeingPudding(s1,s2);
	}

	private static boolean makeingPudding(String s1, String s2) {
		if(!(UtilFile.checkFileExist(s1) && UtilFile.checkFileExist(s2)))
			throw new RuntimeException("检查文件是否都存在" + s1 +"\n" + s2);
		boolean b = true;
		List<String> failedList =new ArrayList<String>();
		try{
			File[] fArr = new File(s1).listFiles();
			PuddingMaker p ;
			for(File i : fArr){
				String i0 = i.getAbsolutePath().replaceAll("\\\\", "/");
				p =new PuddingMaker(i0, s2);
				int x = p.makePudding();
				if(x != 1){
					failedList.add(p.getFileName());
				}
			}
			//结果展示
			System.out.println("共计 " + fArr.length);
			System.out.println("成功: " +(fArr.length - failedList.size()));
			System.out.println("失败: " + failedList.size());
			for(String i : failedList){
				System.out.println(i);
			}
		}catch(Exception e){
			e.printStackTrace();
			b=false;
		}
		return b;
	}

}

