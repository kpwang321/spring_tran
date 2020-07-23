package cn.itcast.proxy;

/**
 * @author kpwang
 * @create 2020-07-22 20:39
 */
public class Product implements IProduct {
    //销售
    public void saleProduct(Float money){
        System.out.println("销售产品：并拿到钱："+money);
    }
    //售后
    public void afterService(float money){
        System.out.println("提供售后服务，并拿到钱："+money);
    }
}
