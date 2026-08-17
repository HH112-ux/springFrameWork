package com.jh.task2;

/**
 * 用户实体类
 */
public class User {
    private String name;
    private String from;    // 出发地
    private String to;      // 目的地

    public User() {
    }

    public User(String name, String from, String to) {
        this.name = name;
        this.from = from;
        this.to = to;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
}
