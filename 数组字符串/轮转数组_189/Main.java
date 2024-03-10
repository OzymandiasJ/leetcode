package 数组字符串.轮转数组_189;

import java.util.ArrayList;

public class Main {
    /**
     * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
     * @param args
     */
    public static void main(String[] args) {
        Solution solution=new Solution();
        int[] nums=new int[]{2,3,4};
        solution.rotate(nums,5);
        for (int num:nums
             ) {
            System.out.println(num);
        }
    }
}
class Solution {
    public void rotate(int[] nums, int k) {
        ArrayList<Integer> list=new ArrayList<>();
        if(nums.length<k){
            k=k% nums.length;
        }
        for (int i = nums.length-k; i < nums.length; i++) {
            list.add(nums[i]);
        }
        for (int i = nums.length-k-1; i >=0; i--) {
            nums[i+k]=nums[i];
        }
        for (int i = 0; i < k; i++) {
            nums[i]=list.get(i);
        }
    }
}