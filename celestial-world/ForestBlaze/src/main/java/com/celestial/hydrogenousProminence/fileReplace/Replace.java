package com.celestial.hydrogenousProminence.fileReplace;

import java.util.List;
import java.util.Map.Entry;

import com.celestial.agniRadiance.EzUtil.Util_File;
import com.celestial.agniRadiance.entity.FileReader;
import com.celestial.agniRadiance.entity.Print;
/**
 * �ļ��滻��,��ȡ�ļ�һ���֣��ŵ���һ���ļ�ĳһλ����ȥ<br/>
 * Ҫ�Զ�ȡ���ļ�Ƭ�ν��в��������������и�дdoTrans()������<br/>
 * ��ƫ��ȫ�ķ�ʽ������ơ�<br/>
 * @author Administrator
 *
 */
public class Replace {
	
	private RepDependency depend;
	private FileReader f ;
	private String charset = "";
	private Print p = new Print(true);
	
	public Replace(RepDependency depend) {
		init(depend,"utf-8");
	}
	
	public Replace(RepDependency depend,String charset) {
		init(depend,charset);
	}
	
	private void init(RepDependency depend, String charset) {
		this.depend = depend;
		this.charset = charset;
		f = new FileReader(depend.getSourceFilePath(),false,this.charset);
	}

	public void executeReplace(){
		for(Entry<String,String[]> ei: depend.getRepMap().entrySet()){
			boolean isSuccess = replaceOne(ei.getValue());
			p.println("�ļ���" + ei.getValue()[4] + "�滻����" + (isSuccess==true?"�ɹ�":"ʧ�ܣ�"));
		}
	}

	/**
	 * �ṹ��RepDependency��������<br/>
	 * [sn_flag,en_flag,target_sn_flag,target_en_flag,targetPath]
	 * @param value
	 * @return
	 */
	private boolean replaceOne(String[] repArr) {
		try {
			String targetFilePath = repArr[4];
			List<String> sourceList = f.selectAllLineBetweenRegex2_removeHeadTail(repArr[0], repArr[1]).getLineList();
			List<String> targetList = doTrans(sourceList);
			FileReader targetFile = new FileReader(targetFilePath,false,charset);
			int start = targetFile.getRegexPosition(repArr[2]),
				end = targetFile.getRegexPosition(repArr[3]);
			if(!(start > 0 && end > start))
				throw new RuntimeException("�ļ���" + targetFilePath + " �Ŀ�ʼ�±꣺" + repArr[2] + " �ͽ����±꣺" + repArr[3] + " ƥ������");
			FileReader endFile = targetFile.replaceList(start, end, targetList);
			Util_File.printFile(endFile.getLineList(), targetFilePath, charset);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * ��ԭ�����ļ�����תΪ�µ�ת����ʽ��<br/>
	 * Ĭ�ϲ����κ��޸ġ�<br/>
	 * Ҫ��ʲô�޸��򴴽����ิд�˷���.<br/>
	 * @param sourceList
	 * @return
	 */
	public List<String> doTrans(List<String> sourceList) {
		return sourceList;
	}
}
