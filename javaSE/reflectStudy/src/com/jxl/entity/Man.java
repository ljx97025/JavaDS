package com.jxl.entity;

/**
 * @ClassName : Man
 * @Author : ljx
 * @Date: 2021/4/30 9:47
 * @Description :
 */
@Decorator("好人")
public class Man extends Person{
    String desc;

    public Man() {
    }

    public Man(String name, int age, int score, String sex, String desc) {
        super(name, age, score, sex);
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Man{" + "name"+getName() +
                "desc='" + desc + '\'' +
                ", age=" + age +
                ", score=" + score +
                ", sex='" + sex + '\'' +
                '}';
    }
    @Decorator("展示")
    public void show(){
        System.out.println(desc);
    }
}
