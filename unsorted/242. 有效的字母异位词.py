# 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。

# TODO 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。

 

# 示例 1:

# 输入: s = "anagram", t = "nagaram"
# 输出: true
# 示例 2:

# 输入: s = "rat", t = "car"
# 输出: false



class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s)!=len(t):
            return False
        dict={}
        for i in s:
            if i in dict:
                dict[i]+=1
            else:
                dict[i]=1
        # 然后需要判断t中的每个字符是否在dict中，如果在，就将对应的值减1，如果不在，就返回False
        for i in t:
            if i in dict:
                dict[i]-=1
                if dict[i]<0:
                    return False
            else:
                return False
        return True
if __name__=="__main__":
    solution=Solution()
    s = "ab"
    t = "a"
    k = solution.isAnagram(s,t)
    print(k)