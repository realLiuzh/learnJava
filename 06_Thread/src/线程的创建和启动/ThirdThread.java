package 线程的创建和启动;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThirdThread {
    public static void main(String[] args) {

        // 使用Lambda表达式创建Callable对象
        // 使用FutureTask来包装Callable对象
        FutureTask<Integer> task = new FutureTask<>(() -> {
            int j = 0;
            for (; j < 100; j++) {
                System.out.println(Thread.currentThread().getName() + " 的循环变量j的值：" + j);
            }
            // call方法可以有返回值
            return j;
        });
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " 的循环变量i的值：" + i);
            if (i == 20) {
                new Thread(task, "有返回值的线程").start();
            }
        }
        try {
            System.out.println("子线程返回值：" + task.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("ThirdThread.main");
    }


}
