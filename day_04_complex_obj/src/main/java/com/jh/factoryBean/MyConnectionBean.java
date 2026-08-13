package com.jh.factoryBean;

import org.springframework.beans.factory.FactoryBean;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyConnectionBean implements FactoryBean<Connection> {
    private String driver;
    private String url;
    private String user;
    private String password;

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public Connection getObject() throws Exception {
        Class.forName(driver);
        Connection connection= DriverManager.getConnection(url,user,password);
        return connection;
    }

    @Override
    public Class<?> getObjectType() {
        return Connection.class;
    }

    /**
     * 通过FactoryBean提供创建的对象，是否是单例模式
     * @return
     */
    @Override
    public boolean isSingleton() {
        return true;
    }
}
