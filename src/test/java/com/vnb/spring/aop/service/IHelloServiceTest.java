package com.vnb.spring.aop.service;

        import org.springframework.aop.framework.AopProxy;
        import org.springframework.context.ApplicationContext;
        import org.springframework.context.support.ClassPathXmlApplicationContext;

        import static org.junit.Assert.*;

public class IHelloServiceTest {


    @org.junit.Test
    public void sayHello() throws Exception {

        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/spring-AspectJ.xml");
        IHelloService helloService = context.getBean("helloService",IHelloService.class);
        helloService.sayFinally("留给还来那个");
//        helloService.sayThrowing();
//        helloService.sayAfterReturning();
//        helloService.sayBefore("刘海亮");
////        helloService.sayHello();
//        System.out.println(context.getType("helloService"));
////        helloService.sayBefore("hello springaAOP");
////        helloService.sayAfterReturning();
////        helloService.sayThrowing();
////          helloService.sayAround("nihao ");
////          IIntroductionService iIntroductionService = context.getBean("helloService",IIntroductionService.class);
////        iIntroductionService.product();

    }


}