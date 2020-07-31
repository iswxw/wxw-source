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
    public static void main(String[] args) {

        Map<String, String> map = new HashMap<>(13);
        map.put("1", "A");
        System.out.println(map.put("1", "B"));
        System.out.println(map);
        System.out.println(map.get("1"));


    }

}

/**
 * 关键属性
 * transient int modCount;//被修改的次数
 */
