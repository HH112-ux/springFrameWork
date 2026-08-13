package com.jh.task2;

/**
 * 任务2：静态代理模式
 * 孙悟空根据高翠兰的样貌，变成高翠兰，可以和猪八戒战斗，可以抓住猪八戒
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("========== 静态代理：孙悟空代理高翠兰 ==========");

        // 创建被代理对象（高翠兰本人）
        GaoCuiLan gaoCuiLan = new RealGaoCuiLan();

        // 创建代理对象（孙悟空），传入被代理对象
        GaoCuiLan proxy = new SunWukongProxy(gaoCuiLan);

        System.out.println("--- 第一幕：与猪八戒战斗 ---");
        proxy.fight();

        System.out.println();

        System.out.println("--- 第二幕：抓住猪八戒 ---");
        proxy.catchPig();
    }
}
