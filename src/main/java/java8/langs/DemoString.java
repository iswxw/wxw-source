package java8.langs;

/**
 * @author: wxw
 * @date: 2021-02-09-13:43
 * @link:
 * @description:
 */
public class DemoString {
    public static void main(String[] args) {

        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println("str1.intern() ==str1 = " + str1.intern() == str1);

        /**
         * intern() jdk6首次调用会复制到常量池，jdk7+怎么在堆的方法区常量池做个标记
         * 当 字符为Java时，为false,因为 "java" 执行 StringBuilder.toString() 之前就执行标记过了
         */
        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println("str2.intern() ==str2 = " + str2.intern() == str2);
    }
}
