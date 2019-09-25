package com.iotknowyou.springsources.mybatisTest.entity;

public enum UserState {
    DISABLED(0),
    AVAILABLE(1);
    private int status;
    UserState(int status){this.status=status;}
    public int getStatus(){return status;}
}
