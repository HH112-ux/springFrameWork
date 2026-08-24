package com.jh.test;

import com.jh.entity.Acc;
import com.jh.mapper.AccMapper;
import com.jh.mapper.RecordsMapper;
import com.jh.service.CouponService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * 任务5：注解方式整合Spring事务
 * 1. 充值500点券 -> 网络延迟超过5秒 -> 事务回滚
 * 2. 消费300点券 -> 正常提交 -> 记录到records表，更新acc的coupon
 */
public class TestAnnotation {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("bean_annotation.xml");
        CouponService service = ctx.getBean("couponServiceImpl", CouponService.class);
        AccMapper accMapper = ctx.getBean(AccMapper.class);
        RecordsMapper recordsMapper = ctx.getBean(RecordsMapper.class);

        // 打印初始状态
        System.out.println("========== 初始状态 ==========");
        printStatus(accMapper, recordsMapper);

        // 任务5-1：充值500点券（超时回滚）
        System.out.println("\n========== 充值500点券（超时回滚）==========");
        try {
            service.recharge("zhangsan", 500);
        } catch (Exception e) {
            System.out.println("充值事务已回滚：" + e.getMessage());
        }

        System.out.println("\n充值后状态（点券应不变，无充值记录）：");
        printStatus(accMapper, recordsMapper);

        // 任务5-2：消费300点券（正常提交）
        System.out.println("\n========== 消费300点券（正常提交）==========");
        service.consume("zhangsan", 300);

        System.out.println("\n消费后状态（点券减300，有消费记录）：");
        printStatus(accMapper, recordsMapper);
    }

    private static void printStatus(AccMapper accMapper, RecordsMapper recordsMapper) {
        System.out.println("--- 帐户信息 ---");
        List<Acc> accs = accMapper.selectList();
        accs.forEach(System.out::println);
        System.out.println("--- 记录信息 ---");
        List<com.jh.entity.Records> records = recordsMapper.selectList();
        records.forEach(System.out::println);
    }
}
