package com.jh.test;

import com.jh.entity.Acc;
import com.jh.service.AccService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * 任务2-3：Spring整合MyBatis完成数据增加、显示和登录
 */
public class TestBasic {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("bean_basic.xml");
        AccService service = ctx.getBean(AccService.class);

        // 任务2：增加数据
        System.out.println("========== 增加帐户 ==========");
        Acc acc = new Acc();
        acc.setAccount("lisi").setPassword("654321").setCoupon(500);
        service.addAcc(acc);

        // 显示所有帐户
        System.out.println("========== 显示所有帐户 ==========");
        List<Acc> list = service.selectList();
        list.forEach(System.out::println);

        // 任务3：登录处理
        System.out.println("\n========== 登录测试 ==========");
        System.out.println("--- 正确密码登录 ---");
        service.login("zhangsan", "123456");

        System.out.println("--- 错误密码登录 ---");
        service.login("zhangsan", "wrong");
    }
}
