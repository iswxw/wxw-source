package java8.collections.set;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ：wxw.
 * @date ： 14:10 2021/1/25
 * @description：hashSet 集合
 * @link: https://www.cnblogs.com/2019wxw/p/12403120.html
 * @version: v_0.0.1
 */
public class HashSetDemo {
    public static void main(String[] args) {
        Set<Integer> hashSet = new HashSet<>();
        hashSet.add(1);
        System.out.println("hashSet = " + hashSet);
    }
}
