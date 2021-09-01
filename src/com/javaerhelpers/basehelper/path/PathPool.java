package com.javaerhelpers.basehelper.path;

import com.javaerhelpers.basehelper.property.Property;
import com.javaerhelpers.basehelper.system.SystemUtils;

import java.io.File;

/**
 * @desc:<p>用途</p>
 * @createDate:2021/8/27
 * @author:王凯宁未拷贝
 * @version:0.0.1
 */
public class PathPool {

    private static Property property;
    private static String parentRoot=new File(System.getProperty("user.dir")).getParent();

    public PathPool() {
        property = new Property();
    }

    public PathPool(String filePath) {
        property = new Property(filePath);
    }

    public static String getTempFilePath() {
        String osType = SystemUtils.getOperatingSystemType();
        if ("unix".equals(osType)) {
            return property.getProperty("unix.temp.path");
        } else {
            return parentRoot + property.getProperty("windows.temp.path");
        }
    }

    public static String getLogFilePath() {
        String osType = SystemUtils.getOperatingSystemType();
        if ("unix".equals(osType)) {
            return property.getProperty("unix.log.path");
        } else {
            return parentRoot + property.getProperty("windows.log.path");
        }
    }
}
