package 多线程.生产者消费者.等待唤醒机制;


public class Main {
    /**
     *  模拟生产者——桌子——消费者模式
     *  等待唤醒机制
     * @param args
     */
    public static void main(String[] args) {
        Cook cook=new Cook("生产者");
        Consumer consumer=new Consumer("消费者");

        consumer.start();
        cook.start();
    }
}

