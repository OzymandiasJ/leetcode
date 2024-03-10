package 动态规划.最小路径和_64;

import java.util.Scanner;

public class Main {
    /**
     * 这里写程序描述
     */
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.minPathSum(new int [][]{{1,3,1},{1,5,1},{4,2,1}}));
    }
}
class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int[][] dp=new int[grid.length][grid[0].length];//dp[i][j]存储到达ij时的sum
        dp[0][0]=grid[0][0];
        for (int i = 1; i < grid.length; i++) {
            dp[i][0]=grid[i][0]+dp[i-1][0];
        }
        for (int i = 1; i < grid[0].length; i++) {
            dp[0][i]=grid[0][i]+dp[0][i-1];
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                dp[i][j]=Math.min(dp[i-1][j]+grid[i][j],dp[i][j-1]+grid[i][j]);
            }
        }
        return dp[grid.length-1][grid[0].length-1];
    }
}