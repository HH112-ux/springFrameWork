package com.jh.user;

public class UserDaoJdbcImpl implements UserDao{
    @Override
    public void save() {
        System.out.println("使用JDBC技术实现");
    }
}
