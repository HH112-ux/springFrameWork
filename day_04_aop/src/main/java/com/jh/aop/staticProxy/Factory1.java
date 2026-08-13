package com.jh.aop.staticProxy;

public class Factory1 implements Platform{
    @Override
    public void product() {
        System.out.println("生产口红产品");
    }
}
