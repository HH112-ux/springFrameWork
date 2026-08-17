package com.jh.aop.impl;

import com.jh.aop.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public void save() {
        System.out.println("主业务逻辑:增加用户管理");
    }

    @Override
    public void delete() {
        System.out.println("主业务逻辑:删除用户管理");
    }
}
