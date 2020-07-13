package java8.com.wxw.code.concurrent.lock;

/**
 * @ Author ：wxw.
 * @ Date ： 12:51 2020/7/13
 * @ Description：线程变量
 * @ Version:   v_0.0.1
 */
public class ThreadLocal01 {
    private static ThreadLocal<String> local = new ThreadLocal<String>(){
        @Override
        protected String initialValue() {
            return "wxw:";
        }
    };
    static class MyRunnable implements Runnable{

        private int num;

        public MyRunnable(int num) {
            this.num = num;
        }

        @Override
        public void run() {
            local.set(String.valueOf(num));
            System.out.println("local.get() = " +local.get());
            // 手动移除变量
            local.remove();
        }
    }
    public static void main(String[] args) {
        new Thread(new MyRunnable(1)).start();
        new Thread(new MyRunnable(2)).start();
        new Thread(new MyRunnable(3)).start();
    }
}
