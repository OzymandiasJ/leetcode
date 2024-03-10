# 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。

# 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish”）。

# 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？

# 网格中的障碍物和空位置分别用 1 和 0 来表示。


class Solution:
    def uniquePathsWithObstacles(self, obstacleGrid: list[list[int]]) -> int:
        dp=[[0 for i in range(len(obstacleGrid[0]))]for j in range(len(obstacleGrid))]
        dp[0][0]=0 
        for i in range(1,len(obstacleGrid)):
            for j in range(1,len(obstacleGrid[0])):
                if obstacleGrid[i-1][j]==1:
                    dp[i][j]=dp[i][j-1]
                if obstacleGrid[i][j-1]==1:
                    dp[i][j]=dp[i-1][j]
                if obstacleGrid[i-1][j]==0 and obstacleGrid[i][j-1]==0:
                    dp[i][j]=dp[i-1][j]+dp[i][j-1]
        return dp[-1][-1]
if __name__=="__main__":
    s=Solution()
    k = s.uniquePathsWithObstacles([[0,0,0],[0,1,0],[0,0,0]])
    print(k)