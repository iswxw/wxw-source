package com.wxw.code.study.hashset;

import java.util.HashSet;

/**
 * @ Author ：com.wxw.
 * @ Date ： 16:24 2020/9/16
 * @ Description：Java高并发
 * @ Version:   v_0.0.1
 */
public class HashSet01 {
    public static void main(String[] args) {
        HashSet<String> hashSet = new HashSet<>();
        boolean add = hashSet.add("学习的苦");
        System.out.println("add = " + add);
    }
}
