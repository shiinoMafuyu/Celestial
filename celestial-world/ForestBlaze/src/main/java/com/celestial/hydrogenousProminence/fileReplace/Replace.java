package com.celestial.hydrogenousProminence.fileReplace;

import java.util.List;
import java.util.Map.Entry;

import com.celestial.agniRadiance.EzUtil.Util_File;
import com.celestial.agniRadiance.entity.FileReader;
import com.celestial.agniRadiance.entity.Print;
/**
 * 文件替换类,读取文件一部分，放到另一个文件某一位置上去<br/>
 * 要对读取的文件片段进行操作，则在子类中复写doTrans()方法。<br/>
 * 以偏安全的方式进行设计。<br/>
 * @author Administrator
 *
 */
public class Replace {
	
	private RepDependency depend;
	private FileReader f ;
	private String charset = "";
	private Print p = new Print(true);
	
	public Replace(RepDependency depend) {
		init(depend,"utf-8");
	}
	
	public Replace(RepDependency depend,String charset) {
		init(depend,charset);
	}
	
	private void init(RepDependency depend, String charset) {
		this.depend = depend;
		this.charset = charset;
		f = new FileReader(depend.getSourceFilePath(),false,this.charset);
	}

	public void executeReplace(){
		for(Entry<String,String[]> ei: depend.getRepMap().entrySet()){
			boolean isSuccess = replaceOne(ei.getValue());
			p.println("文件：" + ei.getValue()[4] + "替换内容" + (isSuccess==true?"成功":"失败！"));
		}
	}

	/**
	 * 结构如RepDependency中所描述<br/>
	 * [sn_flag,en_flag,target_sn_flag,target_en_flag,targetPath]
	 * @param value
	 * @return
	 */
	private boolean replaceOne(String[] repArr) {
		try {
			String targetFilePath = repArr[4];
			List<String> sourceList = f.selectAllLineBetweenRegex2_removeHeadTail(repArr[0], repArr[1]).getLineList();
			List<String> targetList = doTrans(sourceList);
			FileReader targetFile = new FileReader(targetFilePath,false,charset);
			int start = targetFile.getRegexPosition(repArr[2]),
				end = targetFile.getRegexPosition(repArr[3]);
			if(!(start > 0 && end > start))
				throw new RuntimeException("文件：" + targetFilePath + " 的开始下标：" + repArr[2] + " 和结束下标：" + repArr[3] + " 匹配有误！");
			FileReader endFile = targetFile.replaceList(start, end, targetList);
			Util_File.printFile(endFile.getLineList(), targetFilePath, charset);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 将原来的文件部分转为新的转换方式。<br/>
	 * 默认不做任何修改。<br/>
	 * 要做什么修改则创建子类复写此方法.<br/>
	 * @param sourceList
	 * @return
	 */
	public List<String> doTrans(List<String> sourceList) {
		return sourceList;
	}
}
