# 给定一个  无重复元素 的 有序 整数数组 nums 。

# 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表 。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。

# 列表中的每个区间范围 [a,b] 应该按如下格式输出：

# "a->b" ，如果 a != b
# "a" ，如果 a == b
 

# 示例 1：

# 输入：nums = [0,1,2,4,5,7]
# 输出：["0->2","4->5","7"]
# 解释：区间范围是：
# [0,2] --> "0->2"
# [4,5] --> "4->5"
# [7,7] --> "7"


# 先对数组排序,拍完徐后，从前往后遍历，
# 如果当前元素和下一个元素差值大于 1，那么将当前元素加入结果集，否则更新当前元素为起始元素，继续遍历。
class Solution:
    def summaryRanges(self, nums: list[int]) -> list[str]:
        if len(nums)==0:
            return []
        sorted_nums=sorted(nums)
        # 结果集
        result=[]
        # 当前集
        current=[]
        for i in range(len(sorted_nums)):
            if len(current)==0 or sorted_nums[i]-current[-1]==1:
                current.append(sorted_nums[i])
            else:
                # 否则更新当前元素为起始元素，继续遍历。
                result.append(current.copy())
                current.clear()
                current.append(sorted_nums[i])
        result_str=[]
        result.append(current)
        for itemList in result:
            if len(itemList)>1:
                itemList=[str(itemList[0])+"->"+str(itemList[-1])]
                result_str.append(itemList[0])
            else:
                itemList=[str(itemList[0])]
                result_str.append(itemList[0])
        return result_str
        
if __name__=="__main__":
    solution=Solution()
    numbers = [1]
    k = solution.summaryRanges(numbers)
    print(k)