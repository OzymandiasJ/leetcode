package 多线程.Lock;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    /**
     * @param args
     */
    public static void main(String[] args) {
        Solution solution=new Solution();
        solution.solve();
    }
}
class Solution{
    public void solve(){
        MyRun  myRun1=new MyRun();
        MyRun  myRun2=new MyRun();
        Thread t1=new Thread(myRun1);
        Thread t2=new Thread(myRun1);
        t1.setName("线程1");
        t2.setName("线程2");
        t1.start();
        t2.start();
    }
}
class MyRun implements Runnable{
    static Lock lock=new ReentrantLock();
    static int ticket=0;
    @Override
    public void run() {
        while (true){
            lock.lock();
            try {
                if(ticket==100)
                    break;
                else {
                    Thread.sleep(10);
                    ticket++;
                    System.out.println(Thread.currentThread().getName()+"售出了第"+ticket+"张票");
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        }
    }
}

