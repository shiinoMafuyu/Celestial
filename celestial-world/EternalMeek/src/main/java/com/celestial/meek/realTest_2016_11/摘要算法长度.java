package com.celestial.meek.realTest_2016_11;

import java.security.MessageDigest;

public class 摘要算法长度 {

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param args 
	 */
	public static void main(String[] args) {
		/*String s =Util_File.getMd5ByFile(new File("F:/mashiro/我们都是外星人/tu/1.jpg"));
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
	     * 用于获取一个String的md5值
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

	    //对字符串进行MD5编码   
	    private static String encodeByMD5(String originstr)  
	    {  
	   	 if(originstr !=null)  
	   	 {  
	   		 try{  
	   			 //创建具有指定算法名称的信息摘要   
	   			 MessageDigest md = MessageDigest.getInstance("MD5");  
	   			 //使用指定的字节数组对摘要进行最后的更新，然后完成摘要计算   
	   			 byte[] results = md.digest(originstr.getBytes());  
	   			  //将得到的字节数组编程字符窜返回   
	   			 String resultString = byteArrayToHexString(results);  
	   			 return resultString.toUpperCase();  
	   		 }catch(Exception ex){  
	   			 ex.printStackTrace();  
	   		 }  
	   	 }  
	   	return null;  
	    }  
	    //转换字节数组为十六进制字符串   
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
	   //将字节转化成十六进制的字符串   
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
