package cn.itcast.service;

import cn.itcast.domain.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * @author kpwang
 * @create 2020-07-22 17:36
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application.xml")
public class IAccountServiceTest {
    @Autowired
    @Qualifier(value = "accountServiceProxy")//注入代理对象，哥哥，不然一辈子不回滚
    private IAccountService accountService;
    @Test
    public void transter() throws IOException {
        accountService.transter("aaa","bbb",50f);
    }
}