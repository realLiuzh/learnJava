package cas;

import sun.misc.Unsafe;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class CASAddDemo {
    private int i=0;
    private AtomicInteger j=new AtomicInteger(0);
    private AtomicInteger k=new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        CASAddDemo cas = new CASAddDemo();
        List<Thread> list=new ArrayList<>();
        for (int i = 0; i < 500; i++) {
            Thread thread=new Thread(()->{
                for (int j = 0; j < 10000; j++) {
                    cas.unsafeCount();
                    cas.safeCount1();
                    cas.safeCount2();
                }
            });
            list.add(thread);
        }
        for (Thread thread : list) {
            thread.start();
        }
        for (Thread thread : list) {
            thread.join();
        }
        System.out.println(cas.i);
        System.out.println(cas.j);
        System.out.println(cas.k);
    }

    private void safeCount2() {
        while(true){
            int value = k.get();
            boolean flag = k.compareAndSet(value, value + 1);
            if(flag) break;
        }
    }

    private void safeCount1() {
        j.incrementAndGet();
    }

    private void unsafeCount() {
        i++;
    }
}
