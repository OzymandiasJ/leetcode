package 动态规划.零钱兑换_322;

import java.util.Arrays;

public class Main {
    /**
     * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
     *
     * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
     *
     * 你可以认为每种硬币的数量是无限的。
     */
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.coinChange(new int[]{2}, 3));
    }
}
class Solution1 {//暴力递归
    public int coinChange(int[] coins, int amount) {
        if(amount<0)
            return -1;
        if(amount==0)
            return 0;
        int res=Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int subres=coinChange(coins,amount-coins[i]);
            if(subres==-1)
                continue;
            res=Math.min(subres+1,res);
        }
        return res==Integer.MAX_VALUE?-1:res;
    }
}
class Solution2 {//自顶向下dp
    int[] memo;

    public int coinChange(int[] coins, int amount) {
        memo=new int[amount+1];
        Arrays.fill(memo,-666);
        return dp(coins,amount);
    }
    public  int dp(int[] coins, int amount){
        if(amount==0)
            return 0;
        if(amount<0)
            return -1;

        //如果已经计算过，无需计算直接返回即可
        if(memo[amount]!=-666)
            return memo[amount];
        int res=Integer.MAX_VALUE;

        for (int i = 0; i < coins.length; i++) {
            int subres=dp(coins,amount-coins[i]);
            if(subres==-1)
                continue;
            res=Math.min(res,subres+1);
        }
        memo[amount]=(res==Integer.MAX_VALUE)?-1:res;
        return memo[amount];
    }
}
class Solution {//自底向上dp

    public int coinChange(int[] coins, int amount) {
        int dp[]=new int[amount+1];
        Arrays.fill(dp,amount+1);

        //需要凑0元需要0枚硬币
        dp[0]=0;
        //外层循环遍历所有状态取值
        for (int currMoney = 0; currMoney < amount+1; currMoney++) {
            //内存循环求所有选择的最小值
            for (int j = 0; j < coins.length; j++) {
                if(currMoney-coins[j]<0)
                    continue;
                //状态转移方程
                dp[currMoney]=Math.min(dp[currMoney],1+dp[currMoney-coins[j]]);
            }
        }
        return (dp[amount]==amount+1)?-1:dp[amount];
    }
}
