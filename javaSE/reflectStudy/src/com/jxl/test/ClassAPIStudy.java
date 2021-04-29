package com.jxl.test;

import com.jxl.entity.Person;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @ClassName : ClassAPIStudy
 * @Author : ljx
 * @Date: 2021/4/26 16:22
 * @Description : Class 方法学习
 */
public class ClassAPIStudy {
    @Test
    public void test01(){

        Class<Person> aClass = Person.class;
        Person person = null;
        try {
            person = aClass.newInstance(); //创建对象
            System.out.println(person);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    /**
     * 获取Class对象所指向类的方法
     */
    @Test
    public void testMethod() throws Exception {

        Class<Person> personClass = Person.class;
        Person person = personClass.newInstance();
        // 可以获取所有的public方法 包括父类的public方法
        Method[] methods = personClass.getMethods();
        for(Method m:methods){
            System.out.println(m.getName());
        }
        System.out.println("==========================");
        // 获取Person的所有方法(private protected 无权限修饰的方法 public)  但不包括父类的方法，
        Method[] declaredMethods = personClass.getDeclaredMethods();
        for(Method m:declaredMethods){
            System.out.println(m.getName());
        }
        System.out.println("==========================");

        // 获取指定名称的方法并调用
        // 1. 使用getMethod()
        Method setAge = personClass.getMethod("setAge", int.class);
        setAge.invoke(person, 12);
        Method setName = personClass.getMethod("setName", String.class);
        setName.invoke(person, "zhangsan");
        System.out.println(person);
        // 2. 使用getDeclaredMethod()
        System.out.println("==========================");
        Method setAge1 = personClass.getDeclaredMethod("setAge", int.class);
        Method setName1 = personClass.getDeclaredMethod("setName", String.class);
        setAge1.invoke(person,13);
        setName1.invoke(person,"wangwu");
        System.out.println(person);
        System.out.println("==========================");

        // 使用getDeclaredMethod 获取private protected 无权限修饰的方法 并调用
        Method showPrivate = personClass.getDeclaredMethod("showPrivate");
        showPrivate.setAccessible(true);
        showPrivate.invoke(person);
        Method showProtected = personClass.getDeclaredMethod("showProtected");
        showProtected.setAccessible(true);
        showProtected.invoke(person);
        Method showDefault = personClass.getDeclaredMethod("showDefault");
        showDefault.setAccessible(true);
        showDefault.invoke(person);
    }

    /**
     * 获取Class对象所指向类的属性
     */
    @Test
    public void testField() throws Exception{

        Class personClass = Person.class;
        Person person = (Person) personClass.newInstance();
        // 获取public成员变量,包括子类及父类
        Field[] fields = personClass.getFields();
        for(Field f:fields){
            System.out.println(f.getName());
        }
        System.out.println("==========================");
        // 此方法返回的是当前类的所有属性，所有的访问修饰符都可以拿到
        Field[] declaredFields = personClass.getDeclaredFields();
        for(Field f:declaredFields){
            System.out.println(f.getName());
            System.out.println(f.getType());
            System.out.println(f.getModifiers());
            System.out.println("-----");
        }
        System.out.println("==========================");
        // getField()只能获取public属性并设置
        Field score = personClass.getField("score");
        score.set(person,100);
        System.out.println("设置分数: "+person.getScore());
        System.out.println("==========================");
        // getDeclaredField()不仅可以获取public属性也可以获取其它所有剩余访问权限属性并设置
        Field name = personClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(person,"zhaosi");
        System.out.println("设置姓名: "+person.getName());
        Field age = personClass.getDeclaredField("age");
        age.setAccessible(true);
        age.set(person,14);
        System.out.println("设置年龄: "+person.getAge());
        Field sex = personClass.getDeclaredField("sex");
        sex.setAccessible(true);
        sex.set(person,"男");
        System.out.println("设置性别: "+person.getSex());
        System.out.println(person);

        // 可以使用get()方法获取属性值
//        System.out.println(sex.get(person));

    }

    /**
     * 获取Class对象所指向类的构造器
     */
    @Test
    public void testConstructor() throws Exception{
        Class aClass = Class.forName("com.jxl.entity.Person");

//        Object o = aClass.newInstance();
//        Object o1 = aClass.newInstance();
//        System.out.println(o==o1); // false
        // 仅能获取public 构造器
        Constructor[] constructors = aClass.getConstructors();
        for(Constructor c: constructors){
            System.out.println(c);
        }
        System.out.println("============");
        //获取所有的构造方法，无论是私有还是公有
        Constructor[] declaredConstructors = aClass.getDeclaredConstructors();
        for(Constructor c: declaredConstructors){
            System.out.println(c);
        }
        System.out.println("============");

        // 调用非public的构造器
        Constructor declaredConstructor = aClass.getDeclaredConstructor(String.class);
        declaredConstructor.setAccessible(true);
        Object hahah = declaredConstructor.newInstance("hahah");
        System.out.println(hahah);
        System.out.println("============");
        // 调用public的构造器
        Constructor declaredConstructor1 = aClass.getConstructor(String.class,int.class);
        Object aaha = declaredConstructor1.newInstance("aaha",11);
        System.out.println(aaha);


    }
}
