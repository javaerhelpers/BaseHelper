package com.javaerhelpers.basehelper.string;

/**
 * @desc:<p>用途</p>
 * @createDate:2021/8/27
 * @author:王凯宁未拷贝
 * @version:0.0.1
 */
public class StringUtils {
    /**
     * 判断字符串是否为空
     * <p> createDate: 2018/11/15 <br> updateDate: 2018/11/15
     * @param str 验证字符串
     * @return boolean
     * @author: 王凯宁
     * @version: 0.0.1
     */
    public static boolean isEmpty(String str) {
        return (str == null) ||  (str == "")||(str.trim().length()==0);
    }

    /**
     * 判断字符串是否非空
     * <p> createDate: 2018/11/15 <br> updateDate: 2018/11/15
     * @param str 验证字符串
     * @return boolean
     * @author: 王凯宁
     * @version: 0.0.1
     */
    public static boolean isNotEmpty(String str) {
        return (str != null) && (str.trim().length()>0);
    }
}
