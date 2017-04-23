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
	 * <b>����˵����</b>
	 * <ul>
	 * ��ʼ���ɲ���
	 * </ul>
	 */
	public void excute() {
		p.println("��ʼ���ɲ���...");
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
		p.println("����: " + fArr.size()+"\n�ɹ�:" + (fArr.size() - heartFailure.size()) + "\nʧ��:" + heartFailure.size());
		for(File f : heartFailure){
			p.println(f.getName());
		}
	}

	/**
	 * <b>���췽��</b>
	 * �ӿڿ��Ƴ����࣬���ڵ��ýӿ����ɲ�����
	 * <br/>
	 * @param preparedFilePath Ҫ���������ļ�·��<br/>
	 * (֧�ֶ༶Ŀ¼,�ݹ������path�������ļ��������ڴ���ͬ���ļ�����)
	 * @param projectPath ��Ŀ·��
	 * @param ��Ŀ���� java or web
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
			throw new RuntimeException("����������֧��.");
		}
	}

}
