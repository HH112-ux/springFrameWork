package com.jh.spring;

public class StudentService {
    private StudentDao studentDao;

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public void save(Student student) {
        studentDao.save(student);
    }
}
