package com.jh.service;

import com.jh.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAll();
    Student findById(Integer id);
    void save(Student student);
    void update(Student student);
    void delete(Integer id);
}
