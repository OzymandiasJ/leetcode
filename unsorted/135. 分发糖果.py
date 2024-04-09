# n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。

# 你需要按照以下要求，给这些孩子分发糖果：

# 每个孩子至少分配到 1 个糖果。
# 相邻两个孩子评分更高的孩子会获得更多的糖果。
# 请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。

 

# 示例 1：

# 输入：ratings = [1,0,2]
# 输出：5
# 解释：你可以分别给第一个、第二个、第三个孩子分发 2、1、2 颗糖果。
# 示例 2：

# 输入：ratings = [1,2,2]
# 输出：4
# 解释：你可以分别给第一个、第二个、第三个孩子分发 1、2、1 颗糖果。
#      第三个孩子只得到 1 颗糖果，这满足题面中的两个条件。



# 初始化糖果数组：创建一个长度为 n 的数组 candies，其中 n 是孩子数量。每个元素最初都设置为 1，表示每个孩子至少获得一颗糖果。

# 第一次遍历（从左到右）：

# 使用 for 循环遍历数组，从索引 1 开始（因为我们不比较第一个孩子）。
# 如果当前孩子的评分高于前一个孩子的评分，则将当前孩子的糖果数量设置为前一个孩子的糖果数量加 1。
# 第二次遍历（从右到左）：

# 使用 for 循环遍历数组，从倒数第二个孩子开始（因为我们不比较最后一个孩子）。
# 如果当前孩子的评分高于后一个孩子的评分，则将当前孩子的糖果数量设置为当前孩子的糖果数量和后一个孩子的糖果数量加 1 中的较大值。
# 计算糖果总数：

# 使用 sum() 函数计算 candies 数组中所有元素的总和。这给了我们需要准备的最少糖果数目。
# 返回结果：

# 返回计算出的糖果总数。
class Solution:
    def candy(self, ratings: list[int]) -> int:
        n = len(ratings)
        candies = [1] * n

        # 从左到右遍历
        for i in range(1, n):
            if ratings[i] > ratings[i - 1]:
                candies[i] = candies[i - 1] + 1

        # 从右到左遍历
        for i in range(n - 2, -1, -1):
            if ratings[i] > ratings[i + 1]:
                candies[i] = max(candies[i], candies[i + 1] + 1)

        return sum(candies)





if __name__=="__main__":
    solution=Solution()
    
    arg=[1,0,2]
    k = solution.candy(arg)
    print(k)