package com.iotknowyou.springsources.mybatisTest.mapper;

import com.iotknowyou.springsources.mybatisTest.entity.User;

import java.util.List;

public interface UserMapper {

    /*获取全部用户的信息*/
    List<User> getUserList();

    /*添加一个用户*/
    Integer addUser(User user);

    /*通过ID 查询用户*/
    User getUser(Integer id);
}
