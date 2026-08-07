package com.jh.single;
//饿汉式单例模式
public class SingleTon {
    private SingleTon(){}
    private static SingleTon s=new SingleTon();
    public static SingleTon getInstance(){
        return s;
    }
}
//懒汉式单例模式
class SingleTon_A{
    private SingleTon_A(){}
    private static SingleTon_A s=null;
    public static SingleTon_A getInstance(){
        if (s==null)
            s=new SingleTon_A();
        return s;
    }
}
