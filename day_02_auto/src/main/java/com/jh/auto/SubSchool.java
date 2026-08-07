package com.jh.auto;

public class SubSchool implements School{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SubSchool{" +
                "name='" + name + '\'' +
                '}';
    }
}
