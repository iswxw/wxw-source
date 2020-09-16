package java8.com.wxw.code.study.hashmap;

import java.util.HashMap;
import java.util.Map;

import static com.sun.xml.internal.fastinfoset.util.ValueArray.MAXIMUM_CAPACITY;

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
        HashMapTest01();

        // hashmap 扩容测试
        //testResize();

        // hashMap的computeIfAbsent()函数计算语法
        // testComputeIfAbsent();

        // tableSizeFor 根据容量参数，大于并最近的一个2的n次幂的数
        /**
         * 问题：边界区问题
         *  （1）参数幂次变换的时候开始为什么要减1 （int类型的最大值时，变换后返回 n+1会导致溢出, 防止cap已经是2的幂次方，不减一时，导致无符号右移变为原来的2倍）
         *  （2）参数幂次变换的时候最后为什么要加1 （当输入为0的时候就会发现，方法的输出为1，HashMap的容量只有大于0时才有意义）
         * 解答：https://www.jianshu.com/p/e33d3fa32091
         *  （3）为什么计算结果总是2的幂次方
         * 解答：https://www.jianshu.com/p/e33d3fa32091 （因为无符号右移16位后和低16位异样或的结果刚好是30位，这样保证了高32位都为1）
         */
        //testTableSizeFor();
    }

    // hashmap tableSizeFor 保证容量2幂次变换
    private static void testTableSizeFor() {
        System.out.println(tableSizeFor(0));
        System.out.println(tableSizeFor(1));
        System.out.println(tableSizeFor(5));
        System.out.println(tableSizeFor(25));
        System.out.println(tableSizeFor(125));
        System.out.println(tableSizeFor(625));
    }

    // HashMap函数计算
    // https://blog.csdn.net/uniquewonderq/article/details/89890675
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
    // https://my.oschina.net/u/2307589/blog/1800587
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
        String put = map.put("7", "A");
        // key重复返回旧值、否则返回 null
        System.out.println("hashMap 正常添加的返回值 put = " + put);
        // 特殊操作
        map.putIfAbsent("7","小伟"); // onlyIfAbsent = true 如果存在就保留旧值，不进行put操作
        // map.clear(); // 清除map集合元素为null
        map.replace("1","A","状元");
        System.out.println(map.put("1", "B"));
        System.out.println(map);
        System.out.println(map.get("1"));
        System.out.println("map = " + map.size()); //map = 6
    }

    // 根据容量参数，返回一个2的n次幂的table长度
    //
    public static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

}

/**
 * 关键属性
 * transient int modCount;//被修改的次数
 */
