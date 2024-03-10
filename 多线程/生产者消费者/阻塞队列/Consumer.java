package 多线程.生产者消费者.阻塞队列;

import java.util.concurrent.ArrayBlockingQueue;

class Consumer extends Thread {//消费者
    ArrayBlockingQueue<String> queue ;

    public Consumer() {}

    public Consumer(String name) {
        super(name);
    }
    public Consumer(ArrayBlockingQueue<String>queue,String name) {
        super(name);
        this.queue=queue;
    }
    @Override
    public void run() {
        while(true){
            //不需要锁，因为put方法底层有锁
            try {
                String take = queue.take();
                System.out.println("消费者消费了一个数据,队列中剩余"+queue.size()+"个数据");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

