package com.jh.factoryBean;

public class TestMyFactory {
    public static void main(String[] args) {
        Object factoryBean = Factory.getBean("&factoryBean");
        factoryBean=Factory.getBean("factoryBean");
        System.out.println(factoryBean);
    }
}
