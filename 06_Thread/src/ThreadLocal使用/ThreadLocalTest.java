package ThreadLocal使用;

/**
 * @author 志昊的刘
 * @date 2022/6/1
 */
public class ThreadLocalTest {
    static void print(String str) {
        // 打印当前线程本地内存中的localVariable
        System.out.println(str + ":" +localVariable.get());
        // 清除当前线程本地内存中的localVariable
        //localVariable.remove();
    }

    // 创建ThreadLocal变量
    static ThreadLocal<String> localVariable = new ThreadLocal<>();

    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                localVariable.set("threadOne local variable");
                print("threadOne");
                System.out.println("threadOne remove after"+":"+localVariable.get());
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                localVariable.set("threadTwo local variable");
                print("threadTwo");
                System.out.println("threadTwo remove after"+":"+localVariable.get());
            }
        }).start();

    }
}
