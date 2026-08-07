package com.jh.task1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("task1.xml");
        BathManager manager = (BathManager) ctx.getBean("bathManager");
        manager.check();
    }
}
