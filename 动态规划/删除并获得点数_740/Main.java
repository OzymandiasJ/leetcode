package 动态规划.删除并获得点数_740;

import java.util.Scanner;

public class Main {
    /**
     * 这里写程序描述
     */
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.deleteAndEarn(new int[]{2,2,3,3,3,4}));
    }
}
class Solution {
    public int deleteAndEarn(int[] nums) {
        int maxVal = 0;
        for (int val : nums) {
            maxVal = Math.max(maxVal, val);
        }
        int[] sum = new int[maxVal + 1];
        for (int val : nums) {
            sum[val] += val;
        }
        return rob(sum);
    }

//    public int rob(int[] nums) {
//        int size = nums.length;
//        int first = nums[0], second = Math.max(nums[0], nums[1]);
//        for (int i = 2; i < size; i++) {
//            int temp = second;
//            second = Math.max(first + nums[i], second);
//            first = temp;
//        }
//        return second;
//    }
public int rob(int[] nums) {
    if(nums.length==0)
        return 0;
    if(nums.length==1)
        return nums[0];
    int [] dp=new int[nums.length];
    dp[0]=nums[0];
    dp[1]=Math.max(nums[1],dp[0]);
    for (int i = 2; i < nums.length; i++) {
        dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
    }
    return dp[nums.length-1];
}
}
