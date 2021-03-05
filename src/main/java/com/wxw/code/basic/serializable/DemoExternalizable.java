package com.wxw.code.basic.serializable;

import com.wxw.domain.User;

import java.io.*;

/**
 * @author ：wxw.
 * @date ： 16:03 2021/3/5
 * @description： 序列化 外部化
 * @link:
 * @version: v_0.0.1
 */
public class DemoExternalizable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        File file = new File("user.ser");

        ObjectOutputStream oOut = new ObjectOutputStream(new FileOutputStream(file));
        User user = new User("zhang", 18);
        oOut.writeObject(user);
        oOut.close();

        ObjectInputStream oin = new ObjectInputStream(new FileInputStream(file));
        Object newUser = oin.readObject();
        oin.close();

        System.out.println(newUser);
    }
}


