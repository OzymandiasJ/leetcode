# 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。

# 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。

 

# 示例 1：

# 输入：nums = [100,4,200,1,3,2]
# 输出：4
# 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
# 示例 2：

# 输入：nums = [0,3,7,2,5,8,4,6,0,1]
# 输出：9

# 思路：先从小到大排序，从前往后遍历，如果前当前元素必前一个元素大 1，那么当前长度加 1，否则更新最大长度，当前长度置 1。

class Solution:
    def longestConsecutive(self, nums: list[int]) -> int:
        if len(nums)<=1:
            return len(nums)
        sorted_nums=sorted(nums)
        maxLen=1
        currentLen=1
        for i in range(1,len(sorted_nums)):
            if sorted_nums[i]==sorted_nums[i-1]+1:
                currentLen+=1
            elif sorted_nums[i]==sorted_nums[i-1]:
                continue
            else:
                maxLen=max(maxLen,currentLen)
                currentLen=1
        return max(maxLen,currentLen)

if __name__=="__main__":
    solution=Solution()
    numbers = [1,2,0,1]
    k = solution.longestConsecutive(numbers)
    print(k)