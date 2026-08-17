package com.jh.aop.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ProxyUtil {
    public static Object getProxy(Object target, InvocationHandler handler) {
       return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), handler);
    }
}
