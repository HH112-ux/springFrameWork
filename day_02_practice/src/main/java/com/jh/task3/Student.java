package com.jh.task3;

import java.util.Map;

public class Student {
    private String name;
    private Map<String, Double> scores;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Double> getScores() {
        return scores;
    }

    public void setScores(Map<String, Double> scores) {
        this.scores = scores;
    }
}
