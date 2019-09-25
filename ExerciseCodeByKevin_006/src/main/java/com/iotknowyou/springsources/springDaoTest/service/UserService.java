package com.iotknowyou.springsources.springDaoTest.service;

import com.iotknowyou.springsources.springDaoTest.entity.User;

import java.util.List;

public interface UserService {
    /*
    *  查询所有用户的信息
    */
    public List<User> queryAllUserInfo();

    /*
    *  添加一个用户信息
    */
    public Boolean AddUser(User user);


}
