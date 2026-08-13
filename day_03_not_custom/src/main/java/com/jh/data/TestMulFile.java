package com.jh.data;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMulFile {
    public static void main(String[] args) {
        ApplicationContext context=new
                ClassPathXmlApplicationContext("applicationContext_main.xml");
        UserService service=context.getBean(UserService.class);
        service.saveUser();

    }
}
