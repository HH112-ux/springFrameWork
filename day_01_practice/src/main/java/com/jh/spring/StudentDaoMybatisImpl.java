package com.jh.spring;

public class StudentDaoMybatisImpl implements StudentDao {
    @Override
    public void save(Student student) {
        System.out.println("使用MyBatis技术保存学生：" + student);
    }
}
