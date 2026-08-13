package com.jh.task1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 任务1：通过注解注入方式模拟球队管理
 */
public class Test {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("task.xml");

        // 获取通过注解创建的Team对象
        Team team = ctx.getBean(Team.class);
        System.out.println("Spring注解创建的球队对象：" + team);

        // 获取TeamService，DAO已通过@Autowired注入
        TeamService service = ctx.getBean(TeamService.class);

        System.out.println("========== 模拟增加球队 ==========");
        service.addTeam(team);

        System.out.println("========== 模拟删除球队 ==========");
        service.deleteTeam("湖人队");
    }
}
