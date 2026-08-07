package com.jh.user;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class XmlBeanFactory {
    public static Object getBean(String fileName,String key){
        SAXReader reader=new SAXReader();
        try {
            Document doc= reader.read(fileName);
            Element root=doc.getRootElement();//获取根元素
            List<Element> beans=root.elements("bean");//获取下面的所有bean元素
            for (Element bean : beans) {
                if (key.contentEquals(bean.attributeValue("id"))){
                    String clazz=bean.attributeValue("class");
                    Class<?> aClass = Class.forName(clazz);//加载类，获得字节码
                    List<Element> properties = bean.elements("property");//取下面所有属性配置
                    Object obj = aClass.getConstructor().newInstance();//构造对象
                    for (Element property:properties){
                        //获取属性名并给属性赋值
                        String propertyName=property.attributeValue("name");
                        Field field=aClass.getDeclaredField(propertyName);
                        field.setAccessible(true);
                        field.set(obj,property.attributeValue("value"));
                    }
                    return obj;
                }
            }
        } catch (DocumentException | ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return null;
    }


}
