package com.vnb.spring.aop;

import org.aspectj.lang.annotation.*;
import sun.awt.SunHints;

@Aspect()
public class HelloAspect2 {

    @Pointcut(value ="execution (* com.vnb.spring.aop.service..*.sayBefore(..)) && args(param)",argNames ="param")
    public void beforePointCut (String param) {}

    @Before(value = "beforePointCut(param)",argNames = "param")
    public void beforeAdvice (String param) {
        System.out.println("AspectJ前置通知："+param);
    }

    @Pointcut(value = "execution(* com.vnb.spring.aop.service..*.sayAfterReturning(..))")
    public void afterReturning () {}

    @AfterReturning(value = "afterReturning ()",returning = "result")
    public void afterReturnAdvice (Object result) {
        System.out.println("##########后置返回通知");
        System.out.println("目标方法返回的结果："+result);

    }


    @Pointcut(value = "execution(* com.vnb.spring.aop.service..*.sayThrowing())")
    public void exceptionPointcut () {}
    @AfterThrowing(value = "exceptionPointcut ()",throwing = "exception")
    public void afterThrwingAdvice (Exception exception) {
        System.out.println("后置抛出通知 ");
        System.out.println("异常信息："+exception);

    }


    /*后置最终通知切入点*/
    @Pointcut(value="execution (* com.vnb.spring.aop.service..*.sayFinally(..)) && args(name)",argNames = "name")
    public void afterFinallyPointCut (String name) {}
    /*后置最终通知*/
    @After(value = "afterFinallyPointCut (name)" ,argNames = "name")
    public void afterAdvice (String name) {
        System.out.println("后置最终通知 切面类方法"+name);

    }
}
