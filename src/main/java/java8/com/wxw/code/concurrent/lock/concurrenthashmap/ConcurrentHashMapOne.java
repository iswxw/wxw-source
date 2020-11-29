package java8.com.wxw.code.concurrent.lock.concurrenthashmap;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;

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
