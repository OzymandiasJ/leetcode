package 多线程.CountDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 创建callable任务丢到线程池中的睡眠，一定时机全部唤醒
 */
public class Main {
    static int numberOfTasks = 5;
    static ExecutorService executor = Executors.newFixedThreadPool(numberOfTasks);
    static CountDownLatch latch = new CountDownLatch(numberOfTasks);
    public static void main(String[] args) {


        for (int i = 0; i < numberOfTasks; i++) {
            executor.submit(() -> {
                try {
                    System.out.println("Task is going to sleep");
                    // 任务等待Latch减少到0，进入睡眠状态
                    latch.await();
                    System.out.println("Task woke up!");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.err.println("Task interrupted");
                }
            });
            latch.countDown(); // 每次提交任务时，Latch减少一次
        }

        // 让所有任务进入睡眠状态一段时间
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Main thread interrupted");
        }

        // 在特定条件下唤醒所有任务
        latch = new CountDownLatch(numberOfTasks); // 重置Latch
        latch.countDown(); // 释放Latch，使所有任务唤醒
        executor.shutdown();
    }
}
