package com.example.demo.mult;

import java.lang.annotation.*;

/**
 * @ClassName : DataSourceAnnotation
 * @Author : ljx
 * @Date: 2021/4/21 11:26
 * @Description : 数据源切换注解
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSourceAnnotation {
    DataSourceType value() default DataSourceType.REMOTE;
}
