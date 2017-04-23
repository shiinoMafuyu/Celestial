package com.celestial.butterflystorm.puddingIII.implement.entity;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.celestial.agniRadiance.EzUtil.Util_File;
import com.celestial.butterflystorm.puddingIII.Interface.entity.TypeFile;
import com.celestial.butterflystorm.puddingIII.tempAbstract.entity.TypeFileTemp;

public class TypeJava extends TypeFileTemp implements TypeFile {

	public static List<String> srcPathList;
	private String originalPath;
	private File srcFile;
	private String subHead;
	
	private String[] findSourceFile() {
		Map<String,List<String>> m = new LinkedHashMap<String, List<String>>();
		String key = null;
		for(String i : srcPathList){
			List<String> ltemp = Util_File.findFile(this.srcFile, new File(i));
			if(ltemp.size() > 0){
				m.put(i, ltemp);
				if(key == null)
					key = i;
			}
		}
		check(m);
		String srcFilePath = m.get(key).get(0);
		String head = key;
		String tail = srcFilePath.substring(key.length());
		return new String[]{head,tail};
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 检查找到的文件是否超过一个.
	 * </ul>
	 * @param m
	 * @return
	 */
	private void check(Map<String, List<String>> m) {
		if(m.size()<1)
			throw new RuntimeException("文件未找到:"+srcFile.getName());
		if(m.size() > 1)
			p.println("警告,文件超过1个,以第一个为准."+ srcFile.getName());
		//虽然只有一个..
		for(Entry<String, List<String>> ei : m.entrySet()){
			if(ei.getValue().size() > 1){
				p.println("警告,文件超过1个,以第一个为准."+ srcFile.getName());
			}
		}
	}

	@Override
	public String[] findOriginalFile() {
		String[] sourceFilePath = findSourceFile();
		String tail = sourceFilePath[1];
		tail = tail.substring(0, tail.lastIndexOf(".java"))+".class";
		String filePath = this.originalPath + tail;
		if(!new File(filePath).exists())
			throw new RuntimeException("对应.class文件不存在:" + this.srcFile.getName());
		String[] originalFilePath = new String[]{filePath.substring(0, subHead.length()),filePath.substring(subHead.length())};
		return originalFilePath;
	}
	
	public TypeJava(String projectPath,String subHead,String originalPath, File srcFile) {
		if(srcPathList == null)
			srcPathList = getSrcPathList(projectPath);
		this.subHead = subHead;
		this.originalPath = originalPath;
		this.srcFile = srcFile;
	}

	private List<String> getSrcPathList(String projectPath) {
		File[] fArr = Util_File.fileDirectory(projectPath, ".*src");
		List<String> fileList = new ArrayList<String>();
		for(File i : fArr){
			if(Util_File.findFile(".+\\.java", i).size() > 0)
				fileList.add(i.getAbsolutePath().replaceAll("\\\\", "/"));
		}
		return fileList;
	}


	@Override
	public void copy(File original, File pudding) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		m.invoke(null, original,pudding);
		String name = original.getName();
		name = name.substring(0, name.lastIndexOf(".class"));
		File[] fArr = Util_File.fileDocument(original.getParent().replaceAll("\\\\", "/"), name+"\\$.*\\.class");
		for(File f: fArr){
			m.invoke(null,f, new File(pudding.getParent()+"/"+f.getName()));
		}
		
		
	}
}
