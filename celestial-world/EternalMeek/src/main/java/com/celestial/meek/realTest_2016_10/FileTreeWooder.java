package com.celestial.meek.realTest_2016_10;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.celestial.agniRadiance.EzUtil.Util_File;
import com.celestial.agniRadiance.EzUtil.Util_Normal;


public class FileTreeWooder {
	static{
		
	}
	
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		FileTreeWooder f =new FileTreeWooder();
		String filePath = "C:/Users/Administrator/Desktop/������/00002�Ϻ���ó��Ҫ������Ĳ���";
		String destHead = "C:/Users/Administrator/Desktop/������/0000-�Ϻ���ó�����Ȳ��Բ���(�������߿���)";
		boolean isRuled = f.checkAllContainFiles(filePath);
		if(isRuled){
			f.zhengHe(filePath,destHead);
		}
		else
			System.out.println("��淶������,����Ŀ�ļ����ڲ������е�filesĿ¼��.");
		
	}
	/**=======================================================���뷴������ �����޸� wangzg 2016��7��20��17:23:32====================================================*/
																             //�������� �ͷ�����дһ������ �r(�s���t)�q
	
	/**=========================================================���뷴�����಻���޸� wangzg 2016��7��20��17:23:37===================================================*/
	/**
	 * 
	 * @param filePath	������������Ŀ¼
	 * @param destHead	���ϵ��ĸ����� (��Ҫ������Ŀ¼����Ŀ¼)
	 * @param projects	��Ŀ����
	 * @param dates		���ڹ���
	 */
	public void zhengHe(String filePath, String destHead, String[] projects,
			String[] dates) {
		
		
	}
	
	
	/**=======================================================ʵ�����÷��� �����޸� wangzg 2016��7��20��11:23:56====================================================*/
	/**
	 * �����ļ�
	 * @param filePath	������������Ŀ¼
	 * @param destHead	���ϵ��ĸ����� (��Ҫ������Ŀ¼����Ŀ¼)
	 * @param projects	���ڹ���
	 */
	public void zhengHe(String filePath, String destHead, String[] projects) {
		//Ϊ����ʱ
		//Ԥ�������ߵ�·�� ����α���ԵĹ����ļ���
		File file = new File(filePath);
		File[] files = file.listFiles();
		copyAllByTimeMethodList = new ArrayList<Object>();
//		copyAllByTimeMethodList
		
		
	}
	private boolean zhengHe_filterProject(Object dynamicParam){
		
		return false;
	}
	/**
	 * ����Ƿ�ÿ�������ļ��ж�����filesĿ¼
	 * @param filePath
	 * @return true �� ; false ��
	 */
	public boolean checkAllContainFiles(String filePath) {
		File f = new File(filePath);
		File[] files = f.listFiles();
		System.out.println("�ļ����� : "+files.length);
		int filesCount = 0;
		for(File i : files){
			File[] fi = i.listFiles();
			for(File j : fi){
				String name = j.getName();
				if("files".equals(name)){
					filesCount++;
				}
			}
		}
		System.out.println("���ƺ�files:" +filesCount +"   û������: "+(filesCount == files.length));
		return filesCount == files.length;
		
	}

	/**��ʵ��ͻȻ�뵽 ����ڽ��в���֮ǰ����һ���Ƿ���в�����ֵ true or false ,�ǲ��Ǿ���ͨ�����ֵ�����filter��������*/
	/**Ȼ���Ѿ�д�� ������Ī������ͼ�����ܸ�ԭ��!*/
	/**
	 * �����ļ�
	 * @param filePath	������������Ŀ¼
	 * @param destHead	���ϵ��ĸ����� (��Ҫ��filePath����Ŀ¼)
	 */
	public  void zhengHe(String filePath ,String destHead) {
		File file = new File(filePath);
		File[] files = file.listFiles();
		
		try {
			for(File i : files){
				String  head = i.getAbsolutePath().replaceAll("\\\\", "/");
				totalNum = 0;
				needNum = 0;
				susscessNum = 0;
				copyAllByTime(i,head,destHead);
				System.out.println(i.getName() +"  -->  ���� :" + totalNum + "  �追��: "+needNum + "  �ɹ� : " + susscessNum +"\n ʧ��:-------------------------------------");
				for(String j : failList){
					System.out.println(j);
				}
				System.out.println("-------------------------------------");
			}
		} catch (Exception e) {
			System.out.println("�����쳣,������ֹ!");
		}
		
	}
	
	/**=======================================================ʵ�����÷��� �����޸� wangzg 2016��7��20��11:23:56====================================================*/
	
	
	/**
	 * ԭ��ԭ�������ҵ�����~
	 * ��þ�����~
	 * ˬ���Һ�������~
	 */
	
	
	
	/**=======================================================�ڲ����� ��ֹ��Ϸ 2016��7��20��11:21:05 wangzg======================================================*/
	/**=======================================================����ֻ����ʹ�� �������޸�===========================================================================*/
	/**�ܹ��ļ�����*/
	int totalNum = 0;
	/**��Ҫ�����ļ�����*/
	int needNum = 0;
	/**�����ɹ�����*/
	int susscessNum = 0;
	/**ʧ���ļ�*/
	List<String> failList = new ArrayList<String>();
	/**�Ѿ��������ļ�*/
	Map<String,Long> copyedMap = new HashMap<String, Long>();
	/**=======================================================����ֻ����ʹ�� �������޸�===========================================================================
	 * @throws Exception */
	
	private  void copyAllByTime(File file, String head, String destHead,List<Object> methodList) throws Exception{
		boolean b = true ;
		try {
			System.out.println("��ʼִ�з��䷽��..");
			b = Util_Normal.excuteReflectObjectAll(methodList);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		if(b){
			System.out.println("���䷽��ȫ��ִ�гɹ�.");
			copyAllByTime(file, head, destHead);
		}
			
	}
	List<Object> copyAllByTimeMethodList = null;
	/**
	 * �ݹ������Ŀ����<br/>
	 * ��˵�� ���Ǽ򵥵İ�һ���ļ����µ��������ݿ�����һ���ط�,������ظ���������޸�ʱ�䱣��.<br/>
	 * @param file	Ҫ�������ļ�/Ŀ¼ <br/>
	 * @param head	������ļ�ͷ <br/>
	 * @param destHead	����������
	 * @throws Exception 
	 */
	@SuppressWarnings("deprecation")
	private  void copyAllByTime(File file, String head, String destHead) throws Exception {
		//head ������չ
		boolean b = true ;
		try {
			b = Util_Normal.excuteReflectObjectAll(copyAllByTimeMethodList);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		if(!b){
			return;
		}
		//body ��������
		if(file.isFile()){
			totalNum ++;
			try {
				String tail =  file.getAbsolutePath().replaceAll("\\\\", "/").substring(head.length());
				/*if(tail.contains("/files/SelfOpenAccount/")){//���˵�selfOpenAccount
					return;
				}*/
				File destFile = new File(destHead + tail);
				File path = new File(destFile.getParent());
				
				//����ǰĿ��λ�ñ��������ļ�  ����������ǲ��ǱȽ���  �µĻ��ſ�
				boolean b1;
				if(path.exists()){
					b1=true;
				}else{
					b1 = path.mkdirs();
				}
				boolean b2;
				boolean shouldCopy;
				if(destFile.exists()){
					b2 = true;
					//�ļ����ڱȽ�ʱ��
					Date dateAlready =	new Date(copyedMap.get(tail));
					Date dateNow = new Date(file.lastModified());
					System.out.println("�ļ��Ѵ��� ���бȽ�   ---- �����ļ� :" + dateNow.toLocaleString() +" --- ��ǰ�ļ�: "+dateAlready.toLocaleString() +" --- Ϊtrue ��: " + dateNow.after(dateAlready));
					if(dateNow.after(dateAlready)){
						shouldCopy = true;
					}else{
						shouldCopy = false;
					}
				}else{
					b2 = destFile.createNewFile();
					shouldCopy = true;
				}
				
				//�ļ����ڵĻ����ܿ���
				if(!(b1 && b2)){
					throw new RuntimeException("û�����ļ� �����ɹ�");
				}
				if(shouldCopy){
					needNum++;
					Util_File.copyByTransfer(file, destFile);
					copyedMap.put(tail, file.lastModified());
					susscessNum++;
				}
			} catch (Exception e) {
				failList.add(file.getAbsolutePath().replaceAll("\\\\", "/"));
			}
		}
		else if(file.isDirectory()){
			File[] files = file.listFiles();
			for(File i : files){
				copyAllByTime(i,head,destHead);
			}
		}
		else{
			throw new RuntimeException("�����ļ�Ҳ�����ļ���,ʲô��!");
		}
		
	}
	/**=======================================================�ڲ����� ��ֹ��Ϸ 2016��7��20��11:21:05 wangzg======================================================*/
}
