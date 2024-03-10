package 多线程.常用方法.yield;

public class Main {
    /**
     *
     */
    public static void main(String[] args) {
        Solution solution=new Solution();
        solution.solve();
    }
}
class Solution{
    public void solve(){
        Thread mythread1=new MyThread();
        Thread mythread2=new MyThread();
        mythread1.setName("飞机");
        mythread2.setName("坦克");
        mythread1.start();
        mythread2.start();
    }
}
class MyThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(this.getName()+"@"+i);
            this.yield();
        }
    }
}

