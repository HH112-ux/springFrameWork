package com.jh.data;

public class UserService {
    private IUserDao dao;

    public IUserDao getDao() {
        return dao;
    }

    public void setDao(IUserDao dao) {
        this.dao = dao;
    }
    public void saveUser(){
        dao.save();
    }
}
