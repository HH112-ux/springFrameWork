package com.jh.task2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 任务2：AOP环绕通知完成疫情出行校验
 */
public class Test {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("task2.xml");
        TravelService service = ctx.getBean(TravelService.class);

        System.out.println("========== 场景1：正常出行 ==========");
        service.travel(new User("张三", "北京", "成都"));

        System.out.println();

        System.out.println("========== 场景2：出发地为高风险 ==========");
        service.travel(new User("李四", "上海", "北京"));

        System.out.println();

        System.out.println("========== 场景3：目的地为高风险 ==========");
        service.travel(new User("王五", "北京", "广东"));

        System.out.println();

        System.out.println("========== 场景4：出发地和目的地均为高风险 ==========");
        service.travel(new User("赵六", "上海", "广东"));
    }
}
