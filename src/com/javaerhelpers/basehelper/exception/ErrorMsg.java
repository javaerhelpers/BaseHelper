package com.javaerhelpers.basehelper.exception;

/**
 * @desc:<p>错误信息对象</p>
 * @createDate:2021/8/27
 * @author:王凯宁未拷贝
 * @version:1.0.0
 */
public class ErrorMsg {

    /**
     * @desc:<p>错误代码</p>
     * @date:2021/8/27
     * @author:王凯宁
     * @version:1.0.0
     */
    private String errorCode;

    /**
     * @desc:<p>错误描述</p>
     * @date:2021/8/27
     * @author:王凯宁
     * @version:1.0.0
     */
    private String errorDesc;

    public ErrorMsg(String errorCode, String errorDesc) {
        this.errorCode = errorCode;
        this.errorDesc = errorDesc;
    }
}
