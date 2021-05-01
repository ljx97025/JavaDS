package com.jxl.test;

import com.alibaba.druid.pool.DruidDataSource;
import com.jxl.service.ServiceImp;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName : ApplicationTest
 * @Author : ljx
 * @Date: 2021/5/1 12:16
 * @Description : 测试
 */
public class ApplicationTest {

    @Test
    public void test01(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        ServiceImp imp = context.getBean("serviceImp", ServiceImp.class);
        DruidDataSource dataSource = context.getBean("dataSource", DruidDataSource.class);
        System.out.println(dataSource.getUsername());
        imp.find();
    }
}
