# 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。

# 如果可以，返回 true ；否则返回 false 。

# magazine 中的每个字符只能在 ransomNote 中使用一次。

# 示例 1：

# 输入：ransomNote = "a", magazine = "b"
# 输出：false
# 示例 2：

# 输入：ransomNote = "aa", magazine = "ab"
# 输出：false
# 示例 3：

# 输入：ransomNote = "aa", magazine = "aab"
# 输出：true

class Solution:
    def canConstruct(self, ransomNote: str, magazine: str) -> bool:
        charCount={}
        for item in magazine:
            if item in charCount:
                charCount[item]+=1
            else:
                charCount[item]=1
        # 接着，对ransomNote中的每个字符进行遍历，如果在charCount中找到了，就将对应的值减1，如果没有找到，就返回False
        for item in ransomNote:
            if item in charCount:
                charCount[item]-=1
                if charCount[item]<0:
                    return False
            else:
                return False
        return True
if __name__=="__main__":
    solution=Solution()
    s = "aa"
    t = "aab"
    k = solution.canConstruct(s,t)
    print(k)