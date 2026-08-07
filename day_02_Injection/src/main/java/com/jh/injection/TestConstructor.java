package com.jh.injection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestConstructor {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
        Student student=context.getBean(Student.class);
        System.out.println(student);
    }
}
