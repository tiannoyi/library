package com.qf.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @program: library
 * @description:
 * @author: XiongJun
 * @create: 2019-12-18 17:45
 **/
@Aspect
@Component
public class AccountAdvisor {
    @Pointcut("execution(* com.qf.service.*.*(..))")
    public void pointcut(){}

    @Before("pointcut()")
    public  void testCut(){
        System.out.println("测试切面");
    }
}
