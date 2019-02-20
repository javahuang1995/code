package com.huang.spring.aop.study;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {
    @Pointcut("execution(* com.huang.spring.aop.study.BusinessService.*(..))")
    public void pointcutName(){}

    @Before("pointcutName()")
    public void performance(){
        System.out.println("Spring AOP");
    }
    
    @After("execution(* com.huang.spring.aop.study.BusinessService.*(..))")
    public void myAfter(){
    	 System.out.println("Spring AOP");
    }
}