package com.jh.service;

import com.jh.entity.Acc;

import java.io.FileNotFoundException;
import java.util.List;

public interface AccService {
    void doPay(int money) throws FileNotFoundException;
    void delete(int id);
    List<Acc> selectList();
}
