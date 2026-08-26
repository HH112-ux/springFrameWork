package com.jh.test;

import com.jh.service.AccService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.FileNotFoundException;

public class Test {
    public static void main(String[] args) throws FileNotFoundException {
        ApplicationContext context=new ClassPathXmlApplicationContext("bean.xml");
        AccService service= (AccService) context.getBean("accServiceImpl");
        service.doPay(2500);
    }
}
