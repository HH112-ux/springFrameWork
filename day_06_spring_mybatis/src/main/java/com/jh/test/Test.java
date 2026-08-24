package com.jh.test;

import com.jh.service.StudentService;
import com.jh.service.StudentServiceImpl;
import com.jh.entity.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("bean.xml");
        StudentService service=context.getBean(StudentServiceImpl.class);
        //测试增加
        Student student=new Student();
        student.setName("李某人").setAge(22).setGender("女");
        service.save(student);
        //测试显示
        List<Student> list=service.selectList();
        list.forEach(System.out::println);
    }
}
