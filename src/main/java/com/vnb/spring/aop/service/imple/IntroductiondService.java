package com.vnb.spring.aop.service.imple;

import com.vnb.spring.aop.service.IIntroductionService;

public class IntroductiondService implements IIntroductionService {
    @Override
    public void product() {
         System.out.println("引入接口的默认实现");
    }
}
