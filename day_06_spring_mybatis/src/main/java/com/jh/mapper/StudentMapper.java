package com.jh.mapper;

import com.jh.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentMapper {
    void save(Student student);
    List<Student> selectList();
}
