package com.jh.task3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("task3.xml");
        ScoreManager manager = (ScoreManager) ctx.getBean("scoreManager");

        System.out.println("========== 成绩统计 ==========");
        // 1. 打印原始成绩
        manager.printScores();
        // 2. 统计总成绩
        manager.printTotal();
        // 3. 提升不及格成绩10%
        manager.increaseFailingScores();
        // 4. 打印提升后成绩
        manager.printScores();
        // 5. 统计提升后平均成绩
        manager.printAverage();
    }
}
