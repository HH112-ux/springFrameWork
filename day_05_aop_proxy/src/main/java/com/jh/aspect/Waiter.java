package com.jh.aspect;

import org.springframework.stereotype.Component;

@Component
//<bean id="waiter" class="com.jh.aspect.Waiter"/>
public class Waiter {
    public void showMenu(){
        System.out.println("请点菜");
        //try {
        // int x = 10 / 0;
       // }catch(ArithmeticException e){
        //    System.out.println("除零错误");
        //}
    }
    public boolean pay(String acc){
        System.out.println("请付款");
        return true;
        //int x=10/0;
    }

    public User testUser(String acc){
        System.out.println("进入testUser方法");
        return new User("张三","123");
    }
}
