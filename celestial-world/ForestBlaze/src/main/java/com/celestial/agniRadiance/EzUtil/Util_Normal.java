package com.celestial.agniRadiance.EzUtil;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Util_Normal {
	/**
	 * 
	 * <b>方法说明：</b>
	 * <ul>
	 * 进行n此table退格
	 * </ul>
	 * @param createAllVariables
	 * @param i
	 * @return
	 */
	public static Collection<? extends String> table(Collection<? extends String> stringList, int n) {
		List<String> l = new ArrayList<String>();
		String s = Util_String.__nstr("\t",n);
		for(String si : stringList){
			l.add(s+si);
		}
		return l;
	}

	public static Collection<? extends String> table(Collection<? extends String> stringList) {
		return table(stringList,1);
	}
	
	/**
	 * 比较字符串格式的日期<br/>
	 * 支持yyyy-MM-dd 和 yyyy-MM-dd hh:mm:ss 两种格式<br/>
	 * @param date 字符日期
	 * @param dates 字符日期数组
	 * @return 
	 */
	public static boolean inTime(String date, String[] dates) {
		String[] partern = new String[]{"yyyy-MM-dd","yyyy-MM-dd hh:mm:ss"};
		Date dt = null;
		Date[] dts = new Date[dates.length];
		try {
			dt = getDatePatterns(date,partern);
			for(int i = 0 ; i < dates.length ; i++){
				dts[i] = getDatePatterns(dates[i],partern);
			}
			return inTime(dt,dts);
		}catch(RuntimeException e1){
			throw new RuntimeException("日期比较异常!");
		}
		catch (Exception e) {
			throw new RuntimeException("字符串日期格式不对!");
		}
	}
	

	/**
	 * 判断一个时间是否在给定的时间之内 ;<br/>
	 * 如果数组为双数则,判断是不是两两组成的区间之内;<br/>
	 * 如果为单数则默认最后时间到无穷大;<br/>
	 * 判断是某时间之前无穷大,取非即可.<br/>
	 * @param date 日期
	 * @param dates 时间区间
	 * @throws Exception 
	 */
	public static boolean inTime(Date date, Date[] dates) throws Exception {
		boolean b = false ;
		try {
			int n = dates.length;
			if(n%2 == 0){
			}else{
				n = n - 1;
			}
			for(int i = 0 ; i < n ; i += 2){
				if(date.after(dates[i]) && date.before(dates[i+1])){
					b = true;
				}
			}
			if(n == dates.length - 1){
				if(date.after(dates[n])){
					b = true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("日期比较异常");
		}
		
		return b;
	}
	
	/**
	 * 通过几种样式的任意一种获取日期
	 * @param stringDate 字符串日期
	 * @param stringsDatePattern 日期样式
	 * @return
	 */
	public static Date getDatePatterns(String stringDate, String[] stringsDatePattern) {
		SimpleDateFormat df = null;
		Date date = null;
		for(String pattern : stringsDatePattern){
			try {
				df = new SimpleDateFormat(pattern);
				date = df.parse(stringDate);
				
				if(date != null && df.format(date).contains(" ") == stringDate.contains(" ")){
					return date;
				}
			} catch (Exception e) {
				continue;
			}
		}
		throw new RuntimeException("没有适合的字符日期格式匹配,获取Date对象失败!");
	}
	
	/**==============================================反射核心 wangzg 2016年7月21日14:34:48  ↓==========================================================*/
	
	/**
	 * 执行全部反射方法<br/>
	 * methodList的一个元素 表示: obj(含有要执行的方法的对象) + methodName(要执行的方法名) + paramObj1(后面全为参数) + paramObj2+ paramObj3+ paramObj4..<br/>
	 * 全部成功返回 true ;有一个失败返回false<br/>
	 * @param methodList 要执行的方法列表 ;
	 * @return 
	 * @throws Exception
	 */
	public static boolean excuteReflectObjectAll(List<Object> methodList) throws Exception {
		boolean b = true;
		try {
			if(methodList != null && methodList.size() > 0){
				for(Object i : methodList){
					if(!excuteReflectObject(i)){
						b = false;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return b;
	}
	/**
	 * 执行反射方法 <br/>
	 * **究极的方法**<br/>
	 * @param obj 要执行的方法和其参数 ; 约定格式 : [对象,方法名,param0,param1,param2..]
	 * @param me  实例自身
	 * @return 方法调用结果
	 */
	@SuppressWarnings("rawtypes")
	public static boolean excuteReflectObject(Object obj) throws Exception{
		//就算是Class也可以现成添加 !
		Object[] objs =(Object[])obj;
		Class[] cArr = new Class[objs.length -2];
		for(int i =0; i < objs.length -2 ; i++){
			cArr[i] = objs[i+2].getClass();
		}
		Method m = objs[0].getClass().getDeclaredMethod((String)objs[1], cArr);
		Object[] params = new Object[cArr.length];
		for(int i = 0; i < objs.length -2 ; i++){
			params[i] = objs[i+2];
		}
		return (Boolean)m.invoke(objs[0], params);
		
	}
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 执行反射方法 <br/>
	 * **究极的方法**<br/>
	 * 使用自定义类的话,获取方法的时候不能向上造型.(就算是以子类来getClass()也获取不到父类型为参数的方法.)<br/>
	 * 所以写了,这个方法.把参数的.class传入.<br/>
	 * 
	 * </ul>
	 * @param obj 约定格式[对象,方法名,Class[],params[]]
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public static Object excuteReflectObject2(Object obj) throws Exception{
		Object[] objs =(Object[])obj;
		
		Object girlFriend = objs[0];
		String name =  (String)objs[1];
		Class[] cArr = (Class[])objs[2];
		Object[] params = (Object[])objs[3];
		
		Method m = girlFriend.getClass().getDeclaredMethod(name, cArr);
		return m.invoke(objs[0], params);
	}
	/**==============================================反射核心 wangzg 2016年7月21日14:34:48 ↑==========================================================*/

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 加载类qualifiedName,获取一个实例.<br/>
	 * </ul>
	 * @param qualifiedName
	 * @return
	 */
	public static Object getReflectObject(String qualifiedName) {
		Object obj = null;
		try {
			obj = ClassFor(qualifiedName).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("反射获取实例失败:"+qualifiedName);
		} 
		return obj;
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 加载类qualifiedName,获取一个实例.<br/>
	 * 想比getReflectObject,此方法在能使用默认构造函数实例化时,就使用默认构造函数(new)<br/>
	 * </ul>
	 * @param qualifiedName
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Object getReflectObjectPretty(String qualifiedName) {
		Object obj = null;
		try {
			Class c = ClassFor(qualifiedName);
			try {
				obj = c.getConstructor().newInstance();
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(obj == null)
				obj = c.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return obj;
	}
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 加载类.
	 * </ul>
	 * @param qualifiedName
	 */
	@SuppressWarnings("rawtypes")
	public static Class ClassFor(String qualifiedName) {
		try {
			return Class.forName(qualifiedName);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("类加载失败:"+qualifiedName);
		}
	}
	
	private static void close(Closeable stream) {
		if (stream != null) {
			try {
				stream.close();
				stream = null;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static void close(HttpURLConnection httpConn) {
		if (httpConn != null) {
			httpConn.disconnect();
		}
	}
	
	private static int CONNECT_TIMEOUT = 3000;
	private static int READ_TIMEOUT = 3000;
	/**
	 * post请求数据
	 * 
	 * @param connectURL
	 * @param param
	 * @param charset
	 * @return
	 */
	public static String doPost(String connectURL, String param, String charset) {
		byte[] bytes = null;
		ByteArrayOutputStream byteArrayOut = null;
		URL url = null;
		HttpURLConnection httpPost = null;
		OutputStream out = null;
		InputStream in = null;
		try {
			url = new URL(connectURL);
			httpPost = (HttpURLConnection) url.openConnection();
			httpPost.setRequestMethod("POST");
			httpPost.setDoInput(true);
			httpPost.setDoOutput(true);
			httpPost.setUseCaches(false);
			httpPost.setConnectTimeout(CONNECT_TIMEOUT);
			httpPost.setReadTimeout(READ_TIMEOUT);
			httpPost.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded");
			httpPost.connect();
			out = httpPost.getOutputStream();
			out.write(param.getBytes(charset));
			out.flush();
			in = httpPost.getInputStream();
			byteArrayOut = new ByteArrayOutputStream();
			byte[] buf = new byte[512];
			int l = 0;
			while ((l = in.read(buf)) != -1) {
				byteArrayOut.write(buf, 0, l);
			}
			bytes = byteArrayOut.toByteArray();
			return new String(bytes, charset);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(byteArrayOut);
			close(out);
			close(in);
			close(httpPost);
		}
		return null;
	}
	
	public static String doGet(String connectURL, String charset) {
		byte[] bytes = null;
		ByteArrayOutputStream byteArrayOut = null;
		URL url = null;
		HttpURLConnection httpGet = null;
		InputStream in = null;
		try {
			url = new URL(connectURL);
			httpGet = (HttpURLConnection) url.openConnection();
			httpGet.setConnectTimeout(CONNECT_TIMEOUT);
			httpGet.setReadTimeout(READ_TIMEOUT);
			httpGet.connect();
			in = httpGet.getInputStream();
			byteArrayOut = new ByteArrayOutputStream();
			byte[] buf = new byte[512];
			int l = 0;
			while ((l = in.read(buf)) != -1) {
				byteArrayOut.write(buf, 0, l);
			}
			bytes = byteArrayOut.toByteArray();
			return bytes != null ? new String(bytes, charset) : null;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(byteArrayOut);
			close(in);
			close(httpGet);
		}
		return null;
	}
	
	/**  
     * @Description:发送get请求保存下载文件  
     * @author:liuyc  
     * @time:2016年5月17日 下午3:27:29  
     */  
    public static int sendGetAndSaveFile(String urlParam, Map<String, Object> params, String fileSavePath) {
    	int re = 0;
        // 构建请求参数 
        StringBuffer sbParams = new StringBuffer();
        if (params != null && params.size() > 0) {
            for (Entry<String, Object> entry : params.entrySet()) {
                sbParams.append(entry.getKey());
                sbParams.append("=");
                sbParams.append(entry.getValue());
                sbParams.append("&");
            }
        }
        HttpURLConnection con = null;
        BufferedReader br = null;
        FileOutputStream os = null;
        try {
            URL url = null;
            if (sbParams != null && sbParams.length() > 0) {
                url = new URL(urlParam + "?" + sbParams.substring(0, sbParams.length() - 1));
            } else {
                url = new URL(urlParam);
            }
            con = (HttpURLConnection) url.openConnection();
            con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            con.connect();
            InputStream is = con.getInputStream();
            os = new FileOutputStream(fileSavePath);
            byte buf[] = new byte[1024];
            int count = 0;
            while ((count = is.read(buf)) != -1) {
                os.write(buf, 0, count);
            }
            os.flush();
        } catch (Exception e) {
        	re = -1;
            /*throw new RuntimeException(e);*/
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    os = null;
                    throw new RuntimeException(e);
                } finally {
                    if (con != null) {
                        con.disconnect();
                        con = null;
                    }
                }
            }
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    br = null;
                    throw new RuntimeException(e);
                } finally {
                    if (con != null) {
                        con.disconnect();
                        con = null;
                    }
                }
            }
        }
        return re;
    }

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取year年month月有多少天.<br/>
	 * </ul>
	 * @param year
	 * @param month
	 * @return
	 */
	public static int getDays(int year, int month) {
		int days = 0;
		if(month > 12 || month<0)
			throw new RuntimeException("- -我不想和你说话.");
		if(Util_Collection.contain(new Integer[]{1,3,5,7,8,10,12}, month))
			days = 31;
		else if(Util_Collection.contain(new Integer[]{4,6,9,11},month))
				days = 30;
		else{
			if(days % 100 ==0){
				if(days % 400 == 0)
					days =29;
				else
					days = 28;
			}else if(days % 4 ==0)
				days = 29;
			else
				days = 28;
		}
		return days;
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取当前层次里的下一个数。<br/>
	 * 用一个静态变量保存序列，初始化请调用方法initGradationTree<br/>
	 * 
	 * 这个是用来对遍历树进行编号用的。<br/>
	 * 每对一行获取一次，当前行数值就增大1.<br/>
	 * 如:getGradationTreeNum(1) = 0;getGradationTreeNum(1) =1;getGradationTreeNum(1) =2 ...<br/>
	 * </ul>
	 * @param talbelLevel
	 * @return
	 */
	public static int getGradationTreeNumNext(int talbelLevel) {
		List<Integer> currentLevelList = gradationTree.get(talbelLevel);
		if(null == currentLevelList){
			currentLevelList = new ArrayList<Integer>();
		}
		int range = currentLevelList.size();
		currentLevelList.add(range);
		gradationTree.put(talbelLevel, currentLevelList);
		
		return range;
	}
	
	private static Map<Integer,List<Integer>> gradationTree = new HashMap<Integer, List<Integer>>();
	
	public static void initGradationTree() {
		gradationTree = new HashMap<Integer, List<Integer>>();
	}
	
}
