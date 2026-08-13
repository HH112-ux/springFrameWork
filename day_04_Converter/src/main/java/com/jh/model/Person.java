package com.jh.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Person {
    private String name;
    private int age;
    private LocalDate birthday;
}
