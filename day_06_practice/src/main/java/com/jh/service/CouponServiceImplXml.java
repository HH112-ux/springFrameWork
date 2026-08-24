package com.jh.service;

import com.jh.entity.Acc;
import com.jh.entity.Records;
import com.jh.mapper.AccMapper;
import com.jh.mapper.RecordsMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * 任务6：XML配置方式整合Spring事务
 * 不使用@Transactional注解，事务由XML中的tx:advice + aop:config统一管理
 * 1. 充值500点券，网络延迟超过5秒 -> 事务回滚
 * 2. 消费300点券，正常提交 -> 记录到records表，更新acc的coupon
 */
@Service("couponServiceXml")
public class CouponServiceImplXml implements CouponService {
    @Resource
    private AccMapper accMapper;
    @Resource
    private RecordsMapper recordsMapper;

    /**
     * 充值点券
     * XML中配置timeout=5，模拟网络延迟6秒，超过5秒超时，事务回滚
     */
    @Override
    public void recharge(String account, int num) {
        System.out.println("【XML方式】开始充值" + num + "点券...");

        // 插入充值记录
        Records record = new Records();
        record.setAccount(account)
              .setUpdateTime(LocalDateTime.now())
              .setCategory("充值")
              .setNum(num);
        recordsMapper.insert(record);
        System.out.println("充值记录已插入records表");

        // 模拟网络延迟（超过5秒timeout，事务回滚）
        try {
            System.out.println("网络延迟中...");
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 更新用户点券（由于事务超时回滚，这步不会生效）
        Acc acc = new Acc();
        acc.setAccount(account).setCoupon(num);
        accMapper.updateCoupon(acc);
        System.out.println("用户点券已更新（但事务会回滚）");
    }

    /**
     * 消费点券 - 正常提交
     * 记录到records表，并更新acc的coupon
     */
    @Override
    public void consume(String account, int num) {
        System.out.println("【XML方式】开始消费" + num + "点券...");

        // 插入消费记录
        Records record = new Records();
        record.setAccount(account)
              .setUpdateTime(LocalDateTime.now())
              .setCategory("消费")
              .setNum(num);
        recordsMapper.insert(record);
        System.out.println("消费记录已插入records表");

        // 更新用户点券（扣减）
        Acc acc = new Acc();
        acc.setAccount(account).setCoupon(-num);
        accMapper.updateCoupon(acc);
        System.out.println("用户点券已扣减");

        // 查询消费后的用户信息
        Acc dbAcc = accMapper.findByAccount(account);
        System.out.println("消费后用户信息：" + dbAcc);
    }
}
