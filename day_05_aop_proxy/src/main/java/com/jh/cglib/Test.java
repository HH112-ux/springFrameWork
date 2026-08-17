package com.jh.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.time.LocalDate;

public class Test {
    public static void main(String[] args) {
        AccountService service = new AccountService();
        // Proxy.newProxyInstance(classloder,interfaces,invocationhandler);
        Enhancer enhancer = new Enhancer();
        enhancer.setClassLoader(AccountService.class.getClassLoader());
        enhancer.setSuperclass(AccountService.class);
        //enhancer.setCallback(new MyInterceptor(service));
        //使用lambda表达式完成处理
        enhancer.setCallback((MethodInterceptor) (o, method, objects, methodProxy) -> {
            System.out.println("开始监控");
            Object invoke = method.invoke(service, objects);
            System.out.println("监控结束");
            System.out.println(LocalDate.now());
            return invoke;
        });

        AccountService accountService = (AccountService) enhancer.create();
        accountService.save();
        System.out.println("------------------------------");
        accountService.pay();

    }
}
