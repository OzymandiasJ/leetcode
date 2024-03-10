package 动态规划.第N个泰波那契数_1137;

public class Main {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.tribonacci(4));
    }
}
class Solution {
    public int tribonacci(int n) {
        if(n==0)
            return 0;
        if(n==1)
            return 1;
        if(n==2)
            return 1;
        int[] dp=new int[n+1];//dp[i]表示有多少中方法到第i层
        dp[0]=0;dp[1]=1;dp[2]=1;
        for (int i = 3; i <= n; i++) {
            dp[i]=dp[i-3]+dp[i-2]+dp[i-1];
        }
        return dp[n];
    }
}