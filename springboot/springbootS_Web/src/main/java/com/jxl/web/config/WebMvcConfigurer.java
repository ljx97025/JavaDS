package com.jxl.web.config;

import com.jxl.web.listener.MyHttpSessionListener;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName : WebMvcConfigurer
 * @Author : ljx
 * @Date: 2021/4/22 19:53
 * @Description :
 */
@Configuration
public class WebMvcConfigurer {
    @Bean
    public ServletListenerRegistrationBean listenerRegist(){
        ServletListenerRegistrationBean bean = new ServletListenerRegistrationBean();
        bean.setListener(new MyHttpSessionListener());
        System.out.println("listener");
        return bean;
    }
}
