package com.jh.task2;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * 疫情出行校验切面（环绕通知）
 */
@Component
@Aspect
public class TravelCheckAspect {

    @Value("${risk.areas}")
    private String riskAreasStr;

    /**
     * 环绕通知：对travel方法进行拦截
     * 1. 出发地为高风险 -> 不允许出行
     * 2. 目的地为高风险 -> 生成日志，记录用户信息
     */
    @Around(value = "execution(* com.jh.task2.TravelService.travel(..))")
    public Object checkRisk(ProceedingJoinPoint point) {
        Object[] args = point.getArgs();
        if (args == null || args.length == 0 || !(args[0] instanceof User)) {
            try {
                return point.proceed();
            } catch (Throwable e) {
                e.printStackTrace();
                return null;
            }
        }

        User user = (User) args[0];

        // 解析高风险区域（去空格）
        List<String> riskAreas = new ArrayList<>();
        for (String area : riskAreasStr.split(",")) {
            riskAreas.add(area.trim());
        }

        // 检查出发地
        if (riskAreas.contains(user.getFrom())) {
            System.out.println("【拦截】" + user.getName() + "，您的出发地" + user.getFrom()
                    + "为疫情高风险区域，不允许出行！");
            return null;  // 不执行目标方法
        }

        // 检查目的地
        if (riskAreas.contains(user.getTo())) {
            System.out.println("【警告】" + user.getName() + "，您的目的地" + user.getTo()
                    + "为疫情高风险区域，正在生成日志...");
            generateLog(user);
        }

        // 执行目标方法
        try {
            return point.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 生成日志系统，记录用户姓名、出发地、目的地及出发时间
     */
    private void generateLog(User user) {
        String logFile = "travel_risk_log.txt";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(logFile, true))) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String time = LocalDateTime.now().format(formatter);
            bw.write("========== 高风险出行日志 ==========");
            bw.newLine();
            bw.write("用户姓名：" + user.getName());
            bw.newLine();
            bw.write("出发地：" + user.getFrom());
            bw.newLine();
            bw.write("目的地（高风险）：" + user.getTo());
            bw.newLine();
            bw.write("出发时间：" + time);
            bw.newLine();
            bw.write("==================================");
            bw.newLine();
            System.out.println("【日志系统】日志已生成至 " + logFile);
        } catch (IOException e) {
            System.out.println("【日志系统】日志生成失败：" + e.getMessage());
            e.printStackTrace();
        }
    }
}
