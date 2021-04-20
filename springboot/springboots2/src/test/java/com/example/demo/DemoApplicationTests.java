package com.example.demo;

import com.example.entity.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

/**
 * 注意
 * 1. 自动扫描时，默认扫描入口类所在包及其子包，如需修改，使用@ComponentScan在入口类上，标注扫描的其他包
 * 2. 使用.properties文件给对象加载值时，会出现汉字无法识别，使用.yaml文件不会有问题
 *      .properties  @value 为每一个属性赋值(放在属性上)
 *      .yaml        @ConfigurationProperties 为每一个类赋值(放在类上)
 */

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    Person person;

    @Test
    void contextLoads() {
        System.out.println(person);
    }

}

