package com.jh.task1;

/**
 * 普通服务员
 */
public class CommonWaiter implements WaiterService {
    @Override
    public void order() {
        System.out.println("请看一下菜单");
    }

    @Override
    public void pay() {
        System.out.println("请扫码支付");
    }
}
