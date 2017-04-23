package com.celestial.agniRadiance.entity;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.celestial.agniRadiance.EzUtil.Util_String;


	/**
	 * 
	 * <b>修改记录：</b> 
	 * <p>
	 * <li>
	 * 
	 *                        ---- Administrator 2016-8-15<br/>
	 *  一个标签对象;<br/>
	 *  传入一段xml标签字符串把它进行递归解析成标签.<br/>
	 *  会把第一个标签当成父标签 ,进行解析例如:<XXX ref="xxx" sub="lll"></XXX><br/>
	 *  除了用作标签请勿使用"<"和">"符号<br/>
	 * </li>
	 * </p>
	 * 
	 * <b>类说明：</b>
	 * <p> 
	 * 未修正bug:
	 * 1.没考虑到同级标签重名的情况.比如ul标签下面多个li标签.
	 * </p>
	 */
	public class Tag{
		/**
		 * 标签名
		 */
		private String tagName ;
		/**
		 * 标签头尾中间的内容;
		 */
		private String value;
		/**
		 * 标签属性值如ref = "fundQuery" sub = "QueryID" 
		 */
		private Map<String,String> propertyMap = new LinkedHashMap<String, String>();
		/**
		 * 子标签列表
		 */
		private List<Tag> childTagList = new ArrayList<Tag>();
		
		/**
		 * 用来根据标签名s找所需标签的<br/>
		 */
		private List<String> mapColor = new ArrayList<String>();
		
		/**
		 * 父标签
		 */
		private Tag parentTag = null;
		
		public Tag(String tagString) {
			super();
			init(tagString,null);
		}
		/**
		 * 这个主要是用来生成子标签的父标签字段值的!<br/>
		 * 所以写成private不允许外部调用哦<br/>
		 * <b>构造方法</b>
		 * <br/>
		 * 生成含有父标签的Tag<br/>
		 * @param tagString
		 * @param parentTag
		 */
		private Tag(String tagString,Tag parentTag) {
			super();
			init(tagString,parentTag);
		}
		/**
		 * <b>方法说明：</b>
		 * <ul>
		 * 好像要递归生成tag啊
		 * </ul>
		 * @param stringList
		 */
		@SuppressWarnings("unchecked")
		private void init(String tagString,Tag parentTag) {
			this.parentTag = parentTag;
			//p1 生成上面所需要的数据类型 属性值
			//同层次标签不能同名 otherwise throw exception  没有控制好过程吗 有些凌乱 不知道和自己的需求对应上了没 有没有跑偏 ; 由于第一层标签只取一个所以不用担心,检查其子标签字符串即可~
			
			//检测之后做 (必须这样 因为这边是预计好了的,很多东西也都考虑好了,不然等下又全忘了) 可以做个简单的<xx><xx />一个个替换掉不全的话抛出异常 这个好像就很简单了哦 换成一行以后 O(∩_∩)O哈哈~;检测结果说ok....
			//假如检测已经忘了 规范了好爽!
			
			//<MEBS_MOBILE ref = "地球通讯" sub="哔哔哔" type ="电波烧酒">我的bs程序吗<REQ name="user_login" name2 ="user_login_request">申请交易捏<U sub="UserID" type ="String">登陆用户ID</U><PASSWORD sub="PassWord" type="String">口令</PASSWORD><IC sub="InMysteryCode" type="String">加密字符串</IC><RANDOM_KEY sub="Random_key" type="Integer" >随机串</RANDOM_KEY></REQ></MEBS_MOBILE>
			
			List<Object> lp = parseTagString(tagString);
			this.tagName = (String)lp.get(0);
			this.propertyMap = (LinkedHashMap<String, String>)lp.get(1);
			this.value = (String)lp.get(2);
			
			//p2 递归生成子标签 子子孙孙标签   		--> ok!
			String chirldTagString = (String)lp.get(3);
			if(chirldTagString != null && !"".equals(chirldTagString)){
				List<String> chirldTagStringList = parseChirldTagString(chirldTagString);
				for(String si : chirldTagStringList){
					Tag tag = new Tag(si,this);
					this.childTagList.add(tag);
				}
			}
			
			//这个如果是最顶端标签则给他mapColor设值.用于查找子标签;
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
		 * <b>方法说明：</b>
		 * <ul>
		 * 把子标签剖解为标准式.<br/>
		 * 从
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
				throw new RuntimeException("子标签分解失败!请检查标签是否完整,是否符合规范!找不到 尾部标签,或其附近有xml格式错误:" + tagEnd + " <---- " + chirldTagString);
			}
			return l;
		}

		/**
		 * <b>方法说明：</b>
		 * <ul>
		 * 解析tagString获取其属性信息(父标签属性)<br/>
		 * 以第一个"<"和">"之间的字符串里为标签开头内容.以第一个字符串做为标签名,后面的以 key = value的形式存在,做为propertyMap<br/>
		 * value为head尾巴的">"和该标签尾部对应的"<"中间的内容<br/>
		 * </ul>
		 * @param tagString
		 * @return tagName + map<String,String>(属性星系) + value(文本内容)  + 子标签tagString
		 */
		private List<Object> parseTagString(String tagString) {
			List<Object> l = new ArrayList<Object>();
			String tagHead="",tagName="",innerTagString="",value="";
			try {
				//0.删除标签头<?xml version="1.0" encoding = "GBK"?> 如果有的话
				tagString = removeVersionTitile(tagString);
				//1.添加标签名
				tagHead = tagString.substring(tagString.indexOf("<") + 1, tagString.indexOf(">"));
				tagName = Util_String.___getTheFirstWord(tagHead);
				l.add(tagName);
				//2.添加map属性ref="ddd" sub="ddd" type="String"
				tagString = tagString.replaceAll("<{1}\\s*/{1}\\s*"+tagName+"{1}\\s*>", "</" + tagName +">");
				Map<String,String> map = Util_String.___getPropertyMap(tagHead.substring(tagHead.indexOf(tagName)+tagName.length()));
				l.add(map);
				//innerText为第一个>到接着的<中间的内容,接着的<有可能是自己的结束标签,也可能是字标签的开始标签.
				//3.获取自己标签中的文本内容(有子标签就是头部的>结尾到子标签的<开头的地方;如果没有子标签就是头部>和尾部<之间的内容.)
				int index1 = tagString.indexOf(">")+1;
				int index2 = tagString.indexOf("<", index1);
				value = tagString.substring(index1, index2);
				l.add(value);
				//4.添加子标签tagString内容
				innerTagString = tagString.substring(index2, tagString.indexOf("</" + tagName +">", index2));
				l.add(innerTagString);
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("检查标签" + tagName + "是否完整");
			}
			return l;
		}

		/**
		 * <b>方法说明：</b>
		 * <ul>
		 * 若含有讨厌的<?xml version="1.0" encoding = "GBK"?>信息,则去掉<br/>
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
			/**修改日期:2016年9月14日11:00:20 wangzg 修改正则替换式子为下面版本.
			 * 注释版本编码只匹配GBK,事实上有多重,比如GBK2312,UTF-8之类,只要匹配是单个字符就好了 */
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
		 * <b>方法说明：</b>
		 * <ul>
		 * 获取指定tag.
		 * Attention:这里获取的是最获取的最底层的标签!可以不写全路径,但是需要固定标签本身的名称<br/>
		 * </ul>
		 * @param string
		 * @param string2
		 * @return
		 */
		public Tag getTagByNames(String ...tagNames) {
			//递归获取指定的标签
			if(!(tagNames != null && tagNames.length > 0))
				return null;
			String[] tagNameList = findTagNameList(tagNames);
			Tag t = getTagByNamesReal(tagNameList);
			
			return t;
			
		}
		
		/**
		 * <b>方法说明：</b>
		 * <ul>
		 * 以完整的标签路径获取绝对的子标签.<br/>
		 * 带不带子标签都能获取.<br/>
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
				throw new RuntimeException("标签未找到.");
			}
			return t;
		}
		/**
		 * <b>方法说明：</b>
		 * <ul>
		 * 找匹配行<br/>
		 * </ul>
		 * @param tagNames
		 * @return
		 */
		public String[] findTagNameList(String[] tagNames) {
			for(int i=0;i<tagNames.length;i++){
				if(null == tagNames[i] || "".equals(tagNames[i]))
						throw new RuntimeException("标签名错误!");
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
		 * <b>方法说明：</b>
		 * <ul>
		 * 字符串s是否在sArr里面,从n开始之后的某个地方(包含那个位置)
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
		 * <b>方法说明：</b>
		 * <ul>
		 * 获取直接子标签
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
		 * <b>方法说明：</b>
		 * <ul>
		 * 获取该标签内没有子标签的所有子标签.<br/>
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