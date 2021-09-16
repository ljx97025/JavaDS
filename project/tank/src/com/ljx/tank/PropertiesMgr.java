package com.ljx.tank;

import java.io.IOException;
import java.util.Properties;

/**
 * @ClassName : PropertiesMgr
 * @Author : LT
 * @Date: 2021/9/16 23:07
 * @Description : 配置文件管理类
 */
public class PropertiesMgr {
    static Properties properties = new Properties();
    private PropertiesMgr(){
    }
    static {
        try {
            properties.load(PropertiesMgr.class.getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object get(String key) {
        if (properties == null) {
            return null;
        }
        return properties.get(key);
    }
}
