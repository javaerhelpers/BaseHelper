package com.javaerhelpers.basehelper.logger.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @desc <p>Logger工具类</p>
 * @createDate: 2021/8/24
 * @author: 王凯宁
 * @version: 0.0.1
 */
public class LoggerUtils {

    /**
     * @desc:<p>获取Logger</p>
     * @date:2021/8/26
     * @author:王凯宁
     * @version:0.0.1
     * @param clazz
     * @return
     */
    public static <T> Logger getLogger(Class<T> clazz) {
        return LoggerFactory.getLogger(clazz);
    }
}
