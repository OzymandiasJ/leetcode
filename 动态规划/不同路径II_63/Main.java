package 动态规划.不同路径II_63;

import java.util.Scanner;

public class Main {
    /**
     * 这里写程序描述
     */
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.uniquePathsWithObstacles(new int [][]{{0,0,0},{0,1,0},{0,0,0}}));
    }
}
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows=obstacleGrid.length;
        int cols=obstacleGrid[0].length;
        //别堵住起点和终点
        if(obstacleGrid[0][0]==1||obstacleGrid[rows-1][cols-1]==1)
            return 0;
        if(rows==1||cols==1){
            //单行列的，存在1就返回0
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if(obstacleGrid[i][j]==1)
                        return 0;
                }
            }
            //否则返回1
            return 1;
        }

        int [][]dp=new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            dp[i][0]=1;
        }
        for (int i = 0; i < cols; i++) {
            dp[0][i]=1;
        }
        int x=0;
        int y=0;
        int tag=0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                //考虑障碍物的情况
                if(obstacleGrid[i][j]==1){
                    x=i;
                    y=j;
                    tag=1;
                    break;
                }
            }
            if(tag==1)
                break;
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                //考虑障碍物的情况
                if(obstacleGrid[i][j]==1){
                    continue;
                }
                if(i==y&&j==x+1){//当前在障碍物的紧右边
                    dp[i][j]=dp[i-1][j];
                } else if(i==y+1&&j==x) {//当前在障碍物的紧下边
                    dp[i][j]=dp[i][j-1];
                }else {
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        return dp[rows-1][cols-1];
    }
}