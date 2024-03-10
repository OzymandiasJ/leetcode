package 多线程.生产者消费者.等待唤醒机制;

class Consumer extends Thread {//消费者者

    public Consumer() {}

    public Consumer(String name) {
        super(name);
    }

    @Override
    public void run() {
        while (true) {
            synchronized (Desk.lockObj) {
                if (Desk.count == 0)
                    break;
                else {
                    //先判断桌子上是否有资源
                    // 如果没有就等待
                    if (Desk.foodFlag == 0) {
                        try {
                            Desk.lockObj.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    } else {
                        // 有的话消费，消费完之后，资源总数-1
                        Desk.count--;
                        System.out.println(Thread.currentThread().getName() + "消费了一个资源，还能消费" + Desk.count + "个资源");
                        // 并且唤醒生产者继续生产
                        Desk.lockObj.notifyAll();
                        // 还需要修改桌子上的状态，有没有资源
                        Desk.foodFlag = 0;
                    }
                }
            }
        }
    }
}
