package com.example.demo.mult;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @ClassName : DataSourceAspect
 * @Author : ljx
 * @Date: 2021/4/21 11:29
 * @Description : AOP拦截类 拦截 CONTEXT_HOLDER里的数据源信息
 */
@Aspect
@Order(1)
@Component
public class DataSourceAspect {
    @Pointcut("@annotation(com.example.demo.mult.DataSourceAnnotation)")
    public void dsPointCut(){}

    @Around("dsPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        System.out.println("----------------拦截-----------");
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        DataSourceAnnotation dataSource = method.getAnnotation(DataSourceAnnotation.class);
        if (dataSource != null) {
            DynamicDataSourceContextHolder.setDataSourceType(dataSource.value().name());
        }
        try {
            return point.proceed();
        } finally {
            // 销毁数据源 在执行方法之后
            DynamicDataSourceContextHolder.clearDataSourceType();
        }
    }
}
