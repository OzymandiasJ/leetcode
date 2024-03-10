package 多线程.生产者消费者.等待唤醒机制;

/**
 * 循环同步代码块
 * 判断其享数据是否到了末尾《到了末尾)
 * 判断共享数据是否到了末尾《没有到末尾，执行核心逻辑 》
 */
public class Cook extends Thread{
    public Cook() {}

    public Cook(String name) {
        super(name);
    }

    @Override
    public void run() {
        while(true){
            synchronized (Desk.lockObj){
                if(Desk.count==0){
                    break;
                }else {
                    //判断桌子上是否有资源
                    if(Desk.foodFlag==1){
                        //有的话等待
                        try {
                            Desk.lockObj.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }else {
                        //如果没有，就生产资源
                        System.out.println(Thread.currentThread().getName()+"生产了一个资源");
                        // 修改桌子上的食物状态
                        Desk.foodFlag=1;
                        // 唤醒等待的消费者开吃
                        Desk.lockObj.notifyAll();
                    }
                }
            }
        }
    }
}
