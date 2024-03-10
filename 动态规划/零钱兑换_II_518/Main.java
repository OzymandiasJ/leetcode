package 动态规划.零钱兑换_II_518;

public class Main {
    /**
     * 给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
     *
     * 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
     * TODO:计算组合数
     * 假设每一种面额的硬币有无限个。
     *
     * 题目数据保证结果符合 32 位带符号整数。
     * @param args
     */
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.change(5,new int[]{1,2,5}));
    }
}
class Solution {
    public int change(int amount, int[] coins) {

        return solve(amount,coins);
    }
    public int solve(int amount, int[] coins){
        int[] dp=new int[amount+1];
        for (int i = 0; i <= amount; i++) {
            dp[i]=amount+1;
        }
        dp[0]=0;
        //遍历所有的金额
        for (int currMoney = 0; currMoney <= amount; currMoney++) {
            //遍历所有的面值，找到需要的最小的硬币数
            for (int j = 0; j < coins.length; j++) {
                if(currMoney-coins[j]<0)
                    continue;
                else {
                    //如果金额减去面值合法，那么凑够当前金额所需
                    dp[currMoney]=Math.min(dp[currMoney],1+dp[currMoney-coins[j]]);
                }
            }
        }
        return dp[amount]==amount+1?-1:dp[amount];
    }
}