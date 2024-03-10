package 多线程.等待全部唤醒;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ThreadPoolExample {
    public static void main(String[] args) {
        // 创建一个线程池
        ExecutorService executor = Executors.newFixedThreadPool(5);

        // 创建多个 Callable 对象
        List<Callable<String>> callableTasks = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Callable<String> callableTask = () -> {
                try {
                    System.out.println("Callable任务开始执行");
                    Thread.sleep(10000); // 模拟任务执行时间
                    System.out.println("Callable任务执行完成");
                    return "Task " + Thread.currentThread().getName() + " 完成";
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            };
            callableTasks.add(callableTask);
        }

        try {
            // 提交所有的 Callable 任务给线程池执行
            List<Future<String>> futures = executor.invokeAll(callableTasks);

            // 某个时机下唤醒所有线程
            // 例如，在所有任务完成后，你可以调用 executor.shutdown() 或者 executor.shutdownNow()
            // 来关闭线程池，并且这也会中断所有任务，唤醒等待中的线程
            executor.shutdown();

            // 输出所有任务的执行结果
            for (Future<String> future : futures) {
                try {
                    String result = future.get();
                    System.out.println("任务执行结果: " + result);
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
