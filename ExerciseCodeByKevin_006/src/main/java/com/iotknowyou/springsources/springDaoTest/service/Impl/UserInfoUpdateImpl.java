package com.iotknowyou.springsources.springDaoTest.service.Impl;

import com.iotknowyou.springsources.springDaoTest.service.UserInfoUpdate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

import javax.sql.DataSource;
import java.sql.Types;

public class UserInfoUpdateImpl extends SqlUpdate implements UserInfoUpdate {


    public UserInfoUpdateImpl(DataSource dataSource){
        setDataSource(dataSource);
        setSql("update exercise_06_tables_user set money=? where id=?");
        declareParameter(new SqlParameter(Types.DOUBLE));
        declareParameter(new SqlParameter(Types.INTEGER));
        compile();
    }




    @Override
    public Boolean UpdateUserInfo(Integer id,Double money) {
        int row = update(new Object[]{new Double(money),new Integer(id)});
        if(row > 0 ){
            System.out.println("数据添加成功！");
            return true;
        }
        return false;
    }
}
