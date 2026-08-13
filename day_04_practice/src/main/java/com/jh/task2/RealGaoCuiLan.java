package com.jh.task2;

/**
 * 真实角色：高翠兰本人
 */
public class RealGaoCuiLan implements GaoCuiLan {
    @Override
    public void fight() {
        System.out.println("高翠兰与猪八戒战斗");
    }

    @Override
    public void catchPig() {
        System.out.println("高翠兰抓住猪八戒");
    }
}
