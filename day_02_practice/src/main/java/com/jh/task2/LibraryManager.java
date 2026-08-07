package com.jh.task2;

import java.util.List;

public class LibraryManager {
    private List<Student> students;

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void lendBooks() {
        System.out.println("========== 图书馆借书结果 ==========");
        for (Student student : students) {
            String book = getBook(student.getCardColor(), student.getCardType());
            System.out.println(student.getName() + " 持有" + student.getCardColor()
                    + student.getCardType() + "借书证，借到《" + book + "》");
        }
    }

    private String getBook(String color, String type) {
        if ("红色".equals(color) && "A类".equals(type)) {
            return "java基础图书";
        } else if ("红色".equals(color) && "B类".equals(type)) {
            return "html";
        } else if ("蓝色".equals(color) && "A类".equals(type)) {
            return "oracle数据库";
        } else {
            return "三国演义";
        }
    }
}
