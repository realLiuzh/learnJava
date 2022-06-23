package ThreadLocal使用;

import lombok.Data;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 志昊的刘
 * @date 2022/6/22
 */
@Data
public class ThreadLocalTest2 {
    @Data
    static class Foo {
        static final AtomicInteger AMOUNT = new AtomicInteger(0);
        int index = 0;
        int bar = 10;

        public Foo() {
            index = AMOUNT.incrementAndGet();
        }

        private static final ThreadLocal<Foo> LOCAL_FOO = new ThreadLocal<>();

        public static void main(String[] args) {
            ExecutorService threadPool = Executors.newFixedThreadPool(5);

            for (int i = 0; i < 5; i++) {
                threadPool.execute(() -> {
                    if (LOCAL_FOO.get() == null) {
                        LOCAL_FOO.set(new Foo());
                    }
                    System.out.println("初始的本地值：" + LOCAL_FOO.get());
                    for (int j = 0; j < 10; j++) {
                        Foo foo = LOCAL_FOO.get();
                        foo.setBar(foo.getBar() + 1);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("累加后的本地值："+LOCAL_FOO.get());
                    LOCAL_FOO.remove();
                });
            }

        }

    }
}
