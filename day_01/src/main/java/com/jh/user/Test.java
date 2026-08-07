package com.jh.user;

public class Test {
    public static void main(String[] args) {
        UserService service=new UserServiceImpl();
        service.save();
       /* Boy boy= (Boy) XmlBeanFactory.getBean("D:\\idea_workspace\\springFramework\\day_01\\src\\main\\resources\\bean.xml",
                "boy");
    *//*    boy.setName("张三");
        boy.setAge(20);*//*
        System.out.println(boy);*/
    }
}
