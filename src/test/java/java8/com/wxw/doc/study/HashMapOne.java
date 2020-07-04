package com.wxw.doc.study;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: wxw
 * @create: 2020-04-21-16:16
 */
public class HashMapOne {
    public static void main(String[] args) {
        //HashMap<String, String> map = new HashMap<>(13);
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        map.put("1", "A");
        System.out.println(map.put("1", "B"));
        System.out.println(map);
        System.out.println(map.get("1"));
    }

}
