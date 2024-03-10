package 多线程;

public class wait与sleep {
    static Object lock=new Object();
    /**
     * 这里写程序描述
     */
    public static void main(String[] args) throws InterruptedException {
        Thread T1 = new Thread(() -> {
            synchronized (lock){
                System.out.println("Thread T1 is waiting.");
                try {
                    Thread.sleep(3000);
                    //sleep 如果在 synchronized 代码块中执行，并不会释放对象锁,
                    //所以需要等待3秒后线程2才能获得锁去执行
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


        T1.start();
        T2.start();
    }
}
