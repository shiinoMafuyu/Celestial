package com.celestial.butterflystorm.puddingIII.InterfaceHolder;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.celestial.agniRadiance.entity.Print;
import com.celestial.butterflystorm.puddingIII.Interface.core.PuddingCreator;
import com.celestial.butterflystorm.puddingIII.Interface.entity.TypeFile;
import com.celestial.butterflystorm.puddingIII.config.Config;
import com.celestial.butterflystorm.puddingIII.config.Config.PUDDING_TYPE;
import com.celestial.butterflystorm.puddingIII.implement.core.PuddingCreatorImpl;
import com.celestial.butterflystorm.puddingIII.implement.entity.TypeJava;
import com.celestial.butterflystorm.puddingIII.implement.entity.TypeOther;

public class InterfaceHolder {

	private String preparedFilePath;
	private String projectPath;
	private String puddingProjectPath;
	private Print p = new Print(Config.isPrint);
	
	private String JAVA_subHead = "";
	private String JAVA_originalPath = "";
	private String OTHER_originalPath = "";
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 开始生成补丁
	 * </ul>
	 */
	public void excute() {
		p.println("开始生成补丁...");
		PuddingCreator pc = new PuddingCreatorImpl();
		List<File> fArr = pc.getPrepareFile(preparedFilePath);
		List<File> heartFailure = new ArrayList<File>();
		for(File f : fArr){
			try {
				TypeFile tf =  null;
				if(f.getName().endsWith(".java"))
					tf = new TypeJava(projectPath,JAVA_subHead,JAVA_originalPath, f);
				else
					tf = new TypeOther(OTHER_originalPath,f);
				String[] original = pc.findOriginalFile(tf);
				pc.prepareAndCopy(original, this.puddingProjectPath);
			} catch (Exception e) {
				p.println(e.toString());
				heartFailure.add(f);
			}
		}
		p.println("共计: " + fArr.size()+"\n成功:" + (fArr.size() - heartFailure.size()) + "\n失败:" + heartFailure.size());
		for(File f : heartFailure){
			p.println(f.getName());
		}
	}

	/**
	 * <b>构造方法</b>
	 * 接口控制持有类，用于调用接口生成补丁。
	 * <br/>
	 * @param preparedFilePath 要做补丁的文件路径<br/>
	 * (支持多级目录,递归遍历改path下所有文件，可用于处理同名文件问题)
	 * @param projectPath 项目路径
	 * @param 项目类型 java or web
	 */
	public InterfaceHolder(String preparedFilePath , String projectPath,PUDDING_TYPE type) {
		this.preparedFilePath = preparedFilePath ;
		this.projectPath = projectPath;
		this.puddingProjectPath = Config.puddingPath + projectPath.substring(projectPath.lastIndexOf("/"));
		
		if(PUDDING_TYPE.WEB.equals(type)){
			JAVA_subHead = projectPath+"/WebRoot";
			JAVA_originalPath = projectPath+"/WebRoot/WEB-INF/classes";
			OTHER_originalPath = projectPath+"/WebRoot";
			
		}else if(PUDDING_TYPE.JAVA.equals(type)){
			JAVA_subHead = projectPath+"/bin";
			JAVA_originalPath = projectPath+"/bin";
			OTHER_originalPath = projectPath+"/bin";
		}else{
			throw new RuntimeException("请配置类型支持.");
		}
	}

}
