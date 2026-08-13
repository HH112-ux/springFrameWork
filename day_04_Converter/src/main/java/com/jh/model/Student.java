package com.jh.model;

import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
public class Student {
    private String name;
    private LocalDate birth;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", birth=" + birth.format(DateTimeFormatter.ofPattern("yyyy年MM月dd日")) +
                '}';
    }
}
