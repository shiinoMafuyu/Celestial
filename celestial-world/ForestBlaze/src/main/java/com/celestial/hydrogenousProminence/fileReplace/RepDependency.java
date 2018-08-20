package com.celestial.hydrogenousProminence.fileReplace;

import java.util.HashMap;
import java.util.Map;
/**
 * 文件替换依赖对象。
 * @author Administrator
 *
 */
public class RepDependency {
	
	/**
	 * 源路径。
	 */
	private String sourceFilePath = "";
	
	/**
	 * 用于替换索引的Map repMap = <"编号标志"，[sn_flag,en_flag,target_sn_flag,target_en_flag,targetPath]>
	 */
	private Map<String,String[]> repMap = new HashMap<String,String[]>();

	public String getSourceFilePath() {
		return sourceFilePath;
	}

	public RepDependency setSourceFilePath(String sourceFilePath) {
		this.sourceFilePath = sourceFilePath;
		return this;
	}

	public Map<String, String[]> getRepMap() {
		return repMap;
	}

	public RepDependency setRepMap(Map<String, String[]> repMap) {
		this.repMap = repMap;
		return this;
	}
}
