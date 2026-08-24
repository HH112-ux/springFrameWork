package com.jh.entity;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Student {
    private int id;
    private String name;
    private int age;
    private String gender;
}
