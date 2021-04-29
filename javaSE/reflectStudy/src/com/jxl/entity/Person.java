package com.jxl.entity;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * @ClassName : Person
 * @Author : ljx
 * @Date: 2021/4/26 15:51
 * @Description :
 */
public class Person {
    private String name;
    protected int age;
    public int score;
    String sex;

    public Person() {
    }

    private Person(String name){
        System.out.println("私有方法");
        this.name = "**"+name;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;

    }

    public Person(String name, int age, int score, String sex) {
        this.name = name;
        this.age = age;
        this.score = score;
        this.sex = sex;
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

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                ", sex='" + sex + '\'' +
                '}';
    }

    private void showPrivate(){
        System.out.println("我是private方法");
    }

    protected void showProtected(){
        System.out.println("我是protected方法");
    }

    void showDefault(){
        System.out.println("我是无权限修饰的方法");
    }
}
