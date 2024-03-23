# 给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。

# 每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:

# 0 <= j <= nums[i] 
# i + j < n
# 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。

class Solution(object):
    def jump(self, nums):
        end=0
        maxPos=0
        steps=0
        for i in range(len(nums) - 1):
            maxPos = max(maxPos, i + nums[i])
            if i == end:
                end = maxPos
                steps += 1
        return steps

if __name__=="__main__":
    s=Solution()
    args=[10,9,8,7,6,5,4,3,2,1,1,0]


    k = s.jump(args)
    print(k)