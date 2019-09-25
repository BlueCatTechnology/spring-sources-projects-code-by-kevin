package com.iotknowyou.springsources.service.Impl;

import com.iotknowyou.springsources.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String withAopMethod() throws Exception {
        System.out.println("AOP 函数运行方法：withAopMethod");
        if(description.trim().length() == 0){
            throw new Exception("description 属性不能为空");
        }
        return description;
    }

    @Override
    public String withNoAopMethod() throws Exception {
        System.out.println("无 AOP 函数运行方法：withNoAopMethod");
        return description;
    }
}
