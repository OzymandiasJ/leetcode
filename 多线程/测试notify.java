package 多线程;

public class 测试notify {
    static Object lock=new Object();
    /**
     * 这里写程序描述
     */
    public static void main(String[] args) throws InterruptedException {
        Thread T1 = new Thread(() -> {
            synchronized (lock){
                System.out.println("Thread T1 is waiting.");
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Thread T1 is wake.");
            }
        });
        Thread T2 = new Thread(() -> {
            synchronized(lock){
                System.out.println("Thread T2 is waiting.");
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Thread T2 is wake.");
            }
        });
        Thread T3 = new Thread(() -> {
            synchronized(lock){
                System.out.println("Thread T3 is waiting.");
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Thread T3 is wake.");
            }
        });

        T1.start();
        T2.start();
        T3.start();
        Thread.sleep(1000);//注意，必须要等待，
        // 确保了当主线程调用lock.notify()时，有其他线程正在等待被唤醒。
        // 如果移除这行代码，你就不能保证此行为，因此可能无法唤醒任何线程。

        synchronized (lock){
            lock.notify();//随机唤醒一个线程
        }
    }
}
