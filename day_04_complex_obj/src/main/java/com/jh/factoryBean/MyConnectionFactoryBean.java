package com.jh.factoryBean;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyConnectionFactoryBean implements MyFactoryBean<Connection> {
    @Override
    public Connection getObject() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/mybatis?serverTimezone=GMT%2B8&useSSL=false";
        String user="root";
        String password="root";
        Connection connection= DriverManager.getConnection(url,user,password);
        return connection;
    }

    @Override
    public Class<?> getObjectType() {
        return Connection.class;
    }
}
