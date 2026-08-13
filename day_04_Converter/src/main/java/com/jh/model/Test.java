package com.jh.model;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("bean.xml");
       // Person bean = context.getBean(Person.class);
        Student student=context.getBean(Student.class);
        System.out.println(student);
    }
}
