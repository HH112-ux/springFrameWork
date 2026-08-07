package com.jh.injection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSimpleProperty {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("bean1.xml");
        Boy boy= (Boy) context.getBean("/boy4");
        boy.findGF();
    }
}
