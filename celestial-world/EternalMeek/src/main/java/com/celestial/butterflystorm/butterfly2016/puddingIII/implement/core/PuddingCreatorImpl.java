package com.celestial.butterflystorm.butterfly2016.puddingIII.implement.core;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.celestial.agniRadiance.EzUtil.UtilFile;
import com.celestial.agniRadiance.entity.Print;
import com.celestial.butterflystorm.butterfly2016.puddingIII.Interface.core.PuddingCreator;
import com.celestial.butterflystorm.butterfly2016.puddingIII.Interface.entity.TypeFile;
import com.celestial.butterflystorm.butterfly2016.puddingIII.config.Config;

public class PuddingCreatorImpl implements PuddingCreator{
	private TypeFile typeFile = null;
	private Print p = new Print(Config.isPrint);
	@Override
	public List<File> getPrepareFile(String prepareFilePath) {
		//现在觉得遍历获取下面所有文件比较好.
		List<File> l = new ArrayList<File>();
		l.addAll(UtilFile.findAllFile(prepareFilePath));
		return l;
	}

	@Override
	public String[] findOriginalFile(TypeFile typeFile) {
		this.typeFile = typeFile;
		String[] originalFilePath = typeFile.findOriginalFile();
		return originalFilePath;
	}

	@Override
	public void prepareAndCopy(String[] OriginalFilePath,
			String puddingProjectPath) throws Exception {
		File original = new File(OriginalFilePath[0] + OriginalFilePath[1]);
		File pudding = new File( puddingProjectPath + OriginalFilePath[1]);
		File puddingFa = pudding.getParentFile();
		if(!puddingFa.exists()){
			puddingFa.mkdirs();
		}
		typeFile.copy(original,pudding);
		p.println("拷贝成功:" + original.getAbsolutePath() + "   -->\n      " + pudding.getAbsolutePath());
	}
	
}
