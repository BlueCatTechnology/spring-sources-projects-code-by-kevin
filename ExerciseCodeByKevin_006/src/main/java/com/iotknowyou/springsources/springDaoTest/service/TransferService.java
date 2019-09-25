package com.iotknowyou.springsources.springDaoTest.service;

public interface TransferService {

    /* fromUserId 向 toUserId 转账 */
    public Boolean transfer(Integer fromUserId ,Integer toUserId ,Double transferMoney);

}
