package com.celestial.misdirection.JunitPlay;

import java.util.List;

import com.celestial.agniRadiance.EzUtil.UtilCollection;
import com.celestial.agniRadiance.EzUtil.UtilString;
import com.celestial.agniRadiance.entity.FileReader;
import com.celestial.agniRadiance.entity.Tag;
/**
 * 
 * <b>修改记录：</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2016-8-25
 * </li>
 * </p>
 * 
 * <b>类说明：</b>
 * <p> 
 * 一个黑盒自动测试协议功能的类.<br/>
 * 要求编写测试文档<br/>
 * 现在这个类里含有的某些方法只能用于这个情景下的测试,有的则可用于通用的测试.<br/>
 * 目前还没有测试其他,如果有的话再以继承的方式来实现多态和重用就行.<br/>
 * </p>
 */
public class UserCase {
	/**
	 * 请求的连接
	 */
	private String url;
	/**
	 * 用例名
	 */
	private String userCaseName;
	/**
	 * 用例输入标签
	 */
	private Tag tagInput;
	/**
	 * 用例请求信息(配合url食用)
	 */
	private String requestMessage;
	/**
	 * 验证标签
	 */
	private Tag tagVerify;
	/**
	 * 请求后返回的信息.
	 */
	private Tag tagOutput;
	/**
	 * 是否已经成功发送请求获取到数据标志.
	 */
	private boolean successLinked;
	
	private String[] depArr;
	/**
	 * <b>方法说明：</b>
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
	 * <b>方法说明：</b>
	 * <ul>
	 * 验证用例是否成功匹配.
	 * </ul>
	 * @return
	 */
	private boolean policeTeaTime() {
		if(!this.successLinked)
			throw new RuntimeException(this.userCaseName + "没有成功获取返回信息.请进行callPolice()操作连接服务器获取信息.");
		System.out.println("开始验证用例 :" + this.userCaseName);
		boolean b = true;
		try {
			for(String si : this.tagVerify.getMapColor()){
				String[] sArr = si.split(" ");
				Tag verify = this.tagVerify.getTagByNames(sArr);
				Tag output = this.tagOutput.getTagByNames(sArr);
				String regxValue = verify.getValue();
				regxValue = ___getVariableFromINPUT(regxValue,verify);
				if(UtilString.matchAllSameRegx(output.getValue(), regxValue)){
					System.out.println("	标签:" + verify.getTagName() + "	sucessed!");
				}else{
					System.out.println("	标签:" + verify.getTagName() + "	faild!");
				}
			}
		} catch (Exception e) {
			b = false;
			e.printStackTrace();
			throw new RuntimeException("用例 : " + this.userCaseName + "输出结果与预期对比失败!");
		}
		if(b)
			System.out.println("用例 : " + this.userCaseName + "  匹配验证成功!");
		else
			System.out.println("用例 : " + this.userCaseName + "  匹配验证失败!");
		return b;
	}


	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * output中有需要用到input的输入值的情况,娶过来.<br/>
	 * </ul>
	 * @param regxValue
	 * @param verify 
	 * @return
	 */
	private String ___getVariableFromINPUT(String regxValue, Tag verify) {
		try {
			int n = -1,i = 0;
			while(true){
				if(UtilString.matchAllSameRegx(regxValue, ".*cite\\["+i+"\\].*")){
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
				throw new RuntimeException("verify中标签 :" + verify.getTagName() + "cite参数个数不匹配!");
			
			for(int j = 0 ; j <= n ; j++){
				String[] colorMap = valueMap[j].split("\\.");
				String inputTagValue = this.tagInput.getTagByNamesReal(colorMap).getValue();
				regxValue = regxValue.replaceAll("cite\\[" + j + "\\]", "("+inputTagValue+"){1}");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("verify中标签 :" + verify.getTagName() +"验证字符串 : " + regxValue + "cite值替换失败");
		}
		return regxValue;
	}





	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 向服务器发送请求,获取返回信息.
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
			throw new RuntimeException("用例 : " + this.userCaseName + "向服务器发送请求失败!");
		}
		
		return this.successLinked;
	}


	/**
	 * 用包含USERCASE的xml list生成USERCASE对象.
	 * <b>构造方法</b>
	 * <br/>
	 * @param xmlineList 包含USERCASE的xml list
	 */
	public UserCase(List<String> xmlineList){
		init(UtilCollection.transListToLine(xmlineList));
	}
	/**
	 * 用包含USERCASE xml的string对象生成USERCASE对象.
	 * <b>构造方法</b>
	 * <br/>
	 * @param xmlString
	 */
	public UserCase(String xmlString){
		init(xmlString);
	}


	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 初始化
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
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取依赖用例名sArr[]
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
	 * <b>方法说明：</b>
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
