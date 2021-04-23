package com.jxl.Lambda2;

/**
 * @ClassName : PersonDao
 * @Author : ljx
 * @Date: 2021/4/23 14:49
 * @Description :
 */
//@FunctionalInterface注解不是必须的，不加这个注解的接口（前提是只包含一个方法）一样可以作为函数类型。
//        不过，显而易见的是，加了这个注解表意更明确、更直观。

//严格地说，@FunctionalInterface下只能声明一个未实现的方法，
// default方法和static方法因为带有实现体，所有不受此限制。

//覆写Object中toString/equals的方法不受此个数限制 （即Object类中的方法除外）


public interface PersonDao {
    boolean compare(Person p);

    default void showDefaultFunc(){
        System.out.println("我是默认方法");
    }

    static void showStaticFunc(){
        System.out.println("我是静态方法");
    }
}
