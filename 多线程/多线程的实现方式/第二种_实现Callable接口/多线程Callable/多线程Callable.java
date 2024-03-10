package 多线程.多线程的实现方式.第二种_实现Callable接口.多线程Callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class 多线程Callable {
    public static void main(String[] args) {
        int numberOfTasks = 5;

        // 创建线程池
        ExecutorService executor = Executors.newFixedThreadPool(numberOfTasks);

        // 存储Future对象，用于获取Callable任务的执行结果
        List<Future<String>> futures = new ArrayList<>();

        // 提交Callable任务并获取Future对象
        for (int i = 0; i < numberOfTasks; i++) {
            Callable<String> callableTask = new MyCallable(i);
            Future<String> future = executor.submit(callableTask);
            futures.add(future);
        }

        // 获取所有任务的执行结果
        for (Future<String> future : futures) {
            try {
                String result = future.get(); // 获取任务的执行结果（阻塞直到结果可用）
                System.out.println("Callable task result: " + result);
            } catch (InterruptedException | ExecutionException e) {
                System.err.println("Error retrieving task result: " + e.getMessage());
            }
        }

        // 关闭线程池
        executor.shutdown();
    }
}
class MyCallable implements Callable<String> {
    private int taskId;

    public MyCallable(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public String call() throws Exception {
        // 模拟耗时操作
        Thread.sleep(1000);
        return "Task ID: " + taskId + " completed";
    }
}
