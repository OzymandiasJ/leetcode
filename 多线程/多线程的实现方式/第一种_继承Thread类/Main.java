package 多线程.多线程的实现方式.第一种_继承Thread类;

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
        mythread1.start();
        mythread2.start();
    }
}
class MyThread extends Thread{
    public MyThread() {}
    public MyThread(String name) {
        super(name);
    }
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(this.getName()+"启动");
        }
    }
}

