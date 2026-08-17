package com.jh.cglib;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.time.LocalDate;

public class MyInterceptor implements MethodInterceptor {
    private Object obj;

    public MyInterceptor(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("进入系统");
        Object invoke = method.invoke(obj, objects);
        System.out.println(LocalDate.now());
        return invoke;
    }
}
