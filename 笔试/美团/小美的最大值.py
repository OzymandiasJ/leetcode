
import sys

# 小美拿到了一个数组。她定义f(i)为：将第i个元素翻倍后，数组的最大值。现在小美希望你求出f(1)到f(n)的值。你能帮帮她吗？

# 输入描述
# 第一行输入一个正整数n，代表数组大小。
# 第二行输入n个正整数a_i，代表小红拿到的数组。
# 1\leq n \leq 200000
# 1\leq a_i \leq 10^9

# 输出描述
# n个正整数，用空格隔开，代表f(1)到f(n)的值。

# 示例 1
# 收起 

# 输入
# 5
# 1 3 2 5 4
# 输出
# 5 6 5 10 8



# length=input()
# nums=list(map(int,input().split()))
# # 将字符串转数字

# # 存储最大值的数组，maxNums[i]表示将第i个元素翻倍后，数组的最大值
# maxNums=[]

# for i in range(int(length)):
#     # 将第i个元素翻倍后，数组的最大值
#     if len(maxNums)==0:
#         maxNum=max(nums[0:1]*2+nums[1:])
#         maxNums.append(maxNum)
#     else:
#         maxNum=max(nums[0:i]+[nums[i]*2]+nums[i+1:])
#         maxNums.append(maxNum)
# res=""
# for item in maxNums:
#     res+=str(item)+" "
# print(res)




# def f(arr,i):
#     """
#     将数组第 i 个元素翻倍后的数组最大值
#     """
#     new_arr=arr.copy()
#     new_arr[i]=new_arr[i]*2
#     return max(new_arr)

# length=int(input())
# nums=list(map(int,input().split()))
# maxVal=0
# maxNums=[f(nums,i) for i in range(length)]
# print(" ".join(map(str,maxNums)))



# 优化，保存当前数组最大值
length=int(input())
nums=list(map(int,input().split()))
maxVal=max(nums)
maxNums=[max(maxVal,nums[i]*2) for i in range(length)]
print(" ".join(map(str,maxNums)))
