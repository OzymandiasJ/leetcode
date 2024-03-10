package umsorted.三数之和_LCR007;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    /**
     * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a ，b ，c ，
     * 使得 a + b + c = 0 ？请找出所有和为 0 且 不重复 的三元组。
     *
     * 回溯法
     *
     * @param args
     */
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.threeSum(new int[]{-1,0,1,2,-1,-4}));
    }
}
class Solution {

    int SUMCOUNT=3;
    int Target=0;
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        if(nums.length<3)
            return lists;
        backTrace(lists,list,nums,0);
        return lists;
    }
    public void backTrace(List<List<Integer>> lists,List<Integer> list,int[] nums,int index){
        if(list.size()==3){
            int sum=0;
            for(int num:list){
                sum+=num;
            }
            if(sum==Target){
                //看下当前集合中是否存在一样的list，注意[-1,0,1]和[0,1,-1]是一样的
                Integer[] currNums=list.toArray(new Integer[list.size()]);
                Arrays.sort(currNums);
                boolean tag=true;
                for (List<Integer> sublist:lists) {
                    Integer[] subNums=sublist.toArray(new Integer[list.size()]);
                    Arrays.sort(subNums);
                    if(Arrays.equals(currNums,subNums)){
                        tag=false;
                        break;
                    }
                }
                if(tag==true){
                    lists.add(new ArrayList<>(list));
                }
            }
        }else {
            //对于剩下的每个数字都试一遍
            for (int i = index; i < nums.length; i++) {
                list.add(nums[i]);
                backTrace(lists,list,nums,i+1);
                list.remove(list.size()-1);
            }
        }
    }
}