package 多线程.生产者消费者.阻塞队列;


import java.util.concurrent.ArrayBlockingQueue;

public class Main {
    /**
     *  模拟生产者——桌子——消费者模式
     *  阻塞队列实现
     * @param args
     */
    public static void main(String[] args) {
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(10);
        Cook cook=new Cook(queue,"生产者");
        Consumer consumer=new Consumer(queue,"消费者");
        consumer.start();
        cook.start();
    }
}

