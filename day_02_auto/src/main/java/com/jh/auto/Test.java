package com.jh.auto;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("bean_auto.xml");
        Student student=context.getBean(Student.class);
        System.out.println(student);
    }
}
