import sys

# 游戏中，有时我们需要通过地理位置找出用户与用户之间关联关系。我们记两个用户的关联关系可以表示为：
# (1). user1、user2的地理位置分别为(x1, y1)、(x2, y2)，当这两个用户的欧氏距离（二维空间中即直线距离）不超过d时，我们就认为两个用户关联。
# (2). 用户关联性具有传递性，若用户1与用户2关联，用户2与用户3关联，那么用户1，2，3均关联。

# 给定N个用户及其地理位置坐标，将用户按照关联性进行划分，要求返回若干行，行内每个元素是属于同一个范围的用户群。



# 输入描述
# 第一行给出设定的欧氏距离d
# 第二行给出用户数N （最大不超过600）
# 之后的N行表示第0个用户到第N-1个用户的地理位置的横纵坐标，用空格隔开
# 距离d和坐标值范围在 1~10000 之间，小数最多两位

# 输出描述
# 输出若干行，每行为一个用户群，行内用户按编号从小到大排序（以空格分隔），行之间要按照第一个用户的编号从小到大排序

# 示例 1
# 收起 

# 输入
# 复制
# 2.0
# 5
# 3.0 5.0
# 6.0 13.0
# 2.0 6.0
# 7.0 12.0
# 0.0 2.0
# 输出
# 复制
# 0 2
# 1 3
# 4


def dfs(i,graph,visted,component):
    visted.add(i)
    component.append(i)
    for j in graph[i]:
        if j not in visted:
            dfs(j,graph,visted,component)
    return

def distance(x1,y1,x2,y2):
    return ((x1-x2)**2+(y1-y2)**2)**0.5
def solve(d,n,coordinates):
    graph={}
    for i in range(n):
        graph[i]=set()
    for i in range(n):
        for j in range(i+1,n):
            if distance(coordinates[i][0],coordinates[i][1],coordinates[j][0],coordinates[j][1])<=d:
                graph[i].add(j)
                graph[j].add(i)
    components=[]
    visted=set()
    for i in range(n):
        if i not in visted:
            component=[]
            dfs(i,graph,visted,component)
            components.append(component)
    return components

d=float(input())
userNum=int(input())
userLocations=[]
for i in range(userNum):
    xy=list(map(float,input().split()))
    userLocations.append(xy)
res=solve(d,userNum,userLocations)
# 输出
for items in res:
    print(" ".join([str(i) for i in sorted(items)]))
