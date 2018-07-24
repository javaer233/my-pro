package com.fy.bean;

/**
 * @Author kai
 * @Description 注入抽象类如何运行？
 * @Create 2018-05-10 14:46
 **/
public abstract class Someone {
    public String name;
    public abstract void sing();
    public void speak(){
        System.out.println("hello?");
    }
}
