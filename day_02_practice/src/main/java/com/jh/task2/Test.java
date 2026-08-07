package com.jh.task2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("task2.xml");
        LibraryManager manager = (LibraryManager) ctx.getBean("libraryManager");
        manager.lendBooks();
    }
}
