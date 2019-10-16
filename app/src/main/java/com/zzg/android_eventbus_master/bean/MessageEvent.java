package com.zzg.android_eventbus_master.bean;

/**
 * @author Zhangzhenguo
 * @create 2019/10/15
 * @Email 18311371235@163.com
 * @Describe
 */
public class MessageEvent {
    private String name;
    private int age;

    public MessageEvent(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
