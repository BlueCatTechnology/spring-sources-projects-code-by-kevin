package com.iotknowyou.springsources.TestDemo;

import com.iotknowyou.springsources.service.UserService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPTest {
    public static void main(String[] args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"ApplicationContext.xml"});
        BeanFactory beanFactory = context;
        UserService userService = (UserService) beanFactory.getBean("serviceImplA");
        userService.withAopMethod();
        userService.withNoAopMethod();

    }
}
