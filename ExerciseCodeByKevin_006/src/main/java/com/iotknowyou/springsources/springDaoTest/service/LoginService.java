package com.iotknowyou.springsources.springDaoTest.service;

import com.iotknowyou.springsources.springDaoTest.entity.User;

import java.util.List;

public interface LoginService {
    /*
    *   UserService 中的 queryAllUserInfo()方法，是使用 getJdbcTemplate().queryForList(sql) 返回的是 List<Map<String ,Object>>
    *   需要遍历转换成Java对象，
    *   有的时候会有带条件的查询，
    *   我们可以通过实现 MappingSQLQuery 这个抽象类，实现里面的 mapRow() 返回一个 List<T> 的类型
    *
    */

    /* 通过ID得到用户的信息*/
    public List<User> GetUserInfoById(Integer id);
}
