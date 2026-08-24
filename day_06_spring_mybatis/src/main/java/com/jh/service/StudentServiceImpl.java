package com.jh.service;

import com.jh.entity.Student;
import com.jh.mapper.StudentMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentMapper mapper;
    @Override
    public void save(Student student) {
        mapper.save(student);
    }

    @Override
    public List<Student> selectList() {
        return mapper.selectList();
    }
}
