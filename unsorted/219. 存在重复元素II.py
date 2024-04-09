# 给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个 不同的索引 i 和 j ，满足 nums[i] == nums[j] 且 abs(i - j) <= k 。如果存在，返回 true ；否则，返回 false 。

 

# 示例 1：

# 输入：nums = [1,2,3,1], k = 3
# 输出：true
# 示例 2：

# 输入：nums = [1,0,1,1], k = 1
# 输出：true
# 示例 3：

# 输入：nums = [1,2,3,1,2,3], k = 2
# 输出：false


# 首先创建一个 dict，然后遍历数组，如果当前元素在 dict 中，判断当前索引和 dict 中的索引差值是否小于等于 k，
# 如果是，返回 True，
# 否则更新 dict 中的索引为当前索引。如果当前元素不在 dict 中，将当前元素和索引存入 dict 中。遍历结束返回 False。
class Solution:
    def containsNearbyDuplicate(self, nums: list[int], k: int) -> bool:
        mydict={}
        for i in range(len(nums)):
            if nums[i] in mydict and i-mydict[nums[i]]<=k:
                return True
            mydict[nums[i]]=i
        return False


if __name__=="__main__":
    solution=Solution()
    numbers = [1,2,3,1,2,3]
    target = 2
    k = solution.containsNearbyDuplicate(numbers,target)
    print(k)