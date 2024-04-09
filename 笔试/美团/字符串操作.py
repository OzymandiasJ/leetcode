# 小美有两个长度相等的字符串，第一个字符串为 s ，第二个字符串为 t 。

# 小美每次可以选择一个字符串的一个前缀，然后选择一个字母 c ，将选择的前缀的所有字母都变成 c 。

# 小美想知道她最少要操作几次可以使得 s 和 t 相等。

# 输入描述
# 第一行输入一个长度不超过 10^5 的字符串 s 。

# 第二行输入一个长度与 s 相等的字符串 t 。

# 输出描述
# 第一行输出一个整数 m 表示答案。

# 接下来 m 行，每行输出用空格隔开的 i,j,c 表示选择第 i 个字符串的长度为 j 的前缀，将前缀所有字母变成 c 。

# 示例 1
# 收起 

# 输入
# 复制
# aabc
# abcc
# 输出
# 复制
# 2
# 2 3 b
# 2 2 a
def solve(s,t):
    """
    求多少次操作可以使得两个字符串相同
    """
    n=len(s)
    cnt=0
    res=[]
    for i in range(n):
        if s[i]!=t[i]:
            j=i
            while j<n and s[j]==s[i]:
                j+=1
            if j<n:
                cnt+=1
                res.append((i+1,j-i,s[j]))
                s=s[:i]+s[i]*j+s[j:]
            else:
                cnt+=1
                res.append((i+1,n-i,t[i]))
                s=s[:i]+t[i]*n
    return cnt,res


s=input()
t=input()
cnt,res=solve(s,t)
print(cnt)
for i,j,c in res:
    print(i,j,c)