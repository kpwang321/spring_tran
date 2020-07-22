package cn.itcast.dao.impl;

import cn.itcast.dao.IAccountDao;
import cn.itcast.domain.Account;
import cn.itcast.domain.AccountRowMapper;
import cn.itcast.util.ConnectionUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author kpwang
 * @create 2020-07-22 16:52
 */

public class AccountDaoImpl extends JdbcDaoSupport implements IAccountDao {
    public void updateAccount(Account account) {
        this.getJdbcTemplate().update("update account set name=? , money=? where id=?",account.getName(),account.getMoney(),account.getId());
    }

    public List<Account> findAccountByName(Serializable accountName) {
        List<Account> list = getJdbcTemplate().query("select * from account where name=?", new AccountRowMapper(),accountName);
        System.out.println(list);
        return list;
    }
}
