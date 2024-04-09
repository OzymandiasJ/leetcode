import sys

# 某横版游戏的设定是这样的，小⻦从场景左下角起⻜，终点为场景右上⻆。现把游戏场景分为了n*m个小块，即小⻦从1,1块的左下⻆起⻜，目标为n,m块的右上⻆，假设每个块的大小都为1*1，对于正常的块，小⻦只可以向右或者向上⻜，所需要的时间均为1，但是某些特殊的块，小⻦可以直接从中间斜向穿越，同样只需要耗费时间1。现给出场景大小以及特殊块的坐标，求最快可以用多少时间通关。


# 输入描述
# 第一行输入为n, m(0<n,m<100000)，第二行为k(0<k<10000)表示有k个特殊的块。接下来的k行为两个数x，y表示特殊块的位置。

# 输出描述
# 输出最快通关的时间。

# 示例 1
# 收起 

# 输入
# 复制
# 3 2
# 3
# 1 1
# 3 2
# 1 2
# 输出
# 复制
# 3


def solve(matrix,sp,n,m,k):
    # 如果不存在特殊快，需要的时间：
    timeConsumed=n+m
    if k==0:
        return timeConsumed
    # 如果存在特殊块
    sp.sort(key=lambda x:(x[0],x[1]))
    currX=0
    currY=0
    valid_sp=0
    # 找 xy 都是最小的特殊块
    # 存储 x 坐标列表
    x_list=[]
    # 存储 y 坐标列表
    y_list=[]
    for i in range(k):
        x_list.append(sp[i][0])
        y_list.append(sp[i][1])
    
        
        
        
    return timeConsumed

    
# # 使用 dp
# def solve(grid,n,m,k):
#     dp=[[999999.0 for _ in range(m)] for _ in range(n)]
#     dp[0][0]=0
    
#     for i in range(n):
#         for j in range(m):
#             # 如果是特殊方块可以斜着走
#             if grid[i][j]==1:
#                 if i-1>=0 and j-1>=0:
#                     dp[i][j]=min(dp[i][j],dp[i-1][j-1]+1)
#             if j+1<m:
#                 dp[i][j]=min(dp[i][j],dp[i][j+1]+1)
#             if i+1<n:
#                 dp[i][j]=min(dp[i][j],dp[i+1][j]+1)
#     return dp[n-1][m-1]


n,m=map(int,input().split())
k=int(input())
# 构造 n*m 的矩阵，特殊块标记为 1
matrix=[[0]*m for _ in range(n)]
sp=[]
for i in range(k):
    x,y=map(int,input().split())
    sp.append(x,y)
    matrix[x-1][y-1]=1


res=solve(matrix,sp,n,m,k)
print(res)
