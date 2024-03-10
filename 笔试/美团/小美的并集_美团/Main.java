package 笔试.美团.小美的并集_美团;

import java.util.*;

public class Main {
    /**
     * 这里写程序描述
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int m=input.nextInt();
        List<List<Integer>> lists=new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int n=input.nextInt();
            List<Integer> list=new ArrayList<>();
            for (int j = 0; j < n; j++) {
                int num=input.nextInt();
                list.add(num);
            }
            lists.add(list);
        }
        System.out.println(countColectionP(lists));
        input.close();
    }
    public static double countColectionP(List<List<Integer>> lists){
        HashMap<Integer,Integer> map=new HashMap<>();
        //遍历每个集合，从第一个集合开始计算与其他集合的并集大小，
        // 计算出来大小后放到一个hashmap中去，key是大小，value是出现的次数，
        // 最后计算概率
        for (int i = 0; i < lists.size(); i++) {
            for (int j = i+1; j < lists.size(); j++) {
                int num=countColection(lists.get(i),lists.get(j));
                if(!map.containsKey(num)){
                    //如果第一次出现这个key，value设为1
                    map.put(num,1);
                }else {
                    //不是的话value+1
                    int oldValue=map.get(num);
                    map.put(num,oldValue+1);
                }
            }
        }
        int sum=0;
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            sum+=entry.getValue();
        }
        double res=0;
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            res+=entry.getKey()*(1.0*entry.getValue()/sum);
        }
        return res;
    }
    public static int countColection(List<Integer> list1,List<Integer> list2){
        HashSet<Integer> set=new HashSet<>();
        for (int i = 0; i < list1.size(); i++) {
            set.add(list1.get(i));
        }
        for (int i = 0; i < list2.size(); i++) {
            set.add(list2.get(i));
        }
        return set.size();
    }
}
//2
//2 1 2
//3 1 3 5