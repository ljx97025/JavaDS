package com.jxl.lambda1;

/**
 * @ClassName : LambdaTest3
 * @Author : ljx
 * @Date: 2021/4/23 15:58
 * @Description : 函数式接口
 */

import java.util.function.*;

/**
 * 测试 函数式接口
 * Supplier 代表一个输出 Supplier<T> T get();
 *
 * Consumer 代表一个输入 Consumer<T> void accept(T t)
 * BiConsumer 代表两个输入 BiConsumer<T, U> void accept(T t, U u);
 *
 * Function 代表一个输入，一个输出(一般输入和输出是不同类型) Function<T, R>  R apply(T t);
 * UnaryOperator 代表一个输入，一个输出(输入和输出是相同类型) UnaryOperator<T> T apply(T t); UnaryOperator继承于Function
 *
 * BiFunction 代表两个输入，一个输出(一般输入和输出是不同类型) BiFunction<T, U, R>  R apply(T t, U u)
 * BinaryOperator 代表两个输入，一个输出(输入和输出是相同类型) BinaryOperator<T> T apply(T t, T u) BinaryOperator 继承于BiFunction
 *
 */
public class LambdaTest3 {
    public static void main(String[] args){
        Supplier<String> supplier = ()->{System.out.println("supplier"); return "success";};
        System.out.println(supplier.get());
        System.out.println("----------------------");

        Consumer<String> consumer = (String s)->{System.out.println("consumer---"+s);};
        consumer.accept("myConsumer");
        System.out.println("----------------------");

        BiConsumer<String,String> biConsumer = (desc1,desc2)->{
            System.out.println("biConsumer---param1---"+desc1);
            System.out.println("biConsumer---param2---"+desc2);};
        biConsumer.accept("参数1","参数2");
        System.out.println("----------------------");

        Function<String, Integer> function =(s)->{
            System.out.println("function---"+s);
            return 1024;};
        System.out.println(function.apply("myFunction"));
        System.out.println("----------------------");

        UnaryOperator<String> unaryOperator = (s)->{System.out.println("unaryOperator---"+s);
            return "success";};
        System.out.println(unaryOperator.apply("myUnaryOperator"));
        System.out.println("----------------------");

        BiFunction<String,String,Integer> biFunction = (desc1,desc2)->{
            System.out.println("biConsumer---param1---"+desc1);
            System.out.println("biConsumer---param2---"+desc2);
            return 2048;
        };
        System.out.println(biFunction.apply("参数1","参数2"));
        System.out.println("----------------------");

        BinaryOperator<String> binaryOperator = (desc1,desc2)->{
            System.out.println("biConsumer---param1---"+desc1);
            System.out.println("biConsumer---param2---"+desc2);
            return "myBinaryOperator";
        };
        System.out.println(binaryOperator.apply("参数1","参数2"));
        System.out.println("----------------------");
    }
}
