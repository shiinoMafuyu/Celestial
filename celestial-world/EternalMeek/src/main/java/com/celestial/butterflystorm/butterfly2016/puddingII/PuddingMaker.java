package com.celestial.butterflystorm.butterfly2016.puddingII;

import java.io.File;

import com.celestial.agniRadiance.EzUtil.Util_File;
/**
 * <b>�޸ļ�¼��</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2016-5-22
 * </li>
 * </p>
 * 
 * <b>��˵����</b>
 * <p> 
 * 
 * </p>
 */
public class PuddingMaker {
	/**--------------һ�����ɲ��ı���ֵ---------------*/
	/**
	 * �����ַ���s1��Ӧ���ļ�
	 */
	File s1File;
	/**
	 * Դ�ļ�home
	 * java��src��
	 * һ���ļ���webRoot��
	 */
	String sourceHome; 
	/**
	 * Ҫ�������ļ���home
	 * һ���ļ�webRoot��
	 * java�ļ������Ӧ��.class�ļ� ��webRoot/web-inf/classes��
	 */
	String srcFileHome;
	/**
	 * Ŀ��·��home
	 * һ���ļ���Ŀ����
	 * java��Ӧ��class�ļ� ��Ŀ�� + web-inf + classes
	 */
	String destinationHome ;
	/**
	 * �ļ���
	 */
	String fileName;
	/**
	 * ��Ŀ��
	 */
	String projectName;
	/**
	 * �Ƿ���java�ļ�
	 */
	boolean isJava;
	
	/**--------------һ�����ɲ��ı���ֵ---------------*/
	File srcFile ;
	File desFile ;
	 
	String tail = null;
	/**
	 * 
	 * @param s1   һ���ļ�
	 * @param s2   ��ĿĿ¼
	 */
	public PuddingMaker(String s1,String s2) {
		this.s1File = new File(s1);
		this.projectName = s2.substring(s2.lastIndexOf("/")+1, s2.length());
		this.fileName = s1.substring(s1.lastIndexOf("/")+1, s1.length());
		//���ɺ���Ŀ����Ŀ���·��
		this.destinationHome = s1.substring(0, s1.lastIndexOf("/"))+"/"+projectName;
		
		//���ɲ���·��
		this.isJava = fileName.endsWith(".java");
		if(isJava){
			this.sourceHome = s2+"/src";
			this.srcFileHome = s2+"/WebRoot/WEB-INF/classes";
			//������java�ļ� Ŀ���ļ�·���ڸ�Ŀ¼��/WEB-INF/classes����
			this.destinationHome += "/WEB-INF/classes";
			
		}else{
			this.sourceHome = s2+"/WebRoot";
			this.srcFileHome = s2+"/WebRoot";
		}
	}
	/**
	 *  1 :�����ɹ�
	 * -1 :�ļ�δ�ҵ�
	 * -2 :����Ŀ���ļ�ʧ��
	 * -3 :����ʧ��
	 * -4 :����ʧ��
	 * @return ���
	 */
	public int makePudding(){
		//�ҵ��ļ�
		if(!findGelatin()){
			return -1;
		}
		//������Դ��Ŀ��·��
		if(!prepareFood()){
			return -2;
		}
		//����
		if(!cookDinner()){
			return -3;
		}
		//���
		if(isJava){
			foodIngredients();
		}
		System.out.println("�ļ����ɲ����ɹ� : " + this.fileName );
		return 1;
	}
	/**
	 * ����û���ڲ��� �еĻ�����
	 * ��ȥ�ı���е�ֵ
	 * @return
	 */
	private boolean foodIngredients() {
		boolean b= true;
		try {
			String parentDes = desFile.getParent().replaceAll("\\\\", "/");
			String firstName=fileName.split("\\.")[0];
			File[] fArr=srcFile.getParentFile().listFiles();
			for(File i : fArr){
				String iName = i.getName();
				if(iName.contains(firstName+"$") && iName.endsWith(".class")){
					File iDesFile = new File(parentDes + "/"+iName);
					Util_File.copyByCmd(i, iDesFile);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			b = false;
		}
		return b;
	}
	/**
	 * �����ļ�
	 * @return
	 */
	private boolean cookDinner() {
		boolean b = true;
		try {
			Util_File.copyByCmd(srcFile, desFile);
		} catch (Exception e) {
			e.printStackTrace();
			b = false;
		}
		return b;
	}
	/**
	 * ����׼���ļ�
	 * @return
	 */
	private boolean prepareFood() {
		boolean b= true;
		try {
			srcFile =new File ( srcFileHome + tail );
			
			if( srcFile != null && srcFile.exists() && srcFile.isFile()){
				desFile = new File(destinationHome + tail);
				desFile.getParentFile().mkdirs();
				desFile.createNewFile();
			}else{
				System.out.println("Դ�ļ�������!�޷��������ɲ���!");
			}
//			srcFile = 
		} catch (Exception e) {
			e.printStackTrace();
			b = true;
		}
		return b;
	}
	/**
	 * ȥsourceHome�в�����Ҫ���ļ�,
	 * @return �ҵ�����true,����false
	 */
	private boolean findGelatin() {
		boolean b =true;
		try {
			find(new File(this.sourceHome));
			if(tail ==null )
				b=false;
		} catch (Exception e) {
			e.printStackTrace();
			b=false;
		}
		return b;
	}
	/**
	 * ������findGelatin()�ĵݹ���ҷ���
	 * �õݹ鷵���ַ���Ҳ����,���ǲ��ܲ鿴ȫ���ļ���
	 * @param file
	 */
	private void find(File file) {
		if(file.isDirectory()){
			File[] fArr=file.listFiles();
			for(File i : fArr){
				find(i);
			}
		}
		else if(file.isFile()){
			if(Util_File.compareFile(file,this.s1File)){
				if(this.tail !=null ){
					System.out.println("���� : �ҵ��� "+this.fileName+" �ļ���ֹһ��,��ע��!");
				}
				String sFile = file.getAbsolutePath();
				this.tail = sFile.substring(this.sourceHome.length(),sFile.length());
				if(isJava){
					tail = tail.substring(0,tail.lastIndexOf("java"))+"class";
				}
			}
		}else{
			throw new RuntimeException("�����ļ�,����Ŀ¼�쳣");
		}
		
	}
	public String getDestinationHome() {
		return destinationHome;
	}
	public String getProjectName() {
		return projectName;
	}
	public String getSourceHome() {
		return sourceHome;
	}
	public String getSrcFileHome() {
		return srcFileHome;
	}
	public String getFileName() {
		return fileName;
	}
	public boolean isJava() {
		return isJava;
	}
	public File getS1File() {
		return s1File;
	}
	public File getSrcFile() {
		return srcFile;
	}
	public File getDesFile() {
		return desFile;
	}
	public String getTail() {
		return tail;
	}
	
	
	
}
