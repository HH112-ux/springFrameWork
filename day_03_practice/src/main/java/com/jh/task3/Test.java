package com.jh.task3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 任务3：使用JDBC + Druid + Spring注解，完成球队的实际数据库操作
 */
public class Test {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("task3.xml");
        TeamService service = ctx.getBean(TeamService.class);

        System.out.println("========== 初始化数据库表 ==========");
        service.initTable();

        System.out.println("\n========== 增加球队 ==========");
        service.addTeam(new Team("湖人队", "洛杉矶"));
        service.addTeam(new Team("公牛队", "芝加哥"));
        service.addTeam(new Team("勇士队", "旧金山"));

        System.out.println("\n========== 查询所有球队 ==========");
        service.listAllTeams();

        System.out.println("\n========== 删除球队：公牛队 ==========");
        service.deleteTeam("公牛队");

        System.out.println("\n========== 再次查询所有球队 ==========");
        service.listAllTeams();
    }
}
