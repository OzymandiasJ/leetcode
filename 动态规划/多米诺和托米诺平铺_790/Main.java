package 动态规划.多米诺和托米诺平铺_790;

public class Main {
    /**
     * 有两种形状的瓷砖：一种是 2 x 1 的多米诺形，另一种是形如 "L" 的托米诺形。两种形状都可以旋转。
     *
     * 给定整数 n ，返回可以平铺 2 x n 的面板的方法的数量。返回对 10^9 + 7 取模 的值。
     * 平铺指的是每个正方形都必须有瓷砖覆盖。两个平铺不同，
     * 当且仅当面板上有四个方向上的相邻单元中的两个，使得恰好有一个平铺有一个瓷砖占据两个正方形。
     * @param args
     */
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.numTilings(5));
    }
}
class Solution {
    /**
     * 定义 f[i] 表示平铺 2×i面板的方案数，那么答案为 f[n]
     * 尝试计算 f的前几项，并从中找到规律，得到 f[n]的递推式
     * @param n
     * @return
     */
    public int numTilings(int n) {//遍历两种形状瓷砖
        if(n==1)
            return 1;
        else if (n==2) {
            return 2;
        }
        long[]dp=new long[n+1];//dp存储
        dp[0]=1;
        dp[1]=1;
        dp[2]=2;
        final long MOD = (long) 1e9 + 7;
        for (int i = 3; i <= n; i++) {//遍历两点瓷砖

            dp[i]=(dp[i-1]*2+dp[i-3])%MOD;
        }
        return (int)dp[n];
    }
}