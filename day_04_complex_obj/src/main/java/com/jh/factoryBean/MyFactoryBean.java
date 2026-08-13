package com.jh.factoryBean;

import org.springframework.lang.Nullable;

public interface MyFactoryBean<T> {
    @Nullable
    T getObject() throws Exception;

    @Nullable
    Class<?> getObjectType();

    default boolean isSingleton() {
        return true;
    }
}
