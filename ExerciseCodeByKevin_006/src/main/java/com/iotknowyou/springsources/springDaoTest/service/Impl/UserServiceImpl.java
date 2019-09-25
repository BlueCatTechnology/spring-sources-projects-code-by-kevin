package com.iotknowyou.springsources.springDaoTest.service.Impl;

import com.iotknowyou.springsources.springDaoTest.entity.User;
import com.iotknowyou.springsources.springDaoTest.service.UserService;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserServiceImpl extends JdbcDaoSupport implements UserService {
    @Override
    public List<User> queryAllUserInfo() {
        String sql = "select * from exercise_06_tables_user order by id desc ";
        List<Map<String,Object>> list = getJdbcTemplate().queryForList(sql);
        List<User> userList = new ArrayList<User>();
        for (Map<String, Object> stringObjectMap : list) {
            User user = new User();
            user.setId((Integer) stringObjectMap.get("id"));
            user.setName((String) stringObjectMap.get("name"));
            user.setAges((Integer) stringObjectMap.get("ages"));
            user.setMoney(Double.parseDouble(stringObjectMap.get("money").toString()));
            userList.add(user);
        }
        return userList;
    }

    @Override
    public Boolean AddUser(User user) {
        String sql = "insert into exercise_06_tables_user(name ,ages ,money) values (?,?,?)";
        int row  = getJdbcTemplate().update(sql,new Object[]{user.getName(),user.getAges(),user.getMoney()});
        if (row > 0){
            System.out.println("添加数据成功");
            return true;
        }
        return false;
    }
}
