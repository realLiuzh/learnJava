package deadlock;

// 死锁demo
public class DeadLockDemo {
    public Object A = new Object();
    public Object B = new Object();

    public static void main(String[] args) {
        new DeadLockDemo().deadLock();
    }

    public void deadLock() {
        Thread thread1 = new Thread(() -> {
            synchronized (A) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (B) {
                    System.out.println("thread1");
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (B) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (A) {
                    System.out.println("thread2");
                }
            }
        });

        thread1.start();
        thread2.start();

    }
}
