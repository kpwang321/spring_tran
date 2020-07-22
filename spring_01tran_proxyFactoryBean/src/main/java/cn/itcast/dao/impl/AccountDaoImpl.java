package cn.itcast.dao.impl;

import cn.itcast.dao.IAccountDao;
import cn.itcast.domain.Account;
import cn.itcast.domain.AccountRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import java.io.Serializable;
import java.util.List;

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
