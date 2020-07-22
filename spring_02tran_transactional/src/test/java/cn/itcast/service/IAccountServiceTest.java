package cn.itcast.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * @author kpwang
 * @create 2020-07-22 20:00
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application.xml")
public class IAccountServiceTest {

    @Autowired
    private IAccountService accountService;
    @Test
    public void transter(){
        try {
            accountService.transter("aaa","bbb",30f);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}