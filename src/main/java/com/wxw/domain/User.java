package com.wxw.domain;


import lombok.ToString;

import java.io.*;

/**
 * @Method 外部序列化测试
 * @Date 2021/3/5
 * @Return 
 */
@ToString
public class User implements Externalizable {
   
    private String name;
    private transient Integer age;  // 屏蔽字段

 
    public User() {
        System.out.println("none constructor");
    }

    public User(String name, Integer age) {
        System.out.println("arg constructor");
        this.name = name;
        this.age = age;
    }

    // 实现读写
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeInt(age);
        // 屏蔽gender
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        age = in.readInt();
    }

    // 具体重写
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(name);
        out.writeInt(age);
        // 屏蔽gender
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = (String) in.readObject();
        age = in.readInt();
    }
}