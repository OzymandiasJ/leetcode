# 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。

# 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

# 返回容器可以储存的最大水量。

# 说明：你不能倾斜容器。


"""
s=minHeight*(j-i)

初始化两个指针 left 和 right，分别指向数组 height 的第一个和最后一个元素。
计算当前容器的面积 area，即 (right - left) * min(height[left], height[right])。
更新 max_area 为 area 和 max_area 中的最大值。
如果 height[left] 小于 height[right]，则将 left 指针向右移动一位。
否则，将 right 指针向左移动一位。
重复步骤 2-5，直到 left 指针大于或等于 right 指针。
返回 max_area。
"""

class Solution:
    def maxArea(self, height: list[int]) -> int:
        left, right = 0, len(height) - 1
        max_area = 0

        while left < right:
            max_area = max(max_area, (right - left) * min(height[left], height[right]))
            if height[left] < height[right]:
                left += 1
            else:
                right -= 1

        return max_area
if __name__=="__main__":
    solution=Solution()
    
    arg=[1,8,6,2,5,4,8,3,7]
    k = solution.maxArea(arg)
    print(k)