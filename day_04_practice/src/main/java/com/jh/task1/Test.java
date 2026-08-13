package com.jh.task1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;

/**
 * 任务1：自定义类型转换器，将Double类型的工资转换为BigDecimal类型
 */
public class Test {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("task1.xml");
        Employee employee = ctx.getBean("employee", Employee.class);
        System.out.println("员工信息：" + employee);
        System.out.println("salary类型：" + employee.getSalary().getClass().getName());
    }
}
