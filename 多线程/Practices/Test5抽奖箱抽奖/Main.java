package 多线程.Practices.Test5抽奖箱抽奖;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
    /**
     有一个抽奖池,该抽奖池中存放了奖励的金额,
     该抽奖池中的奖项为110,5,20,50,100,200,500,800,2,80,300,7001;
     创建两个抽奖箱(线程)设置线程名称分别为“抽奖箱1、抽奖箱2
     随机从抽奖池中获取奖项元素并打印在控制台上格式如下每次抽出一个奖项就打印个(随机)
     抽奖箱1 又产生了一个 10 元大奖
     抽奖箱1又产生了一个 100 元大奖抽奖箱1 又产生了一个 200 元大奖
     抽奖箱1 又产生了一个 800 元大奖
     抽奖箱2又产生了一个 700 元大奖
     * @param args
     */
    public static void main(String[] args) {
        Solution solution=new Solution();
        solution.solve();
    }
}
class Solution{
    public void solve(){
        ArrayList<Integer> list=new ArrayList<>();
        Collections.addAll(list,110,5,20,50,100,200,500,800,2,80,300,7001);
        Thread mythread1=new MyThread(list,"抽奖箱1");
        Thread mythread2=new MyThread(list,"抽奖箱2");
        mythread1.start();
        mythread2.start();
    }
}
class MyThread extends Thread{
    static ArrayList<Integer> list=new ArrayList<>();
    static Random random=new Random(System.currentTimeMillis());
    public MyThread() {}
    public MyThread(ArrayList<Integer> queue,String name) {
        super(name);
        this.list=queue;
    }
    @Override
    public void run() {
        while(true){
            synchronized (list){
                int len=list.size();
                if(len<=0)
                    break;
                else {
                    int index=random.nextInt(len);
                    int num=list.get(index);
                    list.remove(index);
                    System.out.println(Thread.currentThread().getName()+"产生了一个"+num+"元大奖");
                }
            }
            try {
                sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

