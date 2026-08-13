package com.jh.anno;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("bean_annotation.xml");
        //Teacher teacher= (Teacher) context.getBean("teacher");
       // System.out.println(teacher);
        Student student=context.getBean(Student.class);
        System.out.println(student);
    }
}
