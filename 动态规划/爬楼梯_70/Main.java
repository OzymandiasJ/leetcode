package 动态规划.爬楼梯_70;

public class Main {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.climbStairs(2));
    }
}
class Solution {
    public int climbStairs(int n) {
        int[] dp=new int[n+1];//dp[i]表示有多少中方法到第i层
        dp[0]=1;dp[1]=1;
        for (int i = 2; i <= n; i++) {
            dp[i]=dp[i-2]+dp[i-1];
        }
        return dp[n];
    }
}