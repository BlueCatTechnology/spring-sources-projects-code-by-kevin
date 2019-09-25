package com.iotknowyou.springsources.mybatisTest.entity;

public class User {
    /*用户ID*/
    private Integer id;
    /*用户名*/
    private String name;
    /*年龄*/
    private Integer ages;
    /*余额*/
    private Double money;

    public User() {
    }

    public User(String name, Integer ages, Double money) {
        this.name = name;
        this.ages = ages;
        this.money = money;
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ages=" + ages +
                ", money=" + money +
                '}';
    }
}
