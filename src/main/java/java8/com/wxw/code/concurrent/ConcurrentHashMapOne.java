package java8.com.wxw.code.concurrent;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: wxw
 * @create: 2020-04-24-11:03
 */
public class ConcurrentHashMapOne {
    public static void main(String[] args) {
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("1", "A");

    }
}
