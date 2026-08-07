package com.jh.reflection;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.lang.reflect.Method;
import java.util.List;

/**
 * 任务1：通过xml文件配置方式为属性赋值，使用Java反射机制创建对象，
 *       并使用Method调用类的setXXX方法为属性赋值
 */
public class Test {
    public static void main(String[] args) {
        Object obj = getBean("teacher.xml", "teacher");
        System.out.println(obj);
    }

    public static Object getBean(String fileName, String key) {
        SAXReader reader = new SAXReader();
        try {
            Document doc = reader.read(Test.class.getClassLoader().getResourceAsStream(fileName));
            Element root = doc.getRootElement();
            List<Element> beans = root.elements("bean");

            for (Element bean : beans) {
                if (key.equals(bean.attributeValue("id"))) {
                    String clazz = bean.attributeValue("class");
                    Class<?> aClass = Class.forName(clazz);
                    Object obj = aClass.getConstructor().newInstance();

                    List<Element> properties = bean.elements("property");
                    for (Element property : properties) {
                        String propertyName = property.attributeValue("name");
                        String value = property.attributeValue("value");

                        String setMethodName = "set" + propertyName.substring(0, 1).toUpperCase()
                                + propertyName.substring(1);

                        Method setMethod = aClass.getMethod(setMethodName, String.class);

                        setMethod.invoke(obj, value);
                    }
                    return obj;
                }
            }
        } catch (DocumentException | ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
