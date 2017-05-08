package com.celestial.butterflystorm.butterfly2016.puddingIII.Interface.core;

import java.io.File;
import java.util.List;

import com.celestial.butterflystorm.butterfly2016.puddingIII.Interface.entity.TypeFile;

public interface PuddingCreator {
	
	public List<File> getPrepareFile(String prepareFilePath);
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * �ҵ�Ҫ�����ļ���λ��,�ֳ������ֱ�ʾ:<br/>
	 * ��Ŀ·�� + β·��<br/>
	 * </ul>
	 * @param typeFile
	 * @return
	 */
	public String[] findOriginalFile(TypeFile typeFile);
	
	public void prepareAndCopy(String[] OriginalFilePath,String puddingProjectPath) throws Exception;
	
}
