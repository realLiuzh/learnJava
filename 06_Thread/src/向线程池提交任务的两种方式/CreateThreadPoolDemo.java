package 向线程池提交任务的两种方式;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;

/**
 * @author 志昊的刘
 * @date 2022/6/8
 */
public class CreateThreadPoolDemo {

    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(2);
        Future<Integer> future=pool.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return new Random().nextInt(200);
            }
        });
        try{
            Integer result = future.get();
            System.out.println("异步的结果是："+result);
        }catch (Exception e){
            e.printStackTrace();
        }
        Thread.sleep(100);
        pool.shutdown();
    }
}
