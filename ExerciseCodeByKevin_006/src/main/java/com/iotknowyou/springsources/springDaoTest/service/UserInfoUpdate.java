package com.iotknowyou.springsources.springDaoTest.service;

public interface UserInfoUpdate {

    /****************************************/
    /*     使用  SqlUpdate 实现对数据更新      */
    /***************** **********************/
    public Boolean UpdateUserInfo(Integer id , Double money);

}
