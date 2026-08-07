package com.jh.injection;

import java.util.*;

public class TeacherService {
    private TeacherDao dao;
    private String name;
    private int age;
    private String[] addrs;
    private Set<String> set;
    private Set<Teacher> teachers;
    private List<String> list;
    private Map<String, Double> map;
    private Properties properties;

    public TeacherDao getDao()   {
        return dao;
    }

    public void setDao(TeacherDao dao) {
        this.dao = dao;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("执行了setName方法");
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String[] getAddrs() {
        return addrs;
    }

    public void setAddrs(String[] addrs) {
        this.addrs = addrs;
    }

    public Set<String> getSet() {
        return set;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public Map<String, Double> getMap() {
        return map;
    }

    public void setMap(Map<String, Double> map) {
        this.map = map;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public Set<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<Teacher> teachers) {
        this.teachers = teachers;
    }

    @Override
    public String toString() {
        return "TeacherService{" +
                "dao=" + dao +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", addrs=" + Arrays.toString(addrs) +
                ", set=" + set +
                ", teachers=" + teachers +
                ", list=" + list +
                ", map=" + map +
                ", properties=" + properties +
                '}';
    }
}
