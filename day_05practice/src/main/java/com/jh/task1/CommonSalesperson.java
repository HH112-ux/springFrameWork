package com.jh.task1;

/**
 * 普通售货员
 */
public class CommonSalesperson implements Salesperson {
    @Override
    public void select() {
        System.out.println("购买什么商品？");
    }

    @Override
    public void pay() {
        System.out.println("请扫码支付");
    }
}
