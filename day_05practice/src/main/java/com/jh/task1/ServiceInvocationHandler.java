package com.jh.task1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 动态代理处理器
 * 一个代理对象同时代理售货员和服务员
 */
public class ServiceInvocationHandler implements InvocationHandler {
    private Object target;

    public ServiceInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName();
        boolean isSalesperson = target instanceof Salesperson;
        boolean isWaiter = target instanceof WaiterService;

        // 前置增强：挑选方法（售货员）和点餐方法（服务员）
        if ("select".equals(methodName) || "order".equals(methodName)) {
            System.out.println("您好，欢迎光临");
        }

        // 执行目标方法
        Object result = method.invoke(target, args);

        // 后置增强：支付方法
        if ("pay".equals(methodName)) {
            if (isSalesperson) {
                System.out.println("慢走，欢迎再来");
            } else if (isWaiter) {
                System.out.println("请带好您的随身物品，慢走，欢迎再来");
            }
        }

        return result;
    }
}
