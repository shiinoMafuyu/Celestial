package com.celestial.meek.realTest_2016_08.jvmTest;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;



public class AnotherClassLoader extends ClassLoader {
	private String baseDir;
	//private static final Logger LOG = Logger.getLogger(AnotherClassLoader.class);    
	    public AnotherClassLoader (ClassLoader parent, String baseDir) {
	           super(parent);
	           this.baseDir = baseDir;
	    }
	    @SuppressWarnings({ "unchecked", "rawtypes" })
		protected Class findClass(String name)
	            throws ClassNotFoundException {
	        //LOG.debug("findClass " + name);
	        byte[] bytes = loadClassBytes(name);
	        Class theClass = defineClass(name, bytes, 0, bytes.length);//A
	        if (theClass == null)
	            throw new ClassFormatError();
	        return theClass;
	    }
	    /**
	     * 别人这是用管道流获取的方式..
	     * @param className
	     * @return
	     * @throws ClassNotFoundException
	     */
	    private byte[] loadClassBytes(String className) throws
	        ClassNotFoundException {
	        try {
	            String classFile = getClassFile(className);
	            FileInputStream fis = new FileInputStream(classFile);
	            FileChannel fileC = fis.getChannel();
	            ByteArrayOutputStream baos = new ByteArrayOutputStream();
	            WritableByteChannel outC = Channels.newChannel(baos);
	            ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
	            while (true) {
	                int i = fileC.read(buffer);
	                if (i == 0 || i == -1) {
	                    break;
	                }
	                buffer.flip();
	                outC.write(buffer);
	                buffer.clear();
	            }
	            fis.close();
	            return baos.toByteArray();
	        } catch (IOException fnfe) {
	            throw new ClassNotFoundException(className);
	        }
	    }
	    private String getClassFile(String name) {
	        StringBuffer sb = new StringBuffer(baseDir);
	        name = name.replace('.', File.separatorChar) + ".class";
	        sb.append(File.separator + name);
	        return sb.toString();
	    }
	    
	    
	    
}
