# 给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。一旦你支付此费用，即可选择向上爬一个或者两个台阶。

# 你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。

# 请你计算并返回达到楼梯顶部的最低花费。


class Solution:
    # 站在当前节点，爬到cost更小的台阶
    # dp[i]==min(dp[i-1]+cost[i-1],dp[i]+cost[i])
    def minCostClimbingStairs(self, cost: list[int]) -> int:
        dp=[0]*(len(cost)+1)
  
        for i in range(2,len(cost)+1):
            dp[i]=min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2])
        return dp[len(cost)]
if __name__ == "__main__":
    solution=Solution()
    result=solution.minCostClimbingStairs([10,15,20,])
    print(result)