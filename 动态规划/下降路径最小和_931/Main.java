package 动态规划.下降路径最小和_931;

import java.util.Scanner;

public class Main {
    /**
     * 给你一个 n x n 的 方形 整数数组 matrix ，
     * 请你找出并返回通过 matrix 的下降路径的 最小和 。
     *
     * 下降路径 可以从第一行中的任何元素开始，并从每一行中选择一个元素。
     * 在下一行选择的元素和当前行所选元素最多相隔一列
     * （即位于正下方或者沿对角线向左或者向右的第一个元素）。
     * 具体来说，位置 (row, col) 的下一个元素应当是
     * (row + 1, col - 1)、(row + 1, col) 或者 (row + 1, col + 1) 。
     *
     */
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.minFallingPathSum(new int[][]{{2,1,3},{6,5,4},{7,8,9}}));
    }
}
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        if(matrix.length==1)
            return matrix[0][0];
        int n=matrix.length;
        int[][]dp=new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[0][i]=matrix[0][i];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(j==0){
                    dp[i][j]=Math.min(dp[i-1][j],dp[i-1][j+1])+matrix[i][j];
                }else if(j==n-1){
                    dp[i][j]=Math.min(dp[i-1][j],dp[i-1][j-1])+matrix[i][j];
                }else {
                    dp[i][j]=Math.min(dp[i-1][j],Math.min(dp[i-1][j-1],dp[i-1][j+1]))+matrix[i][j];
                }
            }
        }

        int res=Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            res=Math.min(dp[n-1][i],res);
        }
        return res;
    }
}