package java8.com.wxw.code.study;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: wxw
 * @create: 2020-04-21-16:16
 * @ Description：HashMap 中 hash 冲突的解决方法及原理分析
 *  https://segmentfault.com/a/1190000023326247
 */
public class HashMap01 {

    final SecurityManager sm = System.getSecurityManager();

    public static void main(String[] args) {

        // hashmap 基本功能测试
        // HashMapTest01();

        // hashmap 扩容测试
        // testResize();

        // hashMap的computeIfAbsent()函数计算语法
        // testComputeIfAbsent();
    }

    // HashMap函数计算
    private static void testComputeIfAbsent() {
        // crete a HashMap and add some values
        HashMap<String, Integer> map = new HashMap<>();
        map.put("key1", 10000);
        map.put("key2", 20000);
        map.put("key3", 30000);
        map.put("key4", 40000);

        // print main.java.com.test.map details
        System.out.println("HashMap:" + map.toString());

        // provide value for new key which is absent
        // using computeIfAbsent method
        map.computeIfAbsent("key5", k -> 20000 + 30000);
        map.computeIfAbsent("key6", k -> 20000 * 3);

        //if already exists,不做处理
        map.computeIfAbsent("key1", k -> 9999999);

        // print new mapping
        System.out.println("New HashMap:" + map);
    }

    // hashmap 扩容测试
    private static void testResize() {
        // cap = threshold * loadFactor;
        HashMap<String, Object> hashMap = new HashMap<String, Object>(4,0.75f);
        int i = 0;
        while (true){
            hashMap.put("k"+i,i);
            i++;
        }
    }

    // hashmap 基本功能测试
    private static void HashMapTest01() {
        Map<String, String> map = new HashMap<>(13);
        map.put("1", "A");
        map.put("2", "A");
        map.put("3", "A");
        map.put("5", "A");
        map.put("6", "A");
        map.put("7", "A");
        // 特殊操作
        map.putIfAbsent("7","小伟"); // onlyIfAbsent = true 如果存在就保留旧值，不进行put操作
        // map.clear(); // 清除map集合元素为null
        map.replace("1","A","状元");
        System.out.println(map.put("1", "B"));
        System.out.println(map);
        System.out.println(map.get("1"));
        System.out.println("map = " + map.size()); //map = 6
    }

}

/**
 * 关键属性
 * transient int modCount;//被修改的次数
 */
