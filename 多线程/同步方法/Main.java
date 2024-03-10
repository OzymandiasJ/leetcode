package 多线程.同步方法;


public class Main {
    /**
     *
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
        Thread t1=new Thread(myRun1,"线程1");
        Thread t2=new Thread(myRun1,"线程2");
        t1.start();
        t2.start();
    }
}
class MyRun implements Runnable{
    int ticket=0;
    @Override
    public void run() {
        while(true){
            if (method()) break;
        }
    }
    //同步方法的所对象是当前的run类，是唯一的
    private synchronized boolean method() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if(ticket==100){
            return true;
        }else {
            ticket++;
            System.out.println(Thread.currentThread().getName()+"售出了第"+ticket+"张票");
        }
        return false;
    }
}

