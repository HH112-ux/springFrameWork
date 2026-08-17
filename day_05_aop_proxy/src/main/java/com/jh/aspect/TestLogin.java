package com.jh.aspect;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestLogin {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("bean.xml");
        UserService service= (UserService) context.getBean("userServiceImpl");
        boolean b = service.login("scott", "tiger");
        System.out.println("主方法中查看返回值："+b);
    }
}
