package umsorted.雇佣K位工人的总代价_2462;

import java.util.ArrayList;

public class Main {
    /**
     * 这里写程序描述
     */
    public static void main(String[] args) {
        int[] costs={31,25,72,79,74,65,84,91,18,59,27,9,81,33,17,58};
        int k=11;
        int candidates=2;
        Solution solution=new Solution();
        System.out.println(solution.totalCost(costs, k, candidates));
    }
}
class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int sumCost=0;

        ArrayList<Integer> list=new ArrayList<>();
        for (int i = 0; i < costs.length; i++) {
            list.add(costs[i]);
        }
        for (int j = 0; j < k; j++) {
            if(list.size()<candidates){
                //如果如果剩余员工数目不足 candidates 人，那么下一轮雇佣他们中代价最小的一人，
                // 如果有多位代价相同且最小的工人，选择下标更小的一位工人。
                int minvalue=Integer.MAX_VALUE;
                int minindex=Integer.MAX_VALUE;
                for (int i = 0; i < list.size(); i++) {
                    if(minvalue>list.get(i)){
                        minvalue=list.get(i);
                        minindex=i;
                    }
                }
                sumCost+=list.get(minindex);
                list.remove(minindex);
                continue;
            }
            //否则正常流程
            int minValue1=Integer.MAX_VALUE;
            int minIndex1=Integer.MAX_VALUE;
            for (int i = 0; i < candidates; i++) {
                if(minValue1>list.get(i)){
                    minValue1=list.get(i);
                    minIndex1=i;
                }
            }
            int minValue2=Integer.MAX_VALUE;
            int minIndex2=Integer.MAX_VALUE;
            for (int i = list.size()-candidates; i < list.size(); i++) {
                if(minValue2>list.get(i)){
                    minValue2=list.get(i);
                    minIndex2=i;
                }
            }
            if(minValue1<=minIndex2){
                sumCost+=list.get(minIndex1);
                list.remove(minIndex1);
            }else {
                sumCost+=list.get(minIndex2);
                list.remove(minIndex2);
            }
        }

        return sumCost;
    }
}
