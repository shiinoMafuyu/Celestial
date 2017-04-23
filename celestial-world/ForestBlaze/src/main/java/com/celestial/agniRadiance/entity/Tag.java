package com.celestial.agniRadiance.entity;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.celestial.agniRadiance.EzUtil.Util_String;


	/**
	 * 
	 * <b>�޸ļ�¼��</b> 
	 * <p>
	 * <li>
	 * 
	 *                        ---- Administrator 2016-8-15<br/>
	 *  һ����ǩ����;<br/>
	 *  ����һ��xml��ǩ�ַ����������еݹ�����ɱ�ǩ.<br/>
	 *  ��ѵ�һ����ǩ���ɸ���ǩ ,���н�������:<XXX ref="xxx" sub="lll"></XXX><br/>
	 *  ����������ǩ����ʹ��"<"��">"����<br/>
	 * </li>
	 * </p>
	 * 
	 * <b>��˵����</b>
	 * <p> 
	 * δ����bug:
	 * 1.û���ǵ�ͬ����ǩ���������.����ul��ǩ������li��ǩ.
	 * </p>
	 */
	public class Tag{
		/**
		 * ��ǩ��
		 */
		private String tagName ;
		/**
		 * ��ǩͷβ�м������;
		 */
		private String value;
		/**
		 * ��ǩ����ֵ��ref = "fundQuery" sub = "QueryID" 
		 */
		private Map<String,String> propertyMap = new LinkedHashMap<String, String>();
		/**
		 * �ӱ�ǩ�б�
		 */
		private List<Tag> childTagList = new ArrayList<Tag>();
		
		/**
		 * �������ݱ�ǩ��s�������ǩ��<br/>
		 */
		private List<String> mapColor = new ArrayList<String>();
		
		/**
		 * ����ǩ
		 */
		private Tag parentTag = null;
		
		public Tag(String tagString) {
			super();
			init(tagString,null);
		}
		/**
		 * �����Ҫ�����������ӱ�ǩ�ĸ���ǩ�ֶ�ֵ��!<br/>
		 * ����д��private�������ⲿ����Ŷ<br/>
		 * <b>���췽��</b>
		 * <br/>
		 * ���ɺ��и���ǩ��Tag<br/>
		 * @param tagString
		 * @param parentTag
		 */
		private Tag(String tagString,Tag parentTag) {
			super();
			init(tagString,parentTag);
		}
		/**
		 * <b>����˵����</b>
		 * <ul>
		 * ����Ҫ�ݹ�����tag��
		 * </ul>
		 * @param stringList
		 */
		@SuppressWarnings("unchecked")
		private void init(String tagString,Tag parentTag) {
			this.parentTag = parentTag;
			//p1 ������������Ҫ���������� ����ֵ
			//ͬ��α�ǩ����ͬ�� otherwise throw exception  û�п��ƺù����� ��Щ���� ��֪�����Լ��������Ӧ����û ��û����ƫ ; ���ڵ�һ���ǩֻȡһ�����Բ��õ���,������ӱ�ǩ�ַ�������~
			
			//���֮���� (�������� ��Ϊ�����Ԥ�ƺ��˵�,�ܶණ��Ҳ�����Ǻ���,��Ȼ������ȫ����) ���������򵥵�<xx><xx />һ�����滻����ȫ�Ļ��׳��쳣 �������ͺܼ���Ŷ ����һ���Ժ� O(��_��)O����~;�����˵ok....
			//�������Ѿ����� �淶�˺�ˬ!
			
			//<MEBS_MOBILE ref = "����ͨѶ" sub="������" type ="�粨�վ�">�ҵ�bs������<REQ name="user_login" name2 ="user_login_request">���뽻����<U sub="UserID" type ="String">��½�û�ID</U><PASSWORD sub="PassWord" type="String">����</PASSWORD><IC sub="InMysteryCode" type="String">�����ַ���</IC><RANDOM_KEY sub="Random_key" type="Integer" >�����</RANDOM_KEY></REQ></MEBS_MOBILE>
			
			List<Object> lp = parseTagString(tagString);
			this.tagName = (String)lp.get(0);
			this.propertyMap = (LinkedHashMap<String, String>)lp.get(1);
			this.value = (String)lp.get(2);
			
			//p2 �ݹ������ӱ�ǩ ���������ǩ   		--> ok!
			String chirldTagString = (String)lp.get(3);
			if(chirldTagString != null && !"".equals(chirldTagString)){
				List<String> chirldTagStringList = parseChirldTagString(chirldTagString);
				for(String si : chirldTagStringList){
					Tag tag = new Tag(si,this);
					this.childTagList.add(tag);
				}
			}
			
			//����������˱�ǩ�����mapColor��ֵ.���ڲ����ӱ�ǩ;
			//[REQ U, REQ PASSWORD, REQ RANDOM_KEY]
			/*if(this.getParentTag() == null){
				List<String> l = createMapColor(this);
				for(String si :l){
					mapColor.add(this.tagName + " " + si);
				}
			}*/
			mapColor = createMapColor(this);
			
		}
		
		private List<String> createMapColor(Tag tag) {
			List<Tag> lct = tag.getChildTagList();
			List<String> l = new ArrayList<String>();
			if(lct != null && lct.size()>0){
				for(Tag t : lct){
					if(t.getChildTagList() != null && t.getChildTagList().size() > 0){
						List<String> lt = createMapColor(t);
						for(String si : lt){
							l.add(t.getTagName() +" "+ si);
						}
					}else{
						l.add(t.getTagName());
					}
				}
			}
			return l;
		}
		/**
		 * <b>����˵����</b>
		 * <ul>
		 * ���ӱ�ǩ�ʽ�Ϊ��׼ʽ.<br/>
		 * ��
		 * </ul>
		 * @param chirldTagString
		 * @return
		 */
		private List<String> parseChirldTagString(String chirldTagString) {
			List<String> l = new ArrayList<String>();
			String tagHead="",tagName="",tagEnd="";
			try {
				while(chirldTagString.contains("<")){
					tagHead = chirldTagString.substring(chirldTagString.indexOf("<") + 1, chirldTagString.indexOf(">"));
					tagName = Util_String.___getTheFirstWord(tagHead);
					tagEnd = "</" + tagName +">";
					chirldTagString = chirldTagString.replaceAll("<{1}\\s*/{1}\\s*"+tagName+"{1}\\s*>{1}",tagEnd);
					l.add(chirldTagString.substring(chirldTagString.indexOf("<"), chirldTagString.indexOf(tagEnd)+tagEnd.length()));
					chirldTagString = chirldTagString.substring(chirldTagString.indexOf(tagEnd)+tagEnd.length());
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("�ӱ�ǩ�ֽ�ʧ��!�����ǩ�Ƿ�����,�Ƿ���Ϲ淶!�Ҳ��� β����ǩ,���丽����xml��ʽ����:" + tagEnd + " <---- " + chirldTagString);
			}
			return l;
		}

		/**
		 * <b>����˵����</b>
		 * <ul>
		 * ����tagString��ȡ��������Ϣ(����ǩ����)<br/>
		 * �Ե�һ��"<"��">"֮����ַ�����Ϊ��ǩ��ͷ����.�Ե�һ���ַ�����Ϊ��ǩ��,������� key = value����ʽ����,��ΪpropertyMap<br/>
		 * valueΪheadβ�͵�">"�͸ñ�ǩβ����Ӧ��"<"�м������<br/>
		 * </ul>
		 * @param tagString
		 * @return tagName + map<String,String>(������ϵ) + value(�ı�����)  + �ӱ�ǩtagString
		 */
		private List<Object> parseTagString(String tagString) {
			List<Object> l = new ArrayList<Object>();
			String tagHead="",tagName="",innerTagString="",value="";
			try {
				//0.ɾ����ǩͷ<?xml version="1.0" encoding = "GBK"?> ����еĻ�
				tagString = removeVersionTitile(tagString);
				//1.��ӱ�ǩ��
				tagHead = tagString.substring(tagString.indexOf("<") + 1, tagString.indexOf(">"));
				tagName = Util_String.___getTheFirstWord(tagHead);
				l.add(tagName);
				//2.���map����ref="ddd" sub="ddd" type="String"
				tagString = tagString.replaceAll("<{1}\\s*/{1}\\s*"+tagName+"{1}\\s*>", "</" + tagName +">");
				Map<String,String> map = Util_String.___getPropertyMap(tagHead.substring(tagHead.indexOf(tagName)+tagName.length()));
				l.add(map);
				//innerTextΪ��һ��>�����ŵ�<�м������,���ŵ�<�п������Լ��Ľ�����ǩ,Ҳ�������ֱ�ǩ�Ŀ�ʼ��ǩ.
				//3.��ȡ�Լ���ǩ�е��ı�����(���ӱ�ǩ����ͷ����>��β���ӱ�ǩ��<��ͷ�ĵط�;���û���ӱ�ǩ����ͷ��>��β��<֮�������.)
				int index1 = tagString.indexOf(">")+1;
				int index2 = tagString.indexOf("<", index1);
				value = tagString.substring(index1, index2);
				l.add(value);
				//4.����ӱ�ǩtagString����
				innerTagString = tagString.substring(index2, tagString.indexOf("</" + tagName +">", index2));
				l.add(innerTagString);
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("����ǩ" + tagName + "�Ƿ�����");
			}
			return l;
		}

		/**
		 * <b>����˵����</b>
		 * <ul>
		 * �����������<?xml version="1.0" encoding = "GBK"?>��Ϣ,��ȥ��<br/>
		 * </ul>
		 * @param tagString
		 * @return
		 */
		private String removeVersionTitile(String tagString) {
//			tagString = tagString.replaceAll("<{1}\\s*?", "<?").replaceAll("?\\s*>", "?>");
//			<?xml version="1.0" encoding = "GBK"?>
//			tagString = tagString.replaceAll("<{1}\\s*\\?.*\\?\\s*>{1}", "");
			/**--------------------------------------------------------------------------------------------------------------------------*/
//			tagString = tagString.replaceAll("<\\s*\\?\\s*xml\\s*version\\s*=\\s*\"1\\.0\"\\s*encoding\\s*=\\s*\"GBK\"\\s*\\?\\s*>", "");
			//---------------------------------------------------------------------------------------------------------------------------
			/**�޸�����:2016��9��14��11:00:20 wangzg �޸������滻ʽ��Ϊ����汾.
			 * ע�Ͱ汾����ֻƥ��GBK,��ʵ���ж���,����GBK2312,UTF-8֮��,ֻҪƥ���ǵ����ַ��ͺ��� */
			tagString = tagString.replaceAll("<\\s*\\?\\s*xml\\s*version\\s*=\\s*\"1\\.0\"\\s*encoding\\s*=\\s*\"((\\w|-)+)\"\\s*\\?\\s*>", "");
			/**--------------------------------------------------------------------------------------------------------------------------*/
			 
			return tagString;
		}

		public String getTagName() {
			return tagName;
		}

		public String getValue() {
			return value;
		}

		public Map<String, String> getPropertyMap() {
			return propertyMap;
		}

		public List<Tag> getChildTagList() {
			return childTagList;
		}
		
		public List<String> getMapColor() {
			return mapColor;
		}
		
		
		
		public Tag getParentTag() {
			return parentTag;
		}

		/**
		 * <b>����˵����</b>
		 * <ul>
		 * ��ȡָ��tag.
		 * Attention:�����ȡ�������ȡ����ײ�ı�ǩ!���Բ�дȫ·��,������Ҫ�̶���ǩ���������<br/>
		 * </ul>
		 * @param string
		 * @param string2
		 * @return
		 */
		public Tag getTagByNames(String ...tagNames) {
			//�ݹ��ȡָ���ı�ǩ
			if(!(tagNames != null && tagNames.length > 0))
				return null;
			String[] tagNameList = findTagNameList(tagNames);
			Tag t = getTagByNamesReal(tagNameList);
			
			return t;
			
		}
		
		/**
		 * <b>����˵����</b>
		 * <ul>
		 * �������ı�ǩ·����ȡ���Ե��ӱ�ǩ.<br/>
		 * �������ӱ�ǩ���ܻ�ȡ.<br/>
		 * </ul>
		 * @param string
		 * @param string2
		 * @return
		 */
		public Tag getTagByNamesReal(String...tagNames) {
			boolean firstTime = true;
			Tag t = null;
			try {
				for(int i = 0 ; i < tagNames.length ; i++){
					if(firstTime){
						firstTime = false;
						t = this.getDirectChildTag(tagNames[i]);
					}else{
						t = t.getDirectChildTag(tagNames[i]);
					}
				}
			} catch (NullPointerException e) {
				throw new RuntimeException("��ǩδ�ҵ�.");
			}
			return t;
		}
		/**
		 * <b>����˵����</b>
		 * <ul>
		 * ��ƥ����<br/>
		 * </ul>
		 * @param tagNames
		 * @return
		 */
		public String[] findTagNameList(String[] tagNames) {
			for(int i=0;i<tagNames.length;i++){
				if(null == tagNames[i] || "".equals(tagNames[i]))
						throw new RuntimeException("��ǩ������!");
			}
			String[] sArr = null;
			List<String> l = this.mapColor;
			for(String si : l){
				String[] sRoute = si.split(" ");
				int i,j = -1;
				for(i = 0 ;i<tagNames.length;i++){
					j = inTheArrayPositon(sRoute,tagNames[i],j + 1);
					if(j==-1 || j >= sRoute.length)
						break;
				}
				if(j >= 0 && j < sRoute.length){
					sArr = sRoute;
					break;
				}
			}
			return sArr;
		}
		/**
		 * <b>����˵����</b>
		 * <ul>
		 * �ַ���s�Ƿ���sArr����,��n��ʼ֮���ĳ���ط�(�����Ǹ�λ��)
		 * </ul>
		 * @param sArr
		 * @param s
		 * @param n
		 * @return
		 */
		private int inTheArrayPositon(String[] sArr, String s, int n) {
			int ret = -1;
			for(int i = n ;i<sArr.length;i++){
				if(s.equals(sArr[i])){
					ret = i;
					break;
				}
			}
			return ret;
		}
		/**
		 * <b>����˵����</b>
		 * <ul>
		 * ��ȡֱ���ӱ�ǩ
		 * </ul>
		 * @param i
		 * @return
		 */
		public Tag getDirectChildTag(String childTagName) {
			for(Tag t : this.childTagList){
				if(t.getTagName().equals(childTagName))
					return t;
			}
			return null;
		}
		/*@SuppressWarnings("unused")
		@Deprecated
		private String[] __findTagNameList(String[] tagNames) {
			StringBuffer sb = new StringBuffer(".*");
			for(int  i = 0 ;i < tagNames.length - 1; i++){
				sb.append(tagNames[i]).append(" T_____T ");
			}
			sb.append(tagNames[tagNames.length - 1]).append(".*");
			String s = sb.toString().replaceAll("T_____T", ".*");
			String sArr[] = null;
			for(String i : this.mapColor){
				if(DBUtil3_parseTxt.matchAllSameRegx(i, s))
					sArr = i.replaceAll("\\s+", " ").split(" ");
			}
			
			return sArr;
		}*/
		/**
		 * <b>����˵����</b>
		 * <ul>
		 * ��ȡ�ñ�ǩ��û���ӱ�ǩ�������ӱ�ǩ.<br/>
		 * </ul>
		 * @return
		 */
		public List<Tag> selectTagsWithoutChild() {
			List<Tag> l = new ArrayList<Tag>();
			for(String si : this.mapColor){
				l.add(this.getTagByNames(si.split(" ")));
			}
			return l;
		}
		@Override
		public String toString() {
			StringBuffer sb = new StringBuffer("");
			for(Tag i : this.childTagList){
				sb.append(i.getTagName()).append(" ");
			}
			return "Tag [tagName=" + tagName + ", value=" + value
					+ ", propertyMap=" + propertyMap + "]";
		}
		
		
	}