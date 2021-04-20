package com.example.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ClassName : Person
 * @Author : ljx
 * @Date: 2021/4/20 19:10
 * @Description :
 */
@ConfigurationProperties(prefix = "person")
@Component
public class Person {
    @Value("${name}")
    private String name;
//    @Value("${age}")
    private int age;
//    @Value("${sex}")
    private String sex;
//    @Value("${desc}")
    private String desc;

    public Person() {
    }

    public Person(String name, int age, String sex, String desc) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
