package com.iotknowyou.springsources.TestDemo;

import com.iotknowyou.springsources.config.UserConfig;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo_001 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"ApplicationContext.xml"});
        BeanFactory beanFactory = context;
        UserConfig userConfig = (UserConfig) beanFactory.getBean("userConfig");
        System.out.println(userConfig.newUser().toString());
    }
}
