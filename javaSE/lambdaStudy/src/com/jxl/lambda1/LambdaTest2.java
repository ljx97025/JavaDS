package com.jxl.lambda1;

import org.junit.Test;

/**
 * @ClassName : lambdaTest2
 * @Author : ljx
 * @Date: 2021/4/23 15:55
 * @Description : 测试语法
 */
public class LambdaTest2 {

    @Test
    public void test01() {

//		LambdaNoneReturnNoneParameter lambda1=()->{
//			System.out.println("lambda1 ");
//		};
//		lambda1.test();

        //如果 {} 中只有一条语句，那么此时 {} 可以省略
        LambdaNoneReturnNoneParameter lambda1=()->System.out.println("lambda1 ");
        lambda1.test();


//		LambdaNoneReturnMultipleParameter lambda2=(int a, int b)->{
//			System.out.println("lambda2: "+ (a+b));
//		};
//		lambda2.test(1, 1);
        // lambda表达式中参数的类型可以省略
//		由于在接口中已经定义了参数，所以在Lambda表达式中参数的类型可以省略
//	    备注：如果需要进行省略类型,但是所有参数的类型必须都得省略，省略部分会报错
        LambdaNoneReturnMultipleParameter lambda2=(a, b)->{
            System.out.println("lambda2: "+ (a+b));
        };
        lambda2.test(1, 1);

//		LambdaNoneReturnSingleParameter lambda3 = (int a)->{
//			System.out.println("lambda3: "+ a);
//		};
//		lambda3.test(3);
        //
        LambdaNoneReturnSingleParameter lambda3 = a->{
            System.out.println("lambda3: "+ a);
        };
        lambda3.test(3);
//		如果参数列表中，参数的个数有且只有一个（多了少了都不行），那么小括号可以省略
//	    且仍然可以省略参数的类型
        LambdaSingleReturnMultipleParameter lambda4 = (int a, int b)->{
            return a+b;
        };
        System.out.println("lambda4: "+ lambda4.test(1, 1));

//		LambdaSingleReturnNoneParameter lambda5 = ()->{
//			return 1024;
//		};
//		System.out.println("lambda5: "+ lambda5.test());
//		如果接口的唯一方法只有唯一返回语句，那么可以省略大括号，但是在省略大号的同时必须省略return

        LambdaSingleReturnNoneParameter lambda5 = ()->1024;

        System.out.println("lambda5: "+ lambda5.test());

//		LambdaSingleReturnSingleParameter lambda6 = (int a)->{
//			return a;
//		};

        LambdaSingleReturnSingleParameter lambda6 =  a-> a;

        System.out.println("lambda6: "+ lambda6.test(1023));

    }


}

//1.无返回值的多参数接口
@FunctionalInterface
interface LambdaNoneReturnMultipleParameter {
    void test(int a, int b);
}
//2.无返回值的无参接口
@FunctionalInterface
interface LambdaNoneReturnNoneParameter {
    void test();
}
//3.无返回值的一参接口
@FunctionalInterface
interface LambdaNoneReturnSingleParameter {
    void test(int n );
}

//4.有返回值的多参接口
@FunctionalInterface
interface LambdaSingleReturnMultipleParameter {
    int test(int a, int b);
}
//5.有返回值的无参接口
@FunctionalInterface
interface LambdaSingleReturnNoneParameter {
    int test();

}
//6.有返回值的一参接口
@FunctionalInterface
interface LambdaSingleReturnSingleParameter {
    int test(int n);
}