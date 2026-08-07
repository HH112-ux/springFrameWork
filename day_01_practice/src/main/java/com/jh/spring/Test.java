package com.jh.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 任务2：通过Spring方式创建Student和StudentService对象，
 *       在容器中注入依赖关系，模拟完成保存操作
 */
public class Test {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("student.xml");

        Student student = (Student) ctx.getBean("student");
        System.out.println("Spring创建的Student对象：" + student);
        StudentService service = (StudentService) ctx.getBean("studentService");
        service.save(student);
    }
}
