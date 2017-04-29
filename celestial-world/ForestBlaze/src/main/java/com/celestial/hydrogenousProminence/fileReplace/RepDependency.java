package com.celestial.hydrogenousProminence.fileReplace;

import java.util.HashMap;
import java.util.Map;
/**
 * �ļ��滻��������
 * @author Administrator
 *
 */
public class RepDependency {
	
	/**
	 * Դ·����
	 */
	private String sourceFilePath = "";
	
	/**
	 * �����滻������Map repMap = <"��ű�־"��[sn_flag,en_flag,target_sn_flag,target_en_flag,targetPath]>
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
