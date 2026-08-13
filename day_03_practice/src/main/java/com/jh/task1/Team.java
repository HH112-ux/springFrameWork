package com.jh.task1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 球队实体类，通过注解注入属性
 */
@Component
public class Team {
    @Value("湖人队")
    private String name;
    @Value("洛杉矶")
    private String addr;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    @Override
    public String toString() {
        return "Team{name='" + name + '\'' + ", addr='" + addr + '\'' + '}';
    }
}
