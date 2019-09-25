package com.iotknowyou.springsources.springDaoTest.service.Impl;

import com.iotknowyou.springsources.springDaoTest.entity.User;
import com.iotknowyou.springsources.springDaoTest.service.LoginService;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.Types;
import java.util.List;

public class LoginServiceImpl extends JdbcDaoSupport implements LoginService {

    @Override
    public List<User> GetUserInfoById(Integer id) {
        String sql = "select id,name,ages,money from exercise_06_tables_user where id = ? ";
        MappingSqlQueryTest mappingSqlQueryTest = new MappingSqlQueryTest();
        /* 获取 getDataSource() */
        mappingSqlQueryTest.setDataSource(getDataSource());
        mappingSqlQueryTest.setSql(sql);
        mappingSqlQueryTest.setParameters(new SqlParameter(Types.INTEGER));
        mappingSqlQueryTest.compile();
        return mappingSqlQueryTest.execute(new Object[]{new Integer(id)});
    }


}
