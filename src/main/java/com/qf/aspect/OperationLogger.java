package com.qf.aspect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface OperationLogger {
    //操作名称
    String modelName() default "";

    //操作实体
    String opEntity() default "";

    //操作接口
    String option();
}
