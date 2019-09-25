package com.iotknowyou.springsources.mybatisTest.mapper;

import com.iotknowyou.springsources.mybatisTest.entity.User;

import java.util.List;

public interface UserMapperOne {

    /*获取全部用户的信息*/
    List<User> getUserList();


}
