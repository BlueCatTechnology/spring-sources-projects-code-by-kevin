package com.iotknowyou.springsources.mybatisTest.TestDemo;

import com.iotknowyou.springsources.mybatisTest.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class mybatisTestDemo {

    @Test
    public void TestDemo() throws IOException {
        String resources = "mybatis-config.xml";
        // 使用 Mybatis 提供的 Resources类加载 mybatis 的配置文件 （ 也加载关联的映射文件）
        Reader reader = Resources.getResourceAsReader(resources);
        // 构建 SQLSession 的工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        // 创建 能够执行映射文件中的sql的 sqlSession
        SqlSession session = sqlSessionFactory.openSession();
        String statement = "com.iotknowyou.springsources.mybatisTest.mapper.UserMapperOne.getUserList";
        List<User> userList = session.selectList(statement);
        for (User user : userList) {
            System.out.println(user);
        }
    }
}
