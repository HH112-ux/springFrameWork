package com.jh.service;

import com.jh.entity.Student;
import com.jh.mapper.StudentMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentMapper studentMapper;

    @Override
    @Transactional(readOnly = true)
    public List<Student> findAll() {
        return studentMapper.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Student findById(Integer id) {
        return studentMapper.findById(id);
    }

    @Override
    public void save(Student student) {
        studentMapper.save(student);
    }

    @Override
    public void update(Student student) {
        studentMapper.update(student);
    }

    @Override
    public void delete(Integer id) {
        studentMapper.delete(id);
    }
}
