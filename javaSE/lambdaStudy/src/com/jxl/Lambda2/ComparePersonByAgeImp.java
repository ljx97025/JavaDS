package com.jxl.Lambda2;

/**
 * @ClassName : ComparePersonByAgeImp
 * @Author : ljx
 * @Date: 2021/4/23 14:50
 * @Description : 比较年龄
 */
public class ComparePersonByAgeImp implements PersonDao {

    private int age;

    public ComparePersonByAgeImp(int age) {
        this.age = age;
    }

    @Override
    public boolean compare(Person p) {
        return p.getAge()>this.age;
    }
}
