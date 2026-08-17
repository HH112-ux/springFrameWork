package com.jh.task1;

import java.lang.reflect.Proxy;

/**
 * 任务1：动态代理
 * 使用一个代理对象，实现对普通售货员和普通服务员的代理
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("========== 动态代理：售货员 ==========");

        Salesperson salesperson = new CommonSalesperson();
        Salesperson salesProxy = (Salesperson) Proxy.newProxyInstance(
                salesperson.getClass().getClassLoader(),
                salesperson.getClass().getInterfaces(),
                new ServiceInvocationHandler(salesperson));

        System.out.println("--- 挑选商品 ---");
        salesProxy.select();
        System.out.println("--- 扫码支付 ---");
        salesProxy.pay();

        System.out.println();

        System.out.println("========== 动态代理：服务员 ==========");
        WaiterService waiter = new CommonWaiter();
        WaiterService waiterProxy = (WaiterService) Proxy.newProxyInstance(
                waiter.getClass().getClassLoader(),
                waiter.getClass().getInterfaces(),
                new ServiceInvocationHandler(waiter));

        System.out.println("--- 点餐 ---");
        waiterProxy.order();
        System.out.println("--- 扫码支付 ---");
        waiterProxy.pay();
    }
}
