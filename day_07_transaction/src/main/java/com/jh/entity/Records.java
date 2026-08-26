package com.jh.entity;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Records {
    private int id;
    private String accno;
    private String category;
    private int money;
}
