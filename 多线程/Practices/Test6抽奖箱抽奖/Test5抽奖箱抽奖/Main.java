package 多线程.Practices.Test6抽奖箱抽奖.Test5抽奖箱抽奖;

import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Main {
    /**
     在上一题基础上继续完成如下需求:
     每次抽的过程中，不打印，抽完时一次性打印(随机)在此次抽奖过程中，
     抽奖箱1总共产生了6个奖项。分别为: 10,20,100,500,2,300最高奖项为300元，总计额为932元
     在此次抽奖过程中，抽奖箱2总共产生了6个奖项。
     分别为: 5,50,200,800,80,700最高奖项为800元，总计额为1835元
     * @param args
     */
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Solution solution=new Solution();
        solution.solve();
    }
}
class Solution{
    public void solve() throws ExecutionException, InterruptedException {
        ArrayList<Integer> list=new ArrayList<>();
        Collections.addAll(list,110,5,20,50,100,200,500,800,2,80,300,7001);
        //创建MyCallable的对象 (表示多线程要执行的任务)
        MyCallable mc1=new MyCallable(list);
        MyCallable mc2=new MyCallable(list);
        //创建FutureTask的对象 (作用管理多线程运行的结果)
        FutureTask<ArrayList<Integer>> ft1=new FutureTask<>(mc1);
        FutureTask<ArrayList<Integer>> ft2=new FutureTask<>(mc2);
        //创建线程的对象
        Thread t1=new Thread(ft1);
        Thread t2=new Thread(ft2);
        t1.setName("线程1");
        t2.setName("线程2");
        //启动线程
        t1.start();
        t2.start();

        //获取线程运行结果
        ArrayList<Integer> result1= ft1.get();
        ArrayList<Integer> result2= ft2.get();
        System.out.println("在此次抽奖过程中，"+t1.getName()+"总共产生了"+result1.size()+"个奖项。");
        System.out.print("\t分别为：");
        for (int i = 0; i < result1.size(); i++)
            System.out.print(result1.get(i)+" ");
        int sum1=0;
        for (int i = 0; i < result1.size(); i++)
            sum1+=result1.get(i);
        System.out.println("\n最高奖："+result1.stream().max(Integer::compareTo).get()+"\t总计："+sum1);

        System.out.println("\n在此次抽奖过程中，"+t2.getName()+"总共产生了"+result2.size()+"个奖项。");
        System.out.print("\t分别为：");
        for (int i = 0; i < result2.size(); i++)
            System.out.print(result2.get(i)+" ");
        int sum2=0;
        for (int i = 0; i < result2.size(); i++)
            sum2+=result2.get(i);
        System.out.println("\n最高奖："+result2.stream().max(Integer::compareTo).get()+"\t总计："+sum2);

    }
}
class MyCallable implements Callable<ArrayList<Integer>> {
    static ArrayList<Integer> list=new ArrayList<>();
    static Random random=new Random(System.currentTimeMillis());

    public MyCallable() {
    }
    public MyCallable(ArrayList<Integer> list) {
        this.list=list;
    }

    @Override
    public ArrayList<Integer> call() throws Exception {
        ArrayList<Integer> mylist=new ArrayList<>();
        while (true){
            synchronized (list){
                Thread.sleep(10);
                int len=list.size();
                if(len<=0)
                    break;
                else {
                    int index=random.nextInt(len);
                    int num=list.get(index);
                    list.remove(index);
                    mylist.add(num);
                }
            }
            Thread.sleep(10);
        }
        return mylist;
    }
}

