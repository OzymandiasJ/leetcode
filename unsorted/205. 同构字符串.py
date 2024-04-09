# 给定两个字符串 s 和 t ，判断它们是否是同构的。

# 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。

# 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。

 

# 示例 1:

# 输入：s = "egg", t = "add"
# 输出：true
# 示例 2：

# 输入：s = "foo", t = "bar"
# 输出：false
# 示例 3：

# 输入：s = "paper", t = "title"
# 输出：true

class Solution:
    def isIsomorphic(self, s: str, t: str) -> bool:
        # 首先，长臂不一样必定不是同构
        if len(s)!=len(t):
            return False
        # 构建字典存储映射关系
        dic={}
        for i in range(len(s)):
            if s[i] not in dic:
                # 还要判断当前这个 value 是否存在
                if t[i] in dic.values():
                    return False
                dic[s[i]]=t[i]
            else:
                if dic[s[i]]!=t[i]:
                    return False
                else :
                    continue
        return True
if __name__=="__main__":
    solution=Solution()
    s = "pacer"
    t = "title"
    k = solution.isIsomorphic(s,t)
    print(k)