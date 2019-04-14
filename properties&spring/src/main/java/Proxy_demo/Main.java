package Proxy_demo;

import net.sf.cglib.proxy.Enhancer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;


public class Main {
    public static void main(String[] args) {
        /**
         *动态代理 JDK方法（拦截有接口的方法）
         * */
/*        UserService userService = new UserServiceImpl();
        InvocationHandler invocationHandler = new UserInvocationHandler(userService);
        UserService userService1Proxy = (UserService) Proxy.newProxyInstance(userService.getClass().getClassLoader(),
                userService.getClass().getInterfaces(), invocationHandler);//获取代理实例
        userService1Proxy.callName("wang");
        //实现环绕通知*/

/**
 * 动态代理 Cglib方法（拦截没有接口的方法）
 * */
        CglibProxy proxy = new CglibProxy();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserServiceCglib.class);
        enhancer.setCallback(proxy);
        UserServiceCglib userServiceCglib = (UserServiceCglib) enhancer.create();
        userServiceCglib.callName("wang-cglib");
    }
}
