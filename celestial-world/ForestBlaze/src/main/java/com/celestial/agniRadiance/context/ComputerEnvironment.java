/******************************************************************
 * ComputerEnvironment.java
 * Copyright ${year} by WZG. All Rights Reserved.
 * CreateDate：2017年9月18日
 * Author：wangzg
 * Version：1.0.0
 ******************************************************************/

package com.celestial.agniRadiance.context;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Map;
import java.util.Properties;

/**
 * <b>修改记录：</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2017年9月18日
 * </li>
 * </p>
 * 
 * <b>类说明：</b>
 * <p> 
 * 
 * </p>
 */
public class ComputerEnvironment {


	private static Properties props = System.getProperties();
    private static InetAddress addr;
    private static Map<String,String> map = System.getenv();

    static 
    {
        try
        {
            addr = InetAddress.getLocalHost();
        }
        catch(UnknownHostException unknownhostexception) { }
    }
    private ComputerEnvironment()
    {
    }

    public static String getUserName()
    {
        if(map == null)
            return null;
        else
            return (String)map.get("USERNAME");
    }

    public static String getComputerName()
    {
        if(map == null)
            return null;
        else
            return (String)map.get("COMPUTERNAME");
    }

    public static String getUserDomain()
    {
        if(map == null)
            return null;
        else
            return (String)map.get("USERDOMAIN");
    }

    public static String getHostAddress()
    {
        if(addr == null)
            return null;
        else
            return addr.getHostAddress();
    }

    public static String getHostName()
    {
        if(addr == null)
            return null;
        else
            return addr.getHostName();
    }

    public static String getUserHome()
    {
        if(props == null)
            return null;
        else
            return props.getProperty("user.home");
    }

    public static String getUserDir()
    {
        if(props == null)
            return null;
        else
            return props.getProperty("user.dir");
    }

    public static String getOsName()
    {
        if(props == null)
            return null;
        else
            return props.getProperty("os.name");
    }

    public static String getOsArch()
    {
        if(props == null)
            return null;
        else
            return props.getProperty("os.arch");
    }

    public static String getOsVersion()
    {
        if(props == null)
            return null;
        else
            return props.getProperty("os.version");
    }

    public static String getExtDirs()
    {
        if(props == null)
            return null;
        else
            return props.getProperty("java.ext.dirs");
    }

    public static String getIOTmpdir()
    {
        if(props == null)
            return null;
        else
            return props.getProperty("java.io.tmpdir");
    }

    public static String getLibraryPath()
    {
        if(props == null)
            return null;
        else
            return props.getProperty("java.library.path");
    }

    public static String getFileSeparator()
    {
        if(props == null)
            return null;
        else
            return props.getProperty("file.separator");
    }

    public static String getPathSeparator()
    {
        if(props == null)
            return null;
        else
            return props.getProperty("path.separator");
    }

    public static String getLineSeparator()
    {
        if(props == null)
            return null;
        else
            return props.getProperty("line.separator");
    }

    public static String getJavaVersion()
    {
        if(props == null)
            return null;
        else
            return props.getProperty("java.version");
    }

    public static String getJavaVendor()
    {
        if(props == null)
            return null;
        else
            return props.getProperty("java.vendor");
    }

    public static String getJavaVendorUrl()
    {
        if(props == null)
            return null;
        else
            return props.getProperty("java.vendor.url");
    }

    public static String getJavaHome()
    {
        if(props == null)
            return null;
        else
            return props.getProperty("java.home");
    }

    public static String getJavaVMSFCVesion()
    {
        if(props == null)
            return null;
        else
            return props.getProperty("java.vm.specification.version");
    }

    public static String getJavaVMSFCVendor()
    {
        if(props == null)
            return null;
        else
            return props.getProperty("java.vm.specification.vendor");
    }

    public static String getJavaVMSFCName()
    {
        if(props == null)
            return null;
        else
            return props.getProperty("java.vm.specification.name");
    }

    public static String getJavaVMVersion()
    {
        if(props == null)
            return null;
        else
            return props.getProperty("java.vm.version");
    }

    public static String getJavaVMVendor()
    {
        if(props == null)
            return null;
        else
            return props.getProperty("java.vm.vendor");
    }

    public static String getJavaVMName()
    {
        if(props == null)
            return null;
        else
            return props.getProperty("java.vm.name");
    }

    public static String getJavaSFCVersion()
    {
        if(props == null)
            return null;
        else
            return props.getProperty("java.specification.version");
    }

    public static String getJavaSFCVender()
    {
        if(props == null)
            return null;
        else
            return props.getProperty("java.specification.vender");
    }

    public static String getJavaSFCName()
    {
        if(props == null)
            return null;
        else
            return props.getProperty("java.specification.name");
    }

    public static String getJavaClassVersion()
    {
        if(props == null)
            return null;
        else
            return props.getProperty("java.class.version");
    }

    public static String getJavaClassPath()
    {
        if(props == null)
            return null;
        else
            return props.getProperty("java.class.path");
    }

    

}
