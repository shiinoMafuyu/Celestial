package com.celestial.misdirection.JunitPlay;

import java.util.List;

import com.celestial.agniRadiance.EzUtil.Util_Collection;
import com.celestial.agniRadiance.EzUtil.Util_String;
import com.celestial.agniRadiance.entity.FileReader;
import com.celestial.agniRadiance.entity.Tag;
/**
 * 
 * <b>�޸ļ�¼��</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2016-8-25
 * </li>
 * </p>
 * 
 * <b>��˵����</b>
 * <p> 
 * һ���ں��Զ�����Э�鹦�ܵ���.<br/>
 * Ҫ���д�����ĵ�<br/>
 * ����������ﺬ�е�ĳЩ����ֻ����������龰�µĲ���,�е��������ͨ�õĲ���.<br/>
 * Ŀǰ��û�в�������,����еĻ����Լ̳еķ�ʽ��ʵ�ֶ�̬�����þ���.<br/>
 * </p>
 */
public class UserCase {
	/**
	 * ���������
	 */
	private String url;
	/**
	 * ������
	 */
	private String userCaseName;
	/**
	 * ���������ǩ
	 */
	private Tag tagInput;
	/**
	 * ����������Ϣ(���urlʳ��)
	 */
	private String requestMessage;
	/**
	 * ��֤��ǩ
	 */
	private Tag tagVerify;
	/**
	 * ����󷵻ص���Ϣ.
	 */
	private Tag tagOutput;
	/**
	 * �Ƿ��Ѿ��ɹ����������ȡ�����ݱ�־.
	 */
	private boolean successLinked;
	
	private String[] depArr;
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param args 
	 */
	public static void main(String[] args) {
		
		
		FileReader f = new FileReader("C:/Users/Administrator/Desktop/parese2/c.xml");
		List<List<String>> xmlist = f.selectAllLineBetweenRegexList("<USERCASE index=\"[0-9]+\".*", "</USERCASE>");
		
		
		
		/*List<String> ls = xmlist.get(0);
		Tag tt = new Tag(DBUtil3_parseTxt.transListToLine(ls));*/
		
		UserCase us = new UserCase(xmlist.get(0));
		us.callPolice();
		boolean userCaseSuccess = us.policeTeaTime();
		if(userCaseSuccess)
			System.out.println(us.getTagOutput().getTagByNames("REP","RETCODE").getValue());
		
		
		
		
	}
	



	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ��֤�����Ƿ�ɹ�ƥ��.
	 * </ul>
	 * @return
	 */
	private boolean policeTeaTime() {
		if(!this.successLinked)
			throw new RuntimeException(this.userCaseName + "û�гɹ���ȡ������Ϣ.�����callPolice()�������ӷ�������ȡ��Ϣ.");
		System.out.println("��ʼ��֤���� :" + this.userCaseName);
		boolean b = true;
		try {
			for(String si : this.tagVerify.getMapColor()){
				String[] sArr = si.split(" ");
				Tag verify = this.tagVerify.getTagByNames(sArr);
				Tag output = this.tagOutput.getTagByNames(sArr);
				String regxValue = verify.getValue();
				regxValue = ___getVariableFromINPUT(regxValue,verify);
				if(Util_String.matchAllSameRegx(output.getValue(), regxValue)){
					System.out.println("	��ǩ:" + verify.getTagName() + "	sucessed!");
				}else{
					System.out.println("	��ǩ:" + verify.getTagName() + "	faild!");
				}
			}
		} catch (Exception e) {
			b = false;
			e.printStackTrace();
			throw new RuntimeException("���� : " + this.userCaseName + "��������Ԥ�ڶԱ�ʧ��!");
		}
		if(b)
			System.out.println("���� : " + this.userCaseName + "  ƥ����֤�ɹ�!");
		else
			System.out.println("���� : " + this.userCaseName + "  ƥ����֤ʧ��!");
		return b;
	}


	/**
	 * <b>����˵����</b>
	 * <ul>
	 * output������Ҫ�õ�input������ֵ�����,Ȣ����.<br/>
	 * </ul>
	 * @param regxValue
	 * @param verify 
	 * @return
	 */
	private String ___getVariableFromINPUT(String regxValue, Tag verify) {
		try {
			int n = -1,i = 0;
			while(true){
				if(Util_String.matchAllSameRegx(regxValue, ".*cite\\["+i+"\\].*")){
					n++;
					i++;
				}else{
					break;
				}
			}
			if(n < 0)
				return regxValue;
			String[] valueMap = verify.getPropertyMap().get("cite").split(",");
			if(valueMap.length != n+1)
				throw new RuntimeException("verify�б�ǩ :" + verify.getTagName() + "cite����������ƥ��!");
			
			for(int j = 0 ; j <= n ; j++){
				String[] colorMap = valueMap[j].split("\\.");
				String inputTagValue = this.tagInput.getTagByNamesReal(colorMap).getValue();
				regxValue = regxValue.replaceAll("cite\\[" + j + "\\]", "("+inputTagValue+"){1}");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("verify�б�ǩ :" + verify.getTagName() +"��֤�ַ��� : " + regxValue + "citeֵ�滻ʧ��");
		}
		return regxValue;
	}





	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ���������������,��ȡ������Ϣ.
	 * </ul>
	 * @return
	 */
	private boolean callPolice() {
		this.successLinked = false;
		try {
			String s = HttpUtils.doPost(this.url, this.requestMessage, HttpUtils.GBK);
			this.tagOutput = new Tag(s);
			this.successLinked = true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("���� : " + this.userCaseName + "���������������ʧ��!");
		}
		
		return this.successLinked;
	}


	/**
	 * �ð���USERCASE��xml list����USERCASE����.
	 * <b>���췽��</b>
	 * <br/>
	 * @param xmlineList ����USERCASE��xml list
	 */
	public UserCase(List<String> xmlineList){
		init(Util_Collection.transListToLine(xmlineList));
	}
	/**
	 * �ð���USERCASE xml��string��������USERCASE����.
	 * <b>���췽��</b>
	 * <br/>
	 * @param xmlString
	 */
	public UserCase(String xmlString){
		init(xmlString);
	}


	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ��ʼ��
	 * </ul>
	 * @param xmlString
	 */
	private void init(String xmlString) {
		String s = "<INPUT>", e = "</INPUT>";
		this.requestMessage = xmlString.substring(xmlString.indexOf(s)+s.length(),xmlString.indexOf(e));
		Tag t = new Tag(xmlString);
		this.userCaseName = t.getPropertyMap().get("name");
		this.depArr = ___getDependenceUserCaseArr(t.getPropertyMap().get("dep"));
		this.url = t.getDirectChildTag("URL").getValue();
		this.tagInput = t.getTagByNamesReal("INPUT","MEBS_MT");
		this.tagVerify = t.getTagByNamesReal("VERIFY","MEBS_MT");
		
	}
	
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ��ȡ����������sArr[]
	 * </ul>
	 * @param string
	 * @return
	 */
	private String[] ___getDependenceUserCaseArr(String dep) {
		String[] sArr = null;
		if(dep !=null && !"".equals(dep)){
			sArr = dep.split(",");
		}
		return sArr;
	}




	/**
	 * <b>����˵����</b>
	 * <ul>
	 * test method .. to be deleted...
	 * </ul>
	 * @return
	 */
	@Deprecated
	private boolean ___callPolice() {
		boolean b = true;
		this.successLinked = b;
		return b;
	}





	
	
	public void setTagOutput(Tag tagOutput) {
		this.tagOutput = tagOutput;
	}





	public String getUrl() {
		return url;
	}





	public String getUserCaseName() {
		return userCaseName;
	}





	public Tag getTagInput() {
		return tagInput;
	}





	public String getRequestMessage() {
		return requestMessage;
	}





	public Tag getTagVerify() {
		return tagVerify;
	}





	public Tag getTagOutput() {
		return tagOutput;
	}





	public boolean isSuccessLinked() {
		return successLinked;
	}
	
	
}
