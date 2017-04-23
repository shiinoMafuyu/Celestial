package com.celestial.butterflystorm.puddingIII.Interface.entity;

import java.io.File;

import com.celestial.agniRadiance.entity.Print;
import com.celestial.butterflystorm.puddingIII.config.Config;


public interface TypeFile {
	public Print p = new Print(Config.isPrint);
	public String[] findOriginalFile();
	public void copy(File original, File pudding) throws Exception;
}
