package com.jh.task1;

import java.util.List;

public class BathManager {
    private List<Student> students;

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void check() {
        System.out.println("========== 浴池检查结果 ==========");
        for (Student student : students) {
            if ("男".equals(student.getGender())) {
                System.out.println(student.getName() + " 是男生，可以进入浴池洗浴");
            } else {
                System.out.println(student.getName() + " 是女生，不能进入浴池");
            }
        }
    }
}
