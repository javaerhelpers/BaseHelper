package com.javaerhelpers.basehelper.property;

import com.javaerhelpers.basehelper.logger.LoggerUtils;
import org.slf4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @desc:<p>配置文件类</p>
 * @createDate:2021/8/27
 * @author:王凯宁未拷贝
 * @version:1.0.0
 */
public class Property {

    private String filePath;
    private static Properties properties;
    private static Logger logger = LoggerUtils.getLogger(Property.class);

    /**
     * @desc:<p>读取默认配置</p>
     * @date:2021/8/27
     * @author:王凯宁
     * @version:1.0.0
     */
    public Property() {
        try {
            properties = new Properties();
            properties.load(Property.class.getResourceAsStream("/default.properties"));
        } catch (IOException e) {
            logger.error("读取默认配置信息出错！",e);
        }
    }

    /**
     * @desc:<p>根据路径读取配置</p>
     * @date:2021/8/27
     * @author:王凯宁
     * @version:0.0.1
     * @param filePath
     * @return
     */
    public Property(String filePath) {
        try {
            properties = new Properties();
            properties.load(new FileInputStream(filePath));
        } catch (IOException e) {
            logger.error("读取配置信息出错！配置文件路径："+filePath);
        }
    }

    /**
     * @desc:<p>根据参数名获取参数值</p>
     * @date:2021/8/27
     * @author:王凯宁
     * @version:0.0.1
     * @param prepKey 参数名
     * @return
     */
    public String getProperty(String prepKey) {
        return properties.getProperty(prepKey);
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
