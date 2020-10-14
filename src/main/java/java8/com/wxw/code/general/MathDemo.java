package java8.com.wxw.code.general;

/**
 * @ Author ：wxw.
 * @ Date ： 16:21 2020/10/13
 * @ Description：数学函数方法测试 http://www.51gjie.com/java/185.html
 * @ Version:   v_0.0.1
 */
public class MathDemo {
    public static void main(String[] args) {

        /**
         * Java Math.round() 四舍五入
         * Java Math.random() 获取随机数
         * java Math.pow()计算次方
         * Java Math.ceil() 取整 向上取证
         * Java Math.sqrt() 计算平方根
         * Java Math.log() 计算对数
         * Java Math.floor() 取整
         */
        System.out.println("Math.abs(10) 获取绝对值 = " + Math.abs(-10));
        System.out.println("Math.ceil(5/2) 向上取整 = " + Math.ceil(5 / 2));
        System.out.println("Math.round(5/2) = " + Math.round(5 / 2));
        System.out.println("Math.floor(5/2) = " + Math.floor(5 / 2));
        System.out.println("(Integer)(5/2) = " + (Integer)(5 / 2));
    }
}
