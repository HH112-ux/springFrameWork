package com.jh.spring;

public class StudentDaoJdbcImpl implements StudentDao {
    @Override
    public void save(Student student) {
        System.out.println("使用JDBC技术保存学生：" + student);
    }
}
