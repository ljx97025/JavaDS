package com.jxl.entity;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName : Decorator
 * @Author : ljx
 * @Date: 2021/4/30 9:51
 * @Description : 装饰
 */
@Target({ElementType.TYPE,ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Decorator {
    String value() default "not";
}
