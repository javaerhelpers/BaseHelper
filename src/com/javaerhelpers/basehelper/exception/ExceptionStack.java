package com.javaerhelpers.basehelper.exception;

import com.javaerhelpers.basehelper.io.VectorWriter;

import java.io.Serializable;

/**
 * @desc:<p>用途</p>
 * @createDate:2021/8/27
 * @author:王凯宁 未拷贝
 * @version:0.0.1
 */
public class ExceptionStack implements Serializable {

    private static final long serialVersionUID = 1L;

    private Throwable throwable;
    private String[] rep;

    public ExceptionStack(Throwable throwable){
        this.throwable = throwable;
    }

    public String[] getThrowableStrRep(){
        if(rep == null){
            VectorWriter vectorWriter = new VectorWriter();
            if( throwable instanceof BaseException ){
                ((BaseException)throwable).printStackTrace(vectorWriter);
            }
            else{
                throwable.printStackTrace(vectorWriter);
            }
            rep = vectorWriter.toStringArray();
        }
        return rep;
    }

}