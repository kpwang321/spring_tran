package cn.itcast.service;


import cn.itcast.domain.Account;

import java.io.IOException;
import java.util.List;

/**
 * @author kpwang
 * @create 2020-07-07 20:06
 */
public interface IAccountService {
    //转账   sourceName转出名称   targetName转入
    void transter(String sourceName, String targetName, Float money) throws IOException;
}
