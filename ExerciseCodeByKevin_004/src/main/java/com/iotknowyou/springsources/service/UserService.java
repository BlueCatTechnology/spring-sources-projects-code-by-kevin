package com.iotknowyou.springsources.service;

import org.springframework.stereotype.Service;


public interface UserService {

    /* 定义二个方法，测试 面向切面编程  */
    public String withAopMethod() throws Exception;

    public String withNoAopMethod() throws Exception;
}
