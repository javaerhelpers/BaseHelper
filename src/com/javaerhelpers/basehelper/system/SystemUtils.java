package com.javaerhelpers.basehelper.system;

import com.javaerhelpers.basehelper.string.StringUtils;

/**
 * @desc:<p>用途</p>
 * @createDate:2021/8/27
 * @author:王凯宁未拷贝
 * @version:0.0.1
 */
public class SystemUtils {
    /**
     * 获取操作系统完整名称，like 'windows 10'
     * <p> createDate: 2018/10/12 <br> updateDate: 2018/10/12
     * @author: 王凯宁
     * @return 操作系统名
     * @version: 0.0.1
     */
    public static String getOperatingSystemName() {
        return System.getProperty("os.name");
    }

    /**
     取操作系统类型
     * windows  or  unix
     * <p> createDate: 2018/10/12 <br> updateDate: 2018/10/12
     * @author: 王凯宁
     * @return 操作系统类型名
     * @version: 0.0.1
     */
    public static String getOperatingSystemType() {
        String osName = getOperatingSystemName();
        if (StringUtils.isEmpty(osName)){
            osName = "windows";
        } else {
            osName = osName.toLowerCase();
            if (osName.startsWith("windows")) {
                osName = "windows";
            }else{
                osName = "unix";
            }
        }
        return osName;

        //16:52:09,721  INFO http-nio-8080-exec-1 sys.SysHospitalController:52 - 医院信息列表:   {"biz_content":"f2zG5fklLwtAFXzwlkeZCUlSH89jeMLpRWVavAGRey9RTDUQ4PIyM6/+zdjWCQcOVcvnWSQBeSGq88Bs8pi4M9DY9c7JLe9kKmSmBDjV9Yk/8iKH/y3lhyDn3C1tJwd3","code":"0","appid":"nanjld","sign":"ac9ed26bc50584ea3d6303a4c1fca34a","version":"1.0","timestamp":1629876311975,"token":"fd990b9f06276519116631263c80fd52"}
        //16:52:09,722  INFO http-nio-8080-exec-1 sys.SysHospitalController:56 - 测试父目录路径:   /usr/local/tomcat/apache-tomcat-8.5.68
        //16:52:09,722  INFO http-nio-8080-exec-1 sys.SysHospitalController:57 - 测试系统名称:   Linux
    }
}
