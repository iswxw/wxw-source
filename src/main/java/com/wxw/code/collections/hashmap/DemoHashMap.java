package com.wxw.code.collections.hashmap;

import java.util.Collections;
import java.util.Map;

/**
 * @author: wxw
 * @date: 2021-02-11-15:16
 * @link:
 * @description:
 */
public class DemoHashMap {
    public static void main(String[] args) {
        final Map emptyMap = Collections.EMPTY_MAP;
        emptyMap.put("a","A" );
        System.out.println("emptyMap = " + emptyMap.get("a"));

    }
}
