package com.jh.user;

import java.lang.reflect.InvocationTargetException;
import java.util.ResourceBundle;

public class BeanFactory {
    public static Object getBean(String className) {
        ResourceBundle bundle=ResourceBundle.getBundle("bean");
        String userDao = bundle.getString(className);
        try {
            Class aClass = Class.forName(userDao);
            return (Object)aClass.getConstructor().newInstance();
        } catch (ClassNotFoundException | InstantiationException | InvocationTargetException | NoSuchMethodException |
                 IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
