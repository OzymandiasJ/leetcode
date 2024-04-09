# 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。

# 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。

# 你可以按任意顺序返回答案。


class Solution:
    def twoSum(self, nums: list[int], target: int) -> list[int]:
        num_dict = {}  # 创建一个字典来存储数字及其索引
        for i, num in enumerate(nums):
            complement = target - num  # 计算目标值的补数
            if complement in num_dict:  # 如果补数在字典中，则返回两个索引
                return [num_dict[complement], i]
            num_dict[num] = i  # 将当前数字及其索引添加到字典中
        return []  # 如果没有找到答案，则返回空列表

if __name__=="__main__":
    solution=Solution()
    nums=[2,7,11,15]
    target = 9
    k = solution.twoSum(nums,target)
    print(k)
