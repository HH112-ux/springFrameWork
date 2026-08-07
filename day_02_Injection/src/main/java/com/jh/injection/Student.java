package com.jh.injection;

public class Student {
    private String name;
    private int age;
    private Teacher teacher;

    public Student() {
    }

    public Student(String name, int age, Teacher teacher) {
        this.name = name;
        this.age = age;
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                "}__Teacher{name='" + teacher.getName() + "',age=" + teacher.getAge() + "}";
    }
}
