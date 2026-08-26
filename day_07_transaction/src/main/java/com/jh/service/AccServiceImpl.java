package com.jh.service;

import com.jh.entity.Acc;
import com.jh.entity.Records;
import com.jh.mapper.AccMapper;
import com.jh.mapper.RecordsMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class AccServiceImpl implements AccService {
    @Resource
    private AccMapper accMapper;
    @Resource
    private RecordsMapper recordsMapper;

    /*@Transactional(
            propagation = Propagation.REQUIRED,
            isolation = Isolation.DEFAULT,
            timeout = 3,
            readOnly = false
           *//* rollbackFor = {
                    FileNotFoundException.class,
                    NullPointerException.class
            },
            noRollbackFor = {}*//*
    )*/
    @Override
    public void doPay(int money) throws FileNotFoundException {
        //存一条交易记录
        Records records = new Records();
        records.setAccno("123456").setCategory("支出").setMoney(money);
        recordsMapper.insert(records);
        System.out.println("执行交易记录处理");
        //模拟超时处理
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //运行时异常
       /* try {
            int i = 10 / 0;//算术异常(运行时异常)
        }catch(ArithmeticException e){}*/
        //检查型异常
       /* if (money > 2000)
            throw new FileNotFoundException("文件找不到异常");*/
        //修改用户原帐户下的余额
        Acc acc = new Acc();
        acc.setAccno("123456");
        acc.setMoney(money);
        accMapper.update(acc);
        System.out.println("执行用户余额修改处理");

    }

    @Override
    public void delete(int id) {
        accMapper.delete(id);
    }

    @Override
    public List<Acc> selectList() {
        return accMapper.selectList();
    }
}
