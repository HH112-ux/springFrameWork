package com.jh.factory;

public class Test {
    public static void main(String[] args) {
        Fruit fruit=Factory.getFruit("orange");//new Orange();
        fruit.plant();
        fruit.grow();
        fruit.harvest();
    }
}
