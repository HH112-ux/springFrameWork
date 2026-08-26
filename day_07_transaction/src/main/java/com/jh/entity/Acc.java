package com.jh.entity;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Acc {
    private int id;
    private String accno;
    private String name;
    private int money;
}
