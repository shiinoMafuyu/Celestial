package com.celestial.meek.realTest_2016_11;

import java.security.MessageDigest;

public class ժҪ�㷨���� {

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param args 
	 */
	public static void main(String[] args) {
		/*String s =Util_File.getMd5ByFile(new File("F:/mashiro/���Ƕ���������/tu/1.jpg"));
		System.out.println(s.length()+" : " + s);
		String s2= "a87ff679a2f3e71d9181a67b7542122c";
		System.out.println(s2.length()+" : " + s2);*/
		
		System.out.println(getMd5("e3a00fad-712d-456b-b72a-475f1e2750a4"));
	}


	    private static MessageDigest md5 = null;
	    static {
	        try {
	            md5 = MessageDigest.getInstance("MD5");
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }
	    }

	    /**
	     * ���ڻ�ȡһ��String��md5ֵ
	     * @param string
	     * @return
	     */
	    public static String getMd5(String str) {
	        byte[] bs = md5.digest(str.getBytes());
	        StringBuilder sb = new StringBuilder(40);
	        for(byte x:bs) {
	            if((x & 0xff)>>4 == 0) {
	                sb.append("0").append(Integer.toHexString(x & 0xff));
	            } else {
	                sb.append(Integer.toHexString(x & 0xff));
	            }
	        }
	        return sb.toString();
	    }

	    //���ַ�������MD5����   
	    private static String encodeByMD5(String originstr)  
	    {  
	   	 if(originstr !=null)  
	   	 {  
	   		 try{  
	   			 //��������ָ���㷨���Ƶ���ϢժҪ   
	   			 MessageDigest md = MessageDigest.getInstance("MD5");  
	   			 //ʹ��ָ�����ֽ������ժҪ�������ĸ��£�Ȼ�����ժҪ����   
	   			 byte[] results = md.digest(originstr.getBytes());  
	   			  //���õ����ֽ��������ַ��ܷ���   
	   			 String resultString = byteArrayToHexString(results);  
	   			 return resultString.toUpperCase();  
	   		 }catch(Exception ex){  
	   			 ex.printStackTrace();  
	   		 }  
	   	 }  
	   	return null;  
	    }  
	    //ת���ֽ�����Ϊʮ�������ַ���   
	    private static String byteArrayToHexString(byte[] b)  
	   {  
	   	StringBuffer resultsb = new StringBuffer();  
	   	int i=0;  
	   	for(i=0;i<b.length;i++)  
	   	{  
	   		resultsb.append(byteToHexString(b[i]));  
	   	}  
	   	return resultsb.toString();  
	   }  
	   //���ֽ�ת����ʮ�����Ƶ��ַ���   
	   private static String byteToHexString(byte b)  
	   {  
	   	
	      int n=b;  
	      if(n<0)  
	   	{  
	   		n = 256 + n;  
	   	}  
	   	int d1 = n / 16;  
	   	int d2 = n /16;  
	   	return hexDigits[d1]+hexDigits[d2];  
	   } 
	   private static String[] hexDigits = new String[]{"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f"};  
}
