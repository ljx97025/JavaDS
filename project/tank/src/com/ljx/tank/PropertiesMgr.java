package com.ljx.tank;


import java.io.IOException;
import java.util.Properties;

/**
 * @ClassName : PropertiesMgr
 * @Author : LT
 * @Date: 2021/9/16 22:48
 * @Description : 配置文件加载
 */
public class PropertiesMgr {
    static Properties properties = new Properties();
    static {
        try {
            properties.load(PropertiesMgr.class.getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object get(String key){
        if (properties == null) {
            return null ;
        }

        return properties.get(key);
    }

}
