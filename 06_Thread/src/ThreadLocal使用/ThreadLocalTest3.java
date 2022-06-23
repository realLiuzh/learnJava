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
public class ThreadLocalTest3 {

    @Data
    static class InnerClass {
        // 对象的标号
        private static final AtomicInteger classIndex = new AtomicInteger(0);

        private Integer index;

        // 对象的值
        private Integer value;

        public InnerClass() {
            index = classIndex.incrementAndGet();
            value = 0;
        }
    }

    private static final ThreadLocal<InnerClass> threadLocal = ThreadLocal.withInitial(InnerClass::new);

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(5);


        for (int i = 0; i < 5; i++) {
            threadPool.execute(() -> {
                InnerClass innerClass = threadLocal.get();
                System.out.println("编号"+innerClass.getIndex());
                for (int j = 0; j < 10; j++) {
                    innerClass.setValue(innerClass.getValue() + 1);
                }
                System.out.println("值"+innerClass.getValue());
                threadLocal.remove();
            });
        }
        threadPool.shutdown();

    }


}
