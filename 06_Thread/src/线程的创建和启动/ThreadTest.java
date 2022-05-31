package 线程的创建和启动;


public class ThreadTest {

    public static void main(String[] args) {
        // 问最后输出什么？
        // 考察了两点
        // 1.匿名内部类
        // 2.Thread.start()的操作流程
        // 3.继承
        new Thread(() -> System.out.println("runnable")) {
            @Override
            public void run() {
                System.out.println("Thread run");
            }
        }.start();
    }

}
