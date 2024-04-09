import sys

# 众所周知，“全国大学生英语四级考试”（以下简称CET-4）的满分为 710 分。
# 在经过三次的 CET-4 考试后，小美终于如愿通过了四级。

# 已知 CET-4 的总分数由三大项构成，分别是：听力，阅读，写作。
# 现在已知小美的总分为 k，且他的“写作”得分比“听力”高了 x 分，比“阅读”得分低了 y 分，你能求出他的三个大项分别得了多少分吗？


# 输入包含一行三个整数，分别表示题中所述的 k\ (1 \leq k \leq 710), x, y\ (-120 \leq x, y \leq 120)。
# （保证输入合法，即保证算出的答案一定是正整数）

# 输出描述
# 输出包含三个非负整数 a, b, c，分别表示小美“听力”，“阅读”，“写作”三大项分别的得分。

k,x,y=map(int,input().split())

# a：写作
# b：听力
# c：阅读

# k=(a+b+c)
# x=a-b
# y=c-a

# x+y=c-b
# k+y=2c+b


c=int((2*y+k+x)/3)
b=int(c-x-y)
a=int(k-b-c)
print(f"{b} {c} {a}")

