package 多线程.Practices.Test3找奇数;

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
    static int num=100;
    public MyThread() {}
    public MyThread(String name) {
        super(name);
    }
    @Override
    public void run() {
        while(true){
            if (extracted()) break;
        }
    }

    private static boolean extracted() {
        num--;
        if(num<=0)
            return true;
        else {
            if(num%2!=0){
                System.out.println(Thread.currentThread().getName()+"找到了一个奇数，为："+num);
            }
        }
        return false;
    }
}

