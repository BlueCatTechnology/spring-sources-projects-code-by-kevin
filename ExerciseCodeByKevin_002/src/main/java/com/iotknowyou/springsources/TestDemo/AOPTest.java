package com.iotknowyou.springsources.TestDemo;

import com.iotknowyou.springsources.base.baseicAopInterfaceServices;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPTest {
    public static void main(String[] args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"ApplicationContext.xml"});
        BeanFactory beanFactory = context;
        baseicAopInterfaceServices aopService = (baseicAopInterfaceServices) beanFactory.getBean("aopService");
        aopService.withAopMethod();
        aopService.withNoAopMethod();
    }
}
