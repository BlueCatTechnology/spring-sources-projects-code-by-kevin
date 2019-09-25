package com.iotknowyou.springsources.mybatisTest.entity;

import org.apache.ibatis.type.Alias;

@Alias("MyUsers")
public class User {
    /*用户ID*/
    private Integer id;
    /*用户名*/
    private String name;
    /*年龄*/
    private Integer ages;
    /*余额*/
    private Double money;
    /*用户的状态*/
    private UserState userState;

    public User() {
    }

    public User(String name, Integer ages, Double money,UserState userState) {
        this.name = name;
        this.ages = ages;
        this.money = money;
        this.userState =userState;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAges() {
        return ages;
    }

    public void setAges(Integer ages) {
        this.ages = ages;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public UserState getUserState() {
        return userState;
    }

    public void setUserState(UserState userState) {
        this.userState = userState;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ages=" + ages +
                ", money=" + money +
                ", userState=" + userState +
                '}';
    }
}
