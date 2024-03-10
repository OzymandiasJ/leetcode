package 多线程.常用方法.join;

public class Main {
    /**
     *
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
        Solution solution=new Solution();
        solution.solve();
    }
}
class Solution{
    public void solve() throws InterruptedException {
        Thread mythread1=new MyThread();
        Thread mythread2=new MyThread();
        mythread1.setName("飞机");
        mythread2.setName("坦克");
        mythread1.start();
        mythread1.join();
        mythread2.start();
    }
}
class MyThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 30; i++) {
            System.out.println(this.getName()+"@"+i);
            this.yield();
        }
    }
}

