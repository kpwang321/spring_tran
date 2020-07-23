package cn.itcast.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author kpwang
 * @create 2020-07-22 20:41
 */
public class Client {
    public static void main(String[] args) {
        final Product product=new Product();
        /*
         * 动态代理：
         *    特点：字节码随用随创建，随用随加载
         *    作用：不修改源码的基础上对方法加强
         *    分类：
         *        基于接口的动态代理
         *        基于子类的动态代理
         *    基于接口的动态代理：
         *        涉及的类：Proxy
         *        提供者：JDK官方
         *     如何创建代理对象
         *         使用Proxy类中的newProxyInstance方法
         *     创建代理对象的要求
         *         被代理类最少实现一个接口，如果没有则不能使用
         *     newProxyInstance 方法的参数
         *         ClassLoader:类加载器
         *             它是用于加载代理对象字节码的，和被代理对象使用相同的类加载器
         *         Class[] :字节码数组
         *             它是用于让代理对象和被代理对象有相同的方法
         *         InvocationHandler:用于提供增强的代码
         *             让我们写如何代理。一般都是些该接口的实现类，通常情况下都是匿名内部类，但不是必须的
         *             此接口的实现类都是谁用谁写
         * */
        IProduct productProxy = (IProduct) Proxy.newProxyInstance(product.getClass().getClassLoader(),
                                 product.getClass().getInterfaces(),
                                 new InvocationHandler() {
                                     /**
                                      * @param proxy 代理对象的引用
                                      * @param method 当前执行的方法
                                      * @param args 当前执行方法所需要的参数
                                      * @return  和被代理对象方法有相同返回值
                                      * @throws Throwable
                                      */
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object returnValue=null;
                Float money= (Float) args[0];
                if ("saleProduct".equals(method.getName())){
                    returnValue = method.invoke(product, money * 0.8f);
                }

                return returnValue;
            }
        });
        productProxy.saleProduct(1000f);
    }
}
