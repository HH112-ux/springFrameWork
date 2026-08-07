package com.jh.task3;

import java.util.Map;

public class ScoreManager {
    private Student student;

    public void setStudent(Student student) {
        this.student = student;
    }

    /**
     * 统计总成绩并打印
     * */
    public void printTotal() {
        double total = 0;
        for (Double score : student.getScores().values()) {
            total += score;
        }
        System.out.println(student.getName() + " 的总成绩：" + total);
    }

    /**
     * 将所有不及格成绩提升10%
     * */
    public void increaseFailingScores() {
        System.out.println("提升不及格成绩10%：");
        for (Map.Entry<String, Double> entry : student.getScores().entrySet()) {
            if (entry.getValue() < 60) {
                double oldScore = entry.getValue();
                double newScore = oldScore * 1.1;
                entry.setValue(newScore);
                System.out.println("  " + entry.getKey() + "：" + oldScore + " -> "
                        + String.format("%.1f", newScore));
            }
        }
    }

    /**
     * 统计平均成绩并打印
     * */
    public void printAverage() {
        double total = 0;
        for (Double score : student.getScores().values()) {
            total += score;
        }
        double average = total / student.getScores().size();
        System.out.println(student.getName() + " 提升后的平均成绩："
                + String.format("%.2f", average));
    }
    /**
     * 打印所有成绩明细
     * */
    public void printScores() {
        System.out.println(student.getName() + " 的各科成绩：");
        for (Map.Entry<String, Double> entry : student.getScores().entrySet()) {
            System.out.println("  " + entry.getKey() + "：" + String.format("%.1f", entry.getValue()));
        }
    }
}
