package com.jxl.lambda1;

/**
 * @ClassName : LambdaTest1
 * @Author : ljx
 * @Date: 2021/4/23 14:33
 * @Description : lambda study
 */
public class LambdaTest1 {
    public static void main(String[] args){
        Student s = ()->{System.out.println("student");};
        s.show();
        Student s1 = ()->System.out.println("student1");
        s1.show();
    }
}

interface Student{
    public void show();
}
