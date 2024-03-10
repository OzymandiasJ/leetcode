package 多线程.多线程的实现方式.第二种_实现Callable接口;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Main {
    /**
     * 多线程的第三种实现方式:
     * 特点: 可以获取到多线程运行的结果
     1.创建一个类MyCallable实现Callable接口
     2。重写call (是有返回值的，表示多线程运行的结果 )
     3。创建MyCallable的对象 (表示多线程要执行的任务)
     4，创建FutureTask的对象 (管理多线程运行的结果)
     5。创建Thread类的对象，并启动(表示线程)
     * @param args
     */
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Solution solution=new Solution();
        solution.solve();
    }
}
class Solution{
    public void solve() throws ExecutionException, InterruptedException {
        //创建MyCallable的对象 (表示多线程要执行的任务)
        MyCallable mc=new MyCallable();
        //创建FutureTask的对象 (作用管理多线程运行的结果)
        FutureTask<Integer> ft=new FutureTask<>(mc);
        //创建线程的对象
        Thread t1=new Thread(ft);
        t1.setName("线程");
        //启动线程
        System.out.println("线程启动："+LocalDateTime.now().format(DateTimeFormatter.ofPattern("mm:ss")));
        t1.start();

        //获取线程运行结果
        Integer result= ft.get();//请注意，ft.get()会阻塞主线程运行
        System.out.println("ft.get()执行");
        System.out.println("线程结束"+LocalDateTime.now().format(DateTimeFormatter.ofPattern("mm:ss")));
        System.out.println("返回值"+result);

        result= ft.get();//请注意，ft.get()会阻塞主线程运行
        System.out.println("ft.get()执行");
        System.out.println("线程结束"+LocalDateTime.now().format(DateTimeFormatter.ofPattern("mm:ss")));
        System.out.println("返回值"+result);
    }
}
class MyCallable implements Callable<Integer> {


    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName()+"正在执行...");
        Thread.sleep(3000);
        return 999;
    }
}

