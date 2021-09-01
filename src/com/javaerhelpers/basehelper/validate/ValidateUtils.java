package com.javaerhelpers.basehelper.validate;

import com.javaerhelpers.basehelper.regexp.RegexpConstants;

import java.util.regex.Pattern;

/**
 * @desc:<p>用途</p>
 * @createDate:2021/8/27
 * @author:王凯宁未拷贝
 * @version:0.0.1
 */
public class ValidateUtils {
    /**
     * 校验字符串是否是手机号格式
     * <p> createDate: 2018/11/13 <br> updateDate: 2018/11/13
     * @param mobile 验证字符串
     * @return boolean
     * @author: 王凯宁
     * @version: 0.0.1
     */
    public static boolean isMobile(String mobile) {
        return Pattern.matches(RegexpConstants.REGEXP_MOBILE, mobile);
    }

    /**
     * 校验字符串是否是邮箱格式
     * <p> createDate: 2018/11/13 <br> updateDate: 2018/11/13
     * @param email 验证字符串
     * @return boolean
     * @author: 王凯宁
     * @version: 0.0.1
     */
    public static boolean isEmail(String email) {
        return Pattern.matches(RegexpConstants.REGEXP_EMAIL, email);
    }

    /**
     * 校验字符串是否全是中文
     * <p> createDate: 2018/11/13 <br> updateDate: 2018/11/13
     * @param chinese 验证字符串
     * @return boolean
     * @author: 王凯宁
     * @version: 0.0.1
     */
    public static boolean isChinese(String chinese) {
        boolean flag=true;
        while (chinese.length()>0&&flag==true){
            flag=Pattern.matches(RegexpConstants.REGEXP_CHINESE, chinese.substring(0,1));
            chinese=chinese.substring(1);
            if(flag==false){
                return false;
            }
        }
        return true;
    }

    /**
     * 校验字符串是否是身份证格式
     * <p> createDate: 2018/11/13 <br> updateDate: 2018/11/13
     * @param idCard 验证字符串
     * @return boolean
     * @author: 王凯宁
     * @version: 0.0.1
     */
    public static boolean isIDCard(String idCard) {
        return Pattern.matches(RegexpConstants.REGEXP_ID_CARD, idCard);
    }

    /**
     * 校验字符串是否是url格式
     * <p> createDate: 2018/11/13 <br> updateDate: 2018/11/13
     * @param url 验证字符串
     * @return boolean
     * @author: 王凯宁
     * @version: 0.0.1
     */
    public static boolean isUrl(String url) {
        return Pattern.matches(RegexpConstants.REGEXP_URL, url);
    }

    /**
     * 校验字符串是否是IP地址格式
     * <p> createDate: 2018/11/13 <br> updateDate: 2018/11/13
     * @param ipAddr 验证字符串
     * @return boolean
     * @author: 王凯宁
     * @version: 0.0.1
     */
    public static boolean isIPAddr(String ipAddr) {
        return Pattern.matches(RegexpConstants.REGEXP_IP_ADDR, ipAddr);
    }
}
