package cn.itcast.dao;

import cn.itcast.domain.Account;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

/**
 * @author kpwang
 * @create 2020-07-07 20:11
 */
public interface IAccountDao {
    void updateAccount(Account account);


    List<Account> findAccountByName(Serializable accountName);
}
