package com.jh.task2;

import org.springframework.stereotype.Component;

/**
 * 用户出行服务（目标类）
 */
@Component
public class TravelService {

    /**
     * 出行方法
     */
    public void travel(User user) {
        System.out.println("您好，" + user.getName()
                + "，欢迎您乘坐从" + user.getFrom() + "到" + user.getTo() + "航班");
    }
}
