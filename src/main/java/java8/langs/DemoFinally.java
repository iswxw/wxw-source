package java8.langs;

import lombok.ToString;

/**
 * @author: wxw
 * @date: 2021-02-09-14:41
 * @link:
 * @description:
 */
public class DemoFinally {
    public static void main(String[] args) {
        // System.out.println("真正的返回值： test() = " + test());
        // System.out.println("test_1() = " + test_1());
        // System.out.println("test_2() = " + test_2());
        System.out.println("test_3() = " + test_3());
    }

    public static int test(){
        int num = 10;
        try {
            System.out.println("原来的值：num = " + num);
            num = num + 10;
            System.out.println("操作后的值 num = " + num);

            // 制作异常
            // int NLP = 1/0;
            // 阻止执行，则不再往下执行，也不会执行finally
            // System.exit(0);
            return num;
        }catch (Exception e){
            num = num + 10;
            System.out.println("Exception num = " + num);
            return num;
        }finally {
            num = num + 10;
            System.out.println("finally num = " + num);
            return num;
        }
    }

    /**
     * try中有return，finally中没有return
     * 输出结果：
     *    原来的值：num = 10
     *    操作后的值 num = 20
     *    finally num = 30
     *    test_1() = 20
     *  先将try中return的值保存在栈中，等执行完finally中的逻辑后，再返回保存的try中的return
     * @return
     */
    public static int test_1(){
        int num = 10;
        try {
            System.out.println("原来的值：num = " + num);
            num = num + 10;
            System.out.println("操作后的值 num = " + num);
            return num;
        }catch (Exception e){
            num = num + 10;
            System.out.println("Exception num = " + num);
            return num;
        }finally {
            num = num + 10;
            System.out.println("finally num = " + num);
        }
    }

    /**
     *  try和finally中均有return
     *  输出结果：
     *   原来的值：num = 10
     *   操作后的值 num = 20
     *   finally num = 30
     *   test_2() = 30
     *  try中的return被finally 中的return ”覆盖“掉了，不再执行。
     * @return
     */
    public static int test_2(){
        int num = 10;
        try {
            System.out.println("原来的值：num = " + num);
            num = num + 10;
            System.out.println("操作后的值 num = " + num);
            return num;
        }catch (Exception e){
            num = num + 10;
            System.out.println("Exception num = " + num);
            return num;
        }finally {
            num = num + 10;
            System.out.println("finally num = " + num);
            return num;
        }
    }

    /**
     * 输出结果：
     *   原来的值：num = 10
     *   操作后的值 num = 20
     *   finally num = 100
     *   test_3() = DemoFinally.Num(num=100)
     * 引用类型 的finally
     * @return
     */
    public static Num test_3(){
        Num num = new Num();
        try {
            num.num = 10;
            System.out.println("原来的值：num = " + num.num);
            num.num = num.num +10;
            System.out.println("操作后的值 num = " + num.num);
            return num;
        }catch (Exception e){
            num.num = num.num +10;
            System.out.println("Exception num = " + num.num);
        }finally {
            num.num = 100;
            System.out.println("finally num = " +num.num);
        }
        return num;
    }

    @ToString
    static class Num{
        public Integer num = 10;
    }

}
