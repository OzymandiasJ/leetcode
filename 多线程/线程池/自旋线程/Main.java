package 多线程.线程池.自旋线程;

import java.util.concurrent.*;

public class Main {
    static int numThreads = 5;

    // 创建线程池
    static ExecutorService executor = Executors.newFixedThreadPool(numThreads);

    // 创建CountDownLatch，计数器初始化为线程数量
    static CountDownLatch latch = new CountDownLatch(numThreads);

    public static void main(String[] args) throws InterruptedException {
        // 提交任务到线程池
        for (int i = 0; i < numThreads; i++) {
            executor.submit(() -> {
                try {
                    System.out.println("Thread " + Thread.currentThread().getId() + " is sleeping");
                    Thread.sleep(2000); // 模拟线程睡眠
                    System.out.println("Thread " + Thread.currentThread().getId() + " is awake");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    latch.countDown(); // 任务执行完毕，计数器减一
                }
            });
        }

        try {
            // 主线程等待所有任务执行完毕
            latch.await();

            // 在某个特定时刻唤醒线程池中的所有线程
            System.out.println("Waking up all threads");
            executor.shutdownNow();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
