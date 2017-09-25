package com.vnb.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class HelloServiceAspect {



    public void beforeAdvice1 () {
        System.out.println("#############前置通知1");

    }
    public void beforeAdvice2  (String param) {
        System.out.println("#############前置通知2");

    }



    public void afterAdvice () {

        System.out.println("###############后置最终通知");
    }

    public void afterReturningAdvice (int returnArgs) {

        System.out.println("后置返回通知");
        System.out.println("目标方法返回值"+returnArgs);


    }

    public void afterThrowingAdvice (Exception e) {
            System.out.println("后置异常通知");
            System.out.println("异常信息："+e);

    }

    public Object aroundAdvice (ProceedingJoinPoint pjp) throws Throwable {

            System.out.println("######环绕通知 前置通知");
           Object obj =  pjp.proceed(new Object[]{"替代原参数"});
            System.out.println("####环绕通知   后置通知");
            return obj;

    }
}
