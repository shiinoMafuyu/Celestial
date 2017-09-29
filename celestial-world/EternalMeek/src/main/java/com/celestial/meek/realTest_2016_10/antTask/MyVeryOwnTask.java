package com.celestial.meek.realTest_2016_10.antTask;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;

public class MyVeryOwnTask extends Task {
	
	private String podding;
	private String project;
	
	//Ŀ¼���еľ�ֱ�Ӹ��� ���� �������
	//û��Ŀ¼ û���ļ��ĵ�������ʾ~~��� Ӧ��
    // The method executing the task
    @SuppressWarnings("resource")
	public void execute() throws BuildException {
        System.out.println("����λ��: "+podding);
        System.out.println("��Ŀλ��: "+project);
        //�ҵ�������	�ҵ��������������ļ����ַ��� 		ƴ��Ŀ������ļ�,ȥ��������û�в�����Ӧ�ļ�	û�еĻ�ֱ�Ӹ��� �еĻ�ֱ�Ӹ���(..)
        //����ȡĿ¼��ô�� (niceIdea~) ��������������Ŀ�ﲻ���е�Ŀ¼���ļ�,��ӡ����,���Ƿ�򲹶�.�ǵĻ�,����Ŀ¼���ļ�,��Ļ���ȫ��ִ�в���--->��������ȥ��~
        //���ص������� ����ûʲô��ϵ,������Ҫ��ȡ��֪�����ȺͲ�ε�list ֱ��ȫ��У��һ�� ��ȫ����������
        File fPodding=new File(podding);
        File fProject=new File(project);
        
        //���Ŀ¼�ǲ��ǲ�����
        boolean b1=checkFile(fPodding);
        boolean b2=checkFile(fProject);
        if(!b1){
        	System.out.println("����Ŀ¼Ϊ�ջ��߲����ڻ��߲���Ŀ¼,����~");
        	return;
        }
        if(!b2){
        	System.out.println("��ĿĿ¼Ϊ�ջ��߲����ڻ��߲���Ŀ¼,����~");
        	return;
        }
        
        
        //�����ļ�
        boolean b= recursiveTraverseCheck(fPodding,fProject);
        if(b){
        	System.out.println("��ɼ��,����Ŀ¼����ĿĿ¼�ṹһ��.�Ƿ�ʼ? Y/N");
        }else{
        	System.out.println("��ɼ��,����Ŀ¼����ĿĿ¼�ṹ��һ��.�������������Ŀ�����Ӷ�ӦĿ¼���ļ�");
        	System.out.println("�Ƿ�ʼ? Y/N");
        }
        
        //������� ִ��copy���߷���
        Scanner scan=new Scanner(System.in);
        String op=scan.next();
        if(!op.toLowerCase().equals("y")){
        	System.out.println("�򲹶������ѷ���,�������~");
        	return;
        }
        //copy
        //copy step1:��ȡ���ݴ��·��
        String recordIndexPath=createRecordIndex(fPodding);
        //copy step2:project������ļ��ƶ�����,�����е��ļ��Ź��� Ŀ¼����
		try {
			recursiveTraverseMoveAndCopy(fPodding,fProject,recordIndexPath,fProject.getPath().lastIndexOf("\\"));
		} catch (Exception e) {
			e.printStackTrace();
		}
        
    }
    /**
     * ���File�Ƿ�Ϊ�ջ��߲����ڻ��߲���Ŀ¼
     * @param f
     * @return
     */
	private static boolean checkFile(File f) {
		if(!(f!=null&&f.exists()&&!f.isFile())){
			System.out.println("�����ļ���Ϊnull,���߲�����,���߲����ļ���");
			return false;
		}else{
			return true;
		}
	}

	/**
	 * ͨ���ܵ������ļ�
	 * @param f1 �����ļ�
	 * @param f2 ����ļ�
	 * @return
	 * @throws Exception
	 */
	private static long copyByTransfer(File f1, File f2) throws Exception{
		long time=new Date().getTime();
        int length=1,size=20971520;
        @SuppressWarnings("resource")
		FileChannel inC=new FileInputStream(f1).getChannel();
        @SuppressWarnings("resource")
		FileChannel outC=new FileOutputStream(f2).getChannel();
        while(true){
            if(inC.position()==inC.size()){
                inC.close();
                outC.close();
                return new Date().getTime()-time;
            }
            if((inC.size()-inC.position())<size)
                length=(int)(inC.size()-inC.position());
            else
                length=size;
            inC.transferTo(inC.position(),length,outC);
            inC.position(inC.position()+length);
        }
	}
	
	/**
	 * ���ݲ�������λ�ô�������Ŀ¼
	 * ����ͬһ��Ŀ¼�½�����������Ŀ¼---����-02---������Ŀ�ı��� 
	 * @param podding
	 * @return
	 */
	private static String createRecordIndex(File podding) {
		String p=podding.getPath();
		String parentPath= p.substring(0, p.lastIndexOf(podding.getName()))+"/history/";
		
		String sd=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		File f=new File(parentPath);
		f.mkdirs();
		File[] fArr=f.listFiles();
		int index=1;
		for(int i=0;i<fArr.length;i++){
			if(fArr[i].getName().contains(sd)){
				index++;
			}
		}
		File recordIndexFile=new File(parentPath+sd+"-history--"+index);
		recordIndexFile.mkdirs();
		return recordIndexFile.getPath();
	}
	//�ļ��ݹ�copy
		//�������� ���ݲ����е��ļ� �ļ���ȥ��Ŀ�������ļ�����ֱ�Ӵ���
		/**
		 * 
		 * @param podding �����ļ�
		 * @param project ��Ŀ�ļ�
		 * @param recordIndexPath ���ݱ���ĸ�·��
		 * @param index project�����ֵ�λ��,������������·����λ��ʱ����Ҫ��
		 * @throws Exception 
		 */
		private static void recursiveTraverseMoveAndCopy(File podding, File project,String recordIndexPath, int index) throws Exception {
			File[] fArr=podding.listFiles();
			String sProject=project.getPath();
			File ex=null;
			boolean isExist=true;
			for(File i:fArr){
				ex=new File(sProject+"/"+i.getName());//�ļ�ȫ��~ֻ�����ļ�
				isExist=ex.exists();
				if(i.isFile()){//���ļ�
					if(isExist){//���ڵĻ� ����
						File ft=new File(recordIndexPath+"/"+ex.getPath().substring(index));
						ft.getParentFile().mkdirs();
						ft.createNewFile();
						copyByTransfer(ex,ft);
					}else{//�����ڵĻ�����
						ex.createNewFile();
					}
					copyByTransfer(i,ex);
				}else{//��Ŀ¼
					if(!isExist){//��Ŀ�в����ڵĶ�ӦĿ¼������Ŀ¼ �����ݹ�
						ex.mkdirs();
					}
					recursiveTraverseMoveAndCopy(i,ex,recordIndexPath,index);
				}
			}
			
			
		}
	/**
	 * �ݹ���֤�ļ��Ƿ����
	 * �Բ���Ϊ׼ ͬʱ�ݹ� ��������Ŀ����ͬһ����,֮ǰ��ʽ���ǿӵ�~~
	 * @param podding
	 * @param project
	 * @return
	 */
	private static boolean recursiveTraverseCheck(File podding, File project) {
		
		File[] fArr=podding.listFiles();
		String sProject=project.getPath();
		File ex=null;
		boolean isExist=true;
		boolean isSameStructure=true;
		//����
		//������ļ��򲻻�ȡlist ֱ�ӿ���һ����û�� ����Ļ�ҲҪ���Ǳ���û�� �����еĻ���Ҫ�Ƚ��¼�Ŀ¼
		for(File i:fArr){
			ex=new File(sProject+"/"+i.getName());
			isExist=ex.exists();
			if(isExist==false)//��仰����˼�� ����������ֻҪ��һ�������д��ڶ���Ŀ�в����ڵ��ļ�/�ļ��� ��ṹ�ǲ�һ���� ���false~
				isSameStructure=false;
			if(i.isFile()){
				System.out.println("�ļ� : "+ex.getPath() +"���� : "+isExist );
			}else{
				System.out.println("Ŀ¼ : "+ex.getPath() +"���� : "+isExist );
				if(isExist){
					boolean b=recursiveTraverseCheck(i,ex);
					if(b==false)
						isSameStructure=false;
				}
			}
		}
		return isSameStructure;
		
	}
    
    public void setPodding(String podding) {
		this.podding = podding;
	}
	public void setProject(String project) {
		this.project = project;
	}
	
    
    
}
