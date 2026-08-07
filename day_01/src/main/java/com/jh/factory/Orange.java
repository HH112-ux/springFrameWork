package com.jh.factory;

public class Orange implements Fruit{
    @Override
    public void plant() {
        System.out.println("橘子种植");
    }

    @Override
    public void grow() {
        System.out.println("橘子生长");
    }

    @Override
    public void harvest() {
        System.out.println("橘子收藏");
    }
}
