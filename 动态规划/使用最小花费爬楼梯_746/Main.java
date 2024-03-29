package 动态规划.使用最小花费爬楼梯_746;



import java.util.Scanner;

public class Main {
    /**
     * 给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。一旦你支付此费用，即可选择向上爬一个或者两个台阶。
     *
     * 你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。
     *
     * 请你计算并返回达到楼梯顶部的最低花费。
     */
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.minCostClimbingStairs(new int[]{10,15,20}));
    }
}
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int [] dp=new int[cost.length+1];//dp[i]表示到达楼梯i时的已经花费的钱
        for (int i = 2; i <= cost.length; i++) {
            dp[i]=Math.min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2]);
        }
        return dp[cost.length];
    }
}