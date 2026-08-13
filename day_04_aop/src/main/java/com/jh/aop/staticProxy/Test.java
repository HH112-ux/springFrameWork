package com.jh.aop.staticProxy;

public class Test {
    public static void main(String[] args) {
        Platform platform=new VBuss();//new Factory();
        platform.product();
    }
}
