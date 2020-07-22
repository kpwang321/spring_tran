package cn.itcast.service.impl;

import cn.itcast.dao.IAccountDao;
import cn.itcast.domain.Account;
import cn.itcast.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

/**
 * @author kpwang
 * @create 2020-07-07 20:09
 */
@Service("accountService")
public class AccountServiceImpl implements IAccountService {
    @Autowired
    private IAccountDao accountDao;

    @Transactional(rollbackFor = Exception.class)//默认只有运行时异常才会回滚
    public void transter(String sourceName, String targetName, Float money) throws IOException {
        System.out.println("transfer.......");
        //1根据名称查询转出账户
        Account source = accountDao.findAccountByName(sourceName).get(0);
        //2根据名称查询转入账号
        Account target = accountDao.findAccountByName(targetName).get(0);
        //3转出账户减钱
        if (source.getMoney() - money < 0) {
            throw new RuntimeException("账号余额不足");
        } else {
            source.setMoney(source.getMoney() - money);
        }
        //4转入账号加钱
        target.setMoney(target.getMoney() + money);
        //5更新转出账号
        accountDao.updateAccount(source);
        if (true){
            throw new IOException("ds");
        }


        System.out.println("--------------");
        //int i = 1 / 0;
        //6跟新转入账号
        accountDao.updateAccount(target);
    }
}
