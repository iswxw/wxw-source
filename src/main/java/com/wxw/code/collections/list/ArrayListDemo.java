package com.wxw.code.collections.list;


import java.util.ArrayList;
import java.util.List;

/**
 * @author ：wxw.
 * @date ： 10:46 2021/1/25
 * @description：ArrayList 源码
 * @link: https://www.cnblogs.com/2019wxw/p/12403120.html
 * @version: v_0.0.1
 */
public class ArrayListDemo {
    public static void main(String[] args) {
        List<Integer> arraylist = new ArrayList<>();
    }

    /**
     * ArrayList 扩容
     * 1. ensureCapacity(int minCapacity)
     * 2. ensureExplicitCapacity(minCapacity)
     * 3. grow(minCapacity)
     */
    public void arrayListGrow(){
        List<Integer> arrayList = new ArrayList<>(10);
    }
}
