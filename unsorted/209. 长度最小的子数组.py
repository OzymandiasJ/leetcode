# 给定一个含有 n 个正整数的数组和一个正整数 target 。

# 找出该数组中满足其总和大于等于 target 的长度最小的 连续子数组
#  [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。

 

# 示例 1：

# 输入：target = 7, nums = [2,3,1,2,4,3]
# 输出：2
# 解释：子数组 [4,3] 是该条件下的长度最小的子数组。

# 滑动窗口
# 如果当前窗口内和小于target，right++，
# 否则left++,right++，
class Solution:
    def minSubArrayLen(self, s: int, nums: list[int]) -> int:
        lens=len(nums)
        left,right=0,1
        sum=nums[right]
        while left<right:
            if right>=lens:
                break
            if sum==s:
                return right-left+1
            elif sum<s:
                right+=1
                sum+=nums[right]
            else:
                sum-=nums[left]
                left+=1
                sum-=nums[right]
                right+=1
            
        return 0


if __name__=="__main__":
    solution=Solution()
    numbers = [2,3,1,2,4,3]
    target = 7
    k = solution.minSubArrayLen(target,numbers)
    print(k)