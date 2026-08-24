package com.jh.service;

import com.jh.entity.Acc;

import java.util.List;

public interface AccService {
    void addAcc(Acc acc);
    List<Acc> selectList();
    Acc login(String account, String password);
}
