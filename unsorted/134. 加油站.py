# 在一条环路上有 n 个加油站，其中第 i 个加油站有汽油 gas[i] 升。

# 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。

# 给定两个整数数组 gas 和 cost ，如果你可以按顺序绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1 。如果存在解，则 保证 它是 唯一 的。

 

# 示例 1:

# 输入: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
# 输出: 3

class Solution(object):
    def canCompleteCircuit(self, gas, cost):
        remain=0
        index=0
        # 对每一个起点进行遍历
        for gasItem in gas:
            # 从这个起点开始环行
            subgas=gas[index:]+gas[:index]
            subcost=cost[index:]+cost[:index]
            for i in range(len(subgas)+1):
                if i==len(subgas):
                    return index
                remain+=subgas[i]#加油
                # 行驶
                remain-=subcost[i]#花费
                if remain<0:
                    remain=0
                    break
            index+=1
        return -1
            

if __name__=="__main__":
    s=Solution()
    gas = [2,3,4]
    cost = [3,4,3]
    k = s.canCompleteCircuit(gas,cost)
    print(k)