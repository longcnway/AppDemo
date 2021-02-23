package com.demo.model;

import java.io.Serializable;

/**
 * Intent传递对象，方式一，实现serializable接口，序列化
 * 序列化就是将一个对象转换成可存储或可传输的状态
 */
public class Person implements Serializable {
    private String name;
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
