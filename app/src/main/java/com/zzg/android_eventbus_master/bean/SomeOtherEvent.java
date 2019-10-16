package com.zzg.android_eventbus_master.bean;

/**
 * @author Zhangzhenguo
 * @create 2019/10/15
 * @Email 18311371235@163.com
 * @Describe
 */
public class SomeOtherEvent {
    private String msg;

    public SomeOtherEvent(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
