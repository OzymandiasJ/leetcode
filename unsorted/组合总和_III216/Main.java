package umsorted.组合总和_III216;

import java.util.ArrayList;
import java.util.List;

public class Main {
    /**
     * 这里写程序描述
     */
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.combinationSum3(3,9));
    }
}
class Solution {
    int k,n;
    List<List<Integer>> list=new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        this.k=k;
        this.n=n;
        List<Integer> combination=new ArrayList<>();
        backtrace(combination,0,1);
        return list;
    }
    public void backtrace(List<Integer> combination,int sum,int index){

        if(index-1==k){
            if (sum==n){
                List<Integer> tmp=new ArrayList<>(combination);
                list.add(tmp);
            }
        }else {
            int begin=1;
            if(combination.size()!=0){
                begin=combination.get(combination.size()-1);
            }
            for (int i =begin ; i <= 9; i++) {
                if(!combination.contains(i)){
                    sum+=i;
                    combination.add(i);
                    backtrace(combination,sum,index+1);
                    sum-=i;
                    combination.remove(index-1);
                }
            }
        }
    }
}
