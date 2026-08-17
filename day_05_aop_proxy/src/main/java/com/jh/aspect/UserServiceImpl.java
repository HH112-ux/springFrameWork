package com.jh.aspect;

import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService{
    @Override
    public boolean login(String name, String pwd) {
        if (name.equals("scott") && pwd.equals("tiger"))
            return true;
        return false;
    }
}
