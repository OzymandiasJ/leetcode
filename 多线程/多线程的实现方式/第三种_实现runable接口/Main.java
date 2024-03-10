package 多线程.多线程的实现方式.第三种_实现runable接口;


public class Main {
    /**
     * 多线程的第二种启动方式:
     * 1.自己定义一个任务类实现Runnable
     * 2.重写run方法
     * 3.创建改任务类的实例任务对象，并将这个类的实例作为参数创建一个Thread类，然后调用Thread的run方法
     * 相当于第一种方法传递了一个任务对象
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
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+"启动");
        }
    }
}

