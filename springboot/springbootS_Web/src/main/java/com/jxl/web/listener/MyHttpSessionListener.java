package com.jxl.web.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @ClassName : MyListener
 * @Author : ljx
 * @Date: 2021/4/22 20:02
 * @Description : session监听器
 */
public class MyHttpSessionListener implements HttpSessionListener {
    public static int online = 0;

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("创建session");
        online++;
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("销毁session");
    }
}
