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
	 * <b>����˵����</b>
	 * <ul>
	 * ����n��table�˸�
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
	 * �Ƚ��ַ�����ʽ������<br/>
	 * ֧��yyyy-MM-dd �� yyyy-MM-dd hh:mm:ss ���ָ�ʽ<br/>
	 * @param date �ַ�����
	 * @param dates �ַ���������
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
			throw new RuntimeException("���ڱȽ��쳣!");
		}
		catch (Exception e) {
			throw new RuntimeException("�ַ������ڸ�ʽ����!");
		}
	}
	

	/**
	 * �ж�һ��ʱ���Ƿ��ڸ�����ʱ��֮�� ;<br/>
	 * �������Ϊ˫����,�ж��ǲ���������ɵ�����֮��;<br/>
	 * ���Ϊ������Ĭ�����ʱ�䵽�����;<br/>
	 * �ж���ĳʱ��֮ǰ�����,ȡ�Ǽ���.<br/>
	 * @param date ����
	 * @param dates ʱ������
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
			throw new RuntimeException("���ڱȽ��쳣");
		}
		
		return b;
	}
	
	/**
	 * ͨ��������ʽ������һ�ֻ�ȡ����
	 * @param stringDate �ַ�������
	 * @param stringsDatePattern ������ʽ
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
		throw new RuntimeException("û���ʺϵ��ַ����ڸ�ʽƥ��,��ȡDate����ʧ��!");
	}
	
	/**==============================================������� wangzg 2016��7��21��14:34:48  ��==========================================================*/
	
	/**
	 * ִ��ȫ�����䷽��<br/>
	 * methodList��һ��Ԫ�� ��ʾ: obj(����Ҫִ�еķ����Ķ���) + methodName(Ҫִ�еķ�����) + paramObj1(����ȫΪ����) + paramObj2+ paramObj3+ paramObj4..<br/>
	 * ȫ���ɹ����� true ;��һ��ʧ�ܷ���false<br/>
	 * @param methodList Ҫִ�еķ����б� ;
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
	 * ִ�з��䷽�� <br/>
	 * **�����ķ���**<br/>
	 * @param obj Ҫִ�еķ���������� ; Լ����ʽ : [����,������,param0,param1,param2..]
	 * @param me  ʵ������
	 * @return �������ý��
	 */
	@SuppressWarnings("rawtypes")
	public static boolean excuteReflectObject(Object obj) throws Exception{
		//������ClassҲ�����ֳ���� !
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
	 * <b>����˵����</b>
	 * <ul>
	 * ִ�з��䷽�� <br/>
	 * **�����ķ���**<br/>
	 * ʹ���Զ�����Ļ�,��ȡ������ʱ������������.(��������������getClass()Ҳ��ȡ����������Ϊ�����ķ���.)<br/>
	 * ����д��,�������.�Ѳ�����.class����.<br/>
	 * 
	 * </ul>
	 * @param obj Լ����ʽ[����,������,Class[],params[]]
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
	/**==============================================������� wangzg 2016��7��21��14:34:48 ��==========================================================*/

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ������qualifiedName,��ȡһ��ʵ��.<br/>
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
			throw new RuntimeException("�����ȡʵ��ʧ��:"+qualifiedName);
		} 
		return obj;
	}

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ������qualifiedName,��ȡһ��ʵ��.<br/>
	 * ���getReflectObject,�˷�������ʹ��Ĭ�Ϲ��캯��ʵ����ʱ,��ʹ��Ĭ�Ϲ��캯��(new)<br/>
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
	 * <b>����˵����</b>
	 * <ul>
	 * ������.
	 * </ul>
	 * @param qualifiedName
	 */
	@SuppressWarnings("rawtypes")
	public static Class ClassFor(String qualifiedName) {
		try {
			return Class.forName(qualifiedName);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("�����ʧ��:"+qualifiedName);
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
	 * post��������
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
     * @Description:����get���󱣴������ļ�  
     * @author:liuyc  
     * @time:2016��5��17�� ����3:27:29  
     */  
    public static int sendGetAndSaveFile(String urlParam, Map<String, Object> params, String fileSavePath) {
    	int re = 0;
        // ����������� 
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
	 * <b>����˵����</b>
	 * <ul>
	 * ��ȡyear��month���ж�����.<br/>
	 * </ul>
	 * @param year
	 * @param month
	 * @return
	 */
	public static int getDays(int year, int month) {
		int days = 0;
		if(month > 12 || month<0)
			throw new RuntimeException("- -�Ҳ������˵��.");
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
	 * <b>����˵����</b>
	 * <ul>
	 * ��ȡ��ǰ��������һ������<br/>
	 * ��һ����̬�����������У���ʼ������÷���initGradationTree<br/>
	 * 
	 * ����������Ա��������б���õġ�<br/>
	 * ÿ��һ�л�ȡһ�Σ���ǰ����ֵ������1.<br/>
	 * ��:getGradationTreeNum(1) = 0;getGradationTreeNum(1) =1;getGradationTreeNum(1) =2 ...<br/>
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
