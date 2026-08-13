package com.jh.task2;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * 任务2：使用Druid获得数据库连接
 */
public class Test {
    public static void main(String[] args) {
        /*
        ResourceBundle bundle = ResourceBundle.getBundle("db");
        String driver = bundle.getString("jdbc.driver");
        String url = bundle.getString("jdbc.url");
        String username = bundle.getString("jdbc.username");
        String password = bundle.getString("jdbc.password");
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);*/
        ApplicationContext ctx = new ClassPathXmlApplicationContext("task.xml");
        DruidDataSource dataSource = (DruidDataSource) ctx.getBean("dataSource");
        // 获取数据库连接
        try {
            Connection conn = dataSource.getConnection();
            System.out.println("Druid获取数据库连接成功！");
            System.out.println("连接对象：" + conn);
            System.out.println("连接类：" + conn.getClass().getName());
            conn.close();
        } catch (SQLException e) {
            System.out.println("获取数据库连接失败：" + e.getMessage());
            e.printStackTrace();
        } finally {
            dataSource.close();
        }
    }
}
