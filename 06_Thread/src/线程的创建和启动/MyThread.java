package 线程的创建和启动;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// 线程池创建线程
public class MyThread implements Runnable {


    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" thread run...");
    }

    public static void main(String[] args) {
        // 创建线程池
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        // execute()使用线程池执行任务
        for (int i = 0; i < 10; i++) {
            executorService.execute(new MyThread());
        }
        // 关闭线程池
        executorService.shutdown();
    }
}
