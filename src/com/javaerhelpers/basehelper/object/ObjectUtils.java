package com.javaerhelpers.basehelper.object;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;

/**
 * @desc:<p>用途</p>
 * @createDate:2021/8/27
 * @author:王凯宁未拷贝
 * @version:0.0.1
 */
public class ObjectUtils {

    public static boolean isEmpty(Object obj) {
        if (obj == null) {
            return true;
        }
        if (obj instanceof CharSequence) {
            return ((CharSequence) obj).length() == 0;
        }
        if (obj.getClass().isArray()) {
            return Array.getLength(obj) == 0;
        }
        if (obj instanceof Collection) {
            return ((Collection) obj).isEmpty();
        }
        if (obj instanceof Map) {
            return ((Map) obj).isEmpty();
        }
        return false;
    }
}
