package 多线程.线程安全.synchronized解决安全问题;

public class Main {
    /**
     * 多线程的第一种启动方式:
     * 1.自己定义一个类继承Thread
     * 2.重写run方法
     * 3。创建子类的对象，并启动线程
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
        mythread1.start();
        mythread2.start();
        mythread3.start();
    }
}
class MyThread extends Thread{
    public MyThread() {}
    public MyThread(String name) {
        super(name);
    }

    private static int ticket;

    @Override
    public void run() {
        //同步代码块
        while (true){
            synchronized (MyThread.class){
                if(ticket<100){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    ticket++;
                    System.out.println(this.getName()+"售出了第"+ticket+"张票");
                    Thread.yield();
                }else
                    break;
            }
        }
    }
}

