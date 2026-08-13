package com.jh.aop.staticProxy;

public class Factory implements Platform{
    @Override
    public void product() {
        System.out.println("工厂生产面膜产品");
    }
}
