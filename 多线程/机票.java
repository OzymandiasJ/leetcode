package 多线程;

import java.util.concurrent.Semaphore;

public class 机票 {

    private static final int K = 10; // 初始机票数量
    private static Semaphore ticketSemaphore = new Semaphore(K); // 机票信号量

    public static void main(String[] args) {
        // 创建订票进程和退票进程
        Thread bookingThread = new Thread(new BookingProcess());
        Thread refundThread = new Thread(new RefundProcess());

        // 启动进程
        bookingThread.start();
        refundThread.start();
    }

    // 订票进程
    static class BookingProcess implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    ticketSemaphore.acquire(1); // 等待可用的机票
                    System.out.println("订票成功，剩余机票数量：" + ticketSemaphore.availablePermits());
                    // 模拟订票操作
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // 退票进程
    static class RefundProcess implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    ticketSemaphore.acquire(); // 等待可用的机票
                    System.out.println("退票成功，剩余机票数量：" + ticketSemaphore.availablePermits());
                    // 模拟退票操作
                    Thread.sleep(5000);
                    ticketSemaphore.release(1); // 释放机票
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
