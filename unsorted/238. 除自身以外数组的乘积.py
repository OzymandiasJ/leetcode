# 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。

# 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。

# 请 不要使用除法，且在 O(n) 时间复杂度内完成此题。

 

# 示例 1:

# 输入: nums = [1,2,3,4]
# 输出: [24,12,8,6]
# 示例 2:

# 输入: nums = [-1,1,0,-3,3]
# 输出: [0,0,9,0,0]


# 利用索引左侧所有数字的乘积和右侧所有数字的乘积（即前缀与后缀）相乘得到答案。
class Solution:
    def productExceptSelf(self, nums: list[int]) -> list[int]:
        currIndex=0
        n=len(nums)
        left=[1]*n
        right=[1]*n
        result=[1]*n
        # 首先，计算 left 数组，left[i]表示索引 i 左侧所有元素的乘积
        for i in range(1,n):
            left[i]=left[i-1]*nums[i-1]
        # 然后，计算 right 数组，right[i]表示索引 i 右侧所有元素的乘积
        for i in range(n-2,-1,-1):
            right[i]=right[i+1]*nums[i+1]
        # 最后，将 left 和 right 数组的元素相乘，即可得到答案
        for i in range(n):
            result[i]=left[i]*right[i]
        return result
if __name__=="__main__":
    solution=Solution()
    nums = [1,2,3,4]
    k = solution.productExceptSelf(nums)
    print(k)
