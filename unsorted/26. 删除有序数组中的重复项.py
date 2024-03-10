# 给你一个 非严格递增排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。然后返回 nums 中唯一元素的个数。

# 考虑 nums 的唯一元素的数量为 k ，你需要做以下事情确保你的题解可以被通过：

# 更改数组 nums ，使 nums 的前 k 个元素包含唯一元素，并按照它们最初在 nums 中出现的顺序排列。nums 的其余元素与 nums 的大小不重要。
# 返回 k 。


class Solution:
    def removeDuplicates(self,nums: list[int]) -> int:
        if len(nums)==1:
            return 1
        
        index=0
        while index<len(nums):
            while nums[index] in nums[index+1:]:
                nums.remove(nums[index])
            index+=1
        return len(nums)

if __name__=="__main__":
    s=Solution()
    nums = [1,1]
    k = s.removeDuplicates(nums)
    assert k==1
