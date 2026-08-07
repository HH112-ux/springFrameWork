package com.jh.injection;

public class Boy {
    private String name;

    private Girl girl;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Girl getGirl() {
        return girl;
    }

    public void setGirl(Girl girl) {
        this.girl = girl;
    }
    public void findGF(){
        System.out.println(name+"找到女朋友：");
        System.out.println(girl);
    }
}
