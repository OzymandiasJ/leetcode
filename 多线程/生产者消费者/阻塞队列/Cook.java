package 多线程.生产者消费者.阻塞队列;

import java.util.concurrent.ArrayBlockingQueue;


public class Cook extends Thread{
    ArrayBlockingQueue<String> queue;
    public Cook() {}

    public Cook(String name) {
        super(name);
    }
    public Cook(ArrayBlockingQueue<String> queue,String name) {
        super(name);
        this.queue=queue;
    }
    @Override
    public void run() {
        while(true){
            //不需要锁，因为put方法底层有锁
            try {
                queue.put("数据");
                System.out.println("生产者生产了一个数据放到了队列中");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

