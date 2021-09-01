package com.javaerhelpers.basehelper.io;

import com.javaerhelpers.basehelper.logger.LoggerUtils;
import com.javaerhelpers.basehelper.object.ObjectUtils;
import org.slf4j.Logger;

import java.io.OutputStream;

/**
 * @desc:<p>用途</p>
 * @createDate:2021/8/27
 * @author:王凯宁未拷贝
 * @version:0.0.1
 */
public class OutputStreamUtils {

    private static final Logger logger = LoggerUtils.getLogger(OutputStreamUtils.class);

    public static void close(OutputStream os){
        try{
            if(!ObjectUtils.isEmpty(os)){
                os.close();
            }
        }
        catch(Throwable e){
            logger.error( "关闭流错误", e );
        }
    }
}
