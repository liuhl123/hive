package com.vnb.spring.aop.service;

public interface IHelloService {

    public void sayHello ();

    public void sayBefore (String param);

    public String sayAfterReturning ();

    public void sayThrowing ();

    public void sayFinally (String name);

    public void sayAround (String param);
}
