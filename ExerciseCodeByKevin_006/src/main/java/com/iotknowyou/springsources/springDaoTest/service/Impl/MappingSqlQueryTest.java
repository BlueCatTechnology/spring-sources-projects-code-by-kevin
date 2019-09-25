package com.iotknowyou.springsources.springDaoTest.service.Impl;

import com.iotknowyou.springsources.springDaoTest.entity.User;
import org.springframework.jdbc.object.MappingSqlQuery;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MappingSqlQueryTest extends MappingSqlQuery<User> {

    @Override
    protected User mapRow(ResultSet resultSet, int RowNum) throws SQLException {
        User user = new User();
        user.setId( resultSet.getInt("id"));
        user.setName( resultSet.getString("name"));
        user.setAges(resultSet.getInt("ages"));
        user.setMoney(resultSet.getDouble("money"));
        return user;
    }
}
