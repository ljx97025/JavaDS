package com.jxl.entity;

import java.lang.annotation.*;

/**
 * @ClassName : MyAnnotation
 * @Author : ljx
 * @Date: 2021/4/30 0:10
 * @Description : 测试使用注解
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface MyAnnotation {
    String value() default "test";
    String name() default "name";
}
