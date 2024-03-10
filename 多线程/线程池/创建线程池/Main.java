package 多线程.线程池.创建线程池;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        //    1，创建线程池
        ExecutorService pool1=Executors.newFixedThreadPool(3);//有限大小线程池
        //    2，提交任务
        pool1.submit(new MyRunable());
        Thread.sleep(100);
        pool1.submit(new MyRunable());
        Thread.sleep(100);
        pool1.submit(new MyRunable());
        Thread.sleep(100);
        pool1.submit(new MyRunable());
        //    3，所有的任务全部执行完毕，关闭线程池
        pool1.shutdown();
    }


}
class MyRunable implements Runnable{

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(Thread.currentThread().getName()+"-----"+i );
        }
    }
}
