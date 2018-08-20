package com.celestial.butterflystorm.butterfly2016.puddingIII.Interface.core;

import java.io.File;
import java.util.List;

import com.celestial.butterflystorm.butterfly2016.puddingIII.Interface.entity.TypeFile;

public interface PuddingCreator {
	
	public List<File> getPrepareFile(String prepareFilePath);
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 找到要拷贝文件的位置,分成两部分表示:<br/>
	 * 项目路径 + 尾路径<br/>
	 * </ul>
	 * @param typeFile
	 * @return
	 */
	public String[] findOriginalFile(TypeFile typeFile);
	
	public void prepareAndCopy(String[] OriginalFilePath,String puddingProjectPath) throws Exception;
	
}
