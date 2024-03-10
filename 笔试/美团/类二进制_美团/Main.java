package 笔试.美团.类二进制_美团;

import java.util.*;

public class Main {
    /**
     * 这里写程序描述
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n=input.nextInt();//30302
        System.out.println(findMiniumClassBinaryNumbers(n));
        input.close();
    }

    public static int findMiniumClassBinaryNumbers(int n){
        Queue<List<Integer>> queue=new LinkedList<>();
        queue.add(new LinkedList<>());
        HashSet<Integer> seen=new HashSet<>();
        seen.add(0);
        while(!queue.isEmpty()){
            List<Integer> current=queue.poll();
            int currentSum=getCurrentSum(current);
            if(currentSum==n){
                return current.size();
            }
            for (int num:new int[]{1,10,100,1000,10000}) {
                if(num<=n){
                    List<Integer> newList=new LinkedList<>(current);
                    newList.add(num);
                    int newSum=getCurrentSum(newList);

                    if(!seen.contains(newSum)){
                        seen.add(newSum);
                        queue.add(newList);
                    }
                }
            }
        }
        return -1;
    }
    public static int getCurrentSum(List<Integer> list){
        int sum=0;
        for (Integer num:list){
            sum+=num;
        }
        return sum;
    }
}
