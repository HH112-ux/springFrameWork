package com.jh.aspect;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAOP {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("bean.xml");
        Waiter waiter=context.getBean(Waiter.class);
        waiter.showMenu();
        //System.out.println("++++++++++++++++++++++++++");
        //boolean pay = waiter.pay("12345");
        //System.out.println(pay);

        //User user = waiter.testUser("12345");
        //System.out.println(user);

    }
}
