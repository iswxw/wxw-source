package com.wxw.code.collections.concurrenthashmap;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: com.wxw.wxw
 * @create: 2020-04-24-11:03
 * @link: https://stor.51cto.com/art/202010/629683.htm
 */
public class DemoConcurrentHashMap {
    public static void main(String[] args) {
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("1", "A");
        concurrentHashMap.get("1");
    }
}
