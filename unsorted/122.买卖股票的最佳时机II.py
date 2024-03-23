# 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。

# 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。

# 返回 你能获得的 最大 利润 。

# for indivadual marking day,set today price=p1,tomorrow price=p2,so the profit is p2-p1 that buying today and sell tomorrow
# for consistant rising day set the price of those days as p1,p2,p3,p4...pn,profit is pn-p1=(pn-pn-1)+...+p4-p3+p3-p2+p2-p1
# For continuous declining trading days: then there is no profit or loss, meaning no money is lost.

# 贪心策略：遍历整个股票交易日价格列表 price，并执行贪心策略：所有上涨交易日都买卖（赚到所有利润），所有下降交易日都不买卖（永不亏钱）。


class Solution(object):
    def maxProfit(self, prices):
        index=0
        res=0
        while index<len(prices)-1:
            if prices[index+1]>=prices[index]:
                res+=prices[index+1]-prices[index]
            index+=1
        return res
                
            

if __name__=="__main__":
    s=Solution()
    args=[1,2,3,4,5]
    k = s.maxProfit(args)
    print(k)