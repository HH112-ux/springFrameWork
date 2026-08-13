package com.jh.anno;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

//@Component//组件
//@Repository  应用在持久层组件上   TeacherDao
//@Service     应用在业务逻辑组件上  TeacherService
//@Controller   //应用在控制层       TeacherController
@Component
public class Teacher {
    @Value("李老师")
    private String name;
    @Value("50")
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
