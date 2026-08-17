package com.jh.aop;

import com.jh.aop.impl.AccountServiceImpl;
import com.jh.aop.impl.UserServiceImpl;
import com.jh.aop.proxy.MyInvocationHandler;
import com.jh.aop.proxy.ProxyUtil;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) {
        UserService service= new UserServiceImpl();
        UserService proxy = (UserService) ProxyUtil.getProxy(service,
                new MyInvocationHandler(service));
        proxy.save();
        System.out.println("------------------------------------");
        proxy.delete();

        /*AccountService service=new AccountServiceImpl();
        AccountService proxy= (AccountService) ProxyUtil.getProxy(service,
                new MyInvocationHandler(service));
        proxy.save();
        System.out.println("-----------------------------");
        proxy.pay();*/

    }
}
