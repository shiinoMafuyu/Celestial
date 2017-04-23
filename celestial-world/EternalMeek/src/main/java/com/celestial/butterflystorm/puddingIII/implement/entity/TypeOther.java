package com.celestial.butterflystorm.puddingIII.implement.entity;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.celestial.agniRadiance.EzUtil.Util_File;
import com.celestial.butterflystorm.puddingIII.Interface.entity.TypeFile;
import com.celestial.butterflystorm.puddingIII.tempAbstract.entity.TypeFileTemp;

public class TypeOther extends TypeFileTemp implements TypeFile {
	
	private File originalFile;
	private String originalPath;

	@Override
	public String[] findOriginalFile() {
		List<String> l = Util_File.findFile(originalFile, new File(originalPath));
		check(l);
		String[] originalFilePath = new String[]{originalPath,l.get(0).substring(originalPath.length())};
		return originalFilePath;
	}

	private void check(List<String> l) {
		if(l.size() < 1)
			throw new RuntimeException("文件未找到:"+originalFile.getName());
		else if(l.size() > 1)
			p.println("警告,文件超过1个,以第一个为准."+ originalFile.getName());
	}

	public TypeOther(String originalPath, File originalFile) {
		this.originalPath = originalPath;
		this.originalFile = originalFile;
	}

	@Override
	public void copy(File original, File pudding) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		m.invoke(null, original,pudding);
	}
}
