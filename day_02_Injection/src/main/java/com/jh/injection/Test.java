package com.jh.injection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        TeacherService service=context.getBean("teacherService1",TeacherService.class);// (TeacherService) context.getBean("teacherService");
        System.out.println(service);
        //null值   "null"
        System.out.println(service.getName().equals(""));
       /* String[] addrs = service.getAddrs();
        for (String addr : addrs) {
            System.out.println("addr = " + addr);
        }*/
        //Set<String> set = service.getSet();
        //set.forEach(System.out::println);
      /*  Set<Teacher> teachers=service.getTeachers();
        teachers.forEach(System.out::println);*/
/*        List<String> list=service.getList();
        list.forEach(System.out::println);*/
      /*  Map<String,Double> map=service.getMap();
        Set<String> keys=map.keySet();
        for(String key:keys)
            System.out.println(key+"\t"+map.get(key));*/
       /* Properties properties = service.getProperties();
        String aaa = properties.getProperty("aaa");
        System.out.println(aaa);*/
        //TeacherDao dao = service.getDao();
       // System.out.println(dao);
    }
}
