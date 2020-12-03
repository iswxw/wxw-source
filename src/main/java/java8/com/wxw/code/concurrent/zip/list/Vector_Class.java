package java8.com.wxw.code.concurrent.zip.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

/**
 * https://www.hollischuang.com/archives/498
 * @author ：wxw.
 * @date ： 9:22 2020/12/3
 * @description：Vector类
 * @version: v_0.0.1
 */
public class Vector_Class {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();      // 没有同步处理
        List list2 =  Collections.synchronizedList(list); // 同步块
        Vector<String> list1 = new Vector<String>();      // 同步方法
    }
}
