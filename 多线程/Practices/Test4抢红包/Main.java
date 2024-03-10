package 多线程.Practices.Test4抢红包;

import java.util.Random;

public class Main {
    /**
     假设:100块，分成了3个包，现在有5个人去抢其中，红包是共享数据。5个人是5条线程
     打印结果如下
     XXX抢到了XXX元
     XXX抢到了XXX元
     XXX抢到了XXX元
     XXX没抢到
     XXX没抢到
     TODO:一个人只能参与一次抽奖
     * @param args
     */
    public static void main(String[] args) {
        Solution solution=new Solution();
        solution.solve();
    }
}
class Solution{
    public void solve(){
        Thread mythread1=new MyThread("线程1");
        Thread mythread2=new MyThread("线程2");
        Thread mythread3=new MyThread("线程3");
        Thread mythread4=new MyThread("线程4");
        Thread mythread5=new MyThread("线程5");
        mythread1.start();
        mythread2.start();
        mythread3.start();
        mythread4.start();
        mythread5.start();
        /**
         * 线程1抢到了93块钱，剩余7块钱
         * 线程4抢到了2块钱，剩余5块钱
         * 线程5抢到了5块钱，剩余0块钱
         * 线程3没抢到
         * 线程2没抢到
         */
    }
}
class MyThread extends Thread{
    static int num=100;//剩余金额
    static Random random=new Random(System.currentTimeMillis());
    static Object lockObj=new Object();
    public MyThread() {}
    public MyThread(String name) {
        super(name);
    }
    @Override
    public void run() {
        synchronized (lockObj){
            if(num==0)
                System.out.println(Thread.currentThread().getName()+"没抢到");
            else {
                int number=random.nextInt(num)+1;
                num-=number;
                System.out.println(Thread.currentThread().getName()+"抢到了"+number+"块钱，剩余"+num+"块钱");
            }
        }
    }
}

