# 给你一个 无重叠的 ，按照区间起始端点排序的区间列表 intervals，其中 intervals[i] = [starti, endi] 表示第 i 个区间的开始和结束，并且 intervals 按照 starti 升序排列。同样给定一个区间 newInterval = [start, end] 表示另一个区间的开始和结束。

# 在 intervals 中插入区间 newInterval，使得 intervals 依然按照 starti 升序排列，且区间之间不重叠（如果有必要的话，可以合并区间）。

# 返回插入之后的 intervals。

# 注意 你不需要原地修改 intervals。你可以创建一个新数组然后返回它。

# 示例 1：

# 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
# 输出：[[1,5],[6,9]]


class Solution:
    def merge(self, intervals: list[list[int]],newInterval: list[int]) -> list[list[int]]:
        pass


if __name__=="__main__":
    solution=Solution()
    nums = [[1,3],[2,6],[8,10],[15,18]]
    newInterval = [2,5]
    k = solution.insert(nums,newInterval)
    print(k)