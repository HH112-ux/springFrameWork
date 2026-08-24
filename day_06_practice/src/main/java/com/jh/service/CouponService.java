package com.jh.service;

public interface CouponService {
    /** 充值点券 */
    void recharge(String account, int num);

    /** 消费点券 */
    void consume(String account, int num);
}
