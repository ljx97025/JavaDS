package com.jxl.lambda1;

/**
 * @ClassName : LambdaTest4
 * @Author : ljx
 * @Date: 2021/4/23 16:25
 * @Description : 方法引用
 */

import java.util.function.*;

/**
 * 方法引用是用来直接访问类或者实例的已经存在的方法或者构造方法，方法引用提供了一种引用而不执行方法的方式，
 * 如果抽象方法的实现恰好可以使用调用另外一个方法来实现，就有可能可以使用方法引用
 *
 * 方法引用四种分类
 *
 *     类型             语法                       对应的lambda表达式
 * 静态方法引用    类名::staticMethod           (args)->类名.staticMethod(args)
 * 实例方法引用    instance::instanceMethod     (args)->instance.instanceMethod(args)
 * 对象方法引用    类名::instanceMethod         (instance,args)->instance.instanceMethod(args)
 * 构造方法引用    类名::new                    (args)->new 类名(args)
 */

public class LambdaTest4 {
    public static void main(String[] args){
        Supplier supplier = LambdaTest4::show;
        supplier.get();
        System.out.println("----------------------");

        Teather teather = new Teather("zhangsan", 23);
        Consumer<String> consumer = teather::show;
        consumer.accept("好老师");
        System.out.println("----------------------");

        BiFunction<String,Integer,Teather> function = Teather::new;
        Teather teather1 = function.apply("wangwu", 24);
        System.out.println("构造方法引用");
        System.out.println(teather1);
        System.out.println("----------------------");

        BiConsumer<Teather,String> biConsumer = (Teather teather2, String desc)->{
            teather2.show1(desc);
        };
        biConsumer.accept(new Teather("zhaoliu",25),"lambda 表达式 真不错");
        System.out.println("----------------------");

        BiConsumer<Teather,String> biConsumer2 = Teather::show1;
        biConsumer.accept(new Teather("zhaoliu",25),"对象方法引用 真不错呀");
        System.out.println("----------------------");

    }

    public static String show(){
        System.out.println("静态方法引用");
        return "success";
    }
}

class Teather{
    String name;
    int age;

    public void show(String desc){
        System.out.println("实例方法引用\n"+desc);
        System.out.println(this);
    }

    public void show1(String desc){
        System.out.println("方法引用\n"+desc);
        System.out.println(this);
    }

    public Teather(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Teather{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}