package com.jh.factoryBean;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class XMLOperator {
    public static Document getDoc() {
        SAXReader reader = new SAXReader();
        try {
            Document doc = reader.read(XMLOperator.class.getClassLoader().
                    getResourceAsStream("factoryBean.xml"));
            return doc;
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static Bean getBeanObj(){
        Document document=getDoc();
        Element root=document.getRootElement();
        Element beanElement=root.element("bean");
        Bean bean=new Bean();
        bean.setId(beanElement.attributeValue("id"));
        bean.setClazz(beanElement.attributeValue("class"));
        return bean;
    }
}
