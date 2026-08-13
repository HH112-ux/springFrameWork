package com.jh.aop.staticProxy;

public class VBuss implements Platform{
    //private Factory factory;
    private Factory1 factory1;
    @Override
    public void product() {
        add_friend();
        share();
        if (factory1==null)
            factory1=new Factory1();
        factory1.product();
        send_goods();
    }
    public void add_friend(){
        System.out.println("加好友");
    }
    public void share(){
        System.out.println("发朋友圈");
    }
    public void send_goods(){
        System.out.println("送货");
    }
}
