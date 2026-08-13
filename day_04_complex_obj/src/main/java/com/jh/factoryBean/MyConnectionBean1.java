package com.jh.factoryBean;

import org.springframework.beans.factory.FactoryBean;

public class MyConnectionBean1 implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        return null;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
