package com.javaerhelpers.basehelper.exception;

import com.javaerhelpers.basehelper.error.SystemError;
import com.javaerhelpers.basehelper.io.VectorWriter;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @desc:<p>用途</p>
 * @createDate:2021/8/27
 * @author:王凯宁未拷贝
 * @version:0.0.1
 */
public abstract class BaseException  extends RuntimeException{

    protected String errorCode;

    /**
     * 分隔符
     */
    public static final char ENAME_DELIM = '.';
    public static final char ECODE_DELIM = ':';
    private static final String CRLT_DELIM = "\n";

    /**
     * 保存错误描述的列表信息，当程序截获到异常时，在抛出这个异常时可以增加一些辅助的错误信息
     */
    protected List<String> detailMessage = null;
    /**
     * 如果[true]，输出错误信息，否则不生成输出信息
     */
    protected boolean printFlag = true;

    public BaseException(){
        super( "N/A" );
        errorCode = "999999";
    }

    public BaseException(String errorCode,String message,Throwable cause){
        super(message,cause);
        this.errorCode = errorCode;
        // 是否虚拟机出了问题
        if( cause instanceof VirtualMachineError ){
            SystemError.printSystemError(this);
        }
    }

    /**
     * 初始化函数
     */
    public BaseException( String errorCode, String message ){
        super( message );
        this.errorCode = errorCode;
    }

    /**
     * 初始化函数
     */
    public BaseException( String message, Throwable cause ) {
        super( message, cause );
        setErrName( message );

        // 是否虚拟机出了问题
        if( cause instanceof VirtualMachineError ){
            SystemError.printSystemError(this);
        }
    }

    /**
     * 初始化函数
     */
    public BaseException( String message )
    {
        super( message );
        setErrName( message );
    }

    /**
     * 设置属性 errName
     * 从文件error.properties中获取errName对应的errCode和errDesc的内容
     * 如果errName的格式是
     * XXXXX:XXXXXXX，前后两部分使用[:]分割，则把前一部分保存到errCode中
     * @param errName
     */
    protected void setErrName(String errName)
    {
        int ptr = errName.indexOf( ECODE_DELIM );
        if( ptr > 0 ){
            this.errorCode = errName.substring( 0, ptr );
        }
        else{
            this.errorCode = "";
        }
    }

    /**
     * 取错误级别
     */
    public abstract int getLevel();

    /**
     * 获取属性errCode
     * @return java.lang.String
     */
    public String getErrorCode()
    {
        return this.errorCode;
    }

    /**
     * 增加错误描述信息
     * @param message 错误描述
     */
    public void addMessage(String message)
    {
        if(detailMessage==null){
            detailMessage = new ArrayList<>();
        }

        detailMessage.add(message);
    }

    public void setMessage(String message)
    {
        detailMessage = new ArrayList<String>();
        detailMessage.add(message);
    }

    /**
     * 增加错误描述信息
     * @param className 类名称
     * @param message 错误描述
     */
    public void addMessage( String className, String message )
    {
        if(detailMessage == null){
            detailMessage = new ArrayList<String>();
        }

        detailMessage.add(className + " : " + message);
    }

    /**
     * 取错误信息
     */
    @Override
    public String getMessage()
    {
        StringBuilder str = new StringBuilder( 64 );
        String s = super.getMessage();
        if( s != null ){
            str.append( s );
        }

        if( detailMessage != null ){
            for( int ii=0; ii<detailMessage.size(); ii++ ){
                str.append("\n").append(detailMessage.get(ii));
            }
        }

        return str.toString();
    }

    /**
     * 原始的错误信息
     * @return
     */
    public String getExceptionMessage()
    {
        return super.getMessage();
    }

    /**
     * @return StringArray
     */
    public List<String> getDetailMessage()
    {
        return this.detailMessage;
    }

    /**
     * 按以下格式生成错误信息
     * 错误代码：errCode；
     * 错误原因：getMessage()；
     *   >>：detailMessage中记录的错误描述
     * 如果cause不为空，在后面添加
     * 换行 << cause.toString()
     */
    @Override
    public String toString()
    {
        // 错误信息
        StringBuilder errLog = new StringBuilder(128);

        //显示错误代码
        errLog.append( "错误代码：").append(this.errorCode).append(CRLT_DELIM );

        //显示起始错误
        errLog.append( "错误信息：").append(super.getMessage()).append(CRLT_DELIM );

        //显示其他错误
        if( detailMessage != null ){
            for( int ii=0; ii<detailMessage.size(); ii++ ){
                errLog.append( "  >>：").append(detailMessage.get(ii)).append(CRLT_DELIM );
            }
        }

        // 如果cause不为空，在后面添加
        Throwable c = getCause();
        if( c != null ){
            errLog.append( "错误原因:").append(CRLT_DELIM );
            errLog.append( c.toString() );
        }

        return errLog.toString();
    }

    /**
     * 禁止log4j重复打印错误信息
     */
    @Override
    public void printStackTrace(PrintWriter s ) {
        // 只输出一次
        if( printFlag ){
            printFlag = false;
            super.printStackTrace(s);
        }
    }

    // 这里可以重复输出内容，否则只能输出一次
    public void printStackTrace( VectorWriter s )
    {
        super.printStackTrace(s);
    }
}
