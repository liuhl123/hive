package com.vnb.spring.aop.service.imple;

import com.vnb.spring.aop.service.IHelloService;

public class HelloService implements IHelloService {
    @Override
    public void sayHello() {
        System.out.println("hello spring-aop");

    }

    @Override
    public void sayBefore(String param) {
        System.out .println("############目标连接点：前置通知"+param);
    }

    @Override
    public String sayAfterReturning() {
        System.out.println("后置返回通知目标方法");
//       return "hello 世界";
        return "hello world";
    }

    @Override
    public void sayThrowing() {

        System.out.println("抛出异常通知   目标方法");
//        try{
//            System.out.println("抛出异常通知@##########后置异常通知");
            int a = 1/0;
//        } catch (Exception e) {
//            System.out.println("出現一場了");
//            System.out.println("出現一場了");
//        }
    }

    @Override
    public void sayFinally(String name) {
        System.out.println("目标方法：   后置最终通知"+name);

    }

    @Override
    public void sayAround(String param) {
        System.out.println("########around环绕通知"+param);

    }

}
