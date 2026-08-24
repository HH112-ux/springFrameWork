package com.jh.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * 充值及消费记录表实体
 */
@Data
@Accessors(chain = true)
public class Records {
    private Integer id;
    private String account;
    private LocalDateTime updateTime;
    private String category;   // 充值|消费
    private Integer num;
}
