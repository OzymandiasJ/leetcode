package 多线程.线程安全.不安全示范;

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
        Thread mythread1=new MyThread("线程1");
        Thread mythread2=new MyThread("线程2");
        Thread mythread3=new MyThread("线程3");
        mythread1.start();
        mythread2.start();
        mythread3.start();
    }
}
class MyThread extends Thread{
    public static int ticket=0;
    public MyThread() {}
    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        while (true){
            if(ticket<100){
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                ticket++;
                System.out.println(this.getName()+"售出了第"+ticket+"张票");
            }else
                break;
        }
    }
}

