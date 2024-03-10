package 多线程;

import java.util.Scanner;

public class 测试join {
    static Object lock=new Object();
    /**
     * 这里写程序描述
     */
    public static void main(String[] args) throws InterruptedException {
        Thread T1 = new Thread(() -> {
            System.out.println("Thread T1 is running.");
        });
        Thread T2 = new Thread(() -> {
            try {
                T1.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Thread T2 is running.");
        });
        Thread T3 = new Thread(() -> {
            try {
                T2.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Thread T3 is running.");
        });

        T1.start();
        T2.start();
        T3.start();
    }
}
