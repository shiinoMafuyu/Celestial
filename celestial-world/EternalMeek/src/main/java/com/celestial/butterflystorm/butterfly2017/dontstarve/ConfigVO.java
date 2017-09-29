package com.celestial.butterflystorm.butterfly2017.dontstarve;

import java.util.Map;

import com.celestial.agniRadiance.EzUtil.UtilFile;
import com.celestial.agniRadiance.EzUtil.UtilString;

public class ConfigVO {
	
	private Long interval = 1000L * 60 * 3;
	
	private String srcPath = "";
	
	private String desPath = "";
	
	private Long deleteInterval = 1000*60L;
	
	private Integer least = 20;
	
	

	public ConfigVO() {
		super();
	}

	public ConfigVO(Map<String, String> map) {
		try{
			//配置值
			this.setDeleteInterval(Long.valueOf(map.get("deleteInterval")) * 1000)
			.setDesPath(map.get("desPath"))
			.setInterval(Long.valueOf(map.get("interval")) * 1000)
			.setLeast(Integer.valueOf(map.get("least")))
			.setSrcPath(map.get("srcPath"));
			
		}catch (Exception e) {
			System.out.println("读取配置发生异常，使用默认值");
			//默认值
			String desktopPath = UtilFile.getAbsolutePath(UtilFile.getDesktopPath());
			this.setDeleteInterval(1000*60L)
			.setDesPath(desktopPath)
			.setInterval(1000*60L)
			.setLeast(20)
			.setSrcPath(UtilString.getStrBeforeLast(desktopPath,"/") + "/" + "Documents/Klei/DoNotStarve/save");
		}
		
	}
	
	public Long getInterval() {
		return interval;
	}

	public String getSrcPath() {
		return srcPath;
	}

	public String getDesPath() {
		return desPath;
	}

	public Long getDeleteInterval() {
		return deleteInterval;
	}

	public Integer getLeast() {
		return least;
	}

	public ConfigVO setInterval(Long interval) {
		this.interval = interval;
		return this;
	}

	public ConfigVO setSrcPath(String srcPath) {
		this.srcPath = srcPath;
		return this;
	}

	public ConfigVO setDesPath(String desPath) {
		this.desPath = desPath;
		return this;
	}

	public ConfigVO setDeleteInterval(Long deleteInterval) {
		this.deleteInterval = deleteInterval;
		return this;
	}

	public ConfigVO setLeast(Integer least) {
		this.least = least;
		return this;
	}

	@Override
	public String toString() {
		return "ConfigVO [interval=" + interval + ", srcPath=" + srcPath + ", desPath=" + desPath + ", deleteInterval="
				+ deleteInterval + ", least=" + least + "]";
	}
	
	
	
	
}
