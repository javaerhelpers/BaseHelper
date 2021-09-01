package com.javaerhelpers.basehelper.regexp;

/**
 * @desc:<p>各种正则表达式</p>
 * @createDate:2021/8/27
 * @author:王凯宁未拷贝
 * @version:1.0.0
 */
public class RegexpConstants {

    /**
     * @desc:<p>正则表达式：手机号</p>
     * @date:2021/8/27
     * @author:王凯宁
     * @version:1.0.0
     */
    public static final String REGEXP_MOBILE ="^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$";

    /**
     * @desc:<p>正则表达式：邮箱</p>
     * @date:2021/8/27
     * @author:王凯宁
     * @version:1.0.0
     */
    public static final String REGEXP_EMAIL = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";

    /**
     * @desc:<p>正则表达式：中文</p>
     * @date:2021/8/27
     * @author:王凯宁
     * @version:1.0.0
     */
    public static final String REGEXP_CHINESE = "^[\u4e00-\u9fa5],{0,}$";

    /**
     * @desc:<p>正则表达式：身份证</p>
     * @date:2021/8/27
     * @author:王凯宁
     * @version:1.0.0
     */
    public static final String REGEXP_ID_CARD = "(^\\d{18}$)|(^\\d{15}$)";

    /**
     * @desc:<p>正则表达式：网址</p>
     * @date:2021/8/27
     * @author:王凯宁
     * @version:1.0.0
     */
    public static final String REGEXP_URL = "http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?%&=]*)?";

    /**
     * @desc:<p>正则表达式：IP地址</p>
     * @date:2021/8/27
     * @author:王凯宁
     * @version:1.0.0
     */
    public static final String REGEXP_IP_ADDR = "(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)";
}
