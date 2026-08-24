package com.jh.service;

import com.jh.entity.Acc;
import com.jh.mapper.AccMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AccServiceImpl implements AccService {
    @Resource
    private AccMapper accMapper;

    @Override
    public void addAcc(Acc acc) {
        accMapper.insert(acc);
    }

    @Override
    public List<Acc> selectList() {
        return accMapper.selectList();
    }

    @Override
    public Acc login(String account, String password) {
        Acc acc = accMapper.findByAccount(account);
        if (acc != null && acc.getPassword().equals(password)) {
            System.out.println("登录成功：" + acc);
            return acc;
        }
        System.out.println("登录失败：账号或密码错误");
        return null;
    }
}
