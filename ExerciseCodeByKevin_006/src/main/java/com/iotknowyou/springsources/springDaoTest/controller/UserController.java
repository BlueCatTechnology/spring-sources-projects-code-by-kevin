package com.iotknowyou.springsources.springDaoTest.controller;

import com.iotknowyou.springsources.springDaoTest.entity.User;
import com.iotknowyou.springsources.springDaoTest.service.LoginService;
import com.iotknowyou.springsources.springDaoTest.service.TransferService;
import com.iotknowyou.springsources.springDaoTest.service.UserInfoUpdate;
import com.iotknowyou.springsources.springDaoTest.service.UserService;
import org.apache.commons.dbcp.BasicDataSource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.object.SqlFunction;

import java.util.List;

public class UserController {

    @Test
    public  void TsetOne() {
        /* 简单的测试 */
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        BeanFactory beanFactory = context;
        UserService userService = (UserService) beanFactory.getBean("userServiceImpl");
        User user = new User("JdbcDaoSupportTest",22,888.98);
        userService.AddUser(user);
        List<User> userList = userService.queryAllUserInfo();
        for (User user1 : userList) {
            System.out.println(user1);
        }

    }

    @Test
    public void TestTwo(){
        /* 简单的测试 */
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        BeanFactory beanFactory = context;
        LoginService loginService = (LoginService) beanFactory.getBean("loginServiceImpl");
        List<User> userList = loginService.GetUserInfoById(1);
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void TestThree(){
        /* 简单的测试 */
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        BeanFactory beanFactory = context;
        UserInfoUpdate userInfoUpdate = (UserInfoUpdate) beanFactory.getBean("userInfoUpdateImpl");
        userInfoUpdate.UpdateUserInfo(4,1006.00);
    }

    /* 测试使用 SQLFunction 的使用 ,返回统计求和的结果 */
    @Test
    public void TestFour(){
        /* 简单的测试 */
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        BeanFactory beanFactory = context;
        BasicDataSource basicDataSource = (BasicDataSource) beanFactory.getBean("dataSources");
        SqlFunction sqlFunction = new SqlFunction(basicDataSource,"select count(1) from exercise_06_tables_user ");
        sqlFunction.compile();
        int count = sqlFunction.run();
        /* 结果为： 表中的记录总数 */
        System.out.println("User count : "+count);
    }

    /* 测试 数据库操作的事务 */
    @Test
    public void TestFive(){
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        BeanFactory beanFactory = context;
        TransferService transferService = (TransferService) beanFactory.getBean("userDaoProxy");
        try {
            Boolean aBoolean = transferService.transfer(1, 2, 200.00);
            if (aBoolean){
                System.out.println("交易完成。。。");
            }
        }catch (Exception e){
            System.out.println("交易失败。。。");
            System.out.println("事务回滚。。。。");
            e.printStackTrace();
        }

    }
}
