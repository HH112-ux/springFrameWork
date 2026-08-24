package com.jh.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * 帐户表实体
 */
@Data
@Accessors(chain = true)
public class Acc {
    private Integer id;
    private String account;
    private String password;
    private Integer coupon;
}
