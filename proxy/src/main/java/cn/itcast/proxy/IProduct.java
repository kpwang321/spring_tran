package cn.itcast.proxy;

/**
 * @author kpwang
 * @create 2020-07-22 20:38
 */
public interface IProduct {

    //销售
    void saleProduct(Float money);

    //售后
    void afterService(float money);
}
