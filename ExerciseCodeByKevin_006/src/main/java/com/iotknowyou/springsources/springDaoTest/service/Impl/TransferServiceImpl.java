package com.iotknowyou.springsources.springDaoTest.service.Impl;

import com.iotknowyou.springsources.springDaoTest.service.TransferService;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

/* 数据的处理，有可能会出现异常，我们需要添加事务处理  */
public class TransferServiceImpl extends JdbcDaoSupport implements TransferService {

    @Override
    public Boolean transfer(Integer fromUserId, Integer toUserId, Double transferMoney) {
        /* 资金流出*/
        Boolean out = outInMoney(fromUserId,-transferMoney);

        // 异常的出现
        int i= 1/0;

        /* 资金流入*/
        Boolean in = outInMoney(toUserId,transferMoney);

        return out&in;
    }

    /* 收入与支出 */
    private Boolean outInMoney(Integer toUserId , Double money){
        String sql = "update exercise_06_tables_user set money = money + ? where id = ?";
        int row = getJdbcTemplate().update(sql,new Object[]{money,toUserId});
        if(row > 0){
            return true;
        }
        return false;
    }
}
