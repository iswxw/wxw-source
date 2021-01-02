package com.wxw.wxw.code.study.base;

/**
 * @ Author ：com.wxw.wxw.
 * @ Date ： 17:15 2020/8/24
 * @ Description：基础 反射测试
 * @ Version:   v_0.0.1
 */
public class ReflectClass {
    public static void main(String[] args) {
        try {
            Class<?> forName = Class.forName("com.wxw.wxw.code.study.base.ReflectClass");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
