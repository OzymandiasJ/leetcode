# 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。

# 说明：每次只能向下或者向右移动一步。

class Solution:
    # dp[i][j]=min(dp[i-1][j]+grid[i-1][j],dp[i][j-1]+grid[i][j-1])
    def minPathSum(self, grid: list[list[int]]) -> int:
        m=len(grid)
        n=len(grid[0])
        dp = [[0] * (n) for _ in range(m)]
        if m==1:
            return sum(grid[0])
        if n==1:
            return sum(item[0] for item in grid)
        
        for i in range(m):
            dp[i][0]=sum(item[0] for item in grid[0:i+1])
        for j in range(n):
            dp[0][j]=sum(grid[0][0:j+1])

        for i in range(1,m):
            for j in range(1,n):
                dp[i][j]=min(dp[i-1][j]+grid[i][j],dp[i][j-1]+grid[i][j])
        return dp[-1][-1]

if __name__=="__main__":
    s=Solution()
    k = s.minPathSum([[1],[1]])
    print(k)