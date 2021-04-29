package com.jxl.test;

import com.jxl.entity.Person;

/**
 * @ClassName : GetClassObject
 * @Author : ljx
 * @Date: 2021/4/26 16:20
 * @Description : 获取Class对象
 */
public class GetClassObject {

    public static void main(String[] args) throws ClassNotFoundException {
        // 使用反射reflect 获取Class对象
        // 推荐使用1，2  第3种需要预先创建对象，但是创建对象的时候已经创建了Class对象, 所以会浪费资源

//        //1. 通过类名.class获取
//        Class<Person> aClass = Person.class;
//        //2. 通过Class.forName
//        Class aClass1 = Class.forName("com.jxl.entity.Person");
//        //3. 通过对象.getClass()
//        Person person = new Person();
//        Class aClass2 = person.getClass();
//        // 可以通过Classloader.loadClass() 获取class 但需要注意确保Classloader对象是可以加载到需要获取的class对象
//        Class aClass3 = GetClassObject.class.getClassLoader().loadClass("com.jxl.entity.Person");
        //4. 如果是基本数据类型 那么可以通过Type的方式来获取Class对象
//        Class type = Integer.TYPE;

        Class<Person> aClass = Person.class;

        System.out.println(aClass.getClassLoader());
        System.out.println(aClass.getName());
        System.out.println(aClass.getSimpleName());
        System.out.println(aClass.getPackage());
        System.out.println("============================");
        Class aClass3 = GetClassObject.class.getClassLoader().loadClass("com.jxl.entity.Person");



        System.out.println(aClass3.getClassLoader());
        System.out.println(aClass3.getName());
        System.out.println(aClass3.getSimpleName());
        System.out.println(aClass3.getPackage());
    }

}
