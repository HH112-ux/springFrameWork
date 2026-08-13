package com.jh.task3;

/**
 * 球队实体类
 */
public class Team {
    private Integer id;
    private String name;
    private String addr;

    public Team() {
    }

    public Team(String name, String addr) {
        this.name = name;
        this.addr = addr;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
        return "Team{id=" + id + ", name='" + name + '\'' + ", addr='" + addr + '\'' + '}';
    }
}
