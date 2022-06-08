package Executors创建线程池;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 志昊的刘
 * @date 2022/6/7
 */
public class CreateThreadPoolDemo4 {
    public static final int SLEEP_GAP = 500;

    // target
    static class TargetTask implements Runnable {
        static AtomicInteger taskNo = new AtomicInteger(1);
        private String taskName;

        public TargetTask() {
            taskName = "task-" + taskNo.get();
            taskNo.incrementAndGet();
        }

        @Override
        public void run() {
            System.out.println("任务："+taskName+" doing");
            // 线程睡眠
            try {
                Thread.sleep(SLEEP_GAP);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(taskName+" 运行结束");

        }
    }

    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(2);
        for (int i = 0; i < 1; i++) {
            pool.scheduleAtFixedRate(new TargetTask(),0,500, TimeUnit.MILLISECONDS);
        }
        Thread.sleep(100000000);
        pool.shutdown();

    }

}
