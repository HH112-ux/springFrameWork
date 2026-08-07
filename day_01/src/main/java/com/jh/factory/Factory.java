package com.jh.factory;

public class Factory {
    public static Fruit getFruit(String type){
        if (type.equals("apple")){
            Apple apple=new Apple();
            return apple;
        }else {
            Orange orange=new Orange();
            return orange;
        }
    }
}
