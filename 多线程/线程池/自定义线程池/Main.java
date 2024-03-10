package 多线程.线程池.自定义线程池;

import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {
    /**
     * 这里写程序描述
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        input.close();
    }

}
class MyThreadPool{
    ThreadPoolExecutor pool = new ThreadPoolExecutor(
            3, //核心线程数量，能小于9maximumPoolSize:
            6, //最大线程数，不能小于0，最大数量 >= 核心线程数量
            60,//空闲线程最大存活时间
            TimeUnit.SECONDS,//时间单位
            new ArrayBlockingQueue<>(3),//任务队列
            Executors.defaultThreadFactory(),//创建线程工)
            new ThreadPoolExecutor.AbortPolicy()//停务的拒绝策略
    );
}
