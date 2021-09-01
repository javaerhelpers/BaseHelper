package com.javaerhelpers.basehelper.date;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @desc:<p>Date工具类</p>
 * @createDate:2021/8/27
 * @author:王凯宁未拷贝
 * @version:0.0.1
 */
public class DateUtils {

//    private static Logger logger= LoggerUtil.getLogger(DateUtil.class);
//
//    /**
//     * 根据格式转换字符串
//     * <p> createDate: 2018/11/14 <br> updateDate: 2018/11/14
//     * @param dateString 要转换字符串
//     * @param datePattern 格式串
//     * @return 转换后的日期
//     * @author: 王凯宁
//     * @version: 0.0.1
//     */
//    public static Date toDate(String dateString,String datePattern) {
//        SimpleDateFormat fmt = new SimpleDateFormat(datePattern);
//        Date date= null;
//        try {
//            date = fmt.parse(dateString);
//        } catch (ParseException e) {
//            logger.error("字符串["+dateString+"]转换成格式["+datePattern+"]的日期出错");
//        }
//        return date;
//    }
//
    /**
     * 根据格式转换日期
     * <p> createDate: 2018/11/14 <br> updateDate: 2018/11/14
     * @param date 要转换的日期
     * @param datePattern 格式串
     * @return 转换后的字符串
     * @author: 王凯宁
     * @version: 0.0.1
     */
    public static String toString(Date date, String datePattern) {
        SimpleDateFormat fmt = new SimpleDateFormat(datePattern);
        return fmt.format(date);
    }
//
//    /**
//     * 判断date1是否在date2之前
//     * <p> createDate: 2018/11/30 <br> updateDate: 2018/11/30
//     * @param date1 时间1
//     * @param date2 时间2
//     * @return 是/否
//     * @author: 王凯宁
//     * @version: 0.0.1
//     */
//    public static boolean isBefore(Date date1, Date date2) {
//        return date1.before(date2);
//    }
//
//    /**
//     * 判断date1是否在date2之后
//     * <p> createDate: 2018/11/30 <br> updateDate: 2018/11/30
//     * @param date1 时间1
//     * @param date2 时间2
//     * @return 是/否
//     * @author: 王凯宁
//     * @version: 0.0.1
//     */
//    public static boolean isAfter(Date date1, Date date2) {
//        return date1.after(date2);
//    }
}
