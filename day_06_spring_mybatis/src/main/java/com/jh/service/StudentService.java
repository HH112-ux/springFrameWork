package com.jh.service;

import com.jh.entity.Student;

import java.util.List;

public interface StudentService {
    void save(Student student);
    List<Student> selectList();
}
