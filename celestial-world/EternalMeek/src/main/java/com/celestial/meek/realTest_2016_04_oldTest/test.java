package com.celestial.meek.realTest_2016_04_oldTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.channels.FileChannel;
import java.text.SimpleDateFormat;
import java.util.Date;

@SuppressWarnings("unused")
public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		//���Թܵ������ļ� ������ֻ�ܿ����ļ�
		//teCopyByTransfer();
		//�����ļ�copy
		//teFileCreate();
		//�����ļ�listFile()����
		//teFileList();
		//���Եݹ����
		//teCheck();
		
		File podding=new File("E:/te/test/pod");
		File project=new File("E:/te/test/A");
		boolean  b1=checkFile(podding);
		boolean b2=checkFile(project);
		if(!(b1&&b2)){
			System.out.println("�ļ�Ŀ¼������ �������~");
			return;
		}
		
		String recordIndexPath=createRecordIndex(podding);
		recursiveTraverseMoveAndCopy(podding,project,recordIndexPath,project.getPath().lastIndexOf("\\"));
		
	}
	/**
	 * ��������Ŀ¼
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
	
	//�ݹ���֤�ļ��Ƿ����
	//�Բ���Ϊ׼ ͬʱ�ݹ� ��������Ŀ����ͬһ����,֮ǰ���ǿӵ�~~
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
	//�����ļ�List
	private static void teFileList() {
		File f=new File("E:/te");
		File[] fArr=f.listFiles();
		String[] s= f.list();
		for(File i:fArr){
			System.out.print(i.getPath());
			if(i.isFile()){
				System.out.println("  �ļ�");
			}else{
				System.out.println("  �ļ���");
			}
		}
		
	}
	/**
	 * ���Եݹ�����ļ��Ǹ�����
	 */
	private static void teCheck() {
		File podding=new File("E:/te/test/pod");
		File project=new File("E:/te/test/A");
		
		System.out.println(podding!=null);
		System.out.println(podding.exists());
		System.out.println(!podding.isFile());
		
		/*System.out.println(podding.getPath());
		File n=new File(podding.getPath()+"/x");
		System.out.println(n.getPath()+"  ex? "+n.exists());*/
		boolean b=recursiveTraverseCheck(podding,project);
		System.out.println(b);
	}
	//�ļ����������ļ��д�������
	//����:Ҫ���������ڵ�Ŀ¼�µ�Ŀ¼��file.mkdirs()����	Ҫ���������ڵ�Ŀ¼�µ��ļ��Ȱ�֮ǰ�Ĵ���Ŀ¼����file.createNewFile()�����ļ�
	//����ļ�,�ļ��д�����ôfile.mkdirs() file.createNewFile()��ִ��
	private static void teFileCreate() throws Exception {
		File f=new File("E:/te/h/h2");
		File f2=new File("E:/te/h/h2/lp.txt");
		/*System.out.println("�ļ��д���: "+f.exists());
		System.out.println("�ļ�����: "+f2.exists());*/
		
		File f3=new File("w2.txt");
		/*File f4=new File("D:/workspace/test/lib");
		System.out.println("f3 ex?:"+f3.exists());
		System.out.println("f3 is file?:"+f3.isFile());
		
		System.out.println("f4 ex?:"+f4.exists());
		System.out.println("f4 is file?:"+f4.isFile());*/
		f.mkdirs();
		f2.createNewFile();
		
		System.out.println(f2.exists());
		//System.out.println(copyByTransfer(f3,f2));
		
	}
	//���Թܵ�����
	private static void teCopyByTransfer() throws Exception {
		File in=new File("C:/Users/Administrator/Desktop/te2");
		File out=new File("E:/te2");
		System.out.println(copyByTransfer(in,out));
	}
	/**
	 * ͨ���ܵ������ļ�
	 * @param f1 �����ļ�
	 * @param f2 ����ļ�
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("resource")
	private static long copyByTransfer(File f1, File f2) throws Exception{
		long time=new Date().getTime();
        int length=1,size=20971520;
        FileChannel inC=new FileInputStream(f1).getChannel();
		FileChannel outC=new FileOutputStream(f2).getChannel();
        while(true){
        	//���Դ�ļ���ָ��λ�úʹ�Сһ����,˵��������,����
            if(inC.position()==inC.size()){
                inC.close();
                outC.close();
                return new Date().getTime()-time;
            }
            //���������������� ����˵����ͨ���ܵ����䶫����Ŵ��������ɿ�,���û��20m�����Ͱ�ʵ�ʳߴ�д��;�������20m��������д��20m ʣ�µ��´���˵~
            if((inC.size()-inC.position())<size)//�����С��ȥλ��С�� 20m ����length=�ߴ��
                length=(int)(inC.size()-inC.position());
            else
                length=size;//���򳤶�=20m
            inC.transferTo(inC.position(),length,outC);
            inC.position(inC.position()+length);
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

	@SuppressWarnings("resource")
	private static void te1 () throws Exception{
		File f=new File("w.txt");
		File f2=new File("C:/Users/Administrator/Desktop");
		PrintWriter pw=new PrintWriter(new OutputStreamWriter(new FileOutputStream(f,false),"utf-8"),true);
		BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(f2)));
		String s=null;
		while((s=br.readLine())!=null){
			pw.println("");
		}
		pw.close();
		f.renameTo(new File("w2.txt"));
	}

}
