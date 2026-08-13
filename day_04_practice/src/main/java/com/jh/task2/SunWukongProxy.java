package com.jh.task2;

/**
 * 代理角色：孙悟空
 * 根据高翠兰的样貌，变成高翠兰的样子，代理高翠兰完成战斗和抓猪八戒
 */
public class SunWukongProxy implements GaoCuiLan {
    // 持有被代理对象（高翠兰）的引用
    private GaoCuiLan gaoCuiLan;

    public SunWukongProxy(GaoCuiLan gaoCuiLan) {
        this.gaoCuiLan = gaoCuiLan;
    }

    @Override
    public void fight() {
        // 前置增强：孙悟空变成高翠兰的样子
        transform();
        // 调用目标方法
        gaoCuiLan.fight();
        // 后置增强：孙悟空收回变化
        recover();
    }

    @Override
    public void catchPig() {
        // 前置增强：孙悟空变成高翠兰的样子
        transform();
        // 调用目标方法
        gaoCuiLan.catchPig();
        // 后置增强：孙悟空收回变化
        recover();
    }

    /** 孙悟空根据高翠兰的样貌，变成高翠兰 */
    private void transform() {
        System.out.println("【孙悟空】使用七十二变，变成高翠兰的样貌");
    }

    /** 孙悟空收回变化，恢复真身 */
    private void recover() {
        System.out.println("【孙悟空】收回变化，恢复齐天大圣真身");
    }
}
