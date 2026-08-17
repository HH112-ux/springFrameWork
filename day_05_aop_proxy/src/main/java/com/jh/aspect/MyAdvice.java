package com.jh.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.weaver.patterns.ArgsAnnotationPointcut;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 通知(增强)
 */
@Component
@Aspect
public class MyAdvice {
    //切点的别名来使用
    @Pointcut(value = "execution(* com.jh.aspect.*.*(..))")
    private void MyPointcut(){}

    @Before(value = "MyPointcut()")
    //前置通知
    public void doBefore() {
        System.out.println("欢迎光临本餐厅");
        System.out.println("很高兴为您服务");
        System.out.println("_____________");
    }
    //最终通知 try finally
    //@After(value = "execution(* login(..))")
    @After(value = "MyPointcut()")
    public void doAfter() {
        System.out.println("请慢走，下次再来");
    }

    //后置通知
    @AfterReturning(value = "execution(* login(..))", returning = "result")
    public void log(JoinPoint point, Object result) {
        Object[] args = point.getArgs();
        String name = "";
        if (args != null) {
            name = (String) args[0];
        }
       /* System.out.println("原值:"+result);
        result="Fail";
        System.out.println("改后值："+result);
        //User user= (User) result;
       // user.setName("root");
        //System.out.println(result);
      result=false;
        System.out.println("方法返回值："+result);*/
        boolean b = (boolean) result;
        if (b) {
            System.out.println("正在生成日志...");
            try {
                //打印日志
                BufferedWriter bw=new BufferedWriter(new FileWriter("c:/log.log",true));
                bw.write("访问用户:"+name);
                bw.newLine();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                LocalDateTime dateTime=LocalDateTime.now();
                String time = formatter.format(dateTime);
                bw.write("访问时间:"+ time);
                bw.newLine();
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("日志生成成功！");
        }else{
            System.out.println("用户登录失败");
        }
        /*for (Object arg:args)
            System.out.println(arg);

        System.out.println(point.getSignature());
        System.out.println(point.getClass().getName());*/
    }

    @Around(value = "execution(* testUser(..))")
    public Object transaction(ProceedingJoinPoint point){
        System.out.println("开启事务");
        Object res=null;
        try {
            Object[] args = point.getArgs();
            String acc=null;
            if (args!=null){
                acc= (String) args[0];
            }
            if (acc.equals("12345")) {
                res = point.proceed();//调用目标方法
                User u=(User)res;
                u.setName("李四");
                System.out.println(res);
            } else
                System.out.println("帐户不存在");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("提交事务");
        return res;
    }
    @AfterThrowing(value = "execution(* showMenu(..))",throwing = "e")
    public void catchException(Exception e){
        System.out.println("出现了异常"+e.toString());
    }
}
