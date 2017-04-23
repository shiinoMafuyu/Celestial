package com.celestial.misdirection.JvmTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MyLoader1 extends ClassLoader{
String classpath;  
    
    Map<String, Class> loadedClassPool = new HashMap<String, Class>();  
  
    public MyLoader1(String classpath) {  
        this.classpath = classpath;  
    }  
  
      
    @SuppressWarnings("unchecked")  
    @Override  
    public synchronized Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {  
        Class claz = null;  
        if (loadedClassPool.containsKey(name)) {  
            claz = this.loadedClassPool.get(name);  
        } else {  
  
            try {  
                if (claz == null) {  
                    claz = super.loadClass(name, false);  
                    if (claz != null) {  
                        System.out.println("系统加载成功：" + name);  
                    }  
                }  
            } catch (ClassNotFoundException e) {  
                System.out.println("系统无法加载：" + name);  
            }  
              
            try {  
                if (claz == null) {  
                    claz = loadByCjClassLoader(name);  
                    if (claz != null) {  
                        System.out.println("自定义加载成功：" + name);  
                    }  
                }  
            } catch (Exception e) {  
                System.out.println("自定义无法加载：" + name);  
            }  
  
            if (claz != null) {  
                this.loadedClassPool.put(name, claz);  
            }  
  
        }  
        if (resolve) {  
            resolveClass(claz);  
        }  
        return claz;  
    }  
  
    /** 
     *  
     * 解密加载 
     *  
     *  
     * @param name 
     * @return 
     */  
    @SuppressWarnings("unchecked")  
    private Class loadByCjClassLoader(String name) {  
        Class claz = null;  
        try {  
            byte[] rawData = loadClassData(name);  
            if (rawData != null) {  
                //byte[] classData = decrypt(getReverseCypher(this.cjcipher.getKeycode()), rawData);  
                //classData = CipherUtil.filter(classData, this.cjcipher);  
                  
                claz = defineClass(name, rawData, 0, rawData.length);  
            }  
        } catch (Exception e) {  
            claz = null;  
        }  
        return claz;  
    }


    /**
     * 取反输出正确的class二进制数据
     * @param name
     * @return
     * @throws IOException 
     */
	@SuppressWarnings("resource")
	private byte[] loadClassData(String name) throws IOException {
		String fullPath=getClassFile(name);;//classpath+"/"+name;
		int k=0,len,n=1024;
		byte[] b=new byte[n];
		byte[] classData=new byte[0];
		
		FileInputStream fi=null;
		OutputStream os=null;
		try {
			os=new FileOutputStream("D:/tat/te8.class");
			fi=new FileInputStream(fullPath);
			while((k=fi.read(b,0,n)) != -1){
				for(int i=0;i<k;i++){
					b[i]=(byte)~b[i];
				}
				os.write(b, 0, k);
				len=classData.length;
				classData=Arrays.copyOf(classData, len+k);
				System.arraycopy(b, 0, classData, len, k);
				//System.out.print(new String(b,0,k,"gbk"));
			}
			os.flush();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		finally{
			if(os!=null){
				os.close();
			}
			if(fi!=null){
				fi.close();
			}
		}

		return classData;
	}
	
	private String getClassFile(String name) {
        StringBuffer sb = new StringBuffer(classpath);
        name = name.replace('.', File.separatorChar) + ".class";
        sb.append(File.separator + name);
        return sb.toString();
    }
}
